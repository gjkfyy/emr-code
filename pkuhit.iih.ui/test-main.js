var netMgr        = require('./test/scripts/NetManager.js');
Ext.onReady(function() {
    Ext.Loader.setConfig({enabled: true});
});

Ext.application({
    requires: [
        'Xap.ej.data.DataManager',
        'iih.po.com.view.App',
		'Xap.ej.block.Canvas',
        'Xap.ej.action.LocalChainExecutor',
        'Xap.ej.action.RemoteChainExecutor2',
        'Xap.ej.action.Chain',

        // plugins
        'iih.po.com.PortalPlugin'
    ],

    name: 'iih_iemr_ui',

    paths: {
        'Xap': './bower_components/xap.ej/src',
        'iih': './src'
    },

    launch: function() {
    	Xap.ej.Net.netMgr = netMgr;
        // 加载插件
        var plugin = Xap.ej.platform.Plugin;
        plugin.load([
            'iih.po.com.PortalPlugin'
        ]);
        
        var app = Xap.getApp();
        app.mainView = {
                    xtype: 'app'
                };
//        app.baseUrl = "http://172.18.65.156:8088/iemr/";
		app.baseUrl = "http://localhost:8081/xap/";
        app.launch();
    }
});