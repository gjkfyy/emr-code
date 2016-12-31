package pkuhit.iih.mr.wr;

import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.md.MrSignLevel;
import pkuhit.iih.mr.md.MrStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.me.DataObjectService;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

// 检查命令的可用操作
public class MrActionCheck {

	/**
	 * 检查全部的5个操作标志，并赋予医疗记录对象
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @return
	 */
	MedicalRecord setActionFlag(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) {
		MedicalRecord result = mr;

		// Step1 判断病案状态下病历是否可编辑
		boolean canEditAmr = this.getCheckCanEditByAmrMessage(amr) == null;

		// Step2 判断病历是否可编辑
		boolean canEditMr = canEditAmr
				&& this.getCheckCanEditMessage(mr, amr, userSignLevelCode, userId, dataObjectService) == null;
		result.setCanEdit(canEditMr ? 1 : 0);

		// Step3 判断是否可签名提交
		boolean canSignMr = canEditMr && this.getCheckCanSignMessage(mr, userId, dataObjectService) == null;
		result.setCanSign(canSignMr ? 1 : 0);

		// Step4 判断是否可驳回
		boolean canRejectMr = canEditMr
				&& this.getCheckCanRejectMessage(mr, userSignLevelCode, dataObjectService, userId) == null;
		result.setCanReject(canRejectMr ? 1 : 0);

		// Step5 判断是否可撤销签名
		boolean canCancelSignedMr = canEditAmr && this.getCheckCanCancelSignedMessage(mr, userId) == null;
		result.setCanCancelSigned(canCancelSignedMr ? 1 : 0);

		// Step6 判断是否可打印
		boolean canPrintMr = this.getCheckCanPrintMessage(mr) == null;
		result.setCanPrint(canPrintMr ? 1 : 0);

		// Step7 设置可删除标志
		boolean canDeleteMr = canEditAmr && this.getCheckCanDeleteMessage(mr, userId) == null;
		result.setCanDelete(canDeleteMr ? 1 : 0);

		// Step8 设置可保存标志
		boolean canSaveMr = canEditMr
				&& this.getCheckCanEditMessage(mr, amr, userSignLevelCode, userId, dataObjectService) == null;
		result.setCanUpdate(canSaveMr ? 1 : 0);

		// Step9 设置审签标志
		boolean canApprove = canEditMr
				&& this.getCheckCanApproveMessage(mr, userSignLevelCode, dataObjectService, userId) == null;
		result.setCanApprove(canApprove ? 1 : 0);

		// Step10 设置可审签撤回标志
		boolean canCancelApprove = canEditAmr
				&& this.getCheckCanCancelApproveMessage(mr, userId, userSignLevelCode) == null;
		result.setCanCancelApprove(canCancelApprove ? 1 : 0);

		// Step11 设置可开始审签
		boolean canStartApprove = canEditAmr
				&& this.getCanStartApproveMessage(mr, userSignLevelCode, dataObjectService, userId) == null;
		result.setCanStartApprove(canStartApprove ? 1 : 0);

		// Step11 设置可另存为模板
		boolean canSaveAsTemplate = canEditMr;
		result.setCanSaveAsTemplate(canSaveAsTemplate ? 1 : 0);
		return result;
	}

	/**
	 * 检查是否可插入病历
	 * 
	 * @param amr
	 * @throws Throwable
	 */
	void checkCanCreate(Amr amr) throws Throwable {
		this.checkCanEditByAmr(amr);
	}

	/**
	 * 检查病历是否可编辑
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @throws Throwable
	 */
	void checkCanEdit(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) throws Throwable {
		Notification msg = this.getCheckCanEditMessage(mr, amr, userSignLevelCode, userId, dataObjectService);
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
	void checkCanSign(MedicalRecord mr, Amr amr, String userId, DataObjectService dataObjectService) throws Throwable {
		this.checkCanEdit(mr, amr, null, userId, dataObjectService);
		Notification msg = this.getCheckCanSignMessage(mr, userId, dataObjectService);
		if (msg != null)
			throw new NotificationException(msg);
	}

	private Notification getCheckCanSignMessage(MedicalRecord mr, String userId, DataObjectService dataObjectService) {
		Notification result = null;
		if (!userId.equals(mr.getCreateUserId())) {
			result = new Notification(MessageCode.UN_SIGN_NOT_CREATER);
		}
		if (!MrStatus.CREATED.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_SIGN_MR_STA, mr.getStatusName());
		}
		return result;
	}

