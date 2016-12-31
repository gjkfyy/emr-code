package iih.kr.db.cs.dao;

import iih.kr.db.gen.entity.DiSuiteEntity;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusDiSuiteEntityDao {
	/**
	 * 获取自定义分类与诊断关系，顺序比当前编码的顺序大
	 * */
	@Select
	List<DiSuiteEntity> selectCategoryDiGTSort(String orgCode,String ownerType,
			String ownerCode,String categoryCode,int sortNo,String isInclude);
}
