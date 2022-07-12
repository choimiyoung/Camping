package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;

public interface ReviewDao {
	
	
	public List<ReviewVo> selectList();

	public List<ReviewVo> selectList(Map map);

	// idx에 해당되는 객체 1건 구하기
	public ReviewVo selectOne(int review_idx);

	
	

}
