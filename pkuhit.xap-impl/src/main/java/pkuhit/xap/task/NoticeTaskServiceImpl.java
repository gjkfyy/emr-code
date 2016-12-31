package pkuhit.xap.task;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.QaNotification;
import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.mes.Message;
import pkuhit.xap.mes.MessageService;
import xap.sv.annotation.Reference;
import xap.sv.event.listener.EventListener;
import xap.sv.event.object.EventObject;
import xap.sv.util.UUIDGenerator;

  
public  class NoticeTaskServiceImpl implements EventListener{
	
	@Autowired
	XapTaskDao xapTaskDao;
	
	@Reference
	DictionaryService  dictionaryService;
	
	@Reference
	MessageService messageService;

	public void callBack(EventObject arg0) {
		// TODO Auto-generated method stub
		Map<String,Object> map = (Map<String,Object>)arg0.getSource();
		try {
			saveTaskNotice(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void saveTaskNotice(Map<String,Object> map){
		if(null != map && map.size() > 0){
			QaNotification qaNotification = (QaNotification) map.get("qaNotification");
			Message msg = (Message) map.get("msg");
			if(null != qaNotification){
				String qaTyCd = qaNotification.getQaTyCd();
				String msgContent = msg.getContent();
				XapTask xapTask = new XapTask();
	    		String taskId = UUIDGenerator.getUUID();
	    		xapTask.setTaskId(taskId);
	    		xapTask.setTaskTypeCd(qaTyCd);
	    		xapTask.setDocSn(qaNotification.getRevisionCd());
	    		xapTask.setEncounterSn(qaNotification.getEnPk());
	    		xapTask.setStatus(XapTaskModel.UNDEAL);//置任务状态为未处理
	    		xapTask.setMemo(msgContent);
		    	xapTaskDao.insert(xapTask);
		    	msg.setTaskId(taskId);
		    	messageService.sendMessage(msg);
			}
		}
	}
}
