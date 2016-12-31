/** 
 * 遮罩类。
 * @author ：白斌(mengxinhua)
 * @extends Ext.LoadMask
 */
Ext.define('Xap.ej.element.window.LoadMask', {
	extend: 'Ext.LoadMask',
	
	requires: [],
	
	alias: 'widget.xaploadmask',
	
	icon: 'css/images/loading.gif',
	
	msg: 'loading',
	
	tpl: '<table>' +
		 '<tr><td align="center"><img src={icon} width="20" height="20"></td>' +
		 '<td align="center">{msg}</td></tr>' +
		 '</table>',
	
	constructor: function() {
		if (arguments.length > 1) this.callParent(arguments);
		else {
			var comp = Ext.getBody();
			var config = {};
			if (arguments.length == 1) {
				if (!arguments[0].isComponent && !Ext.isString(arguments[0])) {
					config = arguments[0];
				} else comp = arguments[0];
			}
			this.callParent([comp, config]);
		}
	},
	
	initComponent: function() {
		var config = this.initialConfig;
		var msg = '加载中...';
		this.data = {
			icon: config.icon || this.icon,
			msg: msg == '' ? config.msg || this.msg : msg
		};
		var tpl = Ext.create('Ext.XTemplate', this.tpl);
		this.msg = tpl.apply(this.data);
		
		this.callParent();
	}
});