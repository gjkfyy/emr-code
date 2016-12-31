package pkuhit.iih.mr.wr;

import pkuhit.iih.mr.md.AmrStatus;

public class AmrActionCheck {

	/**
	 * 检查病案是否可编辑 
	 * @param amr
	 * @return null:可编辑，否则返回错误消息。
	 */
	String checkCanEdit(Amr amr)
	{
		String result = null;
		if (!(AmrStatus.WRITE_STARTED.equals(amr.getStatusCode())
				|| AmrStatus.QA_STARTED.equals(amr.getStatusCode())))
		{
			// TODO 标准化消息处理
			result = "MSG001:病案处于" + amr.getStatusName() + "状态，病历不可编辑！";
		}
		return result;
	}
}
