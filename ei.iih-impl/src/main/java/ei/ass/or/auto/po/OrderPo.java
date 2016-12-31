package ei.ass.or.auto.po;

import java.sql.Timestamp;

import org.seasar.doma.Entity;

/**
 * @author guo_zhongbao
 * 医嘱持久化对象
 */
@Entity
public class OrderPo {

	private String		orPk	;//	医嘱主键
	private String		paId	;//	患者ID
	private String		enCnt	;//	就诊次数
	private String		paNm	;//	患者名称
	private String		enPk	;//	就诊主键
	private String		orPresPk	;//	处方主键
	private String		svCd	;//	服务编码
	private String		svNm	;//	服务名称
	private String		orStaCd	;//	医嘱状态编码
	private String		orStaNm	;//	医嘱状态名称
	private String		longOrF	;//	长期临时医嘱标志
	private String		longOrNm	;//	长期临时医嘱名称
	private String		orTpCd	;//	医嘱类型编码
	private String		orTpNm	;//	医嘱类型名称
	private String		freqCd	;//	执行频率编码
	private String		freqNm	;//	执行频率名称
	private String		routeCd	;//	用药途径编码
	private String		routeNm	;//	用药途径名称
	private String		spec	;//	规格
	private String		dosage	;//	剂量
	private String		dosageUnitNm	;//	剂量单位名称
	private String		amount	;//	数量
	private String		takeAmount	;//	领量
	private String		takeAmountUnitNm	;//	领量单位名称   
	private String		crtDosage	;//	开立剂数
	private String		boilDosage	;//	代煎剂数
	private String		boilTpNm	;//	煎煮方式名称
	private String		persistDays;//  天数 
	private String		insruGrdCd	;//	医保分级编码
	private String		insruGrdNm	;//	医保分级名称
	private String		selfF	;//	自付标志
	private String		selfNm	;//	自符名称
	private String		indicationF	;//	适应症标志
	private String		indicationNm	;//	适应症名称
	private String		preventF	;//	预防用药标志
	private String		preventNm	;//	预防用药名称
	private String		skinTestF	;//	皮试标志
	private String		skinTestNm	;//	皮试名称
	private String		inHospF	;//	在院执行标志
	private String		inHospNm	;//	在院执行名称
	private String		orNoteNm	;//	嘱托描述
	private String		parOrPk	;//	父医嘱主键
	private String		sortNo	;//	顺序号
	private Timestamp		orStdTime	;//	医嘱开始时间
	private Timestamp		orStpTime	;//	医嘱停止时间
	private Timestamp		crtTime	;//	医嘱下达时间
	private String		orCrtDctCd	;//	医嘱开立医生编码
	private String		orCrtDctNm	;//	医嘱开立医生名称
	private String		orCrtDeptCd	;//	医嘱开立科室编码
	private String		orCrtDeptNm	;//	医嘱开立科室名称
	
	private String groupFlag;  //组
	
	
	
