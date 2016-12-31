package pkuhit.iih.qa.qaauto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.dao.auto.QaAutoFltDao;
import pkuhit.iih.qa.dao.auto.QaDivideDao;
import pkuhit.iih.qa.dao.auto.entity.QaAutoFlt;
import pkuhit.iih.qa.dao.auto.entity.QaDivide;
import pkuhit.iih.qa.qaauto.old.FirstDiseaseRecordTBServiceImpl;
import pkuhit.iih.qa.qaauto.old.IllConditionRecoredTBServiceImpl;
import pkuhit.iih.qa.qaauto.old.InRecordTimeBoundServiceImpl;
import pkuhit.iih.qa.qaauto.old.UpDoctorFirstRecoredTBServiceImpl;
import pkuhit.iih.qa.qacustom.QaScoreService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.util.UUIDGenerator;

public class QaAutoDataProcessServiceImpl implements QaAutoDataProcessService{

	@Reference
	QaScoreService qaScoreService;
	
	@Autowired
	QaDivideDao qaDivideDao;
	
	@Autowired
	QaAutoFltDao qaAutoFltDao;
	

	@Override
	public void batchDeleteDivide(String enPk) throws Exception {
		//开始自动质控时，先删除已有的自动质控扣分项
		 ArrayResult<QaDivideModel> qaDivideDeleteArrayResult = null;
		    Map searchDeleteMap = new HashMap();
		    searchDeleteMap.put("encounterPk", enPk);
		    searchDeleteMap.put("workScreen", "12");//12为环节质控质量自评
		    try {
		    	qaDivideDeleteArrayResult = qaScoreService.search(searchDeleteMap);
			} catch (Throwable e) {
				e.printStackTrace();
		}
		//批量删除自动质控扣分项
	    batchDeleteDivide(qaDivideDeleteArrayResult);
		
	}



	@Override
	public List<QaItem> qaItems(String qaType) throws Exception {
		
		List  autoItemList = new ArrayList();
		QaItem qaItem = new QaItem();//*未在患者入院24小时内完成入院记录
		qaItem.setQaItmCd("QAM16.24");
		qaItem.setMemo("selectQaMr");
		autoItemList.add(qaItem);
		
		QaItem qaItem1 = new QaItem();//*未在患者住院8小时内完成首次病程记录
		qaItem1.setQaItmCd("QAM16.51");
		qaItem1.setMemo("selectQaMr");
		autoItemList.add(qaItem1);
		
		QaItem qaItem2 = new QaItem();//主治医师首次查房记录未在48小时内完成
		qaItem2.setQaItmCd("QAM16.89");
		qaItem2.setMemo("selectQaMr");
		autoItemList.add(qaItem2);
		if(qaType.equals("1")){
			
		}else{
			QaItem qaItem3 = new QaItem();//病危患者1天、病重患者2天无病程记录
			qaItem3.setQaItmCd("QAM16.57");
			qaItem3.setMemo("selectQaMr");
			autoItemList.add(qaItem3);
		}
		
		
		return autoItemList;
	}

