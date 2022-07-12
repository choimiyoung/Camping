package vo;

public class ReviewVo {

	int review_idx;					
	int category_idx;
	int mem_idx;			
	String mem_nickname;
	String review_title;
	String review_content;
	String review_regdate;
	int review_hit_count;
	int review_like_count;
	String review_thumbnail;
	String review_ip;
	

	public ReviewVo() {
		super();
	}
	
	
	public ReviewVo(int review_idx, int category_idx, int mem_idx, String review_title, String review_content,
			String review_regdate, int review_hit_count, int review_like_count, String review_thumbnail,
			String review_ip, String mem_nickname) {
		super();
		this.review_idx = review_idx;
		this.category_idx = category_idx;
		this.mem_idx = mem_idx;
		this.review_title = review_title;
		this.review_content = review_content;
		this.review_regdate = review_regdate;
		this.review_hit_count = review_hit_count;
		this.review_like_count = review_like_count;
		this.review_thumbnail = review_thumbnail;
		this.review_ip = review_ip;
		this.mem_nickname = mem_nickname;
	}


	public int getReview_idx() {
		return review_idx;
	}


	public void setReview_idx(int review_idx) {
		this.review_idx = review_idx;
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


	public String getReview_title() {
		return review_title;
	}


	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}


	public String getReview_content() {
		return review_content;
	}


	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}


	public String getReview_regdate() {
		return review_regdate;
	}


	public void setReview_regdate(String review_regdate) {
		this.review_regdate = review_regdate;
	}


	public int getReview_hit_count() {
		return review_hit_count;
	}


	public void setReview_hit_count(int review_hit_count) {
		this.review_hit_count = review_hit_count;
	}


	public int getReview_like_count() {
		return review_like_count;
	}


	public void setReview_like_count(int review_like_count) {
		this.review_like_count = review_like_count;
	}


	public String getReview_thumbnail() {
		return review_thumbnail;
	}


	public void setReview_thumbnail(String review_thumbnail) {
		this.review_thumbnail = review_thumbnail;
	}


	public String getReview_ip() {
		return review_ip;
	}


	public void setReview_ip(String review_ip) {
		this.review_ip = review_ip;
	}


	public String getMem_nickname() {
		return mem_nickname;
	}


	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}

	
	
	
	
}
