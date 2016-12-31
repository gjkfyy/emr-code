package pkuhit.iih.qa.apply;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import pkuhit.iih.mr.dao.auto.MrAmrDao;
import pkuhit.iih.mr.dao.auto.entity.MrAmr;
import pkuhit.iih.qa.CusQaAutoFltModel;
import pkuhit.iih.qa.MrApplyModel;
import pkuhit.iih.qa.dao.auto.MrApplyDao;
import pkuhit.iih.qa.dao.auto.entity.MrApply;
import pkuhit.iih.qa.dao.custom.CusMrApplyDao;
import pkuhit.md.DictionaryService;
import pkuhit.xap.ac.Session;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.servlet.mvc.annotation.ModelAttribute;
import xap.util.UUIDGenerator;

/**
 * MrApplyServiceImpl
 * @author cheng_feng
 * @version 0.0.0
 */
public class MrApplyServiceImpl implements MrApplyService {
	
	final String NULL_STRING = "null";
	final static Logger logger = LoggerFactory.getLogger(MrApplyServiceImpl.class);
	
	@Autowired
	MrApplyDao mrApplyDao;
	
	@Autowired
	MrAmrDao mrAmrDao;
	
	@Autowired
	CusMrApplyDao cusMrApplyDao;
	
	@Reference
	DictionaryService dictionaryService;
	
