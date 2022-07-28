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
import dao.MarketDao;
import util.Paging;
import vo.MarketVo;
import vo.MemberVo;

@Controller
public class MarketController {
	
	@Autowired
	ServletContext applicaton;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	MarketDao market_dao;
	

	public void setMarket_dao(MarketDao market_dao) {
		this.market_dao = market_dao;
	}

	@RequestMapping("/homepage/market.do")
	   public String market(Model model) {
	      
	      int m_idx = 0;
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user!=null)m_idx=user.getMem_idx();
	      
	      List<MarketVo> list1 = market_dao.selectList(m_idx);
	      
	      model.addAttribute("list1",list1);
	      
	      return "homepage/carpool_market";
	   }
	
	//��ü��ȸ
	@RequestMapping("/board/market_list.do")
	public String list (@RequestParam(value="page", required = false, defaultValue = "1") int nowPage,
						@RequestParam(value="search", required = false, defaultValue = "market_all") String search,			
						@RequestParam(value="search_text", required = false) String search_text,			  
						Model model) {

			int m_idx = 0;
		      
		    MemberVo user = (MemberVo) session.getAttribute("user");
			int start = (nowPage-1) * MyConstant.Market.BLOCK_LIST + 1;
			int end = start + MyConstant.Market.BLOCK_LIST - 1;
			
			Map map = new HashMap();
			map.put("start", start);
			map.put("end", end);
			map.put("m_idx", m_idx);
			
			map.put("market_buy_sell", search_text);
			
			//��ü�˻��� �ƴϸ� �˻������ֱ�
			if(!search.equals("market_all")) {
				
				if(search.equals("market_title_market_content_mem_nickname")) { //����+�̸�+����
					
						map.put("market_title", search_text);
						map.put("market_content", search_text);
						map.put("mem_nickname", search_text);
					
						map.put("market_buy_sell", search_text);
						
				} else if(search.equals("market_title")) {//����
					
					map.put("market_title", search_text);
					
				} else if(search.equals("market_content")) {//����
					
					map.put("market_content", search_text);
				
				} else if(search.equals("mem_nickname")) {//�г���
			
					map.put("mem_nickname", search_text);
				}
					
			}
			
			//��ü�Խù� �� ���ϱ�
			int rowTotal = market_dao.selectRowTotal();
			
			String search_filter = String.format("search=%s&search_text=%s", search, search_text);
			
			String pageMenu = Paging.getPaging("market_list.do",
												 search_filter, 
												 nowPage, 
												 rowTotal, 
												 MyConstant.Market.BLOCK_LIST, 
												 MyConstant.Market.BLOCK_PAGE);
			
			
			List<MarketVo> list = market_dao.selectConditionList(map);
			
			model.addAttribute("list",list);
			model.addAttribute("pageMenu", pageMenu);
			
			return "board/market_board";
		}
	
	
	@ResponseBody
    @RequestMapping(value ="/market_insertlike.do", method = RequestMethod.POST)
    public int market_insertlike(MarketVo vo) {
 
       int res = market_dao.market_insertlike(vo);
       
       return 1;
    }
    
    @ResponseBody
    @RequestMapping(value ="/market_deletelike.do", method = RequestMethod.POST)
    public int market_deletelike(MarketVo vo) {
       
       int res = market_dao.market_deletelike(vo);
       
       return 1;
    }
 
    @RequestMapping("board/market_view.do")
    public String market_view(int market_idx,Model model) {
       
       //b_idx�� �ش�Ǵ� �Խù� ���� ���´� 
       MarketVo vo = market_dao.selectOne(market_idx);
       
       //�Խù��� �Ⱥ����� ��ȸ�� ����. �Խù� ���� �Ⱥ����� ���ǿ� ���� ���� �־�.
       if(session.getAttribute("show")==null) {
          
          //��ȸ�� ����
          int res = market_dao.update_readhit(market_idx);
          
          //Show������ ���ǿ� �ִ´�
          session.setAttribute("show", true);
          
       }
       //��������� request binding
       model.addAttribute("vo", vo);
       return "board/market_view";
    }
	
    

	   //���۾��� ������
		@RequestMapping("/board/market_insert_form.do")
		public String market_insert_form() {

			return "board/market_insert_form";
		}
		
		//���۾���
		@RequestMapping("/board/market_insert.do")
		public String insert(MarketVo vo,Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/market_list.do";
			}
			
			
			String market_ip = request.getRemoteAddr();
			vo.setMarket_ip(market_ip);
			
			int res = market_dao.insert(vo);
			
			return "redirect:market_list.do";
		}
		
		//�Խñۼ�����
		@RequestMapping("/board/market_modify_form.do")
		public String modify_form(int market_idx,
									  Model model) {

			MarketVo vo = market_dao.selectOne(market_idx);
			
			model.addAttribute("vo", vo);
			
			return "board/market_modify_form";
		}
		
		//�Խñۼ����ϱ�
		@RequestMapping("/board/market_modify.do")
		public String modify(MarketVo vo,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="market_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/market_list.do";
			}
			
			String market_ip = request.getRemoteAddr();
			vo.setMarket_ip(market_ip);
			
			int res = market_dao.modify(vo);
			
			model.addAttribute("market_idx", vo.getMarket_idx());
			model.addAttribute("page" , page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:/board/market_view.do";
		}
		
		
		
		//�Խñۻ���
		@RequestMapping("/board/market_delete.do")
		public String delete(int market_idx,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="market_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			int res = market_dao.delete(market_idx);
			
			model.addAttribute("page", page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:market_list.do";
		}
	

	   
	
}