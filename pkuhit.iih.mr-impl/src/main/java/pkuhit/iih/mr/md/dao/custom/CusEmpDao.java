package pkuhit.iih.mr.md.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;


/**
 */
@Dao
@RepositoryConfig
public interface CusEmpDao {

	/**
	 * 根据角色编码和工作组编码查询人员
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Map<String, Object>> selectByDeptCdAndJobTitleCd(String deptCd);
    
	/**
	 * 根据审签等级编码和工作组编码查询人员
	 * FIXME 
	 * @param enPk
	 * @return
	 */
    @Select
    List<Map<String, Object>> selectByDeptCdAndSignLvlCd(String deptCd,String signLvlCd);
}