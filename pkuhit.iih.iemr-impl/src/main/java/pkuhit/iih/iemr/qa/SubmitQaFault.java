/**
 * <p>文件名:		SubmitQaFault.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 */

package pkuhit.iih.iemr.qa;

/**
 * <p>
 * SubmitQaFault
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
 *          <td>2014年12月6日 上午10:16:20</td>
 *          </tr>
 *          <tr>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          <td>XXX</td>
 *          </tr>
 *          </table>
 */
public class SubmitQaFault {
	
	private String encounterPk;
	
	private String qaTypeCode;
	
	private String[] dataList;
	
	public String getQaTypeCode() {
		return qaTypeCode;
	}

	public void setQaTypeCode(String qaTypeCode) {
		this.qaTypeCode = qaTypeCode;
	}

	public String getEncounterPk() {
		return encounterPk;
	}

	public void setEncounterPk(String encounterPk) {
		this.encounterPk = encounterPk;
	}

	public String[] getDataList() {
		return dataList;
	}

	public void setDataList(String[] dataList) {
		this.dataList = dataList;
	}

	/**
	 * 构造器
	 */
	public SubmitQaFault() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * FIXME
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
