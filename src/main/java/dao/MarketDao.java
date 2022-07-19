package dao;

import java.util.List;
import java.util.Map;

import vo.CarpoolVo;
import vo.MarketVo;

public interface MarketDao {

	List<MarketVo> selectList(int m_idx);
	MarketVo selectOne(int market_idx);
	
	//�Խñ� ���ƿ� +1
	public int market_insertlike(MarketVo vo);
	
	//�Խñ� ���ƿ� -1
	public int market_deletelike(MarketVo vo);

	//��ü�Խù���
	int		selectRowTotal();
	int		selectRowTotal(Map map);
	
	int 	insert(MarketVo vo);//���۾���
	int		reply(MarketVo vo); //��۾���
	int     delete(int market_idx);//���� ������ �ƴϴ�
	
	int		update(MarketVo vo);
	int		update_step(MarketVo vo); //��� �߰��� 
	int     update_readhit(int market_idx);//��ȸ�� ���� 
	int     modify(MarketVo vo);	

}