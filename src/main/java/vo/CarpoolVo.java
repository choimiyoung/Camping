package vo;

public class CarpoolVo {

	int			carpool_idx;
	int			category_idx;
	int			mem_idx;
	String		mem_nickname;
	String		carpool_title;
	String		carpool_content;
	String		carpool_regdate;
	int			carpool_hit_count;
	int			carpool_like_count;
	String		carpool_ip;
	
	
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public int getCarpool_idx() {
		return carpool_idx;
	}
	public void setCarpool_idx(int carpool_idx) {
		this.carpool_idx = carpool_idx;
	}
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}
	public int getMem_idx() {
		return mem_idx;
	}
	public void setMem_idx(int mem_idx) {
		this.mem_idx = mem_idx;
	}
	public String getCarpool_title() {
		return carpool_title;
	}
	public void setCarpool_title(String carpool_title) {
		this.carpool_title = carpool_title;
	}
	public String getCarpool_content() {
		return carpool_content;
	}
	public void setCarpool_content(String carpool_content) {
		this.carpool_content = carpool_content;
	}
	public String getCarpool_regdate() {
		return carpool_regdate;
	}
	public void setCarpool_regdate(String carpool_regdate) {
		this.carpool_regdate = carpool_regdate;
	}
	public int getCarpool_hit_count() {
		return carpool_hit_count;
	}
	public void setCarpool_hit_count(int carpool_hit_count) {
		this.carpool_hit_count = carpool_hit_count;
	}
	public int getCarpool_like_count() {
		return carpool_like_count;
	}
	public void setCarpool_like_count(int carpool_like_count) {
		this.carpool_like_count = carpool_like_count;
	}
	public String getCarpool_ip() {
		return carpool_ip;
	}
	public void setCarpool_ip(String carpool_ip) {
		this.carpool_ip = carpool_ip;
	}
	
	
	
}
