package ei.iih.db.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
import ei.iih.db.dao.auto.entity.MdDi;


/**
 */
@Dao
@RepositoryConfig
public interface MdDiDao {

    /**
     * @param diCd
     * @return the DimDiDefEntity entity
     */
    @Select
    List<MdDi> selectMdDi();

    
}