package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 病历模板类型
 */
@Dao
@RepositoryConfig
public interface CusMdMrTpDao {
	 /* 根据根节点和子层级深度来获取树
	 * @param rootCode  根节点code
	 * @param maxDepthLevel 子层级深度所处的level
	 * */
	@Select
	 List<MdMrTp>  selectTreeList(String rootCode,int maxDepthLevel);
	
	 /* 根据父节点深度来获取下一级节点
	 * @param parentId  父节点code
	 * */
	@Select
	 List<MdMrTp>  getNextLevelChild(String parentId);

	
	/**
	 * 根据[就诊类型编码,自定义分类编码]查询医疗记录类型 
	 * @param enTpCd 急诊类型
	 * @param mrTpCcatCd 自定义分类编码
	 * @return
	 */
	@Select
	 List<MdMrTp>  selectByEnTpCd(String enTpCd,String mrTpCcatCd);
	
	
	/**
	 * 根据[就诊类型编码,自定义分类编码]查询医疗记录类型 
	 * @param enTpCd 急诊类型
	 * @param mrTpCcatCd 自定义分类编码
	 * @return
	 */
	@Select
	List<MdMrTp>  selectByEnTpCdAndDctNsF(String enTpCd,String mrTpCcatCd,String dctNsF);
	
	/*
	 * 查询所有的类型编码叶节点
	 */
	@Select
	 List<MdMrTp>  selectLeafTypeCode();

	/*
	 * 病历文书树，缩进
	 * */
	@Select
	 List<MdMrTp>  selectTypeCodeTree(List<String> typeCodeList ,String keyWord,String dctNsF);
	
	/* 根据文书类型组来获取文书类型
     * @param mrTypeCcatId  文书类型组code
     * */
    @Select
     List<MdMrTp>  selectByMrTypeCcatId(String mrTypeCcatId);
}
