Ext.define('Xap.ej.stl.view.MessageBox', {
	extend : 'Xap.ej.stl.view.PopUpTemplate',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock',
		'Xap.ej.stl.action.PopUpCloseAction',
		'Xap.ej.block.ToolbarBlock',
		'Xap.ej.block.Block'
	],

	alias : 'widget.xapmessagebox',

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
					text: '确定',
					action: 'confirm'
				}, {
					xtype: 'button',
					text: '取消',
					action: 'cancel'
				}],
				height: 30
			}
		},

		actions: {
			'close': {
				xclass: 'Xap.ej.stl.action.PopUpCloseAction'
			}
		},

		chains: {
			'close': ['close']
		},

		connections: {
			'toolbar': [{
				selector: 'button[action=cancel]',
				event: 'click',
				chain: 'close'
			}, {
				selector: 'button[action=confirm]',
				event: 'click',
				chain: 'close'
			}]
		},

		extConfig: {
			height: 300,

			width: 500,

			closable: false,

			layout : {
				type: 'vbox',
				align : 'stretch'
			}
		}
	}
});