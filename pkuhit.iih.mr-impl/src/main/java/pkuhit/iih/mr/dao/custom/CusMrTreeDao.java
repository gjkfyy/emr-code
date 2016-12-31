package pkuhit.iih.mr.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusMrTreeDao {

	@Select
	public List<MdMrTpCcat> selectMrCustCategory(/*String custCategoryCode*/);
	
	@Select
	public List<Mr> selectMr(String encounterCode, String custCategoryCode);
    /**
     * 查询组合元素分类
     * @param orgCd 组织机构编码
     * @param ownTpCd 所属类型编码
     * @param ownCd 所属编码
     * @param parentMrTypeCustomCategoryCode 父分类编码 （如果不传递，那么只查询根分类）
     * @param keyword 搜索关键字
     * @return
     * String orgCd, String ownTpCd, String ownCd, String parentMrTypeCustomCategoryCode, String keyword
     */
	@Select
	public List<MdMrTpCcat> selectTemplateCategory();
}
