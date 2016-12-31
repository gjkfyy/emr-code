package pkuhit.iih.mr.md;

/**
 * @author guo_zhongbao
 *  链接元素  从表保存对象
 */
public class MetaElementSaveModel {
	private String dataElementValueCd;//value主键
   private String dataElementCd; //主表code
   private String valueCode; //code码
   private String valueDisplay;//显示值
   private String memo;
public String getDataElementCd() {
	return dataElementCd;
}
public void setDataElementCd(String dataElementCd) {
	this.dataElementCd = dataElementCd;
}
public String getValueCode() {
	return valueCode;
}
public void setValueCode(String valueCode) {
	this.valueCode = valueCode;
}
public String getValueDisplay() {
	return valueDisplay;
}
public void setValueDisplay(String valueDisplay) {
	this.valueDisplay = valueDisplay;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public String getDataElementValueCd() {
	return dataElementValueCd;
}
public void setDataElementValueCd(String dataElementValueCd) {
	this.dataElementValueCd = dataElementValueCd;
}
   
}
