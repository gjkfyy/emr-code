/** 
 * 质控报表
 * @author ：cheng_feng
 */
Ext.define('iih.sy.patient.action.ToReportAction', {
extend: 'Xap.ej.action.PopAction',

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
	   /* var arguments = context.event.arguments;
	    encounterPk = arguments[0].encounterPk;
        patientId = arguments[0].patientId;
        alert(encounterPk);
        IMER_GLOBAL.encounterSn = encounterPk;
        IMER_GLOBAL.patientId = patientId;*/
	    
	    var mrPk='3A28274DC68445F5A16EF8B4FD38B518';
	    var pageTitle = "为患者["+IMER_GLOBAL.patientName+"]新建病历"
	    var config = {
                pageCode: 'mrdoceditview',
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                pageTitle: pageTitle,
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