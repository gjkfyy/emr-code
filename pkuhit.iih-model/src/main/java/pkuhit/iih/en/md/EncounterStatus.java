package pkuhit.iih.en.md;

import xap.model.BaseMasterModel;


public class EncounterStatus extends BaseMasterModel {

 public EncounterStatus(){

  super();

 }

 public EncounterStatus(String code){

  super(code);

 }

public static final String   OBJ_CD  = "ENM02";

// 已注册(挂号、住院登记)
public static final String registed = "ENM02.01";
// 已接诊
public static final String  receipted= "ENM02.02";
// 挂起
public static final String suspended = "ENM02.03";
// 完成（诊毕、已预出院）
public static final String completed = "ENM02.04";
// 已取消
public static final String  abort = "ENM02.05";
// 已结算
public static final String closed  = "ENM02.06";



}