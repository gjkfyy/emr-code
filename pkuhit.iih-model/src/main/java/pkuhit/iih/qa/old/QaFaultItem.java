package pkuhit.iih.qa.old;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseRelationModel;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class QaFaultItem extends BaseRelationModel {
 public QaFaultItem(){
  super();
 }
 public QaFaultItem(String code){
  super(code);
 }

public static final String   OBJ_CD  = "QAB04";// 质控记录_缺陷项目主键
public static final   String  PK = "QAB04.AT01";
// 质控主键
public static final   String  QA_PK = "QAB04.AT02";
// 缺陷主键
public static final   String  QA_FAULT_PK = "QAB04.AT03";

// 质控记录_缺陷项目主键
@Column(name="QA_FLT_ITM_PK") 
private  String pk;
// 质控主键
@Column(name="QA_PK") 
private  String qaPk;
// 缺陷主键
@Column(name="QA_FLT_PK") 
private  String qaFaultPk;

//缺陷主键
@Column(name="ACTIVE_F") 
private  short activeF;
public String getPk()
 {
     return this.pk;
 }
public  void  setPk(String pk)
 {
  this.pk = pk;
 }
public String getQaPk()
 {
     return this.qaPk;
 }
public  void  setQaPk(String qaPk)
 {
  this.qaPk = qaPk;
 }
public String getQaFaultPk()
 {
     return this.qaFaultPk;
 }
public  void  setQaFaultPk(String qaFaultPk)
 {
  this.qaFaultPk = qaFaultPk;
 }

public short getActiveF() {
	return activeF;
}

public void setActiveF(short activeF) {
	this.activeF = activeF;
}
}