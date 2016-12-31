package pkuhit.iih.mr.wr;

public class MrSplFmValue {
	private String key;
	private String value;
	private String fmName;
	private Integer fmType;//1中医特色内容、2总评分
	
	public String getFmName() {
		return fmName;
	}
	public void setFmName(String fmName) {
		this.fmName = fmName;
	}
	public Integer getFmType() {
		return fmType;
	}
	public void setFmType(Integer fmType) {
		this.fmType = fmType;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
