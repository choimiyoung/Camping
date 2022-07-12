package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.MarketVo;

public class MarketDaoImpl implements MarketDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
	@Override
	public List<MarketVo> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketVo> selectList(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MarketVo selectOne(int market_idx) {
		// TODO Auto-generated method stub
		return null;
	}

}
