package pkuhit.iih.pub;

public interface MrConfigCode {
	//质控体系编码
	public final String QA_SYSTEM_CODE = "XAPM08.01";
	//需要换页处理的病历文书类型
	public final String NEW_PAGE_MR_TYPE = "XAPM08.03";
	//需要续打的病历文书类型
	public final String COUNTINUE_PRINT_MR_TYPE = "XAPM08.04";
	//病历文书需要创建仅且创建一份的病历文书类型
	public final String ONLY_ONE_MR_TYPE = "XAPM08.05";
}
