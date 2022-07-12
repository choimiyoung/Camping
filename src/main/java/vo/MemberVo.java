package vo;

//Member 
public class MemberVo {
	
	
	int mem_idx;
	int grade_idx;
	String mem_email;
	String mem_pwd;
	String mem_nickname;
	String mem_gender ;
	String mem_birth;
	String mem_regdate;
	String mem_pic_filename;
	String mem_profile;
	int	   mem_status;
	
	public MemberVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public int getGrade_idx() {
		return grade_idx;
	}
	public void setGrade_idx(int grade_idx) {
		this.grade_idx = grade_idx;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_pwd() {
		return mem_pwd;
	}
	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}
	
	
	public String getMem_pic_filename() {
		return mem_pic_filename;
	}
	public void setMem_pic_filename(String mem_pic_filename) {
		this.mem_pic_filename = mem_pic_filename;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}
	public int getMem_status() {
		return mem_status;
	}
	public void setMem_status(int mem_status) {
		this.mem_status = mem_status;
	}

	public String getMem_regdate() {
		return mem_regdate;
	}


	public void setMem_regdate(String mem_regdate) {
		this.mem_regdate = mem_regdate;
	}
	
	

}
