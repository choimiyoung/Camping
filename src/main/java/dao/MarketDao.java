package dao;

import java.util.List;

import vo.MarketVo;

public interface MarketDao {

	List<MarketVo> selectList(int m_idx);
	
	//�Խñ� ���ƿ� +1
	public int market_insertlike(MarketVo vo);
	
	//�Խñ� ���ƿ� -1
	public int market_deletelike(MarketVo vo);

}