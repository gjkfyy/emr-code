// TODO 确保展示的视图唯一，不会重复弹出
Ext.define('Xap.ej.action.PopAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [
        'Xap.ej.action.Action',
        'Xap.ej.stl.action.PopUpCloseAction'
    ],

    defaultConfig: {
        width: 800,
        height: 600,
        layout : 'fit',
        modal: true
    },
	 
    execute: function(context) {
        this.callParent();
        if(this.viewConfig) {
            var config = this.viewConfig;
            Xap.create(config).show();
        }
        else if(context && context.contentConfig && context.contentConfig.xtype) {
            // TODO xtype?
            var windowConfig = Ext.apply({}, this.defaultConfig);
            if(context.width) {
                windowConfig.width = context.width;
                context.width = null;
            }
            if(context.height) {
                windowConfig.height = context.height;
                context.height = null;
            }
            if(context.title) {
                windowConfig.title = context.title;
                context.title = null;
            }

            // 弹出窗口
            var window = Ext.create('Ext.window.Window', windowConfig);

            var contentConfig = context.contentConfig;
            var initChainConfig = contentConfig.initChain;
            contentConfig.initChain = null;

            window.add(contentConfig);
            window.show();

            // 调用初始化Action
            if(initChainConfig) {
                var content = window.down(contentConfig.xtype);
                var chain = content.getActionChain(initChainConfig.name);
                if(chain) {
                    var ctx = initChainConfig.context || {};
                    ctx.parentWindow = window;
                    chain.execute(ctx);
                }
            }
        }
    }
});
