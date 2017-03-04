/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.sy.patient.action.ToReportAction', {
extend: 'Xap.ej.action.Action',

	requires: ['iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
	           'iih.mr.wr.mr.view.MrDocEditView',
	           'iih.sy.patient.view.OutMrDocEditView'],
	
	execute: function(context) {
		this.callParent();
		var pageCode = 'patientoutmrdoceditview';
		var record = context.record;
	    var viewConfig = {
	    	reportRecord:record
	    }
	    
      /*  var config = {
        	pageCode: pageCode,
        	pageTitle: '病历文书',
            xclass: 'iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',
            viewConfig:  {
                opType:'open',
                reportRecord:record
            }
        };*/
	    //A8C7634DC3984863B797E8113DA0FCA5
	    var mrPk='D13321E54B8C40B29241C4689A0315C0';
	    var config = {
                pageCode: 'mrdoceditview',
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                pageTitle: '为张三新建上肢病历文书01',
                viewConfig:{
                    mrSn:mrPk,
                    opType:'open'
                },
                assistantConfig:{
                    tgtObCd: 'MRB02',
                    tgtObPk: mrPk
                }
	        };       
	    
        var canvas = Xap.getCanvas();
        canvas.fireEvent("addWorkPage",config);
        
    }
});