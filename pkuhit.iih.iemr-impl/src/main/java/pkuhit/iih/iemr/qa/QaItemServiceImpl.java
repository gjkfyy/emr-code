package pkuhit.iih.iemr.qa;

import java.util.Map;

import pkuhit.iih.en.EncounterService;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.qa.old.QaNItem;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;

public class QaItemServiceImpl implements QaItemService {

	@Reference
	pkuhit.iih.mr.qasys.QaItemService  qaItemService;//qaSysService;

//	@Reference
//	EncounterService enService;


	public QaItemServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.qasys.QaItemService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<QaNItem> search(Map condition) throws Throwable {
		// 就诊编码 *
		String enPk = condition.get("enPk").toString();
		condition.remove("enPk");
		// TODO FIXME lideqiang 通过就诊编码获得就诊类型：门诊/急诊/住院
		String enTpCd = EncounterType.INPATIENT;
		condition.put("enTpCd", enTpCd);
		ArrayResult<QaNItem> search = qaItemService
				.searchByCond(condition);
		return search;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