	@Override
	public ArrayResult<MrApplyModel> getMrApplyList(Map<String, String> condition) {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		String roleFlag = getValueFromMap(condition,"roleFlag","点击菜单的角色类型");
		String applyTypeCd = getValueFromMap(condition,"applyType","申请类型");
		if("2".equals(roleFlag)){//医务部科室查询所有的申请 ~  roleFlag=2表示为医务科的角色点击的菜单~
			userId = ""; //sql里进行判断，userId为空则不作为查询条件
		}
		String enPk = getValueFromMap(condition,"enPk","就诊序号");
		String dctCd = getValueFromMap(condition,"dctNm","医生姓名");
		String curDeptCd = getValueFromMap(condition,"curDeptNm","病人所在科室");
		String applyStatus = getValueFromMap(condition,"applyStatus","申请状态");
		String timeStartStr = getValueFromMap(condition,"timeStart","申请时间start");
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-ddhh:mm:ss");
		String timeStart = "";
		if(StringUtils.isNotEmpty(timeStartStr)){
			timeStart = f.format(new Date(Long.parseLong(timeStartStr)));
			timeStart = timeStart.substring(0, 10) + " 00:00:00";
		}
		String timeEndStr = getValueFromMap(condition,"timeEnd","申请时间end");
		String timeEnd = "";
		if(StringUtils.isNotEmpty(timeEndStr)){
			timeEnd = f.format(new Date(Long.parseLong(timeEndStr)));
			timeEnd = timeEnd.substring(0, 10) +" 23:59:59";
		}
		ArrayResultBuilder<MrApplyModel> builder = ArrayResultBuilder.newArrayResult(MrApplyModel.class);
		String pageNum = null;
		String pageSize = null;
		if(condition.containsKey("pageNum") && condition.containsKey("pageSize")){
			pageNum = (String)condition.get("pageNum");
			pageSize = (String)condition.get("pageSize");
		}
		if(null == pageNum || !StringUtils.isNumeric(pageNum)   || null == pageSize || !StringUtils.isNumeric(pageSize)  )
		{
			pageNum= "1";
			pageSize = "25";
		}
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();		
		List<Map<String, Object>> mrApplyList = cusMrApplyDao.selectApplyByEnPk(applyTypeCd, userId, enPk, dctCd, curDeptCd, applyStatus, timeStart, timeEnd, options);//(conditionStr==null?null:conditionStr.trim().toUpperCase(), );
		Map<String, Object> mapMrApply = null;
		int total = 0;
		if(null!=mrApplyList){
			long count = options.getCount();
			total = Long.valueOf(count).intValue();
			MrApplyModel[] mrApplyArr = new MrApplyModel[mrApplyList.size()];
			if(mrApplyList.size()>0){
				for(int i = 0; i < mrApplyList.size(); i++ ){
					mapMrApply = mrApplyList.get(i);
					MrApplyModel mrApplyModel = new MrApplyModel();
//					BeanCopyUtil.mapToModel(mrApplyModel, mapMrApply);
					mrApplyModel = mrApplyMapToModel(mapMrApply);
					mrApplyModel.setIsMedicalWorkDept("2".equals(roleFlag)?"0":"1");//0-医务科，1-非医务科
					mrApplyArr[i] = mrApplyModel;
				}
				if(mrApplyArr!=null){
					builder.withData(mrApplyArr);
				}
			}
		}
		ArrayResult<MrApplyModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	
	@Override
	public SingleResult<MrApplyModel> getMrApplyByCd(@PathVariable("id") String id) throws Throwable{
		Map<String, Object> mrApplyMap=  cusMrApplyDao.selectApplyInfoById(id);
		MrApplyModel mrApplyModel = new MrApplyModel();
//		BeanCopyUtil.mapToModel(mrApplyModel, mrApplyMap);
		mrApplyModel = mrApplyMapToModel(mrApplyMap);
		SingleResultBuilder<MrApplyModel> singleResult = SingleResultBuilder.newSingleResult(MrApplyModel.class);
		singleResult.withData(mrApplyModel);
		return singleResult.build();
	}
	
	@Override
	public SingleResult<MrApplyModel> create(CusQaAutoFltModel qaAutoFlt) throws Throwable {
		if(null!=qaAutoFlt){
			try{
				if("QAM06.02".equals(qaAutoFlt.getQaItmTpCd())){
					String applyCd = UUIDGenerator.getUUID();
					MrApply mrApply = new MrApply();
					mrApply.setApplyCd(applyCd);
					mrApply.setQaAutoFltPk(qaAutoFlt.getQaAutoFltPk());
					String enPk = qaAutoFlt.getEncounterSn();
					mrApply.setEnPk(enPk);
					mrApply.setMrTpCd(qaAutoFlt.getMrTypes());
					mrApply.setQaItmCd(qaAutoFlt.getQaItmCd());
					mrApply.setApplyTypeCd("MRM25.01");
					mrApply.setApplyStatus("MRM24.01");
					String applyDctCd = cusMrApplyDao.selectApplyDocCdByEnpk(enPk);
					mrApply.setApplyDctCd(applyDctCd);//应该由谁来申请
					mrApplyDao.insert(mrApply);
				}
			}catch(Exception e){
				throw new RuntimeException(e);
			}
		}
		return SingleResultBuilder.newSingleResult(MrApplyModel.class).build();
	}
	
	@Override
	public ArrayResult<MrApplyModel> create(MrApplyModel mrApplyModel) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		if(null!=mrApplyModel){
			String applyCd = UUIDGenerator.getUUID();
			MrApply mrApply = new MrApply();
			mrApply.setApplyCd(applyCd);
			mrApply.setEnPk(mrApplyModel.getEnPk());
			mrApply.setApplyTypeCd("MRM25.02");
			mrApply.setApplyStatus("MRM24.01");
			mrApply.setApplyDctCd(userId);
			mrApply.setApplyDesc(mrApplyModel.getApplyDesc());
			mrApply.setApplyTime(new Timestamp(System.currentTimeMillis()));
			mrApplyDao.insert(mrApply);
		}
		Map<String, String> condition = new HashMap<String, String>();
		condition.put("roleFlag", "1");
		condition.put("applyType", "MRM25.02");
		return getMrApplyList(condition) ;
	}
	
	@Override
	public SingleResult<MrApplyModel> editMrApply(String id, MrApplyModel mrApplyModel) throws Throwable {
		Session session = Session.get();
		String deptCd = session.getDeptId();
		MrApply mrApply =  mrApplyDao.selectById(id);
		mrApply.setApplyStatus("MRM24.02");
		mrApply.setDeptCd(deptCd);
		mrApply.setApplyDesc(mrApplyModel.getApplyDesc());
		mrApply.setApplyTime(new Timestamp(System.currentTimeMillis()));
		mrApplyDao.updateExcludeNull(mrApply);
		return SingleResultBuilder.newSingleResult(MrApplyModel.class).build();
	}
	
