package dao;

import java.util.List;
import java.util.Map;

import vo.MarketVo;

public interface MarketDao {
	
	
	public List<MarketVo> selectList();

	public List<MarketVo> selectList(Map map);

	// idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public MarketVo selectOne(int market_idx);

	
	

}
