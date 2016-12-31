package pkuhit.iih.mr.wr;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IEMRWebService {
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
	 * @param 住院号、住院次数、文书类型编码、段落的name
	 * @return 纯文本内容（如果段落name为null，返回整个病历的纯文本）。
	 * @throws Throwable
	 */
	@WebMethod
	public String selectMrAreas(String paId,String encounterCount,String typeCodes,String names)throws IOException ;
	
	/**
	 * 
	 * 如果根据文书类型编码查询到的病历为多份，则取第一份的对应段落的值。
	 * @param 患者Id
	 * @return 纯文本内容
	 * @throws Throwable
	 */
	@WebMethod
	public String selectXmlOnEnPk(String enPk)throws IOException ;
	
	/**
     * 
     * 查询本次就诊的指定类型文书
     * @param enPk,mrTpCd
     * @return 文书列表
     */
    @WebMethod
    public List<Map<String, Object>> getMrByEnPkAndMrType(String enPk, String mrTpCd);
    
    /**
     * 
     * 查询医嘱所需的病历类型
     * @param orTpCd
     * @return 病历类型
     */
    @WebMethod
    public List<Map<String, Object>> getMrTypeByOrType(String orTpCd);
	
	@WebMethod
	public String selectMrTypeCodeList(String hospitalId,String hospitalId_DeptCode_EmpId);
	
	@WebMethod
	public String selectMrInfosList(String enc_ic,String pa_id,String times,
			String templateId);
	
	@WebMethod
	public String getMrXml(String enPk,String pa_id,String times,String ctrTime, String templateId, 
			String mrPk,String empId);
	
	@WebMethod
	public String saveMrXml(String enPk, String pa_id,String times,String ctrTime,String templateId, 
			String mrPk, String xmlData, String empId);
	
	@WebMethod
	public String deleteMr(String mrPk, String empId);
	
	/**
	 * @param patient_id病人ID，times就诊次数，visit_flag门诊住院体检类型可选的值(ZY：住院；MZ:门诊)
	 * @return 患者病历信息
	 */
	public String mrOrigFileList(String patientId,Integer times,String visitFlag);
}
