package pkuhit.iih.qa.qaauto.validator.baseValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;
import xap.ru.engin.data.Condition;
import xap.ru.engin.data.DataModel;
import xap.ru.engin.data.SearchResult;
import xap.ru.engin.item.ItemEvent;

 /**
  * 该类暂时不启用
  * @deprecated
  * @author wang_yanli
  *
  */
public class CommonTimeBoundValidator extends BaseTimeBound{/*

	public void validateMrTimeBound(DataModel dataModel,ItemEvent itemEvent,List<QaValidateModel> qaValidateModelList,int deadHours,QaValidateMsgModel msgModel)
			throws Exception{
		//获取itemEvent中的condition
		Condition condition = itemEvent.getCondition();
		Map<String, Object> searchCondition = null;
		//质控的文书类型
		String mrTypeCode = "";
		if(condition != null){
			searchCondition = condition.getSearchCondition();
		}
		if(searchCondition != null){
			mrTypeCode = searchCondition.get("mrTypeCode").toString();
		}
		//获得患者病历文书
		SearchResult<QaAutoModel> searchResult =  (SearchResult<QaAutoModel>) dataModel.getSearchResult("enMrList");
		List<QaAutoModel> qaAutoMrModelList = searchResult.getResultList();
		List<QaAutoModel> qaAutoHaveTypeMrList = null;//存放过滤出的需校验的文书列表
		//获得患者病案信息
		SearchResult<Amr> amrSearchResult =  (SearchResult<Amr>) dataModel.getSearchResult("amr");
		List<Amr> amrList = amrSearchResult.getResultList();
		Amr amr = null;
		if(amrList != null && amrList.size() > 0){
			amr = amrList.get(0);
		}
		
		QaValidateModel qaValidateModel = new QaValidateModel(); 
		
		//以下为判断流程
		
		//1、调用父类中的方法，判断入科时间+deadHours compareto 当前系统时间
		
		qaValidateModel = validateCurrentAndDeptIntoTime(amr,deadHours,msgModel);
		
		
		//a、如果返回true，说明   入科时间+deadHours>当前时间，不需要继续判断
		//b、如果返回false，则判断是否为QaValidateModel.vaNoParam，如果是，则说明无入科时间，不需要后续判断
		if(qaValidateModel.isValidateResult() || qaValidateModel.getValidateType().equals(QaValidateModel.vaNoParam)){
			qaValidateModelList.add(qaValidateModel);
		}

		if(qaValidateModelList.size()==0){
			//2、根据返回的文书记录，判断是否存mrTypeCode类型的文书,如果不存在，则不需要继续判断
			qaValidateModel = validateHaveTypeMr(qaAutoMrModelList, mrTypeCode, msgModel);//(qaAutoMrModelList,mrTypeCode,deadHours,qaValidateMsg);
			if(!qaValidateModel.isValidateResult()){
				qaValidateModelList.add(qaValidateModel);
			}
		}
		if(qaValidateModelList.size()==0){
			//3、存在mrTypeCode类型的文书，校验文书是否符合要求
			qaAutoHaveTypeMrList = qaValidateModel.getTempResultMap().get(mrTypeCode);
			qaValidateModel = validateMrList(amr, qaAutoHaveTypeMrList, mrTypeCode, deadHours, msgModel);
			qaValidateModelList.add(qaValidateModel);
		}
	}
*/}
