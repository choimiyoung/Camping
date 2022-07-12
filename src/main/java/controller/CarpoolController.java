package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.CarpoolDao;
import vo.CarpoolVo;

@Controller
public class CarpoolController {

	CarpoolDao carpool_dao;

	public void setCarpool_dao(CarpoolDao carpool_dao) {
		this.carpool_dao = carpool_dao;
	}


	@RequestMapping("list.do")
	public String list(Model model) {
					  //가져온 데이터를 포토에 보여줘야해서Model사용
		
		List<CarpoolVo> list = carpool_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "carpool/carpool_list";
				
		
	}
	
	
	public void carpool_dao(CarpoolDao carpool_dao) {
		this.carpool_dao = carpool_dao;
	}
	
	   @RequestMapping(value="/carpool/list.do")
	   public String list(@RequestParam(value="search",required = false, defaultValue = "all") String search, 
			   			  @RequestParam(value="search_text",required = false)				   String search_text,
			   			  Model model) {
		  
	      Map map = new HashMap();

	      if (!search.equals("all")) { // 전체 검색이 아니면

	         if (search.equals("carpool_title_carpool_content_mem_nickname")) { //제목+내용+작성자닉네임

	            map.put("carpool_title", search_text);
	            map.put("carpool_content", search_text);
	            map.put("mem_nickname", search_text);

	         } else if (search.equals("carpool_title")) { //제목

	            map.put("carpool_title", search_text);

	         } else if (search.equals("carpool_content")) { //내용

	            map.put("carpool_content", search_text);

 	         }  else if (search.equals("mem_nickname")) { //닉네임

 	            map.put("mem_nickname", search_text);

 	         }

	      }

	      List<CarpoolVo> list = carpool_dao.selectList(map);

	      model.addAttribute("list",list); 
	      
	      
	      return "carpool/carpool_list";

	   }
		
	 
}
