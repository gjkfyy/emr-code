package pkuhit.iih.mr.wr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import pkuhit.iih.mr.dao.auto.entity.Mr;
import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.md.MrType;
import pkuhit.iih.mr.md.dao.auto.entity.MdMrTp;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.pub.IihUtils;
import pkuhit.md.SysFunctionCode;
import pkuhit.me.DataObjectService;
import pkuhit.xap.pm.Param;
import pkuhit.xap.pm.ParamsService;
import pkuhit.xap.pm.ParamsSetService;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

// 检查命令的可用操作
public class OutMrActionCheck {

	/**
	 * 检查全部的5个操作标志，并赋予医疗记录对象
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @return
	 */
	MedicalRecord setActionFlag(MedicalRecord mr, Amr amr,String userId, DataObjectService dataObjectService,Param[] params,ParamsService paramsService,ParamsSetService paramsSetService) {
		MedicalRecord result = mr;

		// Step1 判断病案状态下病历是否可编辑
		boolean canEditAmr = this.getCheckCanEditByAmrMessage(amr) == null;
//		boolean canEditAmr =true;

		// Step2 判断病历是否可编辑
		boolean canEditMr = canEditAmr
				&& this.getCheckCanEditMessage(mr, amr,userId, dataObjectService,params,paramsSetService) == null;
		result.setCanEdit(canEditMr ? 1 : 0);

		// Step3 判断是否可签名提交
		boolean canSignMr =  canEditAmr
				&&this.getCheckCanSignMessage(mr, amr,userId, dataObjectService) == null;
		result.setCanSign(canSignMr ? 1 : 0);

		// Step5 判断是否可撤销签名
		boolean canCancelSignedMr = canEditAmr && this.getCheckCanCancelSignedMessage(mr,amr, userId,paramsService) == null;
		result.setCanCancelSigned(canCancelSignedMr ? 1 : 0);

		// Step6 判断是否可打印
		boolean canPrintMr = this.getCheckCanPrintMessage(mr,userId) == null;
		result.setCanPrint(canPrintMr ? 1 : 0);

		// Step7 设置可删除标志
		boolean canDeleteMr = canEditAmr && canEditMr&&this.getCheckCanDeleteMessage(mr, userId) == null;
		result.setCanDelete(canDeleteMr ? 1 : 0);

		// Step8 设置可保存标志
		boolean canSaveMr = canEditMr&& this.getCheckCanEditMessage(mr,amr, userId, dataObjectService, params,paramsSetService) == null;
		result.setCanUpdate(canSaveMr ? 1 : 0);
		
		// Step11 设置可另存为模板
		boolean canSaveAsTemplate = canEditMr;
		result.setCanSaveAsTemplate(canSaveAsTemplate? 1 : 0);
//		this.setHideButton(result,userSignLevelCode);
		return result;
	}

