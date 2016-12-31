package szlh.iih.en;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.en.EncounterModel;
import pkuhit.iih.en.EncounterService;
import szlh.iih.en.dao.EncounterDao;
import szlh.iih.en.po.EncounterPo;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;

/**
 * @author guo_zhongbao
 *
 */
public class EncounterServiceImpl implements EncounterService {
	final static Logger logger = LoggerFactory.getLogger(EncounterServiceImpl.class);
	@Autowired
	EncounterDao encounterDao;
	   /**
  * 根据登陆科室和登陆人员查询患者就诊列表
  * @param curGrpCd 当前诊疗组
  * @param  curDeptCd 登录人员所在科室
  * @param   curMngDctId  登录人员code
  * @param enTpCd 就诊类型（住院/门诊）
  * @param 患者姓名paNm、床位号curBedCd、患者序号paId 
  * 就诊状态编码enStaCd 入院入科时间开始时间inpTimeStart 入院入科时间结束时间inpTimeStop 主诊断编码curMainDiCd    病案状态编码illStaCd
  * 当前页数	pageNum		  每页记录数pageSize	
  * @return 患者就诊列表
  * 测试地址：http://localhost:8081/encounterList?curDeptCd=0300&curMngDctId=003022&enTpCd=onp&paId=0000181054&enStaCd=compltd&xmode=debug
  */
	/* (non-Javadoc)
	 * @see pkuhit.iih.en.EncounterService#getEncounterListByCondition(java.util.Map)
	 */
	@Override
	public ArrayResult<EncounterModel> getEncounterListByCondition(Map map) {
		// 当前诊疗组
		String curGrpCd = getStringValueFromMap(map,"curGrpCd") ;
		//登录科室code
		String curDeptCd = getStringValueFromMap(map,"curDeptCd") ;
		//登录人员code
		String curMngDctId = getStringValueFromMap(map,"curMngDctId") ;
		//就诊类型（住院/门诊）
		String enTpCd = getStringValueFromMap(map,"enTpCd") ;
		//患者姓名,模糊查询 like
		String paNm = getStringValueFromMap(map,"paNm") ;
		//床位号
		String curBedCd = getStringValueFromMap(map,"curBedCd") ;
		//患者序号
		String paId = getStringValueFromMap(map,"paId") ;
		//就诊状态编码
		String enStaCd = getStringValueFromMap(map,"enStaCd") ;
		//主诊断编码
		String curMainDiCd = getStringValueFromMap(map,"curMainDiCd") ;
		//入院入科时间开始时间
		Timestamp inpTimeStart = getTimestampValueFromMap(map,"inpTimeStart") ;
		//入院入科时间结束时间
		Timestamp inpTimeStop = getTimestampValueFromMap(map,"inpTimeStop") ;
		//病情状态编码
		String illStaCd = getStringValueFromMap(map,"illStaCd") ;
		//手术标志
		String suF = getStringValueFromMap(map,"suF") ;
		String pageNum = null;
		String pageSize = null;
		if(map.containsKey("pageNum") && map.containsKey("pageSize")){
			pageNum = (String)map.get("pageNum");
			pageSize = (String)map.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();			
		List<EncounterPo> poList = null;//this.encounterDao.getEncounterList(curGrpCd,curDeptCd,curMngDctId,enTpCd,paNm,curBedCd,paId,enStaCd,curMainDiCd,inpTimeStart,inpTimeStop,illStaCd, suF,options);
		long count = options.getCount();
		int total = Long.valueOf(count).intValue();
		EncounterModel[] voArray = null ;
		ArrayResultBuilder<EncounterModel> builder = ArrayResultBuilder.newArrayResult(EncounterModel.class);
		if(null != poList){
			 voArray = new EncounterModel[poList.size()];
			 int i = 0;
			 for(EncounterPo po : poList){
				 EncounterModel vo = new EncounterModel();
				 BeanUtils.copyProperties( po,vo);
				 voArray[i]= vo;
				 i++;
			 }
			builder.withData(voArray);
		}
		ArrayResult<EncounterModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
		
	}
	/**
	 * 根据就诊序号，就诊详情
	 * @param enSn 就诊序号
	 * @return 就诊对象详情
	 * http://localhost:8081/EncounterModel/838535?xmode=debug
	 * */
	/* (non-Javadoc)
	 * @see pkuhit.iih.en.EncounterService#getEncounterModel(java.lang.String)
	 */
	@Override
	public SingleResult<EncounterModel> getEncounterDetail(String enPk) {
		EncounterModel vo = new  EncounterModel();
		EncounterPo po =null;// encounterDao.getEncounterDetail(enPk);
		SingleResultBuilder<EncounterModel> builder = SingleResultBuilder.newSingleResult(EncounterModel.class);
		if(null != po){
			BeanUtils.copyProperties( po,vo);
			builder.withData(vo);
		}
		return builder.build();
	}
	
	public String getStringValueFromMap(Map map,String key){
		String value = null ;
		if(map.containsKey(key)){
			value = (String)map.get(key);
			if(StringUtils.isBlank(value)){
				value = null ;
			}
		}
		return value;
	}
	public Timestamp getTimestampValueFromMap(Map map,String key){
		Timestamp value = null ;
		if(map.containsKey(key)){
			value = (Timestamp)map.get(key);
		}
		return value;
	}
	@Override
	public EncounterModel getLastEffectiveEncounterByEncounterSn(String encounterSn) {
		logger.debug("南京鼓楼版本使用该方法，获取上一次有效的就诊...");
		return null;
	}
	@Override
	public Boolean getHistoryEncounterByExcuteProcedure(String patientId) {
		logger.debug("南京鼓楼版本使用该方法，执行存储过程，将历史就诊数据复制到7日就诊表中...");
		return true;
	}
}
