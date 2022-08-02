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
import dao.ReviewDao;
import util.Paging1;
import vo.MemberVo;
import vo.ReviewVo;

@Controller
public class ReviewController {

	@Autowired
	ServletContext applicaton;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpSession session;
	
	
	ReviewDao review_dao;

	public void setReview_dao(ReviewDao review_dao) {
		this.review_dao = (ReviewDao) review_dao;
	}


	//��ü��ȸ
	@RequestMapping("/board/review_list.do")
	public String list (@RequestParam(value="page", required = false, defaultValue = "1") int nowPage,
					    @RequestParam(value="search", required = false, defaultValue = "review_all") String search,			
					    @RequestParam(value="search_text", required = false) String search_text,			  
					    Model model) {
		
		int m_idx = 0;
		  
	    MemberVo user = (MemberVo) session.getAttribute("user");
		int start = (nowPage-1) * MyConstant.Review.BLOCK_LIST + 1;
		int end = start + MyConstant.Review.BLOCK_LIST - 1;
		if(user!=null)m_idx=user.getMem_idx();
		
		 //���ǿ� ����Ǿ��ִ� Show������ �����Ѵ�.
	      session.removeAttribute("show");
		
		Map map = new HashMap();
		map.put("start", start);
		map.put("end", end);
		map.put("m_idx", m_idx);
		
		//��ü�˻��� �ƴϸ� �˻������ֱ�
		if(!search.equals("review_all")) {
			
			if(search.equals("review_title_review_content_mem_nickname")) { //����+�̸�+����
				
					map.put("review_title", search_text);
					map.put("review_content", search_text);
					map.put("mem_nickname", search_text);
					
			} else if(search.equals("review_title")) {//����
				
				map.put("review_title", search_text);
				
			} else if(search.equals("review_content")) {//����
				
				map.put("review_content", search_text);
			
			} else if(search.equals("mem_nickname")) {//�г���
		
				map.put("mem_nickname", search_text);
			}
				
		}
		
		//��ü�Խù� �� ���ϱ�
		int rowTotal = review_dao.selectRowTotal(map);
		
		String search_filter = String.format("search=%s&search_text=%s", search, search_text);
		
		String pageMenu = Paging1.getPaging("review_list.do", 
										   search_filter, 
										   nowPage, 
										   rowTotal, 
										   MyConstant.Review.BLOCK_LIST, 
										   MyConstant.Review.BLOCK_PAGE);
		
		
		List<ReviewVo> list = review_dao.selectConditionList(map);
		
		model.addAttribute("list",list);
		model.addAttribute("pageMenu", pageMenu);
		
		return "/board/review_board";
	}

	@RequestMapping("/homepage/review.do")
	   public String review(Model model) {
	      
	      int m_idx = 0;
	      MemberVo user = (MemberVo) session.getAttribute("user");
	      
	      if(user!=null)m_idx=user.getMem_idx();
	      
	      List<ReviewVo> list = review_dao.selectList(m_idx);
	      
	      model.addAttribute("list",list);
	      
	      return "homepage/review_market";
	   }
	   
	   @ResponseBody
	   @RequestMapping(value ="/review_insertlike.do", method = RequestMethod.POST)
	   public int review_insertlike(ReviewVo vo) {

	      int res = review_dao.review_insertlike(vo);
	      
	      return 1;
	   }
	   
	   @ResponseBody
	   @RequestMapping(value ="/review_deletelike.do", method = RequestMethod.POST)
	   public int review_deletelike(ReviewVo vo) {

	      int res = review_dao.review_deletelike(vo);
	      
	      return 1;
	   }
	   
	   @RequestMapping("board/review_view.do")
	   public String review_view(int review_idx,Model model) {
	      
	      //b_idx�� �ش�Ǵ� �Խù� ���� ���´� 
	      ReviewVo vo = review_dao.selectOne(review_idx);
	      
	      //�Խù��� �Ⱥ����� ��ȸ�� ����. �Խù� ���� �Ⱥ����� ���ǿ� ���� ���� �־�.
	      if(session.getAttribute("show")==null) {
	         
	         //��ȸ�� ����
	         int res = review_dao.update_readhit(review_idx);
	         
	         //Show������ ���ǿ� �ִ´�
	         session.setAttribute("show", true);
	         
	      }
	      //��������� request binding
	      model.addAttribute("vo", vo);
	      return "board/review_view";
	   }
	 

	   //���۾��� ������
		@RequestMapping("/board/review_insert_form.do")
		public String review_insert_form() {

			return "board/review_insert_form";
		}
		
		//���۾���
		@RequestMapping("/board/review_insert.do")
		public String insert(ReviewVo vo,Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/review_list.do";
			}
			
			
			String review_ip = request.getRemoteAddr();
			vo.setReview_ip(review_ip);
			
			int res = review_dao.insert(vo);
			
			return "redirect:review_list.do";
		}
		
		//�Խñۼ�����
		@RequestMapping("/board/review_modify_form.do")
		public String modify_form(int review_idx,
									  Model model) {

			ReviewVo vo = review_dao.selectOne(review_idx);
			
			model.addAttribute("vo", vo);
			
			return "board/review_modify_form";
		}
		
		//�Խñۼ����ϱ�
		@RequestMapping("/board/review_modify.do")
		public String modify(ReviewVo vo,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="review_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			if(session.getAttribute("user")==null) {
				
				model.addAttribute("reason", "session_timeout");
				
				return "redirect:../board/review_list.do";
			}
			
			
			String review_ip = request.getRemoteAddr();
			vo.setReview_ip(review_ip);
			
			int res = review_dao.modify(vo);
			
			model.addAttribute("review_idx", vo.getReview_idx());
			model.addAttribute("page" , page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:/board/review_view.do";
		}
		
		
		
		//�Խñۻ���
		@RequestMapping("/board/review_delete.do")
		public String delete(int review_idx,
				             int page,
				             @RequestParam(value="search",required=false,defaultValue="review_all") String search,
					         @RequestParam(value="search_text",required=false) String search_text, 
				             Model model) {
			
			int res = review_dao.delete(review_idx);
			
			model.addAttribute("page", page);
			model.addAttribute("search", search);
			model.addAttribute("search_text", search_text);
			
			return "redirect:review_list.do";
		}
	

	   
	   
}