	/**
	 * 检查是否可驳回
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @throws Throwable
	 */
	void checkCanReject(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) throws Throwable {
		this.checkCanApprove(mr, amr, userSignLevelCode, userId, dataObjectService);
		Notification msg = this.getCheckCanRejectMessage(mr, userSignLevelCode, dataObjectService, userId);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可审签通过
	 * 
	 * @param mr
	 * @param amr
	 * @param userSignLevelCode
	 * @param userId
	 * @param dataObjectService
	 * @throws Throwable
	 */
	void checkCanApprove(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) throws Throwable {
		this.checkCanEdit(mr, amr, userSignLevelCode, userId, dataObjectService);
		Notification msg = this.getCheckCanApproveMessage(mr, userSignLevelCode, dataObjectService, userId);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可撤销签名
	 * 
	 * @param mr
	 * @param amr
	 * @throws Throwable
	 */
	void checkCanCancelSigned(MedicalRecord mr, Amr amr, String userId) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanCancelSignedMessage(mr, userId);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可打印
	 * 
	 * @param mr
	 * @throws Throwable
	 */
	void checkCanPrint(MedicalRecord mr) throws Throwable {
		Notification msg = this.getCheckCanPrintMessage(mr);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可删除
	 * 
	 * @param mr
	 * @throws Throwable
	 */
	void checkCanDelete(MedicalRecord mr, String userId) throws Throwable {
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
	void checkCanSave(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) throws Throwable {
		this.checkCanEdit(mr, amr, userSignLevelCode, userId, dataObjectService);
		// Notification msg = this.getCheckCanSaveMessage(mr, userId);
		// if (msg != null)
		// throw new NotificationException(msg);
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
	 * 检查病案状态下的病历是否可开始审签
	 * 
	 * @param amr
	 * @throws Throwable
	 */
	void checkCanStartApprove(MedicalRecord mr, String userSignLevelCode, DataObjectService dataObjectService,
			String userId) throws Throwable {
		Notification msg = this.getCanStartApproveMessage(mr, userSignLevelCode, dataObjectService, userId);
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
	private Notification getCheckCanEditMessage(MedicalRecord mr, Amr amr, String userSignLevelCode, String userId,
			DataObjectService dataObjectService) {
		Notification result = null;

		// 病案状态为书写已开始
		if (AmrStatus.WRITE_STARTED.equals(amr.getStatusCode())) {
			// Step1 判断病历状态是否为新建
			if (MrStatus.CREATED.equals(mr.getStatusCode())) {
				if (mr.getPermitF()!=1) {
					// 当前用户非创建者不可编辑
					if (!userId.equals(mr.getCreateUserId())) {
						result = new Notification(MessageCode.UN_EDIT_NOT_CREATER);
					}
				}
				
			}

			// Step3判断病历是否已完成
			if (null != mr.getCompletedFlag() && 1 == mr.getCompletedFlag()) {
				result = new Notification(MessageCode.UN_EDIT_COMP);
			}

			MrStatus ms = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getStatusCode()).getObject(MrStatus.class);
			/*
			 * // Step4 判断病历是否处于被驳回状态 if (null != mr.getRejectedFlag() && 1 ==
			 * mr.getRejectedFlag()) { // 用户审签等级是否大于病历当前状态对应的审签等级，符合条件的用户均不可编辑
			 * if (null != ms.getSignLevelCode() && compare(userSignLevelCode,
			 * ms.getSignLevelCode()) > 0) { result = new
			 * Notification(MessageCode.UN_EDIT_REJECT); } }
			 */
			// 审签的情况
			if (!(MrStatus.CREATED.equals(mr.getStatusCode()) || MrStatus.SIGNED_LEVEL_3.equals(mr.getStatusCode())
					|| MrStatus.SUBMITTED.equals(mr.getStatusCode()) || MrStatus.SIGNED_LEVEL_2.equals(mr
					.getStatusCode())) && 1 != mr.getCompletedFlag()) {
				// 提交人是自己不可审签
				if (userId.equals(mr.getSubmitCd())) {
					if(mr.getUpDocCheckSubmit()!=null&&!mr.getUpDocCheckSubmit().equals("1"))
					result = new Notification(MessageCode.UN_APPROVE_SUB_SELF);
				}

				// 根据用户审签等级判断对应的审签者
				if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
					if (!MrStatus.SIGNED_LEVEL_2ING.equals(mr.getStatusCode())) {
						result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
					}
				} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
					if (!MrStatus.SIGNED_LEVEL_3ING.equals(mr.getStatusCode())) {
						result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
					}
				}

				// Step5 判断用户是否可审签，用户的审签级别 > 当前病历的审签级别
				if (null != ms.getSignLevelCode() && compare(userSignLevelCode, ms.getSignLevelCode()) < 0) {
					result = new Notification(MessageCode.UN_EDIT_SIGN_LVL, ms.getName());
				}
			} else if (MrStatus.CREATED.equals(mr.getStatusCode())) {
				if (mr.getPermitF()!=1) {
					if (!userId.equals(mr.getCreateUserId())) {
						result = new Notification(MessageCode.UN_EDIT_NOT_CREATER, ms.getName());
					}
				}
			} else {
				result = new Notification(MessageCode.UN_EDIT_MR_STA, ms.getName());
			}
		}
		// 返回可编辑
		return result;
	}

	/**
	 * 检查是否可【审签通过】【驳回】，前提是可编辑
	 * 
	 * @param saveMr
	 * @param dbMr
	 * @param amr
	 * @return null:可审签、驳回，非空返回错误码
	 */
	private Notification getCheckCanApproveMessage(MedicalRecord mr, String userSignLevelCode,
			DataObjectService dataObjectService, String userId) {
		Notification result = null;
		MrStatus ms = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getStatusCode()).getObject(MrStatus.class);
		// Step1 病历状态不需要审签情况
		if (!(null != mr.getStatusCode() && (mr.getStatusCode().equals(MrStatus.SIGNED_LEVEL_2ING) || mr
				.getStatusCode().equals(MrStatus.SIGNED_LEVEL_3ING)))) {
			result = new Notification(MessageCode.UN_APPROVE_MR_STA, ms.getName());
		}

		// 病历不需要审签
		if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLevelCode())
				|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLevelCode())) {
			result = new Notification(MessageCode.UN_APPROVE_SUB_SELF);
		}

