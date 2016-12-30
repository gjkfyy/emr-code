package szlh.iih.sync;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobOrgEmpDeptService;
import pkuhit.iih.sync.TaskJobOrgEmpService;
import pkuhit.iih.sync.TaskJobOrgService;
import pkuhit.iih.sync.TaskJobWardDeptService;
import pkuhit.iih.sync.TaskJobXapUserService;
import pkuhit.md.DictionaryUpdateService;
import szlh.iih.sync.dao.CusXapUserDao;
import szlh.iih.sync.po.XapUserPo;
import xap.sv.annotation.Reference;

 

public class TaskJobXapuserServiceImpl implements TaskJobXapUserService {
	public static Logger log = LoggerFactory.getLogger(TaskJobXapuserServiceImpl.class);
	
	static StringBuffer xap_user_bf = new StringBuffer();
	
	@Autowired
	CusXapUserDao cusXapuserDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	TaskJobOrgEmpDeptService taskJobOrgEmpDeptService;
	
	@Autowired
	TaskJobOrgEmpService taskJobOrgEmpService;
	
	@Autowired
	TaskJobOrgService TaskJobOrgSerive;
	
	@Autowired
	TaskJobWardDeptService taskJobWardDeptService;
	
	@Reference
	DictionaryUpdateService dictionaryUpdateService;
	
	
	@Override
	public String search() {
		// TODO Auto-generated method stub
		
		List<XapUserPo> ListXapUser = cusXapuserDao.selectAll();
		StringBuffer sbI = new StringBuffer();
		StringBuffer sbU = new StringBuffer();
		StringBuffer sbD = new StringBuffer();
		 if(ListXapUser != null){
			
			 int num = ListXapUser.size();
			 if(num >0){
				 log.debug("sync xap_user start....");
				 log.debug("  xap_user  count = "+num);
				for(XapUserPo xapUserPo:ListXapUser){
					if (xapUserPo.getFlag().equals("I")) {
						String  isExistInIemr = "select count(*) from XAP_USER where XAP_USER_PK =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {xapUserPo.getXapUserPk()}, Integer.class);
						if(intExistInIemr.intValue() == 1 ){
							xapUserPo.setFlag("U");
						}
					}else if (xapUserPo.getFlag().equals("U")) {
						String  isExistInIemr = "select count(*) from XAP_USER where XAP_USER_PK =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {xapUserPo.getXapUserPk()}, Integer.class);
						if(intExistInIemr.intValue() == 0 ){
							xapUserPo.setFlag("I");
						}
					}
					 if(xapUserPo.getFlag().equals("I")){
						 try{
//						 log.debug("time:[" + new java.util.Date().toLocaleString()
//		                          + "]");
							sbI.append(",{'code':"+xapUserPo.getXapUserPk());
							sbI.append(",'name':"+xapUserPo.getNm()+"}");
						 ExecuteInsertSql(xapUserPo);
						 cusXapuserDao.delete(xapUserPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    					
	    			}
					 }
					if(xapUserPo.getFlag().equals("U")){
						 try{
//						log.debug("time:[" + new java.util.Date().toLocaleString()
//		                          + "]");
						sbU.append(",{'code':"+xapUserPo.getXapUserPk());
						sbU.append(",'name':"+xapUserPo.getNm()+"}");
						ExecuteUpdateSql(xapUserPo);	
						 cusXapuserDao.delete(xapUserPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    					
	    			}
										 }
					if(xapUserPo.getFlag().equals("D")){
						 try{
//						log.debug("time:[" + new java.util.Date().toLocaleString()
//		                          + "]");
						sbD.append(",{'code':"+xapUserPo.getXapUserPk());
						sbD.append(",'name':"+xapUserPo.getNm()+"}");
						ExecuteDeleteSql(xapUserPo);
						 cusXapuserDao.delete(xapUserPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    					
	    			}
					}
				}  
				 
				 log.debug("sync xap_user end....");
			 }
			 dictionaryUpdateService.updateDictionaryByDictId("XAPM12");
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
			}
			return "{'result':'success','data':"+data+"}";
	}
    
	@Override
    public String batchSearch() {
		String rs = this.search();
        taskJobOrgEmpDeptService.search();
        taskJobOrgEmpService.search();
        TaskJobOrgSerive.search();
        taskJobWardDeptService.search();
	    return rs;
    }
	
	private String InsertSql(XapUserPo xapUserPo){
		//StringBuffer xap_user_bf = new StringBuffer();
		xap_user_bf.delete(0, xap_user_bf.length());
		xap_user_bf.append(" insert into XAP_USER (");
		xap_user_bf.append("XAP_USER_PK , USER_ID,  EMP_ID , USER_STA_CD, SIGN_PIC, PWD, IEMR_PWD, NM, NM_SPELL, SEX_CD, EMAIL, JOB_TITLE_CD, MOBILE_NO, TEL_NO, ORG_CD, LOGIN_NM,Del_F) values (");
		if(xapUserPo.getXapUserPk() != null && !xapUserPo.getXapUserPk().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getXapUserPk()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getUserId() != null && !xapUserPo.getUserId().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getUserId().trim()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getEmpId() != null && !xapUserPo.getEmpId().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getEmpId().trim()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getUserStaCd() != null && !xapUserPo.getUserStaCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getUserStaCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getSignPic() != null && !xapUserPo.getSignPic().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getSignPic()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getPwd() != null && !xapUserPo.getPwd().equals(null)  && !xapUserPo.getPwd().equals("") && xapUserPo.getPwd() != "" ){
			xap_user_bf.append("'"+xapUserPo.getPwd()+"'");
		 }else{
			 xap_user_bf.append("'MTIzNA=='");
		 }
		xap_user_bf.append(",");
        xap_user_bf.append("'MTIzNA=='");
		 xap_user_bf.append(",");
		if(xapUserPo.getNm() != null && !xapUserPo.getNm().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getNm()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getNmSpell() != null && !xapUserPo.getNmSpell().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getNmSpell().toLowerCase()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getSexCd() != null && !xapUserPo.getSexCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getSexCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getEmail() != null && !xapUserPo.getEmail().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getEmail()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getJobTitleCd() != null && !xapUserPo.getJobTitleCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getJobTitleCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getMobileNo() != null && !xapUserPo.getMobileNo().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getMobileNo()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getTelNo() != null && !xapUserPo.getTelNo().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getTelNo()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getOrgCd() != null && !xapUserPo.getOrgCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getOrgCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }  
		 xap_user_bf.append(",");
		if(xapUserPo.getLoginNm() != null && !xapUserPo.getLoginNm().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getLoginNm()+"'");
		 }else{
			 xap_user_bf.append("''");
		 } 
		 xap_user_bf.append(",");
	    xap_user_bf.append("'"+xapUserPo.getDelF()+"'");
		xap_user_bf.append(" )");
		 log.debug("insert xap_user .."+xap_user_bf.toString());
		return xap_user_bf.toString();
	}
	
	private String UpdateSql(XapUserPo xapUserPo){
		 
		xap_user_bf.delete(0, xap_user_bf.length());
		xap_user_bf.append("update XAP_USER set (");
		xap_user_bf.append(" USER_ID,  EMP_ID , USER_STA_CD, SIGN_PIC, PWD, NM, NM_SPELL, SEX_CD, EMAIL, JOB_TITLE_CD, MOBILE_NO, TEL_NO, ORG_CD, LOGIN_NM)");
		xap_user_bf.append(" = ( select ");
		if(xapUserPo.getUserId() != null && !xapUserPo.getUserId().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getUserId()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getEmpId() != null && !xapUserPo.getEmpId().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getEmpId()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getUserStaCd() != null && !xapUserPo.getUserStaCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getUserStaCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getSignPic() != null && !xapUserPo.getSignPic().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getSignPic()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if( xapUserPo.getPwd() != null && !xapUserPo.getPwd().equals(null) && !xapUserPo.getPwd().equals("") && xapUserPo.getPwd() != "" ){
			xap_user_bf.append("'"+xapUserPo.getPwd()+"'");
		 }else{
			 xap_user_bf.append("'MTIzNA=='"); 
		 }
		
		 xap_user_bf.append(",");
		if(xapUserPo.getNm() != null && !xapUserPo.getNm().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getNm()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getNmSpell() != null && !xapUserPo.getNmSpell().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getNmSpell()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getSexCd() != null && !xapUserPo.getSexCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getSexCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getEmail() != null && !xapUserPo.getEmail().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getEmail()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getJobTitleCd() != null && !xapUserPo.getJobTitleCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getJobTitleCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getMobileNo() != null && !xapUserPo.getMobileNo().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getMobileNo()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getTelNo() != null && !xapUserPo.getTelNo().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getTelNo()+"'");
		 }else{
			 xap_user_bf.append("''");
		 }
		 xap_user_bf.append(",");
		if(xapUserPo.getOrgCd() != null && !xapUserPo.getOrgCd().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getOrgCd()+"'");
		 }else{
			 xap_user_bf.append("''");
		 } 
		 xap_user_bf.append(",");
		if(xapUserPo.getLoginNm() != null && !xapUserPo.getLoginNm().equals(null)){
			xap_user_bf.append("'"+xapUserPo.getLoginNm()+"'");
		 }else{
			 xap_user_bf.append("''");
		 } 
		  
		xap_user_bf.append("  from dual)");
		xap_user_bf.append( " where XAP_USER_PK = '"+xapUserPo.getXapUserPk()+"'");
		log.debug("update xap_user..."+xap_user_bf.toString());
		return xap_user_bf.toString();
	}
	
	private String DeleteSql(XapUserPo xapUserPo){
		xap_user_bf.delete(0, xap_user_bf.length());
		xap_user_bf.append("update    XAP_USER  set del_f =1  where XAP_USER_PK ='");
		xap_user_bf.append(xapUserPo.getXapUserPk()+"'");
		log.debug("delete  xap_user ... "+xap_user_bf.toString());
		return xap_user_bf.toString();
		
	}
	
	/**
	 * ExecuteInsertSql
	 * @param xapUserPo
	 */
	private void ExecuteInsertSql(XapUserPo xapUserPo){
		 try{
	      	jdbcTemplate.execute(InsertSql(xapUserPo));
		 }catch(Exception e){
			 log.warn(" insert xap_user exception .."+e.getMessage());
			 cusXapuserDao.delete(xapUserPo);
		 }
	}
	 
	/**
	 * ExecuteUpdateSql
	 * @param xapUserPo
	 */
	private void ExecuteUpdateSql(XapUserPo xapUserPo){
 
		try{
	     	jdbcTemplate.execute(UpdateSql(xapUserPo));
		}catch(Exception e){
			 log.warn(" update xap_user exception .."+e.getMessage());
			 cusXapuserDao.delete(xapUserPo);
		 }
	}
	
	/**
	 * ExecuteDeleteSql
	 * @param xapUserPo
	 */
	private void ExecuteDeleteSql(XapUserPo xapUserPo){ 
		try{
		   jdbcTemplate.execute(DeleteSql(xapUserPo));
	   }catch(Exception e){
		 log.warn(" delete  xap_user exception .."+e.getMessage());
		 cusXapuserDao.delete(xapUserPo);
	 }
	}
	
	
	
	
	
}
