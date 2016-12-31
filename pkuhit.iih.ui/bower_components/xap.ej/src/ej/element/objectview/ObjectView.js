/*
 * 对象视图，用于加载显示Object标签的内容
 * 配置说明：
 * 	object: object配置，用于生成object标签
 * 	param：	object的参数配置
 * @author：chenyajie<chen_yajie@founder.com>
 *
 *## example xapcombobox
 *     @example 
 *	    	Ext.create('Ext.panel.Panel', {				
 *	    	    bodyPadding: 5,  // Don't want content to crunch against the borders				
 *	    	    				
 *	    	    title: 'Panel',				
 *	    		//html: "<object id='plugin0' type='application/x-founderoffice' width='100%' height='500'><param name='onload' value='pluginLoaded' /><PARAM NAME='src' VALUE='d:/demo.odt'> <PARAM NAME='readonly' VALUE='false'></object>",			
 *	    		items: [			
 *	    			{ 		
 *	    				xtype: 'fuiobjectview',	
 *	    				object: {	
 *	    					id: 'iemrEditor',
 *	    					type: 'application/x-founderoffice',
 *	    					width: '100%',
 *	    					height: 500
 *	    				},	
 *	    				param: [{	
 *	    					name: 'src',
 *	    					value:'d:/demo.odt'
 *	    				}]	
 *	    			}		
 *	    		],	
 *	    	    renderTo: Ext.getBody()			
 *	    	});			
 *
 *
 */
 
Ext.define('Xap.ej.element.objectview.ObjectView', {
	extend: 'Ext.panel.Panel',
	
	alias: 'widget.objectview',
	
	header: false,
	
	layout: 'fit',
	
	initComponent: function() {
		var config = this.initialConfig;
		if (config.object) {
			Ext.apply(config.object, { tag: 'object' });
			if (config.param) {
				config.param = Ext.isArray(config.param) ? config.param : [config.param];
				var params = [];
				for (var i = 0; i < config.param.length; i++) {
					var param = config.param[i];
					param = Ext.apply(param, { tag: 'param' });
					params.push(param);
				}
				config.object.children = params;
			}

			this.html = config.object;
		}
		
		this.callParent();
	}
});