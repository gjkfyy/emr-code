package pkuhit.iih.di.dao.custom;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.di.dao.auto.entity.DiIn;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusDiInDao {

	/**
	 * 通过就诊序号查询就诊信息列表
	 */
	@Select
	List<DiIn> selectDiInsByEnSn(String enSn);
	
	/**
	 * 查询不是主诊断的就诊信息列表
	 */
	@Select
	List<DiIn> selectDiIns(String enSn);
	
	
	/**
	 *查询当前就诊的主诊断列表
	 */
	@Select
	DiIn selectDiInByMainF(String enSn,short  mainF);
	
	/**
	 *查询是否有子诊断
	 */
	@Select
	List<DiIn> selectDiInSon(String parDiSn);

}