		// 提交人是自己不可开始审签
		if (userId.equals(mr.getSubmitCd())) {
			if(mr.getUpDocCheckSubmit()!=null&&!mr.getUpDocCheckSubmit().equals("1"))
			result = new Notification(MessageCode.UN_APPROVE_SUB_SELF);
		}
		// 如果是上级医师查房记录，并且当前用户为此份病历设置的上级医师，则可以越级审签
		if (!(mr.getTypeCode().equals("MRM16.19") || mr.getTypeCode().equals("MRM16.20"))
				&& userId.equals(mr.getSuperiorDoctorId())) {
			// 根据用户审签等级判断对应的审签者
			if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
				if (!MrStatus.SIGNED_LEVEL_2ING.equals(mr.getStatusCode())) {
					result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
				}
			} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
				if (!MrStatus.SIGNED_LEVEL_3ING.equals(mr.getStatusCode())) {
					result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
				}
			}
		}

		// Step2 用户的审签级别 <= 当前病历的审签级别，审签等级不够
		if (null != ms.getSignLevelCode() && compare(userSignLevelCode, ms.getSignLevelCode()) > 0) {
			result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
		}
		return result;
	}

	/**
	 * 检查是否可开始审签
	 * 
	 * @param saveMr
	 * @param dbMr
	 * @param amr
	 * @return null:可审签、驳回，非空返回错误码
	 */
	private Notification getCanStartApproveMessage(MedicalRecord mr, String userSignLevelCode,
			DataObjectService dataObjectService, String userId) {
		Notification result = null;
		MrStatus ms = dataObjectService.getObject(MrStatus.OBJ_CD, mr.getStatusCode()).getObject(MrStatus.class);
		// Step1 病历状态不可开始审签
		if (!(null != mr.getStatusCode() && (mr.getStatusCode().equals(MrStatus.SUBMITTED) || mr.getStatusCode()
				.equals(MrStatus.SIGNED_LEVEL_2)))) {
			result = new Notification(MessageCode.UN_APPROVE_MR_STA, ms.getName());
		}

		// Step1 病历已完成不可开始审签
		if (null != mr.getCompletedFlag() && 1 == mr.getCompletedFlag()) {
			result = new Notification(MessageCode.UN_START_APPROVE_MR_COMP, ms.getName());
		}

		// 提交人是自己不可开始审签
		if (userId.equals(mr.getSubmitCd())) {
			if(mr.getUpDocCheckSubmit()!=null&&!mr.getUpDocCheckSubmit().equals("1"))//不是上级申签医生验证提交
			result = new Notification(MessageCode.UN_APPROVE_SUB_SELF);
		}
		// 病历不需要审签
		if (MrSignLevel.LEVEL_ONE_SIGN.equals(mr.getSignLevelCode())
				|| MrSignLevel.NEED_NOT_SIGN.equals(mr.getSignLevelCode())) {
			result = new Notification(MessageCode.UN_APPROVE_SUB_SELF);
		}

		// // Step2 用户的审签级别 <= 当前病历的审签级别，审签等级不够
		// if
		// (null==userSignLevelCode||MrSignLevel.LEVEL_ONE_SIGN.equals(userSignLevelCode))
		// {
		// result = new Notification(MessageCode.UN_SIGN_SIGN_LVL,
		// ms.getName());
		// }
		// 如果是上级医师查房记录，并且当前用户为此份病历设置的上级医师，则可以越级审签
		if (!(mr.getTypeCode().equals("MRM16.19") || mr.getTypeCode().equals("MRM16.20"))
				&& userId.equals(mr.getSuperiorDoctorId())) {
			// 根据用户审签等级判断对应的权限
			if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
				if (!MrStatus.SUBMITTED.equals(mr.getStatusCode())) {
					result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
				}
			} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
				if (!MrStatus.SIGNED_LEVEL_2.equals(mr.getStatusCode())) {
					result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
				}
			}
		}

		// Step2 用户的审签级别 <= 当前病历的审签级别，审签等级不够
		if (null != ms.getSignLevelCode() && compare(userSignLevelCode, ms.getSignLevelCode()) <= 0) {
			result = new Notification(MessageCode.UN_SIGN_SIGN_LVL, ms.getName());
		}
		return result;
	}

	// 检查是否可【撤销签名】,前提是病案可编辑
	private Notification getCheckCanCancelSignedMessage(MedicalRecord mr, String userId) {
		Notification result = null;

		// // Step1 病案非书写中状态，不可撤销签名
		// if (!AmrStatus.WRITE_STARTED.equals(mr.getQaStatusCode())) {
		// result = new Notification(MessageCode.UN_CANCEL_SIGN_AMR_STA,
		// mr.getQaStatusName());
		// return result;
		// }

		// Step2非已提交状态的文档，不可 撤销签名
		if (!MrStatus.SUBMITTED.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_CANCEL_MR_STA, mr.getStatusName());
		}

		// Step2非自己提交的文档，不可 撤销签名   不是上级申签医师验证提交
		if (!userId.equals(mr.getSubmitCd())) {
			if(mr.getUpDocCheckSubmit()!=null&&!mr.getUpDocCheckSubmit().equals("1"))
			result = new Notification(MessageCode.UN_CANCEL_MR_STA, mr.getStatusName());
		}

		// 可撤销签名
		return result;
	}

	/**
	 * 检查是否可【驳回】操作，驳回的前提是可签名
	 * 
	 * @param saveMr
	 * @param dbMr
	 * @return null：可驳回；非空返回错误码
	 */
	private Notification getCheckCanRejectMessage(MedicalRecord mr, String userSignLevelCode,
			DataObjectService dataObjectService, String userId) {
		Notification result = null;

		result = this.getCheckCanApproveMessage(mr, userSignLevelCode, dataObjectService, userId);
		return result;
	}

	/**
	 * 检查是否可【打印】【续打】，第一次签名后方可打印
	 * 
	 * @param mr
	 * @return
	 */
	private Notification getCheckCanPrintMessage(MedicalRecord mr) {
		Notification result = null;
		if (MrStatus.CREATED.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_PRINT_MR_STA, mr.getStatusName());
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
			return result;
		}

		// 新建者不是当前用户，不可删除
		if (!userId.equals(mr.getCreateUserId())) {
			result = new Notification(MessageCode.UN_DEL_CREAT_LAST_UPDATE);
			return result;
		}

		return result;
	}

	/**
	 * 
	 * signLevelCode1减去signLevelCode2的值
	 * 
	 * @param signLevelCode1
	 * @param signLevelCode2
	 * @return
	 */
	private int compare(String signLevelCode1, String signLevelCode2) {
		if (null == signLevelCode1 || "".equals(signLevelCode1.trim())) {
			return -5;
		}
		if (null == signLevelCode2 || "".equals(signLevelCode2.trim())) {
			return 5;
		}
		int level1 = Integer.parseInt(signLevelCode1.substring(signLevelCode1.length() - 1, signLevelCode1.length()));
		int level2 = Integer.parseInt(signLevelCode2.substring(signLevelCode2.length() - 1, signLevelCode2.length()));
		return level1 - level2;
	}

	/**
	 * 检查是否可【撤销审签】
	 * 
	 * @param value
	 * @param amr
	 * @param userId
	 * @throws Throwable
	 */
	void checkCanCancelApprove(MedicalRecord value, Amr amr, String userId, String userSignLevelCode) throws Throwable {
		this.checkCanEditByAmr(amr);
		Notification msg = this.getCheckCanCancelApproveMessage(value, userId, userSignLevelCode);
		if (msg != null)
			throw new NotificationException(msg);
	}

	/**
	 * 检查是否可【撤销审签】,前提是病案可编辑
	 * 
	 * @param mr
	 * @param userId
	 * @param userSignLevelCode
	 * @return
	 */
	private Notification getCheckCanCancelApproveMessage(MedicalRecord mr, String userId, String userSignLevelCode) {
		Notification result = null;
		// Step1 终末质控状态处于【终末质控已开始】【终末质控已完成】，不可撤销签名
		// if (AmrStatus.QA_STARTED.equals(mr.getQaStatusCode()) ||
		// AmrStatus.QA_COMPLETED.equals(mr.getQaStatusCode())) {
		// result = new Notification(MessageCode.UN_CANCEL_SIGN_QA_STA,
		// mr.getQaStatusName());
		// return result;
		// }
		// Step2 审签者不是自己，不可 撤销审签
		// 根据用户审签等级判断对应的审签者
		if (MrSignLevel.LEVEL_TWO_SIGN.equals(userSignLevelCode)) {
			if (!(userId.equals(mr.getMastDoctorCd()) && userId.equals(mr.getLastUpdateUserId()))) {
				result = new Notification(MessageCode.UN_CANCEL_LAST_SIGNER);
			}
		} else if (MrSignLevel.LEVEL_THREE_SIGN.equals(userSignLevelCode)) {
			if (!(userId.equals(mr.getDirDoctorCd()) && userId.equals(mr.getLastUpdateUserId()))) {
				result = new Notification(MessageCode.UN_CANCEL_LAST_SIGNER);
			}
		} else {
			result = new Notification(MessageCode.UN_CANCEL_LAST_SIGNER);
		}
		// Step3新建、已提交、审签中状态的文档不存在审签，不可撤销审签
		if (MrStatus.CREATED.equals(mr.getStatusCode()) || MrStatus.SUBMITTED.equals(mr.getStatusCode())
				|| MrStatus.SIGNED_LEVEL_2ING.equals(mr.getStatusCode())
				|| MrStatus.SIGNED_LEVEL_3ING.equals(mr.getStatusCode())) {
			result = new Notification(MessageCode.UN_CANCEL_MR_STA, mr.getStatusName());
		}
		// 可撤销签名
		return result;
	}
}
