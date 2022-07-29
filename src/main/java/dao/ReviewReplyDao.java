package dao;

import java.util.List;
import java.util.Map;

import vo.CarpoolReplyVo;
import vo.ReviewReplyVo;

public interface ReviewReplyDao {

	
	List<ReviewReplyVo> selectList();
	List<ReviewReplyVo> selectList(Map map);
	
	ReviewReplyVo 		selectOne(int review_reply_idx);
	
	int 				delete(int review_idx);
	int					insert(ReviewReplyVo vo);
	int 				update_step(ReviewReplyVo baseVo);
	int 				reply(ReviewReplyVo vo);
	
	
	//��ü ��� �� ���ϱ�
	int 				selectRowTotal();
	

	//�̿�
	//mem_idx�� ���ϴ� review_replu ����Ʈ �������� 
	
	List<ReviewReplyVo> review_reply_mem_list(Map map); 
	

   //�Խñ� ���ƿ� +1
   public int review_reply_insertlike(ReviewReplyVo vo);
   
   //�Խñ� ���ƿ� -1
   public int review_reply_deletelike(ReviewReplyVo vo);


	
	
}
