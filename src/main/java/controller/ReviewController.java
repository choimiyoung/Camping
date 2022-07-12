package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.ReviewDao;
import vo.ReviewVo;

@Controller
public class ReviewController {

	ReviewDao review_dao;

	public void setReview_dao(ReviewDao review_dao) {
		this.review_dao = review_dao;
	}


	@RequestMapping("list.do")
	public String list(Model model) {
					  //������ �����͸� ���信 ��������ؼ�Model���
		
		List<ReviewVo> list = review_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "review/review_list";
				
		
	}
	
	
	public void review_dao(ReviewDao review_dao) {
		this.review_dao = review_dao;
	}
	
	   @RequestMapping(value="/review/list.do")
	   public String list(@RequestParam(value="search",required = false, defaultValue = "all") String search, 
			   			  @RequestParam(value="search_text",required = false)				   String search_text,
			   			  Model model) {
		  
	      Map map = new HashMap();

	      if (!search.equals("all")) { // ��ü �˻��� �ƴϸ�

	         if (search.equals("review_title_review_content_mem_nickname")) { //����+����+�ۼ��ڴг���

	            map.put("review_title", search_text);
	            map.put("review_content", search_text);
	            map.put("mem_nickname", search_text);

	         } else if (search.equals("review_title")) { //����

	            map.put("review_title", search_text);

	         } else if (search.equals("review_content")) { //����

	            map.put("review_content", search_text);

 	         }  else if (search.equals("mem_nickname")) { //�г���

 	            map.put("mem_nickname", search_text);

 	         }

	      }

	      List<ReviewVo> list = review_dao.selectList(map);

	      model.addAttribute("list",list); 
	      
	      
	      return "review/review_list";

	   }
		
	 
}
