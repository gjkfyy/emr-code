package pkuhit.iih.mr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Clob;
import java.sql.Timestamp;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = MrParaListener.class)
@Table(name = "MR_PARA")
public class MrPara {

    /** 段落内容主键 */
    @Id
    @Column(name = "PARA_PK")
    String paraPk;

    /** 患者ID */
    @Column(name = "PA_ID")
    String paId;

    /** 就诊序号 */
    @Column(name = "EN_PK")
    String enPk;

    /** 病历编码 */
    @Column(name = "MR_PK")
    String mrPk;

    /** 模板编码 */
    @Column(name = "MR_TPL_CD")
    String mrTplCd;

    /** 病历类型编码 */
    @Column(name = "MR_TP_CD")
    String mrTpCd;

    /** 段落编码 */
    @Column(name = "PARA_CD")
    String paraCd;

    /** 段落名称 */
    @Column(name = "PARA_NM")
    String paraNm;

    /** 段落内容 */
    @Column(name = "PARA_CONTENT")
    Clob paraContent;

    /** 备注 */
    @Column(name = "MEMO")
    String memo;

    /** 排序码 */
    @Column(name = "SORT_NO")
    String sortNo;

    /** 拼音码 */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** 五笔码 */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** 修改次数 */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** 创建时间 */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** 创建人id */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** 创建科室编码 */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** 最后修改时间 */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** 最后修改科室 */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** 最后修改人id */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** 删除标识 */
    @Column(name = "DEL_F")
    Short delF;

    public Clob getParaContent() {
		return paraContent;
	}

	public void setParaContent(Clob paraContent) {
		this.paraContent = paraContent;
	}

	/** 
     * Returns the paraPk.
     * 
     * @return the paraPk
     */
    public String getParaPk() {
        return paraPk;
    }

    /** 
     * Sets the paraPk.
     * 
     * @param paraPk the paraPk
     */
    public void setParaPk(String paraPk) {
        this.paraPk = paraPk;
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
     * Returns the mrPk.
     * 
     * @return the mrPk
     */
    public String getMrPk() {
        return mrPk;
    }

    /** 
     * Sets the mrPk.
     * 
     * @param mrPk the mrPk
     */
    public void setMrPk(String mrPk) {
        this.mrPk = mrPk;
    }

    /** 
     * Returns the mrTplCd.
     * 
     * @return the mrTplCd
     */
    public String getMrTplCd() {
        return mrTplCd;
    }

    /** 
     * Sets the mrTplCd.
     * 
     * @param mrTplCd the mrTplCd
     */
    public void setMrTplCd(String mrTplCd) {
        this.mrTplCd = mrTplCd;
    }

    /** 
     * Returns the mrTpCd.
     * 
     * @return the mrTpCd
     */
    public String getMrTpCd() {
        return mrTpCd;
    }

    /** 
     * Sets the mrTpCd.
     * 
     * @param mrTpCd the mrTpCd
     */
    public void setMrTpCd(String mrTpCd) {
        this.mrTpCd = mrTpCd;
    }

    /** 
     * Returns the paraCd.
     * 
     * @return the paraCd
     */
    public String getParaCd() {
        return paraCd;
    }

    /** 
     * Sets the paraCd.
     * 
     * @param paraCd the paraCd
     */
    public void setParaCd(String paraCd) {
        this.paraCd = paraCd;
    }

    /** 
     * Returns the paraNm.
     * 
     * @return the paraNm
     */
    public String getParaNm() {
        return paraNm;
    }

    /** 
     * Sets the paraNm.
     * 
     * @param paraNm the paraNm
     */
    public void setParaNm(String paraNm) {
        this.paraNm = paraNm;
    }

    
    /** 
     * Returns the memo.
     * 
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /** 
     * Sets the memo.
     * 
     * @param memo the memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /** 
     * Returns the sortNo.
     * 
     * @return the sortNo
     */
    public String getSortNo() {
        return sortNo;
    }

    /** 
     * Sets the sortNo.
     * 
     * @param sortNo the sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo;
    }

    /** 
     * Returns the spellNo.
     * 
     * @return the spellNo
     */
    public String getSpellNo() {
        return spellNo;
    }

    /** 
     * Sets the spellNo.
     * 
     * @param spellNo the spellNo
     */
    public void setSpellNo(String spellNo) {
        this.spellNo = spellNo;
    }

    /** 
     * Returns the wubiNo.
     * 
     * @return the wubiNo
     */
    public String getWubiNo() {
        return wubiNo;
    }

    /** 
     * Sets the wubiNo.
     * 
     * @param wubiNo the wubiNo
     */
    public void setWubiNo(String wubiNo) {
        this.wubiNo = wubiNo;
    }

    /** 
     * Returns the updCnt.
     * 
     * @return the updCnt
     */
    public BigInteger getUpdCnt() {
        return updCnt;
    }

    /** 
     * Sets the updCnt.
     * 
     * @param updCnt the updCnt
     */
    public void setUpdCnt(BigInteger updCnt) {
        this.updCnt = updCnt;
    }

    /** 
     * Returns the crtTime.
     * 
     * @return the crtTime
     */
    public Timestamp getCrtTime() {
        return crtTime;
    }

    /** 
     * Sets the crtTime.
     * 
     * @param crtTime the crtTime
     */
    public void setCrtTime(Timestamp crtTime) {
        this.crtTime = crtTime;
    }

    /** 
     * Returns the crtUserId.
     * 
     * @return the crtUserId
     */
    public String getCrtUserId() {
        return crtUserId;
    }

    /** 
     * Sets the crtUserId.
     * 
     * @param crtUserId the crtUserId
     */
    public void setCrtUserId(String crtUserId) {
        this.crtUserId = crtUserId;
    }

    /** 
     * Returns the crtDeptCd.
     * 
     * @return the crtDeptCd
     */
    public String getCrtDeptCd() {
        return crtDeptCd;
    }

    /** 
     * Sets the crtDeptCd.
     * 
     * @param crtDeptCd the crtDeptCd
     */
    public void setCrtDeptCd(String crtDeptCd) {
        this.crtDeptCd = crtDeptCd;
    }

    /** 
     * Returns the lastUpdTime.
     * 
     * @return the lastUpdTime
     */
    public Timestamp getLastUpdTime() {
        return lastUpdTime;
    }

    /** 
     * Sets the lastUpdTime.
     * 
     * @param lastUpdTime the lastUpdTime
     */
    public void setLastUpdTime(Timestamp lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    /** 
     * Returns the lastUpdDeptCd.
     * 
     * @return the lastUpdDeptCd
     */
    public String getLastUpdDeptCd() {
        return lastUpdDeptCd;
    }

    /** 
     * Sets the lastUpdDeptCd.
     * 
     * @param lastUpdDeptCd the lastUpdDeptCd
     */
    public void setLastUpdDeptCd(String lastUpdDeptCd) {
        this.lastUpdDeptCd = lastUpdDeptCd;
    }

    /** 
     * Returns the lastUpdUserId.
     * 
     * @return the lastUpdUserId
     */
    public String getLastUpdUserId() {
        return lastUpdUserId;
    }

    /** 
     * Sets the lastUpdUserId.
     * 
     * @param lastUpdUserId the lastUpdUserId
     */
    public void setLastUpdUserId(String lastUpdUserId) {
        this.lastUpdUserId = lastUpdUserId;
    }

    /** 
     * Returns the delF.
     * 
     * @return the delF
     */
    public Short getDelF() {
        return delF;
    }

    /** 
     * Sets the delF.
     * 
     * @param delF the delF
     */
    public void setDelF(Short delF) {
        this.delF = delF;
    }
}