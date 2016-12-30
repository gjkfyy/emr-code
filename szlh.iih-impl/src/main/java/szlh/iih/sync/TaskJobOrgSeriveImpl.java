package szlh.iih.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobOrgService;
import pkuhit.md.DictionaryUpdateService;
import szlh.iih.sync.dao.CusOrgDao;
import szlh.iih.sync.po.OrgPo;
import xap.sv.annotation.Reference;

public class TaskJobOrgSeriveImpl implements TaskJobOrgService {
	public static Logger log = LoggerFactory.getLogger(TaskJobOrgService.class);
    
	static StringBuffer org_bf = new StringBuffer();
	
	@Autowired
	CusOrgDao cusOrgDao;

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Reference
	DictionaryUpdateService dictionaryUpdateService;
   /**
    * search
    */
	@Override
	public String search() {

		List<OrgPo> OrgList = cusOrgDao.selectAll();
		if (OrgList != null) {
			
			int size = OrgList.size();
			if (size > 0) {
				log.debug("sync org start...");
				log.debug(" org count = " + size);
				for (OrgPo orgPo : OrgList) {
					if (orgPo.getFlag().equals("I")) {
						String  isExistInIemr = "select count(*) from org where org_cd=?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {orgPo.getOrgCd()}, Integer.class);
						if(intExistInIemr.intValue() == 1 ){
							orgPo.setFlag("U");
						}
					} else if (orgPo.getFlag().equals("U")) {
						String  isExistInIemr = "select count(*) from org where org_cd=?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {orgPo.getOrgCd()}, Integer.class);
						if(intExistInIemr.intValue() == 0 ){
							orgPo.setFlag("I");
						}
					}
					if (orgPo.getFlag().equals("I")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						ExecuteInsertSql(orgPo);
					}
					if (orgPo.getFlag().equals("U")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						ExecuteUpdateSql(orgPo);
					}
					if (orgPo.getFlag().equals("D")) {
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						ExecuteDeleteSql(orgPo);
					}
				}
				//cusOrgDao.batchDelete(OrgList);
				log.debug("sync org end ... ");
			}
			dictionaryUpdateService.updateDictionaryByDictId("ORGB01");
		}

		return "{'result':'success'}";
	}
	
