package pkuhit.iih.qa.qacustom.bizmodel;

import java.math.BigDecimal;

import xap.model.BaseBizModel;
import xap.sv.annotation.Column;

public class QaFaultStatistical extends BaseBizModel {

	public QaFaultStatistical() {

		super();

	}

	public QaFaultStatistical(String code) {

		super(code);

	}
	
	@Column(name = "ALLFAULTNUM")
	private BigDecimal allFaultNum;
	
	@Column(name = "TOREFORM")
	private BigDecimal toReform;//新建，待整改
	
	@Column(name = "REFORMED")
	private BigDecimal reformed;//已整改，待审核
	
	@Column(name = "OTHERSTATE")
	private BigDecimal otherState;//审核通过 扣分数
	
	@Column(name = "REVISIONNUM")
	private BigDecimal revisionNum;//整改通知单状态数（待整改，整改中，已整改）
	
	public BigDecimal getAllFaultNum() {
		return allFaultNum;
	}

	public void setAllFaultNum(BigDecimal allFaultNum) {
		this.allFaultNum = allFaultNum;
	}

	public BigDecimal getToReform() {
		return toReform;
	}

	public void setToReform(BigDecimal toReform) {
		this.toReform = toReform;
	}

	public BigDecimal getReformed() {
		return reformed;
	}

	public void setReformed(BigDecimal reformed) {
		this.reformed = reformed;
	}

	public BigDecimal getOtherState() {
		return otherState;
	}

	public void setOtherState(BigDecimal otherState) {
		this.otherState = otherState;
	}

	public BigDecimal getRevisionNum() {
		return revisionNum;
	}

	public void setRevisionNum(BigDecimal revisionNum) {
		this.revisionNum = revisionNum;
	}
	
}