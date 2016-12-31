package pkuhit.iih.mr.dao.auto.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = ObsReportCollectEntityListener.class)
@Table(name = "OBS_REPORT_COLLECT")
public class ObsReportCollectEntity {

    /** 检查报告主键 */
    @Id
    @Column(name = "OB_RP_PK")
    String obRpPk;

    /** 就诊主键 */
    @Column(name = "EN_PK")
    String enPk;

    /** 患者ID */
    @Column(name = "PA_ID")
    String paId;

    /** 就诊次数 */
    @Column(name = "EN_CNT")
    String enCnt;

    /** 患者名称 */
    @Column(name = "PA_NM")
    String paNm;

    /** 检查报告状态编码 */
    @Column(name = "OB_RP_STA_CD")
    String obRpStaCd;

    /** 检查报告状态名称 */
    @Column(name = "OB_RP_STA_NM")
    String obRpStaNm;

    /** 检查报告单号 */
    @Column(name = "OB_RP_NO")
    String obRpNo;

    /** 检查报告单名称 */
    @Column(name = "OB_RP_NM")
    String obRpNm;

    /** 检查印象 */
    @Column(name = "OB_IMPR")
    String obImpr;

    /** 检查所见 */
    @Column(name = "OB_FNDG")
    String obFndg;

    /** 测量值 */
    @Column(name = "OB_VAL")
    String obVal;

    /** 结果正常标志 */
    @Column(name = "NORMAL_FLAG")
    String normalFlag;

    /** 检查项目编码 */
    @Column(name = "OB_ITM_CD")
    String obItmCd;

    /** 检查项目名称 */
    @Column(name = "OB_ITM_NM")
    String obItmNm;

    /** 执行时间 */
    @Column(name = "EXEC_TIME")
    String execTime;

    /** 执行医生ID */
    @Column(name = "EXEC_DCT_ID")
    String execDctId;

    /** 执行医生名称 */
    @Column(name = "EXEC_DCT_NM")
    String execDctNm;

    /** 执行科室编码 */
    @Column(name = "EXEC_DEPT_CD")
    String execDeptCd;

    /** 执行科室名称 */
    @Column(name = "EXEC_DEPT_NM")
    String execDeptNm;

    /** 发布人ID */
    @Column(name = "RLS_USER_ID")
    String rlsUserId;

    /** 发布人名称 */
    @Column(name = "RLS_USER_NM")
    String rlsUserNm;

    /** 发布时间 */
    @Column(name = "RLS_TIME")
    String rlsTime;

    /** 申请时间 */
    @Column(name = "RQS_TIME")
    String rqsTime;

    /** 申请医生ID */
    @Column(name = "RQS_DCT_ID")
    String rqsDctId;

    /** 申请医生名称 */
    @Column(name = "RQS_DCT_NM")
    String rqsDctNm;

    /** 检查诊断 */
    @Column(name = "OB_DI")
    String obDi;

    /** 建议 */
    @Column(name = "ADV")
    String adv;

    /** 
     * Returns the obRpPk.
     * 
     * @return the obRpPk
     */
    public String getObRpPk() {
        return obRpPk;
    }

