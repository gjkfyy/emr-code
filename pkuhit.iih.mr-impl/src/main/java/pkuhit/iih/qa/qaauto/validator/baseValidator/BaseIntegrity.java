package pkuhit.iih.qa.qaauto.validator.baseValidator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserService;
import xap.sv.annotation.Reference;

public class BaseIntegrity extends BaseValidator{
	
	@Reference
	UserService userService;
	
	/**
	 * 验证：判断已有文书是否符合完整性规则
	 * @param qaAutoMrModelList 
	 * @param jobTitleCd
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	
	public QaValidateModel validateMrList(Map<String, List> eventTimeMap, String eventTypeCode,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode,String jobTitleCd, QaValidateMsgModel msgModel )throws Exception {
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		Timestamp startTime = null;
		Timestamp endTime = null;

		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		//索要校验的多个事件，需循环
		for(String key:eventTimeMap.keySet()){
			List<EmrEventModel> eventList = eventTimeMap.get(key);
			//每个事件可能有多条记录
			for(EmrEventModel emrEvent : eventList){
				//系统当前时间
				startTime = emrEvent.getHappentime();//事件发生的时间
				endTime = emrEvent.getEndtime()!=null ? emrEvent.getEndtime():currentTimeTs;//事件结束的时间,如果没有结束时间，则取当前系统时间为结束时间
				//获得起止时间段内的实际文书数
				int actualMrCount = haveMrCount(startTime, endTime, qaAutoMrModelList,mrTypeCode, jobTitleCd);
				//起止时间之间的天数
				if(actualMrCount == 1){
					resultValue = true;
				}else if(actualMrCount == 2){
					qaValidateModel.setMemo("缺少该份文书");
					resultValue = false;
					break;
				}else if(actualMrCount == 3){
					qaValidateModel.setMemo("缺少该份文书");
					resultValue = false;
					break;
				}else{
					resultValue = false;
					break;
				}
			}
		}
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	//本方法用于判断某个时间段内，符合条件的文书
	public int haveMrCount(Timestamp startTime, Timestamp endTime,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode,String jobTitleCd){
		int count = 0;
		if(null!= qaAutoMrModelList && qaAutoMrModelList.size()>0){
			for(QaAutoModel qaAuto:qaAutoMrModelList){
				Date subDate = qaAuto.getLogicSubmitTime();
				String TypeCode = qaAuto.getTypeCode();
				Timestamp subDateTs = null;
				if(null != subDate && null != startTime && null != endTime && TypeCode.equals(mrTypeCode)){
					subDateTs = new Timestamp(subDate.getTime());
					if(subDateTs.compareTo(startTime)>=0 && subDateTs.compareTo(endTime)<=0){
						String superiorDoctorId = qaAuto.getSuperiorDoctorId();
						User user = userService.selectUserById(superiorDoctorId).getData();
						String jobTitleCdDoc = user.getJobTitleCode();
						if(jobTitleCd.contains(jobTitleCdDoc)){
							count=1;
							break;
						}else{
							count=2;
						}
						
					}else{
						count=3;
					}
				}
			}
		}
		return count;
	}
}
