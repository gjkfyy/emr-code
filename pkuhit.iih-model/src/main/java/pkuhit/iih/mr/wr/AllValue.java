package pkuhit.iih.mr.wr;

import xap.model.BaseBizModel;

/**
 * 新建病历时，所有需要刷新的数据
 */
public class AllValue extends BaseBizModel{
	private MrElemValue[] mrElemValues;
	private MacroElementValue macroElementValue;
	private RefreshPrescriptionAndDisposal refreshPrescriptionAndDisposal;
	
	public MrElemValue[] getMrElemValues() {
	
		return mrElemValues;
	}


	public RefreshPrescriptionAndDisposal getRefreshPrescriptionAndDisposal() {
		return refreshPrescriptionAndDisposal;
	}


	public void setRefreshPrescriptionAndDisposal(
			RefreshPrescriptionAndDisposal refreshPrescriptionAndDisposal) {
		this.refreshPrescriptionAndDisposal = refreshPrescriptionAndDisposal;
	}


	public void setMrElemValues(MrElemValue[] mrElemValues) {
	
		this.mrElemValues = mrElemValues;
	}

	public MacroElementValue getMacroElementValue() {
	
		return macroElementValue;
	}

	public void setMacroElementValue(MacroElementValue data) {

		this.macroElementValue = data;
		
	}
}