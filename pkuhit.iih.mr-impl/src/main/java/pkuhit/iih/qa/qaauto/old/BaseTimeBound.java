package pkuhit.iih.qa.qaauto.old;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import pkuhit.iih.qa.util.QaAutoUtil;

public class BaseTimeBound {

	/**
	 * 验证：入科时间（入院时间）+ 限制时间 compare 当前系统时间
	 * @param amr 
	 * @param deadHours
	 * @param msgModel
	 * @return
	 * @throws Exception
	 */
	public QaValidateModel validateCurrentAndDeptIntoTime( Amr amr,int deadHours ,QaValidateMsgModel msgModel)
			throws Exception {

		QaValidateModel qaValidateModel = new QaValidateModel(); 
		
		//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
		Date curDeptIntoTimeDt = null;
		Timestamp curDeptIntoTime = null;
		//系统当前时间
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		if(null != amr && null != amr.getCurrentDeptIntoTime()){
			curDeptIntoTimeDt = amr.getCurrentDeptIntoTime();//入科时间
			curDeptIntoTime = new Timestamp(curDeptIntoTimeDt.getTime());
		}
		
		qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, currentTimeTs, deadHours,msgModel);
		
		return qaValidateModel;
	
	}
	
	public QaValidateModel validateMrList(List<QaAutoModel> qaAutoMrModelList, String mrTypeCode, int deadHours, QaValidateMsgModel msgModel )throws Exception {
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(QaAutoModel qaAutoModel: qaAutoMrModelList){
				//1=判断有无入院记录
				if(!qaAutoModel.getTypeCode().equals(mrTypeCode)){ //初次
					qaValidateModel.setValidateMessage("无入院记录");
					continue;
				}
				
				//2=判断时间
				Timestamp curDeptIntoTime = qaAutoModel.getCurDeptIntoTime();//入科时间
				Date subDate = qaAutoModel.getLogicSubmitTime();
				Timestamp subDateTs = null; 
				if(null != subDate){
					subDateTs = new Timestamp(subDate.getTime());
				}
				qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, subDateTs, deadHours,msgModel);
				if(!qaValidateModel.isValidateResult()){
					break;
				}
				
				//如果程序可以走到这说明，需校验的2个条件都满足书写要求，故置resultValue=true
				resultValue = true;
				break;
				
			}
			
		}
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	public QaValidateModel validateUnWriteMr(List<QaAutoModel> qaAutoMrModelList, Amr amr,String mrTypeCode, int deadHours, QaValidateMsgModel msgModel ) 
			throws Exception{
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		
		if(null != amr && null != amr.getCurrentDeptIntoTime()){
			
			Date curDeptIntoTimeDt = amr.getCurrentDeptIntoTime();//入科时间
			Timestamp curDeptIntoTime = null;
			
			if(null != curDeptIntoTimeDt){
				curDeptIntoTime = new Timestamp(curDeptIntoTimeDt.getTime());
			}

			if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
				for(QaAutoModel qaAutoModel: qaAutoMrModelList){
					//1=判断有无入院记录
					if(!qaAutoModel.getTypeCode().equals(mrTypeCode)){ 
						qaValidateModel.setValidateType(QaValidateModel.vaNoRecord);
						qaValidateModel.setValidateMessage(msgModel.getMsgAttr()[0]+"未创建");
						continue;
					}
					
					//2=判断时间
					
					Date subDate = qaAutoModel.getLogicSubmitTime();
					if(null != subDate){
						resultValue = true;
						qaValidateModel.setValidateType(QaValidateModel.vaCorrect);
						break;
					}
					//只对没有提交时间的进行提醒
					qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
					if(!qaValidateModel.isValidateResult()){
						if(qaValidateModel.getValidateType().equals(QaValidateModel.vaFault)){
							qaValidateModel.setValidateMessage(msgModel.getMsgAttr()[0]+"逾期未提交");
						}else if(qaValidateModel.getValidateType().equals(QaValidateModel.vaCorrect)){
							qaValidateModel.setValidateMessage("请及时提交"+msgModel.getMsgAttr()[0]);
						}else if(qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam)){
							qaValidateModel.setValidateMessage("入科时间为空");
						}
						
						break;
					}
					//如果程序可以走到这说明，需校验的条件都满足书写要求，故置resultValue=true
					resultValue = true;
					break;
					
				}
				if(null!=qaValidateModel.getValidateType() && qaValidateModel.getValidateType().equals(QaValidateModel.vaNoRecord)){
					qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
				}else{
					
					qaValidateModel.setValidateResult(resultValue);
				}
			}else{
				qaValidateModel.setValidateType(QaValidateModel.vaNoRecord);
				qaValidateModel = QaAutoUtil.valideTime(curDeptIntoTime, null, deadHours,msgModel);
			}
			
		}else{
			qaValidateModel.setValidateResult(false);
			qaValidateModel.setValidateType(QaValidateModel.vaNoParam);
			qaValidateModel.setValidateMessage("入科时间为空");
		}
		return qaValidateModel;
		
	}
	
/*	public List searchResultList(DataModel dataModel,String searchKey)
			throws Exception{
		SearchResult<QaAutoModel> searchResult =  (SearchResult<QaAutoModel>) dataModel.getSearchResult(searchKey);
		List<QaAutoModel> qaAutoMrModelList = searchResult.getResultList();
		return null;
	}*/
}
