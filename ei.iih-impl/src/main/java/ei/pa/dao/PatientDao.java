package ei.pa.dao;

import java.util.List;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;

import ei.pa.po.PatientInfoForXMLPo;
import xap.sv.dao.annotation.RepositoryConfig;

/**
 * @author wang_yanli
 * 患者查询接口
 */
@Dao
@RepositoryConfig
public interface PatientDao {
	 
	/**
	 *    
	 * @param patientId   
	 * @return      
	 * @author wang_yanli  
	 * @查询患者信息视图(按照适配器标准，该视图信息作为病历文书XML的一部分) 
	 */  
	@Select    
	public List<PatientInfoForXMLPo> getPatientInfoForXML(String patientId,String inVisitTimes,String outVisitTimes,String enPk);
}
