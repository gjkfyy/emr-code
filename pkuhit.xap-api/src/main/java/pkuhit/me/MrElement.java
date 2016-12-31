package pkuhit.me;

/**
 * 病历数据元对象
 * @author wu.junhui
 *
 */
public class MrElement {
	/**
	 * 数据元素编码
	 */
	private String objAttrCd;
	
	/**
	 * 数据元素名称
	 */
	private String objAttrNm;
	
	/**
	 * 值域对象编码
	 */
	private String fkObjCd;
	
	/**
	 * 描述
	 */
	private String des;
	
	/**
	 * 数据对象编码
	 */
	private String objCd;
	
	/**
	 * 数据对象名称
	 */
	private String objNm;

	/**
	 * @return the objAttrCd
	 */
	public String getObjAttrCd() {
		return objAttrCd;
	}

	/**
	 * @param objAttrCd the objAttrCd to set
	 */
	public void setObjAttrCd(String objAttrCd) {
		this.objAttrCd = objAttrCd;
	}

	/**
	 * @return the objAttrNm
	 */
	public String getObjAttrNm() {
		return objAttrNm;
	}

	/**
	 * @param objAttrNm the objAttrNm to set
	 */
	public void setObjAttrNm(String objAttrNm) {
		this.objAttrNm = objAttrNm;
	}

	/**
	 * @return the objCd
	 */
	public String getObjCd() {
		return objCd;
	}

	/**
	 * @param objCd the objCd to set
	 */
	public void setObjCd(String objCd) {
		this.objCd = objCd;
	}

	/**
	 * @return the objNm
	 */
	public String getObjNm() {
		return objNm;
	}

	/**
	 * @param objNm the objNm to set
	 */
	public void setObjNm(String objNm) {
		this.objNm = objNm;
	}

	/**
	 * @return the fkObjCd
	 */
	public String getFkObjCd() {
		return fkObjCd;
	}

	/**
	 * @param fkObjCd the fkObjCd to set
	 */
	public void setFkObjCd(String fkObjCd) {
		this.fkObjCd = fkObjCd;
	}

	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}
	
}
