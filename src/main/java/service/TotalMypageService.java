package service;

import java.util.Map;

public interface TotalMypageService {
	
	 //mem_idx�� �ش��ϴ� ī�װ��� ����Ʈ 
	   Map category_list(Map map);
	  //mem_idx�� �ش��ϴ� ī�װ��� ��� ����Ʈ
	   Map category_reply_list(Map map);
	  //mem_idx�� �ش��ϴ� ī�װ��� ���ƿ� ����Ʈ 
	   Map category_like_list(Map map);
	   

}
