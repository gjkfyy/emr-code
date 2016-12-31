/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.qa_reports.action.ToReportAction', {
extend: 'Xap.ej.action.Action',

	requires: ['iih.mr.qa.qa_reports.view.QaReportWithoutConditionView'],
	
	execute: function(context) {
		
		var me = this;
		
		var owner = this.getOwner();   
		
		var topBlock = this.getBlock('result');
	    
	    var enGrid = topBlock.down('xapgrid');
	    
	    var selModel = enGrid.getSelectionModel();
	    
	    var record = selModel.getSelection()[0];

	    var reportCd = record.data.reportCd;
	    var reportName = record.data.reportName;
	    var event = context.event;
	    
	    var workareapageview = owner.ownerCt;
	    var reportview = workareapageview.items.items[1];
	    if(reportview){
	    	workareapageview.remove(reportview);
	    }
	    
	    var pageCode = 'qareportwithoutconditionview';
//	    var pageCode = 'qareportview';
	    var pageTitle = reportName;
	    
	    var viewConfig = {
	    	reportRecord:record,
	    	reportCd: reportCd,
	    	reportName:reportName
	    }
	    
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                xclass: 'iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
//                xclass: 'iih.mr.qa.qa_reports.view.QaReportView',
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",config);
        };
    }
});