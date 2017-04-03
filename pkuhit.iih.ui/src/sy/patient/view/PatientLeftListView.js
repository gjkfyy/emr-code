Ext.define('iih.sy.patient.view.PatientLeftListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.patientleftlistview',
	id:'patientleftlistview',
	
	requires :[
	    'Xap.ej.element.button.Button',
		'iih.sy.patient.block.PatientLeftBlock',
		'iih.sy.patient.block.PatientLeftGridBlock',
		'iih.sy.patient.action.PatientLeftSearchAction',
	
		'iih.sy.patient.action.PatientSaveAction',
		'iih.sy.patient.action.PatientEditWinAction'
		//'iih.sy.patient.action.CreatePatientAction'
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
						id : 'searchCondition',
						name : 'searchCondition',
						colspan : 1,
						labelWidth : 20,
						width : 230,
						labelAlign : 'right',
						readOnly : false,
						fieldStyle:'color:#c6c6c6',
						value : '输入姓名、住院号、手机号检索',
						fieldLabel : '',
						listeners:{
				        	specialkey : function(field, e) {  
				                if (e.getKey() == Ext.EventObject.ENTER) { 
				                	var view = this.up('patientleftlistview');
				                	var chain = view.getActionChain('init');
				                	if(chain) {
				    	        		chain.execute({});
				    	        	}
				                }  
				            },
				            blur : function() {
								var value = Ext.getCmp('searchCondition').getValue();
								if(value==""){
									Ext.getCmp('searchCondition').setValue('输入姓名、住院号、手机号检索');
									Ext.getCmp('searchCondition').setFieldStyle('color:#c6c6c6');
								}
							},
							focus : function(area, The, eOpts) {
								var value = Ext.getCmp('searchCondition').getValue();
								if(value=='输入姓名、住院号、手机号检索'){
									Ext.getCmp('searchCondition').setValue('');
									Ext.getCmp('searchCondition').setFieldStyle('color:#000000');
								}
			                }
				        }
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
				url: 'iemrPatients',
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
			},
			'editPatient': {
                xclass: 'iih.sy.patient.action.PatientEditWinAction',
                url:'patient',
                blocks:{
                    result:'right'
                }
            }
		},

		chains: {
			'init':['init'],
			'create':['create'],
			'patientCreate':['patientCreate'],
			'editPatient':['editPatient']
		},

		connections: {
			'condition':[{
				selector: 'button[action=newPatient]',
				event: 'click',
				chain: 'patientCreate'
			},{
				selector: 'button[action=editPatient]',
				event: 'click',
				chain: 'editPatient'
			}],
			'result': [{// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'init'
			},{
				event: 'afterrender',
				chain: 'init'
			},{
				event: 'selectionchange',
			chain: 'checkPatientChangeAction'
		}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'init'
			}]
		}
	}
})