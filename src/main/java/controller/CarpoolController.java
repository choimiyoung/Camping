package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import common.MyConstant;
import dao.CarpoolDao;
import dao.MarketDao;
import dao.VisitDao;
import util.Paging;
import vo.CarpoolVo;
import vo.MarketVo;
import vo.MemberVo;
import vo.VisitVo;

@Controller
public class CarpoolController {
	
	@Autowired
	ServletContext applicaton;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	VisitDao visit_dao;
	
	public void setVisit_dao(VisitDao visit_dao) {
		this.visit_dao = visit_dao;
	}

	CarpoolDao carpool_dao;

	public void setCarpool_dao(CarpoolDao carpool_dao) {
		this.carpool_dao = carpool_dao;
	}
	
	MarketDao market_dao;
	
	public void setMarket_dao(MarketDao market_dao) {
		this.market_dao = market_dao;
	}
	
	
	/*
	 * @RequestMapping("/board/carpool_list.do") public String list(Model model) {
	 * 
	 * List<CarpoolVo> list = carpool_dao.selectList();
	 * 
	 * model.addAttribute("list",list);
	 * 
	 * return "board/carpool_board"; }
	 */


	@RequestMapping("/")
	   public String main(Model model,VisitVo vo) {
	      
	      int m_idx = 0;
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      if(user!=null)m_idx=user.getMem_idx();
	      
	      vo.setVisit_ip(request.getRemoteAddr());
	      vo.setVisit_agent(request.getHeader("User-Agent"));
	      vo.setMem_idx(m_idx);
	      visit_dao.delete(vo);
	      visit_dao.insert(vo);
	      
	      
	     
	      List<CarpoolVo> list = carpool_dao.selectList(m_idx);
	      List<MarketVo> list1 = market_dao.selectList(m_idx);
	    
	      
	      model.addAttribute("list",list);
	      model.addAttribute("list1",list1);
	      
	      return "homepage/main";
	   }


	//��ü��ȸ
	@RequestMapping("/board/carpool_list.do")
	   public String list(@RequestParam(value="page", required = false, defaultValue = "1") int nowPage,
			   			  @RequestParam(value="search", required = false, defaultValue = "carpool_all") String search,         
			   			  @RequestParam(value="search_text", required = false) String search_text,           
			   			  Model model) {
	      
	      int m_idx = 0;
	      
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      int start = (nowPage-1) * MyConstant.Carpool.BLOCK_LIST + 1;
	      int end = start + MyConstant.Carpool.BLOCK_LIST - 1;
	      if(user!=null)m_idx=user.getMem_idx();
	      
	      
	      //���ǿ� ����Ǿ��ִ� Show������ �����Ѵ�.
	      session.removeAttribute("show");
	      
	      Map map = new HashMap();
	      map.put("start", start);
	      map.put("end", end);
	      map.put("m_idx", m_idx);

	      
	      //��ü�˻��� �ƴϸ� �˻������ֱ�
	      if(!search.equals("carpool_all")) {
	         
	         if(search.equals("carpool_title_carpool_content_mem_nickname")) { //����+�̸�+����
	            
	               map.put("carpool_title", search_text);
	               map.put("carpool_content", search_text);
	               map.put("mem_nickname", search_text);
	               
	         } else if(search.equals("carpool_title")) {//����
	            
	            map.put("carpool_title", search_text);
	            
	         } else if(search.equals("carpool_content")) {//����
	            
	            map.put("carpool_content", search_text);
	         
	         } else if(search.equals("mem_nickname")) {//�г���
	      
	            map.put("mem_nickname", search_text);
	         }
	            
	      }
	      
	      //��ü�Խù� �� ���ϱ�
	      int rowTotal = carpool_dao.selectRowTotal(map);
	      
	      String search_filter = String.format("search=%s&search_text=%s", search, search_text);
	      
	      String pageMenu = Paging.getPaging("carpool_list.do",
	                                  search_filter, 
	                                  nowPage, 
	                                  rowTotal, 
	                                  MyConstant.Carpool.BLOCK_LIST, 
	                                  MyConstant.Carpool.BLOCK_PAGE);
	      
	      List<CarpoolVo> list = carpool_dao.selectConditionList(map);
	      
	      model.addAttribute("list",list);
	      model.addAttribute("pageMenu", pageMenu);
	   
	      return "board/carpool_board";
	   }
	
