package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;

public interface ReviewDao {
	
	
	public List<ReviewVo> selectList();

	public List<ReviewVo> selectList(Map map);

	// idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public ReviewVo selectOne(int review_idx);

	
	

}
