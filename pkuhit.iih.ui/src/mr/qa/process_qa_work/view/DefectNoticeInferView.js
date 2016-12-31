Ext.define('iih.mr.qa.process_qa_work.view.DefectNoticeInferView',{
	extend : 'Xap.ej.template.BaseTemplate',
	
	requires:[
	  	'Xap.ej.stl.action.SimpleSearchAction',
	  	'Xap.ej.element.grid.Grid',
	    'Xap.ej.element.form.Form',
	    'Xap.ej.element.label.Label',
	    'Xap.ej.element.field.TextField',
	    'Xap.ej.element.field.ComboBox',
	    'Xap.ej.element.field.TextArea',
	    'Xap.ej.element.toolbarbutton.ToolBarButton',
	    'Xap.ej.element.button.Button',
	    'Xap.ej.element.field.NumberField',
	    'Xap.ej.element.field.DisplayField',
	    'Xap.ej.element.field.RangeNumberField',
		'iih.mr.qa.process_qa_work.block.DefectNoticeInferBlock',
		'iih.mr.qa.process_qa_work.action.DefectReformDeadlineAction',
		'iih.mr.qa.process_qa_work.action.DefectNoticeInferSaveAction',
		'iih.mr.qa.process_qa_work.action.CancelAction',
		'iih.mr.qa.process_qa_work.action.DefectNoticeInferInitAction'
	],

    alias:'widget.defectnoticeinferview',
	
	
	xapConfig: {
		blocks: {
			'list': {
				xclass: 'iih.mr.qa.process_qa_work.block.DefectNoticeInferBlock',
				height:560
			}
		},
		actions: {
			'refresh': {
				xclass: 'iih.mr.qa.process_qa_work.action.DefectNoticeInferInitAction',
				url: '/qacustom/faults',
//				url: 'http://172.18.72.123:8081/qa/fault/statics',
				blocks: {
					condition: 'properties',
					result: 'list'
				}
			},
			'reformDeadline': {
				xclass: 'iih.mr.qa.process_qa_work.action.DefectReformDeadlineAction',
				blocks: {
					result: 'list'
				}
			},
			'send': {
				xclass: 'iih.mr.qa.process_qa_work.action.DefectNoticeInferSaveAction',
				url:"qacustom/submitted/faults",
//				url: "http://172.18.73.65:8082/qa/submitted/faults",
				blocks: {
					result: 'list'
				}
			},
			'cancel': {
				xclass: 'iih.mr.qa.process_qa_work.action.CancelAction',
				blocks: {
					result: 'list'
				}
			}
		},

		chains: {
			'refresh': ['refresh'],
			'reformDeadline': ['reformDeadline'],
			'send': ['send'],
			'cancel': ['cancel']
		},

		connections: {
			'list': [/*{
				event: 'afterrender',
				chain: 'refresh'
			},{
				//填写整改期限，计算整改截止日期
				selector: 'xapnumberfield[method=reformDeadline]',
				event: 'change',
				chain: 'reformDeadline'
			},*/{
				selector: 'button[method=send]',
				event: 'click',
				chain: 'send'
			},{
				selector: 'button[method=cancel]',
				event: 'click',
				chain: 'cancel'
			}]
		}
	}
})