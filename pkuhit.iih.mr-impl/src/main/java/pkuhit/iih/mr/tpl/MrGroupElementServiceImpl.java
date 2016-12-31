package pkuhit.iih.mr.tpl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.seasar.doma.jdbc.SelectOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import pkuhit.iih.mr.dao.auto.MrGeDao;
import pkuhit.iih.mr.dao.auto.entity.MrGe; //entity
import pkuhit.iih.mr.md.MrGroupElementStatus;
import pkuhit.iih.mr.md.MrGroupElementType;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.tpl.dao.CusGroupElementDao;
import pkuhit.md.Dictionary.SimpleItem;
import pkuhit.md.DictionaryService;
import pkuhit.md.OwnerType;
import pkuhit.org.Organization;
import pkuhit.xap.ac.Session;
import pkuhit.xap.file.FileObject;
import pkuhit.xap.file.FileService;
import pkuhit.xap.me.MeCdRuService;
import pkuhit.xap.util.BeanCopyUtil;
import xap.sv.annotation.Reference;
import xap.sv.model.ArrayResult;
import xap.sv.model.ArrayResultBuilder;
import xap.sv.model.Composite;
import xap.sv.model.SingleResult;
import xap.sv.model.SingleResultBuilder;
import xap.sv.model.TreeNode;
import xap.sv.model.TreeResult;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;
import xap.sv.servlet.mvc.annotation.RequestParam;

/**
 * @author guo_zhongbao
 * 
 */
public class MrGroupElementServiceImpl implements MrGroupElementService {
	Logger log = LoggerFactory.getLogger(MrGroupElementServiceImpl.class);
	@Autowired
	MrGeDao autoGenDao;
	@Reference
	FileService fileService; // 文件服务
	@Autowired
	CusGroupElementDao cusDao;

	// 根记录模板编码生成服务
	@Reference
	MeCdRuService meCdRuService;

	@Reference
	private DictionaryService dictionaryService; //字典服务接口

