Ext.define('iih.mr.dr.retrieval.view.DataRetrievalListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.dataretrievallistview',

	requires:[
		'Xap.ej.element.field.ComboBox',
   		'Xap.ej.element.field.Checkbox',
		'Xap.ej.element.radiogroup.RadioGroup',
		'Xap.ej.element.checkboxgroup.CheckboxGroup',
		'Xap.ej.element.form.Form',
		'Xap.ej.element.grid.Grid',
   		'Xap.ej.element.label.Label',
   		'Xap.ej.element.field.DateField', 
   		'Xap.ej.element.grid.column.Date',
   		'Xap.ej.element.grid.column.CheckColumn',
   		'iih.mr.dr.retrieval.block.DataRetrievalGridBlock',
   		'iih.mr.dr.retrieval.action.DataRetrievalSearchInitAction',
   		'iih.mr.dr.retrieval.action.PopupPlanAction',
   		'iih.mr.dr.plan.view.PlanListBrowseView'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			/*'condition':{
				xclass: 'iih.mr.dr.retrieval.view.DataRetrievalSearchView',
				height:86
			},*/
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					iconCls: 'icon-Search',
					text: '选择方案',
					action: 'searchCondition'
				},/*{
					xtype: 'button',
					iconCls: 'icon-Search',
					text: '查询',
					action: 'search'
				},{
					xtype: 'button',
					iconCls: 'icon-cancel',
					text: '重置',
					action: 'reset'
				},*/{
					xtype: 'button',
					iconCls: 'LinkQCTask',
					text: '导出Excel',
					action: 'search'
				}]
			},
			'result':{
				xclass: 'iih.mr.dr.retrieval.block.DataRetrievalGridBlock',
				flex:1
			}
		},
		actions: {
			'search':{
				xclass: 'iih.mr.dr.retrieval.action.DataRetrievalSearchInitAction',
				blocks: {
//					condition: 'condition',
					result: 'result'
				}
			},'searchCondition':{
				xclass: 'iih.mr.dr.retrieval.action.PopupPlanAction',
				blocks: {
//					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'searchCondition': ['searchCondition']
		},

		connections: {
			/*'condition':[{
                selector: 'comboxgrid[method=curDeptNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'comboxgrid[name=crtUserNm]',
                event: 'combochange',
                chain: 'search'
			},{
                selector: 'comboxgrid[name=currentManageDoctorName]',
                event: 'combochange',
                chain: 'search'
			}],*/
			'result': [{
				event: 'afterrender',
				chain: 'search'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			},{
				selector: 'button[action=searchCondition]',
				event: 'click',
				chain: 'searchCondition'
			}]
		}
			
	}/*,
		
	initComponent : function() {
		
	}*/
})