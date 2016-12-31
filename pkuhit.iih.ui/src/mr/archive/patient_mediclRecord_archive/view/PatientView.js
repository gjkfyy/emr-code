Ext.define('iih.mr.archive.patient_mediclRecord_archive.view.PatientView', {
	extend : 'Xap.ej.template.BaseTemplate',

	alias : 'widget.patientview',
	id : 'patientandmediclrecordview',
	requires : [ 
	             'Xap.ej.element.button.Button',
	             'Xap.ej.element.grid.plugin.CellEditing',
	             'Xap.ej.element.grid.column.CheckColumn',
	             'Xap.ej.element.field.Checkbox',
	             'Xap.ej.element.grid.column.Date',
	             'Xap.ej.element.field.DateField',
	             'iih.mr.archive.patient_mediclRecord_archive.block.PatientListGridBlock',
	             'iih.mr.archive.patient_mediclRecord_archive.block.PatientListBlock',
	             'Xap.ej.element.grid.column.ActionColumn',
	             'iih.mr.archive.patient_mediclRecord_archive.action.PatientArchiveAction',
	             'iih.mr.archive.patient_mediclRecord_archive.action.PatientListArchiveAction'
	             ],

	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	xapConfig : {
		blocks : {
			'condition' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.block.PatientListBlock',
				height : 100
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
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.block.PatientListGridBlock',
				flex : 1
			}
		},
		actions : {
			'search' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientListSearchAction',
				url : 'mr/search/amrs',
				blocks : {
					condition : 'condition',
					result : 'content'
				}
			},
			'init' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientInitAction',
				blocks : {
					content : 'condition'
				}
			},
			'showMedicl' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientShowMediclRecordAction',
				blocks : {
					content : 'content'
				}
			},
			'patientArchive' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientArchiveAction',
				url:'mr/archive/amrArchive',
				blocks : {
					content : 'content'
				}
			},
			'patientListArchive' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientListArchiveAction',
				url:'mr/archive/amrListArchive',
				blocks : {
					content : 'content'
				}
			},
			'patientArchiveBtnSta' : {
				xclass : 'iih.mr.archive.patient_mediclRecord_archive.action.PatientArchiveBtnStaAction',
				blocks : {
					content : 'content'
				}
			},
			'amrConfirmArchive':{
				xclass:'iih.mr.archive.patient_mediclRecord_archive.action.AmrConfirmArchiveAction',
				blocks : {
					content : 'content'
				}
			}

		},

		chains : {
			'init' : [ 'init' ],
			'search' : [ 'search' ],
			'showMedicl' : [ 'showMedicl' ],
			'patientArchive' : [ 'patientArchive' ],
			'patientArchiveBtnSta' : [ 'patientArchiveBtnSta' ],
			'patientListArchive' : [ 'patientListArchive' ],
			'amrConfirmArchive':['amrConfirmArchive']
		},

		connections : {
			condition:[{
				selector : 'radiogroup[name=checkQa]',
				event : 'change',
				chain : 'search'
			},{
				selector : 'radiogroup[name=checkArc]',
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
		this.addListener('pageRefresh', function() {// 添加监听事件
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
		});

	}
})