	/**
	 * 【组合元素】新建服务（单记录）
	 * 
	 * @param MrGroupElement
	 *            value
	 * @return 单条组合元素
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#create(pkuhit.iih.mr.tpl.
	 * MrGroupElement)
	 */
	@Override
	public SingleResult<MrGroupElement> create(MrGroupElement mrGroupElement) {
		log.debug("pkuhit.iih.mr.tpl.MrGroupElementServiceImpl.create(MrGroupElement)   typeCode:"+mrGroupElement.getTypeCode());
		// ■ 参数校验
		this.validate(mrGroupElement);
		// 医疗记录组合元素类型编码
		String typeCode = mrGroupElement.getTypeCode();
		// 所属类型编码
		String ownerTypeCode = mrGroupElement.getOwnerTypeCode();

		// ■ 保存数据
		// 保存文件流
		String odtFile = mrGroupElement.getOdtFile();
		if (odtFile == null) {
			odtFile = "";
		}
		FileObject fo = fileService.createFile("base", odtFile.getBytes());

		// 创建持久化对象 基础模板对象
		MrGe meGe = new MrGe();
		BeanCopyUtil.modelToEntity(meGe, mrGroupElement);

		String rootCode = null;
		BigInteger verNo = null;

		String code = mrGroupElement.getCode();
		if (StringUtils.isBlank(code)) {
			// 如果主键为空，代表初次创建对象
			verNo = BigInteger.ONE;
			// 根医疗记录基础模板编码
			rootCode = meCdRuService.selectById(MrGroupElement.ROOT_CODE)
					.getId();
		} else {
			// 升级对象，获取数据库对象，然后更新版本号，文件流
			MrGe oldMrGe = autoGenDao.selectById(code);
			rootCode = oldMrGe.getRtMrEgCd();
			BigInteger currVersion = cusDao
					.selectMaxVersionByRootCode(rootCode);
			verNo = currVersion.add(BigInteger.ONE);
			if (MrGroupElementType.COMMON_ELEMENT.equalsIgnoreCase(typeCode)) {
				if(!(MrGroupElementStatus.ACTIVED.equalsIgnoreCase(oldMrGe
						.getMrGeStaCd()) || MrGroupElementStatus.STOPPED
						.equalsIgnoreCase(oldMrGe.getMrGeStaCd()))){
					//不能升级
						Notification notification = new Notification(MessageCode.UN_UPGRADE_TEMPLATE,"组合元素当前状态不能升级。只能对最高版本的“启用”“停用”状态进行升级");
						throw new NotificationException(notification);
				}
			}
		}
		code = rootCode +"."+ String.format("%04d", verNo);

		// 医疗记录组合元素编码(PK)
		meGe.setMrGeCd(code);
		// 组织机构编码
		Session session = Session.get();
		String orgCd = this.getOrgCode();
		meGe.setOrgCd(orgCd);
		// 文件主键
		if (fo != null) {
			meGe.setFilePk(fo.getId());
		}
		// 根医疗记录组合元素编码
		meGe.setRtMrEgCd(rootCode);
		// 设置版本
		meGe.setVerNo(verNo);
		// 设置初始状态。
		if (MrGroupElementType.COMMON_ELEMENT.equals(typeCode)) {
			// 如果是普通元素那么状态为[新建]
			meGe.setMrGeStaCd(MrGroupElementStatus.CREATED);
		} else {
			// 如果是片段模板那么状态为[发布]
			meGe.setMrGeStaCd(MrGroupElementStatus.ACTIVED);
		}
		// 所属类型编码
		// 所属编码
		if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
			// 全院
			meGe.setOwnCd(orgCd);
		} else if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
			// 科室
			meGe.setOwnCd(session.getDeptId());
		} else {
			// 个人
			meGe.setOwnCd(session.getUserId());
		}
		autoGenDao.insertExludeNull(meGe);

		// ■　设置返回值
		SingleResultBuilder<MrGroupElement> builder = SingleResultBuilder.newSingleResult(MrGroupElement.class);
		builder.withData(this.getMrGroupElementById(code, true));
		return builder.build();

	}

	/**
	 * 【组合元素】更新服务（单记录）
	 * 
	 * @param MrGroupElement
	 *            value
	 * @return 单条组合元素
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#update(java.lang.String,
	 * pkuhit.iih.mr.tpl.MrGroupElement)
	 */
	@Override
	public SingleResult<MrGroupElement> update(String id, MrGroupElement mrGroupElement) { 
		// ■ 参数校验
		if (StringUtils.isBlank(id)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素编码");
			throw new NotificationException(notification);
		}
		
		MrGe mrGe = autoGenDao.selectById(id); 
		if (mrGe == null) {
			Notification notification = new Notification(MessageCode.NOT_EXIST);
			throw new NotificationException(notification);
		}

		// 如果[医疗记录组合元素类型编码]是[普通元素]，那么需要校验状态
		String typeCode = mrGe.getMrGeTpCd();
		if (MrGroupElementType.COMMON_ELEMENT.equals(typeCode)) {
			String mrGeStaCd = mrGe.getMrGeStaCd();
			if (!(MrGroupElementStatus.CREATED.equals(mrGeStaCd) 
					|| MrGroupElementStatus.REJECTED.equals(mrGeStaCd))) {
				Notification notification = new Notification(MessageCode.UN_EDITABLE_GE);
				throw new NotificationException(notification);
			}
		}
		
		this.validate(mrGroupElement);
		
		
		//■ 更新数据
		// 更新文件流
		String odtFile = mrGroupElement.getOdtFile();
		if (odtFile == null) {
			odtFile = "";
		}
		this.fileService.updateFile(mrGe.getFilePk(), odtFile.getBytes());

		//名称
		mrGe.setNm(mrGroupElement.getName());
		//描述
		mrGe.setDes(mrGroupElement.getDescription());
		
		// 所属类型编码
		String ownerTypeCode = mrGroupElement.getOwnerTypeCode();
		mrGe.setOwnTpCd(ownerTypeCode);

		// 所属编码
		Session session = Session.get();
		String orgCd = this.getOrgCode();
		if (OwnerType.HOSPITAL_WIDE.equalsIgnoreCase(ownerTypeCode)) {
			// 全院
			mrGe.setOwnCd(orgCd);
		} else if (OwnerType.DEPARTMENT.equalsIgnoreCase(ownerTypeCode)) {
			// 科室
			mrGe.setOwnCd(session.getDeptId());
		} else {
			// 个人
			mrGe.setOwnCd(session.getUserId());
		}
		autoGenDao.updateExcludeNull(mrGe);

		// ■　设置返回值
		SingleResultBuilder<MrGroupElement> builder = SingleResultBuilder.newSingleResult(MrGroupElement.class);
		builder.withData(this.getMrGroupElementById(id, true));
		return builder.build();

	}
	
	@Override
	public SingleResult<MrGroupElement> delete(@PathVariable("id")  String id){
		// ■ 参数校验
		if (StringUtils.isBlank(id)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素编码");
			throw new NotificationException(notification);
		}
		
		MrGe mrGe = autoGenDao.selectById(id); 
		if (mrGe == null) {
			Notification notification = new Notification(MessageCode.NOT_EXIST);
			throw new NotificationException(notification);
		}
		
		//如果是组合元素，需要校验当前状态是否允许删除
		String typeCode = mrGe.getMrGeTpCd();
		if (MrGroupElementType.COMMON_ELEMENT.equals(typeCode)) {
			String mrGeStaCd = mrGe.getMrGeStaCd();
			if (!(MrGroupElementStatus.CREATED.equals(mrGeStaCd) 
					|| MrGroupElementStatus.REJECTED.equals(mrGeStaCd))) {
				Notification notification = new Notification(MessageCode.UN_EDITABLE_GE);
				throw new NotificationException(notification);
			}
		}
		
		// ■ 删除组合元素(逻辑删除)
		String filePk = mrGe.getFilePk();
		if (StringUtils.isNotBlank(filePk)) {
			fileService.deleteFile(filePk);
		}
		mrGe.setDelF(Short.valueOf("1"));
		mrGe.setUpdCnt(mrGe.getUpdCnt().add(BigInteger.valueOf(1)));
		autoGenDao.markDelete(mrGe);
		
		// ■ 返回处理结果
		SingleResultBuilder<MrGroupElement> builder = SingleResultBuilder.newSingleResult(MrGroupElement.class);
		SingleResult<MrGroupElement> result = builder.build();
		return result;
	}
	
	private MrGroupElement getMrGroupElementById(String id, boolean isLoadOdt) {
		if(null == id){
			return null;
		}
		MrGe mrGe = this.autoGenDao.selectById(id);
		
		if (mrGe == null) {
			return null;
		}
		
		return this.wrapMrGroupElement(mrGe, isLoadOdt);
	}
	
	
	private MrGroupElement wrapMrGroupElement(MrGe mrGe, boolean isLoadOdt) {
		if (mrGe == null) {
			return null;
		}
		
		MrGroupElement vo = new MrGroupElement();
		BeanCopyUtil.entityToModel(vo, mrGe, MrGroupElement.OBJ_CD,
				dictionaryService);
		
		//设置ODT文件
		if (isLoadOdt) {
			String filePk = mrGe.getFilePk();
			FileObject file = this.fileService.getFile(filePk);
			try {
				String odtFile = new String(file.asByteArray());
				vo.setOdtFile(odtFile);
			} catch (Exception ex) {
				Notification notification = new Notification(MessageCode.FILE_GET_FATAL);
				throw new NotificationException(notification); 
			}
		}
		
		//如果是普通元素，需要设置各编辑状态
		String typeCode = mrGe.getMrGeTpCd();
		if (MrGroupElementType.COMMON_ELEMENT.equalsIgnoreCase(typeCode)) {
			if(!(MrGroupElementStatus.ACTIVED.equalsIgnoreCase(mrGe
					.getMrGeStaCd()) || MrGroupElementStatus.STOPPED
					.equalsIgnoreCase(mrGe.getMrGeStaCd()))){
				vo.setCanUpgrade(0);
			}else{
				vo.setCanUpgrade(1);
			}
			if (!(MrGroupElementStatus.CREATED.equals(mrGe.getMrGeStaCd()) 
					|| MrGroupElementStatus.REJECTED.equals(mrGe
							.getMrGeStaCd()))) {
				vo.setCanUpdate(0);
			}else{
				vo.setCanUpdate(1);
			}
			if (!(MrGroupElementStatus.CREATED.equalsIgnoreCase(mrGe.getMrGeStaCd()) 
					|| MrGroupElementStatus.REJECTED.equals(mrGe.getMrGeStaCd()))) {
				 vo.setCanDelete(0);
			}else{
				vo.setCanDelete(1);//可删除
			}
			if (!(MrGroupElementStatus.CREATED.equalsIgnoreCase(mrGe
					.getMrGeStaCd()) || MrGroupElementStatus.REJECTED
					.equalsIgnoreCase(mrGe.getMrGeStaCd()))) {
				vo.setCanSubmit(0);
			}else{
				vo.setCanSubmit(1);//可提交
			}
			if (!MrGroupElementStatus.SUBMITTED.equalsIgnoreCase(mrGe
					.getMrGeStaCd())) {
				vo.setCanReject(0);
				vo.setCanReview(0);
			}else{
				vo.setCanReject(1);//可驳回
				vo.setCanReview(1);//可审批
			}
			if (!(MrGroupElementStatus.SUBMITTED.equalsIgnoreCase(mrGe
					.getMrGeStaCd()) || MrGroupElementStatus.STOPPED
					.equalsIgnoreCase(mrGe.getMrGeStaCd()))) {
				vo.setCanActivated(0);
			}else{
				vo.setCanActivated(1);//可激活
			}
			if (!MrGroupElementStatus.ACTIVED.equalsIgnoreCase(mrGe
					.getMrGeStaCd())) {
				vo.setCanStop(0);
			}else{
				vo.setCanStop(1);//可停用
			}
		}
		
		
		return vo;
	}
	
	private void validate(MrGroupElement mrGroupElement) {
		// 医疗记录组合元素类型编码
		String typeCode = mrGroupElement.getTypeCode();
		if (StringUtils.isBlank(typeCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素类型编码");
			throw new NotificationException(notification);
		}
		
		if (!    (MrGroupElementType.COMMON_ELEMENT.equals(typeCode)
				|| MrGroupElementType.FRAGMENT_ELEMENT.equals(typeCode))) {
			Notification notification = new Notification(MessageCode.VALID_PARAM,
					"医疗记录组合元素类型编码");
			throw new NotificationException(notification);
		}

		// 名称
		String name = mrGroupElement.getName();
		if (StringUtils.isBlank(name)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,"名称");
			throw new NotificationException(notification);
		}

		// 所属类型编码
		String ownerTypeCode = mrGroupElement.getOwnerTypeCode();
		if (StringUtils.isBlank(ownerTypeCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,"所属类型编码");
			throw new NotificationException(notification);
		}

		// 医疗记录组合元素的自定义分类编码
		String customCategoryCode = mrGroupElement.getCustomCategoryCode();
		if (StringUtils.isBlank(customCategoryCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,"医疗记录组合元素的自定义分类编码");
			throw new NotificationException(notification);
		}
	}

	/**
	 * 【组合元素】查询服务（单记录）
	 * 
	 * @param String
	 *            id
	 * @return 单条组合元素
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#search(java.lang.String)
	 */
	@Override
	public SingleResult<MrGroupElement> searchById(String id) {
		if (StringUtils.isBlank(id)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素编码");
			throw new NotificationException(notification);
		}
		
		MrGroupElement mrGroupElement = this.getMrGroupElementById(id, true);
		if (mrGroupElement == null) {
			Notification notification = new Notification(MessageCode.NOT_EXIST);
			throw new NotificationException(notification);
		}
		
		SingleResultBuilder<MrGroupElement> builder = SingleResultBuilder.newSingleResult(MrGroupElement.class);
		SingleResult<MrGroupElement> result = builder.build();
		result.setData(mrGroupElement);
		return result;
	}

	/**
	 * 【组合元素】查询服务（多记录）
	 * 
	 * @param MrGroupElement
	 *            condition
	 * @return List<MrGroupElement>
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#search(java.util.Map)
	 */
	@Override
	public ArrayResult<MrGroupElement> search(Map<String, String> condition) {
		//■ 校验参数
		String typeCode = condition.get("typeCode");
		if (StringUtils.isBlank(typeCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素类型编码");
			throw new NotificationException(notification);
		}
		
		//■ 查询
		String orgCode = Session.get().getOrgCd();
		
		
		String keyword = condition.get("keyWord");
		String ownerTypeCode = condition.get("ownerTypeCode");
		String ownerCode = condition.get("ownerCode");
		String customCategoryCode = condition.get("customCategoryCode");
		String statusCode = condition.get("statusCode");
		String pageNum = null; 
		String pageSize = null; 
		if(condition.containsKey("pageNum") && condition.containsKey("pageSize")){ 
			pageNum = (String)condition.get("pageNum"); 
			pageSize = (String)condition.get("pageSize"); 
		} 
		if(null == pageNum || !StringUtils.isNumeric(pageNum) || null == pageSize || !StringUtils.isNumeric(pageSize) ) 
		{ 
		pageNum= "1"; 
		pageSize = "25"; 
		} 
		SelectOptions options = SelectOptions.get().offset((Integer.valueOf(pageNum)-1)*Integer.valueOf(pageSize)).limit(Integer.valueOf(pageSize)).count();

		List<MrGe> mrGeList = 
				cusDao.selectGroupElement(orgCode, ownerTypeCode, ownerCode, typeCode, customCategoryCode, statusCode, keyword,options);
		
		//■ 返回结果
		ArrayResultBuilder<MrGroupElement> builder = ArrayResultBuilder.newArrayResult(MrGroupElement.class);
		int size = mrGeList.size();
		if (size > 0) {
			MrGroupElement[] voArray = new MrGroupElement[size];
			for (int i = 0; i < size; i++) {
				MrGe po = mrGeList.get(i);
				voArray[i] = this.wrapMrGroupElement(po, false);
			}
			builder.withData(voArray);
		}
		ArrayResult<MrGroupElement> rs = builder.build();
		rs.setTotal(Long.valueOf(options.getCount()).intValue());
		rs.setPageNum(Integer.valueOf(pageNum));
		rs.setPageSize(Integer.valueOf(pageSize));
		return rs;
	}

	/**
	 * 【组合元素】删除服务（多记录），新建的，已驳回的
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#delete(java.lang.String[])
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
			MrGe po = autoGenDao.selectById(id);
			if (!(MrGroupElementStatus.CREATED.equalsIgnoreCase(po
					.getMrGeStaCd()) || MrGroupElementStatus.REJECTED
					.equalsIgnoreCase(po.getMrGeStaCd()))) {
				// 非（新建状态，已驳回）,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrGeCd());
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
	 * 【组合元素】提交服务（多记录），新建的，已驳回的
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#submit(java.lang.String[])
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
			MrGe po = autoGenDao.selectById(id);
			if (!(MrGroupElementStatus.CREATED.equalsIgnoreCase(po
					.getMrGeStaCd()) || MrGroupElementStatus.REJECTED
					.equalsIgnoreCase(po.getMrGeStaCd()))) {
				// 非（新建状态，已驳回）,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrGeCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作 SUBMITTED
				po.setMrGeStaCd(MrGroupElementStatus.SUBMITTED);
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
	 * 【组合元素】驳回服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#reject(java.lang.String[])
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
			MrGe po = autoGenDao.selectById(id);
			if (!MrGroupElementStatus.SUBMITTED.equalsIgnoreCase(po
					.getMrGeStaCd())) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrGeCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrGeStaCd(MrGroupElementStatus.REJECTED);
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
	 * 【组合元素】启用服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#activate(java.lang.String[])
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
			MrGe po = autoGenDao.selectById(id);
			if (!(MrGroupElementStatus.SUBMITTED.equalsIgnoreCase(po
					.getMrGeStaCd()) || MrGroupElementStatus.STOPPED
					.equalsIgnoreCase(po.getMrGeStaCd()))) {
				// 非新建状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrGeCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrGeStaCd(MrGroupElementStatus.ACTIVED);
				autoGenDao.update(po);
				// 停用其他的版本
				List<MrGe> poList = cusDao.selectGroupElementByRootcode(po.getRtMrEgCd(), getOrgCode());
				for (MrGe po_stop : poList) {
					if (po_stop.getMrGeCd().equalsIgnoreCase(po.getMrGeCd())) {
						continue;
					}
					po_stop.setMrGeStaCd(MrGroupElementStatus.STOPPED);
				}
				autoGenDao.batchUpdate(poList);
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
	 * 【组合元素】停用服务（多记录）
	 * 
	 * @param ids
	 *            多个记录主键
	 * @return 批量更新结果
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see pkuhit.iih.mr.tpl.MrGroupElementService#stop(java.lang.String[])
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
			MrGe po = autoGenDao.selectById(id);
			if (!MrGroupElementStatus.ACTIVED.equalsIgnoreCase(po
					.getMrGeStaCd())) {
				// 非启用状态,添加到失败列表中
				FailItem item = new FailItem();
				item.setCode(po.getMrGeCd());
				item.setName(po.getNm());
				failItemsTemp[failCount] = item;
				failCount++;
			} else {
				// 进行正常操作
				po.setMrGeStaCd(MrGroupElementStatus.STOPPED);
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

	private String getOrgCode() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		if (StringUtils.isBlank(orgCd)) {
			orgCd = "SZLH";
		}
		return orgCd;
	}
	
	private String getOrgName() {
		Session session = Session.get();
		String orgCd = session.getOrgCd();
		// TODO... 会话里怎么没有名称？
		String undefinedOrgNm = "未名医院";
		String orgNm = "" ;
		SimpleItem[] simpleItems = dictionaryService.getSimpleItems(
				Organization.OBJ_CD, orgCd);
		if(null == simpleItems || simpleItems.length == 0 || null == simpleItems[0]){
			
		}else{
			orgNm = simpleItems[0].getText();
			if (StringUtils.isBlank(orgNm)) {
				orgNm = undefinedOrgNm;
			}
		}
		return orgNm;
	}

	@Override
	public TreeResult<GETreeData> tree(@RequestParam Map<String, String> condition) {
		//■ 校验参数
		String typeCode = condition.get("typeCode");
		if (StringUtils.isBlank(typeCode)) {
			Notification notification = new Notification(MessageCode.MISS_PARAM,
					"医疗记录组合元素类型编码");
			throw new NotificationException(notification);
		}
		
		
		//■　查询导航树数据
		Composite<GETreeData> treeNode = null;
		
		//如果是惰性加载，需要根据当前节点构造不同的节点包装器
		//目前先简化处理，不支持惰性加载。
		if (true) {
			GETreeData treeData = new GETreeData();
			treeData.setHisOrgCode(this.getOrgCode());
			treeData.setHisOrgName(this.getOrgName());
			treeNode = new GEHispitalTreeNode(treeData, condition);
			
			//加载树数据
			treeNode.loadChildren();
			treeNode.setupCounter();
		}
		
		TreeNode<GETreeData> root = new TreeNode<GETreeData>();
		treeNode.copyToTreeNode(root);
		
		//■　设置返回值
		TreeResult<GETreeData> result = new TreeResult<GETreeData>();
		result.setRoot(root);
		return result;
	}
	
	@Override
	public ArrayResult<GroupElementCategory> searchCategory(Map<String, String> condition) {
		
		//■　查询导航树数据
		GroupElementCategory data = new GroupElementCategory();
		GroupElementCategoryNode treeNode = new GroupElementCategoryNode(data, condition);
		treeNode.loadChildren();
		
		List<GroupElementCategory> catList = getCategoryListFromTree(null, treeNode, "");
		GroupElementCategory[] categorys = new GroupElementCategory[catList.size()];
		categorys = catList.toArray(categorys);
		
		//■ 返回结果
		ArrayResultBuilder<GroupElementCategory> builder = ArrayResultBuilder.newArrayResult(GroupElementCategory.class);
		int size = categorys.length;
		builder.withData(categorys);
		ArrayResult<GroupElementCategory> rs = builder.build();
		rs.setTotal(size);
		return rs; 
	}
	
	private List<GroupElementCategory> getCategoryListFromTree(List<GroupElementCategory> catList, GroupElementCategoryNode treeNode, String indent) {
		if (catList == null) {
			catList = new ArrayList<GroupElementCategory>();
		}
		
		GroupElementCategory data = treeNode.getData();
		if (!StringUtils.isBlank(data.getCode())) {
			data.setName(indent + data.getName());
			catList.add(data);
			
			indent += "  ";
		}
		
		ArrayList<Composite<GroupElementCategory>> children = treeNode.getChildren();
		for(Composite<GroupElementCategory> item:children) {
			this.getCategoryListFromTree(catList, (GroupElementCategoryNode)item, indent);
		}
		
		return catList;
	}
	
	public static void main(String[] args) {
		Map<String, String> condition = new HashMap<String, String>();
		
		Composite<GETreeData> treeNode = null;
		
		//如果是惰性加载，需要根据当前节点构造不同的节点包装器
		//目前先简化处理，不支持惰性加载。
		if (true) {
			GETreeData treeData = new GETreeData();
			treeData.setHisOrgCode("SZLH");
			treeData.setHisOrgName("深圳龙华医院");
			treeData.setNodeType("1");
			
			treeNode = new GEHispitalTreeNode(treeData, condition);
			
			//加载树数据
			treeNode.loadChildren();
			treeNode.setupCounter();
		}
		
		System.out.println(treeNode.toString());
	}
	
}
