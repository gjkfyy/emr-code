package pkuhit.iih.mr.tpl.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 *
 */
@Dao
@RepositoryConfig
public interface CusTemplateDao {
    /**
     * @param 根记录编码
     * @return 最大版本号
     */
    @Select
    BigInteger selectMaxVersionByRootCode(String rootCode);
    
    @Select
    int getCountOfName(String orgCode ,String code ,String name,String ownDeptCd);
    
    @Select
    int getCounts();
    
    @Select
    int getMaxSortNo();
    
    /**
     * @param codeList 模板编码列表
     * @param excludeDelete 不包含删除标志。 如果为null，则包含了删除。如果不为null，则输出结果不包含删除
     * @param excludeStop 不包含停用标志。 如果为null，则包含了停用。如果不为null，则输出结果不包含停用
     * @param statusCode 状态标志
     * @param name 名称，模糊查询，包含
     * @param rootCode 根记录编码
     * @param orgCode 组织机构编码
     * @param ownerTypeCode //所属类型编码
	 * @param ownerCode //所属编码
	 * @param typeCode// 医疗记录模板类型编码
	 * @param baseTemplateCode //基础模板编码
     * @return 列表
     */
    @Select
    List<MrTpl> selectAll(List<String> codeList ,String excludeDelete ,List<String> statusCode,String name,String rootCode, String orgCode,String ownerTypeCode ,List<String>  ownerCode , List<String> typeCode,String baseTemplateCode,String enTypeCode ,SelectOptions options);

    
    /**
     * @param codeList 模板编码列表
     * @param rootCode 根记录编码
     * @param orgCode 组织机构编码
     * @param ownerTypeCode //所属类型编码
	 * @param ownerCode //所属编码
	 * @param typeCode// 医疗记录模板类型编码
     * */
    @Select
    List<Map<String,Object>> selectAllToUse( String orgCode,String name,String ownerTypeCode ,List<String>  ownerCode , List<String> typeCode,String enTypeCode ,SelectOptions options);

    
	/**
	 * 【医疗记录模板】导航树---所属院区的每个所属类型 所属编码对应的模板个数
	 * * @param  orgCode 院区编码
	 * @return 导航树
	 */
    @Select
    List<Map<String,Object>> getCountByOrg(String orgCode,List<String> owerCodes,String keyWord,String enTypeCode ,List<String>  scTemplateTypeCode,String statusCode);

	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（ 首层）  对应的模板个数
	 * * @param  ownerCode 所属编码
	 * @return map<编码  个数>
	 */
    @Select
	List<Map<String,Object>> getCountOfMrTlCategoryByOwner(String orgCode,String ownerCode,String keyWord,String enTypeCode ,String scTemplateCategoryCode ,String scTemplateTypeCode,String statusCode,String dctNsF) ;
	
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（非首层 非叶） 对应的模板个数
	 * * @param  mrCategoryCode 自定义分类编码
	 * @return map<编码  个数>
	 */
    @Select
	List<Map<String,Object>> getCountByMrTlCategoryByCategory(String orgCode,String ownerCode,String mrCategoryCode,String keyWord,String enTypeCode,String dctNsF) ;
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板自定义分类（叶） 对应的模板个数
	 * * @param  mrCategoryCode 自定义分类编码
	 * @return map<编码  个数>
	 */
    @Select
	List<Map<String,Object>> getCountByMrTlCategoryByLeafCategory(String orgCode,String ownerCode,String mrCategoryCode,String keyWord,String enTypeCode,String scTemplateTypeCode,String statusCode,String dctNsF) ;
	
	/**
	 * 【医疗记录模板】导航树---病历类型分类对应的模板
	 * * @param  TypeCode 类型编码
	 * @return map<编码  个数>
	 */
    @Select
	List<MrTpl> getMrTlByLeafCategory(String orgCode,String ownerCode,String mrCategoryCode,String keyWord,String enTypeCode,String scTemplateTypeCode,String statusCode,String dctNsF) ;
    
	/**
	 * 【医疗记录模板】导航树---所属院区的每个病历模板类型   对应的模板个数
	 * * @param  TypeCode 类型编码
	 * @return map<编码  个数>
	 */
    @Select
	List<MrTpl> getCountByMrTlCategoryByType(String orgCode,String ownerCode,String TypeCode,String keyWord,String enTypeCode) ;
    
    /**
     * 【医疗记录模板】导航树---所属院区的每个病历模板类型   对应的模板个数
     * * @param  TypeCode 类型编码
     * @return map<编码  个数>
     */
    @Select
    List<MrTpl> getMrTemplate(String ownerCode) ;
    

    /**
     * 查询默认模板
     * @param ownerCode
     * @param ownerTypeCode
     * @param mrTypeCode
     * @return
     */
    @Select
    List<MrTpl> getDefaultTemplate(String ownerCode,String ownerTypeCode,String mrTypeCode) ;
    
    /**
     * @param name 模板名称
     * @param hospitalArea 医院编码
     * @param departCode 科室编码
     * @param userCode 用户编码
     * @param mrCategoryCode 医疗记录模板类型分组编码
     * @param typeCode// 医疗记录模板类型编码
     * */
    @Select
    List<Map<String,Object>> selectAllToCreate(String name,String hospitalArea,String departCode,String userCode,String mrCategoryCode,String typeCode);
    
    /**
     * mrTplCCat 自定义分类
     * mrTplTypeCd 病历类型
     * mrTplStatCd 模板状态
     * keyWord 名称搜索关键词
     * enTypeCode 就诊类型
     * dctNsF 医护标识
     * orgCode 组织机构编码
     * userId 用户编码
     * */
    @Select
    List<Map<String,Object>> selectMrTemplateTreeData(String mrTplCCat,String mrTplTypeCd,String mrTplStatCd,String keyWord,String enTypeCode,String dctNsF,String orgCode,String userId);
    
    /**
     * @param statusCode 状态标志
     * @param name 名称，模糊查询，包含
     * @param dctNsF 医护标识
     * @param orgCode 组织机构编码
     * @param ownerTypeCode //所属类型编码
     * @param ownerCode //所属编码
     * @param typeCode// 医疗记录模板类型编码
     * @param mrCategoryCode //医疗记录模板自定义分类编码
     * @param enTypeCode //就诊类型
     * @param userCode //用户编码
     * @return 列表
     */
    @Select
    List<Map<String,Object>> selectMrTplList(String statusCode,String name,String dctNsF,String orgCode,String ownerTypeCode,String ownerCode,String typeCode,String mrCategoryCode,String enTypeCode,String userCode,SelectOptions options);
}
