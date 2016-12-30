package szlh.iih.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import szlh.iih.sync.dao.CusMrAmrDao;

public class TaskJob {
	public static Logger log = LoggerFactory.getLogger(TaskJob.class);
   public void SyncTask() {
     // TODO Auto-generated method stub
     try {
    	 log.debug("处理任SyncTask务开始>..debug......");
    	 
            log.info("处理任SyncTask务开始>....info....");
//            log.info("处理任务开始>...mrAmrDao....."+mrAmrDao);
            // 业务逻辑代码调用
            System.out.println("时间[" + new java.util.Date().toLocaleString()
                          + "]----->！----------");
            log.info("处理任务结束!");
     } catch (Exception e) {
            log.error("处理任务出现异常", e);
     }
}

}
