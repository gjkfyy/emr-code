package szlh.iih.qa;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.AutoQaTaskService;
import pkuhit.iih.qa.EmrEventModel;
import szlh.iih.qa.dao.AutoQaTaskDao;
import szlh.iih.qa.dao.auto.EmrEventDao;
import szlh.iih.qa.po.EmrEvent;
import xap.sv.annotation.Reference;
import xap.sv.event.engin.EventEngin;

public class AutoQaTaskServiceImpl implements AutoQaTaskService{

	@Autowired
	AutoQaTaskDao autoQaTaskDao;
	
	@Autowired
	EmrEventDao emrEventDao;
	
	@Reference
	EventEngin eventEngin;

	//@Override
	public String searchTasktest() {
		String startTime = "2014-8-27 16:20:00";
		String endTime = "2015-7-10 16:20:00";
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		List<EmrEvent> emrEventList = autoQaTaskDao.selectEmrEventsByTime(startTime, endTime);
		for(EmrEvent emrEvent:emrEventList){
			EmrEventModel emrEventModel = new  EmrEventModel();
			BeanUtils.copyProperties( emrEvent,emrEventModel);
			eventEngin.fire(emrEvent.getEventtype(), emrEventModel);
			emrEvent.setTreattime(currentTimeTs);
		}
		emrEventDao.batchUpdate(emrEventList);
		System.out.println("wangyanli test time task===================");
		return null;
	}
	//查询emr事件
	@Override
	public String searchTask() {
		
		//EmrEventModel.endTime = addDay(EmrEventModel.startTime, 2)+" 00:00:00";
		//System.out.println("wangyanli========================endtime is "+EmrEventModel.endTime );
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		List<EmrEvent> emrEventList = autoQaTaskDao.selectEmrEventsByTime(EmrEventModel.startTime, EmrEventModel.endTime);
		for(EmrEvent emrEvent:emrEventList){
			EmrEventModel emrEventModel = new  EmrEventModel();
			BeanUtils.copyProperties( emrEvent,emrEventModel);
			//触发事件
			eventEngin.fire(emrEvent.getEventtype(), emrEventModel);
			emrEvent.setTreattime(currentTimeTs);
		}
		emrEventDao.batchUpdate(emrEventList);
		//EmrEventModel.startTime = EmrEventModel.endTime;
		System.out.println("wangyanli test time task===================");
		return null;
	}
	
	 /** 
     * 返回日期加X天后的日期 
     * @author dylan_xu 
     * @date Mar 11, 2012 
     * @param date 
     * @param i 
     * @return 
     */  
    public  String addDay(String date, int i) {  
        try {  
        	SimpleDateFormat sdf_datetime_format = new SimpleDateFormat("yyyy-MM-dd");  
            GregorianCalendar gCal = new GregorianCalendar(  
                    Integer.parseInt(date.substring(0, 4)),   
                    Integer.parseInt(date.substring(5, 7)) - 1,   
                    Integer.parseInt(date.substring(8, 10)));  
            gCal.add(GregorianCalendar.DATE, i);  
            return sdf_datetime_format.format(gCal.getTime());  
        } catch (Exception e) {  
           e.printStackTrace();
           return "";
        }  
    }  
   

}
