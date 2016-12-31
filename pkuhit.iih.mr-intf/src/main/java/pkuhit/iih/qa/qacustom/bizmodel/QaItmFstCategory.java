package pkuhit.iih.qa.qacustom.bizmodel;
import xap.sv.annotation.Column;
import xap.sv.annotation.DictionaryTag;
import xap.model.BaseMasterModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.seasar.doma.Id;

public class QaItmFstCategory extends BaseMasterModel {
 public QaItmFstCategory(){
  super();
 }
 public QaItmFstCategory(String code){
  super(code);
 }
 public static final String   OBJ_CD  = "MRM16";

 /** 一级分类编码 */
 @Column(name = "FST_CD")
 String fstCd;

 /** 分值 */
 @Column(name = "SCORE")
 BigDecimal score;

 /** 名称 */
 @Column(name = "NM")
 String nm;
 
 /** 描述*/
 @Column(name = "MEMO")
 String memo;

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

public String getMemo() {
	return memo;
}

public void setMemo(String memo) {
	this.memo = memo;
}
 }