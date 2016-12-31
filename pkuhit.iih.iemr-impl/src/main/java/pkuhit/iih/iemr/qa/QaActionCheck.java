package pkuhit.iih.iemr.qa;

import pkuhit.iih.mr.md.AmrStatus;
import pkuhit.iih.mr.pub.MessageCode;
import pkuhit.iih.mr.wr.Amr;
import xap.sv.notification.Notification;
import xap.sv.notification.exception.NotificationException;

/**
 * 
 * <p>QaRecordActionCheck</p>
 * <p>判断质控工作记录是否可操作</p>
 *
 * @author		chengfeng(cheng_feng@founder.com)
 * @version		0.0.0
 */
public class QaActionCheck {
	
	public QaActionCheck() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 检查病案状态下的病历是否可编辑 
	 * @param amr
	 * @throws Throwable
	 */
	private void checkCanOperateByAmr(Amr amr) throws Throwable{
		Notification msg = this.getCheckCanOperateByAmrMessage(amr);
		if (msg != null) throw new NotificationException(msg);
	}
	
	/**
	 * 检查是否可删除 
	 * @param dbMr
	 * @return
	 */
	private Notification getCheckCanOperateByAmrMessage(Amr amr)
	{
		Notification result = null;
		// 已归档状态，不可操作
		if (AmrStatus.ARCHIVED.equals(amr.getStatusCode())){
			result = new Notification(MessageCode.UN_OPERATE_AMR_STA, "病案处于"+amr.getStatusName() + "状态，不可操作！");
		}
		return result;
	}
	
}