    /** 
     * Sets the obRpPk.
     * 
     * @param obRpPk the obRpPk
     */
    public void setObRpPk(String obRpPk) {
        this.obRpPk = obRpPk;
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
     * Returns the paId.
     * 
     * @return the paId
     */
    public String getPaId() {
        return paId;
    }

    /** 
     * Sets the paId.
     * 
     * @param paId the paId
     */
    public void setPaId(String paId) {
        this.paId = paId;
    }

    /** 
     * Returns the enCnt.
     * 
     * @return the enCnt
     */
    public String getEnCnt() {
        return enCnt;
    }

    /** 
     * Sets the enCnt.
     * 
     * @param enCnt the enCnt
     */
    public void setEnCnt(String enCnt) {
        this.enCnt = enCnt;
    }

    /** 
     * Returns the paNm.
     * 
     * @return the paNm
     */
    public String getPaNm() {
        return paNm;
    }

    /** 
     * Sets the paNm.
     * 
     * @param paNm the paNm
     */
    public void setPaNm(String paNm) {
        this.paNm = paNm;
    }

    /** 
     * Returns the obRpStaCd.
     * 
     * @return the obRpStaCd
     */
    public String getObRpStaCd() {
        return obRpStaCd;
    }

    /** 
     * Sets the obRpStaCd.
     * 
     * @param obRpStaCd the obRpStaCd
     */
    public void setObRpStaCd(String obRpStaCd) {
        this.obRpStaCd = obRpStaCd;
    }

    /** 
     * Returns the obRpStaNm.
     * 
     * @return the obRpStaNm
     */
    public String getObRpStaNm() {
        return obRpStaNm;
    }

    /** 
     * Sets the obRpStaNm.
     * 
     * @param obRpStaNm the obRpStaNm
     */
    public void setObRpStaNm(String obRpStaNm) {
        this.obRpStaNm = obRpStaNm;
    }

    /** 
     * Returns the obRpNo.
     * 
     * @return the obRpNo
     */
    public String getObRpNo() {
        return obRpNo;
    }

    /** 
     * Sets the obRpNo.
     * 
     * @param obRpNo the obRpNo
     */
    public void setObRpNo(String obRpNo) {
        this.obRpNo = obRpNo;
    }

    /** 
     * Returns the obRpNm.
     * 
     * @return the obRpNm
     */
    public String getObRpNm() {
        return obRpNm;
    }

    /** 
     * Sets the obRpNm.
     * 
     * @param obRpNm the obRpNm
     */
    public void setObRpNm(String obRpNm) {
        this.obRpNm = obRpNm;
    }

    /** 
     * Returns the obImpr.
     * 
     * @return the obImpr
     */
    public String getObImpr() {
        return obImpr;
    }

    /** 
     * Sets the obImpr.
     * 
     * @param obImpr the obImpr
     */
    public void setObImpr(String obImpr) {
        this.obImpr = obImpr;
    }

    /** 
     * Returns the obFndg.
     * 
     * @return the obFndg
     */
    public String getObFndg() {
        return obFndg;
    }

    /** 
     * Sets the obFndg.
     * 
     * @param obFndg the obFndg
     */
    public void setObFndg(String obFndg) {
        this.obFndg = obFndg;
    }

    /** 
     * Returns the obVal.
     * 
     * @return the obVal
     */
    public String getObVal() {
        return obVal;
    }

    /** 
     * Sets the obVal.
     * 
     * @param obVal the obVal
     */
    public void setObVal(String obVal) {
        this.obVal = obVal;
    }

    /** 
     * Returns the normalFlag.
     * 
     * @return the normalFlag
     */
    public String getNormalFlag() {
        return normalFlag;
    }

    /** 
     * Sets the normalFlag.
     * 
     * @param normalFlag the normalFlag
     */
    public void setNormalFlag(String normalFlag) {
        this.normalFlag = normalFlag;
    }

    /** 
     * Returns the obItmCd.
     * 
     * @return the obItmCd
     */
    public String getObItmCd() {
        return obItmCd;
    }

    /** 
     * Sets the obItmCd.
     * 
     * @param obItmCd the obItmCd
     */
    public void setObItmCd(String obItmCd) {
        this.obItmCd = obItmCd;
    }

    /** 
     * Returns the obItmNm.
     * 
     * @return the obItmNm
     */
    public String getObItmNm() {
        return obItmNm;
    }

    /** 
     * Sets the obItmNm.
     * 
     * @param obItmNm the obItmNm
     */
    public void setObItmNm(String obItmNm) {
        this.obItmNm = obItmNm;
    }

    /** 
     * Returns the execTime.
     * 
     * @return the execTime
     */
    public String getExecTime() {
        return execTime;
    }

    /** 
     * Sets the execTime.
     * 
     * @param execTime the execTime
     */
    public void setExecTime(String execTime) {
        this.execTime = execTime;
    }

    /** 
     * Returns the execDctId.
     * 
     * @return the execDctId
     */
    public String getExecDctId() {
        return execDctId;
    }

    /** 
     * Sets the execDctId.
     * 
     * @param execDctId the execDctId
     */
    public void setExecDctId(String execDctId) {
        this.execDctId = execDctId;
    }

    /** 
     * Returns the execDctNm.
     * 
     * @return the execDctNm
     */
    public String getExecDctNm() {
        return execDctNm;
    }

    /** 
     * Sets the execDctNm.
     * 
     * @param execDctNm the execDctNm
     */
    public void setExecDctNm(String execDctNm) {
        this.execDctNm = execDctNm;
    }

    /** 
     * Returns the execDeptCd.
     * 
     * @return the execDeptCd
     */
    public String getExecDeptCd() {
        return execDeptCd;
    }

    /** 
     * Sets the execDeptCd.
     * 
     * @param execDeptCd the execDeptCd
     */
    public void setExecDeptCd(String execDeptCd) {
        this.execDeptCd = execDeptCd;
    }

    /** 
     * Returns the execDeptNm.
     * 
     * @return the execDeptNm
     */
    public String getExecDeptNm() {
        return execDeptNm;
    }

    /** 
     * Sets the execDeptNm.
     * 
     * @param execDeptNm the execDeptNm
     */
    public void setExecDeptNm(String execDeptNm) {
        this.execDeptNm = execDeptNm;
    }

    /** 
     * Returns the rlsUserId.
     * 
     * @return the rlsUserId
     */
    public String getRlsUserId() {
        return rlsUserId;
    }

    /** 
     * Sets the rlsUserId.
     * 
     * @param rlsUserId the rlsUserId
     */
    public void setRlsUserId(String rlsUserId) {
        this.rlsUserId = rlsUserId;
    }

    /** 
     * Returns the rlsUserNm.
     * 
     * @return the rlsUserNm
     */
    public String getRlsUserNm() {
        return rlsUserNm;
    }

    /** 
     * Sets the rlsUserNm.
     * 
     * @param rlsUserNm the rlsUserNm
     */
    public void setRlsUserNm(String rlsUserNm) {
        this.rlsUserNm = rlsUserNm;
    }

    /** 
     * Returns the rlsTime.
     * 
     * @return the rlsTime
     */
    public String getRlsTime() {
        return rlsTime;
    }

    /** 
     * Sets the rlsTime.
     * 
     * @param rlsTime the rlsTime
     */
    public void setRlsTime(String rlsTime) {
        this.rlsTime = rlsTime;
    }

    /** 
     * Returns the rqsTime.
     * 
     * @return the rqsTime
     */
    public String getRqsTime() {
        return rqsTime;
    }

    /** 
     * Sets the rqsTime.
     * 
     * @param rqsTime the rqsTime
     */
    public void setRqsTime(String rqsTime) {
        this.rqsTime = rqsTime;
    }

    /** 
     * Returns the rqsDctId.
     * 
     * @return the rqsDctId
     */
    public String getRqsDctId() {
        return rqsDctId;
    }

    /** 
     * Sets the rqsDctId.
     * 
     * @param rqsDctId the rqsDctId
     */
    public void setRqsDctId(String rqsDctId) {
        this.rqsDctId = rqsDctId;
    }

    /** 
     * Returns the rqsDctNm.
     * 
     * @return the rqsDctNm
     */
    public String getRqsDctNm() {
        return rqsDctNm;
    }

    /** 
     * Sets the rqsDctNm.
     * 
     * @param rqsDctNm the rqsDctNm
     */
    public void setRqsDctNm(String rqsDctNm) {
        this.rqsDctNm = rqsDctNm;
    }

    /** 
     * Returns the obDi.
     * 
     * @return the obDi
     */
    public String getObDi() {
        return obDi;
    }

    /** 
     * Sets the obDi.
     * 
     * @param obDi the obDi
     */
    public void setObDi(String obDi) {
        this.obDi = obDi;
    }

    /** 
     * Returns the adv.
     * 
     * @return the adv
     */
    public String getAdv() {
        return adv;
    }

    /** 
     * Sets the adv.
     * 
     * @param adv the adv
     */
    public void setAdv(String adv) {
        this.adv = adv;
    }
}