	public Timestamp getCrtTime() {
		return crtTime;
	}
	public void setCrtTime(Timestamp crtTime) {
		this.crtTime = crtTime;
	}
	public String getPersistDays() {
		return persistDays;
	}
	public void setPersistDays(String persistDays) {
		this.persistDays = persistDays;
	}
	public String getGroupFlag() {
		return groupFlag;
	}
	public void setGroupFlag(String groupFlag) {
		this.groupFlag = groupFlag;
	}
	public String getOrPk() {
		return orPk;
	}
	public void setOrPk(String orPk) {
		this.orPk = orPk;
	}
	public String getPaId() {
		return paId;
	}
	public void setPaId(String paId) {
		this.paId = paId;
	}
	public String getEnCnt() {
		return enCnt;
	}
	public void setEnCnt(String enCnt) {
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
	public String getOrPresPk() {
		return orPresPk;
	}
	public void setOrPresPk(String orPresPk) {
		this.orPresPk = orPresPk;
	}
	public String getSvCd() {
		return svCd;
	}
	public void setSvCd(String svCd) {
		this.svCd = svCd;
	}
	public String getSvNm() {
		return svNm;
	}
	public void setSvNm(String svNm) {
		this.svNm = svNm;
	}
	public String getOrStaCd() {
		return orStaCd;
	}
	public void setOrStaCd(String orStaCd) {
		this.orStaCd = orStaCd;
	}
	public String getOrStaNm() {
		return orStaNm;
	}
	public void setOrStaNm(String orStaNm) {
		this.orStaNm = orStaNm;
	}
	public String getLongOrF() {
		return longOrF;
	}
	public void setLongOrF(String longOrF) {
		this.longOrF = longOrF;
	}
	public String getLongOrNm() {
		return longOrNm;
	}
	public void setLongOrNm(String longOrNm) {
		this.longOrNm = longOrNm;
	}
	public String getOrTpCd() {
		return orTpCd;
	}
	public void setOrTpCd(String orTpCd) {
		this.orTpCd = orTpCd;
	}
	public String getOrTpNm() {
		return orTpNm;
	}
	public void setOrTpNm(String orTpNm) {
		this.orTpNm = orTpNm;
	}
	public String getFreqCd() {
		return freqCd;
	}
	public void setFreqCd(String freqCd) {
		this.freqCd = freqCd;
	}
	public String getFreqNm() {
		return freqNm;
	}
	public void setFreqNm(String freqNm) {
		this.freqNm = freqNm;
	}
	public String getRouteCd() {
		return routeCd;
	}
	public void setRouteCd(String routeCd) {
		this.routeCd = routeCd;
	}
	public String getRouteNm() {
		return routeNm;
	}
	public void setRouteNm(String routeNm) {
		this.routeNm = routeNm;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getDosageUnitNm() {
		return dosageUnitNm;
	}
	public void setDosageUnitNm(String dosageUnitNm) {
		this.dosageUnitNm = dosageUnitNm;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTakeAmount() {
		return takeAmount;
	}
	public void setTakeAmount(String takeAmount) {
		this.takeAmount = takeAmount;
	}
	public String getTakeAmountUnitNm() {
		return takeAmountUnitNm;
	}
	public void setTakeAmountUnitNm(String takeAmountUnitNm) {
		this.takeAmountUnitNm = takeAmountUnitNm;
	}
	public String getCrtDosage() {
		return crtDosage;
	}
	public void setCrtDosage(String crtDosage) {
		this.crtDosage = crtDosage;
	}
	public String getBoilDosage() {
		return boilDosage;
	}
	public void setBoilDosage(String boilDosage) {
		this.boilDosage = boilDosage;
	}
	public String getBoilTpNm() {
		return boilTpNm;
	}
	public void setBoilTpNm(String boilTpNm) {
		this.boilTpNm = boilTpNm;
	}
	public String getInsruGrdCd() {
		return insruGrdCd;
	}
	public void setInsruGrdCd(String insruGrdCd) {
		this.insruGrdCd = insruGrdCd;
	}
	public String getInsruGrdNm() {
		return insruGrdNm;
	}
	public void setInsruGrdNm(String insruGrdNm) {
		this.insruGrdNm = insruGrdNm;
	}
	public String getSelfF() {
		return selfF;
	}
	public void setSelfF(String selfF) {
		this.selfF = selfF;
	}
	public String getSelfNm() {
		return selfNm;
	}
	public void setSelfNm(String selfNm) {
		this.selfNm = selfNm;
	}
	public String getIndicationF() {
		return indicationF;
	}
	public void setIndicationF(String indicationF) {
		this.indicationF = indicationF;
	}
	public String getIndicationNm() {
		return indicationNm;
	}
	public void setIndicationNm(String indicationNm) {
		this.indicationNm = indicationNm;
	}
	public String getPreventF() {
		return preventF;
	}
	public void setPreventF(String preventF) {
		this.preventF = preventF;
	}
	public String getPreventNm() {
		return preventNm;
	}
	public void setPreventNm(String preventNm) {
		this.preventNm = preventNm;
	}
	public String getSkinTestF() {
		return skinTestF;
	}
	public void setSkinTestF(String skinTestF) {
		this.skinTestF = skinTestF;
	}
	public String getSkinTestNm() {
		return skinTestNm;
	}
	public void setSkinTestNm(String skinTestNm) {
		this.skinTestNm = skinTestNm;
	}
	public String getInHospF() {
		return inHospF;
	}
	public void setInHospF(String inHospF) {
		this.inHospF = inHospF;
	}
	public String getInHospNm() {
		return inHospNm;
	}
	public void setInHospNm(String inHospNm) {
		this.inHospNm = inHospNm;
	}
	public String getOrNoteNm() {
		return orNoteNm;
	}
	public void setOrNoteNm(String orNoteNm) {
		this.orNoteNm = orNoteNm;
	}
	public String getParOrPk() {
		return parOrPk;
	}
	public void setParOrPk(String parOrPk) {
		this.parOrPk = parOrPk;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	public Timestamp getOrStdTime() {
		return orStdTime;
	}
	public void setOrStdTime(Timestamp orStdTime) {
		this.orStdTime = orStdTime;
	}
	public Timestamp getOrStpTime() {
		return orStpTime;
	}
	public void setOrStpTime(Timestamp orStpTime) {
		this.orStpTime = orStpTime;
	}
	public String getOrCrtDctCd() {
		return orCrtDctCd;
	}
	public void setOrCrtDctCd(String orCrtDctCd) {
		this.orCrtDctCd = orCrtDctCd;
	}
	public String getOrCrtDctNm() {
		return orCrtDctNm;
	}
	public void setOrCrtDctNm(String orCrtDctNm) {
		this.orCrtDctNm = orCrtDctNm;
	}
	public String getOrCrtDeptCd() {
		return orCrtDeptCd;
	}
	public void setOrCrtDeptCd(String orCrtDeptCd) {
		this.orCrtDeptCd = orCrtDeptCd;
	}
	public String getOrCrtDeptNm() {
		return orCrtDeptNm;
	}
	public void setOrCrtDeptNm(String orCrtDeptNm) {
		this.orCrtDeptNm = orCrtDeptNm;
	}

	

}
