/** 
 * 是否可以整改
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.DefectIfRfmAction', {
    extend: 'Xap.ej.action.Action',

    execute: function(context) {
    	var resultBlock = this.getBlock('bottom');
	    var defectGrid = resultBlock.down('xapgrid');
		var rfmBtn = resultBlock.down('xapgrid xapbutton[action=rfm]');    //整改按钮
//		var finishRfmBtn = resultBlock.down('xapgrid xapbutton[action=finishRfm]');    //本次质控完成确认
	    var selModel = defectGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    var statusCode = record.data.fltStaCd;
	    var owner = this.getOwner(); 
	    var revisionStatus = owner.revisionStatus;
	    if(revisionStatus == iih.mr.qa.QaStatusGlobal.revisionNoticeToReform || revisionStatus == iih.mr.qa.QaStatusGlobal.revisionNoticeReforming){
		    if(statusCode == iih.mr.qa.QaStatusGlobal.faultVerified || statusCode == iih.mr.qa.QaStatusGlobal.faultDeductioned || statusCode == iih.mr.qa.QaStatusGlobal.faultReformed){
		    	rfmBtn.setDisabled(true);
//				finishRfmBtn.setDisabled(true);
		    }else{
		    	rfmBtn.setDisabled(false);
//				finishRfmBtn.setDisabled(false);
			}
	    }
    }
});
