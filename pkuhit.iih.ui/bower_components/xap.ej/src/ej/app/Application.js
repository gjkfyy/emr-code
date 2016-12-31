Ext.define('Xap.ej.app.Application', {
	requires: [
		'Xap.ej.platform.Plugin',
		'Xap.ej.action.Chain',
		'Xap.ej.action.RemoteChainExecutor2',
		'Xap.ej.CorePlugin',
		'Xap.ej.stl.STLPlugin',
		'Xap.ej.block.Canvas'
	],

	mixins: [
		'Ext.util.Observable'
	],

    launch: function() {
		 	
        // 加载插件
        var plugin = Xap.ej.platform.Plugin;
        plugin.load([
            'Xap.ej.CorePlugin',
            'Xap.ej.stl.STLPlugin'
        ]);

        if(!this.chainExecutor) {
			this.chainExecutor = Xap.create({
				xclass: 'Xap.ej.action.RemoteChainExecutor2'
			});
        }
        if(!this.baseUrl) {
        	this.baseUrl = "http://localhost:8081/";
        }
        this.chainExecutor.baseUrl = this.baseUrl;
		
		Xap.ej.action.Chain.setExecutor(this.chainExecutor);

		if(this.mainView) {
	        // 创建Viewport
	        Ext.create('Ext.container.Viewport', {
	            layout: 'fit',
	            items: [{
	                xtype: this.mainView.xtype
	            }]
	        });
		}
		//*************************************************
		//*****修改基类js默认值 主要解决object挡住遮罩*****
		//*****addby chenyajie 2014.10.22******************
		//****************开始*****************************
		Ext.useShims=true;
		//****************结束***************************** 
    },
	
	loadPlugins: function(plugins) {
        var plugin = Xap.ej.platform.Plugin;
        plugin.load(plugins);
	},

	getBaseUrl: function() {
		// TODO 不是以'/'结尾的话，加上
		return this.baseUrl;
	}
});