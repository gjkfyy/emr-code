/** 
 * 通知书缺陷列表
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_patient.action.ToProcessQaDefectAction', {
extend: 'Xap.ej.action.Action',
	
	requires: ['iih.mr.qa.process_qa_patient.view.ProcessQaDefectsView'],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = this.getOwner();   
	    var record = context.record;
	    var  event = context.event;
	    
	    var patientName = record.data.patientName;
	    iih.mr.qa.QaStatusGlobal.patient.name = patientName;
	   /* var topview = owner.up('portalblock').down('topview');
		topview.eventNm = record.eventNm;*/
		
		/*var topBlock = this.getBlock('result');
	        
	    var enGrid = topBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	    
	    var faultTotal = record.data.faultTotal;
	    if(faultTotal == '' || faultTotal == null){
	    	return;
	    }
	    
	    var pk = record.data.pk;
	    
	    var sourceView=this.getOwner();	*/
		
	    var event = context.event;
	    var pageTitle = '缺陷列表';
	    var	pageCode = "processQaDefectsView";

	    var viewConfig = {
	    	revisionRecord:record
	    }
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("updatePatient",{patient:record.data});  // top患者信息刷新
            canvas.fireEvent("addWorkPage",config);
        };
    }
});