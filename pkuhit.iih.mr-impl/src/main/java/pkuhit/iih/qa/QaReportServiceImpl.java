package pkuhit.iih.qa;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.dao.auto.IemrReportDao;
import pkuhit.iih.qa.dao.auto.entity.IemrReport;
import pkuhit.iih.qa.dao.qacustom.CusIemrReportDao;
import pkuhit.iih.qa.old.QaFault;
import pkuhit.iih.qa.IemrReportModel;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

public class QaReportServiceImpl implements QaReportService{
	@Autowired
	IemrReportDao iemrReportDao;
	
	@Autowired
	CusIemrReportDao cusIemrReportDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	public QaReportServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayResult<IemrReportModel> search(Map param) throws Throwable {
		ArrayResultBuilder<IemrReportModel> builder = ArrayResultBuilder.newArrayResult(IemrReportModel.class);
		Session session = Session.get();
		String userId = session.getUserId();
		
		//wangyanli add start
		
		String reportType = "";
		String workScreen = "15"; //15=质控报表-工作画面  16=护理报表
		if(param != null && param.containsKey("workScreen")){
			workScreen = param.get("workScreen").toString();
		}	
		
		if(workScreen.equals("15")){
			reportType = "QA";
		}else if(workScreen.equals("16")){
			reportType = "NS";
		}
		//wangyali add end 
		
		List<Map<String, Object>> iemrReportList= cusIemrReportDao.selectIemrReport(userId,reportType);
		int total = 0;
		if(iemrReportList!=null && iemrReportList.size()>0 ){
			total = iemrReportList.size();
			IemrReportModel[] iemrReportArr = new IemrReportModel[iemrReportList.size()];
			for(int i=0;i<iemrReportList.size();i++){
				IemrReportModel iemrReportModel = new IemrReportModel();
				iemrReportModel.setReportCd(isNull(iemrReportList.get(i).get("ID")));
				iemrReportModel.setReportName(isNull(iemrReportList.get(i).get("NM")));
				iemrReportModel.setDeptCd(isNull(iemrReportList.get(i).get("DEPT_CD")));
				iemrReportModel.setUrl(isNull(iemrReportList.get(i).get("URL")));
				iemrReportModel.setReportDes(isNull(iemrReportList.get(i).get("DES")));
				iemrReportModel.setParaNm(isNull(iemrReportList.get(i).get("PARA_NM")));
				iemrReportModel.setParaTp(isNull(iemrReportList.get(i).get("PARA_TP")));
				iemrReportArr[i] = iemrReportModel;
			}
			builder.withData(iemrReportArr);
		}
		ArrayResult<IemrReportModel> iemrReportResult = builder.build();
		iemrReportResult.setTotal(total);
		return iemrReportResult;
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
	
	@Override
	public SingleResult<IemrReportModel> get(String id){
	    SingleResultBuilder<IemrReportModel> builder = SingleResultBuilder.newSingleResult(IemrReportModel.class);
	    IemrReport entity = iemrReportDao.selectById(id);
	    if(null != entity){
	        IemrReportModel model = new IemrReportModel();
	        model.setReportCd(entity.getId());
	        model.setReportName(entity.getNm());
	        model.setDeptCd(entity.getDeptCd());
	        model.setUrl(entity.getUrl());
	        model.setReportDes(entity.getDes());
	        model.setParaNm(entity.getParaNm());
	        model.setParaTp(entity.getParaTp());
	        builder.withData(model);
	    }
	    SingleResult<IemrReportModel> rs = builder.build();
	    return rs;
	}

}
