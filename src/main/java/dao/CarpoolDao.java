package dao;

import java.util.List;

import vo.CarpoolVo;

public interface CarpoolDao {

	List<CarpoolVo> selectList(int m_idx);

	//�Խñ� ���ƿ� +1
	public int carpool_insertlike(CarpoolVo vo);
	
	//�Խñ� ���ƿ� -1
	public int carpool_deletelike(int carpool_idx);

		
	
}
