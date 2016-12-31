/**
 * 
 */
package ei.en.zy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.en.md.PatientModel;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.PerformancePrinter;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.en.db.dao.po.PatientPo;
import ei.en.db.dao.po.VwEnZyPo;
import ei.en.zy.db.dao.ZyCusViewEnDao;
import ei.en.zy.db.dao.ZyPatientInfoDao;
import ei.en.zy.service.ZyEiEncounterService;
import ei.iih.db.dao.auto.entity.VwNisWardConfig;
import ei.iih.db.dao.custom.VwNisWardConfigDao;

/**
 * @author guo_zhongbao
 *
 */
public class ZyEiEncounterServiceImpl implements ZyEiEncounterService {

	public static Logger log = LoggerFactory.getLogger(ZyEiEncounterServiceImpl.class);
	final String KEY_EN_TYPE_CODE = "enTypeCode";
	
	@Autowired
	VwNisWardConfigDao vwNisWardConfigDao;
	
	@Reference
	ParamsSetService paramsSetService;//参数获取信息服务接口

	@Autowired
	ZyCusViewEnDao cusViewEnMzDao; //访问门诊就诊视图
	
	@Autowired
	ZyPatientInfoDao zyPatientInfoDao ;//住院患者信息dao

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ei.en.service.EncounterService#getEncounterDetail(java.lang.String,
	 * java.util.Map)
	 */
	@Override
	public SingleResult<Map> insertEncounterToDB(String enPk, Map map) {

		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
		Map rsMap = new HashMap();
		String enTypeCode = EncounterType.INPATIENT;
		if (null != map && map.containsKey(KEY_EN_TYPE_CODE)) {
			enTypeCode = map.get(KEY_EN_TYPE_CODE).toString();
		}
		boolean notExistPatient = false;
		if (null != map && map.containsKey("notExistPatient")) {
			notExistPatient = true;
		}
		String patientId = null;
		String times = null;
		if (enPk.contains("_")) {
			String[] arr = enPk.split("_");
			patientId = arr[0];
			times = arr[1];
			enPk = null ;
		} else { //cis 时 需要通过map传值获取患者信息 wangyanli 20160810
			if(null != map && map.containsKey("patientId")){
				patientId = map.get("patientId").toString();
			}
			if(null != map && map.containsKey("times")){
				times = map.get("times").toString();
			}
		} 
		Map mapRs = new HashMap();

		// 从第三方视图查询
		if (EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)) {
			// 住院
			mapRs = getInPatientEn(enPk,patientId, times, notExistPatient);
		} 
		builder.withData(map);
		return builder.build();

	}

	@Override
	public SingleResult<Map> updateEncounterToDB(String enPk, Map map) {
		String enTypeCode = EncounterType.OUTPATIENT;
		if (null != map && map.containsKey(KEY_EN_TYPE_CODE)) {
			enTypeCode = map.get(KEY_EN_TYPE_CODE).toString();
		}
		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
		Map rsMap = new HashMap();
		String patientId = null;
		String times = null;
		if (enPk.contains("_")) {
			String[] arr = enPk.split("_");
			patientId = arr[0];
			times = arr[1];
			enPk = null ;
		} else {
			//return null;
		}
		Map mapRs = new HashMap();
		// 从第三方视图查询
		if (EncounterType.INPATIENT.equalsIgnoreCase(enTypeCode)) {
			// 住院
			mapRs = getInPatientEnUpadateInfo( enPk,patientId, times);
		} 
		builder.withData(map);
		return builder.build();
	}

	

	// 住院
	private Map getInPatientEn(String enPk,String patientId, String times, boolean notExistPatient) {
		VwEnZyPo viewEnZyPoByEnPk = cusViewEnMzDao.getViewEnZyPoByEnPk( enPk,patientId, times);
		if (null == viewEnZyPoByEnPk) {
			log.info("没有住院就诊信息，enPk:"+enPk+" ,patientId：" + patientId + " ,times:" + times);
			return null;
		}
		return insertMrAmrForZy(viewEnZyPoByEnPk, notExistPatient);
	}

	private Map insertMrAmrForZy(VwEnZyPo viewEnZyPoByEnPk, boolean notExistPatient) {
		// TODO Auto-generated method stub
		//getInsertMastDctIdForZy(viewEnZyPoByEnPk);wangyanli 20160810不需要设置上级医生上级医生在设置审签级别时设置
		return InsertOracleForZy(viewEnZyPoByEnPk, notExistPatient);
	}

	// 更新就诊信息，住院类型
	private Map getInPatientEnUpadateInfo(String enPk,String patientId, String times) {
		Map mapRs = new HashMap();
		VwEnZyPo viewEnZyPoByEnPk = cusViewEnMzDao.getViewEnZyPoByEnPk( enPk,patientId, times);
		if (null == viewEnZyPoByEnPk) {
			log.info("没有门诊就诊信息，patientId：" + patientId + " ,times:" + times);
			return null;
		}
		String sql = generateUpdateSqlForZy(viewEnZyPoByEnPk);
		try {
			long start = System.currentTimeMillis();
			jdbcTemplate.execute(sql);
			long end = System.currentTimeMillis();
			log.debug(" UpdateSqlForZy jdbc时间====" + (start - end));
		} catch (Exception e) {
			log.error("UpdateSqlForZy sync mr_mar insert exception ......" + e.getMessage());
			log.error("UpdateSqlForZy sync mr_mar insert exception ......" + sql);
		}
		return mapRs;
		// updateMrAmrForZy(viewEnZyPoByEnPk) ;
	}

	/**
	 * 
	 * @param ViewEnZyPoByEnPk
	 */
	private void getInsertMastDctIdForZy(VwEnZyPo ViewEnZyPoByEnPk) {
		getSuperiorDoctorIdForZy(ViewEnZyPoByEnPk);
	}

	/**
	 * 设置主管医生的 上级医生
	 * 
	 * @param ViewEnZyPoByEnPk
	 */
	private void getSuperiorDoctorIdForZy(VwEnZyPo ViewEnZyPoByEnPk) {
		StringBuffer sql = new StringBuffer();
		try {
			if (ViewEnZyPoByEnPk != null) {
				sql.append("SELECT CUR_DRC_DCT_ID,CUR_DEPUTY_DRC_DCT_ID FROM ORG_EMP_DEPT WHERE EMP_ID ='");
				sql.append(ViewEnZyPoByEnPk.getCurMngDctId() + "' AND  WARD_DEPT_CD = '");
				sql.append(ViewEnZyPoByEnPk.getCurDeptCd() + "'  AND DEL_F ='0' ");
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
				if (list != null && list.size() > 0) {
					Map map = list.get(0);
					log.debug("---" + map.size());
					if (map.get("CUR_DEPUTY_DRC_DCT_ID") != null) {
						ViewEnZyPoByEnPk.setCurMojDctId(map.get("CUR_DEPUTY_DRC_DCT_ID").toString());
					}
					if (map.get("CUR_DRC_DCT_ID") != null) {
						ViewEnZyPoByEnPk.setCurDrcDctId(map.get("CUR_DRC_DCT_ID").toString());
					}
				}
			}
		} catch (Exception e) {
			log.warn("getInsertMastDctId  method exception : " + sql.toString());
			log.warn("getInsertMastDctId  method exception : " + e.getMessage());
		}
	}

	/**
	 * 增加
	 * 
	 * @param ViewEnZyPoByEnPk
	 * @return
	 */
	private Map InsertOracleForZy(VwEnZyPo ViewEnZyPoByEnPk, boolean notExistPatient) {
		String sql = getInsertSqlForZy(ViewEnZyPoByEnPk);
		PerformancePrinter.start("generateInsertSql");
		String sqlPatientInfo = null;
		if (notExistPatient) {
			sqlPatientInfo = getInsertPatientInfoSqlForZy(ViewEnZyPoByEnPk);
		}
		PerformancePrinter.end("generateInsertSql");
		try {
			long start = System.currentTimeMillis();
			jdbcTemplate.execute(sql);
			if (notExistPatient) {
				jdbcTemplate.execute(sqlPatientInfo);
			}
			long end = System.currentTimeMillis();
			log.debug("jdbc时间====" + (start - end));
		} catch (Exception e) {
			log.warn("sync mr_mar insert exception ......" + e.getMessage());
			log.warn("sync mr_mar insert exception ......" + sql);
		}
		return null;
	}

	private String getInsertSqlForZy(VwEnZyPo ViewEnZyPoByEnPk) {
		StringBuffer bf = new StringBuffer();
		bf.append(" insert into mr_amr (");
		bf.append("EN_PK,PA_ID,EN_CNT,PA_NM,SEX_CD,AGE,ORG_CD,AMR_NO,EN_NO,");
		bf.append("EN_TP_CD,EN_STA_CD,AMR_STA_CD,AMR_RANK_CD,REG_TIME,REG_USER_ID,");
		bf.append("REG_DEPT_CD,RCV_USER_ID,RCV_DEPT_CD,RCV_TIME,ILL_STA_CD,NU_LVL_CD,CUR_MAIN_DI_CD,CUR_DEPT_CD,");
		bf.append("CUR_DEPT_INTO_TIME,CUR_WARD_CD,CUR_WARD_INTO_TIME,CUR_GRP_CD,CUR_BED_CD,");
		bf.append("CUR_MNG_DCT_ID,CUR_MOJ_DCT_ID,CUR_DRC_DCT_ID,CUR_MNG_NUR_ID,SU_F,DEATH_F,");
		bf.append("READM_F,CALL_BACK_F,FLUP_VISIT_F,FNSH_TIME,FNSH_USER_ID,FNSH_DEPT_CD,PA_INSUR_CD,PA_INSUR_NM )");
		bf.append(" values (");
		if (ViewEnZyPoByEnPk.getEnPk() != null) {
			bf.append("'" + ViewEnZyPoByEnPk.getEnPk() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getPaId() != null && !ViewEnZyPoByEnPk.getPaId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getPaId() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getEnCnt() != null && !ViewEnZyPoByEnPk.getEnCnt().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getEnCnt() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getPaNm() != null && !ViewEnZyPoByEnPk.getPaNm().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getPaNm() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getSexCd() != null && !ViewEnZyPoByEnPk.getSexCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getSexCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getAge() != null && !ViewEnZyPoByEnPk.getAge().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getAge() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getOrgCd() != null) {
			bf.append("'" + ViewEnZyPoByEnPk.getOrgCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getAmrNo() != null && !ViewEnZyPoByEnPk.getAmrNo().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getAmrNo() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getEnNo() != null && !ViewEnZyPoByEnPk.getEnNo().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getEnNo() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getEnTpCd() != null && !ViewEnZyPoByEnPk.getEnTpCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getEnTpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getEnStaCd() != null && !ViewEnZyPoByEnPk.getEnStaCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getEnStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getAmrStaCd() != null && !ViewEnZyPoByEnPk.getAmrStaCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getAmrStaCd() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getAmrRankCd() != null && !ViewEnZyPoByEnPk.getAmrRankCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getAmrRankCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getRegTime() != null && !ViewEnZyPoByEnPk.getRegTime().equals(null)) {
			String regTimeTemp = ViewEnZyPoByEnPk.getRegTime();
			String regTime = regTimeTemp.substring(0,regTimeTemp.lastIndexOf("."));
			bf.append(" to_date('" + regTime + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getRegUserId() != null && !ViewEnZyPoByEnPk.getRegUserId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getRegUserId() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getRegDeptCd() != null && !ViewEnZyPoByEnPk.getRegDeptCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getRegDeptCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getRcvUserId() != null && !ViewEnZyPoByEnPk.getRcvUserId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getRcvUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getRcvDeptCd() != null && !ViewEnZyPoByEnPk.getRcvDeptCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getRcvDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getRcvTime() != null && !ViewEnZyPoByEnPk.getRcvTime().equals(null)) {
			String rcvTimeTemp = ViewEnZyPoByEnPk.getRcvTime();
			String rcvTime = rcvTimeTemp.substring(0,rcvTimeTemp.lastIndexOf("."));
			bf.append(" to_date('" + rcvTime + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getIllStaCd() != null && !ViewEnZyPoByEnPk.getIllStaCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getIllStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getNuLvlCd() != null && !ViewEnZyPoByEnPk.getNuLvlCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getNuLvlCd() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurMainDiCd() != null && !ViewEnZyPoByEnPk.getCurMainDiCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurMainDiCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCurDeptCd() != null && !ViewEnZyPoByEnPk.getCurDeptCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurDeptInfoTime() != null && !ViewEnZyPoByEnPk.getCurDeptInfoTime().equals(null)) {
			String curDeptInfoTimeTemp = ViewEnZyPoByEnPk.getCurDeptInfoTime();
			String curDeptInfoTime = curDeptInfoTimeTemp.substring(0,curDeptInfoTimeTemp.lastIndexOf("."));
			bf.append(" to_date('" + curDeptInfoTime + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCurWardCd() != null && !ViewEnZyPoByEnPk.getCurWardCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurWardCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCurWardInfoTime() != null && !ViewEnZyPoByEnPk.getCurWardInfoTime().equals(null)) {
			String curWardInfoTimeTemp = ViewEnZyPoByEnPk.getCurWardInfoTime();
			String curWardInfoTime = curWardInfoTimeTemp.substring(0,curWardInfoTimeTemp.lastIndexOf("."));
			bf.append(" to_date('" + curWardInfoTime + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurGrpCd() != null && !ViewEnZyPoByEnPk.getCurGrpCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurGrpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCurBedCd() != null && !ViewEnZyPoByEnPk.getCurBedCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurBedCd() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurMngDctId() != null && !ViewEnZyPoByEnPk.getCurMngDctId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurMngDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurMojDctId() != null && !ViewEnZyPoByEnPk.getCurMojDctId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurMojDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getCurDrcDctId() != null && !ViewEnZyPoByEnPk.getCurDrcDctId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurDrcDctId() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCurMngNurId() != null && !ViewEnZyPoByEnPk.getCurMngNurId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCurMngNurId() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getSuF() != null && !ViewEnZyPoByEnPk.getSuF().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getSuF() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getDeathF() != null && !ViewEnZyPoByEnPk.getDeathF().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getDeathF() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getReadmF() != null && !ViewEnZyPoByEnPk.getReadmF().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getReadmF() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getCallBackF() != null && !ViewEnZyPoByEnPk.getCallBackF().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getCallBackF() + "',");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getFlupVisitF() != null && !ViewEnZyPoByEnPk.getFlupVisitF().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getFlupVisitF() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getFnshTime() != null && !ViewEnZyPoByEnPk.getFnshTime().equals(null)) {
			String fnshTimeTemp = ViewEnZyPoByEnPk.getFnshTime();
			String fnshTime = fnshTimeTemp.substring(0,fnshTimeTemp.lastIndexOf("."));
			bf.append(" to_date('" + fnshTime + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (ViewEnZyPoByEnPk.getFnshUserId() != null && !ViewEnZyPoByEnPk.getFnshUserId().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getFnshUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (ViewEnZyPoByEnPk.getFnshDeptCd() != null && !ViewEnZyPoByEnPk.getFnshDeptCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getFnshDeptCd() + "',");
		} else {
			bf.append("'', ");
		}

		if (ViewEnZyPoByEnPk.getPaInsurCd() != null && !ViewEnZyPoByEnPk.getPaInsurCd().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getPaInsurCd() + "',");
		} else {
			bf.append("'', ");
		}

		if (ViewEnZyPoByEnPk.getPaInsurNm() != null && !ViewEnZyPoByEnPk.getPaInsurNm().equals(null)) {
			bf.append("'" + ViewEnZyPoByEnPk.getPaInsurNm() + "'");
		} else {
			bf.append("'' ");
		}

		bf.append(" )");
		log.debug(" insert 语句>........" + bf.toString());
		return bf.toString();
	}



	private String getInsertPatientInfoSqlForZy(VwEnZyPo ViewEnZyPoByEnPk) {

		StringBuffer bf = new StringBuffer();
		bf.append(" insert into PA_INFO (");
		bf.append("PA_ID,PA_NM,SEX_CD,ID_CARD,HOME_TEL,SOCIAL_SN,HIC_NO,BIRTH_DATE)");
		bf.append(" values (");
		if (ViewEnZyPoByEnPk.getPaId() != null && !ViewEnZyPoByEnPk.getPaId().equals("''")) {
			bf.append("'" + ViewEnZyPoByEnPk.getPaId() + "'");
		} else {
			bf.append("''");
		}
		if (ViewEnZyPoByEnPk.getPaNm() != null && !ViewEnZyPoByEnPk.getPaNm().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getPaNm() + "'");
		} else {
			bf.append(",''");
		}
		if (ViewEnZyPoByEnPk.getSexCd() != null && !ViewEnZyPoByEnPk.getSexCd().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getSexCd() + "'");
		} else {
			bf.append(",''");
		}
		if (ViewEnZyPoByEnPk.getIdCard() != null && !ViewEnZyPoByEnPk.getIdCard().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getIdCard() + "'");
		} else {
			bf.append(",''");
		}

		if (ViewEnZyPoByEnPk.getHomeTel() != null && !ViewEnZyPoByEnPk.getHomeTel().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getHomeTel() + "'");
		} else {
			bf.append(",''");
		}
		if (ViewEnZyPoByEnPk.getSocialSn() != null && !ViewEnZyPoByEnPk.getSocialSn().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getSocialSn() + "'");
		} else {
			bf.append(",''");
		}
		if (ViewEnZyPoByEnPk.getHicNo() != null && !ViewEnZyPoByEnPk.getHicNo().equals("''")) {
			bf.append(",'" + ViewEnZyPoByEnPk.getHicNo() + "'");
		} else {
			bf.append(",''");
		}

		if (ViewEnZyPoByEnPk.getBirthDate() != null) {
			bf.append(", to_date('" + ViewEnZyPoByEnPk.getBirthDate() + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			bf.append(",'' ");
		}
		bf.append(" )");
		log.debug(" insert PA_INFO :" + bf.toString());
		return bf.toString();

	}

	// 更新住院就诊信息sql
	private String generateUpdateSqlForZy(VwEnZyPo viewEnZyPoByEnPk) {

		StringBuffer bf = new StringBuffer();
		bf.append(" update mr_amr set ");
		bf.append(" RCV_USER_ID='");// 接诊人
		bf.append(viewEnZyPoByEnPk.getRcvUserId());
		bf.append("' ,");
		bf.append(" RCV_DEPT_CD='");// 接诊科室

		bf.append(viewEnZyPoByEnPk.getRcvDeptCd());
		bf.append("'");
		if (null == viewEnZyPoByEnPk.getRcvTime()) {
			bf.append(",");
			bf.append(" RCV_TIME=");// 接诊时间
			bf.append(" to_date('" + viewEnZyPoByEnPk.getRcvTime() + "','yyyy-MM-DD hh24:mi:ss')");

		}
		if (null == viewEnZyPoByEnPk.getRegTime()) {
			bf.append(" ,");
			bf.append(" REG_TIME="); // 挂号时间
			bf.append(" to_date('" + viewEnZyPoByEnPk.getRegTime() + "','yyyy-MM-DD hh24:mi:ss')");

		}
		if (null != viewEnZyPoByEnPk.getCurMainDiCd()) {
			bf.append(" ,");
			bf.append(" cur_main_di_cd='"); // 主诊断
			bf.append(viewEnZyPoByEnPk.getCurMainDiCd());
			bf.append("'");
		}
		bf.append(" where EN_PK ='" + viewEnZyPoByEnPk.getEnPk() + "'");
		log.debug(" update 语句>........" + bf.toString());
		return bf.toString();

	}
	@Transactional
	@Override
	public SingleResult<String> importNisWardConfig() {
		/**增加多条sql语句
		 * 	insert all 
		 *	into ei_nis_ward_config(DEPT_SN,WARD_SN,WARD_NM,IP_LIST) values ('1','2','3','4')  
		 *	into ei_nis_ward_config(DEPT_SN,WARD_SN,WARD_NM,IP_LIST) values ('2','2','3','4') 
		 *	select 1 from dual
		 */
		SingleResult<String> result=new SingleResult<String>();
		//delete ei_nis_ward_config
		String sql="delete ei_nis_ward_config";
		//清空表
		PerformancePrinter.start("importNisWardConfig");
		jdbcTemplate.execute(sql);
		sql="insert all ";
		List<VwNisWardConfig> vwNisWardConfigs= vwNisWardConfigDao.selectNisWarkConfigs();
		if(vwNisWardConfigs!=null&&vwNisWardConfigs.size()>0){
			int i=1000;
			for (VwNisWardConfig vw : vwNisWardConfigs) {
				i++;
				sql+="into ei_nis_ward_config("
						+ "NIS_WARD_CD,DEPT_SN,WARD_SN,WARD_NM,ORDER_START_TIME,ORDER_DAYS,KF_START_TIME,"
						+ "KF_DAYS,FKF_START_TIME,FKF_DAYS,FEE_ORDER_SN,BASE_GROUP,WZ_GROUP_LIST,INFUSION_FLAG,"
						+ "IP_LIST,ENABLE_FLAG,OWE_LIMIT,LONG_ORDER_WIDTH,ONCE_ORDER_WIDTH,AUTO_BUILD,INFUSION_FLAG2) "
						+ "values ('"+i+"','"+vw.getDeptSn()+"','"+vw.getWardSn()+"','"+vw.getWardNm()+"','"+vw.getOrderStartTime()+"','"
						+vw.getOrderDays()+"','"+vw.getKfStartTime()+"','"+vw.getKfDays()+"','"+vw.getFkfStartTime()+"','"
						+vw.getFkfDays()+"',"+vw.getFeeOrderSn()+",'"+vw.getBaseGroup()+"','"+vw.getWzGroupList()+"','"
						+vw.getInfusionFlag()+"','"+vw.getIpList()+"','"+vw.getEnableFlag()+"','"+vw.getOweLimit()+"',"
						+vw.getLongOrderWidth()+","+vw.getOnceOrderWidth()+",'"+vw.getAutoBuild()+"','"+vw.getInfusionFlag2()+"') ";
			}
			sql+=" select 1 from dual";
			sql=sql.replaceAll("\'null\'","''");//字符空
			jdbcTemplate.execute(sql);
		}
		PerformancePrinter.end("importNisWardConfig");
		result.setData("数据刷新成功");
		return result;
	}

	@Override
	public PatientModel getPatientDetailForZy(String pa_id) {
		PatientModel vo = new  PatientModel();
		List<PatientPo> poList = zyPatientInfoDao.getPatientDetailForZy(pa_id);
//		SingleResultBuilder<PatientModel> builder = SingleResultBuilder.newSingleResult(PatientModel.class);
		if(poList.size() > 0 ){
			PatientPo po = poList.get(0) ;
			if(null != po){
				BeanUtils.copyProperties( po,vo);
//				builder.withData(vo);
			}
		}
		return vo;
	}
	
}
