package vo;

public class GradeVo {
	
	
	int 	grade_idx;
	String  grade_name;
	
	
	public GradeVo() {
		super();
	}


	public GradeVo(int grade_idx, String grade_name) {
		super();
		this.grade_idx = grade_idx;
		this.grade_name = grade_name;
	}
	
	
	public int getGrade_idx() {
		return grade_idx;
	}
	public void setGrade_idx(int grade_idx) {
		this.grade_idx = grade_idx;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	
	
	
	
	
	
	
}
