package pkuhit.iih.mr.tpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pkuhit.iih.di.md.DiagnosisDict;
import pkuhit.iih.en.md.EncounterType;
import pkuhit.iih.mr.dao.auto.MrBaseTplDao;
import pkuhit.iih.mr.dao.auto.MrTplDao;
import pkuhit.iih.mr.dao.auto.MrTplDeptDao;
import pkuhit.iih.mr.dao.auto.MrTplDiDao;
import pkuhit.iih.mr.dao.auto.entity.MrBaseTpl;
import pkuhit.iih.mr.dao.auto.entity.MrTpl;
import pkuhit.iih.mr.dao.auto.entity.MrTplDept;
import pkuhit.iih.mr.dao.auto.entity.MrTplDi;
import pkuhit.iih.mr.dao.custom.CusMrTplDeptDao;
import pkuhit.iih.mr.dao.custom.CusMrTplDiDao;
import pkuhit.iih.mr.md.MrSignLevel;
import pkuhit.iih.mr.md.MrTemplateStatus;
import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.MrTypeCustomCategory;
import pkuhit.iih.mr.md.dao.auto.MdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpCcat;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTpSignLvl;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpCcatDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpDao;
import pkuhit.iih.mr.md.dao.custom.CusMdMrTpSignLvlDao;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.dao.CusTemplateDao;
import pkuhit.iih.pub.FirstLetterUtil;
import pkuhit.iih.pub.IihUtils;
import pkuhit.iih.pub.PerformancePrinter;
import pkuhit.md.ApplyTo;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.me.DataObject;
import pkuhit.me.DataObjectService;
import pkuhit.org.Employee;
import pkuhit.org.Organization;
import pkuhit.org.OrganizationService;
import pkuhit.utils.ParameterUtils;
import pkuhit.xap.ac.Session;
//import pkuhit.xap.ac.User;
import pkuhit.xap.ac.UserRole;
import pkuhit.xap.ac.UserRoleService;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.Composite;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.model.TreeBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.servlet.mvc.annotation.RequestParam;
import xap.sv.util.UUIDGenerator;

/**
 * @author guo_zhongbao
 * 
 */
public class MrTemplateServiceImpl implements MrTemplateService {
	
	@Reference
	OrganizationService organizationService;
	
	//public final String DEPT_TYPE_DEPT = "ENM01.04";
	
	Logger log = LoggerFactory.getLogger(MrTemplateServiceImpl.class);
	
	public final String ORG_TEMPLATE_ROLE = "XAPM14.11" ; //全院模板管理员
	
	public final String DEPT_TEMPLATE_ROLE = "XAPM14.12" ; //科室模板管理员
	
	public final String ZY_EXCUTE_DOCTOR_ROLE = "XAPM14.02" ; //临床医生
	
	public final String MZ_EXCUTE_DOCTOR_ROLE = "XAPM14.03" ; //门诊医生
	
	public final String ZY_EXCUTE_NURSE_ROLE = "XAPM14.16" ; //护士
	
	final String NULL_STRING = "null";
	
	String HeaderInital = "";
	String MaxRowCount = "";
	String HeaderRowCount = "";
	
	@Autowired
	MrTplDao autoGenDao;

	@Autowired
	// 自动生成dao
	MrBaseTplDao baseTemplateDao;

	// 根记录模板编码生成服务
	//@Reference
	//MeCdRuService meCdRuService;

	@Reference
	FileService fileService;

	@Autowired
	CusTemplateDao cusDao;

	// 模板与诊断关系记录表
	@Autowired
	MrTplDiDao mrTplDiDao;
	@Autowired
	CusMrTplDiDao cusMrTplDiDao;
	@Autowired
	CusMdMrTpSignLvlDao cusMdMrTpSignLvlDao;// 医疗记录类型_审签级别 数据访问dao

	@Reference
	DictionaryService dictionaryService;

	@Autowired
	MdMrTpCcatDao mdMrTpCcatDao;// 自定义类型 的 dao

	@Autowired
	CusMdMrTpDao cusMdMrTpDao;
	@Reference
	DataObjectService dataObjectService; // 数据对象获取服务
	
	@Autowired
	MrTplDeptDao mrTplDeptDao;//模板适用
	
	@Autowired
	CusMrTplDeptDao cusMrTplDeptDao;//模板适用自定义dao
	
	@Reference
	UserRoleService userRoleService; //用户 角色
	
	@Autowired
	CusMdMrTpCcatDao cusMdMrTpCcatDao; //自定义 病历模板类型 分类
	
	/*
	 * @Reference OrganizationService organizationService; //组织服务
	 */
	@Override
	public ArrayResult<MrType> searchLeafTypeCode() {
		List<MdMrTp> poList = cusMdMrTpDao.selectLeafTypeCode();
		ArrayResultBuilder<MrType> builder = ArrayResultBuilder
				.newArrayResult(MrType.class);
		int total = 0;
		if (poList.size() > 0) {
			total = poList.size();
			MrType[] voArray = new MrType[total];
			int i = 0;
			for (MdMrTp po : poList) {
				MrType vo = translateTypePo2vo(po);
				voArray[i] = vo;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<MrType> rs = builder.build();
		rs.setTotal(total);
		return rs;
	}

	private MrType translateTypePo2vo(MdMrTp po) {
		MrType vo = new MrType();
		BeanCopyUtil.entityToModel(vo, po, MrType.OBJ_CD, dictionaryService);
		return vo;
	}

	/**
	 * 【医疗记录模板】新建服务（单记录）
	 * 
	 * @param MrTemplate
	 *            value
	 * @return 单条医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * pkuhit.iih.mr.tpl.MrTemplateService#create(pkuhit.iih.mr.tpl.MrTemplate)
	 */
	@Override
	public SingleResult<MrTemplate> create(TemplateInputModel io) {
		if (null == io.getMrTypeCode()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "医疗记录类型编码");
			throw new NotificationException(notification);
		}
		if (null == io.getOdtFile()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "文件流");
			throw new NotificationException(notification);
		}
		if (null == io.getName()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "名称");
			throw new NotificationException(notification);
		}
		if (null == io.getOwnerTypeCode()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属类型编码");
			throw new NotificationException(notification);
		}
		
		if (OwnerType.DEPARTMENT.equalsIgnoreCase(io.getOwnerTypeCode()) && null == io.getOwnDeptCd()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
			throw new NotificationException(notification);
		}
		if (null == io.getBaseTemplateCode()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "基础模板编码");
			throw new NotificationException(notification);
		}
		if (null == io.getSignLevel()) {
			Notification notification = new Notification(MessageCode.MISS_PARAM, "审签级别");
			throw new NotificationException(notification);
		}
		if(null == io.getTplUseCode()){
		Notification notification = new Notification(MessageCode.MISS_PARAM,"模板适用");
		throw new NotificationException(notification);
		}
		if(null == io.getTplUseTypeCode()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"模板适用类别");
			throw new NotificationException(notification);
		}
		if(null == io.getCustomerData()){
			Notification notification = new Notification(MessageCode.MISS_PARAM,"保存操作类型");
			throw new NotificationException(notification);
		}
		if(!userRoleCanCreate(io.getOwnerTypeCode(),io.getOwnDeptCd())){
			Notification notification = new Notification("MR_10070");
			throw new NotificationException(notification);
		}
		String baseFileContent = io.getOdtFile();// 字符大字段
		//增加判断功能
		String xmlFileContent = io.getXmlFile();// 字符大字段
		FileObject xml = fileService.createFile("base",xmlFileContent.getBytes());// 保存到文件
		FileObject fo = fileService.createFile("base",baseFileContent.getBytes());// 保存到文件
		MrTpl mrTpl = new MrTpl();// 创建持久化对象 基础模板对象
		
		/*String rootCode = null;
		BigInteger verNo = null;
		if (null == io.getCode()) {
			// 新建对象
			verNo = BigInteger.ONE;
			// 根医疗记录基础模板编码
			rootCode = meCdRuService.selectById(MrTemplate.ROOT_CODE).getId();
			if (null == rootCode) {

			}
		} else {
			// 升级对象，获取数据库对象，然后更新版本号，文件流
			MrTpl old = autoGenDao.selectById(io.getCode());
//			rootCode = old.getRtMrTplPk();
			BigInteger currVersion = cusDao.selectMaxVersionByRootCode(rootCode);
			if (!(MrTemplateStatus.ACTIVED.equalsIgnoreCase(old.getMrTplStaCd()) || MrTemplateStatus.STOPPED.equalsIgnoreCase(old.getMrTplStaCd()))) {
				Notification notification = new Notification(MessageCode.UN_UPGRADE_TEMPLATE,"只能升级操作只适用于启用或停用状态的病历模板");
				throw new NotificationException(notification);
			}
			verNo = currVersion.add(BigInteger.ONE);
		}*/
		// 医疗记录模板类型编码
		mrTpl.setMrTpCd(io.getMrTypeCode());
		// 所属类型编码
		mrTpl.setOwnTpCd(io.getOwnerTypeCode());
		// 所属编码
		Session session = Session.get();
		if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(io.getOwnerTypeCode())) {// 全院
			mrTpl.setOwnCd(getOrgCode());
		} else {
			if (OwnerType.DEPARTMENT.equalsIgnoreCase(io.getOwnerTypeCode())) {// 科室
				mrTpl.setOwnCd(io.getOwnDeptCd());
			} else {// 个人
				mrTpl.setOwnCd(session.getUserId());
			}
		}
		// 设置版本
//		mrTpl.setVerNo(verNo);
		//String code = rootCode + "." + String.format("%04d", verNo);
		String code = UUIDGenerator.getUUID();
		String codeXml = UUIDGenerator.getUUID();
		// 医疗记录基础模板编码
		mrTpl.setMrTplCd(code);
		// 根医疗记录基础模板编码
