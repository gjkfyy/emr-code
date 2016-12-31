package pkuhit.iih.qa.dao.auto.entity;

import java.math.BigInteger;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 */
@Entity(listener = QaSysAmrRankScrListener.class)
@Table(name = "QA_SYS_AMR_RANK_SCR")
public class QaSysAmrRankScr {

    /** */
    @Id
    @Column(name = "QA_SYS_AMR_RANK_SCR_CD")
    String qaSysAmrRankScrCd;

    /** */
    @Column(name = "QA_SYS_AMR_CD")
    String qaSysAmrCd;

    /** */
    @Column(name = "AMR_RANK_CD")
    String amrRankCd;

    /** */
    @Column(name = "MAX_SCR")
    BigInteger maxScr;

    /** */
    @Column(name = "MIN_SCR")
    BigInteger minScr;

    /** 
     * Returns the qaSysAmrRankScrCd.
     * 
     * @return the qaSysAmrRankScrCd
     */
    public String getQaSysAmrRankScrCd() {
        return qaSysAmrRankScrCd;
    }

    /** 
     * Sets the qaSysAmrRankScrCd.
     * 
     * @param qaSysAmrRankScrCd the qaSysAmrRankScrCd
     */
    public void setQaSysAmrRankScrCd(String qaSysAmrRankScrCd) {
        this.qaSysAmrRankScrCd = qaSysAmrRankScrCd;
    }

    /** 
     * Returns the qaSysAmrCd.
     * 
     * @return the qaSysAmrCd
     */
    public String getQaSysAmrCd() {
        return qaSysAmrCd;
    }

    /** 
     * Sets the qaSysAmrCd.
     * 
     * @param qaSysAmrCd the qaSysAmrCd
     */
    public void setQaSysAmrCd(String qaSysAmrCd) {
        this.qaSysAmrCd = qaSysAmrCd;
    }

    /** 
     * Returns the amrRankCd.
     * 
     * @return the amrRankCd
     */
    public String getAmrRankCd() {
        return amrRankCd;
    }

    /** 
     * Sets the amrRankCd.
     * 
     * @param amrRankCd the amrRankCd
     */
    public void setAmrRankCd(String amrRankCd) {
        this.amrRankCd = amrRankCd;
    }

    /** 
     * Returns the maxScr.
     * 
     * @return the maxScr
     */
    public BigInteger getMaxScr() {
        return maxScr;
    }

    /** 
     * Sets the maxScr.
     * 
     * @param maxScr the maxScr
     */
    public void setMaxScr(BigInteger maxScr) {
        this.maxScr = maxScr;
    }

    /** 
     * Returns the minScr.
     * 
     * @return the minScr
     */
    public BigInteger getMinScr() {
        return minScr;
    }

    /** 
     * Sets the minScr.
     * 
     * @param minScr the minScr
     */
    public void setMinScr(BigInteger minScr) {
        this.minScr = minScr;
    }
}