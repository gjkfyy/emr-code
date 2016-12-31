package pkuhit.iih.mr.tpl;

import java.io.Serializable;

@SuppressWarnings("serial")
public class GETreeData implements Serializable {
	/**
	 * 院区编码
	 */
	private String hisOrgCode;
	
	/**
	 * 院区名称
	 */
	private String hisOrgName;
	
	/**
	 * 所属类型编码
	 */
	private String ownerTypeCode;
	
	/**
	 * 所属类型名称
	 */
	private String ownerTypeName;
	
	/**
	 * 所属编码
	 */
	private String ownerCode;
	
	/**
	 * 所属名称
	 */
	private String ownerName;
	
	/**
	 * 医疗记录组合元素的自定义分类编码
	 */
	private String customCategoryCode;
	
	/**
	 * 医疗记录组合元素的自定义分类名称
	 */
	private String customCategoryName;
	/**
	 * 医疗记录组合元素编码
	 */
	private String code;
	/**
	 * 医疗记录组合元素名称
	 */
	private String name;
	/**
	 * 节点类型
	 */
	private String nodeType;
	
	private String filePk ;
	
	/**
	 * 
	 */
	private Integer counter;
	
	public String getHisOrgCode() {
		return hisOrgCode;
	}
	public void setHisOrgCode(String hisOrgCode) {
		this.hisOrgCode = hisOrgCode;
	}
	public String getHisOrgName() {
		return hisOrgName;
	}
	public void setHisOrgName(String hisOrgName) {
		this.hisOrgName = hisOrgName;
	}
	public String getOwnerTypeCode() {
		return ownerTypeCode;
	}
	public void setOwnerTypeCode(String ownerTypeCode) {
		this.ownerTypeCode = ownerTypeCode;
	}
	public String getOwnerTypeName() {
		return ownerTypeName;
	}
	public void setOwnerTypeName(String ownerTypeName) {
		this.ownerTypeName = ownerTypeName;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getCustomCategoryCode() {
		return customCategoryCode;
	}
	public void setCustomCategoryCode(String customCategoryCode) {
		this.customCategoryCode = customCategoryCode;
	}
	public String getCustomCategoryName() {
		return customCategoryName;
	}
	public void setCustomCategoryName(String customCategoryName) {
		this.customCategoryName = customCategoryName;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNodeType() {
		return nodeType;
	}
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public Integer getCounter() {
		return counter;
	}
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	public String getFilePk() {
		return filePk;
	}
	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}
	
}
