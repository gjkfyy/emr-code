package pkuhit.iih.iemr.sys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pkuhit.iih.qa.CusQaFaultArr;
import pkuhit.iih.qa.FaultRecordService;
import pkuhit.iih.qa.md.QaFaultStatus;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.xap.task.Task;
import pkuhit.xap.task.TaskActionService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.SingleResult;

public class TaskServiceImpl implements TaskService
{
    @Reference
    TaskActionService taskActionService;
    
    @Reference
    FaultRecordService faultRecordService;
    
    @Override
    public TaskModel[] selectTask(Map<String, String> params) throws Throwable
    {
        ArrayResult<Task> results = taskActionService.search(params);
        if(results != null){
            Task[] tasks = results.getDataList();
            List<TaskModel> list = new ArrayList<TaskModel>();
            if(tasks != null && tasks.length > 0){
                for(int i=0;i<tasks.length;i++){
                    Task task = tasks[i];
                    TaskModel model = new TaskModel();
                    model.setTaskPk(task.getPk());
                    model.setTaskStaCd(task.getStatusCode());
                    model.setTaskStaNm(task.getStatusName());
                    model.setDes(task.getDescription());
                    String srcObCd = task.getSorceObjectCode();
                    String srcObPk = task.getSorceObjectPk();
                    if(QaFault.OBJ_CD.equals(srcObCd)){//任务来源质控缺陷
                        SingleResult<QaFault> record = faultRecordService.searchById(srcObPk);
                        if(record != null){
                            QaFault qaFault = record.getData();
                            if(qaFault != null){
                                model.setQaFltPk(qaFault.getPk());
                                model.setSbmtUserId(qaFault.getSubmittedUserId());
                                model.setSbmtUserNm(qaFault.getSubmittedUserName());
                                model.setSbmtDeptCd(qaFault.getSubmittedDeptCode());
                                model.setSbmtDeptNm(qaFault.getSubmittedDeptName());
                                model.setSbmtTime(qaFault.getSubmittedTime());
                                model.setFltFromCd(qaFault.getFaultFromCode());
                                model.setFltFromNm(qaFault.getFaultFromName());
                                model.setSegTpCd(qaFault.getSegmentTypeCode());
                                model.setSegTpNm(qaFault.getSegmentTypeName());
                                model.setDeadline(qaFault.getDeadline());
                                model.setRfmDes(qaFault.getReformedDescription());
                                model.setRfmReq(qaFault.getReformRequirement());
                            }
                        }
                    }
                    list.add(model);
                }
                if(list.size() > 0){
                    TaskModel[] taskArray = new TaskModel[list.size()];
                    return list.toArray(taskArray);
                }
            }
        }
        return null;
    }
    
    public Task completeTask(CusCompleteTask map) throws Throwable{
        String taskPk = map.getTaskPk();
        //更新缺陷的整改说明
        TaskModel[] taskArray = map.getTaskArray();
        if(taskArray != null && taskArray.length > 0){
            List<QaFault> qaFaultList = new ArrayList<QaFault>();
            for(int i=0;i<taskArray.length;i++){
                TaskModel model = taskArray[i];
                String qaFltPk = model.getQaFltPk();
                if(qaFltPk == null)qaFltPk="null";
                SingleResult<QaFault> record = faultRecordService.searchById(qaFltPk);
                if(record != null){
                    QaFault qaFault = new QaFault();
                    qaFault = record.getData();
                    if(qaFault != null){
                        String desc = model.getRfmDes();
                        qaFault.setReformedDescription(desc);
                        if(taskPk.equals(model.getTaskPk()))
                            qaFault.setStatusCode(QaFaultStatus.REFORMED);
                        qaFaultList.add(qaFault);
                    }
                }
            }
            CusQaFaultArr cusQaFaultArr = new CusQaFaultArr();
            cusQaFaultArr.setQaFaultList(qaFaultList);
            faultRecordService.update(cusQaFaultArr);
        }
        //任务完成
        Task task = taskActionService.selectById(taskPk);
        return taskActionService.complete(task);
    }
}
