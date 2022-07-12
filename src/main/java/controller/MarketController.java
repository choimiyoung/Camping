package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.MarketDao;
import vo.MarketVo;

@Controller
public class MarketController {

	MarketDao market_dao;

	public void setMarket_dao(MarketDao market_dao) {
		this.market_dao = market_dao;
	}


	@RequestMapping("list.do")
	public String list(Model model) {
					  //가져온 데이터를 포토에 보여줘야해서Model사용
		
		List<MarketVo> list = market_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "market/market_list";
				
		
	}
	
	
	public void market_dao(MarketDao market_dao) {
		this.market_dao = market_dao;
	}
	
	   @RequestMapping(value="/market/list.do")
	   public String list(@RequestParam(value="search",required = false, defaultValue = "all") String search, 
			   			  @RequestParam(value="search_text",required = false)				   String search_text,
			   			  Model model) {
		  
	      Map map = new HashMap();

	      if (!search.equals("all")) { // 전체 검색이 아니면

	         if (search.equals("market_title_market_content_mem_nickname")) { //제목+내용+작성자닉네임

	            map.put("market_title", search_text);
	            map.put("market_content", search_text);
	            map.put("mem_nickname", search_text);

	         } else if (search.equals("market_title")) { //제목

	            map.put("market_title", search_text);

	         } else if (search.equals("market_content")) { //내용

	            map.put("market_content", search_text);

 	         }  else if (search.equals("mem_nickname")) { //닉네임

 	            map.put("mem_nickname", search_text);

 	         }

	      }

	      List<MarketVo> list = market_dao.selectList(map);

	      model.addAttribute("list",list); 
	      
	      
	      return "market/market_list";

	   }
		
	 
}
