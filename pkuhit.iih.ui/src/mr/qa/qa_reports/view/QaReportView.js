
/** 
 * 质控报表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.qa_reports.view.QaReportView',{
	extend : 'Xap.ej.stl.view.TopBottomContainerTemplate',
	
	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'Xap.ej.block.GridBlock',
	           'Xap.ej.element.MessageBox.MessageBox',
	           'iih.mr.qa.qa_reports.block.ReportBlock',
	           'iih.mr.qa.qa_reports.block.ReportConditionBlock',
	           'iih.mr.qa.qa_reports.action.OpenReportAction',
	           'iih.mr.qa.qa_reports.action.ShowReportConditionAction'
	],

	alias:'widget.qareportview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.qa_reports.block.ReportConditionBlock',
                height:50
            },
            'bottom': {
                xclass: 'iih.mr.qa.qa_reports.block.ReportBlock',
                flex:1
            }
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.qa_reports.action.ShowReportConditionAction',
				blocks: {
					condition: 'properties',
					result: 'top'
				}
			},
			'openBios': {
				xclass: 'iih.mr.qa.qa_reports.action.OpenReportAction',
//				url: 'qa/notification/faults',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			}
		},

		chains: {
			'init':['init'],
			'openBios':['openBios']
		},

		connections: {
			'top':[{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'xapbutton[name=openBios]',
				event: 'click',
				chain: 'openBios'
			}]
		}
	}
})