package pkuhit.org.dao.auto.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = EiNisWardConfigListener.class)
@Table(name = "EI_NIS_WARD_CONFIG")
public class EiNisWardConfig {

    /** 科室编号 */
    @Id
    @Column(name = "NIS_WARD_CD")
    String nisWardCd;
    
    @Column(name = "DEPT_SN")
    String deptSn;

    /** 病区编号 */
    @Column(name = "WARD_SN")
    String wardSn;

    /** 病区名称 */
    @Column(name = "WARD_NM")
    String wardNm;

    /** */
    @Column(name = "ORDER_START_TIME")
    String orderStartTime;

    /** */
    @Column(name = "ORDER_DAYS")
    String orderDays;

    /** */
    @Column(name = "KF_START_TIME")
    String kfStartTime;

    /** */
    @Column(name = "KF_DAYS")
    String kfDays;

    /** */
    @Column(name = "FKF_START_TIME")
    String fkfStartTime;

    /** */
    @Column(name = "FKF_DAYS")
    String fkfDays;

    /** */
    @Column(name = "FEE_ORDER_SN")
    String feeOrderSn;

    /** */
    @Column(name = "BASE_GROUP")
    String baseGroup;

    /** */
    @Column(name = "WZ_GROUP_LIST")
    String wzGroupList;

    /** */
    @Column(name = "INFUSION_FLAG")
    String infusionFlag;

    /** */
    @Column(name = "IP_LIST")
    String ipList;

    /** */
    @Column(name = "ENABLE_FLAG")
    String enableFlag;

    /** */
    @Column(name = "OWE_LIMIT")
    String oweLimit;

    /** */
    @Column(name = "LONG_ORDER_WIDTH")
    BigInteger longOrderWidth;

    /** */
    @Column(name = "ONCE_ORDER_WIDTH")
    BigInteger onceOrderWidth;

    /** */
    @Column(name = "AUTO_BUILD")
    String autoBuild;

    /** */
    @Column(name = "INFUSION_FLAG2")
    String infusionFlag2;

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
     * Returns the deptSn.
     * 
     * @return the deptSn
     */
    public String getDeptSn() {
        return deptSn;
    }

    /** 
     * Sets the deptSn.
     * 
     * @param deptSn the deptSn
     */
    public void setDeptSn(String deptSn) {
        this.deptSn = deptSn;
    }

    /** 
     * Returns the wardSn.
     * 
     * @return the wardSn
     */
    public String getWardSn() {
        return wardSn;
    }

    /** 
     * Sets the wardSn.
     * 
     * @param wardSn the wardSn
     */
    public void setWardSn(String wardSn) {
        this.wardSn = wardSn;
    }

    /** 
     * Returns the wardNm.
     * 
     * @return the wardNm
     */
    public String getWardNm() {
        return wardNm;
    }

    /** 
     * Sets the wardNm.
     * 
     * @param wardNm the wardNm
     */
    public void setWardNm(String wardNm) {
        this.wardNm = wardNm;
    }

    /** 
     * Returns the orderStartTime.
     * 
     * @return the orderStartTime
     */
    public String getOrderStartTime() {
        return orderStartTime;
    }

    /** 
     * Sets the orderStartTime.
     * 
     * @param orderStartTime the orderStartTime
     */
    public void setOrderStartTime(String orderStartTime) {
        this.orderStartTime = orderStartTime;
    }

    /** 
     * Returns the orderDays.
     * 
     * @return the orderDays
     */
    public String getOrderDays() {
        return orderDays;
    }

    /** 
     * Sets the orderDays.
     * 
     * @param orderDays the orderDays
     */
    public void setOrderDays(String orderDays) {
        this.orderDays = orderDays;
    }

    /** 
     * Returns the kfStartTime.
     * 
     * @return the kfStartTime
     */
    public String getKfStartTime() {
        return kfStartTime;
    }

    /** 
     * Sets the kfStartTime.
     * 
     * @param kfStartTime the kfStartTime
     */
    public void setKfStartTime(String kfStartTime) {
        this.kfStartTime = kfStartTime;
    }

    /** 
     * Returns the kfDays.
     * 
     * @return the kfDays
     */
    public String getKfDays() {
        return kfDays;
    }

    /** 
     * Sets the kfDays.
     * 
     * @param kfDays the kfDays
     */
    public void setKfDays(String kfDays) {
        this.kfDays = kfDays;
    }

    /** 
     * Returns the fkfStartTime.
     * 
     * @return the fkfStartTime
     */
    public String getFkfStartTime() {
        return fkfStartTime;
    }

