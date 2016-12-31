package iih.kr.db.cs.entity;

import java.util.Date;

import org.seasar.doma.Entity;
@Entity()
public class DbDateEntity {

	/**
	 * 构造器
	 */
	public DbDateEntity() {
		// TODO Auto-generated constructor stub
	}
	
	private Date systimestamp;
	
	private String sysdateStr;
	
	private String systsStr;
	

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



	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}