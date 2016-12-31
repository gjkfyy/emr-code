package pkuhit.xap.task.ruleHandler.baseValidator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;

public class BaseValidator {

	/**
	 * 本校验只判断 comparedTime + deadHours 与 compareTime的大小，截止时间离系统的当前时间需要另外的校验进行
	 * @param comparedTime
	 * @param compareTime
	 * @param deadHours
	 * @param msgModel
	 * @author wang_yanli
	 * @return
	 */
	public static QaValidateModel valideTime(Timestamp comparedTime,Timestamp compareTime, int deadHours ,QaValidateMsgModel msgModel){
		
		QaValidateModel qaValidateModel = new QaValidateModel();
		boolean resultValue = true;
		
		if(null == comparedTime){
			 resultValue = false;
			 qaValidateModel.setValidateType(QaValidateModel.vaNoParam);//参数为空
			 qaValidateModel.setValidateMessage(msgModel.getMsgName()+msgModel.getMsgAttr()[0]+"时间为空");
		}else if(null == compareTime){
			 resultValue = false;
			 qaValidateModel.setValidateType(QaValidateModel.vaNoParam);//参数为空
			 qaValidateModel.setValidateMessage(msgModel.getMsgName()+msgModel.getMsgAttr()[0]+"时间为空");
		}else{
			Date deadLineDate = null;//QaUtil.dateIncreaseByHours(comparedTime,deadHours);
			Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
			qaValidateModel.setDeadDate(deadLineDateTs);
			if(deadLineDateTs.compareTo(compareTime)<1){
				resultValue = false;
				qaValidateModel.setValidateType(QaValidateModel.vaFault);//校验结果为false
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"XX超时");
			}else{
				resultValue = true;
				qaValidateModel.setValidateType(QaValidateModel.vaCorrect);//校验结果为true
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"截止时间为"+deadLineDateTs);
			}
		}
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	/**
	 * 本方法往已有的qaValidateModel中添加surplusTime值，获得该值得规则为：comparedTime+deadHours 与当前系统时间比较，差值为剩余时间即surplusTime
	 * @param qaValidateModel
	 * @param comparedTime
	 * @param deadHours
	 * @author wang_yanli
	 */
	public void addSurplusTime(QaValidateModel qaValidateModel,Timestamp comparedTime, int deadHours){

		//系统当前时间
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		String  surplusTime = "";
		Date deadLineDate = null;//QaUtil.dateIncreaseByHours(comparedTime,deadHours);
		Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
		qaValidateModel.setDeadDate(deadLineDateTs);
		//计算当前时间与截止时间的差，结果为H:M
		int[] diffDays = null;//QaUtil.getTimeDifference(deadLineDateTs, currentTimeTs);
		//surplusTime = QaUtil.formatSurplusTime(diffDays,"H:M");
		qaValidateModel.setSurplusTime(surplusTime);
		/*if(deadLineDateTs.compareTo(currentTimeTs)<1){
			resultValue = false;
			//qaValidateModel.setValidateType(QaValidateModel.vaFault);//校验结果为false
			qaValidateModel.setValidateType(QaValidateModel.vaMesgCorrect);//校验结果为true
			qaValidateModel.setValidateMessage(msgModel.getMsgName()+"XX超时");
		}else{
			resultValue = true;
			//qaValidateModel.setValidateType(QaValidateModel.vaCorrect);//校验结果为true
			qaValidateModel.setValidateType(QaValidateModel.vaMesgCorrect);//校验结果为true
			qaValidateModel.setValidateMessage(msgModel.getMsgName()+"截止时间为"+deadLineDateTs);
		}*/
		
	
	}
	
	/**
	 * 验证：获得事件时间,事件可能为多个eg：03,10 所以需要循环事件列表，内部循环匹配具体事件，匹配成功一个事件，则跳出，不再匹配，加载的事件列表，排序为hanppentime升序排序
	 * @param amr 
	 * @param deadHours
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public Timestamp getEventTime(List<EmrEventModel> emrEventList, String eventTypeCodes)
			throws Exception {

		
		Timestamp eventTime = null;
		String[] eventTypeCodeArray = eventTypeCodes.split(",");
		if(null != emrEventList){
			for(EmrEventModel emrEventModel:emrEventList){
				String eventType = emrEventModel.getEventtype();
				for(String eventTypeCode:eventTypeCodeArray){
					if(eventType.equals(eventTypeCode)){
						eventTime = emrEventModel.getHappentime();
						break;
					}
				}
				if(null != eventTime){
					break;
				}
				
			}
		}
		
		return eventTime;
	
	}
	
	/**
	 * 验证：获得事件时间,事件可能为多个eg：03,10 所以需要循环事件列表，将符合条件的事件存入map容器，key=事件编码，value=符合条件的事件记录List
	 * @param amr 
	 * @param deadHours
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public Map<String, List> getEventTimeMap(List<EmrEventModel> emrEventList, String eventTypeCodes)
			throws Exception {

		//声明一个Map事件编码作为key，事件编码对应的记录集合作为value
		Map<String, List> eventTimeMap = new HashMap<String, List>();
		
		String[] eventTypeCodeArray = eventTypeCodes.split(",");
		if(null != emrEventList){
			for(EmrEventModel emrEventModel:emrEventList){
				String eventType = emrEventModel.getEventtype();
				List<EmrEventModel> eventTimeList = new ArrayList<EmrEventModel>();
				//如果map中存在此【事件编码】key，则直接将新的事件记录存入对应的value中
				if(eventTimeMap.containsKey(eventType)){
					eventTimeList = eventTimeMap.get(eventType);
					eventTimeList.add(emrEventModel);
				}else{
					for(String eventTypeCode:eventTypeCodeArray){
						if(eventType.equals(eventTypeCode)){
							eventTimeList.add(emrEventModel);
							break;
						}
					}
					if(eventTimeList.size()>0){
						eventTimeMap.put(eventType, eventTimeList);
					}
				}
			}
		}
		
		return eventTimeMap;
	
	}
	
	/**
	 * 验证：文书列表中是否存在该mrTypeCode类型文书
	 * @param qaAutoMrModelList 
	 * @param mrTypeCode --2015624修改 该变量是一个文书类型编码的字符串集合 A:B:C
	 * @param msgModel 
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateHaveTypeMr(List<QaAutoModel> qaAutoMrModelList, String mrTypeCodes,QaValidateMsgModel msgModel)throws Exception{
		
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
		
	}
}
