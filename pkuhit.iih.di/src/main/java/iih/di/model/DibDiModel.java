package iih.di.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * 根据就诊序号来区分是门诊诊断或是住院诊断为了统计方便，增加一个就诊类型字段。来区分诊断的来源 同时删除
 * 诊断类型编码字段。而出院诊断、入院诊断的定义见使用方案。
 */
public class DibDiModel {
	
	private String diSn;

	/** 诊断编码 */
	private String diCd;

	/** 诊断名称 输入手工录入的情景而预备的冗余字段,通常直接通过诊断编码获取 */
	private String diNm;

	/** icd编码 ，冗余 20140826确定 */
	private String icdCd;

	/** 补充说明 */
	private String addDescr;
	/**
	 * 默认为NULL 0 活动的：不一定是最新的 1 停用的又称为活动FLAG
	 */
	private Short stopUseF;
	/** 疑似标志 */
	private Boolean suspected;

	/** 待查标志 */
	private Boolean tocheck;
	/**
	 * 乐观锁字段
	 */
	private Integer updCount;
	
    /**若该诊断从组套选择中添加到诊断列表的，则该字段为组套选择是的owerType */
    String setOwnerTypeCd;

    /**若该诊断从组套选择中添加到诊断列表的，则该字段为组套选择是的owerTypeCd */
    String setOwnerCd;
	
	public String getSetOwnerTypeCd() {
		return setOwnerTypeCd;
	}

	public void setSetOwnerTypeCd(String setOwnerTypeCd) {
		this.setOwnerTypeCd = setOwnerTypeCd;
	}

	public String getSetOwnerCd() {
		return setOwnerCd;
	}

	public void setSetOwnerCd(String setOwnerCd) {
		this.setOwnerCd = setOwnerCd;
	}

	public Integer getUpdCount() {
		return updCount;
	}

	public void setUpdCount(Integer updCount) {
		this.updCount = updCount;
	}

	/** 诊断时间 */
	private Date diTime;
	
	private DibDiModel[] children;
	
	public DibDiModel[] getChildren() {
		return children;
	}

	public void setChildren(DibDiModel[] children) {
		this.children = children;
	}

	public String getDiSn() {
		return diSn;
	}

	public void setDiSn(String diSn) {
		this.diSn = diSn;
	}

	public Boolean getSuspected() {
		return suspected;
	}

	public void setSuspected(Boolean suspected) {
		this.suspected = suspected;
	}

	public Boolean getTocheck() {
		return tocheck;
	}

	public void setTocheck(Boolean tocheck) {
		this.tocheck = tocheck;
	}



	public Date getDiTime() {
		return this.diTime;
	}

	public void setDiTime(Date diTime) {
		this.diTime = diTime;
	}

	public String getDiCd() {
		return diCd;
	}

	public void setDiCd(String diCd) {
		this.diCd = diCd;
	}

	public String getDiNm() {
		return diNm;
	}

	public void setDiNm(String diNm) {
		this.diNm = diNm;
	}

	public String getIcdCd() {
		return icdCd;
	}

	public void setIcdCd(String icdCd) {
		this.icdCd = icdCd;
	}

	public String getAddDescr() {
		return addDescr;
	}

	public void setAddDescr(String addDescr) {
		this.addDescr = addDescr;
	}


//	public Short getUncertainF() {
//		Short uf = null;
//		if (this.one.equalsIgnoreCase(this.getSuspected())) {
//			uf = Short.valueOf(this.one);
//		} else {
//			if (this.one.equalsIgnoreCase(this.getTocchek())) {
//				uf = Short.valueOf(this.zero);
//			}
//		}
//		this.uncertainF = uf;
//		return uncertainF;
//	}


	public Short getStopUseF() {
		return stopUseF;
	}

	public void setStopUseF(Short stopUseF) {
		this.stopUseF = stopUseF;
	}


}