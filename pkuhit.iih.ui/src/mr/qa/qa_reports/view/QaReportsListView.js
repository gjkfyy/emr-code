
/** 
 * 质控报表列表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.qa_reports.view.QaReportsListView',{
	extend: 'Xap.ej.template.BaseTemplate',
	requires: [
	           'Xap.ej.element.grid.Grid', 
	           'Xap.ej.element.field.Checkbox',
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.button.Button',
	           'Xap.ej.element.label.Label',
	           'Xap.ej.element.grid.column.Date',
	           'iih.mr.qa.QaStatusGlobal',
	           'Xap.ej.block.GridBlock',
	           'iih.mr.qa.qa_reports.block.ReportsListBlock',
	           'iih.mr.qa.qa_reports.action.ReportsListAction'
	],

	alias:'widget.qareportslistview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'result': {
                xclass: 'iih.mr.qa.qa_reports.block.ReportsListBlock',
                flex:1
            }
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.qa_reports.action.ReportsListAction',
				url: 'qa/reports',
				blocks: {
					condition: 'properties',
					result: 'result'
				}
			},
			'wakeButton': {
				xclass: 'iih.mr.qa.qa_reports.action.WakeReportButtonAction',
				blocks: {
					condition: 'properties',
					result: 'result'
				}
			},
			'reportViewreadyAction': {
				xclass: 'iih.mr.qa.qa_reports.action.ReportViewreadyAction',
				blocks: {
					condition: 'properties',
					result: 'result'
				}
			},
			'toReport': {
				xclass: 'iih.mr.qa.qa_reports.action.ToReportAction',
				blocks: {
					condition: 'properties',
					result: 'result'
				}
			}
		},

		chains: {
			'init':['init'],
			'toReport':['toReport'],
			'wakeButton':['wakeButton'],
			'reportViewreadyAction':['reportViewreadyAction']
		},

		connections: {
			'result':[{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'toReport'
			},{
				selector: 'xapgrid',
				event: 'select',
				chain: 'wakeButton'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'reportViewreadyAction'
			},{
				event: 'afterrender',
				chain: 'init'
			}]
		}
	},
	
	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");//为视图添加刷新事件
		this.addListener('pageRefresh', function(){//添加监听事件
	        var chain = this.getActionChain('init');
	        if(chain) {
	            chain.execute();
	        }
		});
	}
	
})