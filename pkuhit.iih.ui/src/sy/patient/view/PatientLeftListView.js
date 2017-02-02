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
						id : 'searchCondition',
						name : 'searchCondition',
						colspan : 1,
						labelWidth : 20,
						width : 230,
						labelAlign : 'right',
						readOnly : false,
						fieldStyle:'color:#c6c6c6',
						value : '输入姓名、住院号、入院时间检索',
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
									Ext.getCmp('searchCondition').setValue('输入姓名、住院号、入院时间检索');
								}
							},
							focus : function(area, The, eOpts) {
								var value = Ext.getCmp('searchCondition').getValue();
								if(value=='输入姓名、住院号、入院时间检索'){
									Ext.getCmp('searchCondition').setValue('');
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
			},{
				event: 'afterrender',
				chain: 'init'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'init'
			}]
		}
	}
})