package pkuhit.xap.task;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.QaNotification;
import pkuhit.iih.qa.md.QaRevisionNoticeStatus;
import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.dao.custom.CutomXapTaskDao;
import pkuhit.xap.ru.RuleEnginService;
import xap.ru.engin.RuleEngin;
import xap.sv.annotation.Reference;
import xap.sv.event.listener.EventListener;
import xap.sv.event.object.EventObject;

  
public  class NoticeTaskHandleServiceImpl implements EventListener{
	
	@Autowired
	CutomXapTaskDao cutomXapTaskDao;
	
	@Autowired
	XapTaskDao xapTaskDao;

	public void callBack(EventObject arg0) {
		// TODO Auto-generated method stub
		Map<String,Object> map = (Map<String,Object>)arg0.getSource();
		try {
			updateNoticeTask(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Override
	public void updateNoticeTask(Map<String,Object> map) throws Exception{
		if(null != map && map.size() > 0){
			QaNotification qaNotification = (QaNotification) map.get("qaNotification");
			if(null != qaNotification){
				String revisionCd = qaNotification.getRevisionCd();
				XapTask xapTask = cutomXapTaskDao.selectTaskByRevisionCd(revisionCd);
				String noticeStatus = qaNotification.getStatus();
				if(null !=noticeStatus && noticeStatus == QaRevisionNoticeStatus.REFORMING){
					xapTask.setStatus(XapTaskModel.DEALING);//置任务状态为处理中
				}else if(null !=noticeStatus && noticeStatus == QaRevisionNoticeStatus.REFORMED){
					xapTask.setStatus(XapTaskModel.DEALED);//置任务状态为已处理
				}
				if(xapTask.getCompleteTime() == null){
					xapTaskDao.update(xapTask);
				}else{
					xapTaskDao.updateExcludeNull(xapTask);
				}
			}	
		}
	}
}
