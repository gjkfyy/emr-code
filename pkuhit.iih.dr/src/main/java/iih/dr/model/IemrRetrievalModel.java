package iih.dr.model;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;

public class IemrRetrievalModel extends BaseBizModel{

	public IemrRetrievalModel(){
		 super();
	}

	public IemrRetrievalModel(String code){
		 super(code);
	}
	 
	 public static final String   OBJ_CD  = "DRM01";
	 
    @Column(name = "RETRIEVAL_CD")
    private String retrievalCd;

    @Column(name = "RETRIEVAL_NM")
    private String retrievalNm;

    /** 全院、科室 */
    @Column(name = "OWN_TP_CD")
    private String ownTpCd;
    
    /** 所属名称*/
    @DictionaryTag(code = "ownTpCd", objCd = "MDM12")
	private String ownTpNm;
    
    /** 用","分隔 */
    @Column(name = "DEPT_CD")
    private String deptCd;
    
    /** 科室名称*/
    @DictionaryTag(code = "deptCd", objCd = "ORGB01")
	private String deptNm;
    
    @Column(name = "RESPONSIBLE_CD")
    private String responsibleCd;
    
    /** 负责人名称*/
    @DictionaryTag(code = "responsibleCd", objCd = "ORGB04")
	private String responsibleNm;

    @Column(name = "RETRIEVAL_KEY")
    private String retrievalKey;

    @Column(name = "STATUS_F")
    private Short statusF;

    @Column(name = "MEMO")
    private String memo;

    public String getRetrievalCd() {
        return retrievalCd;
    }

    public void setRetrievalCd(String retrievalCd) {
        this.retrievalCd = retrievalCd;
    }

    public String getRetrievalNm() {
        return retrievalNm;
    }

    public void setRetrievalNm(String retrievalNm) {
        this.retrievalNm = retrievalNm;
    }

    public String getOwnTpCd() {
        return ownTpCd;
    }

    public void setOwnTpCd(String ownTpCd) {
        this.ownTpCd = ownTpCd;
    }

    public String getDeptCd() {
        return deptCd;
    }

    public void setDeptCd(String deptCd) {
        this.deptCd = deptCd;
    }

    public String getResponsibleCd() {
        return responsibleCd;
    }

    public void setResponsibleCd(String responsibleCd) {
        this.responsibleCd = responsibleCd;
    }

    public String getRetrievalKey() {
        return retrievalKey;
    }

    public void setRetrievalKey(String retrievalKey) {
        this.retrievalKey = retrievalKey;
    }

    public Short getStatusF() {
        return statusF;
    }

    public void setStatusF(Short statusF) {
        this.statusF = statusF;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getResponsibleNm() {
		return responsibleNm;
	}

	public void setResponsibleNm(String responsibleNm) {
		this.responsibleNm = responsibleNm;
	}

	public String getOwnTpNm() {
		return ownTpNm;
	}

	public void setOwnTpNm(String ownTpNm) {
		this.ownTpNm = ownTpNm;
	}

}