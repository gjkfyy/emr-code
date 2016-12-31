package iih.dr.service.impl;

import iih.dr.dao.auto.IemrRetrievalDao;
import iih.dr.dao.auto.entity.IemrRetrieval;
import iih.dr.dao.custom.CusRetrievalDao;
import iih.dr.model.IemrRetrievalModel;
import iih.dr.service.intf.DataRetrievalService;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.md.DictionaryService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.util.UUIDGenerator;

/**
 * DataRetrievalServiceImpl
 * 
 * @author cheng_feng
 * @version 0.0.0
 */
public class DataRetrievalServiceImpl implements DataRetrievalService {
	
	final String NULL_STRING = "null";
	final static Logger logger = LoggerFactory.getLogger(DataRetrievalServiceImpl.class);
	
	@Autowired
	private IemrRetrievalDao retrievalDao; 
	
	@Autowired
	private CusRetrievalDao cusRetrievalDao; 

	@Reference
	DictionaryService dictionaryService;
	
	
	@Override
	public ArrayResult<IemrRetrievalModel> createRetrieval(IemrRetrievalModel irm) throws Throwable {
		/*Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		Timestamp d = new Timestamp(System.currentTimeMillis()); */
		try{
			Timestamp tm = new Timestamp(System.currentTimeMillis());
			String retrievalCd = UUIDGenerator.getUUID();
			irm.setRetrievalCd(retrievalCd);
			IemrRetrieval retrieval = new IemrRetrieval();
			BeanCopyUtil.modelToEntity(retrieval, irm);
			retrievalDao.insert(retrieval);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		Map param = new HashMap();
		ArrayResult<IemrRetrievalModel> retrievalArrayResult = retrievalListBrowses(param);
		return retrievalArrayResult;
	}
	
	@Override
	public SingleResult<IemrRetrieval> deleteRetrieval(String id) throws Throwable {
		IemrRetrieval retrieval= retrievalDao.selectById(id);
		retrieval.setDelF((short)1);
		retrievalDao.markDelete(retrieval);
		return SingleResultBuilder.newSingleResult(IemrRetrieval.class).build();
	}
	
	@Override
	public SingleResult<IemrRetrieval> editRetrieval(String id,IemrRetrievalModel value) throws Throwable {
		IemrRetrieval retrieval= retrievalDao.selectById(id);
		if(value.getRetrievalNm() != null){
			retrieval.setRetrievalNm(value.getRetrievalNm());
		}
		if(value.getDeptCd() != null){
			retrieval.setDeptCd(value.getDeptCd());
		}
		if(value.getResponsibleCd() != null){
			retrieval.setResponsibleCd(value.getResponsibleCd());
		}
		if(value.getRetrievalKey() != null){
			retrieval.setRetrievalKey(value.getRetrievalKey());
		}
		if(value.getMemo() != null){
			retrieval.setMemo(value.getMemo());
		}
		retrievalDao.updateExcludeNull(retrieval);
		return SingleResultBuilder.newSingleResult(IemrRetrieval.class).build();
	}
	
	@Override
	public ArrayResult<IemrRetrievalModel> retrievalListBrowses(Map map) {
		String retrievalCd = getValueFromMap(map,"retrievalCd","检索方案编码");
		String retrievalNm = getValueFromMap(map,"retrievalNm","检索方案名称");
		if(retrievalNm!=null){
			retrievalNm = retrievalNm.toUpperCase();
		}
		String ownTpCd = getValueFromMap(map,"ownTpCd","方案所属");
		String responsibleCd = getValueFromMap(map,"responsibleCd","负责人");
		String retrievalKey = getValueFromMap(map,"retrievalKey","检索关键字");
		if(retrievalKey!=null){
			retrievalKey = retrievalKey.toUpperCase();
		}
		String deptCd = getValueFromMap(map,"deptCd","检索科室");
		ArrayResultBuilder<IemrRetrievalModel> builder = ArrayResultBuilder.newArrayResult(IemrRetrievalModel.class);
		int total = 0;
		List<Map<String, Object>> retrievalList = cusRetrievalDao.selectRetrievalByCondition(retrievalCd, retrievalNm, ownTpCd, responsibleCd, retrievalKey, deptCd, null);
		Map<String, Object> mapRetrieval = null;
		if(null!=retrievalList){
			total = retrievalList.size() ;
			IemrRetrievalModel[] retrievalArr = new IemrRetrievalModel[retrievalList.size()];
			if(retrievalList.size()>0){
				for(int i = 0; i < retrievalList.size(); i++ ){
					mapRetrieval = retrievalList.get(i);
					IemrRetrievalModel retrievalModel = new IemrRetrievalModel();
					BeanCopyUtil.mapToModel(retrievalModel, mapRetrieval,dictionaryService);
					retrievalArr[i] = retrievalModel;
				}
				if(retrievalArr!=null){
					builder.withData(retrievalArr);
				}
			}
		}
		ArrayResult<IemrRetrievalModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	//判断map中是否存在key
	private boolean verifyExistKey(Map map, String key) {
		if (map.containsKey(key) && null != map.get(key)) {
			String value = (String) map.get(key) ;
			if(!NULL_STRING.equalsIgnoreCase(value) && value.length() > 0)
			return true;
		}
		return false;
	}
	
	private String getValueFromMap(Map map,String key,String name){
		String value = null ;
		if(verifyExistKey(map,key)){
			Object object = map.get(key);
			value = object.toString();
			if(StringUtils.isBlank(value)){
				logger.debug(name+"为空");
				value = null ;
			}
			logger.debug(name+":"+ value);
		}else{
			logger.debug(name+"为空");
		}
		return value;
	}
	
}
