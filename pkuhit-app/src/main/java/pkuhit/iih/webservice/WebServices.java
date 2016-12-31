package pkuhit.iih.webservice;

import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * http://localhost:8081/xap/webservice/IEMRWebService?wsdl
 * */
@WebService
public interface WebServices {
	/**
	 * @param enPk pdfFlag odtFlag
	 * @return xml toString()
	 */
	public String getMrPdfList(String enPk,Boolean pdfFlag,Boolean odtFlag);
	/**根据患者Id和就诊次数查询患者病历
	 * @param paId ent pdfFlag odtFlag
	 * @return xml toString()
	 */
	public String getMrListByPaIdAndEnCnt(String paId,String ent,Boolean pdfFlag,Boolean odtFlag);
	/**
	 * @param enPk 修改
	 * @return 返回成功结果
	 */
	public String updMrPrintCount(String enPk);
	
	/**
	 * 
	 * 如果根据文书类型编码查询到的病历为多份，则取第一份的对应段落的值。
	 * @param 住院号、住院次数、文书类型编码、多个段落名
	 * @return 纯文本内容（如果段落name为null，返回整个病历的纯文本）。
	 * @throws Throwable
	 */
	public String selectMrAreas(String paId,String times,String typeCodes,String names)throws IOException ;
	/**
	 * 返回病历xml
	 * @param enPk
	 * @return xml
	 */
	public String selectMrsXml(String enPk)throws IOException ;
	
	/**
     * 返回相关病历是否存在
     * @param enPk,mrTpCd
     * @return 0-否,1-是
     */
    public String isExistMrOfEncounter(String enPk,String mrTpCd);
	
	/**
     * 返回相关病历是否完成
     * @param enPk,orTpCd
     * @return 0-否,1-是
     */
    public String isFinishMrOfOrder(String enPk, String orTpCd);
	/** 暂时未实现
	 * 返回该医院护理模板列表
	 * @param HospitalId 医院的id
	 * @param HospitalId 医院的id
	 * @return HospitalId_DeptCode_EmpId  需要获取的所属code,以_分割，医院，科室，个人

	public String selectMrTypeCodeList(String HospitalId,String HospitalId_DeptCode_EmpId)throws IOException ;	 */
	/**
	 * 根据enpk(enc_id)返回病历信息列表,创建及上次修改时间，不包含病历内容
	 * @param enc_ic   就诊主键
	 * @param pa_id    患者id
	 * @param times    住院次数
	 * @param templateId  病历模板的主键
	 * @return   病历列表  <enc_id>1</enc_id><templateId>2</templateId><mrList><mr></mr><mr></mr></mrList>
	 */
	public String selectMrInfosList(String enc_ic,String pa_id,String times,String templateId)throws IOException ;

	/**
	 * 获取enpk(enc_id)的该类型 特定时间的xml
	 * @param enc_ic   就诊主键
	 * @param pa_id    患者id
	 * @param times    住院次数
	 * @param ctrTime   创建时间 2016-08-16 15:13:47
	 * @param templateId  病历模板的主键
	 * @param mrPk      病历记录的主键
	 * @param empId    员工id
	 * @return   <enc_id>1</enc_id><templateId>2</templateId><mrList><mr></mr></mrList>
	 */
	public String getMrXml(String enPk,String pa_id,String times,String ctrTime,String templateId,String mrPk,String empId )throws IOException ;
	/**
	 * 保存enpk(enc_id)的该类型 特定时间的xml
	 * @param enc_ic   就诊主键
	 * @param pa_id    患者id
	 * @param times    住院次数
	 * @param ctrTime   创建时间 2016-08-16 15:13:47
	 * @param templateId  病历模板的主键
	 * @param mrPk      病历记录的主键
	 * @param xmlData  病历xml数据
	 * @param empId    员工id
	 * @return 操作成功success,失败原因
	 */
	public String saveMrXml(String enPk,String pa_id,String times,String ctrTime,String templateId,String mrPk, String xmlData,String empId )throws IOException ;
	/**
	 * 删除病历
	 * @param mrPk 病历记录的主键
	 * @param empId    员工id
	 * @return 操作成功，失败原因
	 */
	public String deleteMr(String mrPk,String empId )throws IOException ;
	
	/**
	 * @param patient_id病人ID，times就诊次数，visit_flag门诊住院体检类型可选的值(ZY：住院；MZ:门诊)
	 * @return 患者病历信息
	 */
	public String NmrOrigFileList(String patientId,Integer times,String visitFlag);
}
