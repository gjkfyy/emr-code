package pkuhit.iih.qa;
import java.sql.Timestamp;

import xap.model.BaseBizModel;

/**
 * 
 * @author wang_yanli
 * 自动质控校验model
 */public class QaValidateMsgModel extends BaseBizModel {
 public QaValidateMsgModel(){
  super();
 }
 public QaValidateMsgModel(String code){
  super(code);
 }
 
 
 private  String   msgName;
 
 private  String[]   msgAttr;

public String getMsgName() {
	return msgName;
}

public void setMsgName(String msgName) {
	this.msgName = msgName;
}

public String[] getMsgAttr() {
	return msgAttr;
}

public void setMsgAttr(String[] msgAttr) {
	this.msgAttr = msgAttr;
}

 
}