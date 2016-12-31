package ei.his.service;

import java.util.List;
import java.util.Map;

import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author yao_lijie
 * 通过住院号查找门诊患者，查询语句写到存储过程中
 */
public interface HisMrAmrOutService {
	List<String> getPatientOut(String amrNo);
}
