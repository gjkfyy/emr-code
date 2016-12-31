package iih.di.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 诊断列表返回的model<br>
 * 
 * 根据就诊序号来区分是门诊诊断或是住院诊断为了统计方便，增加一个就诊类型字段。来区分诊断的来源 同时删除
 * 诊断类型编码字段。而出院诊断、入院诊断的定义见使用方案。
 */
public class DibDiRtModel {
	/** 诊断序号 */
	private String diSn;

	/** 父诊断序号 */
	private String parDiSn;

	/** 层级 */
	private Short lvl;

	/** 诊断编码 */
	private String diCd;

	/** 诊断名称 输入手工录入的情景而预备的冗余字段,通常直接通过诊断编码获取 */
	private String diNm;

	/** icd编码 ，冗余 20140826确定 */
	private String icdCd;

	/** 补充说明 */
	private String addDescr;

	/** 主诊断标志 */
	private Short mainF;

	/**
	 * 乐观锁字段
	 */
	private Integer updCount;

	/** 诊断时间 */
	private Timestamp diTime;

	private List<DibDiRtModel> children;

	/**
	 * 默认为NULL 0 活动的：不一定是最新的 1 停用的又称为活动FLAG
	 */
	//private Short stopUseF;
	/** 诊断医生编码 */
	private String diEmpId;
	/** 诊断医生姓名 */
	private String diEmpNm;

	/** 疑似标志 */
	private Boolean suspected;

	/** 待查标志 */
	private Boolean tocheck;
	
    /** */
    String setOwnerTypeCd;

    /** */
    String setOwnerCd;
    
	private String	 	lvl1SortNo	;//	一级顺序号
	private String	 	lvl2SortNo	;//	二级顺序号
    
	
	
	
	public String getLvl1SortNo() {
		return lvl1SortNo;
	}

	public void setLvl1SortNo(String lvl1SortNo) {
		this.lvl1SortNo = lvl1SortNo;
	}

	public String getLvl2SortNo() {
		return lvl2SortNo;
	}

	public void setLvl2SortNo(String lvl2SortNo) {
		this.lvl2SortNo = lvl2SortNo;
	}

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

	public String getDiEmpNm() {
		return diEmpNm;
	}

	public void setDiEmpNm(String diEmpNm) {
		this.diEmpNm = diEmpNm;
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

	public Timestamp getDiTime() {
		return this.diTime;
	}

	public void setDiTime(Timestamp diTime) {
		this.diTime = diTime;
	}

	public String getDiSn() {
		return diSn;
	}

	public void setDiSn(String diSn) {
		this.diSn = diSn;
	}

	public String getParDiSn() {
		return parDiSn;
	}

	public void setParDiSn(String parDiSn) {
		this.parDiSn = parDiSn;
	}

	public Short getLvl() {
		return lvl;
	}

	public void setLvl(Short lvl) {
		this.lvl = lvl;
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

	public Short getMainF() {
		return mainF;
	}

	public void setMainF(Short mainF) {
		this.mainF = mainF;
	}

	public String getDiEmpId() {
		return diEmpId;
	}

	public void setDiEmpId(String diEmpId) {
		this.diEmpId = diEmpId;
	}

	public List<DibDiRtModel> getChildren() {
		return children;
	}

	public void setChildren(List<DibDiRtModel> children) {
		this.children = children;
	}

}