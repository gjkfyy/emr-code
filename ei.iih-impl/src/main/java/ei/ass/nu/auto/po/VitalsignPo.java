package ei.ass.nu.auto.po;

import org.seasar.doma.Entity;

/**
 * 生命体征
 * */
@Entity
public class VitalsignPo {
	private String	 	vitalSignPk	;//	体征记录主键
	private String	 	enPk	;//	就诊主键
	private String	 	paId	;//	患者ID
	private String	 	enCnt	;//	就诊次数
	private String	 	paNm	;//	患者名称
	private String	 	temper	;//	体温
	private String	 	weight	;//	体重
	private String	 	heartRate	;//	心率
	private String	 	pulse	;//	脉搏
	private String	 	breathe	;//	呼吸
	private String	 	bldOxygen	;//	血氧
	private String	 	systolicPress	;//	收缩压
	private String	 	diastolicPress	;//	舒张压
	private String	 	acquisitionDate	;//	采集日期
	private String      circumference;//腹围
	private String      bldSugar;//血糖
	private String	 	normalStool	;//	大便
	private String	 	normalPiss	;//	小便
	private String	 	intakeSum	;//	入水量
	private String	 	outtakeSum	;//	出水量
	private String	 	height	;//	身高
	private String	 	drugAllergic	;//	药物过敏
	
	public String getCircumference() {
		return circumference;
	}
	public void setCircumference(String circumference) {
		this.circumference = circumference;
	}
	public String getBldSugar() {
		return bldSugar;
	}
	public void setBldSugar(String bldSugar) {
		this.bldSugar = bldSugar;
	}
	public String getVitalSignPk() {
		return vitalSignPk;
	}
	public void setVitalSignPk(String vitalSignPk) {
		this.vitalSignPk = vitalSignPk;
	}
	public String getEnPk() {
		return enPk;
	}
	public void setEnPk(String enPk) {
		this.enPk = enPk;
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
	public String getTemper() {
		return temper;
	}
	public void setTemper(String temper) {
		this.temper = temper;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}
	public String getPulse() {
		return pulse;
	}
	public void setPulse(String pulse) {
		this.pulse = pulse;
	}
	public String getBreathe() {
		return breathe;
	}
	public void setBreathe(String breathe) {
		this.breathe = breathe;
	}
	public String getBldOxygen() {
		return bldOxygen;
	}
	public void setBldOxygen(String bldOxygen) {
		this.bldOxygen = bldOxygen;
	}
	public String getSystolicPress() {
		return systolicPress;
	}
	public void setSystolicPress(String systolicPress) {
		this.systolicPress = systolicPress;
	}
	public String getDiastolicPress() {
		return diastolicPress;
	}
	public void setDiastolicPress(String diastolicPress) {
		this.diastolicPress = diastolicPress;
	}
	public String getAcquisitionDate() {
		return acquisitionDate;
	}
	public void setAcquisitionDate(String acquisitionDate) {
		this.acquisitionDate = acquisitionDate;
	}
	public String getNormalStool() {
		return normalStool;
	}
	public void setNormalStool(String normalStool) {
		this.normalStool = normalStool;
	}
	public String getNormalPiss() {
		return normalPiss;
	}
	public void setNormalPiss(String normalPiss) {
		this.normalPiss = normalPiss;
	}
	public String getIntakeSum() {
		return intakeSum;
	}
	public void setIntakeSum(String intakeSum) {
		this.intakeSum = intakeSum;
	}
	public String getOuttakeSum() {
		return outtakeSum;
	}
	public void setOuttakeSum(String outtakeSum) {
		this.outtakeSum = outtakeSum;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDrugAllergic() {
		return drugAllergic;
	}
	public void setDrugAllergic(String drugAllergic) {
		this.drugAllergic = drugAllergic;
	}

}
