package pkuhit.iih.mr.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.MrTplDept;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 模板适用
 */
@Dao
@RepositoryConfig
public interface CusMrTplDeptDao {
	//根据模板code获得模板适用列表
	@Select
	List<MrTplDept> getTplDeptByTpl(String mrTplCode) ;
	//根据部门编码获得模板适用列表
	@Select
	List<MrTplDept> getTplDeptByDept(String tplUseTypeCode ,List<String> deptCode) ;
}
