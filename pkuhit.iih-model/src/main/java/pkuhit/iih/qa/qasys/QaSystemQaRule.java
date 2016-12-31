package pkuhit.iih.qa.qasys;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaSystemQaRule extends BaseRelationModel {
 public QaSystemQaRule(){
  super();
 }
 public QaSystemQaRule(String code){
  super(code);
 }
// 质控体系质控规则编码
public static final   String  CODE = "QAK06.AT01";
// 质控体系质控项目编码
public static final   String  QA_SYSTEM_ITEM_CODE = "QAK06.AT02";
// 规则编码
public static final   String  RULE_CODE = "QAK06.AT03";

// 质控体系质控规则编码
@Column(name="QA_SYS_RULE_CD") 
private  String code;
// 质控体系质控项目编码
@Column(name="QA_SYS_ITM_CD") 
private  String qaSystemItemCode;
// 规则编码
@Column(name="RULE_CD") 
private  String ruleCode;
public String getCode()
 {
     return this.code;
 }
public  void  setCode(String code)
 {
  this.code = code;
 }
public String getQaSystemItemCode()
 {
     return this.qaSystemItemCode;
 }
public  void  setQaSystemItemCode(String qaSystemItemCode)
 {
  this.qaSystemItemCode = qaSystemItemCode;
 }
public String getRuleCode()
 {
     return this.ruleCode;
 }
public  void  setRuleCode(String ruleCode)
 {
  this.ruleCode = ruleCode;
 }

}