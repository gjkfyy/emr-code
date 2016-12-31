package iih.kr.db.cs.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;

/**
 * 诊断字典
 */
@Entity()
public class MdDiSimpleEntity {

    /** 诊断编码 */
    @Id
    @Column(name = "DI_CD")
    String diCd;

    /** 名称 */
    @Column(name = "NM")
    String diNm;

    /** ICD编码 */
    @Column(name = "ICD_CD")
    String icdCd;


    /** 
     * Returns the diCd.
     * 
     * @return the diCd
     */
    public String getDiCd() {
        return diCd;
    }

    /** 
     * Sets the diCd.
     * 
     * @param diCd the diCd
     */
    public void setDiCd(String diCd) {
        this.diCd = diCd;
    }

  

  
    public String getDiNm() {
		return diNm;
	}

	public void setDiNm(String diNm) {
		this.diNm = diNm;
	}

	/** 
     * Returns the icdCd.
     * 
     * @return the icdCd
     */
    public String getIcdCd() {
        return icdCd;
    }

    /** 
     * Sets the icdCd.
     * 
     * @param icdCd the icdCd
     */
    public void setIcdCd(String icdCd) {
        this.icdCd = icdCd;
    }

   
}