	//���ƿ�
	@RequestMapping("/homepage/carpool.do")
	   public String carpool(Model model) {
	      
	      int m_idx = 0;
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user!=null)m_idx=user.getMem_idx();
	      
	      List<CarpoolVo> list = carpool_dao.selectList(m_idx);
	      
	      model.addAttribute("list",list);
	      
	      return "homepage/carpool_market";
	   }
	   
	   @ResponseBody
	   @RequestMapping(value ="/carpool_insertlike.do", method = RequestMethod.POST)
	   public int carpool_insertlike(CarpoolVo vo) {
	      
	      int res = carpool_dao.carpool_insertlike(vo);
	      
	      return 1;
	   }
	   
	   @ResponseBody
	   @RequestMapping(value ="/carpool_deletelike.do", method = RequestMethod.POST)
	   public int carpool_deletelike(CarpoolVo vo) {
	      
	      int res = carpool_dao.carpool_deletelike(vo);
	      
	      return 1;
	   }
	   
	   //�Խñۺ���
	   @RequestMapping("board/carpool_view.do")
	   public String carpool_view(int carpool_idx,Model model) {
	      
	      //b_idx�� �ش�Ǵ� �Խù� ���� ���´� 
	      CarpoolVo vo = carpool_dao.selectOne(carpool_idx);
	      
	      //�Խù��� �Ⱥ����� ��ȸ�� ����. �Խù� ���� �Ⱥ����� ���ǿ� ���� ���� �־�.
	      if(session.getAttribute("show")==null) {
	         
	         //��ȸ�� ����
	         int res = carpool_dao.update_readhit(carpool_idx);
	         
	         //Show������ ���ǿ� �ִ´�
	         session.setAttribute("show", true);
	         
	      }
	      //��������� request binding
	      model.addAttribute("vo", vo);
	      return "board/carpool_view";
	   }
	
	   //���۾��� ������
		@RequestMapping("/board/carpool_insert_form.do")
		public String carpool_insert_form() {

			return "board/carpool_insert_form";
		}
		
		//���۾���
		@RequestMapping("/board/carpool_insert.do")
		public String insert(CarpoolVo vo,Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/carpool_list.do";
			}
			
			
			String carpool_ip = request.getRemoteAddr();
			vo.setCarpool_ip(carpool_ip);
			
			int res = carpool_dao.insert(vo);
			
			return "redirect:carpool_list.do";
		}
		
		//�Խñۼ�����
		@RequestMapping("/board/carpool_modify_form.do")
		public String modify_form(int carpool_idx,
									  Model model) {

			CarpoolVo  vo = carpool_dao.selectOne(carpool_idx);
			
			model.addAttribute("vo", vo);
			
			return "board/carpool_modify_form";
		}
		
		//�Խñۼ����ϱ�
		@RequestMapping("/board/carpool_modify.do")
		public String modify(CarpoolVo vo,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="carpool_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/carpool_list.do";
			}
			
			
			String carpool_ip = request.getRemoteAddr();
			vo.setCarpool_ip(carpool_ip);
			
			int res = carpool_dao.modify(vo);
			
			model.addAttribute("carpool_idx", vo.getCarpool_idx());
			model.addAttribute("page" , page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:/board/carpool_view.do";
		}
		
		
		
		//�Խñۻ���
		@RequestMapping("/board/carpool_delete.do")
		public String delete(int carpool_idx,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="carpool_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			int res = carpool_dao.delete(carpool_idx);
			
			model.addAttribute("page", page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:carpool_list.do";
		}
	
	
}