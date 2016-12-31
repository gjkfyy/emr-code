package pkuhit.iih.mr.md.dao.custom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 医疗记录类型_审签级别 数据访问dao
 */
@Dao
@RepositoryConfig
public interface CusMdMrTpSignLvlDao {
	//根据主诊断查询审签级别
    @Select
    MdMrTpSignLvl selectByTpDi(String deptCode,String mrTypeCode,String mainDiCode);
}
