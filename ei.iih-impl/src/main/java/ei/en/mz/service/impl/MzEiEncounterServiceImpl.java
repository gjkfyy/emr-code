/**
 * 
 */
package ei.en.mz.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.iih.en.md.EncounterForXMLModel;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.en.md.PatientModel;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.PerformancePrinter;
import xap.sv.annotation.Reference;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import ei.en.db.dao.po.PatientPo;
import ei.en.db.dao.po.VwEnMzPo;
import ei.en.mz.db.dao.MzCusViewEnDao;
import ei.en.mz.db.dao.MzPatientInfoDao;
import ei.en.mz.service.MzEiEncounterService;
import ei.iih.db.dao.auto.entity.VwNisWardConfig;
import ei.iih.db.dao.custom.VwNisWardConfigDao;

/**
 * @author guo_zhongbao
 *
 */
public class MzEiEncounterServiceImpl implements MzEiEncounterService {

	public static Logger log = LoggerFactory.getLogger(MzEiEncounterServiceImpl.class);
	final String KEY_EN_TYPE_CODE = "enTypeCode";
	
	@Autowired
	VwNisWardConfigDao vwNisWardConfigDao;
	
	@Reference
	ParamsSetService paramsSetService;

	@Autowired
	MzCusViewEnDao cusViewEnMzDao;

