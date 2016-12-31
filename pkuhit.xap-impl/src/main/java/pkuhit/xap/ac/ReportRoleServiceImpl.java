package pkuhit.xap.ac;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import pkuhit.iih.qa.IemrReportModel;
import pkuhit.xap.dao.auto.IemrReportRoleDao;
import pkuhit.xap.dao.auto.XapRoleDao;
import pkuhit.xap.dao.auto.entity.IemrReport;
import pkuhit.xap.dao.auto.entity.IemrReportRole;
import pkuhit.xap.dao.custom.CustomReportRoleDao;
import pkuhit.xap.pub.MessageCode;
import xap.sv.annotation.Reference;
import xap.sv.i18n.MessageSource;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.util.UUIDGenerator;

public class ReportRoleServiceImpl implements ReportRoleService
{
    @Autowired
	XapRoleDao xapRoleDao;
    
    @Autowired
    IemrReportRoleDao iemrReportRoleDao;
    
    @Autowired
    CustomReportRoleDao cusReportRoleDao;
    
    @Reference
    MessageSource messageSource;
    
    @Override	
    public ArrayResult<IemrReportModel> search(Map<String, String> params)
    {
        List<IemrReport> list = cusReportRoleDao.selectReportList();
        ArrayResultBuilder<IemrReportModel> builder = ArrayResultBuilder.newArrayResult(IemrReportModel.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
        	IemrReportModel[] reportList = new IemrReportModel[list.size()];
			for(int i=0;i<list.size();i++){
				IemrReportModel iemrReportModel = new IemrReportModel();
				iemrReportModel.setReportCd(isNull(list.get(i).getId()));
				iemrReportModel.setReportName(isNull(list.get(i).getNm()));
				iemrReportModel.setDeptCd(isNull(list.get(i).getDeptCd()));
				iemrReportModel.setUrl(isNull(list.get(i).getUrl()));
				iemrReportModel.setReportDes(isNull(list.get(i).getDes()));
				iemrReportModel.setParaNm(isNull(list.get(i).getParaNm()));
				iemrReportModel.setParaTp(isNull(list.get(i).getParaTp()));
				reportList[i] = iemrReportModel;
			}
            builder.withData(reportList);
            size = reportList.length;
        }
        
        ArrayResult<IemrReportModel> arrayResult = builder.build();
        arrayResult.setTotal(size);
        return arrayResult;
    }

	@Override
	public ArrayResult<IemrReportModel> searchReportsByRoleCode(Map<String, String> params) {
        String roleCode = getParamValue(params, "roleCode");
        List<IemrReport> list = cusReportRoleDao.selectReportListByRoleCode(roleCode);
        ArrayResultBuilder<IemrReportModel> builder = ArrayResultBuilder.newArrayResult(IemrReportModel.class);
        int size = 0;
        if (list != null && list.size() > 0)
        {
        	IemrReportModel[] reportList = new IemrReportModel[list.size()];
			for(int i=0;i<list.size();i++){
				IemrReportModel iemrReportModel = new IemrReportModel();
				iemrReportModel.setReportCd(isNull(list.get(i).getId()));
				iemrReportModel.setReportName(isNull(list.get(i).getNm()));
				iemrReportModel.setDeptCd(isNull(list.get(i).getDeptCd()));
				iemrReportModel.setUrl(isNull(list.get(i).getUrl()));
				iemrReportModel.setReportDes(isNull(list.get(i).getDes()));
				iemrReportModel.setParaNm(isNull(list.get(i).getParaNm()));
				iemrReportModel.setParaTp(isNull(list.get(i).getParaTp()));
				reportList[i] = iemrReportModel;
			}
            builder.withData(reportList);
            size = reportList.length;
        }
        ArrayResult<IemrReportModel> arrayResult = builder.build();
        arrayResult.setTotal(size);
        return arrayResult;
	}

	@Override
	public SingleResult<ReportRole> saveReportsByRoleCode(String roleCode, ReportRole reportRole) {
		List<IemrReportModel> reportList = reportRole.getRoleReportList();
		//■　数据校验
        if (StringUtils.isEmpty(roleCode))
        {
//            throw new NotificationException(new Notification(MessageCode.M10010, "id"));
        }
        //更新角色报表
        this.deleteRoleReportByRoleCode(roleCode);
        if (reportList != null) {
        	for(IemrReportModel item:reportList) {
        		this.saveRoleReport(item, roleCode);
        	}
        }
        //■　返回更新后的角色
        SingleResultBuilder<ReportRole> builder = SingleResultBuilder.newSingleResult(ReportRole.class);
        builder.withData(reportRole);
		return builder.build();
    }
    
	private void saveRoleReport(IemrReportModel reportModel, String roleCd){
		IemrReportRole iemrReportRole = new IemrReportRole();
		iemrReportRole.setIemrReportRoleId(UUIDGenerator.getUUID());
		iemrReportRole.setIemrReportId(reportModel.getReportCd());
		iemrReportRole.setRoleCd(roleCd);
		iemrReportRole.setMemo(reportModel.getReportDes());
	    iemrReportRoleDao.insert(iemrReportRole);
	}
    
	private void deleteRoleReportByRoleCode(String roleCode){
	    List<IemrReportRole> list = cusReportRoleDao.selectReportRoleListByRoleCode(roleCode);
	    if (list != null){
	    	iemrReportRoleDao.batchDelete(list);
        }
	}    
	
    String getParamValue(Map<String, String> params, String paramName)
    {
        String value = params.get(paramName);
        if (!StringUtils.hasText(value))
        {
            return null;
        }
        return value;
    }
    
    private String isNull(Object param){
		String str = "";
		if(param!=null){
			if(!param.toString().isEmpty()){
				str = param.toString();
			}
		}
		return str;
	}

}
