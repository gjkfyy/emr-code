package pkuhit.iih.mr.md.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author guo_zhongbao
 *
 */
@Dao
@RepositoryConfig
public interface CusMdMrTpCcatDao {
	/**
	 * 根据根节点和子层级深度来获取树
	 * @param orgCode 院区编码
	 * @param rootCode  根节点code
	 * @param maxDepthLevel 子层级深度所处的level
	 * */
	@Select
	 List<MdMrTpCcat>  selectTreeList(String orgCode ,String rootCode,int maxDepthLevel);

	/**
	 * 根据父节点获取子节点列表
	 * @param orgCode 院区编码
	 * @param rootCode  根节点code
	 * @param maxDepthLevel 子层级深度所处的level
	 * */
	@Select	
	 List<MdMrTpCcat>  getNextLevelChild(String orgCode ,String rootCode);

	
	/**
	 * 根据就诊类型编码查询医疗记录类型 
	 * @param enTpCd
	 * @return
	 */
	@Select
	 List<MdMrTpCcat>  selectByEnTpCd(String enTpCd,int doctorNuserFlag);
	
	/**
     * 根据就诊类型得到病历类型分组树
     * @param enTpCd 就诊类型
     * */
    @Select
     List<MdMrTpCcat>  selectSortTree(String enTpCd,String encounterPk,int dctNsF);
    
    /**
     * 根据就诊类型得到病历类型  病历文书树
     * @param enTpCd 就诊类型
     * */
    @Select
     List<MdMrTpCcat>  selectMrDocTree(String enTpCd,String enPk,Integer dctNsF);
    
    /**
     * 根据就诊类型得到病历类型  病历文书树
     * @param enTpCd 就诊类型
     * */
    @Select
     List<MdMrTpCcat>  selectMrDocTreeByGroup(List<String> enTpCdList,List<String> enPks);
    
    /**
     * 检索病历类型组
     * */
    @Select
     List<MdMrTpCcat>  selectAll();
}
