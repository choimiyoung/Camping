package dao;

import java.util.List;
import java.util.Map;

import vo.MarketVo;

public interface MarketDao {
	
	
	public List<MarketVo> selectList();

	public List<MarketVo> selectList(Map map);

	// idx에 해당되는 객체 1건 구하기
	public MarketVo selectOne(int market_idx);

	
	

}
