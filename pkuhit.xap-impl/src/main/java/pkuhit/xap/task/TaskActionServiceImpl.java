package pkuhit.xap.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.auto.XapTaskDao;
import pkuhit.xap.dao.auto.entity.XapTask;
import pkuhit.xap.dao.custom.CutomXapTaskDao;
import pkuhit.xap.md.TaskStatus;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.servlet.mvc.annotation.RequestParam;

  
public  class TaskActionServiceImpl implements TaskActionService{
  
	@Autowired
	XapTaskDao xapTaskDao;
	@Autowired
	CutomXapTaskDao cutomXapTaskDao;
	
	@Reference
	DictionaryService  dictionaryService;
//	public Task create(Task task) {
//		// TODO Auto-generated method stub
//		XapTask xapTask = new XapTask();
//		BeanCopyUtil.modelToEntity(xapTask,task);
//		xapTaskDao.insert(xapTask);
//		return task;
//	}

	@Override
	public Task update(Task task) {
		// TODO Auto-generated method stub
		XapTask xapTask = new XapTask();
		BeanCopyUtil.modelToEntity(xapTask,task);
		xapTaskDao.updateExcludeNull(xapTask);
		return task;
	}

//	@Override
//	public Task delete(String TaskId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Task selectById(String taskId) {
		// TODO Auto-generated method stub
		//System.out.println("taskId  = "+taskId);
		XapTask xapTask  =  xapTaskDao.selectById(taskId);
		//System.out.println("taskId  =  "+xapTask.getTaskPk());
		Task task = new  Task();
		BeanCopyUtil.entityToModel(task,xapTask,task.OBJ_CD,dictionaryService);
		//BeanCopyUtil.beanCopy(task, xapTask);
		return task;
	}
	
	
	/**
	 *  已发送 和已接收的任务
	 *  根据  tgtObCd  和  tgtObPk 查询任务
	 */
	@Override
	public ArrayResult<Task> search(Map<String,String> params ) {
		// TODO Auto-generated method stub
		ArrayResult<Task> arrayTask = new ArrayResult<Task>();
		List<String> statusList = new ArrayList();
		statusList.add(TaskStatus.SENT); //已发送
		statusList.add(TaskStatus.RECEIVED);//已接收
		List<XapTask> list = cutomXapTaskDao.selectXapTaskList(statusList,params.get("tgtObCd"),params.get("tgtObPk"));
		if(list != null){
			int num = list.size();
			Task[] taskList = new Task[num];
			for(int i=0;i<num;i++){
				 Task task = new Task();
				 BeanCopyUtil.entityToModel(task, list.get(i), task.OBJ_CD, dictionaryService);;
				 taskList[i] = task;;
			}
			arrayTask.setDataList(taskList);
		}
		return arrayTask;
	}

	@Override
	public Task sent(Task task) {
		// TODO Auto-generated method stub
		XapTask xapTask = new XapTask();
		BeanCopyUtil.modelToEntity(xapTask,task);
		xapTaskDao.insert(xapTask);
		return task;
	}

	@Override
	public ArrayResult<Task> searchSent(Task task) {
		// TODO Auto-generated method stub
		String taskStaCd = TaskStatus.SENT;
		List<XapTask> list = cutomXapTaskDao.searchSent(taskStaCd);
		ArrayResult<Task> arayList = new ArrayResult<Task>();
		if(list != null){
			int i=0;
			Task[] dataList = new  Task[list.size()];
			for(XapTask xapTask:list){
				Task tasks = new Task();
				BeanCopyUtil.entityToModel(tasks, xapTask, tasks.OBJ_CD, dictionaryService);
				dataList[i] = tasks;
				i++;
			}
			arayList.setDataList(dataList);
		}
		
		return arayList;
	}

	@Override
	public Task receive(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task searchReceived(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task complete(Task task) {
		// TODO Auto-generated method stub
		XapTask xapTask = new XapTask();
		BeanCopyUtil.modelToEntity(xapTask,task);
//		xapTask.setTaskStaCd(TaskStatus.COMPLETED);
		xapTaskDao.updateExcludeNull(xapTask);
		return task;
	}

	@Override
	public Task searchCompleted(Task task) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Task verify(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task searchVerified(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task searchTimeout(Task task) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Task searchWaitForVerify(Task task) {
		// TODO Auto-generated method stub
		
		List<Map<String,Object>>  Listmap = cutomXapTaskDao.searchWaitForVerify("XAPM05.01");
		BeanCopyUtil.mapToModel(task, Listmap.get(0));
		return null;
	}

}
