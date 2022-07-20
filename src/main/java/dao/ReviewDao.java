package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;

public interface ReviewDao {
	
	
	public List<ReviewVo> selectList();
	public List<ReviewVo> selectList(String search_text);

	public List<ReviewVo> selectList(Map map);

	// idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public ReviewVo selectOne(int review_idx);

	
	int			  selectRowTotal();
	int			  selectRowTotal(Map map); 



}
