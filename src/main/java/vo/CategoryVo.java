package vo;

public class CategoryVo {
	
	int 	category_idx;
	String  category_type;
	

	public CategoryVo() {
		super();
	}


	public CategoryVo(int category_idx, String category_type) {
		super();
		this.category_idx = category_idx;
		this.category_type = category_type;
	}
	
	
	public int getCategory_idx() {
		return category_idx;
	}
	public void setCategory_idx(int category_idx) {
		this.category_idx = category_idx;
	}
	public String getCategory_type() {
		return category_type;
	}
	public void setCategory_type(String category_type) {
		this.category_type = category_type;
	}
	
	
	
	

}
