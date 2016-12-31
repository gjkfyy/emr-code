package pkuhit.iih.mr.md.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.md.DataElememtDimenService;
import pkuhit.iih.mr.md.MetaElement;
import pkuhit.iih.mr.md.MetaElementSaveModel;
import pkuhit.iih.mr.md.MetaElementValue;
import pkuhit.iih.mr.md.MrTemplateStatus;
import pkuhit.iih.mr.md.dao.auto.MdMetaElementDao;
import pkuhit.iih.mr.md.dao.auto.MdMetaElementValueDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElement;
import pkuhit.iih.mr.md.dao.auto.entity.MdMetaElementValue;
import pkuhit.iih.mr.md.dao.custom.CusMdMetaElementDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMetaElementValueDao;
import pkuhit.iih.mr.tpl.ArrayInputModel;
import pkuhit.iih.mr.tpl.BatchOperationResult;
import pkuhit.iih.mr.tpl.FailItem;
import pkuhit.iih.qa.util.DateUtil;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.util.UUIDGenerator;

/**
 * @author guo_zhongbao
 * 数据元素管理-链接元素-维度管理
 */
public class DataElememtDimenServiceImpl implements DataElememtDimenService {
	
	private Logger log = LoggerFactory.getLogger(DataElememtDimenServiceImpl.class);
	
	@Autowired
	CusMdMetaElementDao cusMdMetaElementDao;  //读取元素 主表
	@Autowired
	MdMetaElementDao autoMdMetaElementDao;
	
	@Autowired
	CusMdMetaElementValueDao cusMdMetaElementValueDao; //读取元素 从表，码表
	
