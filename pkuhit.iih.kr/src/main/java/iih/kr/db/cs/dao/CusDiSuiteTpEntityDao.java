package iih.kr.db.cs.dao;

import iih.kr.db.gen.entity.DiSuiteTpEntity;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;
@Dao
@RepositoryConfig
public interface CusDiSuiteTpEntityDao {
    /**
     * @param diSuiteTpCd
     * @return the DiSuiteTpEntity entity
     */
	@Select 
	List<DiSuiteTpEntity> selectOwnerRelCategoryGTSort( String ownerType, String ownerCode,int sortNo,String isInclude);
}
