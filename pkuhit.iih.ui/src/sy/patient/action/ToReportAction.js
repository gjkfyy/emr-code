/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.sy.patient.action.ToReportAction', {
extend: 'Xap.ej.action.Action',

	requires: ['iih.mr.qa.qa_reports.view.QaReportWithoutConditionView'],
	
	execute: function(context) {
		var pageCode = 'qareportwithoutconditionview';
		var record = context.record;
	    var viewConfig = {
	    	reportRecord:record
	    }
	    
        var config = {
        	pageCode: pageCode,
        	pageTitle: '111',
            xclass: 'iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
            viewConfig:  viewConfig
        };
        var canvas = Xap.getCanvas();
        
         canvas.fireEvent("portalRender");
        
        
       /* this.relayEvents(canvas, ['addWorkPage']);
        this.addListener('addWorkPage', function(config) {
            var chain = me.getActionChain('addWorkAreaPage');
            chain.execute(config);
        });*/
        
        
        
         //canvas.fireEvent("addWorkPage",config);
    }
});