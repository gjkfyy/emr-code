package pkuhit.iih.qa.qaauto.validator.baseValidator;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.EmrEventModel;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.util.DateUtil;
import pkuhit.iih.qa.util.QaUtil;
import xap.ru.engin.item.ItemEvent;

public class BaseFrequency extends BaseValidator{
	
	/**
	 * 验证：判断已有文书是否符合频率性要求
	 * @param qaAutoMrModelList 
	 * @param mrTypeCode
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateMrList(Map<String, List> eventTimeMap, String eventTypeCode,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode,String qaRlTpCd,  String qaRlCd, QaValidateMsgModel msgModel )throws Exception {
		//将频率规则字符串转换为整形
		int qaRlValue = (qaRlCd != null && !qaRlCd.equals(""))?Integer.parseInt(qaRlCd):0; 
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
				//如果重复性频率，则如下实现
				if(qaRlTpCd != null && qaRlValue != 0 && qaRlTpCd.equals("01")){
					endTime = emrEvent.getEndtime()!=null ? emrEvent.getEndtime():currentTimeTs;//事件结束的时间,如果没有结束时间，则取当前系统时间为结束时间

					//获得起止时间段内的实际文书数
					int actualMrCount = haveMrCount(startTime, endTime, qaAutoMrModelList, mrTypeCode);
					//起止时间之间的天数
					int diffDays = QaUtil.getTimeDifference(endTime, startTime)[0]/24; 
					//计算出应有的文书数
					int calCount = diffDays/qaRlValue;
					
					if(actualMrCount<calCount){
						resultValue = false;
						break;
					}
				//如果连续性频率，则如下实现
				}else if(qaRlTpCd != null && qaRlValue != 0 && qaRlTpCd.equals("02")){
					if(null != startTime){
						Date endDate = QaUtil.dateIncreaseByDays(startTime, qaRlValue-1);
						Timestamp endTimeTemp = new Timestamp(endDate.getTime());
						endTime = endTimeTemp.compareTo(currentTimeTs) == -1 ? endTimeTemp : currentTimeTs;//如果截止时间大于当前时间，则当前时间作为截止时间
					}
					//获得起止时间段内的文书数
					Map<String,Object> actualMrMap = haveContinuousMrCount(startTime, endTime, qaAutoMrModelList, mrTypeCode,qaRlValue);
					if(actualMrMap != null && actualMrMap.size()>0){
						Iterator<Map.Entry<String, Object>> it = actualMrMap.entrySet().iterator();  
				        //遍历结果集，如果有某天没有文书，即value==0，则校验结果为false
						while(it.hasNext()){  
				            Map.Entry<String, Object> entry=it.next();  
				            String datekey=entry.getKey();
				            int value = Integer.parseInt(actualMrMap.get(datekey).toString());
				            if(value == 0){
				            	resultValue = false;
								break;
				            }else{
				            	resultValue = true;
				            }
				        }
						if(resultValue == false){
							break;
						}
					}else{
						resultValue = false;
						break;
					}
				}
				
				//如果能走到这里则说明结果都符合要求，设置校验结果为true
				resultValue = true;
			}
			//如果内层循环结果为false，则外层不用再循环，直接跳出
			if(!resultValue){
				break;
			}
		}
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	//本方法用于判断某个时间段内，符合条件的文书个数
	public int haveMrCount(Timestamp startTime, Timestamp endTime,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode){
		int count = 0;
		if(null!= qaAutoMrModelList && qaAutoMrModelList.size()>0){
			for(QaAutoModel qaAuto:qaAutoMrModelList){
				Date subDate = qaAuto.getLogicSubmitTime();
				String TypeCode = qaAuto.getTypeCode();
				Timestamp subDateTs = null;
				if(null != subDate && null != startTime && null != endTime && TypeCode.equals(mrTypeCode)){
					subDateTs = new Timestamp(subDate.getTime());
					if(subDateTs.compareTo(startTime)>=0 && subDateTs.compareTo(endTime)<=0){
						count++;
					}
				}
			}
		}
		return count;
	}
	
	//本方法用于判断某个时间段内，连续几天的文书
	public Map<String,Object> haveContinuousMrCount(Timestamp startTime, Timestamp endTime,List<QaAutoModel> qaAutoMrModelList, String mrTypeCode,int qaRlValue){
		Date startDate = null;
		Date endDate = null;
		Map<String,Object> resultMap = new HashMap(); 
		if(null != startTime && null != endTime){
			startDate = new Date(startTime.getTime());
			endDate = new Date(endTime.getTime());
		}else {
			return resultMap;
		}
		String startTemp = DateUtil.getDate(startDate);//获得起始日期
		//对每天文书与进行比较，首先获取每天的起止时间，第一天的起止时间为，起始时间startTime--当日的23:59:59，第二天为当日00:00:00-23:59:59 ,依次类推,最后一天为，当天00:00:00--endTime
		for(int i=0; i<qaRlValue; i++){
			Date subDate = null;
			Timestamp subDateTs = null;
			String addStart = DateUtil.addDay(startTime.toString(), i);
			Date addStartDate = null;
			try {
				addStartDate = DateUtil.convertStringToDate("yyyy-MM-dd",addStart);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Date start = DateUtil.addStartTime(addStartDate);//为日期添加最小时间
			Date end = DateUtil.addEndTime(addStartDate);//为日期添加最大时间
			Timestamp startTs = new Timestamp(start.getTime());
			Timestamp endTs = new Timestamp(end.getTime());
			int calCount = 0;//局部变量，当天有文书为1，否则为0
			if(null!= qaAutoMrModelList && qaAutoMrModelList.size()>0){
				for(QaAutoModel qaAuto:qaAutoMrModelList){
					subDate = qaAuto.getLogicSubmitTime();
					if(null != subDate){
						subDateTs = new Timestamp(subDate.getTime());
					}else{
						continue;
					}					
					String typeCode = qaAuto.getTypeCode();
					if(typeCode == null && !typeCode.equals(mrTypeCode)){
						return resultMap;
					}
					
					if(i==0){
						if(subDateTs.compareTo(startTime)>=0 && subDateTs.compareTo(endTs)<=0){
							calCount = 1;
						}
					}else if(i==qaRlValue-1){
						//if(subDateTs.compareTo(startTs)>=0 && subDateTs.compareTo(endTime)<=0){
						if(subDateTs.compareTo(startTs)>=0 && subDateTs.compareTo(endTs)<=0){
							calCount = 1;
						}
					}else{
						if(subDateTs.compareTo(startTs)>=0 && subDateTs.compareTo(endTs)<=0){
							calCount = 1;
						}
					}
					resultMap.put(addStart, calCount);
					if(calCount == 1){
						break;
					}
					
				}
			}
			
			
		}
			
		return resultMap;
	}
	
	/*if(null != subDate && null != startTime && null != endTime && typeCode.equals(mrTypeCode) ){
					subDateTs = new Timestamp(subDate.getTime());
					String startTemp = DateUtil.getDate(startDate);//获得起始日期
					//对每天文书与进行比较，首先获取每天的起止时间，第一天的起止时间为，起始时间startTime--当日的23:59:59，第二天为当日00:00:00-23:59:59 ,依次类推,最后一天为，当天00:00:00--endTime
					for(int i=0; i<qaRlValue; i++){
						String addStart = DateUtil.addDay(startTime.toString(), i);
						Date addStartDate = null;
						try {
							addStartDate = DateUtil.convertStringToDate("yyyy-MM-dd",addStart);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Date start = DateUtil.addStartTime(addStartDate);//为日期添加最小时间
						Date end = DateUtil.addEndTime(addStartDate);//为日期添加最大时间
						Timestamp startTs = new Timestamp(start.getTime());
						Timestamp endTs = new Timestamp(end.getTime());
						int calCount = 0;//局部变量，当天有文书为1，否则为0
						if(i==0){
							if(subDateTs.compareTo(startTime)>=0 && subDateTs.compareTo(endTs)<=0){
								calCount = 1;
							}
						}else if(i==qaRlValue-1){
							if(subDateTs.compareTo(startTs)>=0 && subDateTs.compareTo(endTime)<=0){
								calCount = 1;
							}
						}else{
							if(subDateTs.compareTo(startTs)>=0 && subDateTs.compareTo(endTs)<=0){
								calCount = 1;
							}
						}
						resultMap.put(addStart, calCount);
					}
					
				}*/
	
}
