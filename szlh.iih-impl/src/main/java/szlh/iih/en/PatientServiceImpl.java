package szlh.iih.en;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.PatientService;
import pkuhit.iih.en.md.PatientModel;
import szlh.iih.en.dao.PatientDao;
import szlh.iih.en.po.PatientPo;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 *
 */
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientDao patientDao;
	/* (non-Javadoc)
	 * @see pkuhit.iih.en.PatientService#getPatientDetail(java.lang.String)
	 */
	@Override
	public SingleResult<PatientModel> getPatientDetail(String paId) {
		PatientModel vo = new  PatientModel();
		List<PatientPo> poList = patientDao.getPatientDetail(paId);
		SingleResultBuilder<PatientModel> builder = SingleResultBuilder.newSingleResult(PatientModel.class);
		if(poList.size() > 0 ){
			PatientPo po = poList.get(0) ;
			if(null != po){
				BeanUtils.copyProperties( po,vo);
				builder.withData(vo);
			}
		}
		return builder.build();
	}

}
