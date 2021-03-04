package buy;

import java.sql.Date;
import java.sql.Timestamp;

public class BuyVO {

	private int buy_no;
	private String buy_title;
	private String id;
	private int buy_count;
	private Timestamp buy_date;
	private String buy_deadline;
	private String buy_image;
	private String buy_content;
	
	public int getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}
	public String getBuy_title() {
		return buy_title;
	}
	public void setBuy_title(String buy_title) {
		this.buy_title = buy_title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getBuy_count() {
		return buy_count;
	}
	public void setBuy_count(int buy_count) {
		this.buy_count = buy_count;
	}
	public Timestamp getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Timestamp buy_date) {
		this.buy_date = buy_date;
	}
	public String getBuy_deadline() {
		return buy_deadline;
	}
	public void setBuy_deadline(String buy_deadline) {
		this.buy_deadline = buy_deadline;
	}
	public String getBuy_image() {
		return buy_image;
	}
	public void setBuy_image(String buy_image) {
		this.buy_image = buy_image;
	}
	public String getBuy_content() {
		return buy_content;
	}
	public void setBuy_content(String buy_content) {
		this.buy_content = buy_content;
	}
	
	@Override
	public String toString() {
		return "BuyVO [buy_no="+buy_no+", buy_title="+buy_title+", id="+id+", buy_count="+buy_count+", buy_date="+buy_date+", buy_deadline="+buy_deadline+", buy_image="+buy_image+", buy_content="+buy_content+"]";
	}
	
}
