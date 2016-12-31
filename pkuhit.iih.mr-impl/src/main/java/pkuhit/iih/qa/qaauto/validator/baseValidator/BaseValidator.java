package pkuhit.iih.qa.qaauto.validator.baseValidator;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.util.QaUtil;

public class BaseValidator {
	private Logger log = LoggerFactory.getLogger(BaseValidator.class);
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
			Date deadLineDate = QaUtil.dateIncreaseByHours(comparedTime,
					deadHours);
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
		Date deadLineDate = QaUtil.dateIncreaseByHours(comparedTime,
				deadHours);
		Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
		qaValidateModel.setDeadDate(deadLineDateTs);
		//计算当前时间与截止时间的差，结果为H:M
		int[] diffDays = QaUtil.getTimeDifference(deadLineDateTs, currentTimeTs);
		surplusTime = QaUtil.formatSurplusTime(diffDays,"H:M");
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
		if(null != eventTypeCodes){
			log.debug("eventTypeCodes is |"+ eventTypeCodes + "|");
		}
		String[] eventTypeCodeArray = eventTypeCodes.split(",");
		if(null != eventTypeCodeArray){
			//log.debug("null != eventTypeCodeArray");
			log.debug("eventTypeCodeArray.length is |"+eventTypeCodeArray.length +"|");
		}
		if(null != emrEventList){
			log.debug("null != emrEventList");
			if(emrEventList.isEmpty()){
				log.info("emrEventList.isEmpty()");
			}else{
				log.debug("emrEventList.size is " + emrEventList.size());
				for(EmrEventModel emrEventModel:emrEventList){
					String eventType = emrEventModel.getEventtype();
					log.debug("  event_id is "+emrEventModel.getEventid() +",eventType is |"+ eventType+"|");
					for(String eventTypeCode:eventTypeCodeArray){
						log.debug("eventTypeCode is |"+ eventTypeCode+"|");
						if(eventType.equals(eventTypeCode)){
							eventTime = emrEventModel.getHappentime();
							log.debug("equal,break");
							break;
						}
					}
					if(null != eventTime){
						log.debug("break");
						break;
					}
				}
			//	log.info("no equal ");
			}
		}else{
			log.info("null == emrEventList");
		}
		if(null != eventTime){
			log.debug("return-value  is not null");
		}else{
			log.info("return-value  is null");
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
	
	/**
	 * 验证：文书列表中的文书类型与需验证的mrTypeCodes类型匹配，找出文书列表中缺的文书
	 * @param qaAutoMrModelList 
	 * @param mrTypeCode --20160706修改 该变量是一个文书类型编码的字符串集合 A:B:C
	 * @param msgModel 
	 * @return 返回所有缺的文书类型
	 * @throws Exception
	 */
	public static QaValidateModel validateNotHaveMrType(List<QaAutoModel> qaAutoMrModelList, List<String> mrTypeCodeList,QaValidateMsgModel msgModel)throws Exception{
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		Map<String,List> tempMrMap = new HashMap();
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(int i=0;i<qaAutoMrModelList.size();i++){
				QaAutoModel qaAutoModel = qaAutoMrModelList.get(i);
				for(int j=0;j<mrTypeCodeList.size();j++ ){
					String mrTypeCode = mrTypeCodeList.get(j);
					//如果文书列表中存在
					if(qaAutoModel.getTypeCode().equals(mrTypeCode)){ 
						mrTypeCodeList.remove(j);
						j--;
						break;//跳出本层循环
					}
					
				}
				
			}
			
		}
		if(mrTypeCodeList.size()== 0){
			resultValue = true;
		}
		tempMrMap.put("mrTypeCodeList", mrTypeCodeList);
		qaValidateModel.setTempResultMap(tempMrMap);
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
		
	}
}
