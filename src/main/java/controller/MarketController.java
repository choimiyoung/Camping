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


	@RequestMapping("/board/market_list.do")
	public String list(Model model) {
					  //������ �����͸� ���信 ��������ؼ�Model���
		
		List<MarketVo> list = market_dao.selectList();
		
		model.addAttribute("list", list);
		
		return "board/market_board";
				
		
	}
	
	
	  public void market_dao(MarketDao market_dao) { 
		  this.market_dao = market_dao;
	  }
	  
		/*
		 * @RequestMapping(value="/market/market_list.do") public String
		 * list(@RequestParam(value="search",required = false, defaultValue = "all")
		 * String search,
		 * 
		 * @RequestParam(value="search_text",required = false) String search_text, Model
		 * model) {
		 * 
		 * Map map = new HashMap();
		 * 
		 * if (!search.equals("all")) { // ��ü �˻��� �ƴϸ�
		 * 
		 * if (search.equals("market_title_market_content_mem_nickname")) {
		 * //����+����+�ۼ��ڴг���
		 * 
		 * map.put("market_title", search_text); map.put("market_content", search_text);
		 * map.put("mem_nickname", search_text);
		 * 
		 * } else if (search.equals("market_title")) { //����
		 * 
		 * map.put("market_title", search_text);
		 * 
		 * } else if (search.equals("market_content")) { //����
		 * 
		 * map.put("market_content", search_text);
		 * 
		 * } else if (search.equals("mem_nickname")) { //�г���
		 * 
		 * map.put("mem_nickname", search_text);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * List<MarketVo> list = market_dao.selectList(map);
		 * 
		 * model.addAttribute("list",list);
		 * 
		 * 
		 * return "board/market_board";
		 * 
		 * }
		 */
	 
	 
}
