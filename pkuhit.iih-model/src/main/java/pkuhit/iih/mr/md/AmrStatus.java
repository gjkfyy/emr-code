package pkuhit.iih.mr.md;

import xap.model.BaseMasterModel;

public class AmrStatus extends BaseMasterModel {

	public AmrStatus() {

		super();

	}

	public AmrStatus(String code) {

		super(code);

	}

	/*// 书写已开始
	public static final String WRITE_STARTED = "MRM03.01";
	// 书写已完成
	public static final String WRITE_COMPLETED = "MRM03.02";
	// 已开始质控
	public static final String QA_STARTED = "MRM03.03";
	// 已完成质控
	public static final String QA_COMPLETED = "MRM03.04";
	// 已归档
	public static final String ARCHIVED = "MRM03.05";*/
	
	// 书写
	public static final String WRITE_STARTED= "MRM22.01";
	// 书写完成
	public static final String WRITE_COMPLETED = "MRM22.02";
	// 已科室质控
	public static final String QA_DEPT = "MRM22.03";
	// 已科室评分
	public static final String QA_DEPT_SCORED = "MRM22.04";
	// 已签收
	public static final String QA_STARTED = "MRM22.05";
	// 已终末质控
	public static final String QA_COMPLETED = "MRM22.06";
	// 已终末质控评分
	public static final String QA_SCORED = "MRM22.08";
	// 已归档
	public static final String ARCHIVED = "MRM22.07";
	
	
		
}