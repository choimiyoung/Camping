package dao;

import java.util.List;
import java.util.Map;

import vo.CarpoolVo;

public interface CarpoolDao {
	
	
	public List<CarpoolVo> selectList();

	public List<CarpoolVo> selectList(Map map);

	// idx�� �ش�Ǵ� ��ü 1�� ���ϱ�
	public CarpoolVo selectOne(int carpool_idx);

	
	

}
