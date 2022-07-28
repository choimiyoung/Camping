package dao;

import java.util.List;
import java.util.Map;

import vo.CarpoolVo;

public interface CarpoolDao {

	List<CarpoolVo> selectList();
	List<CarpoolVo> selectList(int m_idx);
	List<CarpoolVo> selectList(String search_text);
	List<CarpoolVo> selectConditionList(Map map);

	int			  selectRowTotal();
	int			  selectRowTotal(Map map); 


	

	   List<CarpoolVo> selectList(Map map);
	   CarpoolVo selectOne(int carpool_idx);

	   //�Խñ� ���ƿ� +1
	   public int carpool_insertlike(CarpoolVo vo);
	   
	   //�Խñ� ���ƿ� -1
	   public int carpool_deletelike(CarpoolVo vo);

	   
	   int    insert(CarpoolVo vo);//���۾���
	   int      reply(CarpoolVo vo); //��۾���
	   int     delete(int carpool_idx);//���� ������ �ƴϴ�
	   
	   int      update(CarpoolVo vo);
	   int      update_step(CarpoolVo vo); //��� �߰��� 
	   int     update_readhit(int carpool_idx);//��ȸ�� ���� 
	   int     modify(CarpoolVo vo);   
	   
	   //�̿��ڵ�
	   //mem_idx�� �ش��ϴ� carpool����Ʈ �������� 
	   List<CarpoolVo> carpool_mem_list(int mem_idx);
	      
	   
	   
}