Ext.define('iih.mr.dr.plan.view.PlanListView',{
	extend : 'Xap.ej.template.BaseTemplate',

	alias:'widget.planlistview',

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
   		'iih.mr.dr.plan.view.PlanSearchView',
   		'iih.mr.dr.condition_set.view.ConditionView',
   		'iih.mr.dr.plan.block.PlanGridBlock',
   		'iih.mr.dr.plan.action.PopupPlanInferAction',
   		'iih.mr.dr.plan.action.PlanSearchAction',
   		'iih.mr.dr.plan.action.ProcessPlanViewreadyAction',
   		'iih.mr.dr.plan.action.ToConditionAction',
   		'iih.mr.dr.plan.action.PlanSaveAction',
   		'iih.mr.dr.plan.action.PopupEditPlanAction',
   		'iih.mr.dr.plan.action.PlanDeleteAction'
	],

	layout: {
        type : 'vbox',
        align : 'stretch'
    },
	
	xapConfig: {
		blocks: {
			'condition':{
				xclass: 'iih.mr.dr.plan.view.PlanSearchView',
				height:86
			},
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					iconCls: 'icon-Search',
					text: '查询',
					action: 'search'
				},{
					xtype: 'button',
					iconCls: 'icon-Create',
					text: '新增方案',
					action: 'create'
				},{
					xtype: 'button',
					iconCls: 'LinkQCTask',
					text: '方案设置',
					action: 'conditionSetting'
				}]
			},
			'result':{
				xclass: 'iih.mr.dr.plan.block.PlanGridBlock',
				flex:1
			}
		},
		actions: {
			'search':{
				xclass: 'iih.mr.dr.plan.action.PlanSearchAction',
				url:'dr/retrieval/list',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'processPlanViewready': {
				xclass: 'iih.mr.dr.plan.action.ProcessPlanViewreadyAction',
				blocks: {
					condition:'condition',
					result: 'result'
				}
			},
			'create':{
				xclass: 'iih.mr.dr.plan.action.PopupPlanInferAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'conditionSetting':{
				xclass: 'iih.mr.dr.plan.action.ToConditionAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			},
			'edit': {
				xclass: 'iih.mr.dr.plan.action.PopupEditPlanAction',
//				url:"dr/editretrieval",
				blocks: {
					result: 'result'
				}
			},
			'delete': {
				xclass: 'iih.mr.dr.plan.action.PlanDeleteAction',
				url:"dr/delretrieval",
				blocks: {
					result: 'result'
				}
			}
		},

		chains: {
			'search': ['search'],
			'processPlanViewready': ['processPlanViewready'],
			'create': ['create'],
			'edit': ['edit'],
			'delete': ['delete'],
			'conditionSetting': ['conditionSetting']
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
			},{
				selector: 'xapgrid',
				event: 'itemdblclick',
				chain: 'conditionSetting'
			},{
				selector: 'xapgrid',
				event: 'viewready',
				chain: 'processPlanViewready'
			}],
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			},{
				selector: 'button[action=create]',
				event: 'click',
				chain: 'create'
			},{
				selector: 'button[action=conditionSetting]',
				event: 'click',
				chain: 'conditionSetting'
			}/*,{
				selector: 'button[action=editRetrieval]',
				event: 'click',
				chain: 'edit'
			},{
				selector: 'button[action=deleteRetrieval]',
				event: 'click',
				chain: 'delete'
			}*/]
		}
			
	}/*,
		
	initComponent : function() {
		
	}*/
})