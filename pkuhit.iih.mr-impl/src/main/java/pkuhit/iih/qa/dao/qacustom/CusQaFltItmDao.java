package pkuhit.iih.qa.dao.qacustom;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.QaItmFst;
import pkuhit.iih.qa.dao.auto.entity.QaItmSnd;
import xap.sv.dao.annotation.RepositoryConfig;

import java.util.List;


/**
 */
@Dao
@RepositoryConfig
public interface CusQaFltItmDao {

	@Select
    List<QaItmFst> selectQaFltItm();
	
	@Select
    List<QaItmSnd> selectQaSndItm(String amrScoreCode);
	
	@Select
	QaItmFst selectQaItmFstByNm(String nm);
	
	@Select
	QaItmSnd selectQaItmSndByNm(String nm);
	/**
	 * 根据患者Id查询整改总数
	 * @param enPk 就诊号
	 * @return
	 */
	@Select
	Integer selectCountQaFltByEnPk(String qaTyCd,String enPk);
}