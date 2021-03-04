package sell;

public class SellVO {

	private int sell_no;
	private String sell_title;
	private String sell_genre;
	private String id;
	private int sell_count;
	private String tel;
	private String email;
	private String sell_content;
	private String sell_image1;
	private String sell_image2;
	private String sell_image3;
	public int getSell_no() {
		return sell_no;
	}
	public void setSell_no(int sell_no) {
		this.sell_no = sell_no;
	}
	public String getSell_title() {
		return sell_title;
	}
	public void setSell_title(String sell_title) {
		this.sell_title = sell_title;
	}
	public String getSell_genre() {
		return sell_genre;
	}
	public void setSell_genre(String sell_genre) {
		this.sell_genre = sell_genre;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getSell_count() {
		return sell_count;
	}
	public void setSell_count(int sell_count) {
		this.sell_count = sell_count;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSell_content() {
		return sell_content;
	}
	public void setSell_content(String sell_content) {
		this.sell_content = sell_content;
	}
	public String getSell_image1() {
		return sell_image1;
	}
	public void setSell_image1(String sell_image1) {
		this.sell_image1 = sell_image1;
	}
	public String getSell_image2() {
		return sell_image2;
	}
	public void setSell_image2(String sell_image2) {
		this.sell_image2 = sell_image2;
	}
	public String getSell_image3() {
		return sell_image3;
	}
	public void setSell_image3(String sell_image3) {
		this.sell_image3 = sell_image3;
	}
	
	@Override
	public String toString() {
		return "BuyVO [sell_no="+sell_no+", sell_title="+sell_title+", sell_genre="+sell_genre+", id="+id+", sell_count="+sell_count+", tel="+tel+", email="+email+", sell_content="+sell_content+", sell_image1="+sell_image1+", sell_image2="+sell_image2+", sell_image3="+sell_image3+"]";
	}
	
}
