package sell;

import java.sql.Timestamp;

public class Sell_replyVO {

	
	private int sell_no;
	private int sr_no;
	private String id;
	private Timestamp sr_date;
	private String sr_content;
	
	
	public int getSell_no() {
		return sell_no;
	}
	public void setSell_no(int sell_no) {
		this.sell_no = sell_no;
	}
	public int getSr_no() {
		return sr_no;
	}
	public void setSr_no(int sr_no) {
		this.sr_no = sr_no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Timestamp getSr_date() {
		return sr_date;
	}
	public void setSr_date(Timestamp sr_date) {
		this.sr_date = sr_date;
	}
	public String getSr_content() {
		return sr_content;
	}
	public void setSr_content(String sr_content) {
		this.sr_content = sr_content;
	}
	
	
	
	
	
}
