package pkuhit.iih.mr.tpl;

import java.math.BigInteger;
import java.sql.Timestamp;
import org.seasar.doma.Id;
import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class MrFrTemplate extends BaseMasterModel {

	public MrFrTemplate() {
		super();
	}

	public MrFrTemplate(String mrFrTplCd) {
		super(mrFrTplCd);
	}

	public static final String OBJ_CD = "MRK01";

	// 医疗记录基础模板编码
	public static final String MR_FR_TPL_CD = "MRK01.AT01";
	// 组织机构编码
	public static final String ORGANIZATION_CODE = "MRK01.AT02";
	// 文件主键
	public static final String FILE_PK = "MRK01.AT03";
	// 根医疗记录基础模板编码
	public static final String ROOT_CODE = "MRK01.AT04";
	// 版本号
	public static final String VERSION_NO = "MRK01.AT05";
	// 医疗记录基础模板状态编码
	public static final String STATUS = "MRK01.AT06";
	// 名称
	public static final String NM = "MRK01.AT07";
	// 描述
	public static final String MEMO = "MRK01.AT08";

	/** 主键 */
    @Id
    @Column(name = "MR_FR_TPL_CD")
    private String mrFrTplCd;

    /** 文件编码 */
    @Column(name = "FILE_PK")
    private String filePk;

    /** 名称 */
    @Column(name = "NM")
    private String nm;

    /** 状态，启用/停用 */
    @Column(name = "STATUS")
    private String status;
    
 // 医疗记录基础模板状态名称
 	@DictionaryTag(code = "status", objCd = "MRM06")
 	private String statusName;

    /** 类型，小模板/组合元素/片段模板 */
    @Column(name = "MR_FR_TPL_TP_CD")
    private String mrFrTplTpCd;
    
    
    @DictionaryTag(code = "mrFrTplTpCd", objCd = "MRM12")
    private String mrFrTplTpNm;

    /** */
    @Column(name = "MEMO")
    private String memo;

    /** */
    @Column(name = "SORT_NO")
    private String sortNo;

    /** */
    @Column(name = "SPELL_NO")
    private String spellNo;

    /** */
    @Column(name = "WUBI_NO")
    private String wubiNo;

    /** */
    @Column(name = "UPD_CNT")
    private BigInteger updCnt;

    /** */
    @Column(name = "CRT_TIME")
    private Timestamp crtTime;

    /** */
    @Column(name = "CRT_USER_ID")
    private String crtUserId;
    
 	// 创建人名称
 	@DictionaryTag(code = "crtUserId", objCd = "ORGB04")
 	private String crtUserName;

    /** */
    @Column(name = "CRT_DEPT_CD")
    private String crtDeptCd;

    /** */
    @Column(name = "LAST_UPD_TIME")
    private Timestamp lastUpdTime;

    /** */
    @Column(name = "LAST_UPD_DEPT_CD" )
    private String lastUpdDeptCd;

    /** */
    @Column(name = "LAST_UPD_USER_ID")
    private String lastUpdUserId;
    
    /** */
    @Column(name = "CONTENT_TEXT")
    private String contentText;
    
 // 创建人名称
  	@DictionaryTag(code = "lastUpdUserId", objCd = "ORGB04")
  	private String lastUpdUserName;

    /** */
    @Column(name = "DEL_F")
    private Short delF;
    
    // 文件数据
 	private  String odtFile;

	/** 
     * Returns the mrFrTplCd.
     * 
     * @return the mrFrTplCd
     */
    public String getMrFrTplCd() {
        return mrFrTplCd;
    }

    /** 
     * Sets the mrFrTplCd.
     * 
     * @param mrFrTplCd the mrFrTplCd
     */
    public void setMrFrTplCd(String mrFrTplCd) {
        this.mrFrTplCd = mrFrTplCd;
    }
    
    

    public String getMrFrTplTpNm() {
		return mrFrTplTpNm;
	}

	public void setMrFrTplTpNm(String mrFrTplTpNm) {
		this.mrFrTplTpNm = mrFrTplTpNm;
	}

	/** 
     * Returns the filePk.
     * 
     * @return the filePk
     */
    public String getFilePk() {
        return filePk;
    }

    /** 
     * Sets the filePk.
     * 
     * @param filePk the filePk
     */
    public void setFilePk(String filePk) {
        this.filePk = filePk;
    }

    /** 
     * Returns the nm.
     * 
     * @return the nm
     */
    public String getNm() {
        return nm;
    }

    /** 
     * Sets the nm.
     * 
     * @param nm the nm
     */
    public void setNm(String nm) {
        this.nm = nm;
    }

    /** 
     * Returns the status.
     * 
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /** 
     * Sets the status.
     * 
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 
     * Returns the mrFrTplTpCd.
     * 
     * @return the mrFrTplTpCd
     */
    public String getMrFrTplTpCd() {
        return mrFrTplTpCd;
    }

    /** 
     * Sets the mrFrTplTpCd.
     * 
     * @param mrFrTplTpCd the mrFrTplTpCd
     */
    public void setMrFrTplTpCd(String mrFrTplTpCd) {
        this.mrFrTplTpCd = mrFrTplTpCd;
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
     * Sets the contentText.
     * 
     * @param contentText the contentText
     */
    public String getContentText() {
		return contentText;
	}

    /** 
     * Returns the contentText.
     * 
     * @return the contentText
     */
	public void setContentText(String contentText) {
		this.contentText = contentText;
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

	public String getOdtFile() {
		return odtFile;
	}

	public void setOdtFile(String odtFile) {
		this.odtFile = odtFile;
	}
	
	//补充操作状态
	// 可删除标志
	private Integer canDelete;
	// 可停用标志
	private Integer canStop;
	// 可启用标志
	private Integer canActivated;
	// 可更新标志
	private Integer canUpdate;

	public Integer getCanDelete() {
		return canDelete;
	}

	public void setCanDelete(Integer canDelete) {
		this.canDelete = canDelete;
	}

	public Integer getCanStop() {
		return canStop;
	}

	public void setCanStop(Integer canStop) {
		this.canStop = canStop;
	}

	public Integer getCanActivated() {
		return canActivated;
	}

	public void setCanActivated(Integer canActivated) {
		this.canActivated = canActivated;
	}

	public Integer getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getCrtUserName() {
		return crtUserName;
	}

	public void setCrtUserName(String crtUserName) {
		this.crtUserName = crtUserName;
	}

	public String getLastUpdUserName() {
		return lastUpdUserName;
	}

	public void setLastUpdUserName(String lastUpdUserName) {
		this.lastUpdUserName = lastUpdUserName;
	}
	
	
}