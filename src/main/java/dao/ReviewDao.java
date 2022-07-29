package dao;

import java.util.List;
import java.util.Map;

import vo.ReviewVo;

public interface ReviewDao {
	
	
	public List<ReviewVo> selectList();
	public List<ReviewVo> selectList(int m_idx);
	public List<ReviewVo> selectList(String search_text);

	public List<ReviewVo> selectConditionList(Map map);

	// idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public ReviewVo selectOne(int review_idx);

	
	int			  selectRowTotal();
	int			  selectRowTotal(Map map); 

 //�Խñ� ���ƿ� +1
   public int review_insertlike(ReviewVo vo);
   
   //�Խñ� ���ƿ� -1
   public int review_deletelike(ReviewVo vo);


   int    insert(ReviewVo vo);//���۾���
   int      reply(ReviewVo vo); //��۾���
   int     delete(int review_idx);//���� ������ �ƴϴ�
   
   int      update(ReviewVo vo);
   int      update_step(ReviewVo vo); //��� �߰��� 
   int     update_readhit(int review_idx);//��ȸ�� ���� 
   int     modify(ReviewVo vo);   
	   
   //�̿�
   //mem_idx�� �ش��ϴ� review����Ʈ �������� 
   
   List<ReviewVo> review_mem_list(Map map);
	
 //mem_idx�� �ش��ϴ� carpool �Խñ� ���ƿ��� ����Ʈ 
   List<ReviewVo> review_like_mem_list(Map map);

}
