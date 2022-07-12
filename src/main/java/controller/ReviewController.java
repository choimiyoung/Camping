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
					  //가져온 데이터를 포토에 보여줘야해서Model사용
		
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

	      if (!search.equals("all")) { // 전체 검색이 아니면

	         if (search.equals("review_title_review_content_mem_nickname")) { //제목+내용+작성자닉네임

	            map.put("review_title", search_text);
	            map.put("review_content", search_text);
	            map.put("mem_nickname", search_text);

	         } else if (search.equals("review_title")) { //제목

	            map.put("review_title", search_text);

	         } else if (search.equals("review_content")) { //내용

	            map.put("review_content", search_text);

 	         }  else if (search.equals("mem_nickname")) { //닉네임

 	            map.put("mem_nickname", search_text);

 	         }

	      }

	      List<ReviewVo> list = review_dao.selectList(map);

	      model.addAttribute("list",list); 
	      
	      
	      return "review/review_list";

	   }
		
	 
}
