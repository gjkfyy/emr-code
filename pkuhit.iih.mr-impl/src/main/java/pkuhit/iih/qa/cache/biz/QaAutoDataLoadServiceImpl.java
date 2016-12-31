
package pkuhit.iih.qa.cache.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoEventService;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
/**
 * 该类用于缓存数据的准备：获取整个科室的一定数量的患者的文书和事件
 * @deprecated
 * @author wang_yanli
 *
 */
public class QaAutoDataLoadServiceImpl  implements QaAutoDataLoadService{
	
	@Autowired
	CusQaAutoDao cusQaAutoDao;

	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	QaAutoEventService qaAutoEventService;

	public QaAutoDataLoadServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Map<String,List<QaAutoModel>> searchQaAutoMrList(Map map)
			throws Throwable {
		
		List<MrAmr>  mrAmrList =  selectQaAutoCacheMrAmr(map);
		//准备的数据存入map容器
		Map<String,List<QaAutoModel>>  qaAutoMrModelsMap = new HashMap<String,List<QaAutoModel>>();
		if(null != mrAmrList){
			for(MrAmr mrAmr:mrAmrList){
				String enPk = mrAmr.getEnPk();
				List<Map<String, Object>> qaAutoMrList = cusQaAutoDao.selectQaMr("1",	"1", "1",enPk);
				List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
				// 查询结果转换为qaAutoModel的list
				qaAutoMrModelList = convertQaAutoMapToModel(qaAutoMrList);
				qaAutoMrModelsMap.put(enPk, qaAutoMrModelList);
			}
		}
		return qaAutoMrModelsMap;
	}
	
	@Override
	public Map<String,List<EmrEventModel>>  searchQaAutoEventList(Map map)
			throws Throwable {
		
			List<MrAmr>  mrAmrList =  selectQaAutoCacheMrAmr(map);
		    //准备的数据存入map容器
			Map<String,List<EmrEventModel>>  qaAutoEmrEventModelsMap = new HashMap<String,List<EmrEventModel>>();
			if(null != mrAmrList){
			for(MrAmr mrAmr:mrAmrList){
				String enPk = mrAmr.getEnPk();
				ArrayResult<EmrEventModel> EmrEventResult = qaAutoEventService.getEventTypeList(enPk);
				EmrEventModel[] emrEventModelArray = EmrEventResult.getDataList();
			
				if(null!=emrEventModelArray){
					qaAutoEmrEventModelsMap.put(enPk, Arrays.asList(emrEventModelArray));
				}
			}
		}
		return qaAutoEmrEventModelsMap;
	}
	
	public List<MrAmr> selectQaAutoCacheMrAmr(Map map){
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "15";
		}
		Session session = Session.get();
		String curDeptId = session.getDeptId();//科室
		String statusStr = AmrStatus.WRITE_STARTED;//书写已开始（环节质控）
		
		
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<MrAmr>  mrAmrList = cusQaAutoDao.selectQaAutoCacheMrAmr(statusStr, curDeptId, options);//.selectQaProcessAuto(statusStr,curDeptNm,amrNo ,patientName, currentManageDoctorName,options);
	
		return mrAmrList;
	}
	
	private List<QaAutoModel> convertQaAutoMapToModel(
			List<Map<String, Object>> qaAutoMrList) {
		List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
		if (null != qaAutoMrList) {
			if (qaAutoMrList.size() > 0) {
				Map<String, Object> mapQaAutoMr = null;
				for (int i = 0; i < qaAutoMrList.size(); i++) {
					QaAutoModel qaAutoModel = new QaAutoModel();
					mapQaAutoMr = qaAutoMrList.get(i);
					BeanCopyUtil.mapToModel(qaAutoModel, mapQaAutoMr,
							dictionaryService);
					qaAutoMrModelList.add(qaAutoModel);
				}
			}
		}
		return qaAutoMrModelList;
	}

	
	
}
