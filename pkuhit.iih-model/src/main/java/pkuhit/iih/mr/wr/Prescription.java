package pkuhit.iih.mr.wr;

import java.util.Date;

import xap.model.BaseBizModel;

public class Prescription extends BaseBizModel {

	public Prescription() {

		super();

	}

	public Prescription(String code) {

		super(code);

	}

	private String name;
	private String flag;
	private String specifDosage;
	private Date enterDate;
	private String frename;
	private String supply;
	private String comment;
	private String specification;
	private String chargeGroup;
	private String drugAmount;
	private String diagnosis;
	private String parentOrderSn;
	private String orderSn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getSpecifDosage() {
		return specifDosage;
	}

	public void setSpecifDosage(String specifDosage) {
		this.specifDosage = specifDosage;
	}

	public Date getEnterDate() {
		return enterDate;
	}

	public void setEnterDate(Date enterDate) {
		this.enterDate = enterDate;
	}

	public String getFrename() {
		return frename;
	}

	public void setFrename(String frename) {
		this.frename = frename;
	}

	public String getSupply() {
		return supply;
	}

	public void setSupply(String supply) {
		this.supply = supply;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getChargeGroup() {
		return chargeGroup;
	}

	public void setChargeGroup(String chargeGroup) {
		this.chargeGroup = chargeGroup;
	}

	public String getDrugAmount() {
		return drugAmount;
	}

	public void setDrugAmount(String drugAmount) {
		this.drugAmount = drugAmount;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getParentOrderSn() {
		return parentOrderSn;
	}

	public void setParentOrderSn(String parentOrderSn) {
		this.parentOrderSn = parentOrderSn;
	}

	public String getOrderSn() {
		return orderSn;
	}

	public void setOrderSn(String orderSn) {
		this.orderSn = orderSn;
	}
}