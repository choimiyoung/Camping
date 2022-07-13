package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDao;
import vo.MemberVo;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletRequest request;
	
	
	MemberDao member_dao;

	public void setMember_dao(MemberDao member_dao) {
		this.member_dao = member_dao;
	}
	
	@RequestMapping("mypage_adm.do")
	public String list(Model model) {
		
		List<MemberVo> list =member_dao.selectList();
		model.addAttribute("list", list);
		
		
		
		return "/member/member_mypage_adm";
		
	}
	
	@RequestMapping("login.do")
	@ResponseBody
	public Map login(String mem_email,String mem_pwd)
	{   
		
		MemberVo user = member_dao.selectOne(mem_email);
		
		//mem_email üũ
		
		Map map = new HashMap();
		if(user==null) {
			
		
			map.put("result", "fail_email");
			return map;
		}
		
		if(user.getMem_pwd().equals(mem_pwd)==false) {
		
		
			map.put("result", "fail_pwd");
			return map;
		}
	
		session.setAttribute("user", user);
		
		map.put("mem_nickname",user.getMem_nickname());
<<<<<<< HEAD
=======
		map.put("grade_idx", user.getGrade_idx());
>>>>>>> cb87b1492189691c45fdaaa14f0b4cad7e9d3ed0
		map.put("result", "success");
		return map;
		
	}
	
	//�α��� ��
<<<<<<< HEAD
	@RequestMapping("login_form.do")
	public String login_form() {
		
		return "member/member_login_form";
=======
	@RequestMapping("insert_form.do")
	public String login_form() {
		
		return "member/member_signup_form";
>>>>>>> cb87b1492189691c45fdaaa14f0b4cad7e9d3ed0
	}
	
	
	
	@RequestMapping("delete.do")
	public String delete(int mem_idx) {
		int res = member_dao.delete(mem_idx);
		
		return "redirect:list.do";
		
	}
	
	@RequestMapping("insert.do")
	public String insert(MemberVo vo) {
		
		int res = member_dao.insert(vo);
		return "redirect:list.do";
	}
	
	
	
}
