package szlh.iih.sync;

import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobOrgEmpDeptService;
import pkuhit.md.DictionaryUpdateService;
import szlh.iih.sync.dao.CusOrgEmpDeptDao;
import szlh.iih.sync.po.OrgEmpDeptPo;
import xap.sv.annotation.Reference;

public class TaskJobOrgEmpDeptServiceImpl implements TaskJobOrgEmpDeptService {
	public static Logger log = LoggerFactory
			.getLogger(TaskJobOrgEmpDeptServiceImpl.class);
   
	static StringBuffer org_emp_dept_bf = new StringBuffer();
	
	@Autowired
	CusOrgEmpDeptDao cusOrgEmpDeptDao;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Reference
	DictionaryUpdateService dictionaryUpdateService;
	@Override
	public String search() {
		SelectOptions options = SelectOptions.get().offset(0).limit(5000).count();	
		List<OrgEmpDeptPo> list = cusOrgEmpDeptDao.selectAll(options);
		if (list != null) {

			int size = list.size();

			if (size > 0) {
				log.debug("sync org start...");
				log.debug(" org count = " + size);
				for (OrgEmpDeptPo orgEmpDeptPo : list) {
					if (orgEmpDeptPo.getFlag().equals("I")) {
						String  isExistInIemr = "select count(*) from org_emp_dept where emp_dept_cd =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {String.valueOf(orgEmpDeptPo.getEmpDeptCd())}, Integer.class);
						if(intExistInIemr.intValue() == 1 ){
							orgEmpDeptPo.setFlag("U");
						}
					}else if (orgEmpDeptPo.getFlag().equals("U")) {
						String  isExistInIemr = "select count(*) from org_emp_dept where emp_dept_cd =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {String.valueOf(orgEmpDeptPo.getEmpDeptCd())}, Integer.class);
						if(intExistInIemr.intValue() == 0 ){
							orgEmpDeptPo.setFlag("I");
						}
					}
					
					if (orgEmpDeptPo.getFlag().equals("I")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						try {
							jdbcTemplate.execute(InsertSql(orgEmpDeptPo));
							cusOrgEmpDeptDao.delete(orgEmpDeptPo);
						} catch (Exception e) {
							log.warn("sync  insert org_emp_dept exception ..."
									+ e.getMessage());
							
						}
					}
					if (orgEmpDeptPo.getFlag().equals("U")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						try {
							jdbcTemplate.execute(UpdateSql(orgEmpDeptPo));
							cusOrgEmpDeptDao.delete(orgEmpDeptPo);
						} catch (Exception e) {
							log.warn("sync update org_emp_dept exception ..."
									+ e.getMessage());
							
						}
					}
					if (orgEmpDeptPo.getFlag().equals("D")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						try {
							jdbcTemplate.execute(DeleteSql(orgEmpDeptPo));
							cusOrgEmpDeptDao.delete(orgEmpDeptPo);
						} catch (Exception e) {
							log.warn("sync delete org_emp_dept exception ..."
									+ e.getMessage());
							
						}
					}
				}
				//cusOrgEmpDeptDao.batchDelete(list);
				log.debug("sync org end ... ");	
				dictionaryUpdateService.updateDictionaryByDictId("ORGB06");
			}

		}

		return "{'result':'success'}";
	}

	private String InsertSql(OrgEmpDeptPo orgEmpDeptPo) {
		//StringBuffer org_emp_dept_bf = new StringBuffer();
		org_emp_dept_bf.delete(0, org_emp_dept_bf.length());
		org_emp_dept_bf.append(" insert into org_emp_dept ");
		org_emp_dept_bf.append("(EMP_DEPT_CD,WARD_DEPT_CD,EMP_ID ,SIGN_LVL_CD,CUR_DRC_DCT_ID,CUR_DEPUTY_DRC_DCT_ID,DEL_F) values (");
		if (orgEmpDeptPo.getEmpDeptCd() != null
				&& !orgEmpDeptPo.getEmpDeptCd().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getEmpDeptCd() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getWardDeptCd() != null
				&& !orgEmpDeptPo.getWardDeptCd().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getWardDeptCd() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getEmpId() != null
				&& !orgEmpDeptPo.getEmpId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getEmpId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getSignLvlCd() != null
				&& !orgEmpDeptPo.getSignLvlCd().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getSignLvlCd() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getCurDrcDctId() != null
				&& !orgEmpDeptPo.getCurDrcDctId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getCurDrcDctId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getCurDeputyDrcDctId() != null
				&& !orgEmpDeptPo.getCurDeputyDrcDctId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getCurDeputyDrcDctId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		org_emp_dept_bf.append("'" + orgEmpDeptPo.getDelF() + "'");
		org_emp_dept_bf.append(")");
		log.debug("insert ..." + org_emp_dept_bf.toString());
		return org_emp_dept_bf.toString();

	}

	private String UpdateSql(OrgEmpDeptPo orgEmpDeptPo) {
		//StringBuffer org_emp_dept_bf = new StringBuffer();
		org_emp_dept_bf.delete(0, org_emp_dept_bf.length());
		
		org_emp_dept_bf.append("update org_emp_dept  set ");
		org_emp_dept_bf.append("(WARD_DEPT_CD,EMP_ID ,SIGN_LVL_CD,CUR_DRC_DCT_ID,CUR_DEPUTY_DRC_DCT_ID,DEL_F) ");
		org_emp_dept_bf.append(" = (select ");
		if (orgEmpDeptPo.getWardDeptCd() != null
				&& !orgEmpDeptPo.getWardDeptCd().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getWardDeptCd() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getEmpId() != null
				&& !orgEmpDeptPo.getEmpId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getEmpId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getSignLvlCd() != null
				&& !orgEmpDeptPo.getSignLvlCd().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getSignLvlCd() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getCurDrcDctId() != null
				&& !orgEmpDeptPo.getCurDrcDctId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getCurDrcDctId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		if (orgEmpDeptPo.getCurDeputyDrcDctId() != null
				&& !orgEmpDeptPo.getCurDeputyDrcDctId().equals(null)) {
			org_emp_dept_bf.append("'" + orgEmpDeptPo.getCurDeputyDrcDctId() + "'");
		} else {
			org_emp_dept_bf.append("''");
		}
		org_emp_dept_bf.append(",");
		org_emp_dept_bf.append("0");
		org_emp_dept_bf.append("  from dual )  ");
		org_emp_dept_bf.append("   where EMP_DEPT_CD = ");
		org_emp_dept_bf.append("'" + orgEmpDeptPo.getEmpDeptCd() + "'");
		log.debug("update  ..." + org_emp_dept_bf.toString());
		return org_emp_dept_bf.toString();

	}

	private String DeleteSql(OrgEmpDeptPo orgEmpDeptPo) {
		
		org_emp_dept_bf.delete(0, org_emp_dept_bf.length());
		
		org_emp_dept_bf.append("update   ORG_EMP_DEPT  set del_f =1  where emp_dept_cd ='");
		org_emp_dept_bf.append(orgEmpDeptPo.getEmpDeptCd() + "'");
		log.debug("delte ..." + org_emp_dept_bf.toString());
		return org_emp_dept_bf.toString();
	}

}
