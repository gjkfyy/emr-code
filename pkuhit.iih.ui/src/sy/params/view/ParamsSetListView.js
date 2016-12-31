/**
 *   功能名称：智能助手-医嘱
 *   author：liulei
 */
Ext.define('iih.sy.params.view.ParamsSetListView', {
	extend: 'Xap.ej.template.BaseTemplate',

	requires: [
				'Xap.ej.element.grid.column.Date',
	           	'iih.sy.params.action.ParamsSetListInitAction',
	           	'iih.sy.params.action.CreateParamsSetAction',
	           	'iih.sy.params.action.EditParamsSetAction',
	           	'iih.sy.params.action.ParamsSetRefreshAction',
	           	'iih.sy.params.action.DeleteParamsSetAction'
	           ],

	alias:'widget.paramssetlistview',
	
	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	xapConfig: {
		blocks: {
		    'searchCondition':{
		    	xclass: 'iih.sy.params.block.ParamsSetSearchBlock'
		    	,height:40	
		    }
			,'toolbar' : {
				height:30,
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
			}
			,'paramslist': {
				height:500,
		    	xclass: 'iih.sy.params.block.ParamsSetListBlock'
            }
		},
		actions: {
			'init': {
				xclass: 'iih.sy.params.action.ParamsSetListInitAction',
				url:'param/set/list',
				blocks:{
					result: 'paramslist'
				}
			},
			'create': {
				xclass: 'iih.sy.params.action.CreateParamsSetAction',
				blocks:{
					result: 'paramslist'
				}
			},
			'edit': {
				xclass: 'iih.sy.params.action.EditParamsSetAction',
				blocks:{
					result: 'paramslist'
				}
			},
			'delete': {
				xclass: 'iih.sy.params.action.DeleteParamsSetAction',
				url:'param/set/delete',
				blocks:{
					result: 'paramslist'
				}
			},
			'refresh': {
				xclass: 'iih.sy.params.action.ParamsSetRefreshAction',
				url:'param/set/refresh',
				blocks:{
					result: 'paramslist'
				}
			}
		},

		chains: {
			'init':['init'],
			'create':['create'],
			'edit':['edit'],
			'refresh':['refresh'],
			'delete':['delete']
		},

		connections: {
			'paramslist': [{
					event: 'turnpage',//翻页操作
					chain: 'init'
			},{
					selector: 'button[method=create]',
					event: 'click',
					chain: 'create'
			},{
			},{
				selector: 'button[method=refresh]',
				event: 'click',
				chain: 'refresh'
			},{
					selector: 'button[method=edit]',
					event: 'click',
					chain: 'edit'
			}], 		'toolbar' : [ {
				selector : 'button[action=search]',
				event : 'click',
				chain : 'init'
			} ]
		}
	},
	
	initComponent : function() {
		this.callParent();
		var self = this;
		var grid = self.down('paramssetlistblock');
		var delBtn = grid.down('button[method=delete]');
		var msg = '确认删除？';
        delBtn.on('click',function(btn){
        	XapMessageBox.confirm2(msg, function(btn){
        		if(btn=='yes'){
        			var chainDel = self.getActionChain('delete');
        			chainDel.execute();
        		}
        	});
		});
	}
})