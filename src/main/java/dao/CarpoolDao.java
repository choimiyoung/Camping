package dao;

import java.util.List;
import java.util.Map;

import vo.CarpoolVo;

public interface CarpoolDao {
	
	
	public List<CarpoolVo> selectList();

	public List<CarpoolVo> selectList(Map map);

	// idx에 해당되는 객체 1건 구하기
	public CarpoolVo selectOne(int carpool_idx);

	
	

}