	@Autowired
	MdMetaElementValueDao autoMdMetaElementValueDao;
	final String NULL_STRING = "null";
	
	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#getDataElememtDimenCodeList(java.util.Map)
	 */
	@Override
	public ArrayResult<MetaElement> getDataElememtDimenCodeList(Map conditionMap) {
		String nameOrSpellNo = null ;
		if (verifyExistKey(conditionMap, "conditionStr")) {
			nameOrSpellNo = (String) conditionMap.get("conditionStr");
			nameOrSpellNo = nameOrSpellNo.toUpperCase();
		}
		String pageNum = null;
		String pageSize = null;
		if (conditionMap.containsKey("pageNum")&& conditionMap.containsKey("pageSize")) {
			pageNum = (String) conditionMap.get("pageNum");
			pageSize = (String) conditionMap.get("pageSize");
		}
		if (null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "10";
		}
		ArrayResult<MetaElement> result = null;
		ArrayResultBuilder<MetaElement> builder = ArrayResultBuilder.newArrayResult(MetaElement.class);
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1)* Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		List<MdMetaElement> list = cusMdMetaElementDao.selectByMetaElementNmOrSpellNo(nameOrSpellNo,options);
		List<MetaElement> list2=new ArrayList<MetaElement>();
		MetaElement metaElement = null;
		for(MdMetaElement mdMetaElement:list){
			metaElement=new MetaElement();
//			BeanCopyUtil.entityToModel(metaElement, mdMetaElement, "", dictionaryService);
			metaElement.setDataElementCd(mdMetaElement.getDataElementCd());
			metaElement.setDataElementNm(mdMetaElement.getDataElementNm());
			metaElement.setMemo(mdMetaElement.getMemo());
			list2.add(metaElement);
		}
		if (list2.size() > 0) {
			builder.withData(list2.toArray(new MetaElement[0]));
		}
		result = builder.build();
		result.setTotal(Long.valueOf(options.getCount()).intValue());
		return result;
	}

	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#addDataElememtDimenCode(pkuhit.iih.mr.md.MetaElement)
	 */
	@Override
	public SingleResult<MetaElement> createDataElememtDimenCode(MetaElement model) {
		// TODO Auto-generated method stub
		String name = model.getDataElementNm()  ;
		MdMetaElement entity = new MdMetaElement();
		//获取最新的主键
		String newId = model.getDataElementCd()  ; ;
		log.debug("new id is "+ newId);
		entity.setDataElementCd(newId);
		entity.setDataElementNm(name);
		autoMdMetaElementDao.insert(entity);
		model.setDataElementCd(newId);
		SingleResultBuilder<MetaElement> builder = SingleResultBuilder.newSingleResult(MetaElement.class);
		builder.withData(model);
		SingleResult<MetaElement> rs = builder.build();
		return rs;
	}
	@Override
	public SingleResult<MetaElement> updateDataElememtDimenCode(String id,
			MetaElement model) {
		MdMetaElement entity = autoMdMetaElementDao.selectById(id);
		entity.setDataElementNm(model.getDataElementNm());
		entity.setMemo(model.getDataElementNm());
		autoMdMetaElementDao.updateExcludeNull(entity);
		SingleResultBuilder<MetaElement> builder = SingleResultBuilder.newSingleResult(MetaElement.class);
		builder.withData(model);
		SingleResult<MetaElement> rs = builder.build();
		return rs;
	}
	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#deleteDataElememtDimenCodeList(pkuhit.iih.mr.md.MetaElement)
	 */
	@Override
	public SingleResult<BatchOperationResult> deleteDataElememtDimenCodeList(
			ArrayInputModel delModel) {
		String[] ids = delModel.getIds();
		SingleResult<BatchOperationResult> result = new SingleResult<BatchOperationResult>();
		BatchOperationResult operationMessge = new BatchOperationResult();
		if (null == ids || ids.length == 0) {
			operationMessge.setSuccess("fail");
			operationMessge.setMessage("传入参数为空");
			result.setData(operationMessge);
			return result;
		}
		// 初始化操作结果对象
		int successCount = 0;
		int failCount = 0;
		FailItem[] failItemsTemp = new FailItem[ids.length];
		// 循环遍历，对每个id进行处理
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			if(StringUtils.isBlank(id)){
				continue;
			}
			List<MdMetaElementValue> valueList = cusMdMetaElementValueDao.selectByDataElementCd(id);
			autoMdMetaElementValueDao.batchDelete(valueList);
			// 获取数据库持久化对象
			 MdMetaElement entity = autoMdMetaElementDao.selectById(id);
			 autoMdMetaElementDao.delete(entity);
				// 进行正常操作
				successCount++;
		}
		FailItem[] failItems = null;
		if (failCount > 0) {
			failItems = Arrays.copyOfRange(failItemsTemp, 0, failCount - 1);
		}
		operationMessge.setFailCount(failCount);
		operationMessge.setFailItems(failItems);
		operationMessge.setSuccess("true");
		operationMessge.setSuccessCount(successCount);
		operationMessge.setMessage("操作结果：成功_" + successCount + "_个，失败_"
				+ failCount + "个");
		result.setData(operationMessge);
		return result;

	}

	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#getDataElememtDimenValueList(java.util.Map)
	 */
	@Override
	public ArrayResult<MetaElementValue> getDataElememtDimenValueList(String dataElementCd) {

		ArrayResult<MetaElementValue> result = null;
		ArrayResultBuilder<MetaElementValue> builder = ArrayResultBuilder.newArrayResult(MetaElementValue.class);
		List<MdMetaElementValue> list = cusMdMetaElementValueDao.selectByDataElementCd(dataElementCd);
		List<MetaElementValue> list2=new ArrayList<MetaElementValue>();
		for(MdMetaElementValue mdMetaElement:list){
			MetaElementValue metaElementValue=new MetaElementValue();
		//	BeanCopyUtil.entityToModel(metaElementValue, mdMetaElement, "", dictionaryService);
			metaElementValue.setDataElementValueCd(mdMetaElement.getDataElementValueCd());
			metaElementValue.setValueCode(mdMetaElement.getValueCode());
			metaElementValue.setDataElementCd(mdMetaElement.getDataElementCd());
			metaElementValue.setValueDisplay(mdMetaElement.getValueDisplay());
			metaElementValue.setMemo(mdMetaElement.getMemo());
			list2.add(metaElementValue);
		}
		if (list2.size() > 0) {
			builder.withData(list2.toArray(new MetaElementValue[0]));
		}
		result = builder.build();
		result.setTotal(list2.size());
		return result;
	}

	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#addDataElememtDimenValue(pkuhit.iih.mr.md.MetaElementValue)
	 */
	@Override
	public SingleResult<MetaElementValue> createDataElememtDimenValue(
			MetaElementSaveModel model) {
		String pk = getNewValueCode(null);
		String fk = model.getDataElementCd();
		String code = model.getValueCode();
		String name = model.getValueDisplay()  ;
		String memo = model.getMemo();
		MdMetaElementValue entity = new MdMetaElementValue();
		//获取最新的主键
		entity.setDataElementValueCd(pk);
		entity.setDataElementCd(fk);
		entity.setValueCode(code);
		entity.setValueDisplay(name);
		entity.setMemo(memo);
		autoMdMetaElementValueDao.insert(entity);
		model.setDataElementCd(pk);
		SingleResultBuilder<MetaElementValue> builder = SingleResultBuilder.newSingleResult(MetaElementValue.class);
		MetaElementValue rsModel = new MetaElementValue();
		rsModel.setMemo(model.getMemo());
		rsModel.setDataElementValueCd(pk);
		rsModel.setDataElementCd(fk);
		rsModel.setValueCode(code);
		rsModel.setValueDisplay(name);
		builder.withData(model);
		SingleResult<MetaElementValue> rs = builder.build();
		return rs;
		
	}
	
	@Override
	public SingleResult<MetaElementValue> updateDataElememtDimenValue(
			String id, MetaElementSaveModel model) {
		MdMetaElementValue entity = autoMdMetaElementValueDao.selectById(id);
		entity.setValueDisplay(model.getValueDisplay());
		entity.setMemo(model.getMemo());
		autoMdMetaElementValueDao.updateExcludeNull(entity);
		SingleResultBuilder<MetaElementValue> builder = SingleResultBuilder.newSingleResult(MetaElementValue.class);
		MetaElementValue metaElementValue=new MetaElementValue();
		//	BeanCopyUtil.entityToModel(metaElementValue, mdMetaElement, "", dictionaryService);
			metaElementValue.setDataElementValueCd(id);
			metaElementValue.setValueCode(model.getValueCode());
			metaElementValue.setDataElementCd(model.getDataElementCd());
			metaElementValue.setValueDisplay(model.getValueDisplay());
			metaElementValue.setMemo(model.getMemo());
		builder.withData(metaElementValue);
		SingleResult<MetaElementValue> rs = builder.build();
		return rs;
	}
	/* (non-Javadoc)
	 * @see pkuhit.md.DataElememtDimenService#deleteDataElememtDimenValueList(pkuhit.iih.mr.md.MetaElementValue)
	 */
	@Override
	public SingleResult<BatchOperationResult> deleteDataElememtDimenValueList(
			ArrayInputModel delModel) {

		String[] ids = delModel.getIds();
		SingleResult<BatchOperationResult> result = new SingleResult<BatchOperationResult>();
		BatchOperationResult operationMessge = new BatchOperationResult();
		if (null == ids || ids.length == 0) {
			operationMessge.setSuccess("fail");
			operationMessge.setMessage("传入参数为空");
			result.setData(operationMessge);
			return result;
		}
		// 初始化操作结果对象
		int successCount = 0;
		int failCount = 0;
		FailItem[] failItemsTemp = new FailItem[ids.length];
		// 循环遍历，对每个id进行处理
		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			if(StringUtils.isBlank(id)){
				continue;
			}
			// 获取数据库持久化对象
			 MdMetaElementValue entity = autoMdMetaElementValueDao.selectById(id);
			 autoMdMetaElementValueDao.delete(entity);
				// 进行正常操作
				successCount++;
		}
		FailItem[] failItems = null;
		if (failCount > 0) {
			failItems = Arrays.copyOfRange(failItemsTemp, 0, failCount - 1);
		}
		operationMessge.setFailCount(failCount);
		operationMessge.setFailItems(failItems);
		operationMessge.setSuccess("true");
		operationMessge.setSuccessCount(successCount);
		operationMessge.setMessage("操作结果：成功_" + successCount + "_个，失败_"
				+ failCount + "个");
		result.setData(operationMessge);
		return result;

	
	}
	private boolean verifyExistKey(Map map, String key) {
		if (map.containsKey(key) && null != map.get(key)
				&& ! (NULL_STRING.equalsIgnoreCase((String) map.get(key)) || "".equalsIgnoreCase((String) map.get(key))) ) {
			return true;
		}
		return false;
	}



	@Override
	public String getNewCode(Map map) {
		String rs = null; 
		rs =  cusMdMetaElementDao.getNewSn();
		Long longrs  = 0L ;
		if(StringUtils.isBlank(rs)){
			
		}else{
			try{
				longrs = Long.valueOf(rs)  ;
			}catch(java.lang.NumberFormatException e){
				//e.printStackTrace();
			}
		}
		rs = String.valueOf(longrs + 1) ;
		return rs;
	}

	@Override
	public String getNewValueCode(Map map) {
		String rs = null; 
		rs =  cusMdMetaElementValueDao.getNewSn();
		Long longrs  = 0L ;
		if(StringUtils.isBlank(rs)){
			
		}else{
			try{
				longrs = Long.valueOf(rs)  ;
			}catch(java.lang.NumberFormatException e){
				//e.printStackTrace();
			}
		}
		rs = String.valueOf(longrs + 1) ;
		return rs;
	}

	@Override
	public SingleResult<String> getDataElememtDimenValueCodeFromDB(
			String dataElementCd) {
		//从码表中获取该dataElementCd的码表中最大的序号
		String newDimenValueCode =  cusMdMetaElementValueDao.getMaxDimenValueCode(dataElementCd);
		Long longrs  = 0L ;
		if(StringUtils.isBlank(newDimenValueCode)){
			
		}else{
			try{
				longrs = Long.valueOf(newDimenValueCode)  ;
			}catch(java.lang.NumberFormatException e){
				//e.printStackTrace();
			}
		}
		newDimenValueCode = "0"+String.valueOf(longrs + 1) ;
		newDimenValueCode.substring(newDimenValueCode.length()-2);
		SingleResult<String> result = new SingleResult<String>();
		result.setData(newDimenValueCode); ;
		return result;
	}
	
	
}
