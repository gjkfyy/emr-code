Ext.define('Xap.ej.stl.block.FlowGridBlock',{
	extend : 'Xap.ej.element.grid.FlowGrid',

	requires: [
		'Xap.ej.template.BaseTemplate',
		'Xap.ej.stl.action.ProcessTaskAction',
		'Xap.ej.stl.action.ProcessDispatchAction'
	],

	alias:'widget.xapflowgridblock',

	// TODO baseTemplate
	mixins : {
		'baseTemplate': 'Xap.ej.template.BaseTemplate'
	},

	// TODO 使用mixins时都需要再实现一次initComponent，研究不需要重复实现initComponent的方法
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},

	defaultXapConfig: {
		blocks: {
		},

		// TODO 大部分Action是单例
		actions: {
			'dispatch': {
				xclass: 'Xap.ej.stl.action.ProcessDispatchAction'
			},
			'task': {
				xclass: 'Xap.ej.stl.action.ProcessTaskAction'
			}
		},

		chains: {
			'dispatch': ['dispatch'],
			// TODO 单实例
			'task': ['task']
		}

		// TODO connections可以绑定this的事件
	},

	initBlock: function() {
		this.mixins.baseTemplate.initBlock.call(this);
		// TODO 在配置connnections中定义事件绑定
		this.connect(
			'tasksubmit', 
			this.getActionChain('dispatch')
		);
	}
})