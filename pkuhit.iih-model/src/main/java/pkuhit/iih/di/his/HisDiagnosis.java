/**
 * <p>文件名:		HisDiagnosis.java</p>
 * <p>版权:		CopyrightTag</p>
 * <p>公司:		CompanyTag</p>
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
*/

package pkuhit.iih.di.his;

import java.util.Date;


/**
 * <p>HisDiagnosis</p>
 * <p>TODO</p>
 *
 * @author		李德强(li_deqiang@founder.com, readwall@163.com)
 * @version		0.0.0
 * <table style="border:1px solid gray;">
 * <tr>
 * <th width="100px">版本号</th><th width="100px">动作</th><th width="100px">修改人</th><th width="100px">修改时间</th>
 * </tr>
 * <!-- 以 Table 方式书写修改历史 -->
 * <tr>
 * <td>0.0.0</td><td>创建类</td><td>李德强</td><td>2014年9月3日 下午3:15:53</td>
 * </tr>
 * <tr>
 * <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td>
 * </tr>
 * </table>
 */
public class HisDiagnosis {
	private String patient_id ;//患者标识
	private String times ;//就诊次数
	private String sn; //表标识
	private String diagStr;//诊断名称
	private String diagCode ;//诊断编码
	private String doctorSn ;//医生编码
	private String deptSn ;//科室编码
	private String icdCode;//icd编码
	private String commentStr ;//注释
	private String mainFlag;//主诊断标识  Character
	private String uncertainFlag ;//待查标志 Character
	private String suspectedFlag ;//疑似标志 Character
	private String contagionFlag ;//传染病标志 Character
	private Date inputDate ;//输入日期
	private String lv1sortNo;//第一层顺序
	private String lv2sortNo;//第二层顺序
	
	public String getLv1sortNo() {
		return lv1sortNo;
	}

	public void setLv1sortNo(String lv1sortNo) {
		this.lv1sortNo = lv1sortNo;
	}

	public String getLv2sortNo() {
		return lv2sortNo;
	}

	public void setLv2sortNo(String lv2sortNo) {
		this.lv2sortNo = lv2sortNo;
	}

	public String getSuspectedFlag() {
		return suspectedFlag;
	}

	public void setSuspectedFlag(String suspectedFlag) {
		this.suspectedFlag = suspectedFlag;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getDiagCode() {
		return diagCode;
	}

	public void setDiagCode(String diagCode) {
		this.diagCode = diagCode;
	}

	public String getDoctorSn() {
		return doctorSn;
	}

	public void setDoctorSn(String doctorSn) {
		this.doctorSn = doctorSn;
	}

	public String getDeptSn() {
		return deptSn;
	}

	public void setDeptSn(String deptSn) {
		this.deptSn = deptSn;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getCommentStr() {
		return commentStr;
	}

	public void setCommentStr(String commentStr) {
		this.commentStr = commentStr;
	}

	public String getMainFlag() {
		return mainFlag;
	}

	public void setMainFlag(String mainFlag) {
		this.mainFlag = mainFlag;
	}

	public String getUncertainFlag() {
		return uncertainFlag;
	}

	public void setUncertainFlag(String uncertainFlag) {
		this.uncertainFlag = uncertainFlag;
	}

	public String getContagionFlag() {
		return contagionFlag;
	}

	public void setContagionFlag(String contagionFlag) {
		this.contagionFlag = contagionFlag;
	}

	public Date getInputDate() {
		return inputDate;
	}

	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}

	public String getDiagStr() {
		return diagStr;
	}

	public void setDiagStr(String diagStr) {
		this.diagStr = diagStr;
	}

	/**
	 * 构造器 
	 */
	public HisDiagnosis() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * FIXME 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
