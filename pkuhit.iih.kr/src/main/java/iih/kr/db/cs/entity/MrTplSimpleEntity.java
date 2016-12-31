package iih.kr.db.cs.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

/**
 * 病历模板
 */
@Entity()
public class MrTplSimpleEntity {

    /** 主键 */
    @Id
    @Column(name = "MR_TPL_CD")
    String mrTplCd;
    
    /** 病历文书类型 */
    @Id
    @Column(name = "MR_TP_CD")
    String mrTpCd;
    
    /** 文件编码 */
    @Column(name = "FILE_PK")
    String filePk;
    
    /** 名称 */
    @Column(name = "NM")
    String nm;

	public String getMrTplCd() {
		return mrTplCd;
	}

	public void setMrTplCd(String mrTplCd) {
		this.mrTplCd = mrTplCd;
	}

	public String getNm() {
		return nm;
	}

	public void setNm(String nm) {
		this.nm = nm;
	}

	public String getMrTpCd() {
		return mrTpCd;
	}

	public void setMrTpCd(String mrTpCd) {
		this.mrTpCd = mrTpCd;
	}

	public String getFilePk() {
		return filePk;
	}

	public void setFilePk(String filePk) {
		this.filePk = filePk;
	}

}