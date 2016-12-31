package pkuhit.iih.mr.dao.auto.entity;

import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 病历文书类型段落关系表
 */
@Entity(listener = MdMrTpParaListener.class)
@Table(name = "MD_MR_TP_PARA")
public class MdMrTpPara {

    /** 主键 */
    @Id
    @Column(name = "MD_MR_TP_PARA_PK")
    String mdMrTpParaPk;

    /** 病历文书类型编码 */
    @Column(name = "MD_MR_TP_CD")
    String mdMrTpCd;

    /** 病历文书段落编码 */
    @Column(name = "MD_MR_PARA_CD")
    String mdMrParaCd;

    /** 删除标识 */
    @Column(name = "DEL_F")
    Short delF;

    /** 
     * Returns the mdMrTpParaPk.
     * 
     * @return the mdMrTpParaPk
     */
    public String getMdMrTpParaPk() {
        return mdMrTpParaPk;
    }

    /** 
     * Sets the mdMrTpParaPk.
     * 
     * @param mdMrTpParaPk the mdMrTpParaPk
     */
    public void setMdMrTpParaPk(String mdMrTpParaPk) {
        this.mdMrTpParaPk = mdMrTpParaPk;
    }

    /** 
     * Returns the mdMrTpCd.
     * 
     * @return the mdMrTpCd
     */
    public String getMdMrTpCd() {
        return mdMrTpCd;
    }

    /** 
     * Sets the mdMrTpCd.
     * 
     * @param mdMrTpCd the mdMrTpCd
     */
    public void setMdMrTpCd(String mdMrTpCd) {
        this.mdMrTpCd = mdMrTpCd;
    }

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