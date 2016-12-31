package iih.dr.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = IemrRetrievalCondListener.class)
@Table(name = "IEMR_RETRIEVAL_COND")
public class IemrRetrievalCond {

    /** */
    @Id
    @Column(name = "COND_CD")
    String condCd;

    /** */
    @Column(name = "RETRIEVAL_CD")
    String retrievalCd;

    /** */
    @Column(name = "COND_NAME")
    String condName;

    /** 01-并且，02-或者 */
    @Column(name = "REL_TYPE")
    String relType;

    /** 01-简单条件、02-组合条件、03-表达式 */
    @Column(name = "COND_TYPE")
    String condType;

    /** xml表达式，可以存储病历文书类型、节点信息（如关联的数据源、节点类型等）等数据 */
    @Column(name = "OBJ_CODE")
    String objCode;

    /** */
    @Column(name = "OBJ_NAME")
    String objName;

    /** >、<、=等 */
    @Column(name = "LOGIC")
    String logic;

    /** 约束对象 */
    @Column(name = "VAL_NAME")
    String valName;

    /** 约束值域 */
    @Column(name = "VAL_CODE")
    String valCode;

    /** 条件级次 */
    @Column(name = "GRADE")
    Short grade;

    /** 上级条件 */
    @Column(name = "UPCOND")
    String upcond;

    /** 按照节点层次描述 */
    @Column(name = "FULL_PATH")
    String fullPath;

    /** */
    @Column(name = "DES")
    String des;

    /** */
    @Column(name = "COND_NO")
    Short condNo;

    /** */
    @Column(name = "MEMO")
    String memo;

    /** */
    @Column(name = "SORT_NO")
    String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    String crtUserId;

    /** */
    @Column(name = "CRT_DEPT_CD")
    String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD")
    String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    String lastUpdUserId;

    /** */
    @Column(name = "DEL_F")
    Short delF;

    /** 
     * Returns the condCd.
     * 
     * @return the condCd
     */
    public String getCondCd() {
        return condCd;
    }

    /** 
     * Sets the condCd.
     * 
     * @param condCd the condCd
     */
    public void setCondCd(String condCd) {
        this.condCd = condCd;
    }

    /** 
     * Returns the retrievalCd.
     * 
     * @return the retrievalCd
     */
    public String getRetrievalCd() {
        return retrievalCd;
    }

    /** 
     * Sets the retrievalCd.
     * 
     * @param retrievalCd the retrievalCd
     */
    public void setRetrievalCd(String retrievalCd) {
        this.retrievalCd = retrievalCd;
    }

    /** 
     * Returns the condName.
     * 
     * @return the condName
     */
    public String getCondName() {
        return condName;
    }

    /** 
     * Sets the condName.
     * 
     * @param condName the condName
     */
    public void setCondName(String condName) {
        this.condName = condName;
    }

    /** 
     * Returns the relType.
     * 
     * @return the relType
     */
    public String getRelType() {
        return relType;
    }

    /** 
     * Sets the relType.
     * 
     * @param relType the relType
     */
    public void setRelType(String relType) {
        this.relType = relType;
    }

    /** 
     * Returns the condType.
     * 
     * @return the condType
     */
    public String getCondType() {
        return condType;
    }

    /** 
     * Sets the condType.
     * 
     * @param condType the condType
     */
    public void setCondType(String condType) {
        this.condType = condType;
    }

    /** 
     * Returns the objCode.
     * 
     * @return the objCode
     */
    public String getObjCode() {
        return objCode;
    }

    /** 
     * Sets the objCode.
     * 
     * @param objCode the objCode
     */
    public void setObjCode(String objCode) {
        this.objCode = objCode;
    }

    /** 
     * Returns the objName.
     * 
     * @return the objName
     */
    public String getObjName() {
        return objName;
    }

    /** 
     * Sets the objName.
     * 
     * @param objName the objName
     */
    public void setObjName(String objName) {
        this.objName = objName;
    }

    /** 
     * Returns the logic.
     * 
     * @return the logic
     */
    public String getLogic() {
        return logic;
    }

    /** 
     * Sets the logic.
     * 
     * @param logic the logic
     */
    public void setLogic(String logic) {
        this.logic = logic;
    }

    /** 
     * Returns the valName.
     * 
     * @return the valName
     */
    public String getValName() {
        return valName;
    }

    /** 
     * Sets the valName.
     * 
     * @param valName the valName
     */
    public void setValName(String valName) {
        this.valName = valName;
    }

    /** 
     * Returns the valCode.
     * 
     * @return the valCode
     */
    public String getValCode() {
        return valCode;
    }

    /** 
     * Sets the valCode.
     * 
     * @param valCode the valCode
     */
    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    /** 
     * Returns the grade.
     * 
     * @return the grade
     */
    public Short getGrade() {
        return grade;
    }

    /** 
     * Sets the grade.
     * 
     * @param grade the grade
     */
    public void setGrade(Short grade) {
        this.grade = grade;
    }

    /** 
     * Returns the upcond.
     * 
     * @return the upcond
     */
    public String getUpcond() {
        return upcond;
    }

    /** 
     * Sets the upcond.
     * 
     * @param upcond the upcond
     */
    public void setUpcond(String upcond) {
        this.upcond = upcond;
    }

    /** 
     * Returns the fullPath.
     * 
     * @return the fullPath
     */
    public String getFullPath() {
        return fullPath;
    }

    /** 
     * Sets the fullPath.
     * 
     * @param fullPath the fullPath
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    /** 
     * Returns the des.
     * 
     * @return the des
     */
    public String getDes() {
        return des;
    }

    /** 
     * Sets the des.
     * 
     * @param des the des
     */
    public void setDes(String des) {
        this.des = des;
    }

    /** 
     * Returns the condNo.
     * 
     * @return the condNo
     */
    public Short getCondNo() {
        return condNo;
    }

    /** 
     * Sets the condNo.
     * 
     * @param condNo the condNo
     */
    public void setCondNo(Short condNo) {
        this.condNo = condNo;
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