//		mrTpl.setRtMrTplPk(rootCode);
		// 设置名称
		mrTpl.setNm(io.getName());
		//拼音码
		mrTpl.setSpellNo(FirstLetterUtil.getFirstLetter(io.getName()));
		// 设置描述
		mrTpl.setDes(io.getDescription());
		// 设置文件pk
		mrTpl.setFilePk(fo.getId());
		mrTpl.setXmlFilePk(xml.getId());
		
		// 设置状态为 新建
		if(io.getStatusCode()!=null && io.getStatusCode().length()!=0){
			mrTpl.setMrTplStaCd(MrTemplateStatus.ACTIVED);
		}else{
			mrTpl.setMrTplStaCd(MrTemplateStatus.CREATED);
		}
		// 设置基础模板编码
		mrTpl.setMrBaseTplCd(io.getBaseTemplateCode());
		// 设置纸张类型
		if (null != baseTemplateDao.selectById(io.getBaseTemplateCode())) {
			String pagerTypeCode = baseTemplateDao.selectById(io.getBaseTemplateCode()).getPaperTpCd();
//			mrTpl.setPaperTpCd(pagerTypeCode);
		} else {
			// 默认为A4
//			mrTpl.setPaperTpCd(PaperType.A4);
		}
		mrTpl.setMrSignLvlCd(io.getSignLevel()); //设置审签级别
		mrTpl.setEnTypeCode(io.getEnTypeCode()); //设置就诊类型
		// mrTpl.setPaperTpCd("MDM07.01");
		mrTpl.setOrgCd(getOrgCode()); // 组织结构
		//增加sort_no字段的数据
		int counts = cusDao.getCounts()+1;
		String sortNo = counts+"";
		/*if(counts<10){
			sortNo = "0000"+counts;
		}else if(counts<100 && counts>9){
			sortNo = "000"+counts;
		}else if(counts<1000 && counts>99){
			sortNo = "00"+counts;
		}else if(counts<10000 && counts>999){
			sortNo = "0"+counts;
		}else{
			sortNo = counts+"";
		}*/
		mrTpl.setSortNo(sortNo);
		autoGenDao.insertExludeNull(mrTpl);
		String diCds = io.getDiCds();
		if (StringUtils.isNotBlank(diCds)) {
			if (diCds.contains(",")) {
				String[] idArr = diCds.split(",");
				List<MrTplDi> entities = new ArrayList<MrTplDi>();
				for (int i = 0; i < idArr.length; i++) {
					MrTplDi mrTplDi = new MrTplDi();
					mrTplDi.setMrTplDiCd(UUIDGenerator.getUUID());
					mrTplDi.setMrTplCd(mrTpl.getMrTplCd());
					mrTplDi.setDiCd(idArr[i]);
					entities.add(mrTplDi);
				}
				mrTplDiDao.batchInsert(entities);
			} else {
				MrTplDi mrTplDi = new MrTplDi();
				mrTplDi.setMrTplDiCd(UUIDGenerator.getUUID());
				mrTplDi.setMrTplCd(mrTpl.getMrTplCd());
				mrTplDi.setDiCd(diCds);
				mrTplDiDao.insert(mrTplDi);
			}
		}
		//适用类型
		if(ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(io.getTplUseTypeCode()) || ApplyTo.PERSONAL.equalsIgnoreCase(io.getTplUseTypeCode())){//全院
			MrTplDept mrTplDept = new MrTplDept();
			mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
			mrTplDept.setAplToCd(io.getTplUseCode());
			mrTplDept.setMrTplCd(mrTpl.getMrTplCd());
			mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
			mrTplDeptDao.insert(mrTplDept);
		}else{
			//科室
			String[] statusCodeArrayA = io.getTplUseCode().split(",");
			List<MrTplDept> entities = new ArrayList<MrTplDept>();
			for(int i = 0 ; i < statusCodeArrayA.length ; i++){
				MrTplDept mrTplDept = new MrTplDept();
				mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
				mrTplDept.setAplToCd(statusCodeArrayA[i]);
				mrTplDept.setMrTplCd(mrTpl.getMrTplCd());
				mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
				entities.add(mrTplDept);
			}
			mrTplDeptDao.batchInsert(entities);
		}
		MrTpl po = autoGenDao.selectById(mrTpl.getMrTplCd());
		MrTemplate model = transPo2Vo(po,this.userRoleCanCreate(po.getOwnTpCd(), po.getOwnCd()));
		SingleResultBuilder<MrTemplate> builder = SingleResultBuilder.newSingleResult(MrTemplate.class);
		builder.withData(model);
		SingleResult<MrTemplate> rs = builder.build();
		return rs;
	}
	@Override
	public SingleResult<Boolean>  HasPri(String ownerTypeCode, String ownDeptCd) {
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		builder.withData(userRoleCanCreate(ownerTypeCode,ownDeptCd));
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
	/**
	 * 判断是否有创建修改权限
	 * @param ownerTypeCode 所属类型
	 * @param ownDeptCd 所属编码
	 * @return true 可以  false不可以
	 * 本用户有临床医生权限，可以修改自己的模板
	 * 本用户有全院模板管理员权限，可以修改全院模板和科室模板
	 * 本用户有科室模板管理员权限，可以修改自己管理的科室模板
	 * */
	private Boolean userRoleCanCreate(String ownerTypeCode, String ownDeptCd) {
		boolean rs = false ;
		Session session = Session.get();
		String userId = session.getUserId(); //用户
		String orgCode = session.getOrgCd() ; //机构
		String deptCode = session.getOrgCd() ; //登录科室

		if(ownerTypeCode.equalsIgnoreCase(OwnerType.PERSONAL) ){
				//当为所属类型为个人时，判断是否为本人
			if(ownDeptCd.equalsIgnoreCase(userId)){
					rs = true ;
			}
			return rs;
		}
		Map<String, String> params = new HashMap<String, String>();
		params.put("userId", userId);
		ArrayResult<UserRole> results = userRoleService.search(params);//根据用户获得权限
		List<String> maxUserRoleList = new ArrayList<String>(); 
		List<String> deptCodeForRole = new ArrayList<String>(); 
		if (results != null && results.hasData()) {
			UserRole[] userRoles = results.getDataList();
			for(int i = 0 ; i < userRoles.length ; i++){
	       		UserRole ur = userRoles[i] ;
	       		if(ORG_TEMPLATE_ROLE.equalsIgnoreCase(ur.getRoleCode())){
	       			//能管理全院、所有科室、他本人的模板
	        		/*获得所有业务科室*/
	        			maxUserRoleList.add(ORG_TEMPLATE_ROLE);        			
	        	}else{ 
	        		if(DEPT_TEMPLATE_ROLE.equalsIgnoreCase(ur.getRoleCode())){
		        			//科室管理员，可以看到自己管理的科室
		        		maxUserRoleList.add(DEPT_TEMPLATE_ROLE);
		        		deptCodeForRole.add(ur.getOrganizationCode()); 
	        		}
	        	}
			}
		}
		if(ownerTypeCode.equalsIgnoreCase(OwnerType.HOSPITAL_WIDE)){//所属类型为全院
			if(maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){//为全院模板管理员
				rs = true ;
			}
		}else if(ownerTypeCode.equalsIgnoreCase(OwnerType.DEPARTMENT)){
			if(maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){//为全院模板管理员
				rs = true ;
			}else{
				if(maxUserRoleList.contains(DEPT_TEMPLATE_ROLE)){//所属类型为科室管理员
					if(deptCodeForRole.contains(ownDeptCd)){//可以管理员的管理科室
						rs = true ;
					}
				}
			}
		}
		return rs;
	}

	/**
	 * 【医疗记录模板】更新服务（单记录）
	 * 
	 * @param MrTemplate
	 *            value
	 * @return 单条医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#update(java.lang.String,
	 * pkuhit.iih.mr.tpl.MrTemplate)
	 */
	@Override
	public SingleResult<MrTemplate> update(String id, TemplateInputModel io) {
		MrTpl old = autoGenDao.selectById(io.getCode());// 获取实例化对象
		if (null == io.getOdtFile()) {
			if ( !(null == io.getOwnerTypeCode()) && OwnerType.DEPARTMENT.equalsIgnoreCase(io.getOwnerTypeCode()) && null == io.getOwnDeptCd()) {
				Notification notification = new Notification(MessageCode.MISS_PARAM, "所属编码");
				throw new NotificationException(notification);
			}
			// 只能新建状态的，才能提供修改
/*			if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(old.getMrTplStaCd()) || MrTemplateStatus.REJECTED.equalsIgnoreCase(old.getMrTplStaCd()))) {
				Notification notification = new Notification("只有【新建状态】的病历模板才能编辑信息","");
				throw new NotificationException(notification);
			}*/
			old.setMrTpCd(io.getMrTypeCode());// 医疗记录模板类型编码
			old.setOwnTpCd(io.getOwnerTypeCode());// 所属类型编码
			Session session = Session.get();// 所属编码
			if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(io.getOwnerTypeCode())) {
				old.setOwnCd(getOrgCode());// 全院，
			} else {
				if (OwnerType.DEPARTMENT.equalsIgnoreCase(io.getOwnerTypeCode())) {
					old.setOwnCd(io.getOwnDeptCd());// 科室
				} else {
					old.setOwnCd(session.getUserId());// 个人
				}
			}
			old.setNm(io.getName());// 设置名称
			old.setMrBaseTplCd(io.getBaseTemplateCode());// 设置基础模板编码dx
			old.setMrSignLvlCd(io.getSignLevel());// 设置审签级别
			old.setDes(io.getDescription());// 设置描述
/*			if (null != baseTemplateDao.selectById(io.getBaseTemplateCode())) {// 设置纸张类型
				String pagerTypeCode = baseTemplateDao.selectById(io.getBaseTemplateCode()).getPaperTpCd();
//				old.setPaperTpCd(pagerTypeCode);
			} else {
				// 默认为A4
//				old.setPaperTpCd(PaperType.A4);
			}*/
			
			List<MrTplDi> oldDiList = cusMrTplDiDao.getDiListByTpl(io.getCode());  //旧的诊断
			/*适应病种*/
			String diCds = io.getDiCds(); //新的诊断
			if(diCds == null ||   NULL_STRING.equalsIgnoreCase(diCds) ||"".equalsIgnoreCase(diCds) ){
				//新的诊断为空，删除所有的旧诊断
				if(oldDiList.size() > 0){
					mrTplDiDao.batchDelete(oldDiList);
					log.debug("新的诊断为空，删除所有的旧诊断");
				}else{
					log.debug("新的诊断为空，旧诊断为空");
				}
			}else{
				String[] newDiCodeArr = diCds.split(",") ;
				if(oldDiList.size() == 0){
					//数据库中的诊断为空时，新的诊断全部添加
						List<MrTplDi> entities = new ArrayList<MrTplDi>();
						for (int i = 0; i < newDiCodeArr.length; i++) {
							MrTplDi mrTplDi = new MrTplDi();
							mrTplDi.setMrTplDiCd(UUIDGenerator.getUUID());
							mrTplDi.setMrTplCd(old.getMrTplCd());
							mrTplDi.setDiCd(newDiCodeArr[i]);
							entities.add(mrTplDi);
							log.debug("数据库中的诊断为空时，新的诊断包括："+newDiCodeArr[i]);
						}
						log.debug("数据库中的诊断为空时，新的诊断全部添加");
						mrTplDiDao.batchInsert(entities);
				}else{
					List<String> newDiCodes = new ArrayList<String>();
					for(String newDiCode : newDiCodeArr){//复制成list
						log.debug("前台提交的诊断："+newDiCode);
						newDiCodes.add(newDiCode);
					}
					log.debug("前后台开始比较");
					//比对新 旧 2个数组，新的存在旧的不存在，则添加。新的不存在旧的存在，则删除
					List<MrTplDi> entitiesNew = new ArrayList<MrTplDi>();//需要添加的诊断
					List<MrTplDi> entitiesExist = new ArrayList<MrTplDi>(); //已经存在的诊断
					for(MrTplDi mrTplDi : oldDiList){
						log.debug("诊断遍历："+mrTplDi.getDiCd());
						if(newDiCodes.contains(mrTplDi.getDiCd())){
							log.debug("已经存在的诊断："+ mrTplDi.getDiCd());
							entitiesExist.add(mrTplDi);
							newDiCodes.remove(mrTplDi.getDiCd());
						}
					}
					oldDiList.removeAll(entitiesExist);
					if(oldDiList.size() > 0){
						for(MrTplDi mrTplDi : oldDiList){
							log.debug("需要删除的诊断遍历："+mrTplDi.getDiCd());
						}
						int[] deleteCountArr = mrTplDiDao.batchDelete(oldDiList);
						for(int  i : deleteCountArr){
							log.debug("删除的结果遍历："+i);
						}
						log.debug("删除部分旧诊断");
					}
					if(newDiCodes.size() > 0){
						for (String newDicode : newDiCodes) {
							MrTplDi mrTplDi = new MrTplDi();
							mrTplDi.setMrTplDiCd(UUIDGenerator.getUUID());
							mrTplDi.setMrTplCd(old.getMrTplCd());
							mrTplDi.setDiCd(newDicode);
							entitiesNew.add(mrTplDi);
							log.debug("新的诊断包括："+newDicode);
						}
						int[] insertCountArr = mrTplDiDao.batchInsert(entitiesNew);
						for(int  i : insertCountArr){
							log.debug("删除的结果遍历："+i);
						}
						log.debug("插入部分新诊断");
					}
				}
			}
			/*模板适用*/
			if(null != io.getTplUseTypeCode()){
				List<MrTplDept> oldTplDeptList = cusMrTplDeptDao.getTplDeptByTpl(io.getCode()) ;
				if(null != oldTplDeptList && oldTplDeptList.size() > 0){
					if(ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(io.getTplUseTypeCode()) || ApplyTo.PERSONAL.equalsIgnoreCase(io.getTplUseTypeCode())){
						//新的模板适用为院区或个人
						if(oldTplDeptList.size() == 1 ){
							//旧的模板适用个数为1,
							MrTplDept oldMrTplDept = oldTplDeptList.get(0);
							if(io.getTplUseTypeCode().equalsIgnoreCase(oldMrTplDept.getAplToTpCd()) ){
								//如果类型相等
								if(io.getTplUseCode().equalsIgnoreCase(oldMrTplDept.getAplToCd()) ){
									//值也相等，则不用更新
								}else{
									oldMrTplDept.setAplToCd(io.getTplUseCode());
									mrTplDeptDao.update(oldMrTplDept);
								}
							}else{
								oldMrTplDept.setAplToTpCd(io.getTplUseTypeCode());
								oldMrTplDept.setAplToCd(io.getTplUseCode());
								mrTplDeptDao.update(oldMrTplDept);
							}
						}else{
							//旧的模板适用为科室，则删除所有，创建新的模板适用
							mrTplDeptDao.batchDelete(oldTplDeptList);
							MrTplDept mrTplDept = new MrTplDept();
							mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
							mrTplDept.setAplToCd(io.getTplUseCode());
							mrTplDept.setMrTplCd(io.getCode());
							mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
							mrTplDeptDao.insert(mrTplDept);
						}
					}else{
						//新的模板适用为科室
						if(oldTplDeptList.size() == 1 ){
							MrTplDept oldMrTplDept = oldTplDeptList.get(0);
							if(ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(oldMrTplDept.getAplToTpCd()) || ApplyTo.PERSONAL.equalsIgnoreCase(oldMrTplDept.getAplToTpCd())){
								/* 如果旧的模板适用为 个人 院区,则删除旧的，创建新的模板适用 */
								mrTplDeptDao.batchDelete(oldTplDeptList);
								String[] useCodeArray = io.getTplUseCode().split(",");
								List<MrTplDept> entities = new ArrayList<MrTplDept>();
								for(int i = 0 ; i < useCodeArray.length ; i++){
									MrTplDept mrTplDept = new MrTplDept();
									mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
									mrTplDept.setAplToCd(useCodeArray[i]);
									mrTplDept.setMrTplCd(io.getCode());
									mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
									entities.add(mrTplDept);
								}
								if(entities.size() > 0){
									mrTplDeptDao.batchInsert(entities);
								}
							}else{
								/* 如果旧的模板适用为 科室, 则比对，判断是否需要删除 创建 */
								String[] useCodeArray = io.getTplUseCode().split(",");
								List<MrTplDept> insertList = new ArrayList<MrTplDept>();
								List<MrTplDept> deleteList = new ArrayList<MrTplDept>();
								compareList(oldTplDeptList,useCodeArray,insertList,deleteList,io.getCode());
								if(insertList.size() > 0){
									mrTplDeptDao.batchInsert(insertList);
								}
								if(deleteList.size() > 0){
									mrTplDeptDao.batchDelete(deleteList);
								}
							}
						}else{
							//新模板适用 与 旧模板适用 同为科室，且都是多个，则比对，判断删除 创建
							String[] useCodeArray = io.getTplUseCode().split(",");
							List<MrTplDept> insertList = new ArrayList<MrTplDept>();
							List<MrTplDept> deleteList = new ArrayList<MrTplDept>();
							compareList(oldTplDeptList,useCodeArray,insertList,deleteList,io.getCode());
							if(insertList.size() > 0){
								mrTplDeptDao.batchInsert(insertList);
							}
							if(deleteList.size() > 0){
								mrTplDeptDao.batchDelete(deleteList);
							}
						}
					}
				}
			}else{
					if(ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(io.getTplUseTypeCode()) || ApplyTo.PERSONAL.equalsIgnoreCase(io.getTplUseTypeCode())){
						//全院
					MrTplDept mrTplDept = new MrTplDept();
					mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
					mrTplDept.setAplToCd(io.getTplUseCode());
					mrTplDept.setMrTplCd(io.getCode());
					mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
					mrTplDeptDao.insert(mrTplDept);
					}else{
						//科室
						String[] useCodeArray = io.getTplUseCode().split(",");
						List<MrTplDept> entities = new ArrayList<MrTplDept>();
						for(int i = 0 ; i < useCodeArray.length ; i++){
							MrTplDept mrTplDept = new MrTplDept();
							mrTplDept.setAplToTpCd(io.getTplUseTypeCode());
							mrTplDept.setAplToCd(useCodeArray[i]);
							mrTplDept.setMrTplCd(io.getCode());
							mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
							entities.add(mrTplDept);
						}
						if(entities.size() > 0){
							mrTplDeptDao.batchInsert(entities);
						}
				}
			}
			autoGenDao.updateExcludeNull(old);
		} else {
			// 只是更新模板文件
			String baseFileContent = io.getOdtFile();
			String xmlFileContent = io.getXmlFile();
			log.debug("模板文件内容是："+baseFileContent);
			log.debug("模板xml文件内容是："+xmlFileContent);
/*			String data2 = "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Y2U6ZG9jdW1lbnQtbWV0YSB4bWxuczpvZmZpY2U9InVybjpvYXNpczpuYW1lczp0YzpvcGVuZG9jdW1lbnQ6eG1sbnM6b2ZmaWNlOjEuMCIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6bWV0YT0idXJuOm9hc2lzOm5hbWVzOnRjOm9wZW5kb2N1bWVudDp4bWxuczptZXRhOjEuMCIgeG1sbnM6b29vPSJodHRwOi8vb3Blbm9mZmljZS5vcmcvMjAwNC9vZmZpY2UiIHhtbG5zOmdyZGRsPSJodHRwOi8vd3d3LnczLm9yZy8yMDAzL2cvZGF0YS12aWV3IyIgb2ZmaWNlOnZlcnNpb249IjEuMiI+PG9mZmljZTptZXRhPjxtZXRhOmdlbmVyYXRvcj5PcGVuT2ZmaWNlLzQuMC4wJFdpbjMyIE9wZW5PZmZpY2Uub3JnX3Byb2plY3QvNDAwbTMkQnVpbGQtOTcwMjwvbWV0YTpnZW5lcmF0b3I+PGRjOmRhdGU+MjAxNi0wNC0xNlQxNjoxNzoyNy41NzwvZGM6ZGF0ZT48bWV0YTplZGl0aW5nLWR1cmF0aW9uPlBUMTdNMzdTPC9tZXRhOmVkaXRpbmctZHVyYXRpb24+PG1ldGE6ZWRpdGluZy1jeWNsZXM+MTU8L21ldGE6ZWRpdGluZy1jeWNsZXM+PG1ldGE6ZG9jdW1lbnQtc3RhdGlzdGljIG1ldGE6dGFibGUtY291bnQ9IjIiIG1ldGE6aW1hZ2UtY291bnQ9IjAiIG1ldGE6b2JqZWN0LWNvdW50PSIwIiBtZXRhOnBhZ2UtY291bnQ9IjEiIG1ldGE6cGFyYWdyYXBoLWNvdW50PSIxMiIgbWV0YTp3b3JkLWNvdW50PSI3NSIgbWV0YTpjaGFyYWN0ZXItY291bnQ9Ijc4Ii8+PC9vZmZpY2U6bWV0YT48L29mZmljZTpkb2N1bWVudC1tZXRhPlBLAwQUAAAIAAAtQpBIX2BInNAIAADQCAAAGAAAAFRodW1ibmFpbHMvdGh1bWJuYWlsLnBuZ4lQTkcNChoKAAAADUlIRFIAAAC1AAABAAgCAAAAekGg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";
			fileService.updateFile(io.getFilePk(), baseFileContent.getBytes());*/
			//增加判断
			if(io.getXmlFilePk()!=null && io.getXmlFilePk().length()!=0){
				try {
					fileService.updateBaseFile(io.getFilePk(), baseFileContent.getBytes());
					fileService.updateBaseFile(io.getXmlFilePk(), xmlFileContent.getBytes());
					autoGenDao.updateExcludeNull(old);
				} catch (SQLException e) {
					e.printStackTrace();
					Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
					throw new NotificationException(notification);
				} catch (Exception e) {
					e.printStackTrace();
					Notification notification = new Notification(MessageCode.FILE_UPDATE_FAILURE, "文件保存失败,请重试保存。");
					throw new NotificationException(notification);
				}
				
			}else{
				FileObject xml = fileService.createFile("base",xmlFileContent.getBytes());
				MrTpl temp = new MrTpl();
				temp.setMrTplCd(old.getMrTplCd());
				temp.setXmlFilePk(xml.getId());
				autoGenDao.updateExcludeNull(temp);
			}
		}

		MrTpl po = autoGenDao.selectById(io.getCode());
		MrTemplate model = transPo2Vo(po,this.userRoleCanCreate(po.getOwnTpCd(), po.getOwnCd()));
		SingleResultBuilder<MrTemplate> builder = SingleResultBuilder.newSingleResult(MrTemplate.class);
		builder.withData(model);
		SingleResult<MrTemplate> rs = builder.build();
		return rs;
	}
	
	/**
     * 【医疗记录模板】更新服务（单记录）
     * 
     * @param MrTemplate
     *            value
     * @return 单条医疗记录模板
     */
    /*
     * (non-Javadoc)
     * 
     * @see pkuhit.iih.mr.tpl.MrTemplateService#update(java.lang.String,
     * pkuhit.iih.mr.tpl.MrTemplate)
     */
    @Override
    public SingleResult<MrTemplate> updateReset(String id, TemplateInputModel io) {
        MrTpl old = autoGenDao.selectById(io.getCode());// 获取实例化对象
        old.setMrBaseTplCd(io.getBaseTemplateCode());
        autoGenDao.updateExcludeNull(old);
        MrTemplate model = transPo2Vo(old,this.userRoleCanCreate(old.getOwnTpCd(), old.getOwnCd()));
        SingleResultBuilder<MrTemplate> builder = SingleResultBuilder.newSingleResult(MrTemplate.class);
        builder.withData(model);
        SingleResult<MrTemplate> rs = builder.build();
        return rs;
    }
    
	/**
	 * 比对新旧2个列表的区别，分析出需要删除的，需要创建的
	 * @param src 数据库中保存的数据
	 * @param dst 从页面传入的更新数据
	 * @param insertList 需要执行创建列表
	 * @param deleteList 需要执行删除列表
	 * @param tplCode 模板code
	 * */
	private void compareList(List<MrTplDept> src,
			String[] dst, List<MrTplDept> insertList,
			List<MrTplDept> deleteList,String tplCode) {
		deleteList.addAll(src) ;//将原数据库中的数据全部放到待删除
		List<MrTplDept> notNeedOperteSrcList = new ArrayList<MrTplDept>(); //不需要删除的数据库对象列表
		List<String> notNeedOperteDstList = new ArrayList<String>(); //不需要创建的 输入对象列表
		for(int j = 0 ; j < dst.length ; j++){
			String newCode = dst[j] ;
			for(int i = 0 ; i < src.size() ; i++){
				String oldCode = src.get(i).getAplToCd();
				if(oldCode.equalsIgnoreCase(newCode)){
					//当数据库和输入中同时存在，则  添加到 不操作列表
					notNeedOperteSrcList.add(src.get(i));
					notNeedOperteDstList.add(newCode);
				}
			}
		}
		for(int j = 0 ; j < dst.length ; j++){
			String newCode = dst[j] ;
			if(!notNeedOperteDstList.contains(newCode)){
				//页面输入对象不在 不需要创建的对象中,则开始创建对象，加入创建列表
					MrTplDept mrTplDept = new MrTplDept();
					mrTplDept.setAplToTpCd( ApplyTo.DEPARTMENT );
					mrTplDept.setAplToCd( newCode );
					mrTplDept.setMrTplCd( tplCode );
					mrTplDept.setMrTplDeptPk(xap.sv.util.UUIDGenerator.getUUID());
					insertList.add(mrTplDept);
			}
		}
		deleteList.removeAll(notNeedOperteSrcList);
		
	}

	/**
	 * 【医疗记录模板】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return 单条医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#search(java.lang.String)
	 */
	@Override
	public SingleResult<MrTemplate> searchById(String id) {
		MrTpl po = autoGenDao.selectById(id);
		if (null == po) {
			Notification notification = new Notification(MessageCode.NOT_EXIST);
			throw new NotificationException(notification);
		}
		MrTemplate model = transPo2Vo(po,this.userRoleCanCreate(po.getOwnTpCd(), po.getOwnCd()));
		model.setSignLevelCode(po.getMrSignLvlCd());	
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrSignLevel.OBJ_CD, po.getMrSignLvlCd());
		if(null != simpleItems && simpleItems.length > 0 && null != simpleItems[0] ){
				model.setSignLevelName(simpleItems[0].getText());
		}

		SingleResultBuilder<MrTemplate> builder = SingleResultBuilder
				.newSingleResult(MrTemplate.class);
		builder.withData(model);
		SingleResult<MrTemplate> rs = builder.build();
		return rs;
	}

	/**
	 * 【医疗记录模板】查询服务（多记录）
	 * 
	 * @param excludeDelete
	 *            当输入0或false时，包含删除。否则，不包含删除
	 * @param statusCode
	 *            单个或多个状态码，以 , 分隔
	 * @param name
	 *            //名称 模糊查询
	 * @param rootCode
	 *            //根记录编码
	 * @param orgCode
	 *            //组织机构编码
	 * @param ownerTypeCode
	 *            //所属类型编码
	 * @param baseTemplateCode
	 *            //基础模板编码
	 * @param ownerCode
	 *            //所属编码 ,当为null时，从session中获取
	 * @param typeCode
	 *            // 单个或者多个医疗记录模板类型编码 ，以 , 分隔
	 * @param mrCategoryCode
	 *            自定义分类 mrCategoryCode 单个或者多个自定义分类编码 ，以， 分隔
	 *            。当typeCode为null时，才判断该参数
	 * @param enTypeCode
	 *            就诊类型 当typeCode为null时，才判断该参数
	 * @param addSignLevel
	 *            查询病历模板申请级别标志 0 当为1或true时，有效。默认为空，返回结果不包含审签级别
	 * @param signDeptCode审签科室
	 *            signDeptCode 查询科室的审签。当查询病历模板申请级别标志addSignLevel有效时，此项为必填项
	 * @param mainDiCode
	 *            就诊主诊断 当查询病历模板申请级别标志addSignLevel有效时，此项为选填项
	 * @return
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MrTemplate> search(Map condition) {
		PerformancePrinter.start("pkuhit.iih.mr.tpl.MrTemplateService#search");
		String excludeDelete = "";
		String statusCode = null;
		ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder.newArrayResult(MrTemplate.class);
		String pageNum = null;
		String pageSize = null;
		if (condition.containsKey("pageNum")&& condition.containsKey("pageSize")) {
			pageNum = (String) condition.get("pageNum");
			pageSize = (String) condition.get("pageSize");
		}
		if (null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "25";
		}
		if (condition.containsKey("excludeDelete") && ("false".equalsIgnoreCase((String) condition.get("excludeDelete")) || "0".equalsIgnoreCase((String) condition.get("excludeDelete")))) {
			excludeDelete = null;
		}
		List<String> statusCodeList = new ArrayList<String>();
		if (verifyExistKey(condition, "statusCode")) { // 状态码
			statusCode = (String) condition.get("statusCode");
			String[] statusCodeArrayA = statusCode.split(",");
			statusCodeList = Arrays.asList(statusCodeArrayA);
		}
		String name = null; // 名称，模糊查询
		if (verifyExistKey(condition, "name")) {
			name = (String) condition.get("name");
		}
		String rootCode = null;// 根编码
		if (verifyExistKey(condition, "rootCode")) {
			rootCode = (String) condition.get("rootCode");
		}
		String baseTemplateCode = null; // 基础模板编码
		if (verifyExistKey(condition, "baseTemplateCode")) {
			baseTemplateCode = (String) condition.get("baseTemplateCode");
		}

		String orgCode = getOrgCode(); // 组织结构编码
		if (verifyExistKey(condition, "orgCode")) {
			orgCode = (String) condition.get("orgCode");
		} else {
			orgCode = this.getOrgCode();
		}
		
		// 医疗记录模板类型编码
		String typeCode = null;
		List<String> typeCodeList = new ArrayList<String>();
		String enTypeCode = null; // 就诊类型
		String dctNsF = null; // 就诊类型
		if (verifyExistKey(condition, "enTypeCode")) {
			enTypeCode = (String) condition.get("enTypeCode");
		}
		if (verifyExistKey(condition, "dctNsF")) {
			dctNsF = (String) condition.get("dctNsF");
		}
		String ownerTypeCode = null;
		String ownerCode = null;
		List<String> ownerCodeList = new ArrayList<String>();
		/**
		 * 当所属编码不为null时，所属编码可以为以','分隔的多个值
		 * 当所属编码为null，且所属类型ownerTypeCode不为空，从session获取ownerCode
		 * */
		if (verifyExistKey(condition, "ownerCode")) {
			ownerCode = (String) condition.get("ownerCode");
			// 查询参数所属编码，
			//ownerCodeList = Arrays.asList(ownerCode.split(","));
			String[] ownerCodeArray = ownerCode.split(",") ;
			for(String ownerCodeFor : ownerCodeArray){
				ownerCodeList.add(ownerCodeFor);
			}
			if(ownerCodeList.size() == 1 && (ownerCode.equalsIgnoreCase(Session.get().getOrgCd()) || ownerCode.equalsIgnoreCase(Session.get().getUserId()))){
				//当为一个值，且为全院或者个人时
			}else{
				List<String> ownerCodeListPri = getPriOwnerCodeList(enTypeCode);//该用户可以浏览的科室
				for(int i = 0 ; i < ownerCodeList.size() ; i++){
					String ownerCodeFor = ownerCodeList.get(i);
					if(ownerCodeFor.equalsIgnoreCase(Session.get().getOrgCd()) || ownerCodeFor.equalsIgnoreCase(Session.get().getUserId()) || ownerCodeListPri.contains(ownerCodeFor)){
						//为全院编码，个人编码，或者“可以浏览的科室”
					}else{
						ownerCodeList.remove(i);//删除掉
					}
				}
			}
			if(ownerCodeList.size() == 0){
				// 当没有owerCode，返回空数组
				ArrayResult<MrTemplate> rs = builder.build();
				rs.setTotal(0);
				rs.setPageNum(Integer.valueOf(pageNum));
				rs.setPageSize(Integer.valueOf(pageSize));
				return rs;
			}
		} else {
			// 查询参数不包含所属编码
			if (verifyExistKey(condition, "ownerTypeCode")) {
				ownerTypeCode = (String) condition.get("ownerTypeCode");
				Session session = Session.get();
				if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
					ownerCode = getOrgCode();// 全院，
					ownerCodeList.add(ownerCode);
				} else {
					if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
					//	ownerCode = session.getDeptId();// 科室
						ownerCodeList = getPriOwnerCodeList(enTypeCode);//该用户可以浏览的科室
					//	ownerCodeList.add(ownerCode);
					} else {
						ownerCode = session.getUserId();// 个人
						ownerCodeList.add(ownerCode);
					}
				}
				if(ownerCodeList.size() == 0){
					// 当没有owerCode，返回空数组
					ArrayResult<MrTemplate> rs = builder.build();
					rs.setTotal(0);
					rs.setPageNum(Integer.valueOf(pageNum));
					rs.setPageSize(Integer.valueOf(pageSize));
					return rs;
				}
			}else{//只能查看其权限范围内的模板，全院通用，出诊科室，个人
				ownerCode = getOrgCode();
				Session session = Session.get();
				ownerCodeList = getPriOwnerCodeList(enTypeCode);
				ownerCodeList.add(session.getOrgCd());
				ownerCodeList.add(session.getUserId());
			}
		}


		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1)* Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		

		/**
		 * 当病历类型typeCode不为null时，将该参数以','分隔，组成状态数组。
		 * 当病历类型typeCode为null，且病历模板自定义分类mrCategoryCode不为空
		 * ，获得病历类型typeCode数组。当病历类型typeCode为空数据时，返回
		 * */
		if (verifyExistKey(condition, "typeCode")) {
			typeCode = (String) condition.get("typeCode");
			String[] typeCodeArrayA = typeCode.split(",");
			typeCodeList = Arrays.asList(typeCodeArrayA);
		} else {
			String mrCategoryCode = null; // 自定义分类
			if (verifyExistKey(condition, "mrCategoryCode")) {
				mrCategoryCode = (String) condition.get("mrCategoryCode");
			}
			//if ( null != mrCategoryCode) {
				typeCodeList = getTypeCodeArrayByMrCategoryCode(enTypeCode,mrCategoryCode,dctNsF);
				if (null == typeCodeList || typeCodeList.size() == 0) {
					// 当没有关联的病历模板类型时，返回空数组
					ArrayResult<MrTemplate> rs = builder.build();
					rs.setPageNum(Integer.valueOf(pageNum));
					rs.setPageSize(Integer.valueOf(pageSize));
					rs.setTotal(0);
					return rs;
				}
			//}
		}
		
		/**
		 * 当模板适用编码不为null时，模板适用编码可以为以','分隔的多个值
		 * 当模板适用编码为null，且模板适用类型tplUseTypeCode不为空，从session获取tplUseCode
		 * */
		List<String> CodeList = new ArrayList<String>(); //模板编码列表
		String tplUseCode = null ; //
		String tplUseTypeCode = null ;
		List<String> tplUseCodeList = new ArrayList<String>();
		if (verifyExistKey(condition, "tplUseCode")) {
			tplUseCode = (String) condition.get("tplUseCode");
			tplUseCodeList = Arrays.asList(tplUseCode.split(","));// 查询参数模板适用编码，
		} else {
			// 查询参数不包含模板适用编码
			if (verifyExistKey(condition, "tplUseTypeCode")) {
				tplUseTypeCode = (String) condition.get("tplUseTypeCode");
				Session session = Session.get();
				if (ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(tplUseTypeCode)) {
					tplUseCode = getOrgCode();// 全院，
				} else {
					if (ApplyTo.DEPARTMENT.equalsIgnoreCase(tplUseTypeCode)) {
						tplUseCode = session.getDeptId();// 科室
					} else {
						tplUseCode = session.getUserId();// 个人
					}
				}
				tplUseCodeList.add(tplUseCode);
			}
		}
		if(tplUseCodeList.size() > 0){
			List<MrTplDept> tplDeptList = cusMrTplDeptDao.getTplDeptByDept(tplUseTypeCode, tplUseCodeList);
			if(null != tplDeptList && tplDeptList.size() > 0){
				for(MrTplDept  mrTplDept : tplDeptList ){
					CodeList.add(mrTplDept.getMrTplCd()) ;
				}
			}else{
				// 当无模板适用时，返回空数组
				ArrayResult<MrTemplate> rs = builder.build();
				rs.setTotal(0);
				rs.setPageNum(Integer.valueOf(pageNum));
				rs.setPageSize(Integer.valueOf(pageSize));
				return rs;
			}
		}
		long total = 0;
		if(tplUseCodeList.size() ==0 ||(   tplUseCodeList.size() > 0 && CodeList.size() >= 0)){		
			List<MrTpl> poList = cusDao.selectAll(
					CodeList
					,excludeDelete// 排除删除
					, statusCodeList// 状态码数组
					, name// 名称 模糊查询
					, rootCode// 根记录编码
					, orgCode // 组织机构编码
					, ownerTypeCode // 所属类型编码
					, ownerCodeList // 所属编码
					, typeCodeList// 医疗记录模板类型编码
					, baseTemplateCode // 基础模板编码
					,enTypeCode //就诊类型
					, options);
			if (null != poList && poList.size() > 0) {
				MrTemplate[] voArray = new MrTemplate[poList.size()];
				String[] signLevelCodes = new String[poList.size()];
				Map<String,HashMap<String,Boolean>> mapOnwer = new HashMap<String,HashMap<String,Boolean>>();
				for (int i = 0; i < poList.size(); i++) {
					MrTpl po = poList.get(i);
					MrTemplate vo = new MrTemplate();
					//根据用户权限，来判断是否具备条件					
					boolean canOperate = false;
					if(mapOnwer.containsKey(po.getOwnTpCd()) ){
						Map<String,Boolean> map = mapOnwer.get(po.getOwnTpCd()) ;
						if(map.containsKey(po.getOwnCd())){
							canOperate = ((Boolean)map.get(po.getOwnCd())).booleanValue();
						}else{
							canOperate =  this.userRoleCanCreate(po.getOwnTpCd(), po.getOwnCd());
							map.put(ownerCode, Boolean.valueOf(canOperate));				
						}
					}else{
						HashMap<String,Boolean> map = new HashMap<String,Boolean>();
						canOperate =  this.userRoleCanCreate(po.getOwnTpCd(), po.getOwnCd());
						map.put(po.getOwnCd(), Boolean.valueOf(canOperate));
						mapOnwer.put(po.getOwnTpCd(), map);
					}
					vo = transPo2Vo(po,canOperate);
					vo.setSignLevelCode(po.getMrSignLvlCd());	
					signLevelCodes[i] = po.getMrSignLvlCd() ;
					/*
					 * @param addSignLevel 当为1时，病历模板需要添加审签级别属性
					 * 
					 * @param deptCode 查询科室，根据科室得到审签级别
					 * 
					 * @param mainDiCode 主诊断编码
					 
					if (condition.containsKey("addSignLevel")
							&& ("1".equalsIgnoreCase((String) condition
									.get("addSignLevel")) || "true"
									.equalsIgnoreCase((String) condition
											.get("addSignLevel")))
							&& condition.containsKey("signDeptCode")
							&& null != condition.get("signDeptCode")) {
						String signDeptCode = (String) condition
								.get("signDeptCode");
	
						String mainDiCode = null;
						if (condition.containsKey("mainDiCode")
								&& null != condition.get("mainDiCode")) {
							mainDiCode = (String) condition.get("mainDiCode");
						}
						addSignLevel(vo, signDeptCode, mainDiCode);
					}*/
	
					voArray[i] = vo;
				}
				SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrSignLevel.OBJ_CD, signLevelCodes);
				if(null != simpleItems && simpleItems.length > 0 && null != simpleItems[0] ){
					for(int  i = 0 ; i < simpleItems.length ; i++){
						SimpleItem simpleItem = simpleItems[i];
						if(null!=simpleItem){
							voArray[i].setSignLevelName(simpleItems[i].getText());
						}
					}
				}
				builder.withData(voArray);
				total = options.getCount();
			}
		}else{
			ArrayResult<MrTemplate> rs = builder.build();
			rs.setPageNum(Integer.valueOf(pageNum));
			rs.setPageSize(Integer.valueOf(pageSize));
			rs.setTotal(0);
			return rs;
		}
		PerformancePrinter.start("pkuhit.iih.mr.tpl.MrTemplateService#search");
		ArrayResult<MrTemplate> rs = builder.build();
		rs.setTotal(Long.valueOf(total).intValue());
		rs.setPageNum(Integer.valueOf(pageNum));
		rs.setPageSize(Integer.valueOf(pageSize));
		return rs;
	}

	/**
	 * 根据操作人的角色列举他的科室
	 * 如果是全院模板管理员角色，能浏览全院、所有科室、他本人的模板，可以管理全院、所有科室、他本人的模板
	 * 如果是临床医生，能浏览全院、出诊科室、他本人的模板，可以管理全院、角色配置的科室、他本人的模板
	 * */
	private List<String> getPriOwnerCodeList(String enTypeCode) {
		Map DeptCodeMap = getPriDeptList(enTypeCode).getData();
		return (List<String>)DeptCodeMap.get("deptCodeList");
	}
	
	@Override
	//根据就诊类型获得可以管理和浏览的科室列表
	public SingleResult<Map> getPriDeptList(String enTypeCode) {
		Map<String, String> params = new HashMap<String, String>();
		Map DeptCodeMap = new HashMap();
		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class) ;
		Session session = Session.get() ;
		String userId = session.getUserId();
		String orgCode = session.getOrgCd();
		params.put("userId", userId);
		StringBuffer sbOrgCodes = new StringBuffer();
		List<String> listOrgCodes = new ArrayList<String>();
    	StringBuffer sbOrgNames = new StringBuffer();
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
        			maxUserRoleList.clear();
        			deptCodeForRole.clear();
        			deptNameForRole.clear();
        			maxUserRoleList.add(ORG_TEMPLATE_ROLE);
        			break;
        		}else if(enTypeCode.equalsIgnoreCase(EncounterType.INPATIENT) &&
        				(
        						ZY_EXCUTE_DOCTOR_ROLE.equalsIgnoreCase(ur.getRoleCode())
        					||   ZY_EXCUTE_NURSE_ROLE.equalsIgnoreCase(ur.getRoleCode())
        				 )
        				){
        			//住院，且有临床医生角色
        			if(!maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){
        				maxUserRoleList.add(ZY_EXCUTE_DOCTOR_ROLE);
        				if(!deptCodeForRole.contains(ur.getOrganizationCode())){
    	        			deptCodeForRole.add(ur.getOrganizationCode()); 
    	        			deptNameForRole.add(ur.getOrganizationName());
        				}
        			}
        		}else if(enTypeCode.equalsIgnoreCase(EncounterType.OUTPATIENT) && MZ_EXCUTE_DOCTOR_ROLE.equalsIgnoreCase(ur.getRoleCode())){
        			//门诊，且有门诊医生角色
        			if(!maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){
        				maxUserRoleList.add(MZ_EXCUTE_DOCTOR_ROLE);
        				if(!deptCodeForRole.contains(ur.getOrganizationCode())){
    	        			deptCodeForRole.add(ur.getOrganizationCode()); 
    	        			deptNameForRole.add(ur.getOrganizationName());
        				}
        			}
        		}else if(DEPT_TEMPLATE_ROLE.equalsIgnoreCase(ur.getRoleCode())){
        			if(!maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){
	        			maxUserRoleList.add(DEPT_TEMPLATE_ROLE);
	        			if(!deptCodeForRole.contains(ur.getOrganizationCode())){
		        			//科室管理员，可以看到自己管理的科室
		        			deptCodeForRole.add(ur.getOrganizationCode()); 
		        			deptNameForRole.add(ur.getOrganizationName());
	        			}
        			}
        		}
        			
			}
			if(maxUserRoleList.contains(ORG_TEMPLATE_ROLE)){
				//能浏览全院、所有科室、他本人的模板
    			/*获得所有业务科室*/
    			String deptCode = null ;
    			String deptTypeCode = ParameterUtils.enType2DeptType(enTypeCode) ;
    			ArrayResult<Organization> resultsD = organizationService.searchAllWardDept(deptCode, deptTypeCode);
    			if (resultsD != null && resultsD.hasData()) {
    				Organization[] orgs = resultsD.getDataList();
    	        	for(int j=0;j<orgs.length;j++){
    	                Organization org = orgs[j];
    	                if (sbOrgCodes.length() > 1) {
    	                	sbOrgCodes.append(",");
    	            		sbOrgNames.append(",");        	            		
    	                }
    	                listOrgCodes.add(org.getCode());
    	             sbOrgCodes.append(org.getCode());
    	             sbOrgNames.append(org.getName());
    	        	}
    			}
			}else{
				//如果有管理科室角色，列出所有管理科室
            	for(int m = 0 ; m < deptCodeForRole.size() ; m++){
            		String deptCode = deptCodeForRole.get(m) ;
	                if (sbOrgCodes.length() > 1) {
	                	sbOrgCodes.append(",");
	            		sbOrgNames.append(",");
	                }
	                listOrgCodes.add(deptCode);
	                sbOrgCodes.append(deptCode);
	                sbOrgNames.append(deptNameForRole.get(m));
            	}
            	//树上的科室列表 应该为  科室管理员的管理科室 与 临床医生出诊科室的合集
				/*if(maxUserRoleList.contains(ZY_EXCUTE_DOCTOR_ROLE) || maxUserRoleList.contains(MZ_EXCUTE_DOCTOR_ROLE)){
					//能浏览全院、出诊科室、他本人的模板
					
	    			//获得他的出诊科室
	    			Map<String, String> params1 = new HashMap<String, String>();
	    			params1.put("userId", userId);
	    			params1.put("orgCode", orgCode);
	    			ArrayResult<Organization> resultsD = organizationService.searchUserDepartments(params1);
	    			if (resultsD != null && resultsD.hasData()) {
	    				Organization[] orgs = resultsD.getDataList();
	    	        	for(int j=0;j<orgs.length;j++){
	    	        		//循环出诊科室
	    	                Organization org = orgs[j];
	    	                String curOrgCode = org.getCode() ;
	    	                if(!deptCodeForRole.contains(curOrgCode)){
	    	                	//如果当前出诊科室不在 科室管理之内
		    	                if (sbOrgCodes.length() > 1) {
		    	                	sbOrgCodes.append(",");
		    	            		sbOrgNames.append(",");
		    	                }
		    	                listOrgCodes.add(curOrgCode);
		    	                sbOrgCodes.append(curOrgCode);
		    	                sbOrgNames.append(org.getName());
	    	                }
	    	        	}
	    			}
				}*/
			}
			DeptCodeMap.put("deptCodeList", listOrgCodes);
			DeptCodeMap.put("deptCodeArr", sbOrgCodes.toString());
			DeptCodeMap.put("deptNameArr", sbOrgNames.toString());
		}
		builder.withData(DeptCodeMap);
		SingleResult<Map> rs = builder.build();
		return rs;
	}
	/**
	 * 根据自定义分类，获得相关联的病历类型，以 typeCode|typeCode 返回
	 * 
	 * @param enTpCd
	 *            就诊类型
	 * @param mrCategoryCode
	 *            自定义分类，单条或者多条（以,分隔）
	 * */
	private List<String> getTypeCodeArrayByMrCategoryCode(String enTpCd,String mrCategoryCode,String dctNsF) {
		String[] mrCategoryCodeArray = null;
		Map<String, String> typeCodeMap = null;
		if ( null!= mrCategoryCode && mrCategoryCode.contains(",")) {
			mrCategoryCodeArray = mrCategoryCode.split(",");
			List<MdMrTp> listAll = new ArrayList<MdMrTp>();
			for (String mrccat : mrCategoryCodeArray) {
				List<MdMrTp> list = cusMdMrTpDao.selectByEnTpCdAndDctNsF(enTpCd, mrccat,dctNsF);
				listAll.addAll(list);
			}
			typeCodeMap = removeDuplicateTypeCodeByMapList(listAll);
		} else {
			List<MdMrTp> list = cusMdMrTpDao.selectByEnTpCdAndDctNsF(enTpCd,mrCategoryCode,dctNsF);
			typeCodeMap = removeDuplicateTypeCodeByMapList(list);
		}
		if (null == typeCodeMap) {
			return new ArrayList<String>();
		}
		Set<String> keySet = typeCodeMap.keySet();
		Iterator<String> iterator = keySet.iterator();
		List<String> typeCodeList = new ArrayList<String>();
		while (iterator.hasNext()) {
			String typeCode = (String) iterator.next();
			log.debug("------根据自定义分类获得的类型数组为：" + typeCode);
			typeCodeList.add(typeCode);
		}
		return typeCodeList;
	}

	private Map<String, String> removeDuplicateTypeCodeByMapList(
			List<MdMrTp> list) {
		Map<String, String> resultMap = null;
		if (null != list && list.size() > 0) {
			resultMap = new HashMap<String, String>();
			for (MdMrTp po : list) {
				String typeCode = po.getMrTpCd();
				if (!resultMap.containsKey(typeCode)) {
					resultMap.put(typeCode, typeCode);
				}
			}
		}
		return resultMap;
	}

	/**
	 * 【医疗记录模板】删除服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#delete(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> delete(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(po.getMrTplStaCd()) || MrTemplateStatus.REJECTED
					.equalsIgnoreCase(po.getMrTplStaCd()) || MrTemplateStatus.STOPPED.equalsIgnoreCase(po.getMrTplStaCd()))) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				fileService.deleteFile(po.getFilePk());
				po.setUpdCnt(po.getUpdCnt().add(BigInteger.valueOf(1)));
				po.setDelF(Short.valueOf("1"));
				autoGenDao.markDelete(po);
				successCount++;
			}
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

	/**
	 * 【组合元素】提交服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#submit(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> submit(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(po.getMrTplStaCd())
					|| MrTemplateStatus.REJECTED.equalsIgnoreCase(po
							.getMrTplStaCd()) || MrTemplateStatus.REVIEWED
						.equalsIgnoreCase(po.getMrTplStaCd())
					)) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作 SUBMITTED
				po.setMrTplStaCd(MrTemplateStatus.SUBMITTED);
				autoGenDao.update(po);
				successCount++;
			}
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

	/**
	 * 【组合元素】审核通过服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#verify(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> verify(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!MrTemplateStatus.SUBMITTED
					.equalsIgnoreCase(po.getMrTplStaCd())) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrTplStaCd(MrTemplateStatus.REVIEWED);
				autoGenDao.update(po);
				successCount++;
			}
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

	/**
	 * 【组合元素】驳回已提交服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#reject(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> reject(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!MrTemplateStatus.SUBMITTED
					.equalsIgnoreCase(po.getMrTplStaCd())) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrTplStaCd(MrTemplateStatus.REJECTED);
				autoGenDao.update(po);
				successCount++;
			}
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

	/**
	 * 【医疗记录模板】发布服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#publish(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> publish(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!MrTemplateStatus.REVIEWED.equalsIgnoreCase(po.getMrTplStaCd())) {
				// 非已经状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrTplStaCd(MrTemplateStatus.ACTIVED);
				autoGenDao.update(po);
				String pageNum = "1";
				String pageSize = "1000";
				SelectOptions options = SelectOptions
						.get()
						.offset((Integer.valueOf(pageNum) - 1)
								* Integer.valueOf(pageSize))
						.limit(Integer.valueOf(pageSize)).count();
//				List<MrTpl> otherVersionPoList = this.cusDao.selectAll(new ArrayList<String>(),null,
//						new ArrayList<String>(), null, po.getRtMrTplPk(),
//						po.getOrgCd(), null, new ArrayList<String>(), new ArrayList<String>(),
//						null, options);
//				if (null != otherVersionPoList && otherVersionPoList.size() > 0) {
//					for (MrTpl other : otherVersionPoList) {
//						if (!other.getMrTplCd().equalsIgnoreCase(
//								po.getMrTplCd())) {
//							other.setMrTplStaCd(MrTemplateStatus.STOPPED);
//							other.setDelF(Short.valueOf("1"));
//						}
//					}
//					autoGenDao.batchUpdate(otherVersionPoList);
//				}
				successCount++;
			}
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

	/**
	 * 【医疗记录模板】停用服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#stop(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> stop(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!MrTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrTplStaCd())) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrTplStaCd(MrTemplateStatus.STOPPED);
				autoGenDao.update(po);
				successCount++;
			}
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

	/**
	 * 【医疗记录模板】启用服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#activate(java.lang.String[])
	 */
	@Override
	public SingleResult<BatchOperationResult> activate(
			ArrayInputModel arrayInputModel) {
		String[] ids = arrayInputModel.getIds();
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
			// 获取数据库持久化对象
			MrTpl po = autoGenDao.selectById(id);
			if (!(
					MrTemplateStatus.STOPPED.equalsIgnoreCase(po.getMrTplStaCd())
					||MrTemplateStatus.CREATED.equalsIgnoreCase(po.getMrTplStaCd())
					)){
				// 非停用状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrBaseTplCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrTplStaCd(MrTemplateStatus.ACTIVED);
				autoGenDao.update(po);
				String pageNum = "1";
				String pageSize = "1000";
				SelectOptions options = SelectOptions
						.get()
						.offset((Integer.valueOf(pageNum) - 1)
								* Integer.valueOf(pageSize))
						.limit(Integer.valueOf(pageSize)).count();
//				List<MrTpl> poList = cusDao.selectAll(new ArrayList<String>(),"", null, null,
//						po.getRtMrTplPk(), getOrgCode(), null, null, null,
//						null, options);
//				for (MrTpl po_stop : poList) {
//					if (po_stop.getMrBaseTplCd().equalsIgnoreCase(
//							po.getMrBaseTplCd())) {
//						continue;
//					}
//					po_stop.setMrTplStaCd(MrTemplateStatus.STOPPED);
//				}
//				autoGenDao.batchUpdate(poList);
				successCount++;
			}
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
	
	/**
     * 【医疗记录模板】启用服务（多记录）
     * 
     * @param ids
     *            多个记录主键
     * @return 批量更新结果医疗记录模板
     */
    /*
     * (non-Javadoc)
     * 
     * @see pkuhit.iih.mr.tpl.MrTemplateService#activate(java.lang.String[])
     */
    @Override
    public SingleResult<BatchOperationResult> defaultSet(ArrayInputModel arrayInputModel) {
        String[] ids = arrayInputModel.getIds();
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
            // 获取数据库持久化对象
            MrTpl po = autoGenDao.selectById(id);
            List<MrTpl> poList = cusDao.getMrTemplate(po.getOwnCd());
            if (null != poList && poList.size() > 0) {
                for (int n = 0; n < poList.size(); n++) {
                    MrTpl pon = poList.get(n);
                    pon.setDefaultF(Short.parseShort("0"));
                    autoGenDao.update(pon);
                }
            }
            po.setDefaultF(Short.parseShort("1"));
            autoGenDao.update(po);
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
        operationMessge.setMessage("操作结果：成功_" + successCount + "_个，失败_" + failCount + "个");
        result.setData(operationMessge);
        return result;

    }

	/**
	 * 标记删除。因为各节点查询 子节点 未完成
	 * 
	 * 【医疗记录模板】导航树
	 * 
	 * @param orgCode
	 *            院区编码
	 * @return 导航树
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#tree()
	 */
	@Override
	@Deprecated
	public TreeResult<TemplateNavigatorTreeData> tree(
			Map<String, String> condition) {
		// ■　查询导航树数据
		Composite<TemplateNavigatorTreeData> treeNode = null;

		// 如果是惰性加载，需要根据当前节点构造不同的节点包装器
		// 目前先简化处理，不支持惰性加载。
		if (true) {
			TemplateNavigatorTreeData treeData = new TemplateNavigatorTreeData();
			treeData.setHisOrgCode(this.getOrgCode());
			treeData.setHisOrgName("");
			treeNode = new MrTplHispitalTreeNode(treeData, condition);

			// 加载树数据
			treeNode.loadChildren();
			treeNode.setupCounter();
		}

		TreeNode<TemplateNavigatorTreeData> root = new TreeNode<TemplateNavigatorTreeData>();
		treeNode.copyToTreeNode(root);

		// ■　设置返回值
		TreeResult<TemplateNavigatorTreeData> result = new TreeResult<TemplateNavigatorTreeData>();
		result.setRoot(root);
		return result;
	}

	private String getOrgCode() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		if (StringUtils.isBlank(orgCd)) {
			orgCd = "SZLH";
		}
		return orgCd;
	}

	

	private String getStatusName(String statusCode) {
		return statusCode;
		/*
		 * DataObject object = dataObjectService.getObject(GeneralData.OBJ_CD,
		 * statusCode); return object.getObject(GeneralData.class).getName();
		 */
	}

	// 查询（所属，数目）
	@Override
	public ArrayResult<TemplateNavigatorTreeData> getCountByOrg(String orgCode,
			String ownerCodeJoin,String owerNameJoin,String keyWord,String enTypeCode ,String scTemplateCategoryCode ,String scTemplateTypeCode ,String statusCode,String dctNsF) {
		List<String> owerCodes = Arrays.asList(ownerCodeJoin.split(","));
		List<String> owerNames = Arrays.asList(owerNameJoin.split(","));
		List<String> scTemplateTypeCodeList = new ArrayList<String>();
		if( null != scTemplateTypeCode){
			scTemplateTypeCodeList.add(scTemplateTypeCode);
		}else{
			//if( null != scTemplateCategoryCode){
				scTemplateTypeCodeList = getTypeCodeArrayByMrCategoryCode(enTypeCode,scTemplateCategoryCode,dctNsF);			
			//}
		}
		
		// 根据orgCode获得 所属 对应的个数
		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder
				.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0 ;
		if(scTemplateTypeCodeList.size() > 0 ){
			List<Map<String, Object>> poList = cusDao.getCountByOrg(orgCode,
					owerCodes,keyWord, enTypeCode, scTemplateTypeCodeList,statusCode);
			if (poList.size() > 0) {
				// 循环
				int i = 1;
				total = poList.size();
				int hispital = 0 ; int person = 0; 
				voArray = new TemplateNavigatorTreeData[Math.max(5, poList.size()+2)]; //排序，顺序为全院通用 ，科室...，个人，所以最小长度为3，然后再截取数组
				for (Map<String, Object> map : poList) {
					TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
					String ownerTypeCode = (String) (map.get("OWN_TP_CD"));
					String ownerCode = (String) (map.get("OWN_CD"));
					BigDecimal count = (BigDecimal) (map.get("TPL_CNT"));
					String ownerName = owerNames.get(owerCodes.indexOf(ownerCode));
					model.setHisOrgCode(orgCode);
					model.setOwnerCode(ownerCode);
					model.setOwnerTypeCode(ownerTypeCode);
					model.setNodeType(TemplateNavigatorTreeNodeType.OWNER);
					model.setId(ownerCode);
					model.setText(ownerName + "（"
							+ String.valueOf(count.longValue()) + "）");
					model.setOwnerName(ownerName);
					if(ownerTypeCode.equalsIgnoreCase(OwnerType.HOSPITAL_WIDE)){
						voArray[0] = model;//排序，全院通用第一
						hispital = 1 ;//有全院通用
					}else if(ownerTypeCode.equalsIgnoreCase(OwnerType.PERSONAL)){
						voArray[voArray.length -1 ] = model;//排序，个人 最后
						person = 1 ;//有个人
					}else{
						voArray[i] = model; //在全院通用后，开始累加
						i++;
					}
				}
				TemplateNavigatorTreeData[] voArrayRs = null;
/*				if(total < 3 ){
					//新建数组，遍历voArray数组，复制非空对象到新数组
					voArrayRs = new TemplateNavigatorTreeData[total];
					int y = 0;
					for(int x = 0 ; x < 3 ; x++){
						TemplateNavigatorTreeData vo = voArray[x];
						if(null != vo){
							voArrayRs[y] = vo;
							y++;
						}
					}
				}else{*/
					
					int rsSize = hispital + i-1 + person ;//新的数组总长度
					voArrayRs = new TemplateNavigatorTreeData[rsSize];
					if(hispital == 1){
						voArrayRs[0] = voArray[0] ; 
					}
					if(person == 1 ){
						voArrayRs[rsSize-1] = voArray[voArray.length -1] ;
					}
					for(int z = 0 ; z < i -1 ; z++){
						TemplateNavigatorTreeData vo = voArray[z + 1];
						if(null != vo){
							voArrayRs[hispital + z] = vo ;
						}
					}
				
					//voArrayRs = Arrays.copyOfRange(voArray,1,i+hispital);
				//}
/*				TemplateNavigatorTreeData[] voArray_new = new TemplateNavigatorTreeData[i];
				voArray_new = Arrays.copyOf(voArray, i);*/
				builder.withData(voArrayRs);
				total = i;
			}
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;

	}

	@Override
	public ArrayResult<TemplateNavigatorTreeData> getCountOfMrTlCategoryByOwner(
			String orgCode, String ownerCode,String keyWord,String enTypeCode,String scTemplateCategoryCode ,String scTemplateTypeCode,String statusCode,String dctNsF) {
		// 根据院区，所属获得，第一层自定义分类 对应的
		List<Map<String, Object>> poList = cusDao
				.getCountOfMrTlCategoryByOwner(orgCode, ownerCode,keyWord, enTypeCode,scTemplateCategoryCode,scTemplateTypeCode, statusCode,dctNsF);

		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder
				.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0;
		if (poList.size() > 0) {
			// 循环
			voArray = new TemplateNavigatorTreeData[poList.size()];
			int i = 0;
			total = poList.size();
			for (Map<String, Object> map : poList) {
				TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
				String templateCategoryCode = (String) (map
						.get("MR_TP_CCAT_CD"));
				BigDecimal count = (BigDecimal) (map.get("TPL_CNT"));

/*				MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao
						.selectById(templateCategoryCode);*/
				String templateCategoryName =  (String) (map
						.get("NM"));
				// 当为叶节点时，类型为自定义类型叶节点
//				if (mdMrTpCcat.getLeafF().intValue() == 1) {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRLEAFCATEGORY);
//				} else {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
//				}
				model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
				model.setHisOrgCode(orgCode);
				model.setOwnerCode(ownerCode);
				model.setTemplateCategoryCode(templateCategoryCode);
				model.setTemplateCategoryName(templateCategoryName);
				model.setId(templateCategoryCode);
				model.setText(templateCategoryName + "（"
						+ String.valueOf(count.longValue()) + "）");
				voArray[i] = model;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;
	}

	@Override
	public ArrayResult<TemplateNavigatorTreeData> getCountByMrTlCategoryByCategory(String orgCode, String ownerCode, String mrCategoryCode,String keyWord,String enTypeCode,String dctNsF) {
		// 根据院区，个人获得，非第一层，非叶自定义分类 对应的 。当传入条件为叶类型时，得到该叶类型对应的模板个数。
		List<Map<String, Object>> poList = cusDao.getCountByMrTlCategoryByCategory(orgCode, ownerCode,mrCategoryCode,keyWord, enTypeCode,dctNsF);
		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder
				.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0;
		if (poList.size() > 0) {
			// 循环
			voArray = new TemplateNavigatorTreeData[poList.size()];
			int i = 0;
			total = poList.size();
			for (Map<String, Object> map : poList) {
				TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
				String templateCategoryCode = (String) (map
						.get("MR_TP_CCAT_CD"));
				BigDecimal count = (BigDecimal) (map.get("TPL_CNT"));

				MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao
						.selectById(templateCategoryCode);
				String templateCategoryName = mdMrTpCcat.getNm();
				// 当为叶节点时，类型为自定义类型叶节点
//				if (mdMrTpCcat.getLeafF().intValue() == 1) {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRLEAFCATEGORY);
//				} else {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
//				}
				model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
				model.setHisOrgCode(orgCode);
				model.setOwnerCode(ownerCode);
				model.setTemplateCategoryCode(templateCategoryCode);
				model.setTemplateCategoryName(templateCategoryName);
				model.setId(templateCategoryCode);
				model.setText(templateCategoryName + "（"
						+ String.valueOf(count.longValue()) + "）");
				voArray[i] = model;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;
	}

	@Override
	public ArrayResult<TemplateNavigatorTreeData> getCountByMrTlCategoryByLeafCategory(
			String orgCode, String ownerCode, String leafMrCategoryCode,String keyWord,String enTypeCode,String scTemplateTypeCode,String statusCode,String dctNsF) {
		// 根据院区，个人获得，叶自定义分类 对应的
		List<Map<String, Object>> poList = cusDao.getCountByMrTlCategoryByLeafCategory(orgCode, ownerCode,
						leafMrCategoryCode,keyWord, enTypeCode,scTemplateTypeCode, statusCode,dctNsF);
		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0;
		if (poList.size() > 0) {
			// 循环
			voArray = new TemplateNavigatorTreeData[poList.size()];
			int i = 0;
			total = poList.size();
			for (Map<String, Object> map : poList) {
				TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
				String templateTypeCode = (String) (map.get("MR_TP_CD"));
				BigDecimal count = (BigDecimal) (map.get("TPL_CNT"));
/*				SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
						MrType.OBJ_CD, templateTypeCode);*/
				String templateTypeName = (String) (map.get("NM"));
				model.setHisOrgCode(orgCode);
				model.setOwnerCode(ownerCode);
				model.setTemplateCategoryCode(leafMrCategoryCode);
				model.setTemplateTypeCode(templateTypeCode);
				model.setTemplateTypeName(templateTypeName);
				model.setNodeType(TemplateNavigatorTreeNodeType.MRTYPE);
				model.setId(templateTypeCode);
				model.setText(templateTypeName + "（"
						+ String.valueOf(count.longValue()) + "）");
				voArray[i] = model;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;

	}

	@Override
	public ArrayResult<MrTemplate> getCountByMrTlCategoryByType(String orgCode,
			String ownerCode, String TypeCode,String keyWord,String enTypeCode) {
		List<MrTpl> poList = cusDao.getCountByMrTlCategoryByType(orgCode,
				ownerCode, TypeCode,keyWord, enTypeCode);
		ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder
				.newArrayResult(MrTemplate.class);
		MrTemplate[] voArray = null;
		int total = 0;
		if (poList != null && poList.size() > 0) {
			voArray = new MrTemplate[poList.size()];
			List<String> statusCodeList = new ArrayList<String>();
			String[] statusCodeArr = new String[poList.size()];
			total = poList.size();
			int i = 0;
			for (MrTpl po : poList) {
				voArray[i] = transPo2TreeVo(po);
				statusCodeList.add(po.getMrTplStaCd());
				statusCodeArr[i] = po.getMrTplStaCd() ;
				i++;
				
			}
			SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrTemplateStatus.OBJ_CD, statusCodeArr);
			for(int j = 0 ;j <voArray.length ; j++){
				voArray[j].setStatusName(simpleItems[j].getText());
			}
			builder.withData(voArray);
		}
		ArrayResult<MrTemplate> result = builder.build();
		result.setTotal(total);
		return result;
	}
	private MrTemplate transPo2TreeVo(MrTpl po) {
		MrTemplate vo = new MrTemplate();
		vo.setCode(po.getMrTplCd());
		vo.setName(po.getNm());
		vo.setFilePk(po.getFilePk());
		vo.setMrTypeCode(po.getMrTpCd());
		vo.setSignLevelCode(po.getMrSignLvlCd());
		return vo;
	}
	private String getColValueFromMap(Map<String, Object> po,String key){
		String value = null ;
		if(po.containsKey(key)){
			Object o = po.get(key) ;
			if(o!= null){
				value = (String)o;
			}
		}
		return value ;
	}
	private MrTemplate transPo2SimpleVo(Map<String, Object> po){
		MrTemplate vo = new MrTemplate();
		vo.setCode(getColValueFromMap(po,"MR_TPL_CD")); //code主键
		vo.setName(getColValueFromMap(po,"NM"));//名称
		vo.setFilePk(getColValueFromMap(po,"FILE_PK"));//模板文件主键
		vo.setStatusCode(getColValueFromMap(po,"MR_TPL_STA_CD"));//状态编码
		vo.setStatusName(getColValueFromMap(po,"MR_TPL_STA_NM"));//状态名称
		vo.setMemo(getColValueFromMap(po,"DES"));//描述
		vo.setOwnerTypeCode(getColValueFromMap(po,"OWN_TP_CD"));//所属类型编码
		vo.setOwnerTypeName(getColValueFromMap(po,"OWN_TP_NM"));//所属类型名称
		vo.setOwnerCode(getColValueFromMap(po,"OWN_CD"));//所属编码
		vo.setOwnerName(getColValueFromMap(po,"OWN_NM"));//所属名称
		vo.setMrTypeCode(getColValueFromMap(po,"MR_TP_CD"));//类型编码
		vo.setMrTypeName(getColValueFromMap(po,"MR_TP_NM"));//类型名称
		vo.setDefaultName(getColValueFromMap(po,"DEFAULT_NAME"));//默认模板
		vo.setSignLevelCode(getColValueFromMap(po,"MR_SIGN_LVL_CD"));//审签级别编码
		vo.setSignLevelName(getColValueFromMap(po,"MR_SIGN_LVL_NM"));//审签级别名称
		vo.setDiCodeArray(new String[]{getColValueFromMap(po,"DI_CD")});//关联病种code
		vo.setDiCodes(getColValueFromMap(po,"DI_CD"));//关联病种code
		vo.setDiNameArray(new String[]{getColValueFromMap(po,"DI_NM")});//关联病种name
		vo.setDiNames(getColValueFromMap(po,"DI_NM"));//关联病种name
		return vo;
	}
	
	private MrTemplate transPo2Vo(MrTpl po,Boolean canOperate) {
		MrTemplate vo = new MrTemplate();
		BeanCopyUtil.entityToModel(vo, po, MrTemplate.OBJ_CD,
		dictionaryService);
		vo.setCode(po.getMrTplCd());
		vo.setName(po.getNm());
		vo.setFilePk(po.getFilePk());
//		vo.setRootCode(po.getRtMrTplPk());
		String ownerTypeCode = vo.getOwnerTypeCode();
		String ownerCode = vo.getOwnerCode();
		String ownerName = null;
		if (null != ownerTypeCode || null != ownerCode) {
			if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
				// 全院，
				SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
						Organization.OBJ_CD, ownerCode);
				log.debug("pkuhit.iih.mr.tpl.MrTemplateServiceImpl.transPo2Vo(MrTpl)----全院---id:"
						+ po.getMrTplCd()
						+ "--------------------------"
						+ ownerCode);
				if (verify(simpleItems)) {
					ownerName = simpleItems[0].getText();
				}
			} else {
				if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
					log.debug("pkuhit.iih.mr.tpl.MrTemplateServiceImpl.transPo2Vo(MrTpl)----科室------id:"
							+ po.getMrTplCd()
							+ "-----------------------"
							+ ownerCode);
					// 科室
					 DataObject[] objects = dataObjectService.getObjects(Organization.OBJ_CD, ownerCode);
					 if(null != objects && objects.length > 0 && null != objects[0] ){
							 DataObject object = objects[0] ;
							 ownerName =(String)object.getValue("name");
					 }
				} else {
					log.debug("pkuhit.iih.mr.tpl.MrTemplateServiceImpl.transPo2Vo(MrTpl)------个人--------id:"
							+ po.getMrTplCd()
							+ "-------------------"
							+ ownerCode);
					// 个人

					 DataObject object = dataObjectService.getObject(Employee.OBJ_CD, ownerCode);
					 if(null != object ){
						 ownerName =(String)object.getValue("name");
					 }
				}
			}
		}
		vo.setOwnerName(ownerName);
		
		//boolean canOperate = this.userRoleCanOperate(vo.getOwnerTypeCode(), vo.getOwnerCode());
		if(!canOperate){
			vo.setCanUpgrade(0);
			vo.setCanDelete(0);
			vo.setCanSubmit(0);
			vo.setCanReview(0);
			vo.setCanReject(0);
			vo.setCanPublish(0);
			vo.setCanCancelReview(0);
			vo.setCanStop(0);
			vo.setCanActivated(0);
			vo.setCanUpdate(0);
		}else{
			if (!(MrTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrTplStaCd()) || MrTemplateStatus.STOPPED
					.equalsIgnoreCase(po.getMrTplStaCd()))) {
				vo.setCanUpgrade(0);
			} else {
				vo.setCanUpgrade(1);// 升级
			}
			if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(po.getMrTplStaCd()) || MrTemplateStatus.REJECTED
					.equalsIgnoreCase(po.getMrTplStaCd()))) {
	//			vo.setCanUpdate(0);
				vo.setCanDelete(0);
			} else {
	//			vo.setCanUpdate(1);// 更新
				vo.setCanDelete(1);// 删除
			}
			vo.setCanUpdate(1);// 始终可以更新,目前任何状态都可以修改。
			//vo.setCanUpdate( userRoleCanCreate(vo.getOwnerTypeCode(),vo.getOwnerCode()).booleanValue()?1:0);
			if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(po.getMrTplStaCd()) || MrTemplateStatus.REJECTED
					.equalsIgnoreCase(po.getMrTplStaCd()))) {
				vo.setCanSubmit(0);
			} else {
				vo.setCanSubmit(1);// 提交,
			}
			if (!MrTemplateStatus.SUBMITTED.equalsIgnoreCase(po.getMrTplStaCd())) {
				vo.setCanReview(0);
				vo.setCanReject(0);
			} else {
				vo.setCanReview(1);// 审批
				vo.setCanReject(1);// 驳回
			}
			if (!MrTemplateStatus.REVIEWED.equalsIgnoreCase(po.getMrTplStaCd())) {
				vo.setCanPublish(0);
				vo.setCanCancelReview(0);
			} else {
				vo.setCanPublish(1);// 发布
				vo.setCanCancelReview(1);// 取消审核
			}
			if (!MrTemplateStatus.ACTIVED.equalsIgnoreCase(po.getMrTplStaCd())) {
				vo.setCanStop(0);
			} else {
				vo.setCanStop(1);// 停用
			}
			if (!(MrTemplateStatus.STOPPED.equalsIgnoreCase(po.getMrTplStaCd()) )) {
				vo.setCanActivated(0);
			} else {
				vo.setCanActivated(1); //启用
			}
		}
		// 适应病种
		List<MrTplDi> diList = cusMrTplDiDao.getDiListByTpl(vo.getCode());
		if (diList.size() > 0) {
			String[] diCodeArray = new String[diList.size()];
			StringBuffer diCodesb = new StringBuffer();
			int i = 0;
			for (MrTplDi td : diList) {
				if (i > 0) {
					diCodesb.append(",");
				}
				diCodesb.append(td.getDiCd()) ;
				diCodeArray[i] = td.getDiCd();
				i++;
			}
			PerformancePrinter.start("dictionaryService.getSimpleItems");
			SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
					DiagnosisDict.OBJ_CD, diCodeArray);
			PerformancePrinter.end("dictionaryService.getSimpleItems");
			if (verify(simpleItems)) {
				String[] diNameArray = new String[diList.size()];
				StringBuffer diNamesb = new StringBuffer();
				i = 0;
				for (SimpleItem si : simpleItems) {
					String diName = si.getText();
					diNameArray[i] = diName;
					if (i > 0) {
						diNamesb.append(",");
					}
					diNamesb.append(diName);
				}
				vo.setDiCodeArray(diCodeArray);
				vo.setDiNameArray(diNameArray);
				vo.setDiCodes(diCodesb.toString());
				vo.setDiNames(diNamesb.toString());
			}
		}
		//模板适用
		List<MrTplDept> tplDeptList = cusMrTplDeptDao.getTplDeptByTpl(po.getMrTplCd());
		if(null != tplDeptList && tplDeptList.size() > 0){
			 String tplUseTypeCode = null;//模板适用类型编码
			 String tplUseTypeName = null;//模板适用类型名称
			 String[] tplUseCodeArray = new String[tplDeptList.size()];// 模板适用编码数组
			 String[] tplUseNameArray = new String[tplDeptList.size()]; //模板适用名称数组
			 StringBuffer tplUseCodes = new StringBuffer() ; //模板适用编码 以,分隔 
			 StringBuffer tplUseNames = new StringBuffer();//模板适用名称 以,分隔
			 tplUseTypeCode = tplDeptList.get(0).getAplToTpCd() ;
			 if (ApplyTo.HOSPITAL_WIDE.equalsIgnoreCase(tplUseTypeCode)) {
					// 全院，
				 tplUseTypeName = "全院通用";
				 MrTplDept mrTplDept = tplDeptList.get(0) ;
				 String tplUseCode = mrTplDept.getAplToCd();
				 String tplUseName = null ;
				 tplUseCodeArray[0] = tplUseCode ;
				 tplUseCodes.append(tplUseCode);
				 SimpleItem[] simpleItems = dictionaryService.getSimpleItems(Organization.OBJ_CD, tplUseCode);
				 if(null != simpleItems && simpleItems.length > 0 && null!= simpleItems[0] ){
					 tplUseName = simpleItems[0].getText() ;
					 log.debug("全院通用-------------"+tplUseName);
				 }
/*				 DataObject object = dataObjectService.getObject(Organization.OBJ_CD, tplUseCode);
				 if(null != object ){
				  tplUseName =(String)object.getValue("name");
				 }*/
				 tplUseNameArray[0] = tplUseName ;
				 tplUseNames.append(tplUseName);
			 } else if(ApplyTo.PERSONAL.equalsIgnoreCase(tplUseTypeCode)) {
						// 科室
				 tplUseTypeName = "个人";
				 MrTplDept mrTplDept = tplDeptList.get(0) ;
				 String tplUseCode = mrTplDept.getAplToCd();
				 String tplUseName = null ;
				 tplUseCodeArray[0] = tplUseCode ;
				 tplUseCodes.append(tplUseCode);
				 SimpleItem[] simpleItems = dictionaryService.getSimpleItems(Employee.OBJ_CD, tplUseCode);
				 if(null != simpleItems && simpleItems.length > 0 &&  null!= simpleItems[0] ){
					 tplUseName = simpleItems[0].getText() ;
					 log.debug("个人-------------"+tplUseName);
				 }
				 DataObject object = dataObjectService.getObject(Employee.OBJ_CD, tplUseCode);
				 if(null != object ){
					 tplUseName =(String)object.getValue("name");
				 }
				 tplUseNameArray[0] = tplUseName ;
				 tplUseNames.append(tplUseName);
			 } else {
				 tplUseTypeName = "科室";
				 for(int i = 0 ; i < tplDeptList.size() ; i++){
					 MrTplDept mrTplDept = tplDeptList.get(i); 
					 String tplUseCode = mrTplDept.getAplToCd();
					 if (i > 0) {
						 tplUseCodes.append(",");
					 }
					 tplUseCodeArray[i] = tplUseCode ;
					 tplUseCodes.append(tplUseCode);
				 }
/*				 SimpleItem[] simpleItems = dictionaryService.getSimpleItems(Organization.OBJ_CD, tplUseCodeArray);
				 if(null != simpleItems && simpleItems.length > 0 && null!= simpleItems[0] ){
					 for(int i = 0 ; i < simpleItems.length ; i++  ){
						SimpleItem item = simpleItems[i] ;
						String tplUseName = item.getText() ;
						tplUseNameArray[i] = tplUseName ;
						 if (i > 0) {
							 tplUseNames.append(",");
						 }
						 tplUseNames.append(tplUseName);
					 }
				 }*/
				 DataObject[] objects = dataObjectService.getObjects(Organization.OBJ_CD, tplUseCodeArray);
				 if(null != objects && objects.length > 0 && null != objects[0] ){
					 for(int i = 0 ; i < objects.length ; i++  ){
						 DataObject object = objects[i] ;
						 String tplUseName =(String)object.getValue("name");
						 log.debug("科室-------------"+tplUseName);
						 tplUseNameArray[i] = tplUseName ;
						 if (i > 0) {
							 tplUseNames.append(",");
						 }
						 tplUseNames.append(tplUseName);
					 }
					 
				 }
			 }
			 vo.setTplUseTypeCode(tplUseTypeCode);
			 vo.setTplUseTypeName(tplUseTypeName);
			 vo.setTplUseCodeArray(tplUseCodeArray);
			 vo.setTplUseCodes(tplUseCodes.toString());
			 vo.setTplUseNameArray(tplUseNameArray);
			 vo.setTplUseNames(tplUseNames.toString());
		}
		//默认模板
		if(vo.getDefaultF()!=null){
			if(vo.getDefaultF()==Short.parseShort("0")){
			    vo.setDefaultName("否");
			}else if(vo.getDefaultF()==Short.parseShort("1")){
	            vo.setDefaultName("是");
	        }else{
	            vo.setDefaultName("否");
	        }
		}else{
			vo.setDefaultName("否");
		}
		
		return vo;

	}

	/**
	 * 作废，因为审签级别是 病历模板的属性，不再外置查询
	 * 为病历模板添加 审签级别
	 * */
	@Deprecated
	public MrTemplate addSignLevel(MrTemplate vo, String deptCode,
			String mainDiCode) {
		MdMrTpSignLvl sl = null;
		String lvlCode = null ;
		try {
			sl = cusMdMrTpSignLvlDao.selectByTpDi(deptCode, vo.getMrTypeCode(),
					mainDiCode);
		} catch (Exception e) {
		}
		if (null != sl) {
			lvlCode = sl.getMrSignLvlCd() ;
			vo.setSignLevelCode( lvlCode );
		} else {
			try {
				sl = cusMdMrTpSignLvlDao.selectByTpDi(deptCode,
						vo.getMrTypeCode(), null);
			} catch (Exception e) {
			}
			if (null != sl) {
				lvlCode = sl.getMrSignLvlCd() ;
				vo.setSignLevelCode( lvlCode );
			} else {
				String orgCode = Session.get().getOrgCd();
				if (null != orgCode) {
					sl = cusMdMrTpSignLvlDao.selectByTpDi(orgCode,
							vo.getMrTypeCode(), null);
					if (null != sl) {
						lvlCode = sl.getMrSignLvlCd() ;
						vo.setSignLevelCode( lvlCode );
					}
				}
			}
		}
		if(null != lvlCode ){
			SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrSignLevel.OBJ_CD, lvlCode);
			if(simpleItems.length > 0 && null != simpleItems[0] ){
				vo.setSignLevelName(simpleItems[0].getText());
			}
		}
		return vo;
	}

	private boolean verify(SimpleItem[] simpleItems) {
		 if(null != simpleItems && simpleItems.length > 0 && null!= simpleItems[0] ){
			 return true;
		 }
		 else {
			return false;
		}
	}

	@Override
	public TreeResult<TemplateNavigatorTreeData> getTree(
			Map<String, String> condition) {
		
		//需要查询的科室字符串
		String deptCodeJoin = condition.get("deptCodeArr");
		String deptNameJoin = condition.get("deptNameArr");
		
		TemplateNavigatorTreeData rootNode = new TemplateNavigatorTreeData() ;
		String sessionOrgName = "模板树根节点";
		if(condition.containsKey("SessionOrgName")){
			sessionOrgName = condition.get("SessionOrgName");
		}		
		rootNode.setHisOrgCode(getOrgCode());
		rootNode.setHisOrgName(sessionOrgName);
		rootNode.setId("rootCode");
		rootNode.setText(sessionOrgName);
		//TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("",TemplateNavigatorTreeData.class);
		TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("/",sessionOrgName,rootNode);
		TemplateNavigatorTreeData io = new TemplateNavigatorTreeData();
		io.setNodeType(TemplateNavigatorTreeNodeType.ORG);
		io.setHisOrgCode(getOrgCode());
		String keyWord = null ;
		if(this.verifyExistKey(condition, "name")){
			keyWord = (String)condition.get("name");
		}
		io.setKeyWord(keyWord);
		String enTypeCode = null ;
		if(this.verifyExistKey(condition, "enTypeCode")){
			enTypeCode = (String)condition.get("enTypeCode");
		}
		io.setEnTypeCode(enTypeCode);
		String dctNsF = null ;
		if(this.verifyExistKey(condition, "dctNsF")){
			dctNsF = (String)condition.get("dctNsF");
		}
		io.setDctNsF(dctNsF);
	//	Map map = condition.get("condition");
		
		String scTemplateCategoryCode = null ;
		if(this.verifyExistKey(condition, "mrCategoryCode")){
			scTemplateCategoryCode = (String)condition.get("mrCategoryCode");
		}
		io.setScTemplateCategoryCode(scTemplateCategoryCode);
		String scTtemplateTypeCode = null ;
		if(this.verifyExistKey(condition, "typeCode")){
			scTtemplateTypeCode = (String)condition.get("typeCode");
		}
		io.setScTemplateTypeCode(scTtemplateTypeCode);
		
		String statusCode = null ;
		if(this.verifyExistKey(condition, "statusCode")){
			statusCode = (String)condition.get("statusCode");
		}
		io.setScStatusCode(statusCode);
		
		//io.setText("深圳龙华医院");
		 Session session = Session.get();
		 //院区编码
		String orgCode = session.getOrgCd() ;
		String orgName = "全院通用";//this.getOrgName() ;
		String userId = session.getUserId() ;
		String userName = "个人";//session.getUserName();
		long start = System.currentTimeMillis();
		builder = buildChildrenTree(builder, io,"/",orgCode+","+userId+","+deptCodeJoin,orgName+","+userName+","+deptNameJoin);
		TreeNode<TemplateNavigatorTreeData> tree = builder.build();
		TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
		r.setRoot(tree);
		long end = System.currentTimeMillis();
		System.out.println("-------------------------------:"
				+ String.valueOf(end - start));
		return r;

	}

	
	private TreeBuilder<TemplateNavigatorTreeData>  buildChildrenTree(TreeBuilder<TemplateNavigatorTreeData> builder ,TemplateNavigatorTreeData parentNode,String parentPath,String ownerCodeJoin,String owerNameJoin){
		/**
		 * 当输入参数为空时，从session中获取orgCode
		 * 根据节点类型来调用不同的子节点查询接口。
		 * 拼装成树状返回
		 * */
		 //当没有参数时，返回第一层,根据用户业务角色返回所属树
		 Session session = Session.get();
		 //院区编码
		String orgCode = session.getOrgCd() ;
		

		ArrayResult<TemplateNavigatorTreeData> resultTree = null; 
		ArrayResult<MrTemplate> resultLeaf = null;
		//TreeBuilder<TemplateNavigatorTreeData> builder  =null;
		if(null == parentNode || null == parentNode.getNodeType()){
			resultTree = getCountByOrg(orgCode,ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.ORG)){
			if(null == parentNode.getHisOrgCode() ){
			resultTree = getCountByOrg(orgCode,ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
			}else{
				resultTree = getCountByOrg(parentNode.getHisOrgCode(),ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
			}
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
			resultTree = getCountOfMrTlCategoryByOwner(parentNode.getHisOrgCode(), parentNode.getOwnerCode(),parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){/*自定义分类一层，非树状
			resultTree = getCountByMrTlCategoryByCategory(parentNode.getHisOrgCode(), parentNode.getOwnerCode(), parentNode.getTemplateCategoryCode(),parentNode.getKeyWord());
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRLEAFCATEGORY)){*/
			resultTree = getCountByMrTlCategoryByLeafCategory(parentNode.getHisOrgCode(), parentNode.getOwnerCode(), parentNode.getTemplateCategoryCode(),parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}/* 不需要显示模板else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRTYPE)){
			resultLeaf = getCountByMrTlCategoryByType(parentNode.getHisOrgCode(), parentNode.getOwnerCode(), parentNode.getTemplateTypeCode(),parentNode.getKeyWord());
		}*/			
		if(null!=resultTree && null == resultLeaf ){
		if (resultTree.getDataList() != null)
        {
            for (TemplateNavigatorTreeData node : resultTree.getDataList())
            {
            	node.setLeaf(Boolean.FALSE);
            	node.setChecked(Boolean.FALSE);
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData): id     :"+node.getId());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData): text   :"+node.getText());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):nodeType:"+node.getNodeType());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):ownCode :"+node.getOwnerCode());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):cateCode:"+node.getTemplateCategoryCode());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):typeCode:"+node.getTemplateTypeCode());
            	node.setKeyWord(parentNode.getKeyWord());
            	node.setEnTypeCode(parentNode.getEnTypeCode());
            	node.setScTemplateCategoryCode(parentNode.getScTemplateCategoryCode());
            	node.setScTemplateTypeCode(parentNode.getScTemplateTypeCode());
            	node.setScStatusCode(parentNode.getScStatusCode());
            	node.setDctNsF(parentNode.getDctNsF());
            	
            	String currentPath = null;//parentPath+parentPath.replace("/", "")+"_"+node.getId();
            	if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
            		currentPath = "/_" + node.getOwnerCode() ;
            	}else if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){
            		node.setOwnerName(parentNode.getOwnerName());
            		currentPath = "/_" + node.getOwnerCode() + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode() ;
            	}else if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRTYPE)){
            		node.setOwnerName(parentNode.getOwnerName());
            		currentPath = "/_" + node.getOwnerCode() + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode()
            				    + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode() +"_"+node.getTemplateTypeCode();
            	}
            	log.debug("parentPath:"+parentPath);
            	log.debug("currentPath:"+currentPath);
            	if(!parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){//当父节点类型不为自定义分类时
	            	builder = buildChildrenTree(
	            			builder.addChildByData( currentPath, node.getText(), node) 
	            			,node 
	            			,currentPath+"/"
	            			,""
	            			,"");
            	}else{
            		//node.setLeaf(Boolean.TRUE);
            		builder.addChildByData( currentPath, node.getText(), node) ;
            	}
            }
        }}else{/*
			//当叶节点（模板名称）
			//TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("root", new TemplateNavigatorTreeData());
	        if (resultLeaf.getDataList() != null)
	        {
	            for (MrTemplate tpl : resultLeaf.getDataList())
	            {
	            	TemplateNavigatorTreeData node = new TemplateNavigatorTreeData();
	            	node.setTemplateCode(tpl.getCode());
	            	node.setTemplateName(tpl.getName());
	            	node.setId(tpl.getCode());
	            	node.setText(tpl.getName()+"（"+tpl.getStatusName()+"）");
	            	node.setFilePk(tpl.getFilePk());
	            	node.setLeaf(Boolean.TRUE);
	            	node.setHisOrgCode(parentNode.getHisOrgCode());
	            	node.setOwnerTypeCode(parentNode.getOwnerTypeCode());
	            	node.setOwnerCode(parentNode.getOwnerCode());
	            	node.setTemplateTypeCode(parentNode.getTemplateTypeCode());
	            	String id = "";
	            	if(null != parentNode.getOwnerCode()){
	            		id = "/"+node.getOwnerCode();
	            	}
	            	if(null != parentNode.getTemplateCategoryCode()){
	            		id = id +"/"+ node.getTemplateCategoryCode();
	            	}
	            	if(null != parentNode.getTemplateTypeCode()){
	            		id = id +"/"+ node.getTemplateTypeCode();
	            	}
	            	if(null  == node.getId()){
	            		id = id + "/"+ node.getText();
	            		log.error("-----------------------------------------------------------------------");
	            	}else{
	            		id = id +"/"+ tpl.getCode() ;
	            	}
	            	String currentPath = parentPath+ "/"+ node.getId();
	            	log.error("currentPath:"+currentPath);
	            	builder = builder.addChildByData( currentPath, tpl.getName(), node,Boolean.TRUE);
	            }
	        }
        */}
		return builder;	
		
	}
	
	
	
	/**
	 * 查询病历文书类型列表。需要按照树形结构在名称中进行缩进。
	 * @param condition.keyWord 搜索关键字
	 * @return
	 */
	@Override
	public ArrayResult<MrType> searchMrTypeCode(Map<String, String> condition){
		String keyWord = null ;
		if(this.verifyExistKey(condition, "keyWord")){
			keyWord = (String)condition.get("keyWord");
		}
		String enTypeCode = null ; //就诊类型
		if (verifyExistKey(condition, "enTypeCode")) {
			enTypeCode = (String) condition.get("enTypeCode");

		}
		String dctNsF = null ; //就诊类型
		if (verifyExistKey(condition, "dctNsF")) {
			dctNsF = (String) condition.get("dctNsF");
			
		}
		String mrCategoryCode = null; // 自定义分类
		if (verifyExistKey(condition, "mrCategoryCode")) {
				mrCategoryCode = (String) condition.get("mrCategoryCode");
		}
		List<String> typeCodeList = new ArrayList<String>();
		if( null != enTypeCode || null != mrCategoryCode ){
			typeCodeList = getTypeCodeArrayByMrCategoryCode(enTypeCode,mrCategoryCode,dctNsF);
		}
		List<MdMrTp> poList = cusMdMrTpDao.selectTypeCodeTree(typeCodeList, keyWord,dctNsF);
		ArrayResultBuilder<MrType> builder = ArrayResultBuilder.newArrayResult(MrType.class);
		MrType[]  voArray = null ;
		int total = 0;
		if(poList != null && poList.size() > 0){
			voArray = new MrType[poList.size()];
			total = poList.size() ;
			int i = 0 ;
			String[] signLevelCodes = new String[poList.size()];
			for(MdMrTp po : poList){
				MrType vo = new MrType();
				vo.setSignLevelCode(po.getMrSignLvlCd());	
				signLevelCodes[i] = po.getMrSignLvlCd() ;
				BeanCopyUtil.entityToModel(vo, po, MrTemplate.OBJ_CD, dictionaryService);
				voArray[i] = vo ;
				i++;
			}
			SimpleItem[] simpleItems = dictionaryService.getSimpleItems(MrSignLevel.OBJ_CD, signLevelCodes);
			if(null != simpleItems && simpleItems.length > 0 && null != simpleItems[0] ){
				for(int  j = 0 ; j < simpleItems.length ; j++){
					voArray[j].setSignLevelName(simpleItems[j].getText());
				}
			}
			builder.withData(voArray);
		}
		ArrayResult<MrType> result = builder.build();
		result.setTotal(total);
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
	public ArrayResult<MrTypeCustomCategory> searchMrCCatCode(
			Map<String, String> condition) {
		String enTypeCode = null ;
		if (verifyExistKey(condition, "enTypeCode")) {
			enTypeCode = (String) condition.get("enTypeCode");
		}
		List<MdMrTpCcat> poList = cusMdMrTpCcatDao.selectByEnTpCd(enTypeCode,1) ;
		
		ArrayResultBuilder<MrTypeCustomCategory> builder = ArrayResultBuilder.newArrayResult(MrTypeCustomCategory.class);
		MrTypeCustomCategory[]  voArray = null ;
		int total = 0;
		if(poList != null && poList.size() > 0){
			voArray = new MrTypeCustomCategory[poList.size()];
			total = poList.size() ;
			int i = 0 ;
			String[] signLevelCodes = new String[poList.size()];
			for(MdMrTpCcat po : poList){
				MrTypeCustomCategory vo = new MrTypeCustomCategory();
				BeanCopyUtil.entityToModel(vo, po, MrTypeCustomCategory.OBJ_CD, dictionaryService);
				voArray[i] = vo ;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<MrTypeCustomCategory> result = builder.build();
		result.setTotal(total);
		return result;
		
	}

	@Override
	public SingleResult<Boolean> HasDuplicationOfName(String code ,String name,String ownDeptCd) {
		SingleResultBuilder<Boolean> builder = SingleResultBuilder
				.newSingleResult(Boolean.class);
		Boolean isDuplicationOfName = Boolean.TRUE ;
		
		int count = this.cusDao.getCountOfName(Session.get().getOrgCd(),code,name,ownDeptCd);
		if(count == 0){
			isDuplicationOfName =  Boolean.FALSE ; 
		}
		builder.withData(isDuplicationOfName);
		SingleResult<Boolean> rs = builder.build();
		return rs;
	}
	
	@Override
    public SingleResult<Map>  searchMrBTemplateFile(String code) {
        SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
        try{
            builder.withData(this.searchFilePk(code));
        }catch(Exception e){
            e.printStackTrace();
        }
        SingleResult<Map> rs = builder.build();
        return rs;
    }
	
	/**
     * 查询基础模板的filePk
     * @param code 模板code
     * */
    private Map searchFilePk(String code) throws IOException{
        Map rs = new HashMap();
        MrTpl mrTpl = autoGenDao.selectById(code);
        MrBaseTpl mrBaseTpl = baseTemplateDao.selectById(mrTpl.getMrBaseTplCd());
        FileObject file = fileService.getFile(mrBaseTpl.getFilePk());
        if(null != file){
            String odtFile = new String(file.asByteArray());
            rs.put("odtFile", odtFile);
        }
        return rs;
    }
    
    @Override
    public SingleResult<Map>  searchMrBTemplateFileByFilePk(String filePk) {
        SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
        try{
            builder.withData(this.searchFileByFilePk(filePk));
        }catch(Exception e){
            e.printStackTrace();
        }
        SingleResult<Map> rs = builder.build();
        return rs;
    }
    
    /**
     * 查询基础模板的filePk
     * @param code 模板code
     * */
    private Map searchFileByFilePk(String filePk) throws IOException{
        Map rs = new HashMap();
        FileObject file = fileService.getFile(filePk);
        if(null != file){
            String odtFile = new String(file.asByteArray());
            rs.put("odtFile", odtFile);
        }
        return rs;
    }
    
    
    /**
	 * 【医疗记录模板】停用服务（多记录）
	 * 
	 * @param id
	 *            多个记录主键
	 * @return 批量更新结果医疗记录模板
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrTemplateService#upSort(java.lang.String[])
	 */
	@Override
	public SingleResult<Map> changeSort(String selCode,String tagCode,String model) {
		SingleResultBuilder<Map> builder = SingleResultBuilder.newSingleResult(Map.class);
        try{
        	MrTpl po = autoGenDao.selectById(selCode);
    		MrTpl poTag = autoGenDao.selectById(tagCode);
    		String sortSel = po.getSortNo();
    		String sortTag = poTag.getSortNo();
    		int tempSort = 0,maxSort=0;
    		if(sortSel!=null && sortSel.length()!=0 && (sortTag==null || sortTag.equals(""))){
    			tempSort = Integer.parseInt(sortSel);
    			if(model.equals("up")){
					tempSort = tempSort +1;
					sortTag = tempSort+"";
				}else if(model.equals("down")){
					tempSort = tempSort -1;
					sortTag = tempSort+"";
				}
			}else if(sortTag!=null && sortTag.length()!=0 && (sortSel==null || sortSel.equals(""))){
				tempSort = Integer.parseInt(sortTag);
    			if(model.equals("up")){
					tempSort = tempSort -1;
					sortSel = tempSort+"";
				}else if(model.equals("down")){
					tempSort = tempSort +1;
					sortSel = tempSort+"";
				}
			}if((sortSel==null || sortSel.equals("")) && (sortTag==null || sortTag.equals(""))){
				//全都为空的时候如何设置
				tempSort = cusDao.getCounts();
				maxSort = cusDao.getMaxSortNo()+2;
    			if(model.equals("up")){
					sortSel = maxSort+"";
					sortTag = (maxSort-1)+"";
				}else if(model.equals("down")){
					sortTag = maxSort+"";
					sortSel = (maxSort-1)+"";
				}
			}
    		if(sortSel!=null && sortSel.length()!=0 && sortTag!=null && sortTag.length()!=0){
    			int sortSelNum = Integer.parseInt(sortSel);
    			int sortTagNum = Integer.parseInt(sortTag);
    			if(sortSelNum==sortTagNum){
    				if(model.equals("up")){
    					sortTagNum = sortSelNum-1;
    				}else if(model.equals("down")){
    					sortTagNum = sortSelNum+1;
    				}
    				sortTag = sortTagNum+"";
    			}
    			po.setSortNo(sortTag);
    			poTag.setSortNo(sortSel);
    			autoGenDao.update(po);
    			autoGenDao.update(poTag);
    		}
            builder.withData(po);
        }catch(Exception e){
            e.printStackTrace();
        }
        SingleResult<Map> rs = builder.build();
        return rs;
	}
	
	public String getSortNoFormat(int sortNo){
		String rs = null;
		if(sortNo<10){
			rs = "0000"+sortNo;
		}else if(sortNo<100 && sortNo>9){
			rs = "000"+sortNo;
		}else if(sortNo<1000 && sortNo>99){
			rs = "00"+sortNo;
		}else if(sortNo<10000 && sortNo>999){
			rs = "0"+sortNo;
		}else{
			rs = sortNo+"";
		}
		return rs;
	}
	
	@Override
	public SingleResult<Map<String,Object>> searchTree(MrFormXml mrFormXml) throws IOException{
		SingleResult<Map<String,Object>> result = new SingleResult<Map<String,Object>>();
		//获取xml文件
		List<Map<String,Object>> xmlList = new ArrayList<Map<String,Object>>();
		//String path = "d:\\ls.xml";
//		(new FileInputStream(file),"utf-8")
		//String xmlStr = this.readFileByLines(path);
		String xmlStr = null;
		if (mrFormXml.getXmlFile()!=null && mrFormXml.getXmlFile().length()!=0) {
			xmlStr = mrFormXml.getXmlFile();
			System.err.println(xmlStr);
		}
		SAXReader saxReader = new SAXReader();
		Document docx= null;
		try{
			if(xmlStr!=null && xmlStr.length()!=0){
				docx= (Document) saxReader.read(new StringReader(xmlStr));
			}else{
				return result;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		Element rootElem = docx.getRootElement(); //根节点<data-record>
		List<?> listOne = rootElem.elements();
		Element bodyElem = (Element) listOne.get(0);//正文<office:table>
		
		HeaderInital = bodyElem.attributeValue("HeaderInital");
		MaxRowCount = bodyElem.attributeValue("MaxRowCount");
		HeaderRowCount = bodyElem.attributeValue("HeaderRowCount");
		
		List<?> listBody = bodyElem.elements();
		List<?> listSon = null,listChild = null;
		List<Map<String,Object>> listRange=null;
		Map<String,Object> segmTree = null,rangeTree = null;
		for (int i = 0; i < listBody.size(); i++) { //开始解析文档
			Element elemOne = (Element) listBody.get(i);
			if ("emr-e".equals(elemOne.getName()) && elemOne.attributeValue("start").equals("true")) {//解析中碰到<segment>
				listSon = elemOne.elements();
				segmTree = new HashMap<String,Object>();
				for(int j = 0; j < listSon.size(); j++){
					Element elemSon = (Element) listSon.get(j);
					if(elemSon.attributeValue("name").equals("CUSTORM_RANGE")){
						listChild = elemSon.elements();
						listRange = new ArrayList<Map<String,Object>>();
						for(int n=0;n<listChild.size();n++){
							Element elemChild = (Element) listChild.get(n);
							rangeTree = new HashMap<String,Object>();
							rangeTree.put("name", elemChild.attributeValue("name"));
							rangeTree.put("value", elemChild.attributeValue("value"));
							rangeTree.put("thumbnail", elemChild.attributeValue("thumbnail"));
							listRange.add(rangeTree);
						}
						segmTree.put(elemSon.attributeValue("name"), listRange);
					}else{
						segmTree.put(elemSon.attributeValue("name"), elemSon.attributeValue("value"));
					}
				}
				xmlList.add(segmTree);
			}
		}
		
		// 返回结果map
		Map<String,Object> mapResult = new HashMap<String,Object>();
		mapResult.put("text", "root");
		
		//获取到xml的数据List
		List<Map<String,Object>> firstChild = new ArrayList<Map<String,Object>>();
		Map<String,Object>  mfirstChild = null;
		String deCd = null,mrElementTypeName = null,mrElementNm = null,descriptions = null,showFormat=null,
		freeeditFlag = null,precision = null,minValue = null,maxValue = null,normalMinValue = null,normalMaxValue = null,regular = null,dateTimeValue=null;
		List<?> custormRange = null;
		if (null != xmlList && xmlList.size() > 0) {
			mfirstChild = new HashMap<String,Object>();
			for (int i = 0; i < xmlList.size(); i++) {
				deCd = (String)xmlList.get(i).get("DE_CD");
				mrElementTypeName = (String)xmlList.get(i).get("MR_ELEMENT_TYPE_NAME");
				if(mrElementTypeName!=null && mrElementTypeName.length()!=0){
				}else{
					mrElementTypeName = "Text";
				}
				mrElementNm = (String)xmlList.get(i).get("MR_ELEMENT_NM");
				descriptions = (String)xmlList.get(i).get("DESCRIPTIONS");
				freeeditFlag = (String)xmlList.get(i).get("FREEEDIT_FLAG");
				custormRange = (List<?>)xmlList.get(i).get("CUSTORM_RANGE");
				precision = (String)xmlList.get(i).get("PRECISION");
				showFormat = (String)xmlList.get(i).get("SHOW_FORMAT");
				minValue = (String)xmlList.get(i).get("MIN_VALUE");
				maxValue = (String)xmlList.get(i).get("MAX_VALUE");
				normalMinValue = (String)xmlList.get(i).get("NORMAL_MIN_VALUE");
				normalMaxValue = (String)xmlList.get(i).get("NORMAL_MAX_VALUE");
				regular = (String)xmlList.get(i).get("REGULAR");
				dateTimeValue = (String)xmlList.get(i).get("DATE_TIME_VALUE");
				
				//判断该类型下是否有数据
				mfirstChild = new HashMap<String,Object>();
				mfirstChild.put("id","deCd_col"+(i+1));
				mfirstChild.put("deCd",deCd);
				mfirstChild.put("text",descriptions);
				mfirstChild.put("descriptions",descriptions);
				mfirstChild.put("mrElementNm",mrElementNm);
				mfirstChild.put("mrElementTypeName",mrElementTypeName);
				mfirstChild.put("descriptions",descriptions);
				mfirstChild.put("showFormat",showFormat);
				mfirstChild.put("freeeditFlag",freeeditFlag);
				mfirstChild.put("custormRange",custormRange);
				mfirstChild.put("precision",precision);
				mfirstChild.put("minValue",minValue);
				mfirstChild.put("maxValue",maxValue);
				mfirstChild.put("normalMinValue",normalMinValue);
				mfirstChild.put("normalMaxValue",normalMaxValue);
				mfirstChild.put("regular",regular);
				mfirstChild.put("dateTimeValue",dateTimeValue);
				mfirstChild.put("leaf",true);
				firstChild.add(mfirstChild);
			}
		}
		mapResult.put("children",firstChild );

		result.setData(mapResult);
		return result;
	}
	
	@Override
	public SingleResult<Map<String,Object>> createXml(MrFormXml mrFormXml) throws IOException{
		SingleResult<Map<String,Object>> result = new SingleResult<Map<String,Object>>();
		Map<String,Object> mapResult = new HashMap<String,Object>();
		Map<String,Object> treeNode = null,itemNode = null;
		List<Map<String,Object>> tree = mrFormXml.getMrFormXml();
		
		// 创建根节点并添加进文档
		Document doc = DocumentHelper.createDocument();
		
		//Root document configure
        String version = "1.2";
        String xmlnsOffice = "urn:oasis:names:tc:opendocument:xmlns:office:1.0";
        String xmlnsText = "urn:oasis:names:tc:opendocument:xmlns:text:1.0";
        String xmlnsTable = "urn:oasis:names:tc:opendocument:xmlns:table:1.0";
        String xmlnsXsi = "http://www.w3.org/2001/XMLSchema-instance";
        String xmlnsXsd = "http://www.w3.org/2001/XMLSchema";

		//Def namespace
        Namespace officeNamespace = new Namespace("office", xmlnsOffice);
        
		Element root = doc.addElement(new QName("document-content",officeNamespace));
		root.addNamespace("text", xmlnsText);
		root.addNamespace("table", xmlnsTable);
		root.addNamespace("xsi", xmlnsXsi);
		root.addNamespace("xsd", xmlnsXsd);
		root.addAttribute("office:version", version);
		//下一级子节点
		Element mainElement = root.addElement("table:table");
		mainElement.addAttribute("HeaderInital", HeaderInital);
		mainElement.addAttribute("MaxRowCount", MaxRowCount);
		mainElement.addAttribute("HeaderRowCount", HeaderRowCount);
		Element childElement = null,attrElement = null,thirdElement = null;
        String deCd = null,mrElementTypeName=null,mrElementNm=null,showFormat=null,regular="",freeeditFlag=null,dateTimeValue=null,descriptions=null,precision=null,minValue=null,maxValue=null,normalMinValue = null,normalMaxValue = null,name="",value="",thumbnail="";
        List<Map<String,Object>> custormRange = null;
        if (tree!=null) {
			for(int i=0;i<tree.size();i++){
				treeNode = (Map<String,Object>)tree.get(i);
				deCd = (String)treeNode.get("deCd");
				mrElementTypeName = (String)treeNode.get("mrElementTypeName");
				mrElementNm = (String)treeNode.get("mrElementNm");
				descriptions = (String)treeNode.get("descriptions");
				showFormat = (String)treeNode.get("showFormat");
				dateTimeValue = (String)treeNode.get("dateTimeValue");
				precision = (String)treeNode.get("precision");
				minValue = (String)treeNode.get("minValue");
				maxValue = (String)treeNode.get("maxValue");
				normalMinValue = (String)treeNode.get("normalMinValue");
				normalMaxValue = (String)treeNode.get("normalMaxValue");
				freeeditFlag = (String)treeNode.get("freeeditFlag");
				regular = (String)treeNode.get("regular");
				custormRange = (List<Map<String,Object>>)treeNode.get("custormRange");
				//元素节点
				childElement = mainElement.addElement("text:emr-e");
				childElement.addAttribute("text:start", "true");
				attrElement = childElement.addElement("text:property");
				attrElement.addAttribute("text:name", "DE_CD");
				attrElement.addAttribute("text:value", deCd);
				attrElement = childElement.addElement("text:property");
				attrElement.addAttribute("text:name", "MR_ELEMENT_TYPE_NAME");
				attrElement.addAttribute("text:value", mrElementTypeName);
				attrElement = childElement.addElement("text:property");
				attrElement.addAttribute("text:name", "MR_ELEMENT_NM");
				if(mrElementTypeName.equals("Text") && mrElementNm == null){
					attrElement.addAttribute("text:value", descriptions);
				}else{
					attrElement.addAttribute("text:value", mrElementNm);
				}
				attrElement = childElement.addElement("text:property");
				attrElement.addAttribute("text:name", "DESCRIPTIONS");
				attrElement.addAttribute("text:value", descriptions);
				if(showFormat!=null && showFormat.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "SHOW_FORMAT");
					attrElement.addAttribute("text:value", showFormat);
				}
				if(dateTimeValue!=null && dateTimeValue.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "DATE_TIME_VALUE");
					attrElement.addAttribute("text:value", dateTimeValue);
				}
				if(precision!=null && precision.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "PRECISION");
					attrElement.addAttribute("text:value", precision);
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "REGULAR");
					attrElement.addAttribute("text:value", regular);
				}
				if(freeeditFlag!=null && freeeditFlag.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "FREEEDIT_FLAG");
					attrElement.addAttribute("text:value", freeeditFlag);
				}
				if(minValue!=null && minValue.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "MIN_VALUE");
					attrElement.addAttribute("text:value", minValue);
				}
				if(maxValue!=null && maxValue.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "MAX_VALUE");
					attrElement.addAttribute("text:value", maxValue);
				}
				if(normalMinValue!=null && normalMinValue.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "NORMAL_MIN_VALUE");
					attrElement.addAttribute("text:value", normalMinValue);
				}
				if(normalMaxValue!=null && normalMaxValue.length()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "NORMAL_MAX_VALUE");
					attrElement.addAttribute("text:value", normalMaxValue);
				}
				if(custormRange!=null && custormRange.size()!=0){
					attrElement = childElement.addElement("text:property");
					attrElement.addAttribute("text:name", "CUSTORM_RANGE");
					for(int j=0;j<custormRange.size();j++){
						itemNode = (Map<String,Object>)custormRange.get(j);
						name = (String)itemNode.get("name");
						value = (String)itemNode.get("value");
						thumbnail = (String)itemNode.get("thumbnail");
						thirdElement =  attrElement.addElement("text:sub-item");
						thirdElement.addAttribute("text:name", name);
						thirdElement.addAttribute("text:value", value);
						thirdElement.addAttribute("text:thumbnail", thumbnail);
					}
				}
				//元素节点
				childElement = mainElement.addElement("text:emr-e");
				childElement.addAttribute("text:start", "false");
			}
		}
        String resultStr = null;
        OutputFormat format = OutputFormat.createCompactFormat(); //createPrettyPrint() 层次格式化
		StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(doc);
            writer.close();
            output.close();
            resultStr = this.convert(writer.toString());
            System.err.println("doc="+resultStr);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        mapResult.put("resultStr", resultStr);
		result.setData(mapResult);
		return result;
	}
	
	/** 
	* 将字符串转成unicode 
	* @param str 待转字符串 
	* @return unicode字符串 
	*/ 
	public String convert(String str){ 
		str = (str == null ? "" : str); 
		String tmp;
		StringBuffer sb = new StringBuffer(1000); 
		char c; 
		int i, j; 
		sb.setLength(0); 
		for (i = 0; i < str.length(); i++){ 
			c = str.charAt(i); 
			sb.append("\\u"); 
			j = (c >>>8); //取出高8位 
			tmp = Integer.toHexString(j); 
			if (tmp.length() == 1) 
			sb.append("0"); 
			sb.append(tmp); 
			j = (c & 0xFF); //取出低8位 
			tmp = Integer.toHexString(j); 
			if (tmp.length() == 1) 
			sb.append("0"); 
			sb.append(tmp); 
		} 
		System.err.println("sb=="+new String(sb));
		return (new String(sb)); 
	} 
	 
	/**
     * 以行为单位读取文件
     */
    public String readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sb = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
            	sb.append(tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
            return sb.toString();
        }
    }
    
    
	/**
	 *  【医疗记录模板】前台查询服务查询服务（多记录）
	* @param orgCode //组织机构编码
	* @param ownerTypeCode //所属类型编码
	* @param ownerCode //所属编码
	* @param typeCode// 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param mrCategoryCode 单个或者多个医疗记录模板类型编码  ，以 | 分隔
	* @param 
	* @param enTypeCode 就诊类型
	* @param pageNum 当前页数    从1开始。默认值为1，
	* @param pageSize 每页记录数   默认值25
	* @return 
	 */
	@Override
	public ArrayResult<MrTemplate> searchTemplateToUse(Map condition) {
		PerformancePrinter.start("searchTemplateToUse");
		long start = System.currentTimeMillis();
		ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder.newArrayResult(MrTemplate.class);
		String pageNum = null;
		String pageSize = null;
		if (condition.containsKey("pageNum")&& condition.containsKey("pageSize")) {
			pageNum = (String) condition.get("pageNum");
			pageSize = (String) condition.get("pageSize");
		}
		if (null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize)) {
			pageNum = "1";
			pageSize = "25";
		}

		String orgCode = getOrgCode(); // 组织结构编码
		if (verifyExistKey(condition, "orgCode")) {
			orgCode = (String) condition.get("orgCode");
		} else {
			orgCode = this.getOrgCode();
		}
		String name = null; // 名称，模糊查询
		if (verifyExistKey(condition, "name")) {
			name = (String) condition.get("name");
		}
		// 医疗记录模板类型编码
		String typeCode = null;
		List<String> typeCodeList = new ArrayList<String>();
		String enTypeCode = null; // 就诊类型
		String dctNsF = null; // 就诊类型
		if (verifyExistKey(condition, "enTypeCode")) {
			enTypeCode = (String) condition.get("enTypeCode");
		}
		String ownerTypeCode = null;
		String ownerCode = null;
		List<String> ownerCodeList = new ArrayList<String>();
		/**
		 * 当所属编码不为null时，所属编码可以为以','分隔的多个值
		 * 当所属编码为null，且所属类型ownerTypeCode不为空，从session获取ownerCode
		 * */
		if (verifyExistKey(condition, "ownerCode")) {
			ownerCode = (String) condition.get("ownerCode");
			// 查询参数所属编码，
			//ownerCodeList = Arrays.asList(ownerCode.split(","));
			String[] ownerCodeArray = ownerCode.split(",") ;
			for(String ownerCodeFor : ownerCodeArray){
				ownerCodeList.add(ownerCodeFor);
			}
			if(ownerCodeList.size() == 1 && (ownerCode.equalsIgnoreCase(Session.get().getOrgCd()) || ownerCode.equalsIgnoreCase(Session.get().getUserId()))){
				//当为一个值，且为全院或者个人时
			}else{
				List<String> ownerCodeListPri = getPriOwnerCodeList(enTypeCode);//该用户可以浏览的科室
				for(int i = 0 ; i < ownerCodeList.size() ; i++){
					String ownerCodeFor = ownerCodeList.get(i);
					if(ownerCodeFor.equalsIgnoreCase(Session.get().getOrgCd()) || ownerCodeFor.equalsIgnoreCase(Session.get().getUserId()) || ownerCodeListPri.contains(ownerCodeFor)){
						//为全院编码，个人编码，或者“可以浏览的科室”
					}else{
						ownerCodeList.remove(i);//删除掉
					}
				}
			}
			if(ownerCodeList.size() == 0){
				// 当没有owerCode，返回空数组
				ArrayResult<MrTemplate> rs = builder.build();
				rs.setTotal(0);
				rs.setPageNum(Integer.valueOf(pageNum));
				rs.setPageSize(Integer.valueOf(pageSize));
				return rs;
			}
		} else {
			// 查询参数不包含所属编码
			if (verifyExistKey(condition, "ownerTypeCode")) {
				ownerTypeCode = (String) condition.get("ownerTypeCode");
				Session session = Session.get();
				if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
					ownerCode = getOrgCode();// 全院，
					ownerCodeList.add(ownerCode);
				} else {
					if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
					//	ownerCode = session.getDeptId();// 科室
						ownerCodeList = getPriOwnerCodeList(enTypeCode);//该用户可以浏览的科室
					//	ownerCodeList.add(ownerCode);
					} else {
						ownerCode = session.getUserId();// 个人
						ownerCodeList.add(ownerCode);
					}
				}
				if(ownerCodeList.size() == 0){
					// 当没有owerCode，返回空数组
					ArrayResult<MrTemplate> rs = builder.build();
					rs.setTotal(0);
					rs.setPageNum(Integer.valueOf(pageNum));
					rs.setPageSize(Integer.valueOf(pageSize));
					return rs;
				}
			}else{//只能查看其权限范围内的模板，全院通用，出诊科室，个人
				ownerCode = getOrgCode();
				Session session = Session.get();
				ownerCodeList = getPriOwnerCodeList(enTypeCode);
				ownerCodeList.add(session.getOrgCd());
				ownerCodeList.add(session.getUserId());
			}
		}


		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1)* Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
		

		/**
		 * 当病历类型typeCode不为null时，将该参数以','分隔，组成状态数组。
		 * 当病历类型typeCode为null，且病历模板自定义分类mrCategoryCode不为空
		 * ，获得病历类型typeCode数组。当病历类型typeCode为空数据时，返回
		 * */
		if (verifyExistKey(condition, "typeCode")) {
			typeCode = (String) condition.get("typeCode");
			String[] typeCodeArrayA = typeCode.split(",");
			typeCodeList = Arrays.asList(typeCodeArrayA);
		} else {
			String mrCategoryCode = null; // 自定义分类
			if (verifyExistKey(condition, "mrCategoryCode")) {
				mrCategoryCode = (String) condition.get("mrCategoryCode");
			}
			//if ( null != mrCategoryCode) {
				typeCodeList = getTypeCodeArrayByMrCategoryCode(enTypeCode,mrCategoryCode,dctNsF);
				if (null == typeCodeList || typeCodeList.size() == 0) {
					// 当没有关联的病历模板类型时，返回空数组
					ArrayResult<MrTemplate> rs = builder.build();
					rs.setPageNum(Integer.valueOf(pageNum));
					rs.setPageSize(Integer.valueOf(pageSize));
					rs.setTotal(0);
					return rs;
				}
			//}
		}
		
		List<String> CodeList = new ArrayList<String>(); //模板编码列表
		if(ownerCodeList.size() == 0){
			//没有可查询的所属列表
			ArrayResult<MrTemplate> rs = builder.build();
			rs.setPageNum(Integer.valueOf(pageNum));
			rs.setPageSize(Integer.valueOf(pageSize));
			rs.setTotal(0);
			return rs;
		}
		long total = 0;
		 List<Map<String, Object>> poList = cusDao.selectAllToUse(
					orgCode // 组织机构编码
					,name //名称模糊查询
					, ownerTypeCode // 所属类型编码
					, ownerCodeList // 所属编码
					, typeCodeList// 医疗记录模板类型编码
					,enTypeCode //就诊类型
					, options);
			if (null != poList && poList.size() > 0) {
				MrTemplate[] voArray = new MrTemplate[poList.size()];
				for (int i = 0; i < poList.size(); i++) {
					Map<String, Object> po = poList.get(i);
					MrTemplate vo = new MrTemplate();
					vo = transPo2SimpleVo(po);
					voArray[i] = vo;
				}
				builder.withData(voArray);
				total = options.getCount();
			}
			PerformancePrinter.end("searchTemplateToUse");
			long end = System.currentTimeMillis();
			System.out.print("searchTemplateToUse:");
			System.out.println(end-start);
		ArrayResult<MrTemplate> rs = builder.build();
		rs.setTotal(Long.valueOf(total).intValue());
		rs.setPageNum(Integer.valueOf(pageNum));
		rs.setPageSize(Integer.valueOf(pageSize));
		return rs;
	}
	
	/**
     *  【医疗记录模板】前台查询服务查询服务（多记录）
    * @param name//名称 模糊查询
    * @param hospitalArea //医院编码
    * @param departCode //科室编码
    * @param userCode //用户编码
    * @param mrCategoryCode 医疗记录模板类型分组编码
    * @param typeCode// 医疗记录模板类型编码
    * @return 
     */
    @Override
    public ArrayResult<MrTemplate> searchTemplateToCreate(Map condition) {
        PerformancePrinter.start("searchTemplateToCreate");
        long start = System.currentTimeMillis();
        ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder.newArrayResult(MrTemplate.class);

        String name = null; // 名称，模糊查询
        if (verifyExistKey(condition, "name")) {
            name = (String) condition.get("name");
        }
        String hospitalArea = null;
        if (verifyExistKey(condition, "hospitalArea")) {
            hospitalArea = (String) condition.get("hospitalArea");
        }
        String departCode = null;
        if (verifyExistKey(condition, "departCode")) {
            departCode = (String) condition.get("departCode");
        }
        String userCode = null;
        if (verifyExistKey(condition, "userCode")) {
            userCode = (String) condition.get("userCode");
        }
        String mrCategoryCode = null;
        if (verifyExistKey(condition, "mrCategoryCode")) {
            mrCategoryCode = (String) condition.get("mrCategoryCode");
        }
        String typeCode = null;
        if (verifyExistKey(condition, "typeCode")) {
            typeCode = (String) condition.get("typeCode");
        }
        List<Map<String, Object>> poList = cusDao.selectAllToCreate(
                name //名称模糊查询
                , hospitalArea // 医院编码
                , departCode // 科室编码
                , userCode// 用户编码
                ,mrCategoryCode //医疗记录模板类型分组编码
                , typeCode);
        if (null != poList && poList.size() > 0) {
            MrTemplate[] voArray = new MrTemplate[poList.size()];
            for (int i = 0; i < poList.size(); i++) {
                Map<String, Object> po = poList.get(i);
                MrTemplate vo = new MrTemplate();
                vo = transPo2SimpleVo(po);
                voArray[i] = vo;
            }
            builder.withData(voArray);
        }
        PerformancePrinter.end("searchTemplateToCreate");
        long end = System.currentTimeMillis();
        System.out.print("searchTemplateToCreate:");
        System.out.println(end-start);
        ArrayResult<MrTemplate> rs = builder.build();
        rs.setTotal(poList.size());
        return rs;
    }
    
	@Override
	public TreeResult<TemplateNavigatorTreeData> getUseTree(
			Map<String, String> condition) {
		String sessionOrgName = "模板树根节点";
		TemplateNavigatorTreeData rootNode = new TemplateNavigatorTreeData() ;
		rootNode.setHisOrgCode(getOrgCode());
		rootNode.setHisOrgName(sessionOrgName);
		rootNode.setId("rootCode");
		rootNode.setText(sessionOrgName);
		TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("/",sessionOrgName,rootNode);
		if(!verifyExistKey(condition,"enTypeCode")){
			//空树			
			TreeNode<TemplateNavigatorTreeData> tree = builder.build();
			TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
			r.setRoot(tree);
			return r ;
		}
		Session session = Session.get();
		String orgCode = session.getOrgCd() ;
		String orgName = "全院通用";//this.getOrgName() ;
		String deptCode =session.getDeptId();
		String deptName = organizationService.selectByCode(deptCode).getData().getName();
		String userId = session.getUserId() ;
		String userName = "个人";//session.getUserName();
    	/**
    	 * 根据操作人的角色列举他的科室
    	 * 如果onlyThisDept=1，只是本科室，
    	 * 如果onlyThisDept=0 ，那么要从mr_tpl里查到共享的模板，安装科室A(共享)->分类->模板名称 进行添加
    	 * */
		TemplateNavigatorTreeData io = new TemplateNavigatorTreeData();
		io.setNodeType(TemplateNavigatorTreeNodeType.ORG);
		io.setHisOrgCode(orgCode);
		String enTypeCode = null ;
		if(this.verifyExistKey(condition, "enTypeCode")){
			enTypeCode = (String)condition.get("enTypeCode");
		}
		io.setEnTypeCode(enTypeCode);
		String dctNsF = null ;
		if(this.verifyExistKey(condition, "dctNsF")){
			dctNsF = (String)condition.get("dctNsF");
		}
		io.setDctNsF(dctNsF);
		io.setScStatusCode("MRM07.05");
		//io.setText("深圳龙华医院");

		 //院区编码
		

		long start = System.currentTimeMillis();
		builder = buildUseChildrenTree(builder, io,"/",orgCode+","+userId+","+deptCode,orgName+","+userName+","+deptName);
		TreeNode<TemplateNavigatorTreeData> tree = builder.build();
		TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
		r.setRoot(tree);
		long end = System.currentTimeMillis();
		System.out.println("-------------------------------:"
				+ String.valueOf(end - start));
		return r;
	}
	

	
	private TreeBuilder<TemplateNavigatorTreeData>  buildUseChildrenTree(TreeBuilder<TemplateNavigatorTreeData> builder ,TemplateNavigatorTreeData parentNode,String parentPath,String ownerCodeJoin,String owerNameJoin){
		/**
		 * 当输入参数为空时，从session中获取orgCode
		 * 根据节点类型来调用不同的子节点查询接口。
		 * 拼装成树状返回
		 * */
		 //当没有参数时，返回第一层,根据用户业务角色返回所属树
		 Session session = Session.get();
		 //院区编码
		String orgCode = session.getOrgCd() ;
		

		ArrayResult<TemplateNavigatorTreeData> resultTree = null; 
		ArrayResult<MrTemplate> resultLeaf = null;
		//TreeBuilder<TemplateNavigatorTreeData> builder  =null;
		if(null == parentNode || null == parentNode.getNodeType()){
			resultTree = getUseTreeByOrg(orgCode,ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.ORG)){
			if(null == parentNode.getHisOrgCode() ){
			resultTree = getUseTreeByOrg(orgCode,ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
			}else{
				resultTree = getUseTreeByOrg(parentNode.getHisOrgCode(),ownerCodeJoin,owerNameJoin,parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
			}
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
			resultTree = getUseTreeOfMrTlCategoryByOwner(parentNode.getHisOrgCode(), parentNode.getOwnerCode(),parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateCategoryCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}else if(parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){
			resultLeaf = getUserTreeByMrTlCategoryByLeafCategory(parentNode.getHisOrgCode(), parentNode.getOwnerCode(), parentNode.getTemplateCategoryCode(),parentNode.getKeyWord(),parentNode.getEnTypeCode(),parentNode.getScTemplateTypeCode(),parentNode.getScStatusCode(),parentNode.getDctNsF());
		}		
		if(null!=resultTree && null == resultLeaf ){
		if (resultTree.getDataList() != null)
        {
            for (TemplateNavigatorTreeData node : resultTree.getDataList())
            {
            	node.setLeaf(Boolean.FALSE);
            	node.setChecked(Boolean.FALSE);
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData): id     :"+node.getId());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData): text   :"+node.getText());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):nodeType:"+node.getNodeType());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):ownCode :"+node.getOwnerCode());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):cateCode:"+node.getTemplateCategoryCode());
            	log.debug("pkuhit.iih.iemr.mr.IEMRTempServiceImpl.getLazyTree(TemplateNavigatorTreeData):typeCode:"+node.getTemplateTypeCode());
            	node.setKeyWord(parentNode.getKeyWord());
            	node.setEnTypeCode(parentNode.getEnTypeCode());
            	node.setScTemplateCategoryCode(parentNode.getScTemplateCategoryCode());
            	node.setScTemplateTypeCode(parentNode.getScTemplateTypeCode());
            	node.setScStatusCode(parentNode.getScStatusCode());
            	node.setDctNsF(parentNode.getDctNsF());
            	
            	String currentPath = null;//parentPath+parentPath.replace("/", "")+"_"+node.getId();
            	if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.OWNER)){
            		currentPath = "/_" + node.getOwnerCode() ;
            	}else if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){
            		node.setOwnerName(parentNode.getOwnerName());
            		currentPath = "/_" + node.getOwnerCode() + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode() ;
            	}else if(node.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRTYPE)){
            		node.setOwnerName(parentNode.getOwnerName());
            		currentPath = "/_" + node.getOwnerCode() + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode()
            				    + "/_"+ node.getOwnerCode()+"_"+ node.getTemplateCategoryCode() +"_"+node.getTemplateTypeCode();
            	}
            	log.debug("parentPath:"+parentPath);
            	log.debug("currentPath:"+currentPath);
            	if(!parentNode.getNodeType().equalsIgnoreCase(TemplateNavigatorTreeNodeType.MRCATEGORY)){//当父节点类型不为自定义分类时
	            	builder = buildUseChildrenTree(
	            			builder.addChildByData( currentPath, node.getText(), node) 
	            			,node 
	            			,currentPath+"/"
	            			,""
	            			,"");
            	}else{
            		//node.setLeaf(Boolean.TRUE);
            		builder.addChildByData( currentPath, node.getText(), node) ;
            	}
            }
        }}else{
			//当叶节点（模板名称）
			//TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("root", new TemplateNavigatorTreeData());
	        if (resultLeaf.getDataList() != null)
	        {
	            for (MrTemplate tpl : resultLeaf.getDataList())
	            {
	            	TemplateNavigatorTreeData node = new TemplateNavigatorTreeData();
	            	node.setEnTypeCode(parentNode.getEnTypeCode());
	            	node.setTemplateCode(tpl.getCode());
	            	node.setTemplateName(tpl.getName());
	            	node.setId(tpl.getCode());
	            	node.setText(tpl.getName());
	            	node.setFilePk(tpl.getFilePk());
	            	node.setLeaf(Boolean.TRUE);
	            	node.setHisOrgCode(parentNode.getHisOrgCode());
	            	node.setOwnerTypeCode(parentNode.getOwnerTypeCode());
	            	node.setOwnerCode(parentNode.getOwnerCode());
	            	node.setTemplateTypeCode(tpl.getMrTypeCode());
	            	node.setSignLevelCode(tpl.getSignLevelCode());
	            	String currentPath = parentPath+ node.getId();
	            	log.debug("currentPath:"+currentPath);
	            	builder = builder.addChildByData( currentPath, tpl.getName(), node,Boolean.TRUE);
	            }
	        }
        }
		return builder;	
		
	}
	// 查询（所属，数目）
	public ArrayResult<TemplateNavigatorTreeData> getUseTreeByOrg(String orgCode,
			String ownerCodeJoin,String owerNameJoin,String keyWord,String enTypeCode ,String scTemplateCategoryCode ,String scTemplateTypeCode ,String statusCode,String dctNsF) {
		List<String> owerCodes = Arrays.asList(ownerCodeJoin.split(","));
		List<String> owerNames = Arrays.asList(owerNameJoin.split(","));
		List<String> scTemplateTypeCodeList = new ArrayList<String>();
		if( null != scTemplateTypeCode){
			scTemplateTypeCodeList.add(scTemplateTypeCode);
		}else{
			//if( null != scTemplateCategoryCode){
				scTemplateTypeCodeList = getTypeCodeArrayByMrCategoryCode(enTypeCode,scTemplateCategoryCode,dctNsF);			
			//}
		}
		
		// 根据orgCode获得 所属 对应的个数
		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder
				.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0 ;
		if(scTemplateTypeCodeList.size() > 0 ){
			List<Map<String, Object>> poList = cusDao.getCountByOrg(orgCode,
					owerCodes,keyWord, enTypeCode, scTemplateTypeCodeList,statusCode);
			if (poList.size() > 0) {
				// 循环
				int i = 1;
				total = poList.size();
				int hispital = 0 ; int person = 0; 
				voArray = new TemplateNavigatorTreeData[Math.max(5, poList.size()+2)]; //排序，顺序为全院通用 ，科室...，个人，所以最小长度为3，然后再截取数组
				for (Map<String, Object> map : poList) {
					TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
					String ownerTypeCode = (String) (map.get("OWN_TP_CD"));
					String ownerCode = (String) (map.get("OWN_CD"));
					String ownerName = owerNames.get(owerCodes.indexOf(ownerCode));
					model.setHisOrgCode(orgCode);
					model.setOwnerCode(ownerCode);
					model.setOwnerTypeCode(ownerTypeCode);
					model.setNodeType(TemplateNavigatorTreeNodeType.OWNER);
					model.setId(ownerCode);
					model.setText(ownerName);
					model.setOwnerName(ownerName);
					if(ownerTypeCode.equalsIgnoreCase(OwnerType.HOSPITAL_WIDE)){
						voArray[0] = model;//排序，全院通用第一
						hispital = 1 ;//有全院通用
					}else if(ownerTypeCode.equalsIgnoreCase(OwnerType.PERSONAL)){
						voArray[voArray.length -1 ] = model;//排序，个人 最后
						person = 1 ;//有个人
					}else{
						voArray[i] = model; //在全院通用后，开始累加
						i++;
					}
				}
				TemplateNavigatorTreeData[] voArrayRs = null;
					int rsSize = hispital + i-1 + person ;//新的数组总长度
					voArrayRs = new TemplateNavigatorTreeData[rsSize];
					if(hispital == 1){
						voArrayRs[0] = voArray[0] ; 
					}
					if(person == 1 ){
						voArrayRs[rsSize-1] = voArray[voArray.length -1] ;
					}
					for(int z = 0 ; z < i -1 ; z++){
						TemplateNavigatorTreeData vo = voArray[z + 1];
						if(null != vo){
							voArrayRs[hispital + z] = vo ;
						}
					}
				builder.withData(voArrayRs);
				total = i;
			}
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;

	}
	
	public ArrayResult<TemplateNavigatorTreeData> getUseTreeOfMrTlCategoryByOwner(
			String orgCode, String ownerCode,String keyWord,String enTypeCode,String scTemplateCategoryCode ,String scTemplateTypeCode,String statusCode,String dctNsF) {
		// 根据院区，所属获得，第一层自定义分类 对应的
		List<Map<String, Object>> poList = cusDao
				.getCountOfMrTlCategoryByOwner(orgCode, ownerCode,keyWord, enTypeCode,scTemplateCategoryCode,scTemplateTypeCode, statusCode,dctNsF);

		ArrayResultBuilder<TemplateNavigatorTreeData> builder = ArrayResultBuilder
				.newArrayResult(TemplateNavigatorTreeData.class);
		TemplateNavigatorTreeData[] voArray = null;
		int total = 0;
		if (poList.size() > 0) {
			// 循环
			voArray = new TemplateNavigatorTreeData[poList.size()];
			int i = 0;
			total = poList.size();
			for (Map<String, Object> map : poList) {
				TemplateNavigatorTreeData model = new TemplateNavigatorTreeData();
				String templateCategoryCode = (String) (map
						.get("MR_TP_CCAT_CD"));
				BigDecimal count = (BigDecimal) (map.get("TPL_CNT"));

/*				MdMrTpCcat mdMrTpCcat = mdMrTpCcatDao
						.selectById(templateCategoryCode);*/
				String templateCategoryName =  (String) (map
						.get("NM"));
				// 当为叶节点时，类型为自定义类型叶节点
//				if (mdMrTpCcat.getLeafF().intValue() == 1) {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRLEAFCATEGORY);
//				} else {
//					model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
//				}
				model.setNodeType(TemplateNavigatorTreeNodeType.MRCATEGORY);
				model.setHisOrgCode(orgCode);
				model.setOwnerCode(ownerCode);
				model.setTemplateCategoryCode(templateCategoryCode);
				model.setTemplateCategoryName(templateCategoryName);
				model.setId(templateCategoryCode);
				model.setText(templateCategoryName);
				voArray[i] = model;
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<TemplateNavigatorTreeData> result = builder.build();
		result.setTotal(total);
		return result;
	}
	public ArrayResult<MrTemplate> getUserTreeByMrTlCategoryByLeafCategory(
			String orgCode, String ownerCode, String leafMrCategoryCode,String keyWord,String enTypeCode,String scTemplateTypeCode,String statusCode,String dctNsF) {
		// 根据院区，个人获得，叶自定义分类 对应的
		List<MrTpl> poList = cusDao.getMrTlByLeafCategory(orgCode, ownerCode,
				leafMrCategoryCode,keyWord, enTypeCode,scTemplateTypeCode, statusCode,dctNsF);
		ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder.newArrayResult(MrTemplate.class);
		MrTemplate[] voArray = null;
		int total = 0;
		if (poList != null && poList.size() > 0) {
			voArray = new MrTemplate[poList.size()];
			total = poList.size();
			int i = 0;
			for (MrTpl po : poList) {
				voArray[i] = transPo2TreeVo(po);
				i++;
			}
			builder.withData(voArray);
		}
		ArrayResult<MrTemplate> result = builder.build();
		result.setTotal(total);
		return result;

	}
	
	@Override
	public TreeResult<TemplateNavigatorTreeData> getTreeForTpl(Map<String, String> condition){
	    String mrTplCCat = null ;
        if(this.verifyExistKey(condition, "mrTplCCat")){
            mrTplCCat = (String)condition.get("mrTplCCat");
        }
        String mrTplTypeCd = null ;
        if(this.verifyExistKey(condition, "mrTplTypeCd")){
            mrTplTypeCd = (String)condition.get("mrTplTypeCd");
        }
        String mrTplStatCd = null ;
        if(this.verifyExistKey(condition, "mrTplStatCd")){
            mrTplStatCd = (String)condition.get("mrTplStatCd");
        }
        String keyWord = null ;
        if(this.verifyExistKey(condition, "keyWord")){
            keyWord = (String)condition.get("keyWord");
        }
        String enTypeCode = null ;
        if(this.verifyExistKey(condition, "enTypeCode")){
            enTypeCode = (String)condition.get("enTypeCode");
        }
        String dctNsF = null ;
        if(this.verifyExistKey(condition, "dctNsF")){
            dctNsF = (String)condition.get("dctNsF");
        }
        Session session = Session.get();
        String orgCode = session.getOrgCd();
        String userId = session.getUserId();
        
        List<Map<String,Object>> list = cusDao.selectMrTemplateTreeData(mrTplCCat, mrTplTypeCd, mrTplStatCd, keyWord, enTypeCode, dctNsF, orgCode, userId);
        // 构建根节点，目前规定根节点为空，是一个虚值。
        //TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("root", null);
        TreeBuilder<TemplateNavigatorTreeData> builder = TreeBuilder.newTree("/", "root", new TemplateNavigatorTreeData());
        boolean checked = false;
        if(list != null && list.size() > 0){
            for(int i=0; i<list.size(); i++){
                TemplateNavigatorTreeData node = new TemplateNavigatorTreeData();
                Map<String,Object> map = list.get(i);
                node.setEnTypeCode(enTypeCode);
                node.setDctNsF(dctNsF);
                node.setScStatusCode(mrTplStatCd);
                node.setScTemplateCategoryCode(mrTplCCat);
                node.setScTemplateTypeCode(mrTplTypeCd);
                node.setKeyWord(keyWord);
                node.setHisOrgCode(map.get("HISORGCODE")==null?"":(String)map.get("HISORGCODE"));
                BigDecimal count = (BigDecimal) (map.get("TEXT"));
                node.setText(String.valueOf(count.longValue()));
                node.setNodeType(map.get("NODETYPE")==null?"":(String)map.get("NODETYPE"));
                node.setOwnerTypeCode(map.get("OWNERTYPECODE")==null?"":(String)map.get("OWNERTYPECODE"));
                node.setOwnerTypeName(map.get("OWNERTYPENAME")==null?"":(String)map.get("OWNERTYPENAME"));
                node.setOwnerCode(map.get("OWNERCODE")==null?"":(String)map.get("OWNERCODE"));
                node.setOwnerName(map.get("OWNERNAME")==null?"":(String)map.get("OWNERNAME"));
                node.setTemplateCategoryCode(map.get("TEMPLATECATEGORYCODE")==null?"":(String)map.get("TEMPLATECATEGORYCODE"));
                node.setTemplateCategoryName(map.get("TEMPLATECATEGORYNAME")==null?"":(String)map.get("TEMPLATECATEGORYNAME"));
                node.setTemplateTypeCode(map.get("TEMPLATETYPECODE")==null?"":(String)map.get("TEMPLATETYPECODE"));
                node.setTemplateTypeName(map.get("TEMPLATETYPENAME")==null?"":(String)map.get("TEMPLATETYPENAME"));
                if(!checked){
                    node.setExpanded(true);
                    node.setChecked(true);
                    checked = true;
                }else{
                    node.setExpanded(false);
                    node.setChecked(false);
                }
                StringBuilder strId = new StringBuilder();
                strId.append("/_");
                strId.append(node.getOwnerTypeCode());
                strId.append(node.getOwnerCode());
                if(node.getTemplateCategoryCode() != null && !"".equals(node.getTemplateCategoryCode())){
                    strId.append("/_");
                    strId.append(node.getOwnerTypeCode());
                    strId.append(node.getOwnerCode());
                    strId.append("_");
                    strId.append(node.getTemplateCategoryCode());
                }
                if(node.getTemplateTypeCode() != null && !"".equals(node.getTemplateTypeCode())){
                    strId.append("/_");
                    strId.append(node.getOwnerTypeCode());
                    strId.append(node.getOwnerCode());
                    strId.append("_");
                    strId.append(node.getTemplateCategoryCode());
                    strId.append("_");
                    strId.append(node.getTemplateTypeCode());
                }
                node.setId(strId.toString());
                if("owner".equals(node.getNodeType())){
                    node.setLeaf(false);
                    if("MDM08.02".equals(node.getOwnerTypeCode())){//所属科室
                        String deptName = IihUtils.deptCodeToName(dataObjectService, node.getOwnerCode());
                        StringBuilder sb = new StringBuilder();
                        sb.append(deptName);
                        sb.append("(");
                        sb.append(node.getText());
                        sb.append(")");
                        node.setText(sb.toString());
                    }else{
                        StringBuilder sb = new StringBuilder();
                        sb.append(node.getOwnerTypeName());
                        sb.append("(");
                        sb.append(node.getText());
                        sb.append(")");
                        node.setText(sb.toString());
                    }
                }else if("category".equals(node.getNodeType())){
                    node.setLeaf(false);
                    StringBuilder sb = new StringBuilder();
                    sb.append(node.getTemplateCategoryName());
                    sb.append("(");
                    sb.append(node.getText());
                    sb.append(")");
                    node.setText(sb.toString());
                }else{
                    node.setLeaf(true);
                    StringBuilder sb = new StringBuilder();
                    sb.append(node.getTemplateTypeName());
                    sb.append("(");
                    sb.append(node.getText());
                    sb.append(")");
                    node.setText(sb.toString());
                }
                builder.addChildByData(node.getId(), node.getText(), node);
            }
        }
        //构建树节点
        TreeNode<TemplateNavigatorTreeData> tree = builder.build();
        //构建树返回结果
        TreeResult<TemplateNavigatorTreeData> r = new TreeResult<TemplateNavigatorTreeData>();
        r.setRoot(tree);
        return r;
	}
	
	@Override
	public ArrayResult<MrTemplate> searchMrTemplates(@RequestParam Map<String, String> condition){
        ArrayResultBuilder<MrTemplate> builder = ArrayResultBuilder.newArrayResult(MrTemplate.class);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pageNum = null;
        String pageSize = null;
        if (condition.containsKey("pageNum") && condition.containsKey("pageSize")) {
            pageNum = (String) condition.get("pageNum");
            pageSize = (String) condition.get("pageSize");
        }else{
            pageNum = "1";
            pageSize = "25";
        }
        String statusCode = null;
        if (verifyExistKey(condition, "statusCode")) { // 状态码
            statusCode = (String) condition.get("statusCode");
        }
        String name = null; // 名称，模糊查询
        if (verifyExistKey(condition, "name")) {
            name = (String) condition.get("name");
        }
        Session session = Session.get();
        String orgCode = session.getOrgCd();
        String userCode = session.getUserId();
        String enTypeCode = null; // 就诊类型
        if (verifyExistKey(condition, "enTypeCode")) {
            enTypeCode = (String) condition.get("enTypeCode");
        }
        String dctNsF = null; // 医护标识
        if (verifyExistKey(condition, "dctNsF")) {
            dctNsF = (String) condition.get("dctNsF");
        }
        String ownerTypeCode = null;
        if (verifyExistKey(condition, "ownerTypeCode")) {
            ownerTypeCode = (String) condition.get("ownerTypeCode");
        }
        String ownerCode = null;
        if (verifyExistKey(condition, "ownerCode")) {
            ownerCode = (String) condition.get("ownerCode");
        }
        String typeCode = null;
        if (verifyExistKey(condition, "typeCode")) {
            typeCode = (String) condition.get("typeCode");
        }
        String mrCategoryCode = null;
        if (verifyExistKey(condition, "mrCategoryCode")) {
            mrCategoryCode = (String) condition.get("mrCategoryCode");
        }
        SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum) - 1)* Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();
        long total = 0;  
        List<Map<String,Object>> poList = cusDao.selectMrTplList(
                statusCode// 状态码
                , name// 名称 模糊查询
                , dctNsF// 医护标记
                , orgCode // 组织机构编码
                , ownerTypeCode // 所属类型编码
                , ownerCode // 所属编码
                , typeCode// 医疗记录模板类型编码
                , mrCategoryCode // 医疗记录模板自定义分类编码
                ,enTypeCode //就诊类型
                ,userCode //用户编码
                , options);
        if (null != poList && poList.size() > 0) {
            MrTemplate[] voArray = new MrTemplate[poList.size()];
            for(int i=0;i<poList.size();i++){
                Map<String,Object> po = poList.get(i);
                MrTemplate vo = new MrTemplate();
                vo.setCode((String)po.get("MR_TPL_CD"));
                vo.setName((String)po.get("NM"));
                vo.setEnTypeCode((String)po.get("EN_TP_CD"));
                vo.setOrganizationCode((String)po.get("ORG_CD"));
                vo.setOrganizationName(po.get("ORGANIZATIONNAME")==null?"":(String)po.get("ORGANIZATIONNAME"));
                vo.setBaseTemplateCode((String)po.get("MR_BASE_TPL_CD"));
                vo.setBaseTemplateName(po.get("BASETEMPLATENAME")==null?"":(String)po.get("BASETEMPLATENAME"));
                vo.setFilePk(po.get("FILE_PK")==null?"":(String)po.get("FILE_PK"));
                vo.setXmlFilePk(po.get("XML_FILE_PK")==null?"":(String)po.get("XML_FILE_PK"));
                vo.setStatusCode((String)po.get("MR_TPL_STA_CD"));
                vo.setStatusName(po.get("STATUSNAME")==null?"":(String)po.get("STATUSNAME"));
                vo.setDescription(po.get("DES")==null?"":(String)po.get("DES"));
                vo.setOwnerTypeCode((String)po.get("OWN_TP_CD"));
                vo.setOwnerTypeName(po.get("OWNERTYPENAME")==null?"":(String)po.get("OWNERTYPENAME"));
                vo.setOwnerCode((String)po.get("OWN_CD"));
                vo.setOwnerName(po.get("OWNERNAME")==null?"":(String)po.get("OWNERNAME"));
                if(po.get("CRT_TIME") != null){
                    Date d;
                    try
                    {
                        d = sf.parse((String)po.get("CRT_TIME"));
                        vo.setCrtTime(new Timestamp(d.getTime()));
                    }
                    catch (ParseException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                if(po.get("LAST_UPD_TIME") != null){
                    Date d;
                    try
                    {
                        d = sf.parse((String)po.get("LAST_UPD_TIME"));
                        vo.setLastUpdateTime(new Timestamp(d.getTime()));
                    }
                    catch (ParseException e)
                    {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                vo.setCreateUserId(po.get("CRT_USER_ID")==null?"":(String)po.get("CRT_USER_ID"));
                vo.setCreateUserName(po.get("CREATEUSERNAME")==null?"":(String)po.get("CREATEUSERNAME"));
                vo.setLastUpdateUserId(po.get("LAST_UPD_USER_ID")==null?"":(String)po.get("LAST_UPD_USER_ID"));
                vo.setLastUpdateUserName(po.get("LASTUPDATEUSERNAME")==null?"":(String)po.get("LASTUPDATEUSERNAME"));
                vo.setDefaultF(po.get("DEFAULT_F")==null?0:((BigDecimal)po.get("DEFAULT_F")).shortValue());
                vo.setDefaultName((String)po.get("DEFAULTNAME"));
                vo.setSignLevelCode(po.get("MR_SIGN_LVL_CD")==null?"":(String)po.get("MR_SIGN_LVL_CD"));
                vo.setSignLevelName(po.get("SIGNLEVELNAME")==null?"":(String)po.get("SIGNLEVELNAME"));
                vo.setMrTypeCode((String)po.get("MR_TP_CD"));
                vo.setMrTypeName(po.get("MRTYPENAME")==null?"":(String)po.get("MRTYPENAME"));
                BigDecimal canUpdate = (BigDecimal)po.get("CANUPDATE");
                int intCanUpdate = canUpdate.intValue();
                this.setMrTplButtonsStatus(vo, intCanUpdate);
                this.setMrTplDi(vo);
                voArray[i] = vo;
            }
            builder.withData(voArray);
            total = options.getCount();
        }else{
            ArrayResult<MrTemplate> rs = builder.build();
            rs.setPageNum(Integer.valueOf(pageNum));
            rs.setPageSize(Integer.valueOf(pageSize));
            rs.setTotal(0);
            return rs;
        }
        ArrayResult<MrTemplate> rs = builder.build();
        rs.setTotal(Long.valueOf(total).intValue());
        rs.setPageNum(Integer.valueOf(pageNum));
        rs.setPageSize(Integer.valueOf(pageSize));
        return rs;
	}
	
	// 适应病种
	public void setMrTplDi(MrTemplate vo){
        List<MrTplDi> diList = cusMrTplDiDao.getDiListByTpl(vo.getCode());
        if (diList.size() > 0) {
            String[] diCodeArray = new String[diList.size()];
            StringBuffer diCodesb = new StringBuffer();
            int i = 0;
            for (MrTplDi td : diList) {
                if (i > 0) {
                    diCodesb.append(",");
                }
                diCodesb.append(td.getDiCd());
                diCodeArray[i] = td.getDiCd();
                i++;
            }
            SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
                    DiagnosisDict.OBJ_CD, diCodeArray);
            if (verify(simpleItems)) {
                String[] diNameArray = new String[diList.size()];
                StringBuffer diNamesb = new StringBuffer();
                i = 0;
                for (SimpleItem si : simpleItems) {
                    String diName = si.getText();
                    diNameArray[i] = diName;
                    if (i > 0) {
                        diNamesb.append(",");
                    }
                    diNamesb.append(diName);
                }
                vo.setDiCodeArray(diCodeArray);
                vo.setDiNameArray(diNameArray);
                vo.setDiCodes(diCodesb.toString());
                vo.setDiNames(diNamesb.toString());
            }
        }
	}
	
	public void setMrTplButtonsStatus(MrTemplate vo, int intCanUpdate){
	    if(intCanUpdate == 0){
            vo.setCanUpgrade(0);
            vo.setCanDelete(0);
            vo.setCanSubmit(0);
            vo.setCanReview(0);
            vo.setCanReject(0);
            vo.setCanPublish(0);
            vo.setCanCancelReview(0);
            vo.setCanStop(0);
            vo.setCanActivated(0);
            vo.setCanUpdate(0);
        }else{
            if (!(MrTemplateStatus.ACTIVED.equalsIgnoreCase(vo.getStatusCode()) || MrTemplateStatus.STOPPED
                    .equalsIgnoreCase(vo.getStatusCode()))) {
                vo.setCanUpgrade(0);
            } else {
                vo.setCanUpgrade(1);// 升级
            }
            if (MrTemplateStatus.CREATED.equalsIgnoreCase(vo.getStatusCode()) || MrTemplateStatus.STOPPED.equalsIgnoreCase(vo.getStatusCode()) || MrTemplateStatus.REJECTED
                    .equalsIgnoreCase(vo.getStatusCode())) {
                vo.setCanDelete(1);
            } else {
                vo.setCanDelete(0);// 删除
            }
            vo.setCanUpdate(intCanUpdate);
            if (!(MrTemplateStatus.CREATED.equalsIgnoreCase(vo.getStatusCode()) || MrTemplateStatus.REJECTED
                    .equalsIgnoreCase(vo.getStatusCode()))) {
                vo.setCanSubmit(0);
            } else {
                vo.setCanSubmit(1);// 提交,
            }
            if (!MrTemplateStatus.SUBMITTED.equalsIgnoreCase(vo.getStatusCode())) {
                vo.setCanReview(0);
                vo.setCanReject(0);
            } else {
                vo.setCanReview(1);// 审批
                vo.setCanReject(1);// 驳回
            }
            if (!MrTemplateStatus.REVIEWED.equalsIgnoreCase(vo.getStatusCode())) {
                vo.setCanPublish(0);
                vo.setCanCancelReview(0);
            } else {
                vo.setCanPublish(1);// 发布
                vo.setCanCancelReview(1);// 取消审核
            }
            if (!MrTemplateStatus.ACTIVED.equalsIgnoreCase(vo.getStatusCode())) {
                vo.setCanStop(0);
            } else {
                vo.setCanStop(1);// 停用
            }
            if (!(MrTemplateStatus.STOPPED.equalsIgnoreCase(vo.getStatusCode()) )) {
                vo.setCanActivated(0);
            } else {
                vo.setCanActivated(1); //启用
            }
        }
	}
}
