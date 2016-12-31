package pkuhit.iih.mr.md;

import xap.sv.annotation.Column;

/**
 * 共享数据元素表
 */
public class MrShareElement {

    /** 共享元素编码 */
    @Column(name = "MR_SHARE_ELEMENT_CD")
    String mrShareElementCd;

    /** 名称 */
    @Column(name = "NM")
    String nm;

    /** 描述 */
    @Column(name = "DES")
    String des;

    /** 分类编码 */
    @Column(name = "CATEGORY")
    String category;

    /** 宏标识 */
    @Column(name = "MACRO_FLAG")
    String macroFlag;
    
    /** */
    @Column(name = "SPELL_NO")
    String spellNo;

    /** 
     * Returns the mrShareElementCd.
     * 
     * @return the mrShareElementCd
     */
    public String getMrShareElementCd() {
        return mrShareElementCd;
    }

    /** 
     * Sets the mrShareElementCd.
     * 
     * @param mrShareElementCd the mrShareElementCd
     */
    public void setMrShareElementCd(String mrShareElementCd) {
        this.mrShareElementCd = mrShareElementCd;
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
     * Returns the category.
     * 
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /** 
     * Sets the category.
     * 
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /** 
     * Returns the macroFlag.
     * 
     * @return the macroFlag
     */
    public String getMacroFlag() {
        return macroFlag;
    }

    /** 
     * Sets the macroFlag.
     * 
     * @param macroFlag the macroFlag
     */
    public void setMacroFlag(String macroFlag) {
        this.macroFlag = macroFlag;
    }

	
	public String getSpellNo() {
	
		return spellNo;
	}

	
	public void setSpellNo(String spellNo) {
	
		this.spellNo = spellNo;
	}

}