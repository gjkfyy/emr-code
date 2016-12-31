/**
 * 
 */
package ei.cis.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import ei.cis.db.dao.CusCisIemrEnAdtEntityDao;
import ei.cis.db.dao.CisIemrEnAdtEntityDao;
import ei.cis.db.dao.auto.entity.IemrEnAdtEntity;
import ei.cis.service.CisSyncEnAdtService;

/**
 * @author guo_zhongbao 从Cis中 同步 “转科记录”
 */
public class CisSyncEnAdtServiceImpl implements CisSyncEnAdtService {

	public static Logger log = LoggerFactory
			.getLogger(CisSyncEnAdtServiceImpl.class);

	@Autowired
	CusCisIemrEnAdtEntityDao cusCisIemrEnAdtEntityDao;

	@Autowired
	CisIemrEnAdtEntityDao IemrEnAdtEntityDao;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ei.cis.service.CisSyncEnAdtService#SychronizeEncounterAdtFromCis(java
	 * .util.Map)
	 */
	@Override
	public void SychronizeEncounterAdtFromCis(Map map) {
		List<IemrEnAdtEntity> list = cusCisIemrEnAdtEntityDao.selectAll();
		if (list != null) {
			int size = list.size();
			if (size > 0) {
				log.debug("sync iemr_ent_adt start...");
				log.debug(" org count = " + size);
				for (IemrEnAdtEntity iemrEnAdtEntity : list) {
					if (iemrEnAdtEntity.getFlag().equals("I")) {
						String  isExistInIemr = "select count(*) from en_adt where en_adt_cd =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {iemrEnAdtEntity.getEnAdtCd()}, Integer.class);
						if(intExistInIemr.intValue() == 1 ){
							iemrEnAdtEntity.setFlag("U");
						}
					}else if (iemrEnAdtEntity.getFlag().equals("U")) {
						String  isExistInIemr = "select count(*) from en_adt where en_adt_cd =?";
						Integer intExistInIemr = jdbcTemplate.queryForObject(isExistInIemr, new String[] {iemrEnAdtEntity.getEnAdtCd()}, Integer.class);
						if(intExistInIemr.intValue() == 0 ){
							iemrEnAdtEntity.setFlag("I");
						}
					}
					if (iemrEnAdtEntity.getFlag().equals("I")) {
						try {
							jdbcTemplate.execute(InsertSql(iemrEnAdtEntity));
							IemrEnAdtEntityDao.delete(iemrEnAdtEntity);
						} catch (Exception e) {
							log.warn("sync " + iemrEnAdtEntity.getEnAdtCd()
									+ " insert org_emp_dept exception ..."
									+ e.getMessage());
						}
					}
					if (iemrEnAdtEntity.getFlag().equals("U")) {
						// log.debug("time:["
						// + new java.util.Date().toLocaleString() + "]");
						try {
							jdbcTemplate.execute(UpdateSql(iemrEnAdtEntity));
							IemrEnAdtEntityDao.delete(iemrEnAdtEntity);
						} catch (Exception e) {
							log.warn("sync " + iemrEnAdtEntity.getEnAdtCd()
									+ " update org_emp_dept exception ..."
									+ e.getMessage());

						}
					}
					if (iemrEnAdtEntity.getFlag().equals("D")) {
							// log.debug("time:["
							// + new java.util.Date().toLocaleString() + "]");
						try {
							jdbcTemplate.execute(DeleteSql(iemrEnAdtEntity));
							IemrEnAdtEntityDao.delete(iemrEnAdtEntity);
						} catch (Exception e) {
							log.warn("sync " + iemrEnAdtEntity.getEnAdtCd()
									+ " org_emp_dept exception ..."
									+ e.getMessage());
						}
					}
					log.debug("sync org end ... ");
				}
			}
		}
	}




	
	private String InsertSql(IemrEnAdtEntity iemrEnAdtEntity) {

		StringBuffer sb_insert = new StringBuffer();
		sb_insert.append(" insert into en_adt ");
		sb_insert.append("(en_adt_cd,en_pk,patient_id,en_cnt,ledger_sn,trans_times,admiss_date,dis_date"
				+",trans_reg_date,trans_date,trans_type,orig_dept,orig_ward,orig_room,orig_bed"
				+",orig_opera,curr_dept,curr_ward,curr_room,curr_bed"
				+",curr_opera,mark ) values (");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getEnAdtCd()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getEnAdtCd() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getEnPk()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getEnPk() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getPatientId()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getPatientId() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getEnCnt()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getEnCnt() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(","+ iemrEnAdtEntity.getLedgerSn());
		sb_insert.append(","+ iemrEnAdtEntity.getTransTimes());
		sb_insert.append(",");
		if (null != iemrEnAdtEntity.getAdmissDate() ) {
			sb_insert.append(" to_date('" + sdf.format(iemrEnAdtEntity.getAdmissDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (null != iemrEnAdtEntity.getDisDate() ) {
			sb_insert.append(" to_date('" +  sdf.format(iemrEnAdtEntity.getDisDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_insert.append("''");
		}

		sb_insert.append(",");
		if (null != iemrEnAdtEntity.getTransRegDate() ) {
			sb_insert.append(" to_date('" + sdf.format(iemrEnAdtEntity.getTransRegDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (null != iemrEnAdtEntity.getTransDate() ) {
			sb_insert.append(" to_date('" + sdf.format(iemrEnAdtEntity.getTransDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getTransType()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getTransType() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigDept()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getOrigDept() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigWard()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getOrigWard() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigRoom()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getOrigRoom() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigBed()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getOrigBed() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigOpera()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getOrigOpera() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrDept()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getCurrDept() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrWard()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getCurrWard() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrRoom()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getCurrRoom() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrBed()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getCurrBed() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrOpera()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getCurrOpera() + "'");
		} else {
			sb_insert.append("''");
		}
		
		sb_insert.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getMark()) ) {
			sb_insert.append("'" + iemrEnAdtEntity.getMark() + "'");
		} else {
			sb_insert.append("''");
		}
		sb_insert.append(" )");
		log.debug("insert ..." + sb_insert.toString());
		return sb_insert.toString();
	}
	//生成更新sql
	private String UpdateSql(IemrEnAdtEntity iemrEnAdtEntity) {
		StringBuffer sb_update = new StringBuffer();
		sb_update.append("update  en_adt set ");
		sb_update.append("(en_pk,patient_id,en_cnt,ledger_sn,trans_times,admiss_date,dis_date"
				+",trans_reg_date,trans_date,trans_type,orig_dept,orig_ward,orig_room,orig_bed"
				+",orig_opera,curr_dept,curr_ward,curr_room,curr_bed"
				+",curr_opera,mark ) ");
		sb_update.append(" = ( select ");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getEnPk()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getEnPk() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getPatientId()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getPatientId() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getEnCnt()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getEnCnt() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(","+ iemrEnAdtEntity.getLedgerSn());
		sb_update.append(","+ iemrEnAdtEntity.getTransTimes());
		sb_update.append(",");
		if (null != iemrEnAdtEntity.getAdmissDate() ) {
			sb_update.append(" to_date('" + sdf.format(iemrEnAdtEntity.getAdmissDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (null != iemrEnAdtEntity.getDisDate() ) {
			sb_update.append(" to_date('" +  sdf.format(iemrEnAdtEntity.getDisDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_update.append("''");
		}

		sb_update.append(",");
		if (null != iemrEnAdtEntity.getTransRegDate() ) {
			sb_update.append(" to_date('" + sdf.format(iemrEnAdtEntity.getTransRegDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (null != iemrEnAdtEntity.getTransDate() ) {
			sb_update.append(" to_date('" + sdf.format(iemrEnAdtEntity.getTransDate()) + "','yyyy-MM-DD hh24:mi:ss')");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getTransType()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getTransType() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigDept()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getOrigDept() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigWard()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getOrigWard() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigRoom()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getOrigRoom() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigBed()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getOrigBed() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getOrigOpera()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getOrigOpera() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrDept()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getCurrDept() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrWard()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getCurrWard() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrRoom()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getCurrRoom() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrBed()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getCurrBed() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getCurrOpera()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getCurrOpera() + "'");
		} else {
			sb_update.append("''");
		}
		
		sb_update.append(",");
		if (!StringUtils.isBlank(iemrEnAdtEntity.getMark()) ) {
			sb_update.append("'" + iemrEnAdtEntity.getMark() + "'");
		} else {
			sb_update.append("''");
		}
		sb_update.append("  from dual ) where en_adt_cd ='");
		sb_update.append(iemrEnAdtEntity.getEnAdtCd() + "' ");
		log.debug("update ..." + sb_update.toString());
		return sb_update.toString();
	}
	//生成删除sql
	private String DeleteSql(IemrEnAdtEntity iemrEnAdtEntity) {
		StringBuffer bf_delete = new StringBuffer();
		bf_delete.append("delete from en_adt where en_adt_cd ='"
				+ iemrEnAdtEntity.getEnAdtCd() + "'");
		log.debug(" delete  语句>........" + bf_delete.toString());
		return bf_delete.toString();
	}
}