	@Autowired
	MzPatientInfoDao mzPatientInfoDao;
	
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
		String enTypeCode = EncounterType.OUTPATIENT;
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
		} else {
			//return null;
		}
		Map mapRs = new HashMap();

		// 从第三方视图查询
		if (EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)) {
			// 门诊
			mapRs = getOutPatientEn(enPk,patientId, times, notExistPatient);
		}  else if (EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)) {
			// 急诊
			mapRs = getEmergencyEn(enPk,patientId, times, notExistPatient);
		} else if (EncounterType.EMERGENCY_OBSERVATION.equalsIgnoreCase(enTypeCode)) {
			// 留观
			mapRs = getEmergencyObservationEn(enPk,patientId, times, notExistPatient);
		} else if (EncounterType.PHYSICAL_EXAMINATION.equalsIgnoreCase(enTypeCode)) {
			// 体检
			mapRs = getPhysicalExaminationEn(enPk,patientId, times, notExistPatient);
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
		if (EncounterType.OUTPATIENT.equalsIgnoreCase(enTypeCode)) {
			// 门诊
			mapRs = getOutPatientEnUpadateInfo( enPk,patientId, times);
		}  else if (EncounterType.EMERGENCY.equalsIgnoreCase(enTypeCode)) {
			// 急诊
			mapRs = getEmergencyEnUpadateInfo( enPk,patientId, times);
		} else if (EncounterType.EMERGENCY_OBSERVATION.equalsIgnoreCase(enTypeCode)) {
			// 留观
			mapRs = getEmergencyObservationEnUpadateInfo( enPk,patientId, times);
		} else if (EncounterType.PHYSICAL_EXAMINATION.equalsIgnoreCase(enTypeCode)) {
			// 体检
			mapRs = getPhysicalExaminationEnUpadateInfo( enPk,patientId, times);
		}
		builder.withData(map);
		return builder.build();
	}

	// 门诊
	private Map getOutPatientEn(String enPk,String patientId, String times, boolean notExistPatient) {
		PerformancePrinter.start("getViewEnMzPoByEnPk");
		VwEnMzPo viewEnMzPoByEnPk = cusViewEnMzDao.getViewEnMzPoByEnPk( enPk,patientId, times);
		PerformancePrinter.end("getViewEnMzPoByEnPk");
		if (null == viewEnMzPoByEnPk) {
			log.info("没有门诊就诊信息，enPk:"+enPk+" ,patientId：" + patientId + " ,times:" + times);
			return null;
		}
		return insertMrAmrForMz(viewEnMzPoByEnPk, notExistPatient);
	}

	private Map insertMrAmrForMz(VwEnMzPo viewEnMzPoByEnPk, boolean notExistPatient) {
		PerformancePrinter.start("getInsertMastDctIdForMz");
		getInsertMastDctIdForMz(viewEnMzPoByEnPk);
		PerformancePrinter.end("getInsertMastDctIdForMz");
		return InsertOracleForMz(viewEnMzPoByEnPk, notExistPatient);
	}

	// 体检
	private Map getPhysicalExaminationEn(String enPk,String patientId, String times, boolean notExistPatient) {
		return getOutPatientEn( enPk,patientId, times, notExistPatient);
	}

	// 留观
	private Map getEmergencyObservationEn(String enPk,String patientId, String times, boolean notExistPatient) {
		return getOutPatientEn( enPk,patientId, times, notExistPatient);
	}

	// 急诊
	private Map getEmergencyEn(String enPk,String patientId, String times, boolean notExistPatient) {
		return getOutPatientEn( enPk,patientId, times, notExistPatient);
	}

	// 更新就诊信息，门诊类型
	private Map getOutPatientEnUpadateInfo(String enPk,String patientId, String times) {
		Map mapRs = new HashMap();
		PerformancePrinter.start("getViewEnMzPoByEnPk");
		VwEnMzPo viewEnMzPoByEnPk = cusViewEnMzDao.getViewEnMzPoByEnPk(enPk,patientId, times);
		PerformancePrinter.end("getViewEnMzPoByEnPk");
		if (null == viewEnMzPoByEnPk) {
			log.info("没有门诊就诊信息，patientId：" + patientId + " ,times:" + times);
			return null;
		}
		PerformancePrinter.start("generateUpdateSqlForMz");
		String sql = generateUpdateSqlForMz(viewEnMzPoByEnPk);
		PerformancePrinter.end("generateUpdateSqlForMz");
		try {
			long start = System.currentTimeMillis();
			PerformancePrinter.start("execUpdateSqlForMz");
			jdbcTemplate.execute(sql);
			PerformancePrinter.end("execUpdateSqlForMz");
			long end = System.currentTimeMillis();
			log.debug(" UpdateSqlForMz jdbc时间====" + (start - end));
		} catch (Exception e) {
			log.warn("UpdateSqlForMz sync mr_mar insert exception ......" + e.getMessage());
			log.warn("UpdateSqlForMz sync mr_mar insert exception ......" + sql);
		}
		return mapRs;
	}



	// 体检
	private Map getPhysicalExaminationEnUpadateInfo(String enPk,String patientId, String times) {
		return getOutPatientEnUpadateInfo( enPk,patientId, times);
	}

	// 留观
	private Map getEmergencyObservationEnUpadateInfo(String enPk,String patientId, String times) {
		return getOutPatientEnUpadateInfo( enPk,patientId, times);
	}

	// 急诊
	private Map getEmergencyEnUpadateInfo(String enPk,String patientId, String times) {
		return getOutPatientEnUpadateInfo( enPk,patientId, times);
	}

	/**
	 * 
	 * @param viewEnMzPoByEnPk
	 */
	private void getInsertMastDctIdForMz(VwEnMzPo viewEnMzPoByEnPk) {
		getSuperiorDoctorIdForMz(viewEnMzPoByEnPk);
	}

	/**
	 * 设置主管医生的 上级医生
	 * 
	 * @param viewEnMzPoByEnPk
	 */
	private void getSuperiorDoctorIdForMz(VwEnMzPo viewEnMzPoByEnPk) {
		StringBuffer sql = new StringBuffer();
		try {
			if (viewEnMzPoByEnPk != null) {
				sql.append("SELECT CUR_DRC_DCT_ID,CUR_DEPUTY_DRC_DCT_ID FROM ORG_EMP_DEPT WHERE EMP_ID ='");
				sql.append(viewEnMzPoByEnPk.getCurMngDctId() + "' AND  WARD_DEPT_CD = '");
				sql.append(viewEnMzPoByEnPk.getCurDeptCd() + "'  AND DEL_F ='0' ");
				List<Map<String, Object>> list = jdbcTemplate.queryForList(sql.toString());
				if (list != null && list.size() > 0) {
					Map map = list.get(0);
					if (map.get("CUR_DEPUTY_DRC_DCT_ID") != null) {
						viewEnMzPoByEnPk.setCurMojDctId(map.get("CUR_DEPUTY_DRC_DCT_ID").toString());
					}
					if (map.get("CUR_DRC_DCT_ID") != null) {
						viewEnMzPoByEnPk.setCurDrcDctId(map.get("CUR_DRC_DCT_ID").toString());
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
	 * @param viewEnMzPoByEnPk
	 * @return
	 */
	private Map InsertOracleForMz(VwEnMzPo viewEnMzPoByEnPk, boolean notExistPatient) {
		PerformancePrinter.start("generateInsertSql");
		String sql = getInsertSqlForMz(viewEnMzPoByEnPk);
		PerformancePrinter.end("generateInsertSql");
		String sqlPatientInfo = null;
		if (notExistPatient) {
			PerformancePrinter.start("generateInsertSql");
			sqlPatientInfo = getInsertPatientInfoSqlForMz(viewEnMzPoByEnPk);
			PerformancePrinter.end("generateInsertSql");
		}
		try {
			long start = System.currentTimeMillis();
			PerformancePrinter.start("executeSql");
			jdbcTemplate.execute(sql);
			if (notExistPatient) {
				jdbcTemplate.execute(sqlPatientInfo);
			}
			PerformancePrinter.end("executeSql");
			long end = System.currentTimeMillis();
			log.debug("jdbc时间====" + (start - end));
		} catch (Exception e) {
			log.warn("sync mr_mar insert exception ......" + e.getMessage());
			log.warn("sync mr_mar insert exception ......" + sql);
		}
		return null;
	}

	private String getInsertPatientInfoSqlForMz(VwEnMzPo viewEnMzPoByEnPk) {

		StringBuffer bf = new StringBuffer();
		bf.append(" insert into PA_INFO (");
		bf.append("PA_ID,PA_NM,SEX_CD,ID_CARD,HOME_TEL,SOCIAL_SN,HIC_NO,BIRTH_DATE)");
		bf.append(" values (");
		if (viewEnMzPoByEnPk.getPaId() != null && !viewEnMzPoByEnPk.getPaId().equals("''")) {
			bf.append("'" + viewEnMzPoByEnPk.getPaId() + "'");
		} else {
			bf.append("''");
		}
		if (viewEnMzPoByEnPk.getPaNm() != null && !viewEnMzPoByEnPk.getPaNm().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getPaNm() + "'");
		} else {
			bf.append(",''");
		}
		if (viewEnMzPoByEnPk.getSexCd() != null && !viewEnMzPoByEnPk.getSexCd().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getSexCd() + "'");
		} else {
			bf.append(",''");
		}
		if (viewEnMzPoByEnPk.getIdCard() != null && !viewEnMzPoByEnPk.getIdCard().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getIdCard() + "'");
		} else {
			bf.append(",''");
		}

		if (viewEnMzPoByEnPk.getHomeTel() != null && !viewEnMzPoByEnPk.getHomeTel().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getHomeTel() + "'");
		} else {
			bf.append(",''");
		}
		if (viewEnMzPoByEnPk.getSocialSn() != null && !viewEnMzPoByEnPk.getSocialSn().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getSocialSn() + "'");
		} else {
			bf.append(",''");
		}
		if (viewEnMzPoByEnPk.getHicNo() != null && !viewEnMzPoByEnPk.getHicNo().equals("''")) {
			bf.append(",'" + viewEnMzPoByEnPk.getHicNo() + "'");
		} else {
			bf.append(",''");
		}

		if (viewEnMzPoByEnPk.getBirthDate() != null) {
			bf.append(", to_date('" + viewEnMzPoByEnPk.getBirthDate() + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			bf.append(",'' ");
		}
		bf.append(" )");
		log.debug(" insert PA_INFO :" + bf.toString());
		return bf.toString();

	}

	private String getInsertSqlForMz(VwEnMzPo viewEnMzPoByEnPk) {
		StringBuffer bf = new StringBuffer();
		bf.append(" insert into mr_amr (");
		bf.append("EN_PK,PA_ID,EN_CNT,PA_NM,SEX_CD,AGE,ORG_CD,AMR_NO,EN_NO,");
		bf.append("EN_TP_CD,EN_STA_CD,AMR_STA_CD,AMR_RANK_CD,REG_TIME,REG_USER_ID,");
		bf.append("REG_DEPT_CD,RCV_USER_ID,RCV_DEPT_CD,RCV_TIME,ILL_STA_CD,NU_LVL_CD,CUR_MAIN_DI_CD,CUR_DEPT_CD,");
		bf.append("CUR_DEPT_INTO_TIME,CUR_WARD_CD,CUR_WARD_INTO_TIME,CUR_GRP_CD,CUR_BED_CD,");
		bf.append("CUR_MNG_DCT_ID,CUR_MOJ_DCT_ID,CUR_DRC_DCT_ID,CUR_MNG_NUR_ID,SU_F,DEATH_F,");
		bf.append("READM_F,CALL_BACK_F,FLUP_VISIT_F,FNSH_TIME,FNSH_USER_ID,FNSH_DEPT_CD,PA_INSUR_CD,PA_INSUR_NM )");
		bf.append(" values (");
		if (viewEnMzPoByEnPk.getEnPk() != null) {
			bf.append("'" + viewEnMzPoByEnPk.getEnPk() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getPaId() != null && !viewEnMzPoByEnPk.getPaId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getPaId() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getEnCnt() != null && !viewEnMzPoByEnPk.getEnCnt().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getEnCnt() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getPaNm() != null && !viewEnMzPoByEnPk.getPaNm().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getPaNm() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getSexCd() != null && !viewEnMzPoByEnPk.getSexCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getSexCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getAge() != null && !viewEnMzPoByEnPk.getAge().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getAge() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getOrgCd() != null) {
			bf.append("'" + viewEnMzPoByEnPk.getOrgCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getAmrNo() != null && !viewEnMzPoByEnPk.getAmrNo().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getAmrNo() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getEnNo() != null && !viewEnMzPoByEnPk.getEnNo().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getEnNo() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getEnTpCd() != null && !viewEnMzPoByEnPk.getEnTpCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getEnTpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getEnStaCd() != null && !viewEnMzPoByEnPk.getEnStaCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getEnStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getAmrStaCd() != null && !viewEnMzPoByEnPk.getAmrStaCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getAmrStaCd() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getAmrRankCd() != null && !viewEnMzPoByEnPk.getAmrRankCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getAmrRankCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getRegTime() != null && !viewEnMzPoByEnPk.getRegTime().equals(null)) {
			bf.append(" to_date('" + viewEnMzPoByEnPk.getRegTime() + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getRegUserId() != null && !viewEnMzPoByEnPk.getRegUserId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getRegUserId() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getRegDeptCd() != null && !viewEnMzPoByEnPk.getRegDeptCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getRegDeptCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getRcvUserId() != null && !viewEnMzPoByEnPk.getRcvUserId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getRcvUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getRcvDeptCd() != null && !viewEnMzPoByEnPk.getRcvDeptCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getRcvDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getRcvTime() != null && !viewEnMzPoByEnPk.getRcvTime().equals(null)) {
			bf.append(" to_date('" + viewEnMzPoByEnPk.getRcvTime() + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getIllStaCd() != null && !viewEnMzPoByEnPk.getIllStaCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getIllStaCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getNuLvlCd() != null && !viewEnMzPoByEnPk.getNuLvlCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getNuLvlCd() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurMainDiCd() != null && !viewEnMzPoByEnPk.getCurMainDiCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurMainDiCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCurDeptCd() != null && !viewEnMzPoByEnPk.getCurDeptCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurDeptCd() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurDeptInfoTime() != null && !viewEnMzPoByEnPk.getCurDeptInfoTime().equals(null)) {
			bf.append(" to_date('" + viewEnMzPoByEnPk.getCurDeptInfoTime() + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCurWardCd() != null && !viewEnMzPoByEnPk.getCurWardCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurWardCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCurWardInfoTime() != null && !viewEnMzPoByEnPk.getCurWardInfoTime().equals(null)) {
			bf.append(" to_date('" + viewEnMzPoByEnPk.getCurWardInfoTime() + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurGrpCd() != null && !viewEnMzPoByEnPk.getCurGrpCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurGrpCd() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCurBedCd() != null && !viewEnMzPoByEnPk.getCurBedCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurBedCd() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurMngDctId() != null && !viewEnMzPoByEnPk.getCurMngDctId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurMngDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurMojDctId() != null && !viewEnMzPoByEnPk.getCurMojDctId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurMojDctId() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getCurDrcDctId() != null && !viewEnMzPoByEnPk.getCurDrcDctId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurDrcDctId() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCurMngNurId() != null && !viewEnMzPoByEnPk.getCurMngNurId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCurMngNurId() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getSuF() != null && !viewEnMzPoByEnPk.getSuF().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getSuF() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getDeathF() != null && !viewEnMzPoByEnPk.getDeathF().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getDeathF() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getReadmF() != null && !viewEnMzPoByEnPk.getReadmF().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getReadmF() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getCallBackF() != null && !viewEnMzPoByEnPk.getCallBackF().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getCallBackF() + "',");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getFlupVisitF() != null && !viewEnMzPoByEnPk.getFlupVisitF().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getFlupVisitF() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getFnshTime() != null && !viewEnMzPoByEnPk.getFnshTime().equals(null)) {
			bf.append(" to_date('" + viewEnMzPoByEnPk.getFnshTime() + "','yyyy-MM-DD hh24:mi:ss'),");
		} else {
			bf.append("'',");
		}

		if (viewEnMzPoByEnPk.getFnshUserId() != null && !viewEnMzPoByEnPk.getFnshUserId().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getFnshUserId() + "',");
		} else {
			bf.append("'',");
		}
		if (viewEnMzPoByEnPk.getFnshDeptCd() != null && !viewEnMzPoByEnPk.getFnshDeptCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getFnshDeptCd() + "',");
		} else {
			bf.append("'', ");
		}

		if (viewEnMzPoByEnPk.getPaInsurCd() != null && !viewEnMzPoByEnPk.getPaInsurCd().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getPaInsurCd() + "',");
		} else {
			bf.append("'', ");
		}

		if (viewEnMzPoByEnPk.getPaInsurNm() != null && !viewEnMzPoByEnPk.getPaInsurNm().equals(null)) {
			bf.append("'" + viewEnMzPoByEnPk.getPaInsurNm() + "'");
		} else {
			bf.append("'' ");
		}

		bf.append(" )");
		log.debug(" insert 语句>........" + bf.toString());
		return bf.toString();
	}



	// 更新门诊就诊信息sql
	private String generateUpdateSqlForMz(VwEnMzPo viewEnMzPoByEnPk) {
		StringBuffer bf = new StringBuffer();
		bf.append(" update mr_amr set ");
		bf.append(" RCV_USER_ID='");// 接诊人
		bf.append(viewEnMzPoByEnPk.getRcvUserId());
		bf.append("' ,");
		bf.append(" RCV_DEPT_CD='");// 接诊科室

		bf.append(viewEnMzPoByEnPk.getRcvDeptCd());
		bf.append("'");
		if (null != viewEnMzPoByEnPk.getRcvTime()) {
			bf.append(",");
			bf.append(" RCV_TIME=");// 接诊时间
			bf.append(" to_date('" + viewEnMzPoByEnPk.getRcvTime() + "','yyyy-MM-DD hh24:mi:ss')");

		}
		if (null != viewEnMzPoByEnPk.getRegTime()) {
			bf.append(" ,");
			bf.append(" REG_TIME="); // 挂号时间
			bf.append(" to_date('" + viewEnMzPoByEnPk.getRegTime() + "','yyyy-MM-DD hh24:mi:ss')");
		}
		if (null != viewEnMzPoByEnPk.getCurMainDiCd()) {
			bf.append(" ,");
			bf.append(" cur_main_di_cd='"); // 主诊断
			bf.append(viewEnMzPoByEnPk.getCurMainDiCd());
			bf.append("'");
		}
		bf.append(" where EN_PK ='" + viewEnMzPoByEnPk.getEnPk() + "'");
		String sqlString = bf.toString();
		// log.debug(" update 语句>........" + bf.toString());
		return sqlString;

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
	public PatientModel getPatientDetailForMz(String pa_id) {
		PatientModel vo = new  PatientModel();
		List<PatientPo> poList = mzPatientInfoDao.getPatientDetailForMz(pa_id);
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
	
	@Override
    public EncounterForXMLModel getEncounterDetailForMz(String enPk, String patientId, String times) {
	    EncounterForXMLModel vo = new  EncounterForXMLModel();
        VwEnMzPo po = cusViewEnMzDao.getViewEnMzPoByEnPk(enPk,patientId,times);
        BeanUtils.copyProperties(po,vo);
        return vo;
    }
	
}
