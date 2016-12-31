package pkuhit.org.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 员工dao
 */
@Dao
@RepositoryConfig
public interface CusOrgEmpDao {
   @Select 
   List<Map<String,Object>> getEmpByDept(String deptCode);
}
