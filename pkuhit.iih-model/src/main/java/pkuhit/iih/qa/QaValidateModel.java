package pkuhit.iih.qa;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import xap.model.BaseBizModel;

/**
 * 
 * @author wang_yanli
 * 自动质控校验model
 */public class QaValidateModel extends BaseBizModel {
 public QaValidateModel(){
  super();
 }
 public QaValidateModel(String code){
  super(code);
 }
 public static final String vaNoRecord = "v001";
 public static final String vaNoParam = "v002";
 public static final String vaFault = "v003";
 public static final String vaCorrect = "v004";
 public static final String vaMesgCorrect = "v005";
 
 private  boolean  validateResult;
 
 private  String   validateMessage;
 
 private  Timestamp  deadDate;
 
 private  String  surplusTime;
 
 private String mrType;
 
 private String qaItem;
 
 private Timestamp completeTime; //文书完成时间（校验对比的文书中对应字段时间）
 
 private Timestamp bizTime; //业务时间：事件发生的时间
 
 private String memo; //完整性 所需说明
 
 private Map<String,List> tempResultMap;
 
 
 

public Timestamp getCompleteTime() {
	return completeTime;
}

public void setCompleteTime(Timestamp completeTime) {
	this.completeTime = completeTime;
}

public String getValidateType() {
	return validateType;
}

public void setValidateType(String validateType) {
	this.validateType = validateType;
}
private  String validateType;

public boolean isValidateResult() {
	return validateResult;
}

public void setValidateResult(boolean validateResult) {
	this.validateResult = validateResult;
}

public String getValidateMessage() {
	return validateMessage;
}

public void setValidateMessage(String validateMessage) {
	this.validateMessage = validateMessage;
}

public Timestamp getDeadDate() {
	return deadDate;
}

public void setDeadDate(Timestamp deadDate) {
	this.deadDate = deadDate;
}

public String getSurplusTime() {
	return surplusTime;
}

public void setSurplusTime(String surplusTime) {
	this.surplusTime = surplusTime;
}

public String getMrType() {
	return mrType;
}

public void setMrType(String mrType) {
	this.mrType = mrType;
}

public String getQaItem() {
	return qaItem;
}

public void setQaItem(String qaItem) {
	this.qaItem = qaItem;
}

public Map<String, List> getTempResultMap() {
	return tempResultMap;
}

public void setTempResultMap(Map<String, List> tempResultMap) {
	this.tempResultMap = tempResultMap;
}

public Timestamp getBizTime() {
	return bizTime;
}

public void setBizTime(Timestamp bizTime) {
	this.bizTime = bizTime;
}

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}
 
 
}