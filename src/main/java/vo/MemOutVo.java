package vo;

public class MemOutVo {
	
	int 	mem_out_idx;
	int 	mem_idx;
	String  mem_out_regdate;

	public MemOutVo() {
		super();
	}

	public MemOutVo(int mem_out_idx, int mem_idx, String mem_out_regdate) {
		super();
		this.mem_out_idx = mem_out_idx;
		this.mem_idx = mem_idx;
		this.mem_out_regdate = mem_out_regdate;
	}
	
	


	public int getMem_out_idx() {
		return mem_out_idx;
	}
	public void setMem_out_idx(int mem_out_idx) {
		this.mem_out_idx = mem_out_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getMem_out_regdate() {
		return mem_out_regdate;
	}
	public void setMem_out_regdate(String mem_out_regdate) {
		this.mem_out_regdate = mem_out_regdate;
	}
	

}
