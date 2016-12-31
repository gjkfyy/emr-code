package iih.kr.db.cs.entity;

import org.seasar.doma.Entity;

/**
 */
@Entity()
//@Table(name = "DIM_DI")
public class DiSuiteModelEntity {
	
	private String diSuiteCode ;//所属类型 所属编码 的 自定义分类与诊断关系

	private String diSuiteTypeName;
	
	private String diSuiteTypeCode;
	
	private String diName;
	
	private String diCode;
	


	public String getDiSuiteTypeName() {
		return diSuiteTypeName;
	}

	public void setDiSuiteTypeName(String diSuiteTypeName) {
		this.diSuiteTypeName = diSuiteTypeName;
	}

	public String getDiSuiteTypeCode() {
		return diSuiteTypeCode;
	}

	public void setDiSuiteTypeCode(String diSuiteTypeCode) {
		this.diSuiteTypeCode = diSuiteTypeCode;
	}

	public String getDiName() {
		return diName;
	}

	public void setDiName(String diName) {
		this.diName = diName;
	}

	public String getDiCode() {
		return diCode;
	}

	public void setDiCode(String diCode) {
		this.diCode = diCode;
	}
	
	public String getDiSuiteCode() {
		return diSuiteCode;
	}

	public void setDiSuiteCode(String diSuiteCode) {
		this.diSuiteCode = diSuiteCode;
	}
	
}