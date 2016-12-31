package pkuhit.iih.qa.qamrwrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.qa.CusQaAutoItmConfig;
import pkuhit.iih.qa.QaAutoModel;
import pkuhit.iih.qa.QaDivideModel;
import pkuhit.iih.qa.QaValidateModel;
import pkuhit.iih.qa.dao.qacustom.CusQaAutoDao;
import pkuhit.iih.qa.qaauto.QaItemService;
import pkuhit.iih.qa.qaauto.validator.baseValidator.BaseValidator;
import pkuhit.iih.qa.qamrwite.QaMrTypeService;
import pkuhit.md.DictionaryService;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.xap.util.BeanCopyUtil;
import xap.ru.engin.validate.ValidateResult;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.servlet.mvc.annotation.RequestParam;


/**
 * 
 * @author wang_yanli
 * 病历文书类型质控：当创建文书时，有其他文书必须书写问前提，故校验前置条件是否满足
 *
 */
public class QaMrTypeServiceImpl implements QaMrTypeService {

	
	@Reference
	DictionaryService dictionaryService;
	
	
	@Autowired
	CusQaAutoDao cusQaAutoDao;
	
	@Reference
	QaItemService qaItemService;
	
	public QaMrTypeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ValidateResult<QaValidateModel> haveMrDocValidate(@RequestParam Map map) throws Throwable {
		
		ValidateResult<QaValidateModel> validateResult = new ValidateResult<QaValidateModel>();
		
		//校验结果保存到list
		List<QaValidateModel> qaValidateModelList = new ArrayList<QaValidateModel>();
				
		/*参数获取*/
		String qaMrType = null ;
		String qaItmTpCd = null ;
		String enPk = null ;		
		if(map.containsKey("qaMrType")){
			qaMrType = map.get("qaMrType").toString();
		}	
		if(map.containsKey("qaItmTpCd")){
			qaItmTpCd = map.get("qaItmTpCd").toString();
		}	
		if(map.containsKey("enPk")){
			enPk = map.get("enPk").toString();
		}	
		
		/*获取该文书的校验规则，可能是多个*/
		Map searchMap = new HashMap();
		searchMap.put("qaItmCd", qaMrType);
		searchMap.put("qaItmTpCd", qaItmTpCd);//QAM06.03 依赖质控
		ArrayResult<CusQaAutoItmConfig> qaAutoItmConfigArrayResult =  qaItemService.searchQaAutoItm(searchMap);
		
		
		CusQaAutoItmConfig[] dataList = qaAutoItmConfigArrayResult.getDataList();
		//如果autoItemConfigMap为null则不进行校验
		if(null == dataList || dataList.length == 0){
			ArrayResultBuilder<QaDivideModel> builder = ArrayResultBuilder
						.newArrayResult(QaDivideModel.class);
			return validateResult;
		}
		//循环质控项，进行遍历校验==
		for(CusQaAutoItmConfig configModel:dataList){
			if(null == configModel.getQaItmCd()){
				continue;
			}else{
				QaValidateModel qaValidateModel = new QaValidateModel();
				String mrOpType = configModel.getMrOpType();
				String mrStaCd = configModel.getMrOpType();
				if(mrOpType!=null && mrOpType.equals("03")){
//					mrStaCd = MrStatus.CREATED;//如果是新建的，则不需要该参数
				}else if(mrOpType!=null && mrOpType.equals("01")){
					mrStaCd = MrStatus.CREATED;//如果是提交的，则不等于新建的状态
				}
				String mrTypes = configModel.getMrTypes();
				String[] mrTypeArray = mrTypes.split(",");
				int mrTypeLength = mrTypeArray != null ? mrTypeArray.length :0;
				List<String> mrTypesList = new ArrayList();
				for (int i=0;i<mrTypeArray.length;i++){
					mrTypesList.add(mrTypeArray[i]);
				}
				
				List<Map<String, Object>> qaAutoMrList = cusQaAutoDao.selectQaMrByCondition(enPk,mrTypesList,mrStaCd);
				List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
				// 查询结果转换为qaAutoModel的list
				qaAutoMrModelList = convertQaAutoMapToModel(qaAutoMrList);
				
				if(qaAutoMrList != null && qaAutoMrList.size()== mrTypeLength){
					
					qaValidateModel.setValidateResult(true);
					
				}else{
				
					qaValidateModel = BaseValidator.validateNotHaveMrType(qaAutoMrModelList, mrTypesList, null);
					if(!qaValidateModel.isValidateResult()){
						String msg = "请先完成";
						List<String> mrTypeCodeList = qaValidateModel.getTempResultMap().get("mrTypeCodeList");
						if(mrTypeCodeList != null && mrTypeCodeList.size()>0){
							for(String mrType:mrTypeCodeList){
								 SimpleItem[] item = dictionaryService.getSimpleItems("MRM16",
										 mrType);
								 msg = msg+"【"+item[0].getText()+"】";
							}
						}
						msg = msg + "文书";
						qaValidateModel.setValidateMessage(msg);
					}
				}
				qaValidateModelList.add(qaValidateModel);
			}
		}
		
		
		
		validateResult.setKey("haveMrDocValidate");
		validateResult.setResultList(qaValidateModelList);
		return validateResult;
	}
	

	private List<QaAutoModel> convertQaAutoMapToModel(
			List<Map<String, Object>> qaAutoMrList) {
		List<QaAutoModel> qaAutoMrModelList = new ArrayList<QaAutoModel>();
		if (null != qaAutoMrList) {
			if (qaAutoMrList.size() > 0) {
				Map<String, Object> mapQaAutoMr = null;
				for (int i = 0; i < qaAutoMrList.size(); i++) {
					QaAutoModel qaAutoModel = new QaAutoModel();
					mapQaAutoMr = qaAutoMrList.get(i);
					BeanCopyUtil.mapToModel(qaAutoModel, mapQaAutoMr,
							dictionaryService);
					qaAutoMrModelList.add(qaAutoModel);
				}
			}
		}
		return qaAutoMrModelList;
	}

}
