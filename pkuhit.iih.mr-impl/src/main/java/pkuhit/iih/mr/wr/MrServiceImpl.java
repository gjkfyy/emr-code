package pkuhit.iih.mr.wr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.wr.dao.CusMrDao;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

public class MrServiceImpl  implements MrService {

	@Autowired
	CusMrDao cusMrDao;
	
	@Override
	public ArrayResult<Mr> search(String enPk) throws Throwable {
		// TODO Auto-generated method stub
		ArrayResult<Mr> result = null;
		ArrayResultBuilder<Mr> builder = ArrayResultBuilder.newArrayResult(Mr.class);
		List<Mr> listMr = (List<Mr>) cusMrDao.selectByEnPkForEmergencyMrNumber(enPk, null);
		if (listMr.size() > 0) {
			builder.withData(listMr.toArray(new Mr[0]));
		}
		result = builder.build();
		result.setTotal(listMr.size());
		return result;
	}

}
