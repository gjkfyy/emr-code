Ext.define('iih.mr.tth.view.TeethReportView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: ['iih.mr.qa.qa_reports.block.ReportBlock'],
    
	alias:'widget.teethreportview',
	
	layout: 'fit',
	
	xapConfig: {
		blocks: {
            'content': {
                xclass: 'iih.mr.qa.qa_reports.block.ReportBlock'
            }
		},
        actions: {
            'init': {
                xclass: 'iih.mr.tth.action.TeethReportInitAction',
                url: 'qa/reports',
                blocks: {
                    content: 'content'
                }
            }
        },  
        chains: {
            'init': ['init']
        },
        connections: {
            'content':[{
                event: 'afterrender',
                chain: 'init'
            }]
        }
	},
	initComponent : function() {
		this.callParent();
		var me = this;
	}
});