package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.ReviewVo;

public class ReviewDaoImpl implements ReviewDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public List<ReviewVo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ReviewVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReviewVo selectOne(int review_idx) {
		// TODO Auto-generated method stub
		return null;
	}

}
