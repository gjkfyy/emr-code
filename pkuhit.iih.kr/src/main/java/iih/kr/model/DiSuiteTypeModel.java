package iih.kr.model;


/**
 * @author guo_zhongbao
 * 自定义分类model
 */
public class DiSuiteTypeModel {
	private String diSuiteTpCd ; //自定义分类编码
	private String diSuiteTpNm ;//自定义分类名称
	private String ownerTypeCd ; //所属类型编码
	private String ownerCd ; //所属编码
	private String ownerTypeName ;//所属类型名称
	private String ownerName;//所属编码对应的名称
	   
	private Integer sortNo ; //顺序号
	public String getDiSuiteTpCd() {
		return diSuiteTpCd;
	}
	public void setDiSuiteTpCd(String diSuiteTpCd) {
		this.diSuiteTpCd = diSuiteTpCd;
	}
	public String getDiSuiteTpNm() {
		return diSuiteTpNm;
	}
	public void setDiSuiteTpNm(String diSuiteTpNm) {
		this.diSuiteTpNm = diSuiteTpNm;
	}
	public String getOwnerTypeCd() {
		return ownerTypeCd;
	}
	public void setOwnerTypeCd(String ownerTypeCd) {
		this.ownerTypeCd = ownerTypeCd;
	}
	public String getOwnerCd() {
		return ownerCd;
	}
	public void setOwnerCd(String ownerCd) {
		this.ownerCd = ownerCd;
	}
	public Integer getSortNo() {
		return sortNo;
	}
	public void setSortNo(Integer sortNo) {
		this.sortNo = sortNo;
	}
	public String getOwnerTypeName() {
		return ownerTypeName;
	}
	public void setOwnerTypeName(String ownerTypeName) {
		this.ownerTypeName = ownerTypeName;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
}
