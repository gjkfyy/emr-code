/**
 * <p>文件名:		DiServiceImpl.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.di.service.impl;

import iih.di.db.dao.CusDibDiDao;
import iih.di.db.dao.CusMrbMrDocDao;
import iih.di.db.dao.DiDao;
import iih.di.db.gen.dao.DiEntityDao;
import iih.di.db.gen.dao.MrEntityDao;
import iih.di.db.gen.entity.DiEntity;
import iih.di.db.gen.entity.MdDiEntity;
import iih.di.db.gen.entity.MrEntity;
import iih.di.model.AsistantImputModel;
import iih.di.model.CommitDataModel;
import iih.di.model.DibDiModel;
import iih.di.model.DibDiRtModel;
import iih.di.model.UserModel;
import iih.di.service.intf.DiService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.ass.di.AssDiagnosisService;
import pkuhit.iih.di.DiagnosisModel;
import pkuhit.iih.di.his.HisDiagnosis;
import pkuhit.iih.di.his.HisDiagnosisListModel;
import pkuhit.iih.mr.wr.Amr;
import pkuhit.iih.mr.wr.AmrService;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.UserService;
import pkuhit.xap.pm.ParamsSetService;
import pkuhit.xap.util.PerformancePrinter;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.util.UUIDGenerator;
/**
 * <p>
 * DiServiceImpl
 * </p>
 * <p>
 * TODO
 * </p>
 * 
 * @author 李德强(li_deqiang@founder.com, readwall@163.com)
 * @version 0.0.0
 *          <table style="border:1px solid gray;">
 *          <tr>
 *          <th width="100px">版本号</th>
 *          <th width="100px">动作</th>
 *          <th width="100px">修改人</th>
 *          <th width="100px">修改时间</th>
 *          </tr>
 *          <!-- 以 Table 方式书写修改历史 -->
 *          <tr>
 *          <td>0.0.0</td>
 *          <td>创建类</td>
 *          <td>李德强</td>
 *          <td>2014年8月28日 上午11:27:40</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class DiServiceImpl implements DiService {

	final static Logger logger = LoggerFactory.getLogger(DiServiceImpl.class);
	final Short Level_one = 1; // 第一层级
	final Short Level_two = 2; // 第二层级
	final Short FLAG_TRUE = 1; // 标志位有效状态
	final Short FLAG_FALSE = 0; // 标志位无效状态
	final Short lvlSortNo_1 = 1; // 顺序号
	final String NULL_STRING = "null";
	final String SYNC_DI_TO_HISFLAG_KEY = "SYNC_DI_TO_HIS"; //是否同步到HIS的key键值
	final String USE_MD_DI_ALIAS = "PY_USE_MD_DI_ALIAS"; //是否使用诊断字典别名表进行拼音查询
	@Autowired
	private DiEntityDao dao;

	@Autowired
	private CusDibDiDao cusDiDao;
	
	@Autowired
	CusMrbMrDocDao cusMrbMrDocDao;

	@Autowired
	MrEntityDao MrEntityDao;
	
	//@Autowired
	//MrbMrDocFileEntityDao mrbMrDocFileEntityDao;

	
	@Autowired
	DiDao diDao;

	@Reference
	private AssDiagnosisService diagnosisService;

	@Reference
	private UserService userTusService;
	
//	@Reference
//	private EncounterService encounterService;
	//@Reference
	//ParamsService paramsService ;
	
   @Reference
   AmrService amrService;
	
	@Reference
	ParamsSetService paramsSetService;
	/**
	 * 构造器
	 */
	public DiServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 通过就诊序号，获取诊断列表
	 * 
	 * @param enSn
	 *            就诊序号
	 * @param map
	 *            其他查询参数
	 * */
	@Override
	public List<DibDiRtModel> getDisByEnSn(String enSn, Map map) {
		logger.debug("获取诊断列表，就诊序号是" + enSn);
		Session session = Session.get();
		String orgCode =session.getOrgCd();
		String mainF = null;
		Integer mf = null;
		if (map.containsKey("mainF")) {
			mainF = map.get("mainF").toString();
			if(mainF.equals("1")||mainF.equalsIgnoreCase("true")){
				mf = 1;
				logger.debug("只读取主诊断");
			}else{
				logger.debug("读取全部诊断" );
			}
		}else{
			logger.debug("读取全部诊断" );
		}
		
		
		List<DiEntity> dibdis = cusDiDao.selectByEnSn(enSn, orgCode, mf);
		List<DiEntity> lv1s = new LinkedList<DiEntity>();// level是1的诊断列表
		// <parDiSn, 子诊断列表>
		Map<String, List<DiEntity>> lv2ParSnDis = new HashMap<String, List<DiEntity>>();
		for (DiEntity di : dibdis) {
			//主诊断不一定在第一条，如果第一条停用就不是主诊断
//			if (null != di.getMainF() && FLAG_TRUE == di.getMainF()) {// 找到主诊断,插入列表的第一位
//				lv1s.add(0, di);
//			} else 
			if (null != di.getLvl() && Level_one == di.getLvl()) {// 找到级别为1的诊断
				lv1s.add(di);
			} else if (null != di.getLvl() && Level_two == di.getLvl()) {// 将级别为2的诊断加入map
				// lv2ParSnDis
				List<DiEntity> list = lv2ParSnDis.get(di.getParDiSn());
				if (null == list) {
					list = new LinkedList<DiEntity>();
					lv2ParSnDis.put(di.getParDiSn(), list);
				}
				list.add(di);
			}
		}
		// 将数据库实体对象转换为业务对象返回
		List<DibDiRtModel> models = new LinkedList<DibDiRtModel>();
		for (DiEntity di : lv1s) {
			DibDiRtModel m = trans(di);
			List<DiEntity> list = lv2ParSnDis.get(di.getDiSn());
			if (null != list) {
				List<DibDiRtModel> trans = trans(list);
				m.setChildren(trans);
			}
			models.add(m);
		}
		return models;
	}

	/**
	 * 实体列表转换为业务列表
	 * 
	 * @param orgins
	 * @return
	 */
	public List<DibDiRtModel> trans(List<DiEntity> orgins) {
		List<DibDiRtModel> list = new LinkedList<DibDiRtModel>();
		for (DiEntity di : orgins) {
			DibDiRtModel m = trans(di);
			list.add(m);
		}
		return list;
	}

	/**
	 * 实体对象转换为业务对象
	 * 
	 * @param di
	 * @return
	 */
	public DibDiRtModel trans(DiEntity di) {
		DibDiRtModel m = new DibDiRtModel();
		// TODO 使用BeanUtils拷贝属性
		// BeanUtils.copyProperties(m, di);
		m.setDiSn(di.getDiSn());
		m.setDiCd(di.getDiCd());
		m.setParDiSn(di.getParDiSn());
		m.setLvl(di.getLvl());
		// m.setSortNo(di.getSortNo());
		m.setDiNm(di.getDiNm());
		m.setMainF(di.getMainF());
		if (FLAG_TRUE.equals(di.getUncertainF())) {
			m.setSuspected(Boolean.TRUE);
		} else {
			m.setSuspected(Boolean.FALSE);
		}
		if (FLAG_TRUE.equals(di.getUnknowF())) {
			m.setTocheck(Boolean.TRUE);
		} else {
			m.setTocheck(Boolean.FALSE);
		}
		m.setAddDescr(di.getAddDescr());
		m.setIcdCd(di.getIcdCd());
		// 显示医生姓名
		UserModel userModel = getUserModel();
		m.setDiEmpNm(userModel.getUserNm());
		m.setDiTime(di.getDiTime());
		//m.setStopUseF(di.getStopUseF());
		m.setUpdCount(di.getUpdCnt());
		//组套所属类型，所属编码
		m.setSetOwnerCd(di.getSetOwnerCd());
		m.setSetOwnerTypeCd(di.getSetOwnerTypeCd());
		m.setLvl1SortNo(di.getLvl1SortNo().toString());
		m.setLvl2SortNo(di.getLvl2SortNo().toString());
		return m;
	}

	/**
	 * @author guo_zhongbao
	 * @param commitDataModel
	 *            诊断列表
	 * @throws IihException
	 * @see iih.di.service.intf.DiService#saveEns(java.util.Map)
	 * 
	 * */
	@Override
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { IihException.class })
	public Map saveEns(CommitDataModel commitDataModel)  {
		Map map_result = new HashMap();
		try {
			if (null == commitDataModel) {

				logger.debug("fail");
				logger.debug("commitDataModel is null");

				map_result.put("success", "fail");
				map_result.put("message", "提交内容失败");
				return map_result;
			}
			String enSn = commitDataModel.getEnSn(); // 就诊序号
			DibDiModel[] DibDi_Model_array = commitDataModel.getList();// 诊断列表
			UserModel userModel = getUserModel();
			saveToDB(DibDi_Model_array, userModel, enSn);
			String mainDiCode = null ;
/*			
 *          注释该功能：避免更新就诊表   2015-12-05 guo_zhongbao
 *          if(DibDi_Model_array.length > 0 ){
				mainDiCode = DibDi_Model_array[0].getDiCd();
				updateAmrMainDia( enSn, mainDiCode);
			}*/
			logger.debug("true");
			logger.debug("保存成功");
			map_result.put("success", "true");
			map_result.put("message", "提交成功");
			//return map_result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map_result;
	}

	private void updateAmrMainDia(String enSn, String mainDiCode) {
		try{
		SingleResult<Amr> singleResultAmr = amrService.get(enSn);
		Amr amr = singleResultAmr.getData() ;
		amr.setCurrentMainDiagnosisCode(mainDiCode);
		amrService.update(enSn, amr);
		}catch(Exception ex){
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @author guo_zhongbao
	 * @param list_str
	 *            诊断列表的json格式字符串
	 * @param userModel
	 *            诊断医生bean对象
	 * @param enSn
	 *            就诊序号
	 * */
	private void saveToDB(DibDiModel[] list, UserModel userModel, String enSn)
			throws Exception {
		List<DiEntity> list_add = new ArrayList<DiEntity>();
		List<DiEntity> list_update = new ArrayList<DiEntity>();
		dealArray(list, Level_one, list_add, list_update, null, userModel,
				enSn, Short.valueOf("0"));

		logger.debug(iih.di.utils.TypeUtil.typeToString(null, list_add));
		logger.debug(iih.di.utils.TypeUtil.typeToString(null, list_update));

		// 将接诊新增和更新 转换为 His对象的新增和更新
		List<HisDiagnosis> srcList = new ArrayList<HisDiagnosis>();
		List<HisDiagnosis> srcListAdd = translateToAddHisDiagnosis(list_add);
		if (null != srcListAdd) {
			srcList.addAll(srcListAdd);
		}
		if(list_update.size() > 0){
			List<DiEntity> list_update_entity = new ArrayList<DiEntity>();			
			for(DiEntity upo  : list_update )
			{
/*				if(FLAG_TRUE.equals(upo.getStopUseF())){
					continue;
				}*/
				for (int i = 0; i < list.length; i++) {
					DibDiModel obj = list[i];
					/**
					 * 如果diSn为null或者没有，则表示该对象为新增，从接口api中获得id。 如果diSn有值,则表示该对象为更新，更新
					 * 判断子列表，如果有，则重复以上操作。 将新增对象放入新增的队列， 将更新对象放入更新的队列
					 * */
					String diSn = obj.getDiSn();
					if (upo.getDiSn().equals(diSn)) {
						DiEntity  di = this.creatAddDibDiFromJsonObj(upo,obj,userModel,enSn) ;
						list_update_entity.add(di) ;
					}
				}
			}
			List<HisDiagnosis> srcListUpdate = this.translateToAddHisDiagnosis(list_update_entity);
			if (null != srcListUpdate) {
				srcList.addAll(srcListUpdate);
			}
		}

		dao.batchInsert(list_add);
		// dao.batchUpdate(list_update);
		// 批量更新，因为不支持 excludeNull ，改为 foreach updata
		for (DiEntity dibDi : list_update) {

			dao.updateExcludeNull(dibDi);
		}

		logger.debug("保存到oracle 诊断列表成功");

		syschronizeHis(enSn,srcList);
		
	}

	/**
	 * 处理json数组
	 * 
	 * @author guo_zhongbao
	 * @param array
	 *            待处理的json数组
	 * @param level
	 *            该数组的对象在对象树种的层级
	 * @param list_add
	 *            新增对象列表
	 * @param list_update
	 *            更新对象列表
	 * @param parDiSn
	 *            父诊断
	 * @param userModel
	 *            诊断医生bean对象
	 * @param enSn
	 *            就诊序号
	 * */
	private void dealArray(DibDiModel[] list, Short level,
			List<DiEntity> list_add, List<DiEntity> list_update,
			String parDiSn, UserModel userModel, String enSn, Short parSortNo) {
		// 本层序号
		Short lvlSortNo = 0;
		//诊断时间
		Date diTime = new Date();
		Boolean findMainDi = Boolean.FALSE ;
		// 循环数据
		for (int i = 0; i < list.length; i++) {
			lvlSortNo++;
			DibDiModel obj = list[i];
			/**
			 * 如果diSn为null或者没有，则表示该对象为新增，从接口api中获得id。 如果diSn有值,则表示该对象为更新，更新
			 * 判断子列表，如果有，则重复以上操作。 将新增对象放入新增的队列， 将更新对象放入更新的队列
			 * */
			String diSn = obj.getDiSn();
			if (StringUtils.isBlank(diSn)) {
				// 如果diSn为空，则先获取id,然后保存到新增列表list_add
				diSn = getIdFromAPI();
				logger.debug("当前id为：" + diSn);
				DiEntity  di = this.creatAddDibDiFromJson(obj, diSn, level,
						lvlSortNo, parDiSn, userModel, enSn, parSortNo, diTime,findMainDi) ;
				if(FLAG_TRUE.equals(di.getMainF() )){
					findMainDi = true ; 
				}
				list_add.add(di);
			} else {
				/**
				 * 如果为更新,更新数据库 可更新的字段有 parDiSn父诊断序号 lvl层级 lvl1SortNo第一层顺序号
				 * lvl2SortNo第二层 顺序号 mainF主诊断 suspected 疑似标志 tocchek待查标志
				 * addDescr补充说明 stopUseF活动停用
				 * */
				DiEntity  di =  this.createUpdateDibDiFromJson(obj, level,
						lvlSortNo, parDiSn, parSortNo,findMainDi) ;
				if(i == 0){
					di.setMainF(Short.valueOf("1"));
				}
				if(FLAG_TRUE.equals(di.getMainF())){
					findMainDi = true ; 
				}
				
				list_update.add(di);

			}
			DibDiModel[] children = obj.getChildren();
			if (children != null) {
				dealArray(children, Level_two, list_add, list_update, diSn,
						userModel, enSn, lvlSortNo);
			}
		}

	}

	/**
	 * 创建 新增对象 ，根据json对象
	 * 
	 * @author guo_zhongbao
	 * @param json_obj
	 *            json对象
	 * @param id
	 *            新增对象的id
	 * @param lvl
	 *            对象的层
	 * @param lvlSortNo
	 *            该对象所处层级的序号
	 * @param parDiSn
	 *            父诊断
	 * @param userModel
	 *            诊断医生bean对象
	 * @param enSn
	 *            就诊序号
	 * @return 数据库对象
	 * */
	private DiEntity creatAddDibDiFromJson(DibDiModel obj, String id,
			Short lvl, Short lvlSortNo, String parDiSn, UserModel userModel,
			String enSn, Short parSortNo, Date diTime,Boolean findMainDi) {
		DiEntity dibDi = new DiEntity();
		dibDi.setDiSn(id);
		dibDi.setDiEmpId(userModel.getUserCd());// 诊断医生编码
		dibDi.setAddDescr(obj.getAddDescr()); // 描述
		dibDi.setDiCd(obj.getDiCd()); // 诊断编码
		dibDi.setDiDeptCd(userModel.getDeptCd()); // 诊断科室
		dibDi.setDiNm(obj.getDiNm());// 诊断名称
		if(obj.getDiTime() == null) {//没传时间，用后台时间
			obj.setDiTime(diTime);
		}
		dibDi.setDiTime(new Timestamp(obj.getDiTime().getTime()));// 就诊时间
//		dibDi.setStopUseF(FLAG_FALSE);
		Boolean suspected = obj.getSuspected();// 疑似
		if (suspected) {
			dibDi.setUncertainF(FLAG_TRUE);
		} else {
			dibDi.setUncertainF(FLAG_FALSE);
		}
		Boolean tocheck = obj.getTocheck();
		if (tocheck) {
			dibDi.setUnknowF(FLAG_TRUE);
		} else {
			dibDi.setUnknowF(FLAG_FALSE);
		}
		dibDi.setEnSn(enSn); // 就诊序号
		dibDi.setIcdCd(obj.getIcdCd()); // icd编码
		dibDi.setLvl(lvl); // 层级 1 ，2
		/**
		 * 第一层级，如果顺序号为1，则为主诊断 第二层级，设置父诊断
		 * */
		if (Level_one.equals(lvl)) {
			dibDi.setLvl1SortNo(lvlSortNo);
			dibDi.setLvl2SortNo(Short.valueOf("0"));
			if (!findMainDi) {
				dibDi.setMainF(FLAG_TRUE);
				//findMainDi = true ;
			} else {
				dibDi.setMainF(FLAG_FALSE);
			}
		} else {
			dibDi.setParDiSn(parDiSn); // 父诊断
			dibDi.setLvl2SortNo(lvlSortNo);
			dibDi.setLvl1SortNo(parSortNo);
			dibDi.setMainF(FLAG_FALSE);
		}
		dibDi.setOrgCd(userModel.getOrgCd());
		if(!StringUtils.isBlank(obj.getSetOwnerCd())){
			dibDi.setSetOwnerCd(obj.getSetOwnerCd());
		}
		if(!StringUtils.isBlank(obj.getSetOwnerTypeCd())){
			dibDi.setSetOwnerTypeCd(obj.getSetOwnerTypeCd());
		}
		return dibDi;

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
	
	private DiEntity creatAddDibDiFromJsonObj(DiEntity upo, DibDiModel obj,UserModel  userModel,String enSn) {
		DiEntity dibDi = new DiEntity();
		dibDi.setDiSn(obj.getDiSn());
		dibDi.setDiEmpId(userModel.getUserCd());// 诊断医生编码
		dibDi.setAddDescr(obj.getAddDescr()); // 描述
		dibDi.setDiCd(obj.getDiCd()); // 诊断编码
		dibDi.setDiDeptCd(userModel.getDeptCd()); // 诊断科室
		dibDi.setDiNm(obj.getDiNm());// 诊断名称
		Date diTime = new Date();
		if(obj.getDiTime() == null) {//没传时间，用后台时间
			obj.setDiTime(diTime);
		}
		dibDi.setDiTime(new Timestamp(obj.getDiTime().getTime()));// 就诊时间
		//dibDi.setStopUseF(obj.getStopUseF());
		dibDi.setUncertainF(upo.getUncertainF());
		dibDi.setUnknowF(upo.getUnknowF());

		dibDi.setEnSn(enSn); // 就诊序号
		dibDi.setIcdCd(obj.getIcdCd()); // icd编码
		dibDi.setMainF(upo.getMainF());
		dibDi.setOrgCd(userModel.getOrgCd());
		if(!StringUtils.isBlank(obj.getSetOwnerCd())){
			dibDi.setSetOwnerCd(obj.getSetOwnerCd());
		}
		if(!StringUtils.isBlank(obj.getSetOwnerTypeCd())){
			dibDi.setSetOwnerTypeCd(obj.getSetOwnerTypeCd());
		}
		Boolean suspected = obj.getSuspected();// 疑似
		if (suspected) {
			dibDi.setUncertainF(FLAG_TRUE);
		} else {
			dibDi.setUncertainF(FLAG_FALSE);
		}
		Boolean tocheck = obj.getTocheck();
		if (tocheck) {
			dibDi.setUnknowF(FLAG_TRUE);
		} else {
			dibDi.setUnknowF(FLAG_FALSE);
		}
		dibDi.setLvl1SortNo(upo.getLvl1SortNo());
		dibDi.setLvl2SortNo(upo.getLvl2SortNo());
		dibDi.setParDiSn(upo.getParDiSn());
		return dibDi;

	}
	
	/**
	 * 创建更新对象，根据json对象
	 * 
	 * @author guo_zhongbao
	 * @param json_obj
	 *            json对象
	 * @param lvl
	 *            对象的层
	 * @param lvlSortNo
	 *            该对象所处层级的序号
	 * @param parDiSn
	 *            父诊断
	 * @return 更新的数据库对象
	 * */
	private DiEntity createUpdateDibDiFromJson(DibDiModel obj, Short lvl,
			Short lvlSortNo, String parDiSn, Short parSortNo,Boolean findMainDi) {
		DiEntity dibDi = new DiEntity();
		/*
		 * parDiSn父诊断序号 lvl层级 lvl1SortNo第一层顺序号 lvl2SortNo第二层 顺序号 mainF主诊断
		 * suspected 疑似标志 tocchek待查标志 addDescr补充说明 stopUseF活动停用
		 */
		dibDi.setDiSn(obj.getDiSn());
		dibDi.setAddDescr(obj.getAddDescr());
		//dibDi.setStopUseF(obj.getStopUseF());
		dibDi.setDiCd(obj.getDiCd()); // 诊断编码
		Boolean suspected = obj.getSuspected();// 疑似
		if (suspected) {
			dibDi.setUncertainF(FLAG_TRUE);
		} else {
			dibDi.setUncertainF(FLAG_FALSE);
		}
		Boolean tocheck = obj.getTocheck();
		if (tocheck) {
			dibDi.setUnknowF(FLAG_TRUE);
		} else  {
			dibDi.setUnknowF(FLAG_FALSE);
		}
		dibDi.setLvl(lvl);
		/**
		 * 第一层级，如果顺序号为1，则为主诊断 第二层级，设置父诊断
		 * */
		if (Level_one.equals(lvl)) {
			dibDi.setParDiSn("");
			dibDi.setLvl1SortNo(lvlSortNo);
			dibDi.setLvl2SortNo(Short.valueOf("0"));
			if (FLAG_FALSE.equals(obj.getStopUseF())&&!findMainDi) {
				dibDi.setMainF(FLAG_TRUE);
			//	findMainDi = true;
			} else {
				dibDi.setMainF(FLAG_FALSE);
			}
		} else {
			dibDi.setParDiSn(parDiSn); // 父诊断
			dibDi.setLvl2SortNo(lvlSortNo);
			dibDi.setLvl1SortNo(parSortNo);
			dibDi.setMainF(FLAG_FALSE);
		}
		dibDi.setUpdCnt(obj.getUpdCount());
		return dibDi;

	}

	private List<HisDiagnosis> translateToAddHisDiagnosis(
			List<DiEntity> list_add) {
		if (list_add.isEmpty()) {
			return null;
		}
		List<HisDiagnosis> rs = new ArrayList<HisDiagnosis>();
		for (DiEntity dibDi : list_add) {
			HisDiagnosis hisDiagnosis = new HisDiagnosis();
			hisDiagnosis.setDoctorSn(dibDi.getDiEmpId());// 诊断医生编码
			hisDiagnosis.setCommentStr(dibDi.getAddDescr()); // 描述
			hisDiagnosis.setDiagCode(dibDi.getDiCd()); // 诊断编码
			hisDiagnosis.setDeptSn(dibDi.getDiDeptCd()); // 诊断科室
			hisDiagnosis.setDiagStr(dibDi.getDiNm());// 诊断名称
			hisDiagnosis.setInputDate(dibDi.getDiTime());// 就诊时间
			hisDiagnosis.setUncertainFlag(String.valueOf(dibDi.getUnknowF()
					.shortValue())); // 待查
			hisDiagnosis.setSuspectedFlag(String.valueOf(dibDi.getUncertainF()
					.shortValue()));
			hisDiagnosis.setIcdCode(dibDi.getIcdCd());// icd编码
			hisDiagnosis.setMainFlag(String.valueOf(dibDi.getMainF()
					.shortValue()));// 主诊断标识
			hisDiagnosis.setLv1sortNo(dibDi.getLvl1SortNo().toString());
			hisDiagnosis.setLv2sortNo(dibDi.getLvl2SortNo().toString());
			rs.add(hisDiagnosis);
		}
		return rs;
	}

	private List<HisDiagnosis> translateToUpdateHisDiagnosis(List<DiEntity> list_update) {
		if (list_update.isEmpty()) {
			return null;
		}
		List<HisDiagnosis> rs = new ArrayList<HisDiagnosis>();
		for (DiEntity dibDi : list_update) {
			// 只考虑活动的就诊列表
			//if (FLAG_FALSE.equals(dibDi.getStopUseF())) {
				HisDiagnosis hisDiagnosis = new HisDiagnosis();
				hisDiagnosis.setMainFlag(String.valueOf(dibDi.getMainF()
						.shortValue()));
				hisDiagnosis.setDiagCode(dibDi.getDiCd());
				hisDiagnosis.setLv1sortNo(dibDi.getLvl1SortNo().toString());
				hisDiagnosis.setLv2sortNo(dibDi.getLvl2SortNo().toString());
				rs.add(hisDiagnosis);
		//	}
		}
		return rs;
	}

	@Override
	public Map deleteDia(String diSn, Map map) {
		Map mapRs= null;
		DiEntity di = dao.selectById(diSn) ;
		if(null == di ){
			logger.info("诊断为空，diSn："+diSn);
		}else{
			Short mainF= di.getMainF() ;
			di.setDelF(Short.valueOf("1"));
			dao.markDelete(di);
			

			// 根据enSn获取诊断列表
			List<HisDiagnosis> srcList = new ArrayList<HisDiagnosis>();
			String enSn = di.getEnSn() ;
			logger.debug("enSn is "+enSn);
			String delDiCode = di.getDiCd() ;
			String newMainDiCode = null ;
			if( mainF.equals(Short.valueOf("1"))){
				//当前被删除的诊断为主诊断，需要找的其他的主诊断
				SelectOptions options = SelectOptions.get().offset(0).limit(1).count();	
				Session session = Session.get();
				DiEntity diNextRecord = this.cusDiDao.selectDiNextRecord(enSn, session.getOrgCd(),options);
				if(null != diNextRecord){
					diNextRecord.setMainF(Short.valueOf("1"));
					newMainDiCode = diNextRecord.getDiCd() ;
					dao.updateExcludeNull(diNextRecord);
				}else{
					logger.debug("当前无诊断");
				}
			}
			SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(SYNC_DI_TO_HISFLAG_KEY);
			if(null != rsFunFlag 
					&&  null != rsFunFlag.getData()
					&& rsFunFlag.getData().equalsIgnoreCase("1")
			)
			{
				String[] arr = new String[2];
				if (enSn.indexOf("_") != -1) {
					arr = enSn.split("_");
				} else {
					logger.error("enSn格式不正确");
				}
				PerformancePrinter.start("oracleDiService.delDiagnosis");
				//直接删除诊断，并设置新的主诊断
				diagnosisService.delDiagnosis(delDiCode, newMainDiCode, arr[0], arr[1]);
				PerformancePrinter.end("oracleDiService.delDiagnosis");
			}
/*			List<DibDiRtModel> disListByEnSn = this.getDisByEnSn(enSn, new HashMap());
			for(int i = 0 ; i< disListByEnSn.size() ;i++){
				DibDiRtModel srcModel = disListByEnSn.get(i) ;
				HisDiagnosis dstModel = new HisDiagnosis();
				dstModel.setDiagCode(srcModel.getDiCd());
				dstModel.setMainFlag(srcModel.getMainF().toString());
				dstModel.setLv1sortNo(srcModel.getLvl1SortNo());
				dstModel.setLv2sortNo(srcModel.getLvl2SortNo());
				srcList.add(dstModel);
			}
			try{
				syschronizeHis(enSn,srcList);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			/*			
			 *  注释该功能：避免更新就诊表   2015-12-05 guo_zhongbao
			updateAmrMainDia( enSn, newMainDiCode);
           */
			mapRs= new HashMap();
			logger.debug("删除成功，diSn："+diSn);
			mapRs.put("message", "删除成功");
			mapRs.put("success", Boolean.TRUE);
		}
		return mapRs;
	}
	private void syschronizeHis(String enSn, List<HisDiagnosis> srcList) throws  Exception{
		PerformancePrinter.start("oracleDiService.syschronizeHis");
		SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(SYNC_DI_TO_HISFLAG_KEY);
		if(null != rsFunFlag 
				&&  null != rsFunFlag.getData()
				&& rsFunFlag.getData().equalsIgnoreCase("1")
		)
		{
	//	if (true) {
			String[] arr = new String[2];
			if (enSn.indexOf("_") != -1) {
				arr = enSn.split("_");
			} else {
				logger.debug("enSn格式不正确");
				throw new Exception("enSn格式不正确");
			}
			HisDiagnosisListModel model = new HisDiagnosisListModel();
			model.setList(srcList);
			logger.debug("开始同步");

			// 同步就诊列表到HIS数据库
			diagnosisService.saveOrUpdateDiagnosis(model, arr[0], arr[1]);

			logger.debug("同步到his 诊断列表成功");

		} else {
			logger.info("未设置诊断同步，如需配置，请在  XAP_PARAM 表中，写入“name= 诊断是否自动提交 ， key = 启用标识  ，code =SYSM01.4 ， value = 1 ”");
		}
		PerformancePrinter.end("oracleDiService.syschronizeHis");
	}
	/**
	 * 从接口中获取uuid
	 * */
	public String getIdFromAPI() {
		return UUIDGenerator.getUUID();
	}

	@Override
	public Map Asistant(Map map) {
		String keyWord = getValueFromMap(map,"keyword","关键字");
		List<MdDiEntity> defs =  null ;
		if(null == keyWord){
			defs = diDao.assistantQueryAll();
		}else{
			//是否使用诊断字典别名表查询拼音
			boolean isUseAlias = false ;
			SingleResult<String> rsFunFlag = paramsSetService.searchFunFlagByKey(USE_MD_DI_ALIAS);
			if(   null != rsFunFlag 
					&&  null != rsFunFlag.getData()
					&& rsFunFlag.getData().equalsIgnoreCase("1")
			){
				isUseAlias = true ;
			}
			defs = assistant(diDao, keyWord.toUpperCase(),	20,isUseAlias);
		}
		Map res = new HashMap();
		if(null != defs && !defs.isEmpty()){
			AsistantImputModel[] ret = new AsistantImputModel[defs.size()];
			for (int i = 0; i < ret.length; i++) {
				MdDiEntity et = defs.get(i);
				AsistantImputModel item = new AsistantImputModel();
				item.setValue(et.getDiCd());
				item.setIcd(et.getIcdCd());
				item.setLabel(et.getNm());
				ret[i] = item;
			}
			res.put("data", ret);
		}else{
		}
		return res;
	}
	
	/**
	 * 返回rtNum个诊断，rtNum要和maxRows = IihSettings.DIM_ASSIS_NUM相等
	 * 
	 * @param diDao
	 * @param keyWord
	 * @param rtNum
	 * @return
	 */
	public static List<MdDiEntity> assistant(DiDao diDao, String keyWord,
			int rtNum ,boolean isUseAlias) {
		List<MdDiEntity> defsPrefix = null ;
		List<MdDiEntity> equalList = null;
		if(isChinese(keyWord)){
			defsPrefix = diDao.assistantQueryNm(keyWord, true);
			if (defsPrefix.size() < rtNum) {
				List<MdDiEntity> defsContains = diDao.assistantQueryNm(keyWord,
						false);
				int leftNum = rtNum - defsPrefix.size();
				int toIndex = defsContains.size() > leftNum ? leftNum
						: defsContains.size();
				defsPrefix.addAll(defsContains.subList(0, toIndex));
			}
		}else{
			if( isUseAlias)
			{
				
				//使用诊断字典别名表进行查询拼音
				//查询等于关键字的
				equalList = diDao.assistantQueryAliasEqualSpell(keyWord, true);
				int sizeEqualList = equalList.size();
				if(sizeEqualList <  rtNum){
					//查询以关键字开头的
					defsPrefix = diDao.assistantQueryAliasSpell(keyWord, true);
					if (defsPrefix.size() + sizeEqualList < rtNum) {
						//2个加起来还不够，则需要查询like '%keyword%'
						List<MdDiEntity> defsContains = diDao.assistantQueryAliasSpell(keyWord,
								false);
						int leftNum = rtNum - defsPrefix.size() - sizeEqualList;
						int toIndex = defsContains.size() > leftNum ? leftNum
								: defsContains.size();
						defsPrefix.addAll(defsContains.subList(0, toIndex));
						equalList.addAll(defsPrefix);
						defsPrefix = equalList ;
					}else {
						//2个加起来大于需要的数量，则截取
						int leftNum =  rtNum - sizeEqualList  ;
						int toIndex = defsPrefix.size() > leftNum ? leftNum
								: defsPrefix.size();
						equalList.addAll(defsPrefix.subList(0, toIndex));
						defsPrefix = equalList ;
					}
				}else{
					defsPrefix = new ArrayList<MdDiEntity>(rtNum);
					//如果等于查询，大于需要的数量
					defsPrefix.addAll(equalList.subList(0, rtNum));
				}
			}else{
				
				//使用诊断字典别名表进行查询拼音
				//查询等于关键字的
				equalList = diDao.assistantQueryEqualSpell(keyWord,true);
				int sizeEqualList = equalList.size();
				if(sizeEqualList <  rtNum){
					//查询以关键字开头的
					defsPrefix = diDao.assistantQuerySpell(keyWord, true);
					if (defsPrefix.size() + sizeEqualList < rtNum) {
						//2个加起来还不够，则需要查询like '%keyword%'
						List<MdDiEntity> defsContains = diDao.assistantQuerySpell(keyWord,
								false);
						int leftNum = rtNum - defsPrefix.size() - sizeEqualList;
						int toIndex = defsContains.size() > leftNum ? leftNum
								: defsContains.size();
						defsPrefix.addAll(defsContains.subList(0, toIndex));
						equalList.addAll(defsPrefix);
						defsPrefix = equalList ;
					}else {
						//2个加起来大于需要的数量，则截取
						int leftNum =  rtNum - sizeEqualList  ;
						int toIndex = defsPrefix.size() > leftNum ? leftNum
								: defsPrefix.size();
						equalList.addAll(defsPrefix.subList(0, toIndex));
						defsPrefix = equalList ;
					}
				}else{
					//如果等于查询，大于需要的数量
					defsPrefix = new ArrayList<MdDiEntity>(rtNum);
					defsPrefix.addAll(equalList.subList(0, rtNum));
				}
			}
		
		}
		 


		return defsPrefix;
	}

	
	// 根据Unicode编码完美的判断中文汉字和符号 
    private static boolean isChinese(char c) { 
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c); 
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS 
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B 
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS 
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) { 
            return true; 
        } 
        return false; 
    } 

    // 完整的判断中文汉字和符号 
    public static boolean isChinese(String strName) { 
        char[] ch = strName.toCharArray(); 
        for (int i = 0; i < ch.length; i++) { 
            char c = ch[i]; 
            if (isChinese(c)) { 
                return true; 
            } 
        } 
        return false; 
    } 


	private UserModel getUserModel(){
		UserModel userModel = new UserModel();
		Session session = Session.get();
		userModel.setOrgCd(session.getOrgCd());
		//userModel.setOrgNm(session.get);
		userModel.setDeptCd(session.getDeptId());
		userModel.setDeptNm(session.getDeptName());
		userModel.setUserCd(session.getUserId());
		userModel.setUserNm(session.getUserName());
		return userModel;
	}
	/**
	 * 诊断复制插入本地库并同步HIS库
	 * 
	 * */
	@Override
	//@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { IihException.class })
	public void saveCopyDisByEnSn(String oldEnSn,String newEnsn){
		Session session = Session.get();
		String orgCode = session.getOrgCd() ;
		List<DiEntity> dibdis = cusDiDao.selectDisByOldEnSn(oldEnSn, orgCode);
		UserModel userModel = getUserModel();
		
	   if( null == dibdis || dibdis.isEmpty()){
		   logger.debug("就诊序号："+ oldEnSn +" 诊断列表为空");
	   }else{
		   logger.debug("就诊序号："+ oldEnSn +" 诊断列表数量为："+dibdis.size());
		   saveDisToDb(dibdis, userModel, newEnsn);
	   }
			
	}
	
	private void saveDisToDb(List<DiEntity> list,UserModel userModel,String enSn){
		
		 try{
			    List<DiEntity> listAdd = new ArrayList<DiEntity>();
				
				for(int i=0;i<list.size();i++){
					
					String diSn = getIdFromAPI();
					//DibDiEntity dibDi = new DibDiEntity();
					//BeanUtils.copyProperties(dibDi, list.get(i));
					DiEntity dibDi= dao.selectById(list.get(i).getDiSn());
					dibDi.setDiSn(diSn);
					dibDi.setEnSn(enSn);
					dibDi.setCopyFlag(Short.valueOf("1"));
					listAdd.add(dibDi);
					
				}
				
				// 将接诊新增和更新 转换为 His对象的新增和更新
				List<HisDiagnosis> srcListAdd = translateToAddHisDiagnosis(listAdd);
				
				dao.batchInsert(listAdd);
				
				syschronizeHis(enSn,srcListAdd);
				//diagnosisService.saveOrUpdateDiagnosis(model, arr[0], arr[1]);

				logger.debug("同步到his 诊断列表成功");
				
		 }catch(Exception e){
			 e.printStackTrace();
			 logger.debug(e.getMessage());
		 }
	}

	@Override
	public void saveCopyMrsByEnSn(String oldEnSn, String newEnsn){

		List<MrEntity> mrs = cusMrbMrDocDao.selectMrsByEnSn(oldEnSn);
//
//		if (userTusService == null) {
//			userTusService = ComponentContextUtils.getComponentContext().getBeanOfType(UserService.class);
//		}
//
//		UserModel userModel = userTusService.getUserModel();
		if(null == mrs || mrs.isEmpty() ){
			  logger.debug("就诊序号："+ oldEnSn +" 病历列表为空");
		}else{
			  logger.debug("就诊序号："+ oldEnSn +" 病历列表数量为："+mrs.size());
			saveMrsToDb(mrs, newEnsn);
		}
	}

	private void saveMrsToDb(List<MrEntity> mrs, String newEnsn) {
		try{/*
		    List<MrEntity> listMrAdd = new ArrayList<MrEntity>();
		    List<MrbMrDocFileEntity> listMrFileAdd = new ArrayList<MrbMrDocFileEntity>();
			
			for(int i=0;i<mrs.size();i++){
				
				String mrDocSn = getIdFromAPI();
				MrEntity mr = mrs.get(i);
//				BeanUtils.copyProperties(mr, mrs.get(i));
				//MrbMrDocFileEntity mrbMrDocFileEntity=mrbMrDocFileEntityDao.selectById(mr.getMrDocSn());
				mrbMrDocFileEntity.setMrDocSn(mrDocSn);
				mrbMrDocFileEntity.setCopyFlag(Short.valueOf("1"));
				listMrFileAdd.add(mrbMrDocFileEntity);
				mr.setMrDocSn(mrDocSn);
				mr.setEncounterSn(newEnsn);
				mr.setCopyFlag(Short.valueOf("1"));
				listMrAdd.add(mr);
			}
			MrEntityDao.batchInsert(listMrAdd);
			mrbMrDocFileEntityDao.batchInsert(listMrFileAdd);
		*/}catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}

	@Override
	public void saveCopyDisAndMrsByEnSn(String enSn) {
		String[] arr =  enSn.split("_") ;
		String patientid =arr[0];
		String currentOutpTimes = arr[1];
		int time = Integer.parseInt(currentOutpTimes) ;
//		EncounterModel lastEncounter = encounterService.getLastEffectiveEncounterByEncounterSn(patientid +"_"+ String.valueOf(time) );
//
//		if(null == lastEncounter){
//			logger.debug("找不到有效的就诊");
//		}else{
//			String oldEnSn= lastEncounter.getEnPk();
//			logger.debug("开始复制");
//			logger.debug("enSn："+enSn);
//			logger.debug("oldEnSn："+oldEnSn);
//			if(null!=oldEnSn&&!"".equals(oldEnSn)){
//				this.saveCopyMrsByEnSn(oldEnSn, enSn);
//				this.saveCopyDisByEnSn(oldEnSn, enSn);
//			}
//			logger.debug("复制成功");
//		}
	}

	@Override
	public ArrayResult<DiagnosisModel> getDisListByEnSn(String enSn, Map map) {
		ArrayResultBuilder<DiagnosisModel> builder = ArrayResultBuilder.newArrayResult(DiagnosisModel.class);
		logger.debug("获取诊断列表，就诊序号是" + enSn);
		Session session = Session.get();
		String orgCode =session.getOrgCd();
		String mainF = null;
		Integer mf = null;
		if (map.containsKey("mainF")) {
			mainF = map.get("mainF").toString();
			if(mainF.equals("1")||mainF.equalsIgnoreCase("true")){
				mf = 1;
				logger.debug("只读取主诊断");
			}else{
				logger.debug("读取全部诊断" );
			}
		}else{
			logger.debug("读取全部诊断" );
		}
		
		
		List<DiEntity> dibdis = cusDiDao.selectByEnSn(enSn, orgCode, mf);
		int total = 0 ;
		if(null != dibdis && !dibdis.isEmpty()){
			DiagnosisModel[] voArray = new DiagnosisModel[dibdis.size()];
			total = dibdis.size() ;
			for (int index = 0; index < dibdis.size() ; index++) {
				DiEntity di = dibdis.get(index);
				DiagnosisModel m = trans2DiagnosisModel(di,index);
				voArray[index] = m ;
			}
			builder.withData(voArray);
		}
		ArrayResult<DiagnosisModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	
	}
	public DiagnosisModel trans2DiagnosisModel(DiEntity di,int index) {
		DiagnosisModel m = new DiagnosisModel();
		m.setAddInfo(di.getAddDescr());
		m.setDiCd(di.getDiCd());
		m.setDiDeptCd(di.getDiDeptCd());
		m.setDiNm(di.getDiNm());
		m.setDiPk(di.getDiSn());
		m.setDiTime(di.getDiTime());
		m.setDiUserId(di.getDiEmpId());
		m.setEnPk(di.getEnSn());
		m.setIcdCd(di.getIcdCd());
		m.setLongDiNm(String.valueOf(index)+"."+m.getDiNm());
		m.setLvl1SortNo(String.valueOf(di.getLvl1SortNo()));
		m.setLvl2SortNo(String.valueOf(di.getLvl2SortNo()));
		m.setMainF(String.valueOf(di.getMainF()));
		m.setNumber(index);
		m.setParDiPk(di.getParDiSn());
		m.setUncF(String.valueOf(di.getUncertainF()));
		m.setUnkF(String.valueOf(di.getUnknowF()));
		if(di.getUncertainF().intValue()==1){
			m.setLongDiNm(m.getLongDiNm()+"（？）");
		}
		if(di.getUnknowF().intValue()==1){
			m.setLongDiNm(m.getLongDiNm()+"（待查）"); 
		}
		return m;
	}

}
