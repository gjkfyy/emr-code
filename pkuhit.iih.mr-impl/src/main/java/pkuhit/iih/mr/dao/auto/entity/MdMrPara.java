package pkuhit.iih.mr.dao.auto.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病历文书段落字典
 */
@Entity(listener = MdMrParaListener.class)
@Table(name = "MD_MR_PARA")
public class MdMrPara {

    /** 病历文书段落编码 */
    @Id
    @Column(name = "MD_MR_PARA_CD")
    String mdMrParaCd;

    /** 病历文书段落名称 */
    @Column(name = "NM")
    String nm;

    /** 删除标记 */
    @Column(name = "DEL_F")
    Short delF;

    /** 
     * Returns the mdMrParaCd.
     * 
     * @return the mdMrParaCd
     */
    public String getMdMrParaCd() {
        return mdMrParaCd;
    }

    /** 
     * Sets the mdMrParaCd.
     * 
     * @param mdMrParaCd the mdMrParaCd
     */
    public void setMdMrParaCd(String mdMrParaCd) {
        this.mdMrParaCd = mdMrParaCd;
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