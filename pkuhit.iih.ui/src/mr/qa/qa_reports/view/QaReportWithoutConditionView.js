
/** 
 * 质控报表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.qa_reports.view.QaReportWithoutConditionView',{
	extend :  'Xap.ej.template.BaseTemplate',
	
	requires: [
	           'iih.mr.qa.QaStatusGlobal',
	           'iih.mr.qa.qa_reports.block.ReportBlock',
	           'iih.mr.qa.qa_reports.action.OpenSearchReportAction'
	],

	alias:'widget.qareportwithoutconditionview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'result': {
                xclass: 'iih.mr.qa.qa_reports.block.ReportBlock',
                flex:1
            }
		},
		
		actions: {
			'openBios': {
				xclass: 'iih.mr.qa.qa_reports.action.OpenSearchReportAction',
				blocks: {
					condition: 'properties',
					result: 'result'
				}
			}
		},

		chains: {
			'openBios':['openBios']
		},

		connections: {
			'result':[{
				event: 'afterrender',
				chain: 'openBios'
			}]
		}
	}
})