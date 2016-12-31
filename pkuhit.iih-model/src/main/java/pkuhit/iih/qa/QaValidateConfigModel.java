package pkuhit.iih.qa;
import java.sql.Timestamp;

import xap.model.BaseBizModel;

/**
 * 
 * @author wang_yanli
 * 自动质控校验model
 */public class QaValidateConfigModel extends BaseBizModel {
 public QaValidateConfigModel(){
  super();
 }
 public QaValidateConfigModel(String code){
  super(code);
 }
 
	// 质控项目编码
	private String itemCode;

	// 文件类型
	private String mrType;

	// 事件类型
	private String eventTypeCode;
	
	private int  deadHours;
	
	private String useFlag;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getMrType() {
		return mrType;
	}

	public void setMrType(String mrType) {
		this.mrType = mrType;
	}

	public String getEventTypeCode() {
		return eventTypeCode;
	}

	public void setEventTypeCode(String eventTypeCode) {
		this.eventTypeCode = eventTypeCode;
	}


	public int getDeadHours() {
		return deadHours;
	}

	public void setDeadHours(int deadHours) {
		this.deadHours = deadHours;
	}

	public String getUseFlag() {
		return useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}
	
	
 
}