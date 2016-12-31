package pkuhit.iih.mr.tpl.dao;

import java.math.BigInteger;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrGe;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrGeCcat;
import xap.sv.dao.annotation.RepositoryConfig;
/**
 * @author guo_zhongbao
 *
 */
@Dao
@RepositoryConfig
public interface CusGroupElementDao {
    /**
     * @param 根记录编码
     * @return 最大版本号
     */
    @Select
    BigInteger selectMaxVersionByRootCode(String rootCode);
    
    /**
     * @param rootCode 根记录编码
     * @param orgCode 组织机构编码
     * @return 列表
     */
    @Select
    List<MrGe> selectGroupElementByRootcode(String rootCode, String orgCode);
    
    /**
     * 查询组合元素分类
     * @param orgCd 组织机构编码
     * @param ownTpCd 所属类型编码
     * @param ownCd 所属编码
     * @param typeCode 组合元素类型编码
     * @param parentCode 父组合元素分类编码 （如果不传递，那么只查询根分类）
     * @param keyword 搜索关键字
     * @return
     */
    @Select
    List<MdMrGeCcat> selectGroupElementCategory(String orgCd, String ownTpCd, String ownCd, String typeCode, String parentCode, String keyword);

    @Select
    List<MdMrGeCcat> selectCategory(String orgCd, String parentCode, String keyword);

    /**
     * 查询组合元素
     * @param orgCd 组织机构编码
     * @param ownTpCd 所属类型编码
     * @param ownCd 所属编码
     * @param typeCode 组合元素类型编码
     * @param categoryCd 组合元素分类编码
     * @param statusCode 状态编码
     * @param keyword 搜索关键字 
     * @return
     */
    @Select
    List<MrGe> selectGroupElement(String orgCd, String ownTpCd, String ownCd, String typeCode, String categoryCd, String statusCode, String keyword,SelectOptions options);
}
