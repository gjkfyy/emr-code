package pkuhit.iih.iemr.qa;

import java.util.List;
import java.util.Map;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.en.EncounterService;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.qa.qasys.QaSystemQaItem;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

public class QaSystemItemServiceImpl implements QaSystemItemService {

	@Reference
	pkuhit.iih.mr.qasys.QaSystemItemService qaSysService;

//	@Reference
//	EncounterService enService;


	public QaSystemItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public QaSystemQaItem search(String id) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QaSystemQaItem> search(QaSystemQaItem condition)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.qasys.QaSystemItemService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<QaSystemQaItem> search(Map condition) throws Throwable {
		// 就诊编码 *
		String enPk = condition.get("enPk").toString();
//		SingleResult<EncounterModel> encounterDetail = enService
//				.getEncounterDetail(enPk);
//		String enTpCd = encounterDetail.getData().getEnTpCd();
		condition.remove("enPk");
		// TODO FIXME lideqiang 通过就诊编码获得就诊类型：门诊/急诊/住院
		String enTpCd = EncounterType.INPATIENT;
		condition.put("enTpCd", enTpCd);
		ArrayResult<QaSystemQaItem> search = qaSysService
				.searchByCond(condition);
		return search;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
