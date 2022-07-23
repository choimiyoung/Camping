package dao;

import java.util.List;
import java.util.Map;

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
       
   //mem_idx�� �ش��ϴ� like ī��Ʈ ��  ���ϱ� 
      int selectOne_like_count(int mem_idx);
      
   //mem_idx�� �ش��ϴ� reply ī��Ʈ ��  ���ϱ� 
   int selectOne_reply_count(int mem_idx);
   
      
   //mem_idx�� �ش��ϴ� �Խù� ī��Ʈ ��  ���ϱ� 
   int selectOne_category_count(int mem_idx);

   //����¡&�˻�����
   int selectRowTotal(Map map); 
   List<MemberVo> selectConditionList(Map map);
  // int			  selectRowTotal();
   List<MemberVo> selectList(Map map);


   
   //mem_idx�� �ش��ϴ� ��� ���ƿ�  ī��Ʈ ��  ���ϱ� 
   int selectOne_reply_like_count(int mem_idx);
   
   //mem_idx�� �ش��ϴ� ���� ���� ����
   int member_update(MemberVo vo);
   
   //mem_idx�� �ش��ϴ� ȸ�� Ż�� 
   int member_out(MemberVo vo);
   
   //photo_upload
   int photo_upload(MemberVo vo);
   
    
   
}