
/** 
 * 通知书缺陷列表
 * @author ：cheng_feng
 */
 
Ext.define('iih.mr.qa.process_qa_search.view.ProcessQaDefectView',{
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
	           'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
	           'iih.mr.qa.process_qa_search.block.NotificationDefectListBlock',
			   'iih.mr.qa.process_qa_track.action.DefectListAction',
			   'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction'
	],

	alias:'widget.processqadefectview',
	
	layout: {
        type : 'vbox',
        align : 'stretch'
    },
    
	xapConfig: {
		blocks: {
		    'top': {
                xclass: 'iih.mr.qa.process_qa_work.block.QaMrEditBlock',
                flex:1
            },
			'bottom': {
				xclass: 'iih.mr.qa.process_qa_search.block.NotificationDefectListBlock',
				height:200
			}
		},
		
		actions: {
			'init': {
				xclass: 'iih.mr.qa.process_qa_track.action.DefectListAction',
				url: 'qa/notification/faults',
				blocks: {
					condition: 'properties',
					result: 'bottom'
				}
			},
			'qaMrSignOpen': {
				xclass: 'iih.mr.qa.process_qa_track.action.QaMrSignOpenAction',
				blocks: {
					condition: 'properties',
					top: 'top',
					result: 'bottom'
				}
			},
			'processQaDefectViewready': {
				xclass: 'iih.mr.qa.process_qa_search.action.ProcessQaDefectViewreadyAction',
				blocks: {
					top: 'top',
					bottom: 'bottom'
				}
			}
		},

		chains: {
			'init':['init'],
			'processQaDefectViewready':['processQaDefectViewready'],
			'qaMrSignOpen':['qaMrSignOpen']
		},

		connections: {
			'bottom':[{
				event: 'afterrender',
				chain: 'init'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processQaDefectViewready'
			},{
				selector: 'xapgrid',
				event:'itemdblclick',
				chain: 'qaMrSignOpen'
			},{
				selector: 'xapgrid',
				event:'linkClick',
				chain: 'qaMrSignOpen'
			}]
		}
	}
})