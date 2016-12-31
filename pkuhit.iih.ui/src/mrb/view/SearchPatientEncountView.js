Ext.define('iih.mrb.view.SearchPatientEncountView', {
	extend : 'Xap.ej.template.BaseTemplate',

	alias : 'widget.searchpatientencountview',
	id : 'searchpatientencountview',
	requires : [ 
	             'Xap.ej.element.button.Button',
	             'Xap.ej.element.grid.plugin.CellEditing',
	             'Xap.ej.element.grid.column.CheckColumn',
	             'Xap.ej.element.field.Checkbox',
	             'Xap.ej.element.grid.column.Date',
	             'Xap.ej.element.field.DateField',
	             'iih.mrb.block.MrbPatientListGridBlock',
	             'iih.mrb.block.MrbPatientListBlock',
	             'Xap.ej.element.grid.column.ActionColumn',
	             'iih.mrb.action.MrTypeSearchAction'
	            
	             ],

	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	xapConfig : {
		blocks : {
			'condition' : {
				xclass : 'iih.mrb.block.MrbPatientListBlock',
				height : 130
			},
			'toolbar' : {
				xclass : 'Xap.ej.block.ToolbarBlock',
				items : [ {
					xtype : 'button',
					iconCls : 'icon-reset',
					text : '重置',
					action : 'init'
				}, {
					xtype : 'button',
					iconCls : 'icon-Search',
					text : '查询',
					action : 'search'
				} ]
			},
			'content' : {
				xclass : 'iih.mrb.block.MrbPatientListGridBlock',
				flex : 1
			}
		},
		actions : {
			'searchDeptList' : {
				xclass : 'iih.mrb.action.SearchDeptListAction',
				url : 'departments/entype',
				blocks : {
					result : 'content'
				}
			},
			'searchDoctorByDeptList' : {
				xclass : 'iih.mrb.action.SearchDoctorListByDeptAction',
				url : 'org/dept/employee',
				blocks : {
					result : 'content'
				}
			},
			'search' : {
				xclass : 'iih.mrb.action.PatientListSearchAction',
				url : 'mrb/search/amrs',
				blocks : {
					condition : 'condition',
					result : 'content'
				}
			},
			'init' : {
				xclass : 'iih.mrb.action.PatientInitAction',
				blocks : {
					content : 'condition'
				}
			},
			'showMedicl' : {
				xclass : 'iih.mrb.action.ShowMrDocHelperViewAction',
				blocks : {
					content : 'content'
				}
			},
			'searchMrType':{
				xclass: 'iih.mrb.action.MrTypeSearchAction',
				url:'mrtypes',
				blocks: {
				    content: 'condition'
				}
			}

		},

		chains : {
			'searchDeptList' : [ 'searchDeptList' ]
		,'searchDoctorByDeptList' : [ 'searchDoctorByDeptList' ],
			'init' : [ 'init' ],
			'search' : [ 'search' ],
			'showMedicl' : [ 'showMedicl' ],
			'searchMrType' : [ 'searchMrType' ]
		},
		connections : {
			condition:[
		             {
				     			selector : 'xapcombobox[action=enTypeCode]',
				     			event : 'change',
				     			chain : 'searchDeptList'
				     		}/*, {
				     			selector : 'xapcombobox[action=deptCodeList]',
				     			event : 'select',
				     			chain : 'searchDoctorByDeptList'
				     		} */ ,
			           {
				selector : 'radiogroup[name=checkArchive]',
				event : 'change',
				chain : 'search'
			}],
			'content' : [ {
				event : 'afterrender',
				chain : 'init'
			}, {
				selector : 'xapgrid',
				event : 'itemdblclick',
				chain : 'showMedicl'
			}, {// 翻页操作
				selector : 'xapgrid',
				event : 'turnpage',
				chain : 'search'
			}, {
				selector : 'xapgrid[name=patientGrid]',
				event : 'selectionchange',
				chain : 'patientArchiveBtnSta'
			}
			],
			'toolbar' : [ {
				selector : 'button[action=search]',
				event : 'click',
				chain : 'search'
			}, {
				selector : 'button[action=init]',
				event : 'click',
				chain : 'init'
			} ]
		}
	},

	initComponent : function() {
		this.callParent();
		this.addEvents("pageRefresh");// 为视图添加刷新事件
		this.addListener('pageRefresh', function() {/*// 添加监听事件
			var properties = this.getLayer(Xap.ej.block.Layer.PROPERTIES);
			var chain = this.getActionChain('search');
			var block = this.getBlock('content');
			// var pageSize = block.pageSize;
			if (properties.data == undefined) {
				if (chain) {
					chain.execute({});
				}
			} else {
				var pageSize = properties.data.pageSize;
				var pageNum = properties.data.pageNum;
				if (chain) {
					chain.execute({
						pageSize : pageSize,
						pageNum : pageNum
					});
				}
			}
		*/});

	}
})