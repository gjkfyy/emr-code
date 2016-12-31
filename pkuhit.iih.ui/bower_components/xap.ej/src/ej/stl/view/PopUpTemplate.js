Ext.define('Xap.ej.stl.view.PopUpTemplate', {
	extend : 'Ext.window.Window',

	requires : [
		'Xap.ej.stl.view.PlaceHolderBlock',
		'Xap.ej.block.ToolbarBlock',
		'Xap.ej.stl.action.PopUpCloseAction',
		'Xap.ej.config.Configable'
	],

	alias : 'widget.xappopuptpl',

	mixins: ['Xap.ej.config.Configable'],
	
	defaultXapConfig: {
		blocks: {
			'content': {
				xclass: 'Xap.ej.stl.view.PlaceHolderBlock',
				height:100
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

		extConfig: {
			border : 0,

			layout : 'fit',

			width: 800,

			height: 600,
		}
	},

	initComponent : function() {
		// TODO 这种方式？加一个noral？
		var extConfig = this.defaultXapConfig.extConfig;
        if(this.xapConfig) {
        	extConfig = Ext.apply(extConfig, this.xapConfig.extConfig);
        }
        Ext.apply(this, extConfig);

		this.callParent();

        this.actions = {};
        this.chains = {};
        this.blocks = {};
        if(this.doCheckXapConfig) {
            this.doCheckXapConfig();
        }
        this.doXapConfig();

		var ca = this.getAction('close');
		if(ca && ca instanceof Xap.ej.stl.action.PopUpCloseAction) {
			ca.setTarget(this);
		}
	},

	getContentBlock : function() {
		return this.getBlock('content');
	}
});
