package szlh.iih.sync;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.sync.TaskJobMrAmrService;
import pkuhit.xap.pm.ParamsSetService;
import szlh.iih.en.dao.PatientDao;
import szlh.iih.en.po.PatientPo;
import szlh.iih.sync.dao.CusMrAmrDao;
import szlh.iih.sync.po.MrAmrPo;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;

public class TaskJobMrAmrServiceImpl implements TaskJobMrAmrService {
	public static Logger log = LoggerFactory
			.getLogger(TaskJobMrAmrServiceImpl.class);
	@Autowired
	PatientDao getPatientFromVwMdPaDao;
	@Reference
	ParamsSetService paramsSetService ;
	
	//是否执行
	private static boolean isRun = false;
	//字符串 sql
	public static StringBuffer bf ;
	//字符串 sql
	private static StringBuffer sql;
	//批量删除的集合
	private static List<MrAmrPo> D_list= new ArrayList();
	 static {
		   bf  =new StringBuffer();
		  sql = new StringBuffer();
 	  }
	 
	@Autowired
	CusMrAmrDao mrAmrDao;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class })
	public String search() {
		// TODO Auto-generated method stub
		 if(isRun){
			 log.debug("任务执行中....");
			 return "";
		 }
		try {
			
			long cx_s = System.currentTimeMillis();
			SelectOptions options = SelectOptions.get().offset(0).limit(5000).count();	
			List<MrAmrPo> MrList = mrAmrDao.selectAll(options);
			long cx_e = System.currentTimeMillis();
			log.debug(" 查询mrAmr时间====================."+(cx_e-cx_s));
			if (MrList != null) {
				int num = MrList.size();
				if (num > 0) {
					log.debug(" mr_amr count  = " + num);
					log.debug("sync mr_amr start ....");
					isRun = true;
					for (MrAmrPo mrAmrPo : MrList) {
						if (mrAmrPo.getFlag().equals("I")) {
							String  isExistInIemr = "select count(*) from mr_amr where en_pk =?";
							Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {mrAmrPo.getEnPk()}, Integer.class);
							if(intExistInIemr.intValue() == 1 ){
								mrAmrPo.setFlag("U");
							}
						}else if (mrAmrPo.getFlag().equals("U")) {
							String  isExistInIemr = "select count(*) from mr_amr where en_pk =?";
							Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {mrAmrPo.getEnPk()}, Integer.class);
							if(intExistInIemr.intValue() == 0 ){
								mrAmrPo.setFlag("I");
							}
						}
						
						// 新增加就诊
						if (mrAmrPo.getFlag().equals("I")) {
							log.debug("sync mr_mar...start insert....");
							getInsertMastDctId(mrAmrPo);
							InsertOracle(mrAmrPo);
							log.debug("sync mr_mar... end insert....");
						}
						// 修改就诊
						if (mrAmrPo.getFlag().equals("U")) {
							getUpdateMastDctId(mrAmrPo);
							UpdateOracle(mrAmrPo);
							log.debug("sync mr_amr>....update....end");
						}
						// 就诊删除
						if (mrAmrPo.getFlag().equals("D")) {
							DeleteOracleMrAmr(mrAmrPo);
							log.debug("sync mr_amr >....delete....end");
						}
					}
					//log.debug("time:[" + new java.util.Date().toLocaleString()+ "]");
					
					 //删除
					log.debug("D_list======="+D_list.size());
					long dl = System.currentTimeMillis();
					//mrAmrDao.batchDelete(D_list);
					long de = System.currentTimeMillis();
					log.debug(" batch 删除总时间====================."+(de-dl));
					D_list.clear(); 
				}
				else{
					log.info("MrList size is 0 ");
				}
			}else{
				log.info("MrList != null");
			}
		} catch (Exception e) {
			log.warn("sync mr_amr .Exception...." + e.getMessage());
			isRun = false;
			D_list.clear();
		}
		isRun = false;
		return "{'result':'success'}";
	}

	/**
	 * 
	 * @param mrAmrPo
	 */
     private void getInsertMastDctId(MrAmrPo mrAmrPo){
    	 getSuperiorDoctorId(mrAmrPo);
     }
	
     
     /**
      * 设置主管医生的 上级医生
      * @param mrAmrPo
      */
     private void getSuperiorDoctorId(MrAmrPo mrAmrPo){
    	 
    	 try{
	    	 if (mrAmrPo != null){
	    		  sql.delete(0, sql.length());
	    		  sql.append("SELECT CUR_DRC_DCT_ID,CUR_DEPUTY_DRC_DCT_ID FROM ORG_EMP_DEPT WHERE EMP_ID ='");
	    		  sql.append(mrAmrPo.getCurMngDctId()+"' AND  WARD_DEPT_CD = '");
	    		  sql.append(mrAmrPo.getCurDeptCd()+"'  AND DEL_F ='0' ");
	    		  List<Map<String,Object>> list =  jdbcTemplate.queryForList(sql.toString());
	    		  if(list != null && list.size() > 0 ){
	    			 Map map = list.get(0);
	    		     log.debug("---"+map.size());
			    	 if(map.get("CUR_DEPUTY_DRC_DCT_ID") != null){
			   		      mrAmrPo.setCurMojDctId(map.get("CUR_DEPUTY_DRC_DCT_ID").toString());
			   		   }
			   		  if(map.get("CUR_DRC_DCT_ID") != null){
			   		     mrAmrPo.setCurDrcDctId(map.get("CUR_DRC_DCT_ID").toString());
			   		 }
	    	       }
	    	    }
    	  }catch(Exception e){
    		  log.warn("getInsertMastDctId  method exception : "+sql.toString());
    		  log.warn("getInsertMastDctId  method exception : "+e.getMessage());
    	 } 
     }
     
     
     
     /**
      * 
      * @param mrAmrPo
      */
     private void getUpdateMastDctId(MrAmrPo mrAmrPo){
    	     Map<String,Object> map = new HashMap();
    	 try{
	    	 if (mrAmrPo != null){
	    		 sql.delete(0, sql.length());
	    		 sql.append(" SELECT CUR_MNG_DCT_ID,CUR_DRC_DCT_ID,CUR_MOJ_DCT_ID,CUR_DEPT_CD FROM MR_AMR WHERE EN_PK ='");
	    		 sql.append(mrAmrPo.getEnPk()+"'");
	    		 List<Map<String,Object>> list=  jdbcTemplate.queryForList(sql.toString());
	    		 if(list != null && list.size() > 0) {
	    		   map = list.get(0);
	    		  if (map.get("CUR_MNG_DCT_ID") != null && map.get("CUR_DEPT_CD") != null){
		    		   String CurMngDctId = map.get("CUR_MNG_DCT_ID").toString();
		    		   String CurDeptCd = map.get("CUR_DEPT_CD").toString();
		    		  if(!mrAmrPo.getCurMngDctId().equals(CurMngDctId) && !mrAmrPo.getCurDeptCd().equals(CurDeptCd)){
		    			   getSuperiorDoctorId(mrAmrPo);
		    		 }else{
		    			 if(map.get("CUR_MOJ_DCT_ID") != null){
		       		      mrAmrPo.setCurMojDctId(map.get("CUR_MOJ_DCT_ID").toString());
		       		     }
			       		 if(map.get("CUR_DRC_DCT_ID") != null){
			       		     mrAmrPo.setCurDrcDctId(map.get("CUR_DRC_DCT_ID").toString());
			       		 }
		    		  }
		    	    }
	    		 }    		 
	    	  } 
    	 }catch(Exception e){
    		    if(map.get("CUR_MOJ_DCT_ID") != null){
      		      mrAmrPo.setCurMojDctId(map.get("CUR_MOJ_DCT_ID").toString());
      		    }
	       		 if(map.get("CUR_DRC_DCT_ID") != null){
	       		     mrAmrPo.setCurDrcDctId(map.get("CUR_DRC_DCT_ID").toString());
	       		}
	       		 log.warn("getUpdateMastDctId method exception : "+e.getMessage());
	       		 log.warn("getInsertMastDctId  method exception : "+sql.toString());	  
    	 }
     }
     
     
	
	
	private String getInsertSql(MrAmrPo mrAmrPo) {
		bf.delete(0, bf.length());
		bf.append(" insert into mr_amr (");
		bf.append("EN_PK,PA_ID,EN_CNT,PA_NM,SEX_CD,AGE,ORG_CD,AMR_NO,EN_NO,");
		bf.append("EN_TP_CD,EN_STA_CD,AMR_STA_CD,AMR_RANK_CD,REG_TIME,REG_USER_ID,");
		bf.append("REG_DEPT_CD,RCV_USER_ID,RCV_DEPT_CD,RCV_TIME,ILL_STA_CD,NU_LVL_CD,CUR_MAIN_DI_CD,CUR_DEPT_CD,");
		bf.append("CUR_DEPT_INTO_TIME,CUR_WARD_CD,CUR_WARD_INTO_TIME,CUR_GRP_CD,CUR_BED_CD,");
		bf.append("CUR_MNG_DCT_ID,CUR_MOJ_DCT_ID,CUR_DRC_DCT_ID,CUR_MNG_NUR_ID,SU_F,DEATH_F,");
		bf.append("READM_F,CALL_BACK_F,FLUP_VISIT_F,FNSH_TIME,FNSH_USER_ID,FNSH_DEPT_CD,PA_INSUR_CD,PA_INSUR_NM )");
		bf.append(" values (");
		if (mrAmrPo.getEnPk() != null) {
			bf.append("'" + mrAmrPo.getEnPk() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getPaId() != null && !mrAmrPo.getPaId().equals(null)) {
			bf.append("'" + mrAmrPo.getPaId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnCnt() != null && !mrAmrPo.getEnCnt().equals(null)) {
			bf.append("'" + mrAmrPo.getEnCnt() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getPaNm() != null && !mrAmrPo.getPaNm().equals(null)) {
			bf.append("'" + mrAmrPo.getPaNm() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getSexCd() != null && !mrAmrPo.getSexCd().equals(null)) {
			bf.append("'" + mrAmrPo.getSexCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getAge() != null && !mrAmrPo.getAge().equals(null)) {
			bf.append("'" + mrAmrPo.getAge() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getOrgCd() != null) {
			bf.append("'" + mrAmrPo.getOrgCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getAmrNo() != null && !mrAmrPo.getAmrNo().equals(null)) {
			bf.append("'" + mrAmrPo.getAmrNo() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnNo() != null && !mrAmrPo.getEnNo().equals(null)) {
			bf.append("'" + mrAmrPo.getEnNo() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getEnTpCd() != null && !mrAmrPo.getEnTpCd().equals(null)) {
			bf.append("'" + mrAmrPo.getEnTpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnStaCd() != null && !mrAmrPo.getEnStaCd().equals(null)) {
			bf.append("'" + mrAmrPo.getEnStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getAmrStaCd() != null
				&& !mrAmrPo.getAmrStaCd().equals(null)) {
			bf.append("'" + mrAmrPo.getAmrStaCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getAmrRankCd() != null
				&& !mrAmrPo.getAmrRankCd().equals(null)) {
			bf.append("'" + mrAmrPo.getAmrRankCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getRegTime() != null && !mrAmrPo.getRegTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getRegTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRegUserId() != null
				&& !mrAmrPo.getRegUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getRegUserId() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRegDeptCd() != null
				&& !mrAmrPo.getRegDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getRegDeptCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getRcvUserId() != null
				&& !mrAmrPo.getRcvUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getRcvUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getRcvDeptCd() != null
				&& !mrAmrPo.getRcvDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getRcvDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRcvTime() != null && !mrAmrPo.getRcvTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getRcvTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getIllStaCd() != null
				&& !mrAmrPo.getIllStaCd().equals(null)) {
			bf.append("'" + mrAmrPo.getIllStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getNuLvlCd() != null && !mrAmrPo.getNuLvlCd().equals(null)) {
			bf.append("'" + mrAmrPo.getNuLvlCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurMainDiCd() != null
				&& !mrAmrPo.getCurMainDiCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMainDiCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurDeptCd() != null
				&& !mrAmrPo.getCurDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurDeptInfoTime() != null
				&& !mrAmrPo.getCurDeptInfoTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getCurDeptInfoTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurWardCd() != null
				&& !mrAmrPo.getCurWardCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurWardCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurWardInfoTime() != null
				&& !mrAmrPo.getCurWardInfoTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getCurWardInfoTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurGrpCd() != null
				&& !mrAmrPo.getCurGrpCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurGrpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurBedCd() != null
				&& !mrAmrPo.getCurBedCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurBedCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurMngDctId() != null
				&& !mrAmrPo.getCurMngDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMngDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurMojDctId() != null
				&& !mrAmrPo.getCurMojDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMojDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurDrcDctId() != null
				&& !mrAmrPo.getCurDrcDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurDrcDctId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurMngNurId() != null
				&& !mrAmrPo.getCurMngNurId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMngNurId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getSuF() != null && !mrAmrPo.getSuF().equals(null)) {
			bf.append("'" + mrAmrPo.getSuF() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getDeathF() != null && !mrAmrPo.getDeathF().equals(null)) {
			bf.append("'" + mrAmrPo.getDeathF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getReadmF() != null && !mrAmrPo.getReadmF().equals(null)) {
			bf.append("'" + mrAmrPo.getReadmF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCallBackF() != null
				&& !mrAmrPo.getCallBackF().equals(null)) {
			bf.append("'" + mrAmrPo.getCallBackF() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getFlupVisitF() != null
				&& !mrAmrPo.getFlupVisitF().equals(null)) {
			bf.append("'" + mrAmrPo.getFlupVisitF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getFnshTime() != null
				&& !mrAmrPo.getFnshTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getFnshTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getFnshUserId() != null
				&& !mrAmrPo.getFnshUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getFnshUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getFnshDeptCd() != null
				&& !mrAmrPo.getFnshDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getFnshDeptCd() + "',");
		} else {
			bf.append("'', ");
		}
		
		if (mrAmrPo.getPaInsurCd() != null
				&& !mrAmrPo.getPaInsurCd().equals(null)) {
			bf.append("'" + mrAmrPo.getPaInsurCd() + "',");
		} else {
			bf.append("'', ");
		}
		
		if (mrAmrPo.getPaInsurNm() != null
				&& !mrAmrPo.getPaInsurNm().equals(null)) {
			bf.append("'" + mrAmrPo.getPaInsurNm() + "'");
		} else {
			bf.append("'' ");
		}
		
		bf.append(" )");
		log.debug(" insert 语句>........" + bf.toString());
		return bf.toString();
	}

	private String getUpdateSql(MrAmrPo mrAmrPo) {
		//StringBuffer bf = new StringBuffer();
		bf.delete(0, bf.length());
		bf.append("update  mr_amr set ");
		bf.append("(PA_ID,EN_CNT,PA_NM,SEX_CD,AGE,ORG_CD,AMR_NO,EN_NO,");
		bf.append("EN_TP_CD,EN_STA_CD,");
		// bf.append("AMR_STA_CD,AMR_RANK_CD,");
		bf.append("REG_TIME,REG_USER_ID,");
		bf.append("REG_DEPT_CD,RCV_USER_ID,RCV_DEPT_CD,RCV_TIME,ILL_STA_CD,NU_LVL_CD,CUR_MAIN_DI_CD,CUR_DEPT_CD,");
		bf.append("CUR_DEPT_INTO_TIME,CUR_WARD_CD,CUR_WARD_INTO_TIME,CUR_GRP_CD,CUR_BED_CD,");
		bf.append("CUR_MNG_DCT_ID,");
		//在iemr系统里设置
		bf.append("CUR_MOJ_DCT_ID,CUR_DRC_DCT_ID,")	;	
        bf.append("CUR_MNG_NUR_ID,SU_F,DEATH_F,");
		bf.append("READM_F,CALL_BACK_F,FLUP_VISIT_F,FNSH_TIME,FNSH_USER_ID,FNSH_DEPT_CD,PA_INSUR_CD,PA_INSUR_NM )");
		bf.append(" = ( select ");
		if (mrAmrPo.getPaId() != null && !mrAmrPo.getPaId().equals(null)) {
			bf.append("'" + mrAmrPo.getPaId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnCnt() != null && !mrAmrPo.getEnCnt().equals(null)) {
			bf.append("'" + mrAmrPo.getEnCnt() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getPaNm() != null && !mrAmrPo.getPaNm().equals(null)) {
			bf.append("'" + mrAmrPo.getPaNm() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getSexCd() != null && !mrAmrPo.getSexCd().equals(null)) {
			bf.append("'" + mrAmrPo.getSexCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getAge() != null && !mrAmrPo.getAge().equals(null)) {
			bf.append("'" + mrAmrPo.getAge() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getOrgCd() != null && !mrAmrPo.getOrgCd().equals(null)) {
			bf.append("'" + mrAmrPo.getOrgCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getAmrNo() != null && !mrAmrPo.getAmrNo().equals(null)) {
			bf.append("'" + mrAmrPo.getAmrNo() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnNo() != null && !mrAmrPo.getEnNo().equals(null)) {
			bf.append("'" + mrAmrPo.getEnNo() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getEnTpCd() != null && !mrAmrPo.getEnTpCd().equals(null)) {
			bf.append("'" + mrAmrPo.getEnTpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getEnStaCd() != null && !mrAmrPo.getEnStaCd().equals(null)) {
			bf.append("'" + mrAmrPo.getEnStaCd() + "',");
		} else {
			bf.append("'',");
		}
		/*
		 * if(mrAmrPo.getAmrStaCd() != null &&
		 * !mrAmrPo.getAmrStaCd().equals(null)){
		 * bf.append("'"+mrAmrPo.getAmrStaCd()+"',"); }else{ bf.append("'',"); }
		 */
		/*if (mrAmrPo.getAmrRankCd() != null
				&& !mrAmrPo.getAmrRankCd().equals(null)) {
			bf.append("'" + mrAmrPo.getAmrRankCd() + "',");
		} else {
			bf.append("'',");
		}*/

		if (mrAmrPo.getRegTime() != null && !mrAmrPo.getRegTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getRegTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRegUserId() != null
				&& !mrAmrPo.getRegUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getRegUserId() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRegDeptCd() != null
				&& !mrAmrPo.getRegDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getRegDeptCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getRcvUserId() != null
				&& !mrAmrPo.getRcvUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getRcvUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getRcvDeptCd() != null
				&& !mrAmrPo.getRcvDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getRcvDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getRcvTime() != null && !mrAmrPo.getRcvTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getRcvTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getIllStaCd() != null
				&& !mrAmrPo.getIllStaCd().equals(null)) {
			bf.append("'" + mrAmrPo.getIllStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getNuLvlCd() != null && !mrAmrPo.getNuLvlCd().equals(null)) {
			bf.append("'" + mrAmrPo.getNuLvlCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurMainDiCd() != null
				&& !mrAmrPo.getCurMainDiCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMainDiCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurDeptCd() != null
				&& !mrAmrPo.getCurDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurDeptInfoTime() != null
				&& !mrAmrPo.getCurDeptInfoTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getCurDeptInfoTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurWardCd() != null
				&& !mrAmrPo.getCurWardCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurWardCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurWardInfoTime() != null
				&& !mrAmrPo.getCurWardInfoTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getCurWardInfoTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurGrpCd() != null
				&& !mrAmrPo.getCurGrpCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurGrpCd() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurBedCd() != null
				&& !mrAmrPo.getCurBedCd().equals(null)) {
			bf.append("'" + mrAmrPo.getCurBedCd() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurMngDctId() != null
				&& !mrAmrPo.getCurMngDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMngDctId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurMojDctId() != null
				&& !mrAmrPo.getCurMojDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMojDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getCurDrcDctId() != null
				&& !mrAmrPo.getCurDrcDctId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurDrcDctId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCurMngNurId() != null
				&& !mrAmrPo.getCurMngNurId().equals(null)) {
			bf.append("'" + mrAmrPo.getCurMngNurId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getSuF() != null && !mrAmrPo.getSuF().equals(null)) {
			bf.append("'" + mrAmrPo.getSuF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getDeathF() != null && !mrAmrPo.getDeathF().equals(null)) {
			bf.append("'" + mrAmrPo.getDeathF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getReadmF() != null && !mrAmrPo.getReadmF().equals(null)) {
			bf.append("'" + mrAmrPo.getReadmF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getCallBackF() != null
				&& !mrAmrPo.getCallBackF().equals(null)) {
			bf.append("'" + mrAmrPo.getCallBackF() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getFlupVisitF() != null
				&& !mrAmrPo.getFlupVisitF().equals(null)) {
			bf.append("'" + mrAmrPo.getFlupVisitF() + "',");
		} else {
			bf.append("'',");
		}

		if (mrAmrPo.getFnshTime() != null
				&& !mrAmrPo.getFnshTime().equals(null)) {
			bf.append(" to_date('" + mrAmrPo.getFnshTime()
					+ "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getFnshUserId() != null
				&& !mrAmrPo.getFnshUserId().equals(null)) {
			bf.append("'" + mrAmrPo.getFnshUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (mrAmrPo.getFnshDeptCd() != null
				&& !mrAmrPo.getFnshDeptCd().equals(null)) {
			bf.append("'" + mrAmrPo.getFnshDeptCd() + "', ");
		} else {
			bf.append("'', ");
		}
     
		if (mrAmrPo.getPaInsurCd() != null
				&& !mrAmrPo.getPaInsurCd().equals(null)) {
			bf.append("'" + mrAmrPo.getPaInsurCd() + "', ");
		} else {
			bf.append("'', ");
		}
		if (mrAmrPo.getPaInsurNm() != null
				&& !mrAmrPo.getPaInsurNm().equals(null)) {
			bf.append("'" + mrAmrPo.getPaInsurNm() + "' ");
		} else {
			bf.append("'' ");
		}
		bf.append("  from dual ) where en_pk ='");
		bf.append(mrAmrPo.getEnPk() + "' ");
		log.debug(" update 语句>........" + bf.toString());
		return bf.toString();

	}

	private String getDeleteOracleSql(MrAmrPo mrAmrPo) {
		//StringBuffer bf = new StringBuffer();
		bf.delete(0, bf.length());
		bf.append("update  mr_amr set del_f = 1   where en_pk ='"
				+ mrAmrPo.getEnPk() + "'");
		log.debug(" delete  语句>........" + bf.toString());
		return bf.toString();
	}
    
	/**
	 * 增加
	 * @param mrAmrPo
	 * @return
	 */
	private String InsertOracle(MrAmrPo mrAmrPo) {
		String sql = getInsertSql(mrAmrPo);
		try {
			long start = System.currentTimeMillis();
			jdbcTemplate.execute(sql);
			long end = System.currentTimeMillis();
			log.debug("jdbc时间===="+(start-end));
			D_list.add(mrAmrPo);
			/* 2016-03-25 添加功能  同步就诊时，同步患者信息
			 * 先判断配置项SYNC_PA_INFO_FROM_VWMDPA，是否要同步病人信息到pa_info
			 * 然后判断是否存在于数据库pa_info表中
			 * 如果不存在，则从视图 vw_md_pa 中读取信息，并添加
			 * 
			 * */
			SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey("SYNC_PA_INFO_FROM_VWMDPA");
			if(   null != rsFunFlag 
					&&  null != rsFunFlag.getData()
					&& rsFunFlag.getData().equalsIgnoreCase("1")
			){
				String  isExistInIemr = "select count(*) from PA_INFO where PA_ID =?" ;
				Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {mrAmrPo.getPaId()}, Integer.class);
				if(intExistInIemr.intValue() == 0 ){
					//从视图读取信息并生成sql语句
					String sql_insertPatient = getInsertPatientSql(mrAmrPo.getPaId(),mrAmrPo.getEnTpCd());
					if(StringUtils.isNotBlank(sql_insertPatient)){
						jdbcTemplate.execute(sql_insertPatient);
					}
				}
			}else{
					if(null == rsFunFlag){
						log.info("数据库参数配置中未配置 ：code为SYSM01.0, key为SYNC_PA_INFO_FROM_VWMDPA");
					}else if(null == rsFunFlag.getData()){
						log.info("数据库参数配置中未配置：code为SYSM01.0, key为SYNC_PA_INFO_FROM_VWMDPA");
					}else{
						 log.info("数据库参数配置中code为SYSM01.0, key为SYNC_PA_INFO_FROM_VWMDPA，value值为"+rsFunFlag.getData()+"。");
					}
			}
			mrAmrDao.delete(mrAmrPo);
		} catch (Exception e) {
			log.warn("sync mr_mar insert exception ......" + e.getMessage());
			log.warn("sync mr_mar insert exception ......" + sql);
			long start = System.currentTimeMillis();
			long end = System.currentTimeMillis();
			log.debug("更新时间===="+(start-end));
		}
		finally{
			//mrAmrDao.delete(mrAmrPo);
		}
		return "";
	}
	//增加从门诊或者住院不同的视图获取患者信息
	private String getInsertPatientSql(String paId ,String enTypeCode){
		List<PatientPo> patientDetailList = null ;
		if(enTypeCode.equalsIgnoreCase(EncounterType.INPATIENT)){
			patientDetailList = getPatientFromVwMdPaDao.getPatientDetailForZy(paId);
		}else{
			if(enTypeCode.equalsIgnoreCase(EncounterType.OUTPATIENT)){
				patientDetailList = getPatientFromVwMdPaDao.getPatientDetailForMz(paId);
			}
		}
    	PatientPo vwMdPapo =  null ;
    	if(null != patientDetailList && !patientDetailList.isEmpty()){
    		vwMdPapo = patientDetailList.get(0);
    	}
    	String rs = null ;
    	if(null != vwMdPapo){
    		rs  = getInsertPatientSql(vwMdPapo) ;
    	}
    	return rs;
	}
	/**
	 *  从视图读取病人信息并生成sql语句
	 *  pa_info中  SOCIAL_SN  在视图vw_md_pa中没有。暂时无用。在视图中使用''
	 *  pa_info  中hic_no 读取的是 hic_no，在视图vw_md_pa中没有。
	 *  vw_md_pa，中没有 age字段，需要程序来算
	 *  vw_md_pa，“  a.birthday   BIRTHDAY,” 最好换成  CONVERT(VARCHAR(100),t.birth_date,20)  BIRTH_DATE, 
	 */
    private String getInsertPatientSql(PatientPo vwMdPapo  ) {

		StringBuffer bf = new StringBuffer();
		bf.append(" insert into PA_INFO (");
		bf.append("PA_ID,PA_NM,SEX_CD,ID_CARD,HOME_TEL,SOCIAL_SN,HIC_NO,BIRTH_DATE)");
		bf.append(" values (");
		if (vwMdPapo.getPaId() != null && !vwMdPapo.getPaId().equals("''")) {
			bf.append("'" + vwMdPapo.getPaId() + "'");
		} else {
			bf.append("''");
		}
		if (vwMdPapo.getNm() != null && !vwMdPapo.getNm().equals("''")) {
			bf.append(",'" + vwMdPapo.getNm() + "'");
		} else {
			bf.append(",''");
		}
		if (vwMdPapo.getSexCd() != null && !vwMdPapo.getSexCd().equals("''")) {
			bf.append(",'" + vwMdPapo.getSexCd() + "'");
		} else {
			bf.append(",''");
		}
		if (vwMdPapo.getIdCardNo() != null && !vwMdPapo.getIdCardNo().equals("''")) {
			bf.append(",'" + vwMdPapo.getIdCardNo() + "'");
		} else {
			bf.append(",''");
		}

		if (vwMdPapo.getTelNo() != null && !vwMdPapo.getTelNo().equals("''")) {
			bf.append(",'" + vwMdPapo.getTelNo() + "'");
		} else {
			bf.append(",''");
		}
		//SOCIAL_SN 为空
		bf.append(",''");
		//hic_no 为空
		bf.append(",''");

		if (vwMdPapo.getBirthday() != null) {
			bf.append(", to_date('" + vwMdPapo.getBirthday()
					+ "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			bf.append(",'' ");
		}
		bf.append(" )");
		log.debug(" insert PA_INFO :" + bf.toString());
		return bf.toString();
	
	
	}

	/**
     * 更新
     * @param mrAmrPo
     * @return
     */
	private String UpdateOracle(MrAmrPo mrAmrPo) {
		String sql = getUpdateSql(mrAmrPo);
		try {
			jdbcTemplate.execute(sql);
			D_list.add(mrAmrPo);
			mrAmrDao.delete(mrAmrPo);
		} catch (Exception e) {
			System.out.println("sync mr_mar update exception ......" + e.getMessage());
			/*log.warn("sync mr_mar update exception ......" + e.getMessage());
			log.warn("sync mr_mar insert exception ......" + sql);*/
			System.out.println("sync mr_mar insert exception ......" + sql);
		}
		finally{
			//mrAmrDao.delete(mrAmrPo);
		}
		return "";
	}
	
     /**
      * 删除
      * @param mrAmrPo
      * @return
      */
	private String DeleteOracleMrAmr(MrAmrPo mrAmrPo) {
		String sql = getDeleteOracleSql(mrAmrPo);
		try {
			jdbcTemplate.execute(sql);
			D_list.add(mrAmrPo);
			mrAmrDao.delete(mrAmrPo);
		} catch (Exception e) {
			log.warn("sync mr_mar delete exception ......" + e.getMessage());
		}
		finally{
			//mrAmrDao.delete(mrAmrPo);
		}
		return "";
	}
}