    /** 
     * Sets the fkfStartTime.
     * 
     * @param fkfStartTime the fkfStartTime
     */
    public void setFkfStartTime(String fkfStartTime) {
        this.fkfStartTime = fkfStartTime;
    }

    /** 
     * Returns the fkfDays.
     * 
     * @return the fkfDays
     */
    public String getFkfDays() {
        return fkfDays;
    }

    /** 
     * Sets the fkfDays.
     * 
     * @param fkfDays the fkfDays
     */
    public void setFkfDays(String fkfDays) {
        this.fkfDays = fkfDays;
    }

    /** 
     * Returns the feeOrderSn.
     * 
     * @return the feeOrderSn
     */
    public String getFeeOrderSn() {
        return feeOrderSn;
    }

    /** 
     * Sets the feeOrderSn.
     * 
     * @param feeOrderSn the feeOrderSn
     */
    public void setFeeOrderSn(String feeOrderSn) {
        this.feeOrderSn = feeOrderSn;
    }

    /** 
     * Returns the baseGroup.
     * 
     * @return the baseGroup
     */
    public String getBaseGroup() {
        return baseGroup;
    }

    /** 
     * Sets the baseGroup.
     * 
     * @param baseGroup the baseGroup
     */
    public void setBaseGroup(String baseGroup) {
        this.baseGroup = baseGroup;
    }

    /** 
     * Returns the wzGroupList.
     * 
     * @return the wzGroupList
     */
    public String getWzGroupList() {
        return wzGroupList;
    }

    /** 
     * Sets the wzGroupList.
     * 
     * @param wzGroupList the wzGroupList
     */
    public void setWzGroupList(String wzGroupList) {
        this.wzGroupList = wzGroupList;
    }

    /** 
     * Returns the infusionFlag.
     * 
     * @return the infusionFlag
     */
    public String getInfusionFlag() {
        return infusionFlag;
    }

    /** 
     * Sets the infusionFlag.
     * 
     * @param infusionFlag the infusionFlag
     */
    public void setInfusionFlag(String infusionFlag) {
        this.infusionFlag = infusionFlag;
    }

    /** 
     * Returns the ipList.
     * 
     * @return the ipList
     */
    public String getIpList() {
        return ipList;
    }

    /** 
     * Sets the ipList.
     * 
     * @param ipList the ipList
     */
    public void setIpList(String ipList) {
        this.ipList = ipList;
    }

    /** 
     * Returns the enableFlag.
     * 
     * @return the enableFlag
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /** 
     * Sets the enableFlag.
     * 
     * @param enableFlag the enableFlag
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag;
    }

    /** 
     * Returns the oweLimit.
     * 
     * @return the oweLimit
     */
    public String getOweLimit() {
        return oweLimit;
    }

    /** 
     * Sets the oweLimit.
     * 
     * @param oweLimit the oweLimit
     */
    public void setOweLimit(String oweLimit) {
        this.oweLimit = oweLimit;
    }

    /** 
     * Returns the longOrderWidth.
     * 
     * @return the longOrderWidth
     */
    public BigInteger getLongOrderWidth() {
        return longOrderWidth;
    }

    /** 
     * Sets the longOrderWidth.
     * 
     * @param longOrderWidth the longOrderWidth
     */
    public void setLongOrderWidth(BigInteger longOrderWidth) {
        this.longOrderWidth = longOrderWidth;
    }

    /** 
     * Returns the onceOrderWidth.
     * 
     * @return the onceOrderWidth
     */
    public BigInteger getOnceOrderWidth() {
        return onceOrderWidth;
    }

    /** 
     * Sets the onceOrderWidth.
     * 
     * @param onceOrderWidth the onceOrderWidth
     */
    public void setOnceOrderWidth(BigInteger onceOrderWidth) {
        this.onceOrderWidth = onceOrderWidth;
    }

    /** 
     * Returns the autoBuild.
     * 
     * @return the autoBuild
     */
    public String getAutoBuild() {
        return autoBuild;
    }

    /** 
     * Sets the autoBuild.
     * 
     * @param autoBuild the autoBuild
     */
    public void setAutoBuild(String autoBuild) {
        this.autoBuild = autoBuild;
    }

    /** 
     * Returns the infusionFlag2.
     * 
     * @return the infusionFlag2
     */
    public String getInfusionFlag2() {
        return infusionFlag2;
    }

    /** 
     * Sets the infusionFlag2.
     * 
     * @param infusionFlag2 the infusionFlag2
     */
    public void setInfusionFlag2(String infusionFlag2) {
        this.infusionFlag2 = infusionFlag2;
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

	public String getNisWardCd() {
		return nisWardCd;
	}

	public void setNisWardCd(String nisWardCd) {
		this.nisWardCd = nisWardCd;
	}

	
}