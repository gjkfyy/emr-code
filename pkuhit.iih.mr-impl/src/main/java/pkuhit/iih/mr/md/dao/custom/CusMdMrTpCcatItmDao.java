package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcatItm;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 * 
 */
@Dao
@RepositoryConfig
public interface CusMdMrTpCcatItmDao {
    //根据病历模板类型编码获得病历模板分类编码列表
    @Select
    List<MdMrTpCcatItm> getMdMrTpCcatItmByTemplateTypeAndEnTpCd(String typeCode,String enTpCd);
	
	//根据病历模板类型编码获得门急诊病历模板分类编码列表
	@Select
    List<MdMrTpCcatItm> getOutMdMrTpCcatItmByTemplateType(String typeCode);
	
    //根据病历模板分类编码获得病历模板类型编码列表
	@Select
    List<MdMrTpCcatItm> getMdMrTpCcatItmByTemplateCategory(String categoryCode);
	
	//根据病历模板类型编码获得病历模板分类编码列表
    @Select
    List<MdMrTpCcatItm> getMdMrTpCcatItmByTemplateType(String typeCode);
	
	@Select
    List<MdMrTpCcatItm> selectEnTypeByTemplateType(String typeCode);
    
    @Select
    List<MdMrTpCcatItm> selectMrTpCcatByTemplateType(String typeCode);
}
