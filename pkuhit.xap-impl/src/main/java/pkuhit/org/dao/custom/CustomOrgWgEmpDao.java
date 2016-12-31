package pkuhit.org.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.org.dao.auto.entity.OrgWgEmp;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CustomOrgWgEmpDao {

	@Select
    List<OrgWgEmp> selectOrgWgEmpList(String wgCd, String empId); 

}
