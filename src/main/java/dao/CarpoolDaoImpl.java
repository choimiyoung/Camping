package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.CarpoolVo;

public class CarpoolDaoImpl implements CarpoolDao{
	
	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<CarpoolVo> selectList() {

		List<CarpoolVo> list = sqlSession.selectList("carpool.carpool_list");
		
		return list;
	}
	
	
	public List<CarpoolVo> selectList(Map map) {
		// TODO Auto-generated method stub
		
		List<CarpoolVo> list = null;
		
		
		list = sqlSession.selectList("carpool.carpool_list_condition", map);
		
		
		return list;
	}
	
	public CarpoolVo selectOne(int carpool_idx) {

		 CarpoolVo vo = null;
	
		vo = sqlSession.selectOne("carpool.carpool_one", carpool_idx);
		
		return vo;
	}
	
	
}
