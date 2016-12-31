package pkuhit.iih.qa.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pkuhit.iih.en.md.IllStatus;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaValidateConfigModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.QaValidateMsgModel;

public class QaAutoUtil {

	//需自动质控的项目list
	public static Map autoItemMap(){
		
		Map<String,Map> autoItemList = new HashMap();
		Map searchMethodAndParams =  new HashMap();
		searchMethodAndParams.put("selectQaMr", "mr:mr_amr:xap_user:org_emp");
		autoItemList.put("QAM16.24",searchMethodAndParams);//*未在患者入院24小时内完成入院记录
		autoItemList.put("QAM16.51",searchMethodAndParams);//*未在患者住院8小时内完成首次病程记录
		autoItemList.put("QAM16.89",searchMethodAndParams);//主治医师首次查房记录未在48小时内完成
		autoItemList.put("QAM16.57",searchMethodAndParams);//病危患者1天、病重患者2天无病程记录
	
	
		return autoItemList;
	}
	//需自动质控的项目list
		public static List<QaValidateConfigModel> autoItemConfigMap(){
			
/*			Map<String,Map> autoItemMap= new HashMap();
			Map<String,String> itemEventConfig1 =  new HashMap();
			itemEventConfig1.put("itemEventCode", "QAM18.01");
			itemEventConfig1.put("mrTypeCode", "MRM16.13");//
			autoItemMap.put("QAM16.24",itemEventConfig1);//*未在患者入院24小时内完成入院记录
			Map<String,String> itemEventConfig2 =  new HashMap();
			itemEventConfig2.put("itemEventCode", "QAM18.01");
			itemEventConfig2.put("mrTypeCode", "MRM16.17");//
			autoItemMap.put("QAM16.51",itemEventConfig2);//*未在患者住院8小时内完成首次病程记录
*/			/*autoItemMap.put("QAM16.89",itemEventConfig);//主治医师首次查房记录未在48小时内完成
			autoItemMap.put("QAM16.57",itemEventConfig);//病危患者1天、病重患者2天无病程记录
*/			
			List<QaValidateConfigModel> qaValidateConfigList = new ArrayList<QaValidateConfigModel>();
			QaValidateConfigModel configModel = new QaValidateConfigModel();
			configModel.setItemCode("QAM16.24");
			configModel.setMrType("");
			configModel.setEventTypeCode("MRM16.13");
			configModel.setDeadHours(24);
			QaValidateConfigModel configModel2 = new QaValidateConfigModel();
			configModel2.setItemCode("QAM16.51");
			configModel2.setMrType("");
			configModel2.setEventTypeCode("MRM16.17");
			configModel2.setDeadHours(8);
			qaValidateConfigList.add(configModel);
			qaValidateConfigList.add(configModel);
			return qaValidateConfigList;
			
		}
	//无入院记录 -----规则：输入患者就诊序号，能得到该患者的所有文书，遍历文书，对入院记录文书做校验：无入院记录、24小时内完成、非执业医师书写
	//如果符合要求则返回true，如果校验不符合则返回false 
	//在进行验证时，尽量避免if-else嵌套，使得逻辑清晰
	public static boolean validateInRecored(List<QaAutoModel> qaAutoMrModelList){
		
		boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
		if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
			for(QaAutoModel qaAutoModel: qaAutoMrModelList){
				//1=判断有无入院记录
				if(!qaAutoModel.getTypeCode().equals("MRM16.13")){ //初次
					continue;
				}
				
				//2=判断时间
				
				//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
				Timestamp curDeptIntoTime = qaAutoModel.getCurDeptIntoTime();//入科时间
				if(null == curDeptIntoTime){//如果入科时间为空，则默认校验通过，待确认=============================
					 resultValue = true;
					 break;
				}
				Date deadLineDate = QaUtil.dateIncreaseByHours(curDeptIntoTime, 24);
				Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
				//系统当前时间
				Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
				if(deadLineDateTs.compareTo(currentTimeTs)<1){
					Date subDate = qaAutoModel.getSubmitDate();
					if (subDate == null) {
						break;
					}
					Timestamp subDateTs = new Timestamp(subDate.getTime());
					
					
					if(deadLineDateTs.compareTo(subDateTs)<1){//
						break;
					}
					
				}
				
				//3=判断是否为时非职业医师      如果org_emp表中对应的job_title_cd是非职业医师，则返回false
				if(qaAutoModel.getJobTitleCd().equals("aa")){
					break;
				}
				
				//如果程序可以走到这说明，需校验的3个条件都满足书写要求，故置resultValue=true
				resultValue = true;
				break;
				
			}
		}
		return resultValue;
	}
	
	//无首次病程记录或患者入院8小时内完成 -----规则：输入患者就诊序号，能得到该患者的所有文书，遍历文书，对首次病程文书做校验：无首次病程、患者入院8小时内完成
		//如果符合要求则返回true，如果校验不符合则返回false 
		//在进行验证时，尽量避免if-else嵌套，使得逻辑清晰
		public static boolean validateFirstRecored(List<QaAutoModel> qaAutoMrModelList){
			
			boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
			if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
				for(QaAutoModel qaAutoModel: qaAutoMrModelList){
					//1=判断有无首次病程记录
					if(!qaAutoModel.getTypeCode().equals("MRM16.17")){
						continue;
					}
					
					//2=判断时间
					//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
					Timestamp curDeptIntoTime = qaAutoModel.getCurDeptIntoTime();//入科时间
					if(null == curDeptIntoTime){//如果入科时间为空，则默认校验通过，待确认=============================
						 resultValue = true;
						 break;
					}
					Date deadLineDate = QaUtil.dateIncreaseByHours(curDeptIntoTime,
							8);
					Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
					//系统当前时间
					Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
					if(deadLineDateTs.compareTo(currentTimeTs)<1){
						Date subDate = qaAutoModel.getSubmitDate();
						if (subDate == null) {
							break;
						}
						Timestamp subDateTs = new Timestamp(subDate.getTime());
						
						
						if(deadLineDateTs.compareTo(subDateTs)<1){//
							break;
						}
						
					}
					
					//如果程序可以走到这说明，需校验的2个条件都满足书写要求，故置resultValue=true
					resultValue = true;
					break;
					
				}
			}
			return resultValue;
		}
		
		//无上级医师首次查房记录或未在患者入院后48小时内完成 -----规则：输入患者就诊序号，能得到该患者的所有文书，遍历文书，对无上级医师首次查房记录文书做校验：无上级医师首次查房记录、未在患者入院后48小时内完成
		//如果符合要求则返回true，如果校验不符合则返回false 
		//在进行验证时，尽量避免if-else嵌套，使得逻辑清晰
		public static boolean validateUpDoctorFirstRecored(List<QaAutoModel> qaAutoMrModelList){
			
			boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
			if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
				for(QaAutoModel qaAutoModel: qaAutoMrModelList){
					//1=判断有无上级医师首次查房
					if(!qaAutoModel.getTypeCode().equals("MRM16.19")){
						continue;
					}
					
					//2=判断时间
					//mr_amr 表的入科时间作为入院时间CUR_DEPT_INTO_TIME
					Timestamp curDeptIntoTime = qaAutoModel.getCurDeptIntoTime();//入科时间
					if(null == curDeptIntoTime){//如果入科时间为空，则默认校验通过，待确认=============================
						 resultValue = true;
						 break;
					}
					Date deadLineDate = QaUtil.dateIncreaseByHours(curDeptIntoTime,
							24);
					Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
					//系统当前时间
					Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
					if(deadLineDateTs.compareTo(currentTimeTs)<1){
						Date subDate = qaAutoModel.getSubmitDate();
						if (subDate == null) {
							break;
						}
						Timestamp subDateTs = new Timestamp(subDate.getTime());
						
						
						if(deadLineDateTs.compareTo(subDateTs)<1){//
							break;
						}
						
					}
					
					//如果程序可以走到这说明，需校验的2个条件都满足书写要求，故置resultValue=true
					resultValue = true;
					break;
					
				}
			}
			return resultValue;
		}
		
		//无上级医师首次查房记录或未在患者入院后48小时内完成 -----规则：输入患者就诊序号，能得到该患者的所有文书，遍历文书，对无上级医师首次查房记录文书做校验：无上级医师首次查房记录、未在患者入院后48小时内完成
		//如果符合要求则返回true，如果校验不符合则返回false 
		//在进行验证时，尽量避免if-else嵌套，使得逻辑清晰
		public static boolean validateIllConditionRecored(List<QaAutoModel> qaAutoMrModelList){
			
			boolean resultValue = false; //此默认值的作用包括：如果查询结果为空，则校验结果为false
			if(null != qaAutoMrModelList && qaAutoMrModelList.size() > 0){
				int illRecordCount = 0;
				int diffDays = 0;
				int calCount = 0;
				QaAutoModel qaAutoModelTemp = qaAutoMrModelList.get(0);
				Timestamp curDeptIntoTime = qaAutoModelTemp.getCurDeptIntoTime();//入科时间
				String illStatus = qaAutoModelTemp.getIllStaCd();
				
				if(null == curDeptIntoTime){//如果入科时间为空，则默认校验通过，待确认=============================
					 resultValue = true;
				}else if(null != illStatus){
					//系统当前时间
					Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
					diffDays = QaUtil.getTimeDifference(currentTimeTs, curDeptIntoTime)[0]/24; //???????????//
					if(illStatus.equals(IllStatus.SERIOUSLY_ILL)){//病危
						calCount = diffDays;
					}else if(illStatus.equals(IllStatus.SERIOUSLY_ILL)){//病重
						calCount = diffDays/2;
					}/*else if(illStatus.equals(IllStatus.NORMAL_ILL)){//一般  根据龙华需求，不需判断一般
						calCount = diffDays/3;
					}*/
					for(QaAutoModel qaAutoModel: qaAutoMrModelList){
						//1=判断有无上级医师首次查房
						if(!qaAutoModel.getTypeCode().equals("MRM16.03") && qaAutoModel.getLogicSubmitTime()!=null){
							illRecordCount++;
							continue;
						}
						
					}
				}
				if(illRecordCount>=calCount){
					resultValue = true;
				}
			}
			
			return resultValue;
		}
	//=======================================
	//拆分校验项目
	public static QaValidateModel valideTime(Timestamp comparedTime,Timestamp compareTime, int deadHours ,QaValidateMsgModel msgModel){
		
		QaValidateModel qaValidateModel = new QaValidateModel();
		boolean resultValue = true;
		//系统当前时间
		Timestamp currentTimeTs = new Timestamp(System.currentTimeMillis());
		String  surplusTime = "";
		
		if(null == comparedTime){
			 resultValue = false;
			 qaValidateModel.setValidateType(QaValidateModel.vaNoParam);//参数为空
			 qaValidateModel.setValidateMessage(msgModel.getMsgName()+msgModel.getMsgAttr()[0]+"时间为空");
		}else if(null == compareTime){
			Date deadLineDate = QaUtil.dateIncreaseByHours(comparedTime,
					deadHours);
			Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
			qaValidateModel.setDeadDate(deadLineDateTs);
			//计算当前时间与截止时间的差，结果为H:M
			int[] diffDays = QaUtil.getTimeDifference(deadLineDateTs, currentTimeTs);
			surplusTime = QaUtil.formatSurplusTime(diffDays,"H:M");
			qaValidateModel.setSurplusTime(surplusTime);
			if(deadLineDateTs.compareTo(currentTimeTs)<1){
				resultValue = false;
				//qaValidateModel.setValidateType(QaValidateModel.vaFault);//校验结果为false
				qaValidateModel.setValidateType(QaValidateModel.vaMesgCorrect);//校验结果为true
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"XX超时");
			}else{
				resultValue = true;
				//qaValidateModel.setValidateType(QaValidateModel.vaCorrect);//校验结果为true
				qaValidateModel.setValidateType(QaValidateModel.vaMesgCorrect);//校验结果为true
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"截止时间为"+deadLineDateTs);
			}
		}else{
			Date deadLineDate = QaUtil.dateIncreaseByHours(comparedTime,
					deadHours);
			Timestamp deadLineDateTs = new Timestamp(deadLineDate.getTime());
			qaValidateModel.setDeadDate(deadLineDateTs);
			//计算当前时间与截止时间的差，结果为H:M
			int[] diffDays = QaUtil.getTimeDifference(deadLineDateTs,currentTimeTs);
			surplusTime = QaUtil.formatSurplusTime(diffDays,"H:M");
			qaValidateModel.setSurplusTime(surplusTime);
			if(deadLineDateTs.compareTo(compareTime)<1){//
				resultValue = false;
				qaValidateModel.setValidateType(QaValidateModel.vaFault);//校验结果为false
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"XX超时");
			}else{
				resultValue = true;
				qaValidateModel.setValidateType(QaValidateModel.vaCorrect);//校验结果为true
				qaValidateModel.setValidateMessage(msgModel.getMsgName()+"截止时间为"+deadLineDateTs);
			}
		}
		qaValidateModel.setValidateResult(resultValue);
		return qaValidateModel;
	}
	
	
}
