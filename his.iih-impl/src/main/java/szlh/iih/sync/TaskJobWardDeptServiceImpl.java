package szlh.iih.sync;

import java.util.List;

import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import pkuhit.iih.sync.TaskJobWardDeptService;
import szlh.iih.sync.dao.CusWardDeptDao;
import szlh.iih.sync.po.WardDeptPo;
 

public class TaskJobWardDeptServiceImpl implements TaskJobWardDeptService {

public static Logger log = LoggerFactory.getLogger(TaskJobWardDeptServiceImpl.class);
	
  static StringBuffer ward_dept_bf = new StringBuffer();
  
	@Autowired
	CusWardDeptDao cusWardDeptDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Override
	public String search() {
		SelectOptions options = SelectOptions.get().offset(0).limit(5000).count();	
	    List<WardDeptPo>  list  =	cusWardDeptDao.selectAll(options);
	    if(list != null){
	    	int size = list.size();
	    	if(size >0){
	    	 log.debug("sync ward_dept  start...");
	    	 log.debug(" war_dept count = "+size);
	    	for (WardDeptPo wardDeptPo :list ){
				if (wardDeptPo.getFlag().equals("I")) {
					String  isExistInIemr = "select count(*) from ward_dept where dept_cd=?";
					Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {wardDeptPo.getDeptCd()}, Integer.class);
					if(intExistInIemr.intValue() == 1 ){
						wardDeptPo.setFlag("U");
					}
				}else if (wardDeptPo.getFlag().equals("U")) {
					String  isExistInIemr = "select count(*) from ward_dept where dept_cd=?";
					Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {wardDeptPo.getDeptCd()}, Integer.class);
					if(intExistInIemr.intValue() == 0 ){
						wardDeptPo.setFlag("I");
					}
				}
				
	    		 if(wardDeptPo.getFlag().equals("I")){
//	    			 log.debug("time:[" + new java.util.Date().toLocaleString()
//	                          + "]"); 
	    			 try{
		    			 jdbcTemplate.execute(InsertSql(wardDeptPo));
		    			 cusWardDeptDao.delete(wardDeptPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    			}
	    		 }
				if(wardDeptPo.getFlag().equals("U")){
					 try{
//					log.debug("time:[" + new java.util.Date().toLocaleString()
//	                          + "]");
						 jdbcTemplate.execute(UpdateSql(wardDeptPo));  		
						 cusWardDeptDao.delete(wardDeptPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    					
	    			}
				}
				if(wardDeptPo.getFlag().equals("D")){
				 try{
				//	log.debug("time:[" + new java.util.Date().toLocaleString()
//	                          + "]");
					 	jdbcTemplate.execute(DeleteSql(wardDeptPo));
					 	cusWardDeptDao.delete(wardDeptPo);
	    			 } catch (Exception e) {
	    					log.warn("sync org_emp exception ..." + e.getMessage());
	    					
	    			}
				}
	    	 }	
	    	
	    	 log.debug("sync ward_dept end ... ");
	    	}

	    }

	    return "{'result':'success'}";
	}
   
	private String InsertSql(WardDeptPo wardDeptPo){
		//StringBuffer ward_dept_bf = new StringBuffer();
		ward_dept_bf.delete(0, ward_dept_bf.length());
		
		ward_dept_bf.append(" insert into ward_dept (  ");
		ward_dept_bf.append("DEPT_CD,WARD_CD,ORG_CD,DEPT_TP_CD,NM, MEMO,SPELL_NO,DEL_F) values (");
		 if(wardDeptPo.getDeptCd() !=null && !wardDeptPo.getDeptCd().equals(null)){
		   ward_dept_bf.append("'"+wardDeptPo.getDeptCd()+"'");
		  }else{
			 ward_dept_bf.append("''");
		 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getWardCd() !=null && !wardDeptPo.getWardCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getWardCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 
		 if(wardDeptPo.getOrgCd() !=null && !wardDeptPo.getOrgCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getOrgCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getDeptTpCd() !=null && !wardDeptPo.getDeptTpCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getDeptTpCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getNm() !=null && !wardDeptPo.getNm().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getNm()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		
		 if(wardDeptPo.getMemo() !=null && !wardDeptPo.getMemo().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getMemo()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getSpellNo() !=null && !wardDeptPo.getSpellNo().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getSpellNo()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getDelF() !=null && !wardDeptPo.getDelF().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getDelF()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		  ward_dept_bf.append(")");
		  log.debug(" insert "+ward_dept_bf.toString());
		return ward_dept_bf.toString();
		
		
	}
	
	
	private String UpdateSql(WardDeptPo wardDeptPo){
		//StringBuffer ward_dept_bf = new StringBuffer();
		 ward_dept_bf.delete(0, ward_dept_bf.length());
		 ward_dept_bf.append("update ward_dept set ");
		 ward_dept_bf.append("(ORG_CD,WARD_CD,DEPT_TP_CD,NM, MEMO,SPELL_NO)");
		 ward_dept_bf.append("  =(select ");
		 if(wardDeptPo.getOrgCd() !=null && !wardDeptPo.getOrgCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getOrgCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 
		 if(wardDeptPo.getWardCd() !=null && !wardDeptPo.getWardCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getWardCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getDeptTpCd() !=null && !wardDeptPo.getDeptTpCd().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getDeptTpCd()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getNm() !=null && !wardDeptPo.getNm().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getNm()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		
		 if(wardDeptPo.getMemo() !=null && !wardDeptPo.getMemo().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getMemo()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }
		 ward_dept_bf.append(",");
		 if(wardDeptPo.getSpellNo() !=null && !wardDeptPo.getSpellNo().equals(null)){
			   ward_dept_bf.append("'"+wardDeptPo.getSpellNo()+"'");
			  }else{
				 ward_dept_bf.append("''");
			 }

		 ward_dept_bf.append("  from dual )  ");
		 ward_dept_bf.append("  where DEPT_CD = '");
		 ward_dept_bf.append(wardDeptPo.getDeptCd());
		 ward_dept_bf.append("'");
		 log.debug("update ..."+ward_dept_bf.toString());
		 return ward_dept_bf.toString();
	}
	
	private String DeleteSql(WardDeptPo wardDeptPo){
		//StringBuffer  ward_dept_bf = new StringBuffer();
		ward_dept_bf.delete(0, ward_dept_bf.length());
		ward_dept_bf.append("update   ward_dept   set  del_f =1  where dept_cd ='");
		ward_dept_bf.append(wardDeptPo.getDeptCd()+"'");
		 log.debug("delete  ..."+ward_dept_bf.toString());
		return ward_dept_bf.toString();
	}
	
	
}
