Ext.define('Xap.ej.block.Block', {
	extend : 'Ext.container.Container',

	alias : 'widget.xapblock',

	requires : [
		'Xap.ej.action.ActionFactory',
		'Xap.ej.action.Chain',
		'Xap.ej.block.LayerFactory'
	],

	initComponent : function() {
		this.callParent();
		this.initBlock();
		this.refreshLayers();
	},
	/*
	 * 打开等待遮罩层
	 * author chenyajie
	 */
	openMask : function() {
		this.getEl( ).mask('正在处理中，请稍候......'); 
	},
	/*
	 * 关闭等待遮罩层
	 * author chenyajie
	 */
	closeMask : function() {
		this.getEl( ).unmask(); 
	},
	/*
	 * 初始化Block，考虑在afterrender事件后需要进行事件绑定时被调用
	 */
	initBlock : Ext.emptyFn,

	refreshLayers: Ext.emptyFn,

	getData : Ext.emptyFn,

	setData : Ext.emptyFn,

	getLayer: function(name) {
		if(!name)
			return null;
		if(!this.layers) {
			this.layers = {};
		}
		var l = this.layers[name];
		// canvas层是全局的
		if(!l) {
			// TODO 插件Layer工厂
			var layerFactory = Xap.getLayerFactory();
			l = layerFactory.createLayer(name, this);
			this.layers[name] = l;
		}
		return l;
	},

	isValid : Ext.emptyFn,

	connect : function() {
		var obj, event, chain;
		var length = arguments.length;
		if(length >= 3) {
			var selector = arguments[0];
			obj = this.down(selector);
			event = arguments[1];
			chain = arguments[2];
		}
		else if(length == 2) {
			obj = this;
			event = arguments[0];
			chain = arguments[1];
		}
		/* var obj = this.down(selector);
		if(!obj) {
			obj = this;
		}*/
		if(!event || !chain)
			// TODO log
			return;
		// TODO 避免重复监听一个事件
		obj.on(event, function() {
			Xap.debug('Event[' + event + '] begin...');
			chain.execute({
				event: {
					from: obj,
					name: event,
					arguments: arguments
				}
			});
			Xap.debug('Event[' + event + '] end.');
		});
	},

	// TODO 实现
	disconnect : Ext.emptyFn
});