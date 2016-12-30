package szlh.iih.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobOrgEmpService;
import pkuhit.md.DictionaryUpdateService;
import szlh.iih.sync.dao.CusOrgEmpDao;
import szlh.iih.sync.po.XapOrgEmpPo;
import xap.sv.annotation.Reference;

public class TaskJobOrgEmpServiceImpl implements TaskJobOrgEmpService {
	public static Logger log = LoggerFactory.getLogger(TaskJobOrgEmpServiceImpl.class);
	
	static StringBuffer org_emp_bf = new StringBuffer();
	
	@Autowired
	CusOrgEmpDao cusOrgEmpDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Reference
	DictionaryUpdateService dictionaryUpdateService;
	
	@Override
	public String search() {
		// TODO Auto-generated method stub
	  List<XapOrgEmpPo> list = 	cusOrgEmpDao.selectAll();
	 
	  if (list != null ){
		  log.debug("start sync org_emp ...");
		int num = list.size();
		 log.debug("  org_emp  count = "+num);
		for(int i =0; i<num;i++){
			 
			XapOrgEmpPo xapOrgEmpPo = list.get(i);
			if (xapOrgEmpPo.getFlag().equals("I")) {
				String  isExistInIemr = "select count(*) from org_emp  where emp_id =?";
				Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {xapOrgEmpPo.getEmpId()}, Integer.class);
				if(intExistInIemr.intValue() == 1 ){
					xapOrgEmpPo.setFlag("U");
				}
			}else 			if (xapOrgEmpPo.getFlag().equals("U")) {
				String  isExistInIemr = "select count(*) from org_emp  where emp_id =?";
				Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {xapOrgEmpPo.getEmpId()}, Integer.class);
				if(intExistInIemr.intValue() == 0 ){
					xapOrgEmpPo.setFlag("I");
				}
			}
			
			if(xapOrgEmpPo.getFlag().equals("I")){
				 
				 try{
				    jdbcTemplate.execute(getInsertSql(xapOrgEmpPo));
				    cusOrgEmpDao.delete(xapOrgEmpPo);
				 }catch(Exception e){
						log.warn("sync insert org_emp exception ..."+e.getMessage());
						
					}
			 }
			if(xapOrgEmpPo.getFlag().equals("U")){
				 
				 try{
				   jdbcTemplate.execute(getUpdateSql(xapOrgEmpPo));
				   cusOrgEmpDao.delete(xapOrgEmpPo);
				 }catch(Exception e){
						log.warn("sync update  org_emp exception ..."+e.getMessage());
						
					}
			 }
			if(xapOrgEmpPo.getFlag().equals("D")){
			 
				try{
				    jdbcTemplate.execute(getDeleteSql(xapOrgEmpPo));
				    cusOrgEmpDao.delete(xapOrgEmpPo);
				 }catch(Exception e){
						log.warn("sync delete org_emp exception ..."+e.getMessage());
						
					}
			 }
		} 
		 //cusOrgEmpDao.batchDelete(list);
		 log.debug("end  sync org_emp ...");  
		 dictionaryUpdateService.updateDictionaryByDictId("ORGB04");
	  }
	  
	  return "{'result':'success'}";
	}

	
	private String getInsertSql(XapOrgEmpPo xapOrgEmpPo){
		//StringBuffer org_emp_bf = new StringBuffer();
		org_emp_bf.delete(0, org_emp_bf.length());
		org_emp_bf.append(" insert into org_emp (");
		org_emp_bf.append(" EMP_ID,DEPT_CD,EMP_NO,NM,NM_SPELL ,SEX_CD,BIRTHDAY,ID_CARD_NO,EMAIL,JOB_TITLE_CD,POSITION_CD,PROF_CD,TEL_NO,MOBILE_NO,IEMR_JOB_TITLE_CD,DEL_F)");
		org_emp_bf.append(" values (");
		if(xapOrgEmpPo.getEmpId() != null && !xapOrgEmpPo.getEmpId().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getEmpId()+"'");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getDeptCd() != null && !xapOrgEmpPo.getDeptCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getDeptCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		
		if(xapOrgEmpPo.getEmpNo() != null && !xapOrgEmpPo.getEmpNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getEmpNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getNm() != null && !xapOrgEmpPo.getNm().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getNm()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getNmSpell() != null && !xapOrgEmpPo.getNmSpell().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getNmSpell()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getSexCd() != null && !xapOrgEmpPo.getSexCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getSexCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getBirthday() != null && !xapOrgEmpPo.getBirthday().equals(null)){
			org_emp_bf.append(" to_date('"+xapOrgEmpPo.getBirthday()+"','yyyy-MM-DD hh24:mi:ss')");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getIdCardNo() != null && !xapOrgEmpPo.getIdCardNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getIdCardNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getEmail() != null && !xapOrgEmpPo.getEmail().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getEmail()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getJobTitleCd() != null && !xapOrgEmpPo.getJobTitleCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getJobTitleCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getPositionCd() != null && !xapOrgEmpPo.getPositionCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getPositionCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getProfCd() != null && !xapOrgEmpPo.getProfCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getProfCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getTelNo() != null && !xapOrgEmpPo.getTelNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getTelNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		
		if(xapOrgEmpPo.getMobileNo() != null && !xapOrgEmpPo.getMobileNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getMobileNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getIemrJobTitleCd() != null && !xapOrgEmpPo.getIemrJobTitleCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getIemrJobTitleCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getDelF() != null && !xapOrgEmpPo.getDelF().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getDelF()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(")");
		log.debug("insert ..."+org_emp_bf.toString());
		return org_emp_bf.toString();
	}
	
	
	private String getUpdateSql(XapOrgEmpPo xapOrgEmpPo){
		//StringBuffer org_emp_bf = new StringBuffer();
		org_emp_bf.delete(0, org_emp_bf.length());
		org_emp_bf.append(" update org_emp set (");
		org_emp_bf.append(" DEPT_CD,EMP_NO,NM,NM_SPELL ,SEX_CD,BIRTHDAY,ID_CARD_NO,EMAIL,JOB_TITLE_CD,POSITION_CD,PROF_CD,TEL_NO,MOBILE_NO,IEMR_JOB_TITLE_CD,DEL_F)");
		org_emp_bf.append("  = ( select  ");
		
		if(xapOrgEmpPo.getDeptCd() != null && !xapOrgEmpPo.getDeptCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getDeptCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		
		if(xapOrgEmpPo.getEmpNo() != null && !xapOrgEmpPo.getEmpNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getEmpNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getNm() != null && !xapOrgEmpPo.getNm().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getNm()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getNmSpell() != null && !xapOrgEmpPo.getNmSpell().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getNmSpell()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getSexCd() != null && !xapOrgEmpPo.getSexCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getSexCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getBirthday() != null && !xapOrgEmpPo.getBirthday().equals(null)){
			org_emp_bf.append(" to_date('"+xapOrgEmpPo.getBirthday()+"','yyyy-MM-DD hh24:mi:ss')");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getIdCardNo() != null && !xapOrgEmpPo.getIdCardNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getIdCardNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getEmail() != null && !xapOrgEmpPo.getEmail().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getEmail()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getJobTitleCd() != null && !xapOrgEmpPo.getJobTitleCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getJobTitleCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getPositionCd() != null && !xapOrgEmpPo.getPositionCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getPositionCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getProfCd() != null && !xapOrgEmpPo.getProfCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getProfCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getTelNo() != null && !xapOrgEmpPo.getTelNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getTelNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		
		if(xapOrgEmpPo.getMobileNo() != null && !xapOrgEmpPo.getMobileNo().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getMobileNo()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getIemrJobTitleCd() != null && !xapOrgEmpPo.getIemrJobTitleCd().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getIemrJobTitleCd()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(",");
		if(xapOrgEmpPo.getDelF() != null && !xapOrgEmpPo.getDelF().equals(null)){
			org_emp_bf.append("'"+xapOrgEmpPo.getDelF()+"'");
		}else{
			org_emp_bf.append("''");
		}
		org_emp_bf.append(" from dual ) where emp_id =  '"+xapOrgEmpPo.getEmpId()+"'");
		
		log.debug("update .."+org_emp_bf.toString());
		return org_emp_bf.toString();
	}
	
	private String getDeleteSql(XapOrgEmpPo xapOrgEmpPo){
		//StringBuffer org_emp_bf = new StringBuffer();
		org_emp_bf.delete(0, org_emp_bf.length());
		org_emp_bf.append("update org_emp set del_f = '1' where emp_id='"+xapOrgEmpPo.getEmpId()+"'");
		log.debug("delte .."+org_emp_bf.toString());
		return org_emp_bf.toString();
	}
}
