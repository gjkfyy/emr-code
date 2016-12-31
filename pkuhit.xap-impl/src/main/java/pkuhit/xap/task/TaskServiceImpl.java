package pkuhit.xap.task;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.dao.custom.CutomXapTaskDao;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class TaskServiceImpl implements TaskService
{
    @Autowired
    CutomXapTaskDao cutomXapTaskDao;
    
    @Reference
    DictionaryService dictionaryService;
    
    @Override
    public ArrayResult<XapTaskModel> searchTaskByEn(Map<String, String> params) {
        ArrayResultBuilder<XapTaskModel> builder = ArrayResultBuilder.newArrayResult(XapTaskModel.class);
        ArrayResult<XapTaskModel> taskArrayResult = new ArrayResult<XapTaskModel>();
        String encounterSn = params.get("encounterSn");          
        List<Map<String, Object>> taskMapList = cutomXapTaskDao.selectXapTaskByEn(encounterSn);
        int total = taskMapList.size();
        if (taskMapList != null) {
            XapTaskModel[] taskList = new XapTaskModel[taskMapList.size()];
            int i = 0;
            for (Map<String, Object> taskMap : taskMapList) {
                XapTaskModel task = new XapTaskModel();
                BeanCopyUtil.mapToModel(task, taskMap, dictionaryService);
                String[] mrTpCds = task.getMrTpCd().split(",");
                String mrTpCd = mrTpCds[0];
                task.setMrTpCd(mrTpCd);
                List<Map<String, Object>> ccatMapList = cutomXapTaskDao.selectMrTpCcatForTask(task.getEncounterSn(), mrTpCd);
                if(ccatMapList != null){
                    Map<String, Object> ccatMap = ccatMapList.get(0);
                    if(ccatMap.get("MR_TP_CCAT_CD") != null)
                        task.setMrTpCcatCd((String)ccatMap.get("MR_TP_CCAT_CD"));
                }
                taskList[i] = task;
                i++;
            }
            builder.withData(taskList);
        }
        taskArrayResult = builder.build();
        taskArrayResult.setTotal(total);
        
        return taskArrayResult;
    }
}
