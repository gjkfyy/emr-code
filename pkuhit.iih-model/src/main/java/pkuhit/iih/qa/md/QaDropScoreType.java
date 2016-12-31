package pkuhit.iih.qa.md;

import xap.model.BaseMasterModel;

public class QaDropScoreType extends BaseMasterModel {

	public QaDropScoreType() {

		super();

	}

	public QaDropScoreType(String code) {

		super(code);

	}

	// 仅一次扣
	public static final String ONCE = "QAM02.01";
	// 可多次扣分
	public static final String MORE_THAN_ONCE = "QAM02.02";
	// 单否乙级
	public static final String GRADE_B = "QAM02.03";
	// 单否丙级
	public static final String GRADE_C = "QAM02.04";

}