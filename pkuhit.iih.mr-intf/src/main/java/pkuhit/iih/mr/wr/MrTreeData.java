package pkuhit.iih.mr.wr;

/**
 * 病历文书记录导航树节点数据对象
 * @author wu.junhui
 *
 */
public class MrTreeData {
	/**
	 * 就诊编号
	 */
	private String encounterCode;
	
	/**
	 * 病历文书自定义分类编码
	 */
	private String custCategoryCode;
	/**
	 * 病历文书自定义分类名称
	 */
	private String custCategoryName;
	
	/**
	 * 病历文书编码(PK)
	 */
	private String code;
	
	/**
	 * 病历文书名称
	 */
	private String name;
	
	/**
	 * 节点类型
	 * 1: 病历文书自定义分类节点
	 * 2: 病历文书节点
	 */
	private String nodeType;
	
	/**
	 * 叶子节点统计数
	 */
	private Integer counter;

	/**
	 * @return the custCategoryCode
	 */
	public String getCustCategoryCode() {
		return custCategoryCode;
	}

	/**
	 * @param custCategoryCode the custCategoryCode to set
	 */
	public void setCustCategoryCode(String custCategoryCode) {
		this.custCategoryCode = custCategoryCode;
	}

	/**
	 * @return the custCategoryName
	 */
	public String getCustCategoryName() {
		return custCategoryName;
	}

	/**
	 * @param custCategoryName the custCategoryName to set
	 */
	public void setCustCategoryName(String custCategoryName) {
		this.custCategoryName = custCategoryName;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nodeType
	 */
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * @param nodeType the nodeType to set
	 */
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	/**
	 * @return the counter
	 */
	public Integer getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	/**
	 * @return the encounterCode
	 */
	public String getEncounterCode() {
		return encounterCode;
	}

	/**
	 * @param encounterCode the encounterCode to set
	 */
	public void setEncounterCode(String encounterCode) {
		this.encounterCode = encounterCode;
	}
}