	/**
	 * 检查是否可新建病历
	 * @param outMedicalRecordService 
	 * 
	 * @param amr
	 * @throws Throwable
	 */
	void checkCanCreate(MedicalRecord value,Amr amr, OutMedicalRecordServiceImpl outMedicalRecordService) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg=this.checkCanCreateMessage(value, outMedicalRecordService);
		if (msg != null)
			throw new NotificationException(msg);
	}
	/**
	 * 检查是否可新建病历
	 * @param outMedicalRecordService 
	 * 
	 * @param amr
	 * @throws Throwable
	 */
	Notification checkCanCreateMessage(MedicalRecord value, OutMedicalRecordServiceImpl outMedicalRecordService) throws Throwable {
		Notification result = null;
		Map<String, String> param=new HashMap<String, String>();
		param.put("encounterPk", value.getEncounterPk());
		if(MrType.OUT_FIRST_RECORD.equals(value.getTypeCode())||MrType.OUT_REPLY_RECORD.equals(value.getTypeCode())){
			param.put("mrTypeCustomCode", "MRM14.09");
			MedicalRecord[] mrs=outMedicalRecordService.search(param).getDataList();
			if(null!=mrs&&mrs.length>0){
				result = new Notification(MessageCode.CAN_NOT_CREATE,"门诊病历");
			}
		}else{
			param.put("typeCode", value.getTypeCode());
			MdMrTp mdMrTp=outMedicalRecordService.mdMrTpDao.selectById(value.getTypeCode());
			if (1==mdMrTp.getOnlyF().intValue()) {
				List<Mr> mrs = outMedicalRecordService.cusMrDao.selectByEnPk(value.getEncounterPk(), null, value.getTypeCode(),null,1,null);
				if(null!=mrs&&mrs.size()>0){
					result = new Notification(MessageCode.CAN_NOT_CREATE,mdMrTp.getNm());
				}
			}
		}
		return result;
	}

	/**
	 * 检查病历是否可编辑
	 * @param mr
	 * @param userId
	 * @param dataObjectService
	 * @throws Throwable
	 */
	void checkCanEdit(MedicalRecord mr, Amr amr,String userId, DataObjectService dataObjectService,Param[] params,ParamsSetService paramsSetService) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanEditMessage(mr, amr,userId, dataObjectService, params,paramsSetService);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可签名提交
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @throws Throwable
	 */
	void checkCanSign(MedicalRecord mr,Amr amr, String userId, DataObjectService dataObjectService)
			throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanSignMessage(mr,amr, userId, dataObjectService);
		if (msg != null)
			throw new NotificationException(msg);
	}

	private Notification getCheckCanSignMessage(MedicalRecord mr, Amr amr,String userId, DataObjectService dataObjectService) {
		Notification result = null;
		if (!userId.equals(mr.getCreateUserId())) {
			result = new Notification(MessageCode.UN_SIGN_NOT_CREATER);
		}
		if(!MrStatus.CREATED.equals(mr.getStatusCode())){
			result = new Notification(MessageCode.UN_SIGN_MR_STA,mr.getStatusName());
		}
		return result;
	}


	/**
	 * 检查是否可撤销签名
	 * 
	 * @param mr
	 * @param amr
	 * @throws Throwable
	 */
	void checkCanCancelSigned(MedicalRecord mr, Amr amr,String userId,ParamsService paramsService) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanCancelSignedMessage(mr, amr,userId,paramsService);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可打印
	 * 
	 * @param mr
	 * @throws Throwable
	 */
	void checkCanPrint(MedicalRecord mr,String userId) throws Throwable {
		Notification msg = this.getCheckCanPrintMessage(mr,userId);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可删除
	 * 
	 * @param mr
	 * @throws Throwable
	 */
	void checkCanDelete(MedicalRecord mr,Amr amr, String userId) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanDeleteMessage(mr, userId);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可保存
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @throws Throwable
	 */
	void checkCanSave(MedicalRecord mr,Amr amr, String userId, DataObjectService dataObjectService,Param[] params,ParamsSetService paramsSetService) throws Throwable {
		this.checkCanEditByAmr(amr);
		this.checkCanEdit(mr, amr,userId, dataObjectService, params,paramsSetService);
	}

	/**
	 * 检查病案状态下的病历是否可编辑
	 * 
	 * @param amr
	 * @throws Throwable
	 */
	private void checkCanEditByAmr(Amr amr) throws Throwable {
		Notification msg = this.getCheckCanEditByAmrMessage(amr);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查病案状态下的病历文书是否可编辑
	 * 
	 * @param amr
	 * @return null:可编辑，否则返回错误消息。
	 */
	private Notification getCheckCanEditByAmrMessage(Amr amr) {
		Notification result = null;
		if (!AmrStatus.WRITE_STARTED.equals(amr.getStatusCode())) {
			result = new Notification(MessageCode.UN_EDIT_AMR_STA, amr.getStatusName());
		}
		return result;
	}

	/**
	 * 检查是否可编辑对应操作【编辑】【保存】【只读】
	 * 
	 * @param saveMr
	 * @param dbMr
	 * @param amr
	 * @return null:可编辑，非空返回错误码
	 */
	private Notification getCheckCanEditMessage(MedicalRecord mr, Amr amr,String userId,DataObjectService dataObjectService,Param[] params,ParamsSetService paramsSetService) {
		Notification result = null;
		
			// Step1判断病历是否已完成
			if (null != mr.getCompletedFlag() && 1 == mr.getCompletedFlag()) {
				result = new Notification(MessageCode.UN_EDIT_COMP);
			}
			//判断是否超过设置的时间限制
			result = checkFirmDateOverTime(mr, params,result);
			// Step3判断病历状态是否可以修改
			MrStatus ms = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getStatusCode()).getObject(MrStatus.class);
			if(!MrStatus.CREATED.equals(mr.getStatusCode())){
				result = new Notification(MessageCode.UN_EDIT_MR_STA, ms.getName());
			}
			// Step4判断病历创建者是否为当前用户
			if(MrStatus.CREATED.equals(mr.getStatusCode())){
				if(!userId.equals(mr.getCreateUserId())){
					result = new Notification(MessageCode.UN_EDIT_NOT_CREATER, ms.getName());
				}
			}
			
			String gulouCaEnabled=paramsSetService.searchFunFlagByKey("GULOU_CA_ENABLED").getData();
				// Step5判断病历是否签章
			if(!StringUtils.isBlank(gulouCaEnabled)&&gulouCaEnabled.equals("1")){
				result = new Notification(MessageCode.CAN_NOT_UPDATE_BY_CA, mr.getName());
			}
		return result;
	}

	private Notification checkFirmDateOverTime(MedicalRecord mr, Param[] params,Notification result) {
		// Step2判断病历是否创建超过指定时间
//		Notification result=null;
		boolean flag=false;
		int hourSet = 0;
		for (Param param : params) {
			if("ENABLED".equals(param.getKey())){
				if("1".equals(param.getValue())){
					flag=true;
				}
			}else if("HOUR_NUMBER".equals(param.getKey())){
				if(IihUtils.isInteger(param.getValue())){
					hourSet=Integer.valueOf(param.getValue());
				}
			}
		}
		long now=System.currentTimeMillis();
		long bizTime=mr.getBizTime().getTime();
		long balance=now-bizTime;
		
		if (flag&&hourSet>0&&balance>(hourSet*3600000)) {
			result = new Notification(MessageCode.UN_EDIT_TIME_OUT,hourSet+"小时");
		}
		return result;
	}

	private Notification getCheckCanCancelSignedMessage(MedicalRecord mr, Amr amr,String userId,ParamsService paramsService) {
		Notification result = null;
/*		// Step1判断病历是否创建超过24小时
		long now=System.currentTimeMillis();
		long bizTime=mr.getBizTime().getTime();
		long balance=now-bizTime;
		if (balance>86400000) {
			result = new Notification(MessageCode.UN_EDIT_TIME_OUT,"24小时");
		}
*/
		// Step2非已提交状态的文档，不可 撤销签名
		if (!MrStatus.SUBMITTED.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_CANCEL_MR_STA, mr.getStatusName());
		}
		
		// Step2非自己提交的文档，不可 撤销签名
		if (!userId.equals(mr.getSubmitCd())) {
			result = new Notification(MessageCode.UN_CANCEL_MR_STA, mr.getStatusName());
		}
		
		//门诊限制提交多长时间后不容撤回
		Param[] updateTimeLimitCofig = paramsService.getParam(
				SysFunctionCode.MR_UPDATE_TIME_LIMIT_CONFIG).getDataList();
		result = checkFirmDateOverTime(mr, updateTimeLimitCofig,result);
		
		//验证系统参数配置是否允许提交后撤回
		Param[] params = paramsService.getParam(SysFunctionCode.OMR_REVORKE_ENABLE).getDataList();
		if(params.length>0){
			for (int i = 0; i < params.length; i++) {
				if(params[i].getKey().equals("OMR_SUBMIT_CHECK_REVOKE")){
					if(params[i].getValue().equals("0")){
						result = new Notification(MessageCode.OMR_SUBMIT_CHECK_REVOKE);
					}
				}
			}
		}
		
		// 可撤销签名
		return result;
	}

	/**
	 * 检查是否可【打印】【续打】，第一次签名后方可打印
	 * 
	 * @param mr
	 * @return
	 */
	private Notification getCheckCanPrintMessage(MedicalRecord mr,String userId) {
		Notification result = null;
		if (userId.equals(mr.getCreateUserId())) {
			result = new Notification(MessageCode.UN_PRINT_NOT_CREATOR, mr.getStatusName());
		}
		return result;
	}

	/**
	 * 检查是否可删除
	 * 
	 * @param dbMr
	 * @return
	 */
	private Notification getCheckCanDeleteMessage(MedicalRecord mr, String userId) {
		Notification result = null;
		// 非新建状态，不可删除
		if (!MrStatus.CREATED.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_DEL_MR_STA, mr.getStatusName());
		}

		// 新建者不是当前用户，不可删除
		if ( !userId.equals(mr.getCreateUserId())) {
			result = new Notification(MessageCode.UN_DEL_CREAT_LAST_UPDATE);
		}

		return result;
	}
}
