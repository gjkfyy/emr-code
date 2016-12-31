package pkuhit.iih.qa.qacustom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaFault;
import pkuhit.iih.qa.QaItem;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.dao.auto.QaDivideDao;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.iih.qa.qaauto.QaAutoDataProcessService;
import pkuhit.iih.qa.qaauto.QaTimeBoundService;
import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;

/**
 * 
 * @author wang_yanli
 *
 */
public class QaAutoServiceImpl implements QaAutoService {

	
	@Reference
	DictionaryService dictionaryService;
	
	@Reference
	QaScoreService qaScoreService;
	
	/*@Reference
	QaAutoDataProcessService qaAutoDataProcessService;*/
	
	@Autowired
	CusQaAutoDao cusQaAutoDao;
	
	@Autowired
	QaDivideDao qaDivideDao;
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	
	public QaAutoServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayResult<QaDivideModel> qaAutoTest(String enPk) throws Exception {/*

		//开始自动质控时，先删除已有的自动质控扣分项
		qaAutoDataProcessService.batchDeleteDivide(enPk);
	    
		//获取自动质控项目
		List<QaItem>  autoItemList = new ArrayList();
		autoItemList = qaAutoDataProcessService.qaItems("");//传入质控类型
		
		//质控缓存查询结果
		Map<String,List> QaArmMap = new HashMap();
		
		//准备校验所需的service
		Map validateServiceMap = qaAutoDataProcessService.qaValidateMap("");
		
		
		//查询患者病案，获取就诊信息
		MrAmr mrAmr = mrAmrDao.selectById(enPk);
		Amr amr = new Amr();
		BeanCopyUtil.entityToModel(amr, mrAmr, QaFault.OBJ_CD, dictionaryService);
		
		//对所有质控项进行质控
	    for(QaItem qaItem: autoItemList){
	    	
	    	List<Map<String, Object>> qaAutoMrList = null;
	    	String qaItemCd = qaItem.getQaItmCd();
	    	if(QaArmMap.containsKey(qaItemCd)){
	    		qaAutoMrList = QaArmMap.get(qaItemCd);
	    	}else{
	    		if(qaItem.getMemo().equals("selectQaMr")){
		    		qaAutoMrList = cusQaAutoDao.selectQaMr("1", "1", "1",enPk);
		    		QaArmMap.put(qaItemCd, qaAutoMrList);
		    	}
	    	}
	    	
			List<QaAutoModel> qaAutoMrModelList = new ArrayList();
			//查询结果转换为qaAutoModel的list
			qaAutoMrModelList = convertQaAutoMapToModel(qaAutoMrList);
			
			
			
			if(validateServiceMap.containsKey(qaItemCd)){
				QaTimeBoundService qaTimeBoundService = (QaTimeBoundService)validateServiceMap.get(qaItemCd);
				QaValidateModel qaValidateModel = qaTimeBoundService.autoQaItemForFault(qaAutoMrModelList,amr);
				if(null!=qaValidateModel && !qaValidateModel.isValidateResult()){
					qaAutoDataProcessService.saveQaDivide(qaItemCd,enPk);
				}
				
			}
	    	
	    }
	   
	    
	    ArrayResult<QaDivideModel> qaDivideArrayResult = null;
	    Map searchMap = new HashMap();
	    searchMap.put("encounterPk", enPk);
	    searchMap.put("workScreen", "12");
	    try {
			qaDivideArrayResult = qaScoreService.search(searchMap);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return qaDivideArrayResult;
	*/
		return null;
	}
	
	private List<QaAutoModel> convertQaAutoMapToModel(List<Map<String, Object>> qaAutoMrList){
		List<QaAutoModel> qaAutoMrModelList = new ArrayList();
		if(null != qaAutoMrList){
			if(qaAutoMrList.size()>0){
				Map<String, Object> mapQaAutoMr = null;
				QaAutoModel[] qaAutoModelArray = new QaAutoModel[qaAutoMrList.size()];
				for(int i=0;i<qaAutoMrList.size();i++){
					QaAutoModel qaAutoModel = new QaAutoModel();
					mapQaAutoMr = qaAutoMrList.get(i);
					BeanCopyUtil.mapToModel(qaAutoModel, mapQaAutoMr,dictionaryService);
					qaAutoMrModelList.add(qaAutoModel);
				}
			}
		}
		
		return qaAutoMrModelList;
	}

	@Override
	public ArrayResult<QaValidateModel> needSubmitMr(String enPk)throws Exception {/*
			
			ArrayResultBuilder<QaValidateModel> arrayBuilder = ArrayResultBuilder.newArrayResult(QaValidateModel.class);
			//查询患者病案，获取就诊信息
			MrAmr mrAmr = mrAmrDao.selectById(enPk);
			Amr amr = new Amr();
			BeanCopyUtil.entityToModel(amr, mrAmr, QaFault.OBJ_CD, dictionaryService);
			//获取自动质控项目
			List<QaItem>  autoItemList = new ArrayList();
			autoItemList = qaAutoDataProcessService.qaItems("1");//传入质控类型
			
			//质控缓存查询结果
			Map<String,List> QaArmMap = new HashMap();
			
			//准备校验所需的service
			Map validateServiceMap = qaAutoDataProcessService.qaValidateMap("");
			int arraySize = autoItemList != null ? autoItemList.size() : 0;
			//QaValidateModel[] qaValidateModelArray = new QaValidateModel[autoItemList.size()];
			List<QaValidateModel> qaValidateModelList = new ArrayList();
			//对所有质控项进行质控
		    for(int i=0; i< autoItemList.size(); i++){
		    	QaItem qaItem = autoItemList.get(i);
		    	List<Map<String, Object>> qaAutoMrList = null;
		    	String qaItemCd = qaItem.getQaItmCd();
		    	if(QaArmMap.containsKey(qaItemCd)){
		    		qaAutoMrList = QaArmMap.get(qaItemCd);
		    	}else{
		    		if(qaItem.getMemo().equals("selectQaMr")){
			    		qaAutoMrList = cusQaAutoDao.selectQaMr("1", "1", "1",enPk);
			    		QaArmMap.put(qaItemCd, qaAutoMrList);
			    	}
		    	}
		    	
				List<QaAutoModel> qaAutoMrModelList = new ArrayList();
				//查询结果转换为qaAutoModel的list
				qaAutoMrModelList = convertQaAutoMapToModel(qaAutoMrList);
				
				
				if(validateServiceMap.containsKey(qaItemCd)){
					QaValidateModel qaValidateModel = new QaValidateModel();
					QaTimeBoundService qaTimeBoundService = (QaTimeBoundService)validateServiceMap.get(qaItemCd);
					qaValidateModel = qaTimeBoundService.autoQaItemForMessage(qaAutoMrModelList,amr);
					if(null != qaValidateModel && !qaValidateModel.isValidateResult()){
						qaValidateModelList.add(qaValidateModel);
					}
					
				}
		    	
		    }
		    if(qaValidateModelList.size()!=0){
		    	QaValidateModel[] qaValidateModelArray = 	qaValidateModelList.toArray(new QaValidateModel[qaValidateModelList.size()]);
				arrayBuilder.withData(qaValidateModelArray);
			}
		return arrayBuilder.build();
	*/
	return null;
	}
	
	
	
	

}
