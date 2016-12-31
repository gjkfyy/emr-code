
package pkuhit.iih.mr.wr;

import xap.sv.annotation.Column;
import java.util.Date;
/**
 * <p>签病历文书</p>
 * 
 * @author 李春学(li_chunxue@founder.com)
 * @version 0.0.0 <table style="border:1px solid gray;"> <tr> <th
 *          width="100px">版本号</th><th width="100px">动作</th><th
 *          width="100px">修改人</th><th width="100px">修改时间</th> </tr> <!-- 以 Table
 *          方式书写修改历史 --> <tr>
 *          <td>0.0.0</td><td>创建类</td><td>李春学</td><td>2014年12月4日 下午1:39:03</td>
 *          </tr> <tr> <td>XXX</td><td>XXX</td><td>XXX</td><td>XXX</td> </tr>
 *          </table>
 */
public class SignMr extends MedicalRecord {

	public SignMr() {

		super();

	}

	public SignMr(String code) {

		super(code);

	}

	// 床位
	@Column(name = "CUR_BED_CD")
	private String bedNo;

	// 姓名
    @Column(name = "PA_ID")
    private String patientId;
    
	// 姓名
	@Column(name = "PA_NM")
	private String patientName;

	// 性别代码
	@Column(name = "SEX_CD")
	private String sexCode;

	// 性别名称
	@Column(name = "SEXNAME")
	private String sexName;
	
	// 性别名称
	@Column(name = "SIGNLVLNM")
	private String signLvlNm;
	
    // 文书状态名称
    @Column(name = "MR_STA_NM")
    private String stateName;
    
    // 文书状态名称
    @Column(name = "DOCTOR_DATE")
    private Date doctorDate;
    
	public String getPatientId()
    {
        return patientId;
    }

    public void setPatientId(String patientId)
    {
        this.patientId = patientId;
    }

    public Date getDoctorDate()
    {
        return doctorDate;
    }

    public void setDoctorDate(Date doctorDate)
    {
        this.doctorDate = doctorDate;
    }

    public String getSubmitCd()
    {
        return submitCd;
    }

    public void setSubmitCd(String submitCd)
    {
        this.submitCd = submitCd;
    }

    public String getStateName()
    {
        return stateName;
    }

    public void setStateName(String stateName)
    {
        this.stateName = stateName;
    }

    public String getBedNo() {

		return bedNo;
	}

	public void setBedNo(String bedNo) {

		this.bedNo = bedNo;
	}

	public String getPatientName() {

		return patientName;
	}

	public void setPatientName(String patientName) {

		this.patientName = patientName;
	}

	public String getSexCode() {

		return sexCode;
	}

	public void setSexCode(String sexCode) {

		this.sexCode = sexCode;
	}

	public String getSexName() {

		return sexName;
	}

	public void setSexName(String sexName) {

		this.sexName = sexName;
	}

	
	public String getSignLvlNm() {
	
		return signLvlNm;
	}

	
	public void setSignLvlNm(String signLvlNm) {
	
		this.signLvlNm = signLvlNm;
	}
	
}