	private void batchDeleteDivide( ArrayResult<QaDivideModel> qaDivideArrayResult){
		QaDivideModel[] dataList = qaDivideArrayResult.getDataList();
		if(null != dataList){
			for(QaDivideModel qaDivideModel : dataList){
				try {
					qaScoreService.delete(qaDivideModel.getQaDivideCd());
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}



	@Override
	public Map qaValidateMap(String qaType) throws Exception {
		Map qaItemCdAndServiceMap = new HashMap();
		QaTimeBoundService inRecordTimeBoundService = new InRecordTimeBoundServiceImpl();
		qaItemCdAndServiceMap.put("QAM16.24", inRecordTimeBoundService);
		QaTimeBoundService firstDiseaseRecordTBService = new FirstDiseaseRecordTBServiceImpl();
		qaItemCdAndServiceMap.put("QAM16.51", firstDiseaseRecordTBService);
		QaTimeBoundService upDoctorFirstRecoredTBService = new UpDoctorFirstRecoredTBServiceImpl();
		qaItemCdAndServiceMap.put("QAM16.89", upDoctorFirstRecoredTBService);
		QaTimeBoundService IllConditionRecoredTBService = new IllConditionRecoredTBServiceImpl();
		qaItemCdAndServiceMap.put("QAM16.57", IllConditionRecoredTBService);
		return qaItemCdAndServiceMap;
	}



	@Override
	public void saveQaDivide(QaValidateModel qaValidateModel, String qaItemCode, String enPk, String qaAutoTypeCode,String qaItmTpCd) throws Exception {

		QaDivideModel  qaDivideModel = new QaDivideModel();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String qaDivideCd = "";
		String drpDes = "";
		if(null != qaItmTpCd ){
			if(qaItmTpCd.equals(CusQaAutoItmConfig.TIMELIMIT)){ //时限性
				drpDes = "业务时间为 ";
				if(null != qaValidateModel.getBizTime()){
					drpDes = drpDes + df.format(qaValidateModel.getBizTime());//qaValidateModel.getBizTime();
				}else{
					drpDes = drpDes +"空";
				}
				drpDes = drpDes + ",截止时间为 ";
				if(null != qaValidateModel.getDeadDate()){
					drpDes = drpDes + df.format(qaValidateModel.getDeadDate());
				}else{
					drpDes = drpDes+"空";
				}
			}else if(qaItmTpCd.equals(CusQaAutoItmConfig.INTEGRITY)){// 完整性
				if(null != qaValidateModel.getBizTime() && null == qaValidateModel.getMemo()){
					drpDes = "缺少该份文书";
				}else if(null != qaValidateModel.getMemo()){
					drpDes = qaValidateModel.getMemo();
				}else{
					drpDes ="业务时间为 空";
				}
			}else if(qaItmTpCd.equals(CusQaAutoItmConfig.FREQUENCY)){// 频率性
				if(null != qaValidateModel.getValidateType() && qaValidateModel.getValidateType().equals(qaValidateModel.vaNoParam)){
					drpDes ="业务时间为 空";
				}else{
					drpDes ="缺少文书";
				}
				
			}
			
		}
		
		//保存自动质控扣分记录
		QaDivide qaDivide = new QaDivide();
		qaDivideCd = UUIDGenerator.getUUID();
		qaDivideModel.setQaDivideCd(qaDivideCd);
		qaDivideModel.setQaItmPk(qaItemCode);
		qaDivideModel.setQaTyCd(qaAutoTypeCode);
		qaDivideModel.setEnPk(enPk);
		
		qaDivideModel.setDrpDes(drpDes);
		qaDivideModel.setDeductScrTimes(1);
		
		BeanCopyUtil.modelToEntity(qaDivide, qaDivideModel);
		qaDivideDao.insert(qaDivide);
	
		
	}
	
	public void updateQaAutoFlt(CusQaAutoFltModel cusQaAutoFltModel, QaValidateModel qaValidateModel, String qaItemCode, String enPk, String qaAutoTypeCode,String qaItmTpCd) throws Exception {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		//缺陷描述
		String drpDes = "";
		if(null != qaItmTpCd ){
			if(qaItmTpCd.equals(CusQaAutoItmConfig.TIMELIMIT)){ //时限性
				if(qaValidateModel.getValidateType().equals(QaValidateModel.vaNoRecord) ){
					drpDes = "缺少该份文书   ";
				}
				drpDes = drpDes +"开始时间为 ";
				if(null != qaValidateModel.getBizTime()){
					drpDes = drpDes + df.format(qaValidateModel.getBizTime());//qaValidateModel.getBizTime();
				}else{
					drpDes = drpDes +"空";
				}
				drpDes = drpDes + ",截止时间为 ";
				if(null != qaValidateModel.getDeadDate()){
					drpDes = drpDes + df.format(qaValidateModel.getDeadDate());
				}else{
					drpDes = drpDes+"空";
				}
			}else if(qaItmTpCd.equals(CusQaAutoItmConfig.INTEGRITY)){// 完整性
				if(null != qaValidateModel.getBizTime() && null == qaValidateModel.getMemo()){
					drpDes = "缺少该份文书";
				}else if(null != qaValidateModel.getMemo()){
					drpDes = qaValidateModel.getMemo();
				}/*else{
					drpDes ="业务时间为 空";
				}*/
			}else if(qaItmTpCd.equals(CusQaAutoItmConfig.FREQUENCY)){// 频率性
				if(null != qaValidateModel.getValidateType() && qaValidateModel.getValidateType().equals(qaValidateModel.vaNoParam)){
					drpDes ="业务时间为 空";
				}else{
					drpDes ="缺少文书";
				}
				
			}
			
		}
		
		//保存自动质控扣分记录
		QaAutoFlt qaAutoFlt = new QaAutoFlt();
		//如果validateResult = true，则不是缺陷FltFlag=2，否则是缺陷FltFlag=1
		Short flt = 1;
		Short notFlt = 2;
		if(qaValidateModel.isValidateResult()){
			cusQaAutoFltModel.setFltFlag(notFlt);
		}else{
			//时限质控发送超时申请
			if(qaItmTpCd != null && qaItmTpCd.equals(CusQaAutoItmConfig.TIMELIMIT)){
				cusQaAutoFltModel.setApplyFlag(flt);
			}
			cusQaAutoFltModel.setFltFlag(flt);
		}
		cusQaAutoFltModel.setCompleteTime(qaValidateModel.getCompleteTime());
		cusQaAutoFltModel.setMemo(drpDes);
		
		BeanCopyUtil.modelToEntity(qaAutoFlt, cusQaAutoFltModel);
		qaAutoFltDao.updateExcludeNull(qaAutoFlt);
	
		
	}
}
