package pkuhit.iih.mr.md.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusMdMrOrDao
{
    /**
     * 根据医嘱类型查询病历类型
     * FIXME 
     * @param orTpCd
     * @return
     */
    @Select
    List<Map<String,Object>> selectMrTpByOrTp(String orTpCd);
}
