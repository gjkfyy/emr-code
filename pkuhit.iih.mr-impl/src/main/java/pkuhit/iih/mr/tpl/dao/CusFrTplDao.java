package pkuhit.iih.mr.tpl.dao;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.jdbc.SelectOptions;
import pkuhit.iih.mr.dao.auto.entity.MrFrTpl;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 
 */
@Dao
@RepositoryConfig
public interface CusFrTplDao {
    /**
     * @param excludeDelete 不包含删除标志。 如果为null，则包含了删除。如果不为null，则输出结果不包含删除
     * @param excludeStop 不包含停用标志。 如果为null，则包含了停用。如果不为null，则输出结果不包含停用
     * @param name 名称，模糊查询，包含
     * @param mrFrTplCd 模板分类
     * @param orgCode 组织机构编码
     * @return 列表
     */
    @Select
    List<MrFrTpl> selectAll(String excludeDelete ,String name,String mrFrTplCd,SelectOptions options);

    /**
     * 判断相同名称的数量
     * @param name 搜索名称
     * @return 数量
     * */
    @Select
    int getCountOfName(String code ,String name);
    
    
    /**
     * 判断相同名称的数量
     * @param name 搜索名称
     * @param mrFrTplTpCd 分类
     * @return 类型结果集
     * */
    @Select
    List<Map<String,Object>> selectMrFrTplTree(String keyword,String mrFrTplTpCd );
    
    
}
