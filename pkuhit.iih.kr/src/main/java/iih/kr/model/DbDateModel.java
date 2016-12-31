package iih.kr.model;
import java.util.Date;
public class DbDateModel {


	/**
	 * 构造器
	 */
	public DbDateModel() {
		// TODO Auto-generated constructor stub
	}

	private Date systimestamp;

	private String sysdateStr;

	private String systsStr;
	
	private String mrTime;
	
	
	
	public String getMrTime() {
		return mrTime;
	}

	public void setMrTime(String mrTime) {
		this.mrTime = mrTime;
	}

	public Date getSystimestamp() {
		return systimestamp;
	}

	public void setSystimestamp(Date systimestamp) {
		this.systimestamp = systimestamp;
	}

	public String getSystsStr() {
		return systsStr;
	}

	public void setSystsStr(String systsStr) {
		this.systsStr = systsStr;
	}

	public String getSysdateStr() {
		return sysdateStr;
	}

	public void setSysdateStr(String sysdateStr) {
		this.sysdateStr = sysdateStr;
	}

}
