/**
 * @author wujunhui<wu.junhui@founder.com>
 * @docauthor wujunhui<wu.junhui@founder.com>
 * 该模板用于数据检索。
 */
Ext.define('Xap.ej.stl.view.SearchTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock',
		'Xap.ej.block.ToolbarBlock',
		'Xap.ej.stl.action.SimpleSearchAction'
	],

	alias : 'widget.xapsearchtemplate',

	border : 0,

	layout : {
		type: 'vbox',
		align : 'stretch'
	},
	
	defaultXapConfig: {
		blocks: {
			'condition': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				height:100
			},
			
			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					text: '检索',
					action: 'search'
				}, {
					xtype: 'button',
					text: '重置',
					action: 'reset'
				}]
			},

			'result': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				flex:1
			}
		},

		actions: {
			'search': {
				xclass: 'Xap.ej.stl.action.SimpleSearchAction',
				blocks: {
					condition: 'condition',
					result: 'result'
				}
			}
		},

		chains: {
			'init': ['search'],
			'search': ['search']
		},

		connections: {
			'condition': [{
				// 如果selector为空，则取block本身为事件对象
				event: 'afterrender',
				chain: 'init'
			}], 
			
			'toolbar': [{
				selector: 'button[action=search]',
				event: 'click',
				chain: 'search'
			}]
		}
	},

	initBlock : function() {
		this.callParent();
	},

	doCheckXapConfig: function() {
		// TODO 必须包括的Action等等...
	},

	getConditionBlock : function() {
		return this.getBlock('condition');
	},
	
	getToolbarBlock : function() {
		return this.getBlock('toolbar');
	},
	
	getResultBlock : function() {
		return this.getBlock('result');
	}
});
