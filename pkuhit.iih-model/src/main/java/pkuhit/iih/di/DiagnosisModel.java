package pkuhit.iih.di;

import java.sql.Timestamp;

/**
 * 诊断视图model
 */
public class DiagnosisModel {
	private String	 	diPk	;//	诊断主键
	private String	 	paId	;//	患者ID
	private Integer	 	enCnt	;//	就诊次数
	private String	 	paNm	;//	患者名称
	private String	 	enPk	;//	就诊主键
	private String	 	parDiPk	;//	父诊断主键
	private String	 	diCd	;//	诊断编码
	private String	 	diNm	;//	诊断名称
	private String	 	icdCd	;//	ICD编码
	private String	 	addInfo	;//	补充说明
	private String	 	mainF	;//	主诊断标志
	private String	 	uncF	;//	疑似标志
	private String	 	unkF	;//	待查标志
	private String	 	stopF	;//	停用标志
	private String	 	admMrDiF	;//	入院诊断标志
	private Timestamp	 	diTime	;//	诊断时间
	private String	 	diUserId	;//	诊断医生ID
	private String	 	diUserNm	;//	诊断医生名称
	private String	 	diDeptCd	;//	诊断科室编码
	private String	 	diDeptNm	;//	诊断科室名称
	private String	 	lvl1SortNo	;//	一级顺序号
	private String	 	lvl2SortNo	;//	二级顺序号
	private String		trtRstCd	;//	治疗结果编码 
	private String		trtRstNm	;//	治疗结果名称
	private String		diTpCd	;//	诊断类型编码
	private String		diTpNm	;//	诊断类型名称
	private String	 	longDiNm	;//	诊断名称+标志(疑似\待查）
	private int         typeNumber ; //针对住院，按诊断类型来排序号。入院诊断，出院诊断分别从1开始排序
	private int number ;//诊断选择序号
	
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getLongDiNm() {
		return longDiNm;
	}
	public void setLongDiNm(String longDiNm) {
		this.longDiNm = longDiNm;
	}
	public String getDiPk() {
		return diPk;
	}
	public void setDiPk(String diPk) {
		this.diPk = diPk;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public Integer getEnCnt() {
		return enCnt;
	}
	public void setEnCnt(Integer enCnt) {
		this.enCnt = enCnt;
	}
	public String getPaNm() {
		return paNm;
	}
	public void setPaNm(String paNm) {
		this.paNm = paNm;
	}
	public String getEnPk() {
		return enPk;
	}
	public void setEnPk(String enPk) {
		this.enPk = enPk;
	}
	public String getParDiPk() {
		return parDiPk;
	}
	public void setParDiPk(String parDiPk) {
		this.parDiPk = parDiPk;
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
	public String getAddInfo() {
		return addInfo;
	}
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}

	public Timestamp getDiTime() {
		return diTime;
	}
	public void setDiTime(Timestamp diTime) {
		this.diTime = diTime;
	}
	public String getDiUserId() {
		return diUserId;
	}
	public void setDiUserId(String diUserId) {
		this.diUserId = diUserId;
	}
	public String getDiUserNm() {
		return diUserNm;
	}
	public void setDiUserNm(String diUserNm) {
		this.diUserNm = diUserNm;
	}
	public String getDiDeptCd() {
		return diDeptCd;
	}
	public void setDiDeptCd(String diDeptCd) {
		this.diDeptCd = diDeptCd;
	}
	public String getDiDeptNm() {
		return diDeptNm;
	}
	public void setDiDeptNm(String diDeptNm) {
		this.diDeptNm = diDeptNm;
	}

	public String getMainF() {
		return mainF;
	}
	public void setMainF(String mainF) {
		this.mainF = mainF;
	}
	public String getUncF() {
		return uncF;
	}
	public void setUncF(String uncF) {
		this.uncF = uncF;
	}
	public String getUnkF() {
		return unkF;
	}
	public void setUnkF(String unkF) {
		this.unkF = unkF;
	}
	public String getStopF() {
		return stopF;
	}
	public void setStopF(String stopF) {
		this.stopF = stopF;
	}
	public String getAdmMrDiF() {
		return admMrDiF;
	}
	public void setAdmMrDiF(String admMrDiF) {
		this.admMrDiF = admMrDiF;
	}
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
	public String getTrtRstCd() {
		return trtRstCd;
	}
	public void setTrtRstCd(String trtRstCd) {
		this.trtRstCd = trtRstCd;
	}
	public String getTrtRstNm() {
		return trtRstNm;
	}
	public void setTrtRstNm(String trtRstNm) {
		this.trtRstNm = trtRstNm;
	}
	public String getDiTpCd() {
		return diTpCd;
	}
	public void setDiTpCd(String diTpCd) {
		this.diTpCd = diTpCd;
	}
	public String getDiTpNm() {
		return diTpNm;
	}
	public void setDiTpNm(String diTpNm) {
		this.diTpNm = diTpNm;
	}
	public int getTypeNumber() {
		return typeNumber;
	}
	public void setTypeNumber(int typeNumber) {
		this.typeNumber = typeNumber;
	}

}
