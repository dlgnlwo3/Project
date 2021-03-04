package buy;

import java.sql.Timestamp;

public class Buy_replyVO {

	private int buy_no;
	private int br_no;
	private String id;
	private Timestamp br_date;
	private String br_content;
	
	public int getBuy_no() {
		return buy_no;
	}
	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}
	public int getBr_no() {
		return br_no;
	}
	public void setBr_no(int br_no) {
		this.br_no = br_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getBr_date() {
		return br_date;
	}
	public void setBr_date(Timestamp br_date) {
		this.br_date = br_date;
	}
	public String getBr_content() {
		return br_content;
	}
	public void setBr_content(String br_content) {
		this.br_content = br_content;
	}
	
	
	
	
}
