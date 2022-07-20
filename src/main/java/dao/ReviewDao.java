package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;
import vo.ReviewVo;

public interface ReviewDao {
	
	
	List<ReviewVo> selectList(int m_idx);
	ReviewVo selectOne(int review_idx);

	//�Խñ� ���ƿ� +1
	public int review_insertlike(ReviewVo vo);
	
	//�Խñ� ���ƿ� -1
	public int review_deletelike(ReviewVo vo);

	//��ü�Խù���
	int		selectRowTotal();
	int		selectRowTotal(Map map);
	
	int 	insert(ReviewVo vo);//���۾���
	int		reply(ReviewVo vo); //��۾���
	int     delete(int review_idx);//���� ������ �ƴϴ�
	
	int		update(ReviewVo vo);
	int		update_step(ReviewVo vo); //��� �߰��� 
	int     update_readhit(int review_idx);//��ȸ�� ���� 
	int     modify(ReviewVo vo);	
	
	

}
