package dao;

import java.util.List;
import java.util.Map;

import vo.MarketVo;

public interface MarketDao {

	List<MarketVo> selectList();
	List<MarketVo> selectList(int m_idx);
	List<MarketVo> selectList(String search_text);
	List<MarketVo> selectConditionList(Map map);

	int			  selectRowTotal();
	int			  selectRowTotal(Map map); 

	
	MarketVo selectOne(int market_idx);
	
	//�Խñ� ���ƿ� +1
	   public int market_insertlike(MarketVo vo);
	   
	   //�Խñ� ���ƿ� -1
	   public int market_deletelike(MarketVo vo);

	 
	   int    insert(MarketVo vo);//���۾���
	   int      reply(MarketVo vo); //��۾���
	   int     delete(int market_idx);//���� ������ �ƴϴ�
	   
	   int      update(MarketVo vo);
	   int      update_step(MarketVo vo); //��� �߰��� 
	   int     update_readhit(int market_idx);//��ȸ�� ���� 
	   int     modify(MarketVo vo);   
	   
	   //�̿��ڵ�
	    //mem_idx�� �ش��ϴ� market����Ʈ �������� 
	      List<MarketVo> market_mem_list(int mem_idx);

}