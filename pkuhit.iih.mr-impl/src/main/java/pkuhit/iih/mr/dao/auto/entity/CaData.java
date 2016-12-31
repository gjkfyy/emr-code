package pkuhit.iih.mr.dao.auto.entity;

import java.sql.Clob;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * ca数据
 */
@Entity(listener = CaDataListener.class)
@Table(name = "CA_DATA")
public class CaData {

    /** */
    @Id
    @Column(name = "CA_SN")
    String caSn;

    /** */
    @Column(name = "EMP_ID")
    String empId;

    /** */
    @Column(name = "EN_PK")
    String enPk;

    /** */
    @Column(name = "DATA_ID")
    String dataId;

    /** */
    @Column(name = "DATA_SN")
    String dataSn;

    /** */
    @Column(name = "DATA_XML")
    Clob dataXml;

    /** */
    @Column(name = "CERT_ID")
    String certId;

    /** */
    @Column(name = "CERT_VALUE")
    String certValue;

    /** */
    @Column(name = "CA_DATA")
    Clob caData;

    /** */
    @Column(name = "TS_DATA")
    Clob tsData;

    /** */
    @Column(name = "CREATE_TIME")
    Timestamp createTime;

    /** */
    @Column(name = "SYS_CODE")
    String sysCode;

    /** */
    @Column(name = "MODULE")
    String module;

    /** */
    @Column(name = "CA_STATE")
    String caState;

    /** 
     * Returns the caSn.
     * 
     * @return the caSn
     */
    public String getCaSn() {
        return caSn;
    }

    /** 
     * Sets the caSn.
     * 
     * @param caSn the caSn
     */
    public void setCaSn(String caSn) {
        this.caSn = caSn;
    }

    /** 
     * Returns the empId.
     * 
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /** 
     * Sets the empId.
     * 
     * @param empId the empId
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /** 
     * Returns the enPk.
     * 
     * @return the enPk
     */
    public String getEnPk() {
        return enPk;
    }

    /** 
     * Sets the enPk.
     * 
     * @param enPk the enPk
     */
    public void setEnPk(String enPk) {
        this.enPk = enPk;
    }

    /** 
     * Returns the dataId.
     * 
     * @return the dataId
     */
    public String getDataId() {
        return dataId;
    }

    /** 
     * Sets the dataId.
     * 
     * @param dataId the dataId
     */
    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    /** 
     * Returns the dataSn.
     * 
     * @return the dataSn
     */
    public String getDataSn() {
        return dataSn;
    }

    /** 
     * Sets the dataSn.
     * 
     * @param dataSn the dataSn
     */
    public void setDataSn(String dataSn) {
        this.dataSn = dataSn;
    }

    /** 
     * Returns the dataXml.
     * 
     * @return the dataXml
     */
    public Clob getDataXml() {
        return dataXml;
    }

    /** 
     * Sets the dataXml.
     * 
     * @param dataXml the dataXml
     */
    public void setDataXml(Clob dataXml) {
        this.dataXml = dataXml;
    }

    /** 
     * Returns the certId.
     * 
     * @return the certId
     */
    public String getCertId() {
        return certId;
    }

    /** 
     * Sets the certId.
     * 
     * @param certId the certId
     */
    public void setCertId(String certId) {
        this.certId = certId;
    }

    /** 
     * Returns the certValue.
     * 
     * @return the certValue
     */
    public String getCertValue() {
        return certValue;
    }

    /** 
     * Sets the certValue.
     * 
     * @param certValue the certValue
     */
    public void setCertValue(String certValue) {
        this.certValue = certValue;
    }

    /** 
     * Returns the caData.
     * 
     * @return the caData
     */
    public Clob getCaData() {
        return caData;
    }

    /** 
     * Sets the caData.
     * 
     * @param caData the caData
     */
    public void setCaData(Clob caData) {
        this.caData = caData;
    }

    /** 
     * Returns the tsData.
     * 
     * @return the tsData
     */
    public Clob getTsData() {
        return tsData;
    }

    /** 
     * Sets the tsData.
     * 
     * @param tsData the tsData
     */
    public void setTsData(Clob tsData) {
        this.tsData = tsData;
    }

    /** 
     * Returns the createTime.
     * 
     * @return the createTime
     */
    public Timestamp getCreateTime() {
        return createTime;
    }

    /** 
     * Sets the createTime.
     * 
     * @param createTime the createTime
     */
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    /** 
     * Returns the sysCode.
     * 
     * @return the sysCode
     */
    public String getSysCode() {
        return sysCode;
    }

    /** 
     * Sets the sysCode.
     * 
     * @param sysCode the sysCode
     */
    public void setSysCode(String sysCode) {
        this.sysCode = sysCode;
    }

    /** 
     * Returns the module.
     * 
     * @return the module
     */
    public String getModule() {
        return module;
    }

    /** 
     * Sets the module.
     * 
     * @param module the module
     */
    public void setModule(String module) {
        this.module = module;
    }

    /** 
     * Returns the caState.
     * 
     * @return the caState
     */
    public String getCaState() {
        return caState;
    }

    /** 
     * Sets the caState.
     * 
     * @param caState the caState
     */
    public void setCaState(String caState) {
        this.caState = caState;
    }
}