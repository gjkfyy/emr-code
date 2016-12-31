package ei.cis.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import pkuhit.xap.ass.ObsReport;
import pkuhit.xap.util.PerformancePrinter;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import ei.cis.db.dao.CisDao;
import ei.cis.service.CisService;
import ei.iih.db.dao.auto.entity.VwNisWardConfig;
import ei.iih.db.dao.custom.VwNisWardConfigDao;
import ei.ris.service.RisObReportService;

public class CisServiceImpl implements CisService
{
    @Autowired
    CisDao cisDao;
    
    @Reference
    RisObReportService risObReportService;
    
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	VwNisWardConfigDao vwNisWardConfigDao;
	
    @Override
    public ArrayResult<ObsReport> searchByObsOrder(String enPk, String currentPageIndex,
            String pageSize) {
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(currentPageIndex)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();  
        long count = options.getCount();
        int total = Long.valueOf(count).intValue();
        ObsReport[] voArray = null ;
        ArrayResultBuilder<ObsReport> builder = ArrayResultBuilder.newArrayResult(ObsReport.class);
        if(null == currentPageIndex || !StringUtils.isNumeric(currentPageIndex)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
        {
            currentPageIndex= "1";
            pageSize = "1000";
        }
        List<String> applyCodeList = new ArrayList<String>();
        //根据就诊号，查询检查申请单
        List<Map<String,Object>> list = this.cisDao.getObsOrderByEnSn(enPk);
        if(list != null && list.size() > 0){
            for(int i=0;i<list.size();i++){
                Map<String,Object> m = list.get(i);
                String applyCode = "";
                //台心取apply_code，海四取his_apply_no(cis标准版，无apply_code)
                if(m.containsKey("apply_code"))
                    applyCode = m.get("apply_code")==null?"":m.get("apply_code").toString();
                else if(m.containsKey("his_apply_no"))
                    applyCode = m.get("his_apply_no")==null?"":m.get("his_apply_no").toString();
                applyCodeList.add(applyCode);
            }
            //根据检查申请单号，查询检查报告
            List<ObsReport> poList = risObReportService.searchObsListByObsNo(applyCodeList);
            if(null != poList){
                 voArray = new ObsReport[poList.size()];
                 int i = 0;
                 for(ObsReport po : poList){
                     ObsReport vo = new ObsReport();
                     BeanUtils.copyProperties( po,vo);
                     voArray[i]= vo;
                     i++;
                 }
                 builder.withData(voArray);
            }
        }
        ArrayResult<ObsReport> rs = builder.build();
        rs.setTotal(total);
        return rs;
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
    public List<Map<String, Object>> searchUserByCert(String caSubject,String strCertId){
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        if("1".equals(caSubject))
            result = cisDao.getUserByBJCACert(strCertId);
        else
            result = cisDao.getUserByNetCACert(strCertId);
        return result;
    }

	@Override
	public List<Map<String, Object>> getCaState(String userId) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		if(userId != null && userId != ""){
			result = cisDao.getCaStateByUserId(userId);
		}
		return result;
		
	}
	
}
