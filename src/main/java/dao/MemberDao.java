package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {

	//��ü��ȸ
	 List<MemberVo> selectList();
	
	 int insert(MemberVo vo);
	 int delete(int mem_idx);
	 int update(MemberVo vo);
    //mem_idx�� �ش�Ǵ� ��ü 1�� ���ϱ� 
		 MemberVo selectOne(int mem_idx);
	//mem_email�� �ش�Ǵ� ��ü 1�� ���ϱ�	
		 MemberVo selectOne(String mem_email);
	//mem_nickname �ߺ�Ȯ��
		 MemberVo selectOne1(String mem_nickname);
	
		 
	
}
