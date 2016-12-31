package pkuhit.xap.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.xap.dao.auto.entity.XapTask;

import java.util.List;
import java.util.Map;

import xap.sv.dao.annotation.RepositoryConfig;

/**
 */
@Dao
@RepositoryConfig
public interface CutomXapTaskDao {
	
	@Select
	List<XapTask> selectXapTaskList(List<String> statusList,String tgtObCd,String tgtObPk);
	@Select
	List<XapTask> searchSent(String taskStaCd);
	@Select
	List<Map<String, Object>> searchWaitForVerify(String taskStaCd);
	
	@Select 
    List<Map<String, Object>> selectXapTaskByEn(String encounterSn);
	
	@Select
	XapTask selectTaskByRevisionCd(String revisionCd);
	
	@Select 
    List<Map<String, Object>> selectMrTpCcatForTask(String encounterSn,String mrTpCd);
	
}
