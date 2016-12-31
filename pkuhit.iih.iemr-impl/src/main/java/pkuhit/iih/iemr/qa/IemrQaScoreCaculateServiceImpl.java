/**
 * <p>文件名:		IemrQaScoreCaculateServiceImpl.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.qa;

import java.util.HashMap;
import java.util.Map;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.pub.MrConfigCode;
import pkuhit.iih.qa.MrQaScoreCaculateService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.cfg.ConfigItemData;
import pkuhit.xap.cfg.ConfigItemDataService;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;

/**
 * <p>
 * IemrQaScoreCaculateServiceImpl
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年12月23日 下午5:21:15</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class IemrQaScoreCaculateServiceImpl implements
		IemrQaScoreCaculateService {

//	@Reference
//	pkuhit.iih.en.EncounterService encounterService;

/*	@Reference
	MrQaScoreCaculateService scoreService;*/

	@Reference
	ConfigItemDataService configItemDataService;

	/**
	 * 构造器
	 */
	public IemrQaScoreCaculateServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SingleResult<Map> score(String enPk) throws Exception {
		// TODO FIXME lideqiang 通过就诊编码获得就诊类型：门诊/急诊/住院
		// SingleResult<EncounterModel> encounter = encounterService
		// .getEncounterDetail(enPk);
		//
		// String enTypeCode = encounter.getData().getEnTpCd();
		String enTypeCode = EncounterType.INPATIENT;
		// 调用接口查找质控体系编码
		// String qaSysCode = "SZLH.QAK01.01.01";
		String qaSysCode = getQaSystemCode();
		return null;//scoreService.score(enPk, enTypeCode, qaSysCode);
	}

	private String getQaSystemCode() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		String qaSystemCode = "";
		Map<String, String> params = new HashMap<String, String>();
		params.put("orgCode", orgCd);
		params.put("configCode", MrConfigCode.QA_SYSTEM_CODE);
		SingleResult<ConfigItemData> config = null;
		config = configItemDataService.search(params);
//		qaSystemCode = config.getData().getConfigCode();
		qaSystemCode = config.getData().getValue();
		return qaSystemCode;
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
