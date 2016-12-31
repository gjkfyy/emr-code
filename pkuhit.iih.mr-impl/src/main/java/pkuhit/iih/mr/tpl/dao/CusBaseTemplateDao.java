package pkuhit.iih.mr.tpl.dao;

import java.math.BigInteger;
import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;

import pkuhit.iih.mr.dao.auto.entity.MrBaseTpl;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 
 */
@Dao
@RepositoryConfig
public interface CusBaseTemplateDao {
    /**
     * @param 根记录编码
     * @return 最大版本号
     */
    @Select
    BigInteger selectMaxVersionByRootCode(String rootCode);
    /**
     * @param excludeDelete 不包含删除标志。 如果为null，则包含了删除。如果不为null，则输出结果不包含删除
     * @param excludeStop 不包含停用标志。 如果为null，则包含了停用。如果不为null，则输出结果不包含停用
     * @param statusCode 状态标志
     * @param name 名称，模糊查询，包含
     * @param rootCode 根记录编码
     * @param orgCode 组织机构编码
     * @return 列表
     */
    @Select
    List<MrBaseTpl> selectAll(String excludeDelete ,List<String> statusCode,String name,String rootCode,SelectOptions options);

    /**
     * 判断相同名称的数量
     * @param name 搜索名称
     * @return 数量
     * */
    @Select
    int getCountOfName(String code ,String name);
}
