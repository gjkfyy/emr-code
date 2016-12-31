package iih.di.db.entity;

import java.sql.Timestamp;

import org.seasar.doma.Entity;
import org.seasar.doma.Table;
/**
 * 根据就诊序号来区分是门诊诊断或是住院诊断为了统计方便，增加一个就诊类型字段。来区分诊断的来源
同时删除 诊断类型编码字段。而出院诊断、入院诊断的定义见使用方案。
 */
@Entity(listener = DibDiListener.class)
@Table(name = "DIB_DI")
public class DibDi {
	/**诊断序号 */
    private String diSn;


	/**父诊断序号 */
    private String parDiSn;

    /**就诊序号 */
    private String enSn;

    /** 层级*/
    private Short lvl;

    /** 顺序号*/
    private Short sortNo;

    /**诊断编码 */
    private String diCd;

    /** 诊断名称    输入手工录入的情景而预备的冗余字段,通常直接通过诊断编码获取 */
    private String diNm;

    /** icd编码 ，冗余 20140826确定 */
    private String icdCd;

    /**补充说明 */
    private String addDescr;

    /**主诊断标志 */
    private Short mainF;

    /** 待查/疑似    针对症状来说，待查与疑似标志互斥 0-待查  1-疑似  默认为null */
    private Short uncertainF;
    /** 默认为NULL
0  活动的：不一定是最新的
1 停用的又称为活动FLAG */
    private Short stopUseF;
	/**诊断医生编码 */
    private String diEmpId;

    /**诊断时间 */
    private Timestamp diTime;

	public Timestamp getDiTime() {
		return diTime;
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

	public String getEnSn() {
		return enSn;
	}

	public void setEnSn(String enSn) {
		this.enSn = enSn;
	}

	public Short getLvl() {
		return lvl;
	}

	public void setLvl(Short lvl) {
		this.lvl = lvl;
	}

	public Short getSortNo() {
		return sortNo;
	}

	public void setSortNo(Short sortNo) {
		this.sortNo = sortNo;
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

	public Short getUncertainF() {
		return uncertainF;
	}

	public void setUncertainF(Short uncertainF) {
		this.uncertainF = uncertainF;
	}

	public Short getStopUseF() {
		return stopUseF;
	}

	public void setStopUseF(Short stopUseF) {
		this.stopUseF = stopUseF;
	}



	public String getDiEmpId() {
		return diEmpId;
	}

	public void setDiEmpId(String diEmpId) {
		this.diEmpId = diEmpId;
	}


  
}