package pkuhit.iih.qa.dao.custom;

import java.util.List;
import java.util.Map;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import pkuhit.iih.qa.dao.auto.entity.Qa;
import xap.sv.dao.annotation.RepositoryConfig;

@Dao
@RepositoryConfig
public interface CusQaRecordDao {
	
	@Select
    List<Qa> selectByEnPk(String enPk, String userId, short cmplF);
	
	/**
     * @param qaPk 质控工作记录编码
     * @param userId 用户ID
     * @param deptCd 科室I
     * @return List<QaFault>
     */
	@Select
	Map<String, Object> selectFaultStatistical(String qaPk, String userId, String deptCd);
	
	/**
	 * 查询最后一条完成的质控工作记录
	 * @param enPk
	 * @return
	 */
	@Select
	Qa selectLastCompleted(String enPk, String qaTypeCode);
	
	/**
	 * 根据缺陷主键查询未完成的质控工作记录
	 * @param faultPk 缺陷主键
	 * @return
	 */
	@Select
	Qa selectQaByFaultPk(String faultPk);
	
}
