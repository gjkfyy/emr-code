package szlh.iih.sync;
import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobMdDiService;
import pkuhit.md.DictionaryUpdateService;
import szlh.iih.sync.dao.CusMdDiDao;
import szlh.iih.sync.po.MdDiPo;
import xap.sv.annotation.Reference;

public class TaskJobMdDiServiceImpl implements TaskJobMdDiService {
	public static Logger log = LoggerFactory
			.getLogger(TaskJobMdDiServiceImpl.class);
	
	static StringBuffer md_di_bf = new StringBuffer();

	@Reference
	DictionaryUpdateService dictionaryUpdateService;
	
	@Autowired
	CusMdDiDao cusMdDiDao;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String search() {
		// TODO Auto-generated method stub
		SelectOptions options = SelectOptions.get().offset(0).limit(5000).count();	
		List<MdDiPo> list = cusMdDiDao.selectAll(options);
		StringBuffer sbI = new StringBuffer();
		StringBuffer sbU = new StringBuffer();
		StringBuffer sbD = new StringBuffer();
		// List<MdDiPo> list = new ArrayList();
		if (list != null) {
			int num = list.size();
			if (num > 0) {
				for (MdDiPo mdDiPo : list) {
					if (mdDiPo.getFlag().equals("I")) {
						String  isExistInIemr = "select count(*) from md_di where di_cd=?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {mdDiPo.getDiCd()}, Integer.class);
						if(intExistInIemr.intValue() == 1 ){
							mdDiPo.setFlag("U");
						}
					}else if (mdDiPo.getFlag().equals("U")) {
						String  isExistInIemr = "select count(*) from md_di where di_cd=?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {mdDiPo.getDiCd()}, Integer.class);
						if(intExistInIemr.intValue() == 0 ){
							mdDiPo.setFlag("I");
						}
					}
					if (mdDiPo.getFlag().equals("I")) {
						log.debug("start sync md_di  insert");
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						
						String sql = getInsertSql(mdDiPo);
						try {

							jdbcTemplate.execute(sql);
							cusMdDiDao.delete(mdDiPo);
						} catch (Exception e) {
							log.error("sync Md_di exception ..."
									+ e.getMessage());
						}
						finally{
							
						}
						
						sbI.append(",{'code':"+mdDiPo.getDiCd());
						sbI.append(",'name':"+mdDiPo.getNm()+"}");
						log.debug("end  sync md_di ");
					}
					if (mdDiPo.getFlag().equals("U")) {
						log.debug("start sync md_di  update ");
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						String sql = getUpdateSql(mdDiPo);
						
						try {
							jdbcTemplate.execute(sql);
							cusMdDiDao.delete(mdDiPo);
						} catch (Exception e) {
							log.error("sync Md_di exception ..."
									+ e.getMessage());
						}
						finally{
							
						}
						sbU.append(",{'code':"+mdDiPo.getDiCd());
						sbU.append(",'name':"+mdDiPo.getNm()+"}");
						log.debug("end  sync md_di ");
					}
					if (mdDiPo.getFlag().equals("D")) {
						log.debug("start sync md_di  delete");
//						log.debug("time:["
//								+ new java.util.Date().toLocaleString() + "]");
						String sql = getDeleteSql(mdDiPo);
						try {
							jdbcTemplate.execute(sql);
							cusMdDiDao.delete(mdDiPo);
						} catch (Exception e) {
							log.error("sync Md_di exception ..."
									+ e.getMessage());
						}
						finally{
							
						}
						sbD.append(",{'code':"+mdDiPo.getDiCd());
						sbD.append(",'name':"+mdDiPo.getNm()+"}");
					}
				}
				//cusMdDiDao.batchDelete(list);
				log.debug("end  sync md_di ");
			}

		}
		StringBuffer sb = new StringBuffer();
		if(sbI.length()>0){
			 sb.append(",'I':[").append(sbI.substring(1)).append("]"); 
		}
		if(sbU.length()>0){
			sb.append(",'U':[").append(sbU.substring(1)).append("]"); 
		}
		if(sbD.length()>0){
			sb.append(",'D':[").append(sbD.substring(1)).append("]"); 
		}
		String data = "{}";
		if(sb.length() > 0 ){
			data = "{"+ sb.substring(1).toString() +"}";
			dictionaryUpdateService.updateDictionaryByDictId("DIM01");
		}
		
		return "{'result':'success'}";
	}
	
   /**
    * getInsertSql
    * @param mdDiPo
    * @return
    */
	private String getInsertSql(MdDiPo mdDiPo) {
		//StringBuffer md_di_bf = new StringBuffer();
		md_di_bf.delete(0,md_di_bf.length());
		md_di_bf.append(" insert into md_di (");
		md_di_bf.append("DI_CD,NM,ICD_CD,SPELL_NO,ORG_CD,DEL_F) values (");
		if (mdDiPo.getDiCd() != null && !mdDiPo.getDiCd().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getDiCd() + "'");
			md_di_bf.append(",");
		}
		if (mdDiPo.getNm() != null && !mdDiPo.getNm().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getNm() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getIcdCd() != null && !mdDiPo.getIcdCd().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getIcdCd() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getSpellNo() != null && !mdDiPo.getSpellNo().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getSpellNo() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getOrgCd() != null && !mdDiPo.getOrgCd().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getOrgCd() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getDelF() != null && !mdDiPo.getDelF().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getDelF() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(")");
		log.debug("insert ..." + md_di_bf.toString());
		return md_di_bf.toString();
	}

	private String getUpdateSql(MdDiPo mdDiPo) {
		//StringBuffer md_di_bf = new StringBuffer();
		md_di_bf.delete(0,md_di_bf.length());
		md_di_bf.append(" update  md_di set  (");
		md_di_bf.append("NM,ICD_CD,SPELL_NO,ORG_CD,DEL_F) = ( select  ");

		if (mdDiPo.getNm() != null && !mdDiPo.getNm().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getNm() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getIcdCd() != null && !mdDiPo.getIcdCd().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getIcdCd() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getSpellNo() != null && !mdDiPo.getSpellNo().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getSpellNo() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getOrgCd() != null && !mdDiPo.getOrgCd().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getOrgCd() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(",");
		if (mdDiPo.getDelF() != null && !mdDiPo.getDelF().equals(null)) {
			md_di_bf.append("'" + mdDiPo.getDelF() + "'");
		} else {
			md_di_bf.append("''");
		}
		md_di_bf.append(" from dual )  where DI_CD ='" + mdDiPo.getDiCd() + "'");
		log.debug("update .." + md_di_bf.toString());
		return md_di_bf.toString();
	}

	private String getDeleteSql(MdDiPo mdDiPo) {
		//StringBuffer md_di_bf = new StringBuffer();
		md_di_bf.delete(0,md_di_bf.length());
		md_di_bf.append(" update md_di set del_f ='1' where di_cd = '"
				+ mdDiPo.getDiCd() + "'");
		log.debug("delete.." + md_di_bf.toString());
		return md_di_bf.toString();

	}
}
