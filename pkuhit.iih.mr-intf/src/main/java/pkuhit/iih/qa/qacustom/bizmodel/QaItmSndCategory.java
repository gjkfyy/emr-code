package pkuhit.iih.qa.qacustom.bizmodel;
import java.math.BigDecimal;

import org.seasar.doma.Id;

import xap.model.BaseMasterModel;
import xap.sv.annotation.Column;

public class QaItmSndCategory extends BaseMasterModel {
 public QaItmSndCategory(){
  super();
 }
 public QaItmSndCategory(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM16";
 /** 二级分类编码 */
 @Id
 @Column(name = "SND_CD")
 String sndCd;

 /** 一级分类编码 */
 @Column(name = "FST_CD")
 String fstCd;

 /** 分值 */
 @Column(name = "SCORE")
 BigDecimal score;

 /** 名称 */
 @Column(name = "NM")
 String nm;

public String getSndCd() {
	return sndCd;
}

public void setSndCd(String sndCd) {
	this.sndCd = sndCd;
}

public String getFstCd() {
	return fstCd;
}

public void setFstCd(String fstCd) {
	this.fstCd = fstCd;
}

public BigDecimal getScore() {
	return score;
}

public void setScore(BigDecimal score) {
	this.score = score;
}

public String getNm() {
	return nm;
}

public void setNm(String nm) {
	this.nm = nm;
}
 
 }