     /**
      * InsertSql
      * @param orgPo
      * @return
      */
	private String InsertSql(OrgPo orgPo) {
		//StringBuffer org_bf = new StringBuffer();
		org_bf.delete(0, org_bf.length());
		org_bf.append(" insert into org (");
		org_bf.append("ORG_CD , ORG_TP_CD,  NM ,  DES ,  SHT_NM ,  ALIAS_NM , DIST_CD ,  SUBDIST_NM ,  ZIP_NO ,  TEL_NO ,  SPELL_NO, Del_F) values (");
		if (orgPo.getOrgCd() != null && !orgPo.getOrgCd().equals(null)) {
			org_bf.append("'" + orgPo.getOrgCd() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getOrgTpCd() != null && !orgPo.getOrgTpCd().equals(null)) {
			org_bf.append("'" + orgPo.getOrgTpCd() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getNm() != null && !orgPo.getNm().equals(null)) {
			org_bf.append("'" + orgPo.getNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getDes() != null && !orgPo.getDes().equals(null)) {
			org_bf.append("'" + orgPo.getDes() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getShtNm() != null && !orgPo.getShtNm().equals(null)) {
			org_bf.append("'" + orgPo.getShtNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getAliasNm() != null && !orgPo.getAliasNm().equals(null)) {
			org_bf.append("'" + orgPo.getAliasNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getDistCd() != null && !orgPo.getDistCd().equals(null)) {
			org_bf.append("'" + orgPo.getDistCd() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getSubdistNm() != null && !orgPo.getSubdistNm().equals(null)) {
			org_bf.append("'" + orgPo.getSubdistNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getZipNo() != null && !orgPo.getZipNo().equals(null)) {
			org_bf.append("'" + orgPo.getZipNo() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getTelNo() != null && !orgPo.getTelNo().equals(null)) {
			org_bf.append("'" + orgPo.getTelNo() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getSpellNo() != null && !orgPo.getSpellNo().equals(null)) {
			org_bf.append("'" + orgPo.getSpellNo() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		org_bf.append("'" + orgPo.getDelF() + "'");
		org_bf.append(")");
        log.debug(" insert ..."+org_bf.toString());
		return org_bf.toString();

	}
	
    /**
     * UpdateSql
     * @param orgPo
     * @return
     */
	private String UpdateSql(OrgPo orgPo) {
		//StringBuffer org_bf = new StringBuffer();
		org_bf.delete(0, org_bf.length());
		org_bf.append("update org set ");
		org_bf.append("(ORG_TP_CD,  NM ,  DES ,  SHT_NM ,  ALIAS_NM , DIST_CD ,  SUBDIST_NM ,  ZIP_NO ,  TEL_NO )");
		org_bf.append(" =(select ");
		if (orgPo.getOrgTpCd() != null && !orgPo.getOrgTpCd().equals(null)) {
			org_bf.append("'" + orgPo.getOrgTpCd() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getNm() != null && !orgPo.getNm().equals(null)) {
			org_bf.append("'" + orgPo.getNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getDes() != null && !orgPo.getDes().equals(null)) {
			org_bf.append("'" + orgPo.getDes() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getShtNm() != null && !orgPo.getShtNm().equals(null)) {
			org_bf.append("'" + orgPo.getShtNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getAliasNm() != null && !orgPo.getAliasNm().equals(null)) {
			org_bf.append("'" + orgPo.getAliasNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getDistCd() != null && !orgPo.getDistCd().equals(null)) {
			org_bf.append("'" + orgPo.getDistCd() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getSubdistNm() != null && !orgPo.getSubdistNm().equals(null)) {
			org_bf.append("'" + orgPo.getSubdistNm() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getZipNo() != null && !orgPo.getZipNo().equals(null)) {
			org_bf.append("'" + orgPo.getZipNo() + "'");
		} else {
			org_bf.append("''");
		}
		org_bf.append(",");
		if (orgPo.getTelNo() != null && !orgPo.getTelNo().equals(null)) {
			org_bf.append("'" + orgPo.getTelNo() + "'");
		} else {
			org_bf.append("''");
		}

		org_bf.append("  from dual )");
		org_bf.append("where ORG_CD = '");
		org_bf.append(orgPo.getOrgCd());
		org_bf.append("'");
		log.debug("update ... "+org_bf.toString());
		return org_bf.toString();
	}
    /**
     * DeleteSql
     * @param orgPo
     * @return
     */
	private String DeleteSql(OrgPo orgPo) {
		//StringBuffer org_bf = new StringBuffer();
		org_bf.delete(0, org_bf.length());
		org_bf.append("update   org  set del_f =1  where ORG_CD ='");
		org_bf.append(orgPo.getOrgCd() + "'");
		log.debug("delete .."+org_bf.toString());
		return org_bf.toString();
	}
    /**
     * ExecuteInsertSql
     * @param orgPo
     */
	private void ExecuteInsertSql(OrgPo orgPo) {
		try {
			jdbcTemplate.execute(InsertSql(orgPo));
			cusOrgDao.delete(orgPo);
		} catch (Exception e) {
			log.warn("sync org_emp exception ..." + e.getMessage());
			
		}
	}
    /**
     * ExecuteUpdateSql
     * @param orgPo
     */
	private void ExecuteUpdateSql(OrgPo orgPo) {
		try {
			jdbcTemplate.execute(UpdateSql(orgPo));
			cusOrgDao.delete(orgPo);
		} catch (Exception e) {
			log.warn("sync org_emp exception ..." + e.getMessage());
			
		}
	}
   /**
    * ExecuteDeleteSql
    * @param orgPo
    */
	private void ExecuteDeleteSql(OrgPo orgPo) {
		try {
			jdbcTemplate.execute(DeleteSql(orgPo));
			cusOrgDao.delete(orgPo);
		} catch (Exception e) {
			log.warn("sync org_emp exception ..." + e.getMessage());
			
		}
	}
}
