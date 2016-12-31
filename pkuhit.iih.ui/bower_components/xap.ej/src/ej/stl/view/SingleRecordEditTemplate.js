/**
 * @author wujunhui<wu.junhui@founder.com>
 * @docauthor wujunhui<wu.junhui@founder.com>
 * 该模板用于单条记录的编辑。
 */
Ext.define('Xap.ej.stl.view.SingleRecordEditTemplate', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock',
		'Xap.ej.block.ToolbarBlock',
		'Xap.ej.stl.action.SimpleSearchAction',
		'Xap.ej.stl.action.SimpleSaveAction'
	],

	alias : 'widget.xapsinglerecordedittemplate',

	border : 0,

	layout : {
		type: 'vbox',
		align : 'stretch'
	},

	defaultXapConfig: {
		blocks: {
			'content': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				flex: 1
			},

			'toolbar': {
				xclass: 'Xap.ej.block.ToolbarBlock',
				items: [{
					xtype: 'button',
					text: '保存',
					action: 'save'
				}, {
					xtype: 'button',
					text: '取消',
					action: 'cancel'
				}]
			}
		},

		actions: {
			'search': {
				xclass: 'Xap.ej.stl.action.SimpleSearchAction',
				blocks: {
					condition: 'content',
					result: 'content'
				}
			}, 
			'save': {
				xclass: 'Xap.ej.stl.action.SimpleSaveAction',
				blocks: {
					content: 'content'
				}
			}
		},

		chains: {
			'init': ['search'],
			'save': ['save']
		},

		connections: {
			/*
			'content': [{
				// 如果selector为空，则取block本身为事件对象
				event: 'afterrender',
				chain: 'init'
			}], 
			*/

			'toolbar': [{
				selector: 'button[action=save]',
				event: 'click',
				chain: 'save'
			}]
		}
	},

	doCheckXapConfig: function() {
		// TODO 必须包括的Action等等...
	},

	getContentBlock : function() {
		return this.getBlock('content');
	},
	
	getToolbarBlock : function() {
		return this.getBlock('toolbar');
	}
});