	@Override
	public SingleResult<MrApplyModel> editMrApplyPass(String id, MrApplyModel mrApplyModel) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		MrApply mrApply =  mrApplyDao.selectById(id);
		mrApply.setApplyStatus("MRM24.03");
		mrApply.setMemo(mrApplyModel.getMemo());
		mrApply.setApprovalDctCd(userId);
		mrApply.setDeptCd(deptId);
		mrApply.setApprovalTime(new Timestamp(System.currentTimeMillis()));
		//如果为归档撤回申请，通过时修改病案状态到未书写完成
		if("MRM25.02".equals(mrApply.getApplyTypeCd())){
			MrAmr mrAmr = mrAmrDao.selectById(mrApply.getEnPk());
			mrAmr.setAmrStaCd("MRM22.01");
			mrAmrDao.updateExcludeNull(mrAmr);
		}
		mrApplyDao.updateExcludeNull(mrApply);
		return SingleResultBuilder.newSingleResult(MrApplyModel.class).build();
	}
	
	@Override
	public SingleResult<MrApplyModel> editMrApplyRefuse(String id, MrApplyModel mrApplyModel) throws Throwable {
		Session session = Session.get();
		String userId = session.getUserId();
		String deptId = session.getDeptId();
		MrApply mrApply =  mrApplyDao.selectById(id);
		mrApply.setApplyStatus("MRM24.04");
		mrApply.setMemo(mrApplyModel.getMemo());
		mrApply.setApprovalDctCd(userId);
		mrApply.setDeptCd(deptId);
		mrApply.setApprovalTime(new Timestamp(System.currentTimeMillis()));
		mrApplyDao.updateExcludeNull(mrApply);
		return SingleResultBuilder.newSingleResult(MrApplyModel.class).build();
	}
	

	private MrApplyModel mrApplyMapToModel(Map<String, Object> mapMrApply){
		MrApplyModel mrApplyModel = new MrApplyModel();
		mrApplyModel.setApplyCd(this.getValueFromMap(mapMrApply, "APPLY_CD", "主键"));
		mrApplyModel.setEnPk(this.getValueFromMap(mapMrApply, "EN_PK", "就诊编码"));
		mrApplyModel.setPaId(this.getValueFromMap(mapMrApply, "PA_ID", "患者编码"));
		mrApplyModel.setPaNm(this.getValueFromMap(mapMrApply, "PA_NM", "患者姓名"));
		mrApplyModel.setCurDeptCd(this.getValueFromMap(mapMrApply, "CUR_DEPT_CD", "就诊科室"));
		mrApplyModel.setCurDeptNm(this.getValueFromMap(mapMrApply, "CUR_DEPT_NM", "就诊科室"));
		mrApplyModel.setAmrNo(this.getValueFromMap(mapMrApply, "AMR_NO", "病案号"));
		mrApplyModel.setCurDeptIntoTime(this.getTimestampToStringFromMap(mapMrApply, "CUR_DEPT_INTO_TIME", "入院时间"));
		mrApplyModel.setMrTpCd(this.getValueFromMap(mapMrApply, "MR_TP_CD", "文书类型"));
		mrApplyModel.setQaAutoFltPk(this.getValueFromMap(mapMrApply, "QA_AUTO_FLT_PK", "缺陷编码"));
		mrApplyModel.setMrTpNm(this.getValueFromMap(mapMrApply, "MR_TP_NM", "文书类型"));
		mrApplyModel.setQaItmCd(this.getValueFromMap(mapMrApply, "QA_ITM_CD", "缺陷编码"));
		mrApplyModel.setReq(this.getValueFromMap(mapMrApply, "REQ", "缺陷项"));
		mrApplyModel.setOnceDrpScr(this.getBigDecimalToStringFromMap(mapMrApply, "ONCE_DRP_SCR", "扣分分值"));
		mrApplyModel.setApplyTime(this.getTimestampToStringFromMap(mapMrApply, "APPLY_TIME", "申请时间"));
		mrApplyModel.setApplyDctCd(this.getValueFromMap(mapMrApply, "APPLY_DCT_CD", "申请医生"));
		mrApplyModel.setApplyDctNm(this.getValueFromMap(mapMrApply, "APPLY_DCT_NM", "申请医生"));
		mrApplyModel.setApplyStatus(this.getValueFromMap(mapMrApply, "APPLY_STATUS", "申请状态"));
		mrApplyModel.setApplyStatusNm(this.getValueFromMap(mapMrApply, "APPLY_STATUS_NM", "申请状态"));
		mrApplyModel.setApplyDesc(this.getValueFromMap(mapMrApply, "APPLY_DESC", "申请描述"));
		mrApplyModel.setApplyTypeCd(this.getValueFromMap(mapMrApply, "APPLY_TYPE_CD", "申请类型"));
		mrApplyModel.setApplyTypeNm(this.getValueFromMap(mapMrApply, "APPLY_TYPE_NM", "申请类型"));
//		mrApplyModel.setSupDctCd(this.getValueFromMap(mapMrApply, "SUP_DCT_CD", "上级医生"));
//		mrApplyModel.setSupDctNm(this.getValueFromMap(mapMrApply, "SUP_DCT_NM", "上级医生"));
		mrApplyModel.setMngDctCd(this.getValueFromMap(mapMrApply, "MNG_DCT_CD", "主管医生"));
		mrApplyModel.setMngDctNm(this.getValueFromMap(mapMrApply, "MNG_DCT_NM", "主管医生"));
		mrApplyModel.setDeptCd(this.getValueFromMap(mapMrApply, "DEPT_CD", "审批科室"));
		mrApplyModel.setDeptNm(this.getValueFromMap(mapMrApply, "DEPT_NM", "审批科室"));
		mrApplyModel.setApprovalTime(this.getTimestampToStringFromMap(mapMrApply, "APPROVAL_TIME", "申批时间"));
		mrApplyModel.setApprovalDctCd(this.getValueFromMap(mapMrApply, "APPROVAL_DCT_CD", "申批医生"));
		mrApplyModel.setApprovalDctNm(this.getValueFromMap(mapMrApply, "APPROVAL_DCT_NM", "申批医生"));
		mrApplyModel.setMemo(this.getValueFromMap(mapMrApply, "MEMO", "申批医生"));
		return mrApplyModel;
	}
	
	private String getTimestampToStringFromMap(Map map,String key,String name){
		String value = "" ;
		if(verifyExistKeyOfObject(map, key)){
			Object object  = map.get(key);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			value = sdf.format(object);
			if(StringUtils.isBlank(object.toString())){
//				logger.debug(name+"为空");
				value = "" ;
			}
//			logger.debug(name+":"+ value);
		}else{
//			logger.debug(name+"为空");
		}
		return value;
	}
	
	private String getBigDecimalToStringFromMap(Map map,String key,String name){
		String value = "0" ;
		if(verifyExistKeyOfObject(map, key)){
			Object object  = map.get(key);
			value = object.toString();
			if(StringUtils.isBlank(object.toString())){
//				logger.debug(name+"为空");
				value = "0" ;
			}
//			logger.debug(name+":"+ value);
		}else{
//			logger.debug(name+"为空");
		}
		return value;
	}
	
	//判断map中是否存在key
	private boolean verifyExistKeyOfObject(Map map, String key) { 
		if (map.containsKey(key) && null != map.get(key)) {
			Object value = map.get(key) ;
			if(value !=null )
				return true;
		}
		return false;
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
//				logger.debug(name+"为空");
				value = null ;
			}
//			logger.debug(name+":"+ value);
		}else{
//			logger.debug(name+"为空");
		}
		return value;
	}

}
