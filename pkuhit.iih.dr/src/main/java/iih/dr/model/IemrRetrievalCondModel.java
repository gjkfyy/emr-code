package iih.dr.model;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

public class IemrRetrievalCondModel extends BaseBizModel{

	public IemrRetrievalCondModel(){
		 super();
	}

	public IemrRetrievalCondModel(String code){
		 super(code);
	}
	 
	 public static final String   OBJ_CD  = "DRM02";
	 
	 	@Column(name = "COND_CD")
	    String condCd;

	    @Column(name = "RETRIEVAL_CD")
	    String retrievalCd;

	    @Column(name = "COND_NAME")
	    String conditionName;

	    /** 01-并且，02-或者 */
	    @Column(name = "REL_TYPE")
	    String relationType;

	    /** 01-简单条件、02-组合条件、03-表达式 */
	    @Column(name = "COND_TYPE")
	    String conditionType;

	    /** xml表达式，可以存储病历文书类型、节点信息（如关联的数据源、节点类型等）等数据 */
	    @Column(name = "OBJ_CODE")
	    String objectCode;

	    @Column(name = "OBJ_NAME")
	    String objectName;

	    /** >、<、=等逻辑关系 */
	    @Column(name = "LOGIC")
	    String logicSymbolCode;

	    /** 约束对象 */
	    @Column(name = "VAL_NAME")
	    String constraintObject;

	    /** 约束值域 */
	    @Column(name = "VAL_CODE")
	    String constraintDomain;
	    
	    /** 条件级次 */
	    @Column(name = "GRADE")
	    Short grade;
	    
	    /** 上级条件 */
	    @Column(name = "UPCOND")
	    String upcond;

	    /** 按照节点层次描述 */
	    @Column(name = "FULL_PATH")
	    String elemPath;

	    @Column(name = "DES")
	    String des;

	    @Column(name = "COND_NO")
	    Short condNo;

	    @Column(name = "MEMO")
	    String memo;
	    
	    private String mrPk;
	    private String docType;

		private String id;// 与text对应的id
		private String text ;//显示名称
		private Boolean leaf;//是否叶子节点
		private Boolean expanded;//是否展开
//		private String nodeType;//节点类型
//		private Boolean checked; //默认选中
		
		public String getCondCd() {
			return condCd;
		}

		public void setCondCd(String condCd) {
			this.condCd = condCd;
		}

		public String getRetrievalCd() {
			return retrievalCd;
		}

		public void setRetrievalCd(String retrievalCd) {
			this.retrievalCd = retrievalCd;
		}

		public String getConditionName() {
			return conditionName;
		}

		public void setConditionName(String conditionName) {
			this.conditionName = conditionName;
		}

		public String getRelationType() {
			return relationType;
		}

		public void setRelationType(String relationType) {
			this.relationType = relationType;
		}

		public String getConditionType() {
			return conditionType;
		}

		public void setConditionType(String conditionType) {
			this.conditionType = conditionType;
		}

		public String getObjectCode() {
			return objectCode;
		}

		public void setObjectCode(String objectCode) {
			this.objectCode = objectCode;
		}

		public String getObjectName() {
			return objectName;
		}

		public void setObjectName(String objectName) {
			this.objectName = objectName;
		}

		public String getLogicSymbolCode() {
			return logicSymbolCode;
		}

		public void setLogicSymbolCode(String logicSymbolCode) {
			this.logicSymbolCode = logicSymbolCode;
		}

		public String getConstraintObject() {
			return constraintObject;
		}

		public void setConstraintObject(String constraintObject) {
			this.constraintObject = constraintObject;
		}

		public String getConstraintDomain() {
			return constraintDomain;
		}

		public void setConstraintDomain(String constraintDomain) {
			this.constraintDomain = constraintDomain;
		}

		public Short getGrade() {
			return grade;
		}

		public void setGrade(Short grade) {
			this.grade = grade;
		}

		public String getUpcond() {
			return upcond;
		}

		public void setUpcond(String upcond) {
			this.upcond = upcond;
		}

		public String getElemPath() {
			return elemPath;
		}

		public void setElemPath(String elemPath) {
			this.elemPath = elemPath;
		}

		public String getDes() {
			return des;
		}

		public void setDes(String des) {
			this.des = des;
		}

		public Short getCondNo() {
			return condNo;
		}

		public void setCondNo(Short condNo) {
			this.condNo = condNo;
		}

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Boolean getLeaf() {
			return leaf;
		}

		public void setLeaf(Boolean leaf) {
			this.leaf = leaf;
		}

		public Boolean getExpanded() {
			return expanded;
		}

		public void setExpanded(Boolean expanded) {
			this.expanded = expanded;
		}

		public String getMrPk() {
			return mrPk;
		}

		public void setMrPk(String mrPk) {
			this.mrPk = mrPk;
		}

		public String getDocType() {
			return docType;
		}

		public void setDocType(String docType) {
			this.docType = docType;
		}

}