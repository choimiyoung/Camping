package dao;

import java.util.List;

import vo.CarpoolVo;

public interface CarpoolDao {

	List<CarpoolVo> selectList();

	//�Խñ� ���ƿ� +1
	public int carpool_insertlike(int carpool_idx);
	
	//�Խñ� ���ƿ� -1
	public int carpool_deletelike(int carpool_idx);	
	
}
