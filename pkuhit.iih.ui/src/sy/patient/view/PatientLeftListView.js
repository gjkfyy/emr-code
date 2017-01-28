Ext.define('iih.sy.patient.view.PatientLeftListView',{
	extend : 'Xap.ej.stl.view.SearchTemplate',

	alias:'widget.patientleftlistview',
	
	requires :[
	    'Xap.ej.element.button.Button',
		'iih.sy.patient.block.PatientLeftBlock',
		'iih.sy.patient.block.PatientLeftGridBlock',
		'iih.sy.patient.action.PatientLeftSearchAction',
		'iih.sy.patient.action.PatientRightListAction',
		'iih.sy.patient.action.PatientSaveAction',
		'iih.sy.patient.action.CreatePatientAction'
	],
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.sy.patient.block.PatientLeftBlock',
				height:35
			},
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
						xtype : 'xaptextfield',
						name : 'id',
						colspan : 1,
						labelWidth : 20,
						width : 230,
						labelAlign : 'right',
						readOnly : false,
						fieldStyle:'color:#c6c6c6',
						value : '输入姓名、住院号、入院时间检索',
						fieldLabel : ''
					},{
						xtype: 'button',
						text: '查询',
						iconCls: 'icon-Search',
						action: 'search'
					}]
			},
			'result':{
				xclass: 'iih.sy.patient.block.PatientLeftGridBlock'
			}
		},
		actions: {
			'init': {
				xclass: 'iih.sy.patient.action.PatientLeftSearchAction',
				//url: 'http://172.18.100.116:8081/dm-xap/users',
				url: 'users',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'create': {
                xclass: 'iih.sy.patient.action.PatientCreateWinAction',
                url:'patient',
                blocks:{
                    result:'left'
                }
            },
			'patientCreate': {
				xclass: 'iih.sy.patient.action.PatientCreateAction',
				url:'patient'
			}
		},

		chains: {
			'init':['init'],
			'create':['create'],
			'patientCreate':['patientCreate']
		},

		connections: {
			'condition':[{
				selector: 'button[action=newPatient]',
				event: 'click',
				chain: 'patientCreate'
			}],
			'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'init'
			}]
		}
	}
})