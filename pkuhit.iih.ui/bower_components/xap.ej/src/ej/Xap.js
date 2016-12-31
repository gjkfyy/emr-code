/**
 * @class Xap
 * @singleton
 * @author: wenliming
 */

if (!console) {
	console = {
		log: function() {}
	};
}

var Xap = Xap || {};
(function() {
	
	
    Xap.test = function(){
//    	alert('test');
	};
	
	Xap.mode = 'debug';
	
	/**
	 * 使用该方法输出调试信息.
	 * @param {String} msg 调试信息
	 * @public
	 */
	Xap.debug = function(msg) {
		if(Xap.mode == 'debug') {
			var method = this.debug.caller, prefix='>> ';
			if (method.$owner) {
				prefix = method.$owner.$className + '#' + method.$name + prefix;
			} 
			console.log(prefix + msg);
		}
	};

	Xap.create = function(config) {
		return Ext.create(config);
	};
	
	/*
	Xap.create = function(objectType, config) {
		return Ext.widget(objectType, config);
	};
	*/

	Xap.createAction= function(actionType, config) {
		var action = Ext.widget(actionType,config);
		
    	return Ext.create('Ext.Action',{
    		text: action.text,
    	    handler: function(){
    	        action.execute();
    	    },
    	    iconCls: action.iconCls,
    	    itemId: action.itemId
		});
	};
	
	Xap.doRequest = function(data, callback, scope) {
    	console.log(data);
    	
    	if (Ext.isFunction(callback)) {
    		if (Ext.isFunction(simulateTest)) {
    			data = simulateTest(data);
    			console.log(data);
    			callback.call(scope || null, data);
    		}
    	}
	};

	Xap.getCanvas = function() {
		return Xap.ej.block.Canvas;
	};

	Xap.getLayerFactory = function() {
		return Xap.ej.block.LayerFactory;
	};

	Xap.getApp = function() {
		if(!this.app) {
			this.app = Xap.create({
				xclass: 'Xap.ej.app.Application'
			});
		}
		return this.app;
	};

	Xap.runAction = function(action, context) {
		if(action) {
			var chain = Xap.create({
				xclass: 'Xap.ej.action.Chain'
			});
			chain.addAction(action);
			chain.execute(context || {});
		}
	};
}());