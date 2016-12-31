/**
 * <p>文件名:		KrServiceImpl.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package iih.kr.service.impl;

import iih.kr.db.cs.dao.CusDiSuiteEntityDao;
import iih.kr.db.cs.dao.CusDiSuiteTpEntityDao;
import iih.kr.db.cs.dao.KrDao;
import iih.kr.db.cs.entity.DbDateEntity;
import iih.kr.db.cs.entity.DiSuiteModelEntity;
import iih.kr.db.cs.entity.MdDiSimpleEntity;
import iih.kr.db.cs.entity.MrTplSimpleEntity;
import iih.kr.db.gen.dao.DiSuiteDiEntityDao;
import iih.kr.db.gen.dao.DiSuiteEntityDao;
import iih.kr.db.gen.dao.DiSuiteShareEntityDao;
import iih.kr.db.gen.dao.DiSuiteTemplateEntityDao;
import iih.kr.db.gen.dao.DiSuiteTpEntityDao;
import iih.kr.db.gen.dao.MrTplEntityDao;
import iih.kr.db.gen.entity.DiSuiteDiEntity;
import iih.kr.db.gen.entity.DiSuiteEntity;
import iih.kr.db.gen.entity.DiSuiteShareEntity;
import iih.kr.db.gen.entity.DiSuiteTemplateEntity;
import iih.kr.db.gen.entity.DiSuiteTpEntity;
import iih.kr.db.gen.entity.MrTplEntity;
import iih.kr.model.DbDateModel;
import iih.kr.model.Dept;
import iih.kr.model.DiSuiteCommitModel;
import iih.kr.model.DiSuiteTreeNodeModel;
import iih.kr.model.DiSuiteTypeCommitModel;
import iih.kr.model.DiSuiteTypeModel;
import iih.kr.model.DiSuiteViewModel;
import iih.kr.model.MessageCode;
import iih.kr.model.RelDiModelSimple;
import iih.kr.model.RelMrTemplateModelSimple;
import iih.kr.model.ShareDeptModel;
import iih.kr.service.intf.KrService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import pkuhit.iih.di.md.DiagnosisDict;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectService;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ac.Session;
import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRole;
import pkuhit.xap.ac.UserRoleService;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.util.UUIDGenerator;

/**
 * <p>
 * KrServiceImpl
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
 *          <td>2014年8月22日 上午9:43:04</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class KrServiceImpl implements KrService {

	final static Logger logger = LoggerFactory.getLogger(KrServiceImpl.class);
	
	final String NULL_STRING = "null";
	final String ROLE_QY = "0001";//全院组套管理员角色
	final String ROLE_KS = "0002";//科室组套管理员角色
	@Autowired
	private DiSuiteTpEntityDao genDiSuiteTpDao; //自动生成分类dao
	
	@Autowired
	private CusDiSuiteTpEntityDao cusDiSuiteTpDao ;//自定义分类dao
	
	@Autowired
	private DiSuiteEntityDao genDiSuiteDao; //自动生成分类与诊断关系dao
	
	@Autowired
	private CusDiSuiteEntityDao cusDiSuiteDao; //自定义分类与诊断关系dao
	
	@Autowired
	private DiSuiteDiEntityDao  genDiSuiteDiDao ;// 诊断关系dao
	
	@Autowired
	private DiSuiteTemplateEntityDao genDiSuiteTemplateDao ;//诊断和病历模板关系
	
	@Autowired
	private DiSuiteShareEntityDao diSuiteShareDao ;// 共享给其他所属的组套
	@Autowired
	private MrTplEntityDao mrTplEntityDao ;//病历模板dao
	/*@Autowired
	 userRoleEntityDao ;// 用户角色关系表
	/*	@Autowired
	UserManageDeptEntityDao userManageDeptEntityDao;//用户管理组套的科室列表dao
*/	
	@Autowired
	private KrDao dao;
	
	@Reference
	OrganizationService  organizationService ; //从his读取科室列表的服务接口，调用存储过程
	
	@Reference
	UserRoleService userRoleService;
	
	
	public final String ORG_TEMPLATE_ROLE = "XAPM14.11" ; //全院模板管理员
	
	public final String DEPT_TEMPLATE_ROLE = "XAPM14.12" ; //科室模板管理员
	
	@Reference
	DictionaryService dictionaryService; //字典服务
	
	@Reference
	DataObjectService dataObjectService;

	/**
	 * 构造器
	 */
	public KrServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see iih.kr.cs.service.intf.KrService#csas(java.util.Map)
	 */
	@Override
	public ArrayResult<DiSuiteTreeNodeModel> csas(Map map) {//List<CsasDeptKrModel>
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");

		if(null == ownerType){
			generateFailure("csasCategoryList","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("csasCategoryList","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if( null == enTypeCode ){
			generateFailure("csasCategoryList","就诊类型");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		String orgCode = Session.get().getOrgCd();
		logger.debug("orgCode:"+orgCode);
		ArrayResultBuilder<DiSuiteTreeNodeModel> builder = ArrayResultBuilder.newArrayResult(DiSuiteTreeNodeModel.class);
		if(null == enTypeCode  || null == ownerType || null == ownerCode){
			logger.info("null == enTypeCode  || null == ownerType || null == ownerCode");
			ArrayResult<DiSuiteTreeNodeModel> rs = builder.build();
			rs.setTotal(0);
		}
		logger.debug("ownerType:"+ownerType+"|ownerCode"+ownerCode+"|enTypeCode"+enTypeCode);
		//读取自己所属的组套
		List<DiSuiteModelEntity> krs = dao.selectDiSuiteEntities(ownerType, ownerCode, orgCode,enTypeCode);
		if(null == krs){
			logger.debug("null == krs");
		}else{
			logger.debug("krs size"+krs.size());
		}
		//List<String> list = new ArrayList<String>();
		//组套 自定义分类节点
		Map<String,DiSuiteTreeNodeModel> mapKr = new HashMap<String,DiSuiteTreeNodeModel>();
		
		List<DiSuiteTreeNodeModel> krbeans = new ArrayList<DiSuiteTreeNodeModel>();
		logger.debug("csas——组套：所属编码："+ownerCode);
		//组套的所属编码对应的名称，当为本科室和个人时忽略
		String ownerName = null ;
		AppendTree(mapKr,krbeans,krs,orgCode,ownerType,ownerCode,ownerName);
		//读取其他科室(个人)分享的组套
		List<DiSuiteShareEntity> sharedKrOwner = dao.getSharedKr(null, null, ownerType, ownerCode);
		for(DiSuiteShareEntity sd :sharedKrOwner){
			List<DiSuiteModelEntity> krSharedList = dao
					.selectDiSuiteEntities(sd.getOwnerTypeCd(), sd.getOwnerCd(), orgCode,enTypeCode);
			logger.debug("csas——追加组套——共享源：所属编码："+sd.getOwnerCd());
			AppendTree(mapKr,krbeans,krSharedList,orgCode,sd.getOwnerTypeCd(), sd.getOwnerCd(),sd.getShareNm());
		}
		
		if(!krbeans.isEmpty()){
			DiSuiteTreeNodeModel[] array = new DiSuiteTreeNodeModel[krbeans.size()];
			krbeans.toArray(array);
			builder.withData(array);
		}
		ArrayResult<DiSuiteTreeNodeModel> rs = builder.build();
		return rs; 
	}
	

	@Override
	public DbDateModel sysdate() {
			DbDateEntity e = dao.sysdate();
			DbDateModel m = new DbDateModel();
			m.setSysdateStr(e.getSysdateStr());
			m.setSystimestamp(e.getSystimestamp());
			m.setSystsStr(e.getSystsStr());
			SimpleDateFormat sdfmr = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm");
			m.setMrTime(sdfmr.format((m.getSystimestamp())));
			return m;
	}

	private void AppendTree(Map<String, DiSuiteTreeNodeModel> mapKr, List<DiSuiteTreeNodeModel> krbeans,List<DiSuiteModelEntity> krSharedList,String orgCode,String ownerType,String ownerCode,String ownerName) {
		logger.debug("追加组套");
		for (DiSuiteModelEntity e : krSharedList) {
			DiSuiteTreeNodeModel diSuiteType = null;
			
			String krName = e.getDiSuiteTypeName();
			String krCode = e.getDiSuiteTypeCode();
			if(null != ownerName){
				krName = krName + "-"+ownerName+"共享";
			}
			if (!mapKr.containsKey(krCode)) {
				diSuiteType = new DiSuiteTreeNodeModel();
				diSuiteType.setDiSuiteTypeName(krName);
				diSuiteType.setDiSuiteTypeCode(krCode);
				diSuiteType.setId(krCode);
				diSuiteType.setText(krName);
				krbeans.add(diSuiteType);
			}else{
				diSuiteType = mapKr.get(krCode) ;
			}
			DiSuiteTreeNodeModel diSuite = new DiSuiteTreeNodeModel();
			diSuite.setDiSuiteCode(e.getDiSuiteCode());
			diSuite.setId(e.getDiSuiteCode());//id 为 自定义分类和组套关系主键
			diSuite.setText(e.getDiName());//诊断名称
			diSuite.setDiSuiteTypeCode(krCode);//自定义分类编码
			diSuite.setOrgCode(orgCode);
			diSuite.setOwnerCode(ownerCode);//所属编码
			diSuite.setOwnerType(ownerType);//所属类型
			diSuite.setDiCode(e.getDiCode());//诊断编码
			diSuite.setDiName(e.getDiName());//诊断名称
			List<DiSuiteTreeNodeModel> children = diSuiteType.getChildren() ;
			if( null == children){
				children = new ArrayList<DiSuiteTreeNodeModel>();
			}
			children.add(diSuite);
			diSuiteType.setChildren(children);
			mapKr.put(krCode, diSuiteType);
		}
	}
	

	
	/**
	 * 组套列表---查询 组套 的关联诊断列表
	 * 
	 * @param map map:{diSuiteCode:'123'} 
	 * @return
	 */
	@Override
	public ArrayResult<RelDiModelSimple> disListBrowse(Map map) {
		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		logger.debug("diSuiteCode:"+diSuiteCode);
		//获取自定义分类编码
		if(null == diSuiteCode ){
			generateFailure("csasCategoryCreate","组套编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
			throw new NotificationException(notification);
		}
		ArrayResultBuilder<RelDiModelSimple> builder = ArrayResultBuilder.newArrayResult(RelDiModelSimple.class);
		int total = 0;
		List<DiSuiteDiEntity> rsEntity = dao.selectRelDiByDiSuite(diSuiteCode);
		if(null == rsEntity ){
			logger.info("diSuiteCode："+ diSuiteCode + "| 关联诊断列表为 null");
			ArrayResult<RelDiModelSimple> rs = builder.build();
			rs.setTotal(0);
			return rs;
		}else{
			if(rsEntity.isEmpty()){
				logger.info("diSuiteCode："+ diSuiteCode + "|  关联诊断列表为空");
				ArrayResult<RelDiModelSimple> rs = builder.build();
				rs.setTotal(0);
				return rs;
			}else{
				logger.debug("diSuiteCode："+ diSuiteCode + "|  关联 诊断数量为"+rsEntity.size());
				RelDiModelSimple[] array = new RelDiModelSimple[rsEntity.size()];
				Session session = Session.get();
				logger.debug("ownerCode:"+session.getUserId()+"|ownerName:"+session.getUserName()+"|deptCode:"+session.getDeptId()+"|deptName:"+session.getDeptName());
				int i = 0 ;
				total = rsEntity.size() ;
				for(DiSuiteDiEntity tpl : rsEntity ){
					String relDiCode = tpl.getRelDiCd();
					String relDiName = tpl.getRelDiNm();
					String icdCode = tpl.getRelDiIcd();
					String creatId = tpl.getCrtUserId();
					int sortNo = tpl.getSortNo();
					logger.debug("diSuiteCode："+ diSuiteCode + "|relDiCode_"+relDiCode+"|relDiName_"+relDiName+"|icdCode_"+icdCode+"|creatId_"+creatId); 
					RelDiModelSimple relDiModel = new RelDiModelSimple(tpl.getDiSuiteDiCd(),relDiCode, relDiName, icdCode, sortNo);
					relDiModel.setOwnerType(tpl.getOwnerTypeCode());
					relDiModel.setOwnerCode(tpl.getOwnerCode());
					array[i] = relDiModel ;
					i++;
				}
				
				builder.withData(array);
				ArrayResult<RelDiModelSimple> rs = builder.build();
				rs.setTotal(total);
			}
		}
		ArrayResult<RelDiModelSimple> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	/**
	 * 组套列表---查询 组套 关联的病历列表
	 * @param map map:{orgCode:'SZLH',ownerType:'所属类型编码',ownerCode:'a1058', diSuiteTypeCode:'1001',categoryName:'a',diCode:'1030',diName:'诊断名称'}
	 * @return
	 */
	@Override
	public ArrayResult<RelMrTemplateModelSimple> mrTemplateListBrowse(Map map) {
		String orgCode = Session.get().getOrgCd();		
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
	//	String diSuiteTypeCode = getValueFromMap(map,"diSuiteTypeCode","自定义分类编码");
		String diCode = getValueFromMap(map,"diCode","诊断编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		
		ArrayResultBuilder<RelMrTemplateModelSimple> builder = ArrayResultBuilder.newArrayResult(RelMrTemplateModelSimple.class);
		int total = 0;
		if(null == diSuiteCode ){
			logger.debug("null == diSuiteCode");
			if( !StringUtils.isBlank(diCode) && diCode.equalsIgnoreCase("*")){
				logger.debug("!StringUtils.isBlank(diCode) && diCode.equalsIgnoreCase(\"*\")");
				if( null == ownerCode || null == ownerType || null == enTypeCode){
					generateFailure("mrTemplateListBrowse","就诊类型、所属类型编码或所属编码");	
					Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型、所属类型编码或所属编码");
					throw new NotificationException(notification);
				}
				List<MrTplEntity> list = dao.selectCOmmonMrDoc(ownerType, ownerCode,enTypeCode);
				if(null == list ){
					logger.info("orgCode_"+orgCode+"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|diCode_"+diCode+"| 关联病历列表为 null");
				}else{
					if(list.isEmpty()){
						logger.info("orgCode_"+orgCode+"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|diCode_"+diCode+"| 关联病历列表为空");
					}else{
						logger.debug("orgCode_"+orgCode+"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|diCode_"+diCode+"| 关联 病历列表数量为"+list.size());
						RelMrTemplateModelSimple[] array = new RelMrTemplateModelSimple[list.size()];
						Integer i = 0 ;
						for(MrTplEntity  mr : list){
							RelMrTemplateModelSimple model = new RelMrTemplateModelSimple( mr.getMrTplCd(), mr.getNm(),mr.getFilePk(),mr.getMrTpCd(), ownerType, ownerCode, i, this.getOwnerName(mr.getOwnTpCd(),null),false);
							logger.debug("orgCode_"+orgCode+"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|diCode_"+diCode+"|relMrTemplateCode_"+mr.getMrTplCd()+"|relMrTemplateName_"+mr.getNm()+"|creatId_"+mr.getCrtUserId());
							array[i] = model ;
							i++;
						}
						builder.withData(array);
						total = list.size() ;
					}
				}
			}else{
					 generateFailure("mrTemplateListBrowse","诊断编码");
					 return builder.build() ;
			}
		}
		else
		{
			logger.debug("diSuiteCode:"+diSuiteCode);
			//获取自定义分类编码
			if(null == diSuiteCode ){
				generateFailure("csasCategoryCreate","组套编码");
				Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
				throw new NotificationException(notification);
			}
			List<DiSuiteTemplateEntity> list = dao.selectRelMrDocByDiSuite(diSuiteCode);
			if(null == list ){
				logger.info("diSuiteCode:"+diSuiteCode+"| 关联病历列表为 null");
			}else{
				if(list.isEmpty()){
					logger.info("diSuiteCode:"+diSuiteCode+"|  关联病历列表为空");
				}else{
					logger.debug("diSuiteCode:"+diSuiteCode+"|  关联 病历列表数量为"+list.size());
					RelMrTemplateModelSimple[] array = new RelMrTemplateModelSimple[list.size()];
					int i = 0 ;
					for(DiSuiteTemplateEntity  mr : list){
						Session session = Session.get();
						MrTplEntity mrTplEntity=mrTplEntityDao.selectById(mr.getMrTemplateCd());
						logger.debug("ownerCode:"+session.getUserId()+"|ownerName:"+session.getUserName()+"|deptCode:"+session.getDeptId()+"|deptName:"+session.getDeptName());
						RelMrTemplateModelSimple model = new RelMrTemplateModelSimple( mr.getMrTemplateCd(), mr.getMrTemplateNm(),mrTplEntity.getFilePk(),mrTplEntity.getMrTpCd(), ownerType, ownerCode,mr.getSortNo(), mr.getOwnerNm(),false);
						logger.debug("diSuiteCode:"+diSuiteCode+"| relMrTemplateCode_"+mr.getMrTemplateCd()+"|relMrTemplateName_"+mr.getMrTemplateNm()+"|creatId_"+mr.getCrtUserId());
						array[i] = model ;
						i++;
					}
					total = list.size() ;
					builder.withData(array);
				}
			}
		}
		ArrayResult<RelMrTemplateModelSimple> rs = builder.build();
		rs.setTotal(total);
		return rs ;
	}

	/**
	 * 组套列表管理
	 * 
	 * */
	@Override
	public ArrayResult<Dept> csasDeptListForAdmin(Map map) {
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		ArrayResultBuilder<Dept> builder = ArrayResultBuilder.newArrayResult(Dept.class);
		if( null == enTypeCode ){
			generateFailure("csasDeptListForAdmin","就诊类型");
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		Dept[] deptList = null ;
		Session session = Session.get() ;
		String userId = session.getUserId();
		Map<String, String> params = new HashMap<String, String>();
		logger.debug("userId:"+userId);
		params.put("userId", userId);
		//params.put("orgCode", orgCode);
    	int total = 0;
    	/**
    	 * 根据操作人的角色列举他的科室
    	 * 如果是全院模板管理员角色，能浏览全院、所有科室、他本人的模板，可以管理全院、所有科室、他本人的模板
    	 * 如果是临床医生，能浏览全院、出诊科室、他本人的模板，可以管理全院、角色配置的科室、他本人的模板
    	 * */
    	List<String> deptCodeForRole = new ArrayList<String>(); 
    	List<String> deptNameForRole = new ArrayList<String>(); 
		ArrayResult<UserRole> results = userRoleService.search(params);
		List<String> maxUserRoleList = new ArrayList<String>(); 
		if (results != null && results.hasData()) {
			UserRole[] userRoles = results.getDataList();
			//遍历所有的角色，找到相关角色
			for(int i = 0 ; i < userRoles.length ; i++){
        		UserRole ur = userRoles[i] ;
        		if(ORG_TEMPLATE_ROLE.equalsIgnoreCase(ur.getRoleCode())){
        			//能浏览全院、所有科室、他本人的模板
        			/*获得所有业务科室*/
        			maxUserRoleList.add(ORG_TEMPLATE_ROLE);
        			logger.debug("ORG_TEMPLATE_ROLE is exist");
        		}else if(DEPT_TEMPLATE_ROLE.equalsIgnoreCase(ur.getRoleCode())){
        			//maxUserRoleList.add(ORG_TEMPLATE_ROLE);
        			//科室管理员，可以看到自己管理的科室
        		    deptCodeForRole.add(ur.getOrganizationCode()); 
        			deptNameForRole.add(ur.getOrganizationName());
        			logger.debug("DEPT_TEMPLATE_ROLE is exist,deptCode:"+ur.getOrganizationCode()+",deptName"+ur.getOrganizationName());

        		}
			}
			if(maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){
				logger.debug("ORG_TEMPLATE_ROLE is exist");
				//能浏览全院、所有科室、他本人的模板
    			/*获得所有业务科室*/
    			String deptCode = null ;
    			String deptTypeCode = ParameterUtils.enType2DeptType(enTypeCode) ;
    			ArrayResult<Organization> resultsD = organizationService.searchAllWardDept(deptCode, deptTypeCode);
    			if (resultsD != null && resultsD.hasData()) {
    				Organization[] orgs = resultsD.getDataList();
    				deptList = new Dept[orgs.length];
    	        	for(int j=0;j<orgs.length;j++){
    	        		Organization org = orgs[j];
    	        		Dept dept = new Dept();
    	        		dept.setDeptCode(org.getCode());
    	        		dept.setDeptName(org.getName());
    	        		deptList[j] = dept ;
    	        		logger.debug("索引为"+ j +"个，deptCode为"+deptCode+",deptName为"+org.getName());
    	        	}
    	        	builder.withData(deptList);
    	        	total = orgs.length ;
    			}
			}else {
    			/*树上的科室列表 应该为  科室管理员的管理科室 */
				
				deptList = new Dept[deptCodeForRole.size()];
            	for(int m = 0 ; m < deptCodeForRole.size() ; m++){
            		String deptCode = deptCodeForRole.get(m) ;
	        		Dept dept = new Dept();
	        		dept.setDeptCode(deptCode);
	        		dept.setDeptName(deptNameForRole.get(m));
	        		logger.debug("索引为"+m+"个，deptCode为"+deptCode+",deptName为"+deptNameForRole.get(m));
	        		deptList[m] = dept ;
            	}
            	total = deptCodeForRole.size() ;
            	builder.withData(deptList);
			}
		}
		ArrayResult<Dept> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}
	/**
	 * 组套列表管理---以自定义分类为主
	 * 
	 * */
	@Override
	public ArrayResult<DiSuiteTreeNodeModel> csasForAdmin(Map map) {
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		String orgCode = Session.get().getOrgCd();
		ArrayResultBuilder<DiSuiteTreeNodeModel> builder = ArrayResultBuilder.newArrayResult(DiSuiteTreeNodeModel.class);
		if(null == enTypeCode  || null == ownerType || null == ownerCode){
			generateFailure("csasForAdmin","就诊类型、所属类型编码或所属编码");
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型、所属类型编码或所属编码");
			throw new NotificationException(notification);
		}
		int total = 0;
		List<DiSuiteTreeNodeModel> list  = getcsasForAdmin(orgCode,ownerType,ownerCode,enTypeCode);
		if(null != list && !list.isEmpty()){
			DiSuiteTreeNodeModel[] array = new DiSuiteTreeNodeModel[list.size()];
			list.toArray(array);
			builder.withData(array);
			total = list.size() ;
		}
		ArrayResult<DiSuiteTreeNodeModel> rs = builder.build();
		rs.setTotal(total);
		return rs; 
	}
	
	private List<DiSuiteTreeNodeModel> getcsasForAdmin(String orgCode, String ownerType,
			String ownerCode ,String enTypeCode) {
		List<DiSuiteModelEntity> krs = dao
				.selectDiSuiteEntitiesForAdmin(orgCode,ownerType, ownerCode,enTypeCode);
		//组套 自定义分类节点
		Map<String,DiSuiteTreeNodeModel> mapKr = new HashMap<String,DiSuiteTreeNodeModel>();
		List<DiSuiteTreeNodeModel> krbeans = new ArrayList<DiSuiteTreeNodeModel>();
		logger.debug("csas——组套：所属编码："+ownerCode);
		//组套的所属编码对应的名称，当为本科室和个人时忽略
		String ownerName = null ;
		AppendTree(mapKr,krbeans,krs,orgCode,ownerType,ownerCode,ownerName);
		return krbeans;
	}
		
		@Override		
		public SingleResult<Boolean> csasCategoryHasPriToCreate(@RequestParam Map map){
			String orgCode = Session.get().getOrgCd();
			String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
			String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
			String diSuiteTypeName = getValueFromMap(map,"diSuiteTypeName","自定义分类名称");
			String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");

			if(null == diSuiteTypeName ){
				generateFailure("csasCategoryCreate","自定义分类名称");	
				Notification notification = new Notification(MessageCode.MISS_PARAM, "自定义分类名称");
				throw new NotificationException(notification);
			}
			if(null == ownerType){
				generateFailure("csasCategoryCreate","所属类型编码");	
				Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
				throw new NotificationException(notification);
			}
			if( null == ownerCode ){
				generateFailure("csasCategoryCreate","所属编码");		
				Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
				throw new NotificationException(notification);
			}
			if( null == enTypeCode ){
				generateFailure("csasCategoryCreate","就诊类型");		
				Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
				throw new NotificationException(notification);
			}
			SingleResultBuilder<Boolean> builder = SingleResultBuilder
					.newSingleResult(Boolean.class);
			Boolean notExist = Boolean.TRUE ;
			//String selectCountOfCategoryName = dao.selectCountOfCategoryName(categoryName);
			int count = dao.selectCountOfCategoryName(diSuiteTypeName,orgCode,ownerType,ownerCode,enTypeCode);
			if(count > 0){
				notExist = Boolean.FALSE ;
			}
			builder.withData(notExist);
			SingleResult<Boolean> rs = builder.build();
			return rs;
		}
		
	/**
	 * 组套列表---添加自定义分类节点
	 * @param map  map:{ownerType:'所属类型编码',ownerCode:'a1058',categoryName:'a'} 
	 * @return   map：
	 *   添加失败 {success："false",message, "添加失败"} 
	 *   或者 添加成功，组套列表为空  {success："true",message, "添加成功",dataList:null}
	 *   或者 添加成功，组套列表  {success："true",message, "添加成功",dataList:[{},{}]}
	 */
	@Override
	public SingleResult<DiSuiteTypeModel> csasCategoryCreate(Map map) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String diSuiteTypeName = getValueFromMap(map,"diSuiteTypeName","自定义分类名称");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");

		if(null == diSuiteTypeName ){
			generateFailure("csasCategoryCreate","自定义分类名称");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "自定义分类名称");
			throw new NotificationException(notification);
		}
		if(null == ownerType){
			generateFailure("csasCategoryCreate","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("csasCategoryCreate","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if( null == enTypeCode ){
			generateFailure("csasCategoryCreate","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}

		DiSuiteTpEntity diSuiteTypeEntity = new DiSuiteTpEntity();
		String diSuiteTypeCode = UUIDGenerator.getUUID() ;
		diSuiteTypeEntity.setDiSuiteTpCd(diSuiteTypeCode);//自定义分类编码
		diSuiteTypeEntity.setDiSuiteTpNm(diSuiteTypeName);//自定义分类名称
		diSuiteTypeEntity.setOrgCd(orgCode);//组织机构
		int maxSortNo = dao.selectMaxSortNoForCC(orgCode,ownerType,ownerCode,enTypeCode);
		diSuiteTypeEntity.setSortNo(maxSortNo+1);//顺序号
		diSuiteTypeEntity.setDescr(diSuiteTypeName);//描述
		diSuiteTypeEntity.setOwnerTypeCd(ownerType);
		diSuiteTypeEntity.setOwnerCd(ownerCode);
		diSuiteTypeEntity.setEnTypeCode(enTypeCode);
		logger.debug("添加自定义分类dao start");
		int result = genDiSuiteTpDao.insert(diSuiteTypeEntity);
		if(result > 0){
			logger.debug("添加自定义分类成功");
		}
		logger.debug("添加自定义分类dao end");
		DiSuiteTypeModel model = new DiSuiteTypeModel();
		model.setDiSuiteTpCd(diSuiteTypeCode);
		model.setDiSuiteTpNm(diSuiteTypeName);
		model.setOwnerCd(ownerCode);
		model.setOwnerTypeCd(ownerType);
		model.setSortNo(maxSortNo + 1);
		SingleResultBuilder<DiSuiteTypeModel> builder = SingleResultBuilder
				.newSingleResult(DiSuiteTypeModel.class);
		builder.withData(model);
		SingleResult<DiSuiteTypeModel> rs = builder.build();
		return rs;
	}
	

	/**
	 * 组套列表---删除自定义分类节点
	 * @param map   map:{orgCode:'SZLH',ownerType:'所属类型编码',ownerCode:'a1058',diSuiteTypeCode:'1001'} 
	 * @return
	 */
	@Override
	public SingleResult<Boolean> csasCategoryDelete(Map map) {
		String diSuiteTypeCode = getValueFromMap(map,"diSuiteTypeCode","自定义分类编码");
		//获取自定义分类编码
		if(null == diSuiteTypeCode ){
			generateFailure("csasCategoryCreate","自定义分类编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "自定义分类编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		//String selectCountOfCategoryName = dao.selectCountOfCategoryName(categoryName);
		logger.debug("diSuiteTypeCode:"+diSuiteTypeCode);
		//判断是否是以字符串分隔
		if (diSuiteTypeCode.contains(",")) {
			String[] idArr = diSuiteTypeCode.split(",");
			logger.debug("预删除"+idArr.length+"个");
			int total = 0 ;
			for(int j = 0 ; j < idArr.length ; j ++){
				String id = idArr[j] ;
				if(!StringUtils.isBlank(id)){
					int i = deleteCategoryById(id);
					logger.debug("删除索引为第:"+j+"个，id为"+id+",结果为"+i);
					total = total + i;
				}
			}
			logger.debug("成功删除"+total+"个");
			if(total == idArr.length){
				logger.debug("全部成功删除");
			}
		}else{
			int i = deleteCategoryById(diSuiteTypeCode);
			if(i == 1){
			}else{
				success = Boolean.FALSE;
			}
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;		
	}
	private int deleteCategoryById(String diSuiteTypeCode){
		logger.debug("diSuiteTypeCode:"+diSuiteTypeCode);
		DiSuiteTpEntity entity = this.genDiSuiteTpDao.selectById(diSuiteTypeCode);
		if(null == entity){
			logger.info("null == entity,diSuiteTypeCode:"+diSuiteTypeCode);
			return 0;
		}
		/**
		 * 删除自定义分类和诊断的关系
		 * */
		String ownerType = entity.getOwnerTypeCd();
		String ownerCode = entity.getOwnerCd() ;
		String orgCode = entity.getOrgCd();
		String enTypeCode = entity.getEnTypeCode() ;
		List<DiSuiteEntity> list = dao.selectCcdByCategoryCode(ownerType, ownerCode, orgCode, diSuiteTypeCode,enTypeCode);
		if(list == null){
			logger.debug("csasCategoryDelete_该所属类型 所属编码下的  自定义分类与诊断的关系  列表为null" );
		}else{
			logger.debug("csasCategoryDelete_该所属类型 所属编码下的  自定义分类与诊断的关系  列表数量为"+list.size() );
			if(!list.isEmpty()){
				logger.debug("csasCategoryDelete_删除自定义和诊断关系start");
				for(DiSuiteEntity ccdd :list){
					Map mapToDelete = new HashMap();
					mapToDelete.put("diSuiteCode", ccdd.getDiSuiteCd());
					this.DiSuiteDelete(mapToDelete);
				}
			}
		}
		entity.setDelF(Short.valueOf("1"));
		int i = this.genDiSuiteTpDao.markDelete(entity);
		return i;
	}

	@Override
	public SingleResult<Boolean> DiSuiteCanCreate(Map map) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String diSuiteTypeCode = getValueFromMap(map,"diSuiteTypeCode","自定义分类编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		String diCode=  getValueFromMap(map,"diCode","诊断编码");
		if(null == ownerType){
			generateFailure("DiSuiteSave","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("DiSuiteSave","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		
		if(null == diSuiteTypeCode ){
			generateFailure("DiSuiteSave","自定义分类编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "自定义分类编码");
			throw new NotificationException(notification);
		}

		if( null == enTypeCode ){
			generateFailure("DiSuiteSave","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		
		if( null == diCode ){
			generateFailure("DiSuiteSave","诊断编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "诊断编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean notExist = Boolean.TRUE ;
		int count = dao.selectCountOfDiSuite(orgCode,ownerType,ownerCode,diSuiteTypeCode,diCode,enTypeCode);
		if(count > 0){
			notExist = Boolean.FALSE ;
		}
		builder.withData(notExist);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}


	@Override
	public ArrayResult<RelMrTemplateModelSimple> mrTemplateList(Map map) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		if(null == ownerType){
			generateFailure("mrTemplateList","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("mrTemplateList","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		
		if( null == enTypeCode ){
			generateFailure("mrTemplateList","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		ArrayResultBuilder<RelMrTemplateModelSimple> builder = ArrayResultBuilder.newArrayResult(RelMrTemplateModelSimple.class);
		//该所属下的所有病历模板
		List<MrTplSimpleEntity> mrList = dao.selectAllMrTemplate(orgCode,ownerType, ownerCode,enTypeCode) ;//orgCode,ownerType, ownerCode,diSuiteTypeCode,diSuiteCode, enTypeCode) ;
		List<String> checkedList = null ;
		if(null != diSuiteCode ){
			//该组套关联的病历模板
			ArrayResult<RelMrTemplateModelSimple> mrTemplateListBrowse = mrTemplateListBrowse(map);
			RelMrTemplateModelSimple[] dataList = mrTemplateListBrowse.getDataList();
			//组套管理的病历模板code列表
			if(null != dataList && dataList.length > 0)
			{
				checkedList = new ArrayList<String>();
				for(int i = 0 ; i < dataList.length ; i ++){
					RelMrTemplateModelSimple s = dataList[i];
					checkedList.add(s.getMrTemplateCode());
				}
			}
		}
		int total = 0 ;
		if(null == mrList ){
			logger.debug(" 关联病历列表为 null");
		}else{
			if(mrList.isEmpty()){
				logger.debug("  关联病历列表为空");
			}else{
				logger.debug(" 关联 病历列表数量为"+mrList.size());
				RelMrTemplateModelSimple[] array = new RelMrTemplateModelSimple[mrList.size()];
				int i = 0 ;
				for(MrTplSimpleEntity  mr : mrList){
					String mrCode = mr.getMrTplCd() ;
					String mrName = mr.getNm() ;
					boolean isExist = false ;
					if(null != diSuiteCode  && null != checkedList && !checkedList.isEmpty() ){
						isExist = checkedList.contains(mrCode) ;
					}
					Session session = Session.get();
					logger.debug("ownerCode:"+session.getUserId()+"|ownerName:"+session.getUserName()+"|deptCode:"+session.getDeptId()+"|deptName:"+session.getDeptName());
					RelMrTemplateModelSimple model = new RelMrTemplateModelSimple( mrCode, mrName,mr.getFilePk(),mr.getMrTpCd(), ownerType, ownerCode,i, this.getOwnerName(ownerType, ownerCode),isExist);
					logger.debug("relMrTemplateCode_"+mrCode+"|relMrTemplateName_"+mrName);
					array[i] = model ;
					i++;
				}
				builder.withData(array);
				total = array.length ;
			}
		}
		ArrayResult<RelMrTemplateModelSimple> rs = builder.build();
		rs.setTotal(total);
		return rs ;
	}
	
	/**
	 * 组套列表---组套新建/修改
	 * @param map   map:{orgCode:'SZLH',ownerType:'所属类型编码',ownerCode:'a1058',diSuiteTypeCode:'1001',categoryName:'a',diCode:'1030',diName:'诊断名称'} 
	 * @return
	 */
	@Override
	public SingleResult<Boolean> DiSuiteSave(DiSuiteCommitModel model) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = model.getOwnerType();
		String ownerCode = model.getOwnerCode() ;
		String diSuiteTypeCode = model.getDiSuiteTypeCode();
		String enTypeCode = model.getEnTypeCode() ;
		String diSuiteCode = model.getDiSuiteCode() ;
		String diCode= model.getDiCode();
		String[] relDiList = model.getRelDiList() ;//关联诊断数组
		String[] relMrList = model.getRelMrList() ;//关联病历数组
		
		if(null == ownerType){
			generateFailure("DiSuiteSave","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("DiSuiteSave","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		
		if(null == diSuiteTypeCode ){
			generateFailure("DiSuiteSave","自定义分类编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "自定义分类编码");
			throw new NotificationException(notification);
		}

		if( null == enTypeCode ){
			generateFailure("DiSuiteSave","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		
		if( null == diCode ){
			generateFailure("DiSuiteSave","诊断编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "诊断编码");
			throw new NotificationException(notification);
		}
		
		if(null == relDiList || relDiList.length ==0){
			generateFailure("DiSuiteSave","关联诊断数组");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "关联诊断数组");
			throw new NotificationException(notification);
		}

		if( null == relMrList || relMrList.length ==0){
			generateFailure("DiSuiteSave","关联病历数组");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "关联病历数组");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		if(null == diSuiteCode ){
			logger.debug("开始创建组套：ownerType:"+"|ownerCode:"+ownerCode+"|diSuiteTypeCode:"+diSuiteTypeCode+"|enTypeCode:"+enTypeCode+"|diSuiteTypeCode:"+diSuiteTypeCode);
			DiSuiteEntity ds = new DiSuiteEntity();
			ds.setDiCd(diCode);
			diSuiteCode = UUIDGenerator.getUUID() ;
			ds.setDiSuiteCd(diSuiteCode);
			ds.setDiSuiteTpCd(diSuiteTypeCode);
			ds.setEnTypeCode(enTypeCode);
			ds.setOrgCd(orgCode);
			ds.setOwnerCd(ownerCode);
			ds.setOwnerTypeCd(ownerType);
			int i = this.genDiSuiteDao.insert(ds);
			if(i>0){
				logger.debug("组套创建成功");
			}
			model.setDiSuiteCode(diSuiteCode);
			relDisListSave(model);
			relMrTemplateListSave(model);
		}else{
			logger.debug("修改组套：diSuiteCode："+diSuiteCode+"|ownerType:"+"|ownerCode:"+ownerCode+"|diSuiteTypeCode:"+diSuiteTypeCode+"|enTypeCode:"+enTypeCode+"|diSuiteTypeCode:"+diSuiteTypeCode);
			DiSuiteEntity ds = genDiSuiteDao.selectById(diSuiteCode);
			boolean di_IsModified = false;
			if(!ds.getDiCd().equalsIgnoreCase(diCode)){
				ds.setDiCd(diCode);
				di_IsModified = true ;
			}
			boolean diSuiteTp_IsModified = false ;
			if(!ds.getDiSuiteTpCd().equalsIgnoreCase(diSuiteTypeCode)){
				ds.setDiSuiteTpCd(diSuiteTypeCode);
				diSuiteTp_IsModified = true ;
			}
			if(diSuiteTp_IsModified || di_IsModified){
				int i = this.genDiSuiteDao.update(ds);
				if(i > 0){
				logger.debug("组套修改成功");
				}
			}
			relDisListUpdate(model,di_IsModified,diSuiteTp_IsModified);
			relMrTemplateListUpdate(model,di_IsModified,diSuiteTp_IsModified);
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;
		
	}
	
	//@Override
	public SingleResult<Boolean> relDisListSave(DiSuiteCommitModel model) {
		String orgCode = Session.get().getOrgCd();
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		String[] relDiCodeList = model.getRelDiList();
/*		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
				DiagnosisDict.OBJ_CD, relDiCodeList);
		String[] diNameArray = null ;
		if (verify(simpleItems)) {
			diNameArray = new String[relDiCodeList.length];
			int i = 0;
			for (SimpleItem si : simpleItems) {
				String diName = si.getText();
				diNameArray[i] = diName;
			}
		}*/
		//关联诊断，去数据库查询名称和icd
		List<String> diCodesArray = Arrays.asList(relDiCodeList);
		List<String> diCodes = new ArrayList<String>(diCodesArray);
		if(!diCodes.contains(model.getDiCode())){
			diCodes.add(model.getDiCode()) ;
		}
		List<MdDiSimpleEntity> mdDiList = dao.selectMdDi(orgCode,diCodes);
		String[] diCodeDB = null ;
		String[] diNameDB = null ;
		String[] icdCdDB = null ;
		List<String> diCodeDBList = null;
		if(!mdDiList.isEmpty()){
			diCodeDB = new String[mdDiList.size()] ;
			diNameDB = new String[mdDiList.size()] ;
			icdCdDB = new String[mdDiList.size()] ;
			diCodeDBList= new ArrayList<String>(mdDiList.size());
		}
		//保存到数组
		for(int m = 0 ; m < mdDiList.size() ; m++){
			MdDiSimpleEntity mdDi  = mdDiList.get(m);
			diCodeDB[m] = mdDi.getDiCd() ;
			diNameDB[m] = mdDi.getDiNm() ;
			icdCdDB[m] = mdDi.getIcdCd() ;
			diCodeDBList.add(mdDi.getDiCd()) ;
		}
		String diName = null ;
		if(null != diCodeDBList && !diCodeDBList.isEmpty()){
			int index = diCodeDBList.indexOf(model.getDiCode());
			diName = diNameDB[index] ;
		}
		int maxSortNo = dao.selectMaxSortNoForRelDi(model.getDiSuiteCode());
		//开始遍历关联诊断，保存到数据库
		for(int j = 0 ; j< relDiCodeList.length ; j++){
			String relDiCode = relDiCodeList[j];
			DiSuiteDiEntity entity = new DiSuiteDiEntity();
			String diSuiteDiCd = UUIDGenerator.getUUID() ;
			entity.setDiSuiteDiCd(diSuiteDiCd);
			entity.setDiNm(diName);
			entity.setDiCd(model.getDiCode()); //诊断编码
			entity.setDiSuiteCd(model.getDiSuiteCode());
			entity.setDiSuiteTpCd(model.getDiSuiteTypeCode());
			entity.setEnTypeCode(model.getEnTypeCode());//就诊类型编码\
			entity.setOwnerTypeCode(model.getOwnerType());//所属类型
			entity.setOwnerCode(model.getOwnerCode());//所属编码
			entity.setOwnerName(getOwnerName(model.getOwnerType(), model.getOwnerCode()));
			entity.setRelDiCd(relDiCode);
			if(null != diCodeDBList && !diCodeDBList.isEmpty()){
				int index = diCodeDBList.indexOf(relDiCode);
				entity.setRelDiNm(diNameDB[index]);
				entity.setRelDiIcd(icdCdDB[index]);
			}
			maxSortNo++;
			entity.setSortNo( maxSortNo );//顺序号
			genDiSuiteDiDao.insert(entity);
			logger.debug("relDisListSave_插入成功：orgCode_"+orgCode+"|ownerType_"+model.getOwnerType()+"|ownerCode_"+model.getOwnerCode()+"|diCode_"+model.getDiCode()+"|relDiCode_"+relDiCode+"|diSuiteDiCd_"+diSuiteDiCd);
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
	
	/**
	 * 组套列表---为诊断添加关联病历列表
	 * 
	 * @param map  map:{orgCode:'SZLH',ownerType:'所属类型编码',ownerCode:'a1058', diSuiteTypeCode:'1001',categoryName:'a',diCode:'1030',diName:'诊断名称',relMrtemplatelist:[{mrTemplateCode:'1010',sortNo:'1'},{mrTemplateCode:'1040',sortNo:'2'}]}
	 * @return
   */
	//@Override
	public SingleResult<Boolean> relMrTemplateListSave(DiSuiteCommitModel model) {
		String orgCode = Session.get().getOrgCd();
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		String diCode = model.getDiCode();//诊断编码
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
				DiagnosisDict.OBJ_CD, diCode);
		String diName = null ;//诊断名称
		if (verify(simpleItems)) {
			diName = simpleItems[0].getText();
		}
		String[] relMrtemplatelist = model.getRelMrList();
		//关联病历模板，从数据库读取
		List<String> mrCodesArray = Arrays.asList(relMrtemplatelist);
		List<String> mrCodes = new ArrayList<String>(mrCodesArray);
		List<MrTplSimpleEntity> mrList = dao.selectMrTemplate(mrCodes);
		//保存到数组
		List<String> mrCodeDB = new ArrayList<String>(mrList.size());
		List<String> mrNameDB = new ArrayList<String>(mrList.size());
		for(int m = 0 ; m < mrList.size() ; m++){
			MrTplSimpleEntity mr  = mrList.get(m);
			mrCodeDB.add(mr.getMrTplCd());
			mrNameDB.add(mr.getNm());
		}
		int sortNo = dao.selectMaxSortNoForRelMr(model.getDiSuiteCode());
		for(String relMrTemplateCode :relMrtemplatelist){
			DiSuiteTemplateEntity entity = new DiSuiteTemplateEntity();
			entity.setDiCd(diCode);
			entity.setDiNm(diName);
			entity.setDiSuiteCd(model.getDiSuiteCode());
			String diSuiteTemplateCd = UUIDGenerator.getUUID() ;
			entity.setDiSuiteTemplateCd(diSuiteTemplateCd);
			entity.setDiSuiteTpCd(model.getDiSuiteTypeCode());
			entity.setMrTemplateCd(relMrTemplateCode);
			entity.setMrTemplateNm(mrNameDB.get(mrCodeDB.indexOf(relMrTemplateCode)));
			entity.setOwnerCd(model.getOwnerCode());
			entity.setOwnerNm(getOwnerName(model.getOwnerType(), model.getOwnerCode()));
			entity.setOwnerTypeCd(model.getOwnerType());
			entity.setEnTypeCode(model.getEnTypeCode());
			sortNo++;
			entity.setSortNo(sortNo);
			genDiSuiteTemplateDao.insert(entity);
			logger.debug("relMrTemplateListSave_插入成功：orgCode_"+orgCode+"|ownerType_"+model.getOwnerType()+"|ownerCode_"+model.getOwnerCode()+"|diCode_"+model.getDiCode()+"|mrTemplateCode_"+relMrTemplateCode);
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
	
	private void relDisListUpdate(DiSuiteCommitModel model,boolean di_IsModified,boolean diSuiteTp_IsModified) {
		String diSuiteCode = model.getDiSuiteCode() ;
		List<DiSuiteDiEntity> oldList = dao.selectRelDiByDiSuite(diSuiteCode);
		String[] newList = model.getRelDiList();
		if(null == oldList || oldList.isEmpty() ){
			logger.info("原诊断列表为空");
			if(null == newList || newList.length == 0 ){
				logger.info("新诊断列表为空");
			}else{
				relDisListSave(model);
				return ;
			}
		}
		if(null == newList || newList.length == 0 ){
			logger.info("新诊断列表为空");
			if(null == oldList || oldList.isEmpty() ){
				logger.info("原诊断列表为空");
				return ;
			}else{
				Map<String,String> param = new HashMap<String,String>();
				param.put("diSuiteCode", diSuiteCode);
				relDisListDeleteByDiSuite(param);
				return ;
			}
		}
		if(null != newList && newList.length > 0  && null != oldList && !oldList.isEmpty() ){
			//待删除的旧实体
			Map<String,DiSuiteDiEntity> oldMapTodelete = new HashMap<String,DiSuiteDiEntity>();
			List<DiSuiteDiEntity> oldMapToUpate = new ArrayList<DiSuiteDiEntity>();
			//待添加的新诊断
			List<String> newMap  = new ArrayList<String>();
			for(int i = 0 ; i < oldList.size() ; i++){
				//把全部就实体全部放入 待删除
				DiSuiteDiEntity dsd = oldList.get(i) ;
				logger.debug("old map,key:"+dsd.getRelDiCd());
				oldMapTodelete.put(dsd.getRelDiCd(), dsd);
			}
			for(int i = 0 ; i < newList.length ; i++){
				String newDiCd = newList[i];//新的诊断
				logger.debug("新诊断："+newDiCd);
				if(oldMapTodelete.containsKey(newDiCd)){
					//当新诊断在待删除实体中，则从待删除中移除
					logger.debug("oldMap.containsKey("+newDiCd+")");
					DiSuiteDiEntity ds = oldMapTodelete.get(newDiCd);
					oldMapToUpate.add(ds);
					oldMapTodelete.remove(newDiCd);
				}else{
					//当新诊断在待删除实体中，则添加到待添加的新诊断中
					logger.debug(newDiCd+"is not in oldMap");
					newMap.add(newDiCd);
				}
			}
			if(!oldMapTodelete.isEmpty()){
				Iterator<DiSuiteDiEntity> it = oldMapTodelete.values().iterator();
				while(it.hasNext()){
					DiSuiteDiEntity entity = it.next();
					entity.setDelF(Short.valueOf("1"));
					this.genDiSuiteDiDao.markDelete(entity);
				}
			}
			if(!oldMapToUpate.isEmpty() && (di_IsModified || diSuiteTp_IsModified)){
				for(DiSuiteDiEntity entity : oldMapToUpate){
					if(di_IsModified){
						entity.setDiCd(model.getDiCode());
						SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
								DiagnosisDict.OBJ_CD, model.getDiCode());
						if (verify(simpleItems)) {
							String diName = simpleItems[0].getText();
							entity.setDiNm(diName);
						}
					}
					if(diSuiteTp_IsModified){
						entity.setDiSuiteTpCd(model.getDiSuiteTypeCode());
					}
					genDiSuiteDiDao.update(entity);
				}
			}
			if(!newMap.isEmpty()){

				DiSuiteCommitModel modelClone = Clone(model) ;
				 String[] array = new String[newMap.size()];
				//设置新的诊断数组
				 modelClone.setRelDiList(newMap.toArray(array));
				 //保存新的诊断关联列表
				 relDisListSave(modelClone);

			}
		}
	}

	private DiSuiteCommitModel Clone(DiSuiteCommitModel model) {
		DiSuiteCommitModel clone = new DiSuiteCommitModel();
		clone.setDiCode(model.getDiCode());
		clone.setDiSuiteCode(model.getDiSuiteCode());
		clone.setDiSuiteTypeCode(model.getDiSuiteTypeCode());
		clone.setEnTypeCode(model.getEnTypeCode());
		clone.setOwnerCode(model.getOwnerCode());
		clone.setOwnerType(model.getOwnerType());
		clone.setRelDiList(model.getRelDiList());
		clone.setRelMrList(model.getRelMrList());
		return clone;
	}

	private void relMrTemplateListUpdate(DiSuiteCommitModel model,boolean di_IsModified,boolean diSuiteTp_IsModified) {
		
		String diSuiteCode = model.getDiSuiteCode() ;
		logger.debug("relMrTemplateListUpdate,diSuiteCode:"+diSuiteCode);
		List<DiSuiteTemplateEntity> oldList = dao.selectRelMrDocByDiSuite(diSuiteCode);
		String[] newList = model.getRelMrList();
		if(null == oldList || oldList.isEmpty() ){
			logger.info("原关联病历模板列表为空");
			if(null == newList || newList.length == 0 ){
				logger.info("新关联病历模板列表为空");
			}else{
				relDisListSave(model);
				return ;
			}
		}
		if(null == newList || newList.length == 0 ){
			logger.info("新关联病历模板列表为空");
			if(null == oldList || oldList.isEmpty() ){
				logger.info("原关联病历模板列表为空");
				return ;
			}else{
				Map<String,String> param = new HashMap<String,String>();
				param.put("diSuiteCode", diSuiteCode);
				relDisListDeleteByDiSuite(param);
				return ;
			}
		}
		if(null != newList && newList.length > 0  && null != oldList && !oldList.isEmpty() ){
			//待删除的旧实体
			Map<String,DiSuiteTemplateEntity> oldMapToDelete  = new HashMap<String,DiSuiteTemplateEntity>();
			List<DiSuiteTemplateEntity> oldMapToUpate = new ArrayList<DiSuiteTemplateEntity>();
			//待添加的新关联病历模板
			List<String> newMap  = new ArrayList<String>();
			for(int i = 0 ; i < oldList.size() ; i++){
				//把全部就实体全部放入 待删除
				DiSuiteTemplateEntity dst = oldList.get(i) ;
				logger.debug("old map,key:"+dst.getDiCd());
				oldMapToDelete.put(dst.getMrTemplateCd(), dst);
			}
			for(int i = 0 ; i < newList.length ; i++){
				String newDiCd = newList[i];//新的关联病历模板
				logger.debug("新关联病历模板："+newDiCd);
				if(oldMapToDelete.containsKey(newDiCd)){
					//当新关联病历模板在待删除实体中，则从待删除中移除
					logger.debug("oldMap.containsKey("+newDiCd+")");
					DiSuiteTemplateEntity diSuiteTemplateEntity = oldMapToDelete.get(newDiCd);
					oldMapToUpate.add(diSuiteTemplateEntity);
					oldMapToDelete.remove(newDiCd);
				}else{
					//当新关联病历模板在待删除实体中，则添加到待添加的新关联病历模板中
					logger.debug(newDiCd+"is not in oldMap");
					newMap.add(newDiCd);
				}
			}
			if(!oldMapToDelete.isEmpty()){
				Iterator<DiSuiteTemplateEntity> it = oldMapToDelete.values().iterator();
				while(it.hasNext()){
					DiSuiteTemplateEntity entity = it.next();
					entity.setDelF(Short.valueOf("1"));
					this.genDiSuiteTemplateDao.markDelete(entity);
				}
			}
			if(!oldMapToUpate.isEmpty() && (di_IsModified || diSuiteTp_IsModified)){
				for(DiSuiteTemplateEntity entity : oldMapToUpate){
					if(di_IsModified){
						entity.setDiCd(model.getDiCode());
						SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
								DiagnosisDict.OBJ_CD, model.getDiCode());
						if (verify(simpleItems)) {
							String diName = simpleItems[0].getText();
							entity.setDiNm(diName);
						}
					}
					if(diSuiteTp_IsModified){
						entity.setDiSuiteTpCd(model.getDiSuiteTypeCode());
					}
					this.genDiSuiteTemplateDao.update(entity);
				}
			}
			if(!newMap.isEmpty()){

				 DiSuiteCommitModel modelClone = Clone(model) ;
				 String[] array = new String[newMap.size()];
				//设置新的关联病历模板数组
				 modelClone.setRelMrList(newMap.toArray(array));
				 //保存新的关联病历模板关联列表
				 this.relMrTemplateListSave(modelClone);				 

			}
		}
	

	}

	public SingleResult<DiSuiteViewModel> DiSuiteView(String diSuiteCode){
		logger.debug("diSuiteCode:"+diSuiteCode);
		//获取自定义分类编码
		if(null == diSuiteCode ){
			generateFailure("DiSuiteView","组套编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<DiSuiteViewModel> builder = SingleResultBuilder
				.newSingleResult(DiSuiteViewModel.class);
		DiSuiteEntity entity = this.genDiSuiteDao.selectById(diSuiteCode);
		Map<String,String> param = new HashMap<String,String>();
		param.put("diSuiteCode",diSuiteCode);
		ArrayResult<RelDiModelSimple> disListBrowse = disListBrowse(param);
		ArrayResult<RelMrTemplateModelSimple> mrTemplateListBrowse = mrTemplateListBrowse(param);
		DiSuiteViewModel model = new DiSuiteViewModel();
		model.setDiCode(entity.getDiCd());
		model.setDiSuiteCode(entity.getDiSuiteCd());
		model.setDiSuiteTypeCode(entity.getDiSuiteTpCd());
		model.setEnTypeCode(entity.getEnTypeCode());
		model.setOwnerCode(entity.getOwnerCd());
		model.setOwnerType(entity.getOwnerTypeCd());
		model.setRelDiList(disListBrowse.getDataList());
		model.setRelMrList(mrTemplateListBrowse.getDataList());
		builder.withData(model);
		SingleResult<DiSuiteViewModel> rs = builder.build();
		return rs;	
		
	}
	
	/**
	 * 组套列表---删除组套,删除该诊断及关联诊断列表和病历列表
	 * @param map   map:{orgCode:'SZLH',ownerType:'所属类型编码',ownerCode:'a1058',diCustClaDiCi:'自定义分类和诊断关系主键'}
	 * @return
	 */
	@Override
	public SingleResult<Boolean> DiSuiteDelete(Map map) {
		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		logger.debug("diSuiteCode:"+diSuiteCode);
		//获取自定义分类编码
		if(null == diSuiteCode ){
			generateFailure("csasCategoryCreate","组套编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		//String selectCountOfCategoryName = dao.selectCountOfCategoryName(categoryName);
		DiSuiteEntity entity = this.genDiSuiteDao.selectById(diSuiteCode);
		if(null != entity){
			relDisListDeleteByDiSuite(map);//删除组套管理的诊断列表
			relMrTemplateListDelete(map);//删除组套关联的病历模板列表
			entity.setDelF(Short.valueOf("1"));
			int i = this.genDiSuiteDao.markDelete(entity);
			if(i == 1){
				
			}else{
				success =Boolean.FALSE ;
			}
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;			
	}

	@Override
	public SingleResult<Boolean> relDisListDeleteByDiSuite(Map map) {
		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		logger.debug("diSuiteCode:"+diSuiteCode);
		//获取自定义分类编码
		if(null == diSuiteCode ){
			generateFailure("csasCategoryCreate","组套编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		List<DiSuiteDiEntity> rsEntity = dao.selectRelDiByDiSuite(diSuiteCode);
		if(null == rsEntity ){
			success = Boolean.FALSE ;
			logger.debug("diSuiteCode："+ diSuiteCode + "| 关联诊断列表为 null");
		}else{
			if(rsEntity.isEmpty()){
				success = Boolean.FALSE ;
				logger.debug("diSuiteCode："+ diSuiteCode + "|  关联诊断列表为空");
			}else{
				logger.debug("diSuiteCode："+ diSuiteCode + "|  关联 诊断数量为"+rsEntity.size());
				int i = 1 ;
				for(DiSuiteDiEntity tpl : rsEntity ){
					logger.debug("diSuiteCode："+ diSuiteCode + "|第"+i+"个diSuiteDi——Code:"+tpl.getDiSuiteDiCd());
					i++;
					tpl.setDelF(Short.valueOf("1"));
					this.genDiSuiteDiDao.markDelete(tpl);
				}
			}
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;		
	}

	@Override
	public SingleResult<Boolean> relMrTemplateListDelete(Map map) {

		String diSuiteCode = getValueFromMap(map,"diSuiteCode","组套编码");
		logger.debug("diSuiteCode:"+diSuiteCode);
		//获取自定义分类编码
		if(null == diSuiteCode ){
			generateFailure("csasCategoryCreate","组套编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "组套编码");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		List<DiSuiteTemplateEntity> rsEntity = dao.selectRelMrDocByDiSuite(diSuiteCode);
		if(null == rsEntity ){
			success = Boolean.FALSE ;
			logger.debug("diSuiteCode："+ diSuiteCode + "| 关联病历模板列表为 null");
		}else{
			if(rsEntity.isEmpty()){
				success = Boolean.FALSE ;
				logger.debug("diSuiteCode："+ diSuiteCode + "|  关联病历模板列表为空");
			}else{
				logger.debug("diSuiteCode："+ diSuiteCode + "|  关联 病历模板列表 数量为"+rsEntity.size());
				int i = 1 ;
				for(DiSuiteTemplateEntity tpl : rsEntity ){
					logger.debug("diSuiteCode："+ diSuiteCode + "|第"+i+"个diSuiteTemplate——Code:"+tpl.getDiSuiteTemplateCd());
					i++;
					tpl.setDelF(Short.valueOf("1"));
					this.genDiSuiteTemplateDao.markDelete(tpl);
				}
			}
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;		
	
	}
	
	/**
	 * 组套列表---查看该科室组套的共享对象列表
	* @return
	 */
	@Override
	public ArrayResult<Dept> DiShareView( Map map){
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");
		if(null == ownerType ){
			generateFailure("mrTemplateListBrowse","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if(null == ownerCode ){
			generateFailure("mrTemplateListBrowse","所属编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if(null == enTypeCode ){
			generateFailure("mrTemplateListBrowse","就诊类型");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		//该科室共享给其他科室的列表，Whose are this to be shared to ?
		List<DiSuiteShareEntity> sharedKrOwner = dao.getSharedKr(ownerType, ownerCode ,null, null );
		Map<String,String> checkDeptList = new HashMap<String,String>();		
		for(DiSuiteShareEntity sd :sharedKrOwner){
			checkDeptList.put(sd.getToOwnerCd(), sd.getToOwnerTypeCd());			
		}
		ArrayResultBuilder<Dept> builder = ArrayResultBuilder.newArrayResult(Dept.class);
		Dept[] allDeptList = null;
		String deptCode = null ;
		int total = 0 ;
		String deptTypeCode = ParameterUtils.enType2DeptType(enTypeCode) ;
		ArrayResult<Organization> resultsD = organizationService.searchAllWardDept(deptCode, deptTypeCode);
		if (resultsD != null && resultsD.hasData()) {
			Organization[] orgs = resultsD.getDataList();
			allDeptList = new Dept[orgs.length];
        	for(int j=0;j<orgs.length;j++){
        		Organization org = orgs[j];
        		Dept dept = new Dept();
        		dept.setDeptCode(org.getCode());
        		dept.setDeptName(org.getName());
        		if(checkDeptList.containsKey(org.getCode())){
        			dept.setChecked(true);
        		}
        		allDeptList[j] = dept ;
        	}
        	builder.withData(allDeptList);
        	total = orgs.length ;
		}
		ArrayResult<Dept> rs = builder.build();
		rs.setTotal(total);
		return rs;
		
	}
	
	/**
	 * 组套列表---保存该科室组套的共享对象列表
	 * @return
	 */
	@Override
	public SingleResult<Boolean> DiShareSave(ShareDeptModel model){
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean success = Boolean.TRUE ;
		String deptCodeSrc = model.getDeptCodeSrc() ;
		String deptNameSrc = model.getDeptNameSrc() ;
		Dept[] deptDstArr = model.getDeptDstArr();
		for(int i = 0 ; i < deptDstArr.length ; i ++){
			Dept dept = deptDstArr[i] ;
			DiSuiteShareEntity entity = new DiSuiteShareEntity();
			String diSuiteShareCd = UUIDGenerator.getUUID() ;
			entity.setDiSuiteShareCd(diSuiteShareCd);
			entity.setOwnerCd(deptCodeSrc);
			entity.setOwnerTypeCd(OwnerType.DEPARTMENT);
			entity.setShareNm(deptNameSrc);
			entity.setToOwnerCd(dept.getDeptCode());
			entity.setToOwnerTypeCd(OwnerType.DEPARTMENT);
			entity.setToShareNm(dept.getDeptName());
			diSuiteShareDao.insert(entity);
			logger.debug("插入成功，主键:"+diSuiteShareCd+"||源"+deptCodeSrc+"_"+deptNameSrc +"||目标："+dept.getDeptCode() +"_"+dept.getDeptName());
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;	
	}
	
	private boolean verify(SimpleItem[] simpleItems) {
		 if(null != simpleItems && simpleItems.length > 0 && null!= simpleItems[0] ){
			 return true;
		 }
		 else {
			return false;
		}
	}


	private String getOwnerCode(String ownerType){
		String ownerCode = null ;
		Session session = Session.get();
		if (OwnerType.HOSPITAL_WIDE.equals(ownerType)) {
			ownerCode = session.getOrgCd();
		} else if (OwnerType.DEPARTMENT.equals(ownerType)) {
			ownerCode = session.getDeptId();
		} else if (OwnerType.PERSONAL.equals(ownerType)) {
			ownerCode = session.getUserId();
		}
		return ownerCode;
	}
	
	private String getOwnerTypeName(String ownerTypeCode){
		String  ownerTypeName = null ;
		if(StringUtils.isBlank(ownerTypeCode)){
			return ownerTypeName ;
		}

		   if(OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode) ){
			   ownerTypeName = "全院";
		   }else if(OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode) ){
			   ownerTypeName = "科室";
		   }else if(OwnerType.PERSONAL.equalsIgnoreCase(ownerTypeCode) ){
			   ownerTypeName = "个人";
		   }
		   return ownerTypeName;
	}
	
	private String getOwnerName(String ownerTypeCode,String ownerCode){
		Session session = Session.get();
		logger.debug("ownerCode:"+session.getUserId());
		logger.debug("ownerName:"+session.getUserName());
		logger.debug("deptCode:"+session.getDeptId());
		logger.debug("deptName:"+session.getDeptName());
		String ownerName = null ;
		if(null == ownerCode){
			ownerName = "全院通用";
			if(OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)){
				ownerName = session.getDeptName();
			}else if(OwnerType.PERSONAL.equalsIgnoreCase(ownerTypeCode)){
				ownerName = session.getUserName();
			}
			return ownerName;
		}
		if (null != ownerTypeCode || null != ownerCode) {
			if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
				// 全院，
				SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
						Organization.OBJ_CD, ownerCode);
				if (verify(simpleItems)) {
					ownerName = simpleItems[0].getText();
				}
			} else {
				if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
					// 科室
					 DataObject[] objects = dataObjectService.getObjects(Organization.OBJ_CD, ownerCode);
					 if(null != objects && objects.length > 0 && null != objects[0] ){
							 DataObject object = objects[0] ;
							 ownerName =(String)object.getValue("name");
					 }
				} else {
					 DataObject object = dataObjectService.getObject(User.OBJ_CD, ownerCode);
					 if(null != object ){
						 ownerName =(String)object.getValue("name");
					 }
				}
			}
		}
		return ownerName;
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
	
	//判断map中是否存在key
	private boolean verifyExistKey(Map map, String key) {
		if (map.containsKey(key) && null != map.get(key)) {
			String value = (String) map.get(key) ;
			if(!NULL_STRING.equalsIgnoreCase(value) && value.length() > 0)
			return true;
		}
		return false;
	}
	
	private void generateFailure(String methodName,String name){
		logger.info(methodName+"-"+name+"为空，返回");
	}

	@Override
	public ArrayResult<DiSuiteTypeModel> csasCategoryList(Map map) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = getValueFromMap(map,"ownerType","所属类型编码");
		String ownerCode = getValueFromMap(map,"ownerCode","所属编码");
		String enTypeCode = getValueFromMap(map,"enTypeCode","就诊类型");

		if(null == ownerType){
			generateFailure("csasCategoryList","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("csasCategoryList","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if( null == enTypeCode ){
			generateFailure("csasCategoryList","就诊类型");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		ArrayResultBuilder<DiSuiteTypeModel> builder = ArrayResultBuilder.newArrayResult(DiSuiteTypeModel.class);
		List<DiSuiteTpEntity> list = dao.selectCategoryByOwner(orgCode, ownerType, ownerCode, enTypeCode);
		int total = 0;
		if(null == list ){
			logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 自定义分类列表为 null");
		}else{
			if(list.isEmpty()){
				logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 自定义分类列表数量为空");
			}else{
				logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 自定义分类列表数量为"+list.size());
				DiSuiteTypeModel[] arr = new DiSuiteTypeModel[list.size()];
				for(int i = 0 ; i < list.size() ; i++){
					DiSuiteTpEntity entity = list.get(i);
					DiSuiteTypeModel model = new DiSuiteTypeModel();
					model.setDiSuiteTpCd(entity.getDiSuiteTpCd());
					model.setDiSuiteTpNm(entity.getDiSuiteTpNm());
					model.setOwnerCd(ownerCode);
					model.setOwnerTypeCd(ownerType);
					model.setSortNo(entity.getSortNo());					
					model.setOwnerTypeName(getOwnerTypeName(entity.getOwnerTypeCd()));
					model.setOwnerName(this.getOwnerName(ownerType, ownerCode));
					arr[i] = model;
				}
				total = list.size() ;
				builder.withData(arr);
			}
		}
		ArrayResult<DiSuiteTypeModel> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	@Override
	public SingleResult<Boolean> csasCategorySave(
			DiSuiteTypeCommitModel commitModel) {
		String orgCode = Session.get().getOrgCd();
		String ownerType = commitModel.getOwnerType();
		String ownerCode = commitModel.getOwnerCode();
		String enTypeCode = commitModel.getEnTypeCode();
		if(null == ownerType){
			generateFailure("csasCategoryList","所属类型编码");	
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		if( null == ownerCode ){
			generateFailure("csasCategoryList","所属编码");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if( null == enTypeCode ){
			generateFailure("csasCategoryList","就诊类型");		
			Notification notification = new Notification(MessageCode.MISS_PARAM, "就诊类型");
			throw new NotificationException(notification);
		}
		SingleResultBuilder<Boolean> builder =  SingleResultBuilder.newSingleResult(Boolean.class);
		Boolean success = Boolean.FALSE ;
		List<DiSuiteTpEntity> oldList = dao.selectCategoryByOwner(orgCode, ownerType, ownerCode, enTypeCode);
		StringBuffer sbOld =  new StringBuffer();
		if(null == oldList ){
			logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 原自定义分类列表为 null");
		}else{
			if(oldList.isEmpty()){
				logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 原自定义分类列表数量为空");
			}else{
				logger.debug("ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "| 原自定义分类列表数量为"+oldList.size());
				sbOld = new StringBuffer();
				for(int i = 0 ; i < oldList.size() ; i++){
					DiSuiteTpEntity entity = oldList.get(i);
					if(i > 0){
						sbOld.append(",");
					}
					sbOld.append(entity.getDiSuiteTpCd());					
				}
			}
		}
		String[] newList = commitModel.getDiSuiteTypeNames();
		if(null == oldList || oldList.isEmpty() ){
			logger.info("原诊断列表为空");
			if(null == newList || newList.length == 0 ){
				logger.info("新诊断列表为空");
			}else{
				int createNum = 0;
				for(int i = 0 ; i < newList.length ; i++){
					String diSuiteTypeName = newList[i];
					if(StringUtils.isBlank(diSuiteTypeName)){
						continue;
					}
					Map<String,String> map = new HashMap<String,String>();
					map.put("ownerType", ownerType);
					map.put("ownerCode", ownerCode);
					map.put("enTypeCode", enTypeCode);
					map.put("diSuiteTypeName", diSuiteTypeName);
					SingleResult<DiSuiteTypeModel> result = this.csasCategoryCreate(map);
					if(null != result.getData()){
						logger.debug("创建成功，ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "|diSuiteTypeName:"+diSuiteTypeName);
						createNum++;
					}
				}
				logger.debug("共创建"+ createNum +"个");
				builder.withData(success);
				SingleResult<Boolean> rs = builder.build();
				return rs;	
			}
		}
		if(null == newList || newList.length == 0 ){
			logger.info("新诊断列表为空");
			if(null == oldList || oldList.isEmpty() ){
				logger.info("原诊断列表为空");
				builder.withData(success);
				SingleResult<Boolean> rs = builder.build();
				return rs;	
			}else{
				Map<String,String> param = new HashMap<String,String>();
				param.put("diSuiteTypeCode", sbOld.toString());
				SingleResult<Boolean> result = csasCategoryDelete(param);
				if( result.getData()){
					logger.debug("删除成功，ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "|diSuiteTypeCode:"+sbOld.toString());
				}
				builder.withData(success);
				SingleResult<Boolean> rs = builder.build();
				return rs;	
			}
		}
		if(null != newList && newList.length > 0  && null != oldList && !oldList.isEmpty() ){
			//待删除的旧实体
			Map<String,DiSuiteTpEntity> oldMapTodelete = new HashMap<String,DiSuiteTpEntity>();
			//待添加的新诊断
			List<String> newMap  = new ArrayList<String>();
			for(int i = 0 ; i < oldList.size() ; i++){
				//把全部就实体全部放入 待删除
				DiSuiteTpEntity dsd = oldList.get(i) ;
				logger.debug("old map,key:"+dsd.getDiSuiteTpNm());
				oldMapTodelete.put(dsd.getDiSuiteTpNm(), dsd);
			}
			for(int i = 0 ; i < newList.length ; i++){
				String newTypeName = newList[i];//新的分类名称
				logger.debug("新分类名称："+newTypeName);
				if(oldMapTodelete.containsKey(newTypeName)){
					//当新诊断在待删除实体中，则从待删除中移除
					logger.debug("oldMap.containsKey("+newTypeName+")");
					oldMapTodelete.remove(newTypeName);
				}else{
					//当新诊断在待删除实体中，则添加到待添加的新诊断中
					logger.debug(newTypeName+" is not in oldMap");
					newMap.add(newTypeName);
				}
			}
			if(!oldMapTodelete.isEmpty()){
				Iterator<DiSuiteTpEntity> it = oldMapTodelete.values().iterator();
				sbOld = new StringBuffer();
				while(it.hasNext()){
					DiSuiteTpEntity entity = it.next();
					if(sbOld.length() > 0 ){
							sbOld.append(",");
					}
					sbOld.append(entity.getDiSuiteTpCd());					
				}
				if(sbOld.length() > 0 ){
					Map<String,String> param = new HashMap<String,String>();
					param.put("diSuiteTypeCode", sbOld.toString());
					SingleResult<Boolean> result = csasCategoryDelete(param);
					if( result.getData()){
						logger.debug("删除成功，ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "|diSuiteTypeCode:"+sbOld.toString());
					}

					builder.withData(success);
					SingleResult<Boolean> rs = builder.build();
					return rs;	
				}
			}
			if(!newMap.isEmpty()){
				int createNum  =0 ;
				for(int i = 0 ; i < newMap.size() ; i++){
						String diSuiteTypeName = newMap.get(i);
						Map<String,String> map = new HashMap<String,String>();
						map.put("ownerType", ownerType);
						map.put("ownerCode", ownerCode);
						map.put("enTypeCode", enTypeCode);
						map.put("diSuiteTypeName", diSuiteTypeName);
						SingleResult<DiSuiteTypeModel> result = this.csasCategoryCreate(map);
						if(null != result.getData()){
							logger.debug("创建成功，ownerType："+ ownerType + "|ownerCode："+ ownerCode +"|enTypeCode："+ enTypeCode  + "|diSuiteTypeName:"+diSuiteTypeName);
							createNum++;
						}

					}
				logger.debug("共创建"+ createNum +"个");
				builder.withData(success);
				SingleResult<Boolean> rs = builder.build();
				return rs;	
			}
		}
		builder.withData(success);
		SingleResult<Boolean> rs = builder.build();
		return rs;	
	
	}
	
	/**
	 * 组套列表---托拽到本节点前，该顺序号（包括该节点）开始之后的顺序号全部加1
	 * target : 目标节点
	 * moved ： 被移动节点
	 * @param map    map:{orgCode:'00',ownerType:'所属类型编码',ownerCode:'a1058',target:'1005',moved:'1003'} 
	 * @return
	 */
	@Override
	public Map csasCategorySortAddOneBeforeNode(Map map) {
		// TODO Auto-generated method stub
		return CsasIndexAddOne(map,"true");
	}

	/**
	 * 组套列表---组套列表---托拽到本节点后，该顺序号（不包括该节点）开始之后的顺序号全部加1
	 * target : 目标节点
	 * moved ： 被移动节点
	 * @param map    map:{orgCode:'00',ownerType:'所属类型编码',ownerCode:'a1058',target:'1005',moved:'1003'} 
	 * @return
	 */
	@Override
	public Map csasCategorySortAddOneAfterNode(Map map) {
		return CsasIndexAddOne(map,null);
	}
	
	private Map CsasIndexAddOne(Map map,String isInclude){
		String orgCode = null ;
		if(verifyExistKey(map,"orgCode")){
			Object object = map.get("orgCode");
			orgCode = object.toString();
			logger.debug("CsasIndexAddOne_组织结构 是："+ orgCode);
		}else{
			logger.debug("CsasIndexAddOne_组织机构 为空");
		}
		
		String ownerType = null ;
		if(verifyExistKey(map,"ownerType")){
			Object object = map.get("ownerType");
			ownerType = object.toString();
			logger.debug("CsasIndexAddOne_所属类型编码 是："+ ownerType);
		}else{
			logger.debug("CsasIndexAddOne_所属类型编码 为空");
		}
		
		String ownerCode = null ;
		if(verifyExistKey(map,"ownerCode")){
			Object object = map.get("ownerCode");
			ownerCode = object.toString();
			logger.debug("CsasIndexAddOne_所属编码 是："+ ownerCode);
		}else{
			logger.debug("CsasIndexAddOne_所属编码 为空");
		}
		
		String targetCategoryCode = null ;
		if(verifyExistKey(map,"target")){
			Object object = map.get("target");
			targetCategoryCode = object.toString();
			logger.debug("CsasIndexAddOne_目标自定义分类编码 是："+ targetCategoryCode);
		}else{
			logger.debug("CsasIndexAddOne_目标自定义分类编码 为空");
		}

		String movedCategoryCode = null ;
		if(verifyExistKey(map,"moved")){
			Object object = map.get("moved");
			movedCategoryCode = object.toString();
			logger.debug("CsasIndexAddOne_被拖动自定义分类编码 是："+ movedCategoryCode);
		}else{
			logger.debug("CsasIndexAddOne_被拖动自定义分类编码 为空");
		}
		
		if(null == orgCode ||null ==  ownerType ||null == ownerCode ||null ==targetCategoryCode ||null ==movedCategoryCode ){
			logger.info("CsasIndexAddOne_组织机构、所属类型、所属编码或者自定义分类编码(目标和被拖动)为空，返回");
			Map mapRs = new HashMap();
			mapRs.put("success", Boolean.FALSE) ;
			mapRs.put("message", "组织机构、所属类型、所属编码、所属编码或者自定义分类编码(目标和被拖动)为空，返回") ;
			return mapRs;
		}
		//目标节点
		DiSuiteTpEntity entity = this.genDiSuiteTpDao.selectById(targetCategoryCode);
		//目标节点当前的序号
		int sortNoOfMoved = entity.getSortNo() ;
		//需要加1的节点
		List<DiSuiteTpEntity> ownerRelCategory = cusDiSuiteTpDao.selectOwnerRelCategoryGTSort(ownerType,ownerCode ,sortNoOfMoved,isInclude);
		if(null == isInclude){
			sortNoOfMoved += 1 ;
			logger.debug("CsasIndexAddOne_(isInclude == null )_ownerRelCategory.size is:"+ownerRelCategory.size());
		}else{
			logger.debug("CsasIndexAddOne_( isInclude <> null)_ownerRelCategory.size is:"+ownerRelCategory.size());
		}
		for(DiSuiteTpEntity  category : ownerRelCategory){
			int sortNo = category.getSortNo() + 1 ;
			category.setSortNo(sortNo);
			int rs = genDiSuiteTpDao.updateExcludeNull(category);
			logger.debug("CsasIndexAddOne_更新成功：orgCode_"+orgCode +"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|categoryCode_"+ category.getDiSuiteTpCd() +"|sortNo_"+ sortNo );
		}
		//被移动节点
		DiSuiteTpEntity movedCategory = this.genDiSuiteTpDao.selectById(movedCategoryCode);
		movedCategory.setSortNo(sortNoOfMoved);
		int rs = this.genDiSuiteTpDao.updateExcludeNull(movedCategory);
		logger.debug("CsasIndexAddOne_更新成功：orgCode_"+orgCode +"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|categoryCode_"+ movedCategory.getDiSuiteTpCd() +"|sortNo_"+ sortNoOfMoved );

		Map mapRs = new HashMap();
		mapRs.put("success", Boolean.TRUE) ;
		mapRs.put("message", "更新成功") ;
		return mapRs;
	
	}
	/**
	 * 组套列表---托拽到本节点前，该顺序号（包括该节点）开始之后的顺序号全部加1
	 * @param map    map:{orgCode:'00',ownerType:'所属类型编码',ownerCode:'a1058',categoryCode:'1003',diCode:'2003'} 
	 * @return
	 */
	@Override
	public Map csasDiaSortAddOneBeforeNode(Map map) {
		// TODO Auto-generated method stub
		return CsasDiaIndexAddOne(map,"true") ;
	}
	/**
	 * 组套列表---托拽到本节点后，该顺序号（不包括该节点）开始之后的顺序号全部加1
	 * @param map    map:{orgCode:'00',ownerType:'所属类型编码',ownerCode:'a1058',categoryCode:'1003',diCode:'2003'} 
	 * @return
	 */
	@Override
	public Map csasDiaSortAddOneAfterNode(Map map) {
		return CsasDiaIndexAddOne(map,null) ;
	}
	
	private Map CsasDiaIndexAddOne(Map map,String isInclude){

		// TODO Auto-generated method stub
		String orgCode = null ;
		if(verifyExistKey(map,"orgCode")){
			Object object = map.get("orgCode");
			orgCode = object.toString();
			logger.debug("CsasDiaIndexAddOne_组织结构 是："+ orgCode);
		}else{
			logger.debug("CsasDiaIndexAddOne_组织机构 为空");
		}
		
		String ownerType = null ;
		if(verifyExistKey(map,"ownerType")){
			Object object = map.get("ownerType");
			ownerType = object.toString();
			logger.debug("CsasDiaIndexAddOne_所属类型编码 是："+ ownerType);
		}else{
			logger.debug("CsasDiaIndexAddOne_所属类型编码 为空");
		}
		
		String ownerCode = null ;
		if(verifyExistKey(map,"ownerCode")){
			Object object = map.get("ownerCode");
			ownerCode = object.toString();
			logger.debug("CsasDiaIndexAddOne_所属编码 是："+ ownerCode);
		}else{
			logger.debug("CsasDiaIndexAddOne_所属编码 为空");
		}

/*		String categoryCode = null ;
		if(verifyExistKey(map,"categoryCode")){
			Object object = map.get("categoryCode");
			categoryCode = object.toString();
			logger.debug("CsasDiaIndexAddOne_自定义分类编码 是："+ categoryCode);
		}else{
			logger.debug("CsasDiaIndexAddOne_自定义分类编码 为空");
		}*/

		String movedDiCustClaDiCi = null ;
		if(verifyExistKey(map,"moved")){
			Object object = map.get("moved");
			movedDiCustClaDiCi = object.toString();
			logger.debug("CsasDiaIndexAddOne_被拖动自定义分类与诊断关系主键 是："+ movedDiCustClaDiCi);
		}else{
			logger.debug("CsasDiaIndexAddOne_被拖动自定义分类与诊断关系主键 为空");
		}
		
		String targetDiCustClaDiCi = null ;
		if(verifyExistKey(map,"target")){
			Object object = map.get("target");
			targetDiCustClaDiCi = object.toString();
			logger.debug("CsasDiaIndexAddOne_目标自定义分类与诊断关系主键 是："+ targetDiCustClaDiCi);
		}else{
			logger.debug("CsasDiaIndexAddOne_目标自定义分类与诊断关系主键 为空");
		}
		if(null == orgCode ||null ==  ownerType ||null == ownerCode ||null ==movedDiCustClaDiCi ||null ==targetDiCustClaDiCi){
			logger.info("CsasDiaIndexAddOne_组织机构、所属类型、所属编码、自定义分类与诊断关系主键 为空，返回");
			Map mapRs = new HashMap();
			mapRs.put("success", Boolean.FALSE) ;
			mapRs.put("message", "组织机构、所属类型、所属编码、自定义分类与诊断关系主键 为空，返回") ;
			return mapRs;
		}
		//目标节点
		DiSuiteEntity targetCategoryDi = this.genDiSuiteDao.selectById(targetDiCustClaDiCi);
		//目标节点当前的序号
		int sortNoOfMoved = targetCategoryDi.getSortNo() ;
		//需要加1的实体
		List<DiSuiteEntity> categoryDiaListToAddOne = cusDiSuiteDao.selectCategoryDiGTSort(orgCode, ownerType, ownerCode, targetCategoryDi.getDiSuiteTpCd(), targetCategoryDi.getSortNo(),isInclude);
		if(null == isInclude){
			sortNoOfMoved += 1 ;
			logger.debug("CsasDiaIndexAddOne_(isInclude == null )_categoryDiaListToAddOne.size is:"+categoryDiaListToAddOne.size());
		}else{
			logger.debug("CsasDiaIndexAddOne_( isInclude <> null)_categoryDiaListToAddOne.size is:"+categoryDiaListToAddOne.size());
		}
		for(DiSuiteEntity  categoryDi : categoryDiaListToAddOne){
			Integer entitySortNo = categoryDi.getSortNo() + 1;
			categoryDi.setSortNo(entitySortNo );
			int i = this.genDiSuiteDao.updateExcludeNull(categoryDi);
			logger.debug("CsasIndexAddOne_更新成功：orgCode_"+orgCode +"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|DiCustClaDiCi_"+ categoryDi.getDiSuiteCd() +"|new_sortNo_"+ entitySortNo );
		}	
		//被拖动的目标
		DiSuiteEntity movedCategoryDi = this.genDiSuiteDao.selectById(movedDiCustClaDiCi);
		movedCategoryDi.setSortNo(sortNoOfMoved);
		int i = this.genDiSuiteDao.updateExcludeNull(movedCategoryDi);
		logger.debug("CsasIndexAddOne_更新成功：orgCode_"+orgCode +"|ownerType_"+ownerType+"|ownerCode_"+ownerCode+"|DiCustClaDiCi_"+ movedCategoryDi.getDiSuiteCd() +"|new_sortNo_"+ sortNoOfMoved );

		Map mapRs = new HashMap();
		mapRs.put("success", Boolean.FALSE) ;
		mapRs.put("message", "更新成功") ;
		return mapRs;
	
	}
	
	
	
}
