Ext.define('iih.mr.qa.qa_work_assistant.view.QaWorkHelperView', {
	extend: 'Xap.ej.element.tab.Panel',

	requires: ['iih.mr.qa.qa_work_assistant.view.DiagnosisHelperView',
	           'iih.mr.qa.qa_work_assistant.view.OrderListView',
	           'iih.po.assistant.view.ObservationReportView',
	           'iih.po.assistant.view.LabReportView',
	           'iih.mr.qa.qa_work_assistant.view.VitalSignHelperView'],

	alias:'widget.qaworkhelperview',

	layout: 'fit',
	
	tabBar: {
	    height:30,
	    layout: {
            type: 'hbox',
            align: 'middle',
            pack: 'end'
        },
	},

    items: [],

    initComponent: function() {
    	this.callParent();
    	this.removeAll();
    	this.add({
    	    title:'诊断',
            xtype:'diagnosishelperview'
    	});
    	this.add({
    	    title:'医嘱',
            xtype:'orderlistview'
    	});
    	this.add({
    	    title:'检查报告',
            xtype:'observationreportview'
    	});
    	this.add({
    	    title:'检验报告',
            xtype:'labreportview'
    	});
    	this.add({
    	    title:'生命体征',
            xtype:'vitalsignhelperview'
    	});
    	this.addListener('tabchange', function(p,n,o) {
    	   var enPk = IMER_GLOBAL.encounterSn;
    	   if(!n.refresh && enPk!=null){
			   n.fireEvent("changeEncounter",enPk);
			   n.refresh = true;
    	   }
       });
//       this.setActiveTab(0);
    }	
});