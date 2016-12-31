package pkuhit.iih.qa.qaauto.validator.baseValidator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.util.QaAutoUtil;

public class BaseTimeBound extends BaseValidator{
	
	/**
	 * 验证：事件时间（eg：入院时间）+ 限制时间 compare 当前系统时间
	 * @param amr 
	 * @param deadHours
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateCurrentAndEventTime(List<EmrEventModel> emrEventList, String eventTypeCode,int deadHours ,QaValidateMsgModel msgModel)
			throws Exception {

		QaValidateModel qaValidateModel = new QaValidateModel(); 
		
		//根据当前质控项的事件类型从事件List中得到该事件发生的事件
		Timestamp eventTime = null;
		eventTime = getEventTime(emrEventList, eventTypeCode);
		//系统当前时间
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());

		qaValidateModel = valideTime(eventTime, currentTimeTs, deadHours,msgModel);
		if(qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam) && !eventTypeCode.equals("01")){
			qaValidateModel.setValidateResult(true);
		}
		qaValidateModel.setBizTime(eventTime);//业务时间
		return qaValidateModel;
	
	}

	/**
	 * 验证：入科时间（入院时间）+ 限制时间 compare 当前系统时间
	 * @param amr 
	 * @param deadHours
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateCurrentAndDeptIntoTime1( Amr amr,int deadHours ,QaValidateMsgModel msgModel)
			throws Exception {

		QaValidateModel qaValidateModel = new QaValidateModel(); 
		
		//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
		Date curDeptIntoTimeDt = null;
		Timestamp curDeptIntoTime = null;
		//系统当前时间
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		if(null != amr && null != amr.getCurrentDeptIntoTime()){
			curDeptIntoTimeDt = amr.getCurrentDeptIntoTime();//入科时间
			curDeptIntoTime = new Timestamp(curDeptIntoTimeDt.getTime());
		}
		
		qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, currentTimeTs, deadHours,msgModel);
		
		return qaValidateModel;
	
	}
	
	
	/**
	 * 验证：文书列表中是否存在该mrTypeCode类型文书（该方法已经移到父类中，在此不再使用和维护）
	 * @param qaAutoMrModelList 
	 * @param mrTypeCode --2015520修改 该变量是一个文书类型编码的字符串集合 A:B:C
	 * @param msgModel 
	 * @deprecated
	 * @return
	 * @throws Exception
	 */
	/*public QaValidateModel validateHaveTypeMr(List<QaAutoModel> qaAutoMrModelList, String mrTypeCodes,QaValidateMsgModel msgModel)throws Exception{
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		List<QaAutoModel> qaAutoHaveTypeMrList = new ArrayList<QaAutoModel>();
		Map<String,List> tempMrMap = new HashMap();
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		String[] mrTypeArray = mrTypeCodes.split(",");
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(QaAutoModel qaAutoModel: qaAutoMrModelList){
				for(String mrTypeCode:mrTypeArray){
					if(qaAutoModel.getTypeCode().equals(mrTypeCode)){ //初次
						resultValue = true;
						qaAutoHaveTypeMrList.add(qaAutoModel);
						//break;
					}
				}
				
			}
			
		}
		tempMrMap.put(mrTypeCodes, qaAutoHaveTypeMrList);
		qaValidateModel.setTempResultMap(tempMrMap);
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
		
	}*/
	
	/**
	 * 验证：判断已有文书是否符合时限性要求
	 * mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
	 * @param qaAutoMrModelList 
	 * @param mrTypeCode
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateMrList(List<EmrEventModel> emrEventList, String eventTypeCode,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode,String mrOpType,  int deadHours, QaValidateMsgModel msgModel )throws Exception {
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		Timestamp eventTime =  getEventTime(emrEventList,eventTypeCode);
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(QaAutoModel qaAutoModel: qaAutoMrModelList){
				//判断时间
				Date subDate = null;
				Timestamp subDateTs = null; 
				if(mrOpType.equals("01")){
					subDate = qaAutoModel.getLogicSubmitTime();
				}else if(mrOpType.equals("02")){
					subDateTs = qaAutoModel.getMastDoctorDate();//.getLogicSubmitTime();
				}
						
				
				if(null != subDate){
					subDateTs = new Timestamp(subDate.getTime());
				}
				qaValidateModel = valideTime(eventTime, subDateTs, deadHours,msgModel);
				qaValidateModel.setCompleteTime(subDateTs);
				//以下操作表示：如果有记录符合校验，则校验通过，即：在所有需要校验的文书中，如果有一个文书符合要求，即为本校验通过（文书之间校验为【或】的关系）
				if(qaValidateModel.isValidateResult()){
					break;
				}
			}
		}
		//qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	//待修改
	public QaValidateModel validateUnWriteMr(List<QaAutoModel> qaAutoMrModelList, Amr amr,String mrTypeCode, int deadHours, QaValidateMsgModel msgModel ) 
			throws Exception{
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		
		if(null != amr && null != amr.getCurrentDeptIntoTime()){
			
			Date curDeptIntoTimeDt = amr.getCurrentDeptIntoTime();//入科时间
			Timestamp curDeptIntoTime = null;
			
			if(null != curDeptIntoTimeDt){
				curDeptIntoTime = new Timestamp(curDeptIntoTimeDt.getTime());
			}

			if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
				for(QaAutoModel qaAutoModel: qaAutoMrModelList){
					//1=判断有无入院记录
					if(!qaAutoModel.getTypeCode().equals(mrTypeCode)){ 
						qaValidateModel.setValidateType(QaValidateModel.vaNoRecord);
						qaValidateModel.setValidateMessage(msgModel.getMsgAttr()[0]+"未创建");
						continue;
					}
					
					//2=判断时间
					
					Date subDate = qaAutoModel.getLogicSubmitTime();
					if(null != subDate){
						resultValue = true;
						qaValidateModel.setValidateType(QaValidateModel.vaCorrect);
						break;
					}
					//只对没有提交时间的进行提醒
					qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
					if(!qaValidateModel.isValidateResult()){
						if(qaValidateModel.getValidateType().equals(QaValidateModel.vaFault)){
							qaValidateModel.setValidateMessage(msgModel.getMsgAttr()[0]+"逾期未提交");
						}else if(qaValidateModel.getValidateType().equals(QaValidateModel.vaCorrect)){
							qaValidateModel.setValidateMessage("请及时提交"+msgModel.getMsgAttr()[0]);
						}else if(qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam)){
							qaValidateModel.setValidateMessage("入科时间为空");
						}
						
						break;
					}
					//如果程序可以走到这说明，需校验的条件都满足书写要求，故置resultValue=true
					resultValue = true;
					break;
					
				}
				if(null!=qaValidateModel.getValidateType() && qaValidateModel.getValidateType().equals(QaValidateModel.vaNoRecord)){
					qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
				}else{
					
					qaValidateModel.setValidateResult(resultValue);
				}
			}else{
				qaValidateModel.setValidateType(QaValidateModel.vaNoRecord);
				qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
			}
			
		}else{
			qaValidateModel.setValidateResult(false);
			qaValidateModel.setValidateType(QaValidateModel.vaNoParam);
			qaValidateModel.setValidateMessage("入科时间为空");
		}
		return qaValidateModel;
		
	}
	
/*	public List searchResultList(DataModel dataModel,String searchKey)
			throws Exception{
		SearchResult<QaAutoModel> searchResult =  (SearchResult<QaAutoModel>) dataModel.getSearchResult(searchKey);
		List<QaAutoModel> qaAutoMrModelList = searchResult.getResultList();
		return null;
	}*/
}
