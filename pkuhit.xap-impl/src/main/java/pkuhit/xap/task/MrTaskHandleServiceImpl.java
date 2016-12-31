package pkuhit.xap.task;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.wr.MedicalRecord;
import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.dao.custom.CutomXapMrTaskDao;
import pkuhit.xap.ru.RuleEnginService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.RuleEngin;
import xap.sv.annotation.Reference;
import xap.sv.event.listener.EventListener;
import xap.sv.event.object.EventObject;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

  
public  class MrTaskHandleServiceImpl implements EventListener{
  
/*	@Autowired
	XapTaskDao xapTaskDao;*/
	
	@Autowired
	CutomXapMrTaskDao cutomXapMrTaskDao;
	
	@Autowired
	XapTaskDao xapTaskDao;
	
	@Reference
	DictionaryService  dictionaryService;
	
	@Reference
	RuleEngin ruleEngin;
	
	@Reference
	RuleEnginService ruleEnginService;

	public void callBack(EventObject arg0) {
		// TODO Auto-generated method stub
		Map<String,Object> map = (Map<String,Object>)arg0.getSource();
		try {
			taskRuleHandler(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Override
	public void taskRuleHandler(Map<String,Object> map) throws Exception{
		if(null != map && map.size() > 0){
			for (String key : map.keySet()){
				MedicalRecord medicalRecord = new MedicalRecord();
				String mrTypeCode = "";
				String enPk = "";
				String mrPk = "";
				Date completeTime = null;
				String status = "";
				String docSn = "";
				Map conditionMap = new HashMap();
				
				medicalRecord = (MedicalRecord)map.get(key);
				mrTypeCode = medicalRecord.getTypeCode();
				enPk = medicalRecord.getEncounterPk();
				mrPk = medicalRecord.getMrPk();
				conditionMap.put("enPk", enPk);
				conditionMap.put("mrTypeCode", mrTypeCode);
				ArrayResult xapTaskList = searchXapTask(conditionMap);
				//根据事件编码，判断对文书的操作，如果为创建、撤销，则读出文书保存时间，如果为提交，读出文书提交时间,如果为删除，则状态改为待处理
				if(key.equals("CREATE_MR")||key.equals("REVOKE_MR")){
					completeTime = 	medicalRecord.getCreateTime();
					status = XapTaskModel.DEALING;//处理中
					
				}else if(key.equals("SUBMIT_MR")){
					completeTime = medicalRecord.getSubmitDate();
					status = XapTaskModel.DEALED;//完成
				}else if(key.equals("DELETE_MR")){
					status = XapTaskModel.UNDEAL;//完成
					completeTime = null;
					mrPk = "";
				}
				XapTaskModel[] xapTaskModelArray = (XapTaskModel[])xapTaskList.getDataList();
				if(null != xapTaskModelArray && xapTaskModelArray.length>0){
					for(XapTaskModel xapTaskModel:xapTaskModelArray){
						xapTaskModel.setCompleteTime(completeTime);
						xapTaskModel.setStatus(status);
						xapTaskModel.setDocSn(mrPk);
					}
					updateTask(xapTaskModelArray);
				}
				
				
			}
				
		}
		}
	//查询事件类型
		public ArrayResult<XapTaskModel> searchXapTask(Map condition)
				throws Exception {
			String enPk = "";
			String mrTypeCode = "";
			if(null != condition){
				enPk = (String)condition.get("enPk");
				
				mrTypeCode = (String)condition.get("mrTypeCode");
			}
			ArrayResultBuilder<XapTaskModel> arrayBuilder = ArrayResultBuilder.newArrayResult(XapTaskModel.class);
			List<Map<String, Object>> xapTaskModelList = null;
			Map<String, Object> mapXapTask = null;
			
			xapTaskModelList = cutomXapMrTaskDao.searchTasksByCondition(enPk,mrTypeCode);
			if(null != xapTaskModelList && xapTaskModelList.size()>0){
				
				XapTaskModel[] xapTaskModelArray = new XapTaskModel[xapTaskModelList.size()];
				for(int i=0;i<xapTaskModelList.size();i++){
					XapTaskModel xapTaskModel = new XapTaskModel();
					mapXapTask = xapTaskModelList.get(i);
					BeanCopyUtil.mapToModel(xapTaskModel, mapXapTask,dictionaryService);
					xapTaskModelArray[i] = xapTaskModel;
				}
				if(xapTaskModelArray!=null){
					arrayBuilder.withData(xapTaskModelArray);
				}
				
			}
			ArrayResult<XapTaskModel> xapTaskResult = arrayBuilder.build();
			return xapTaskResult;
		}
	public void updateTask(XapTaskModel[] xapTaskModels){
		if (xapTaskModels != null) {
			for (XapTaskModel xapTaskModel : xapTaskModels) {
				XapTask xapTask = new XapTask();
				BeanCopyUtil.modelToEntity(xapTask, xapTaskModel);
				if(xapTask.getCompleteTime() == null){
					xapTaskDao.update(xapTask);
				}else{
					xapTaskDao.updateExcludeNull(xapTask);
				}
			}
		}
	}
	
	public Timestamp converDateToTimestamp(Date arg){
		Timestamp result = null;
		if(arg != null){
			result = new Timestamp(arg.getTime());
		}
		return result;
	}
	
	public String converDateToString(Date arg){
		String result = "";
		if(arg != null){
			result = Long.toString(arg.getTime());
		}
		return result;
	}
}
