/** 
 *
 * 时间范围编辑框
 * @extends Ext.form.field.Date
 * @author：mengxinhua<meng_xinhua@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.field.RangeDateField', {
	extend: 'Ext.form.FieldContainer',

	requires: ['Ext.form.FieldContainer','Xap.ej.element.field.DateField'],
	
	alias: 'widget.rangedatefield',
	
	layout: 'hbox',
	
	colspan: 2,
	
	initComponent: function() {
		var config = this.initialConfig;
		this.initConfig(config);
		this.items = [Ext.apply(config.startConfig || {}, this.getStartConfig()), {
			xtype: 'container',
			margin: '2 1 2 1',
			html: '~'
			}, Ext.apply(config.endConfig || {}, this.getEndConfig())];
		
	    this.callParent();
	},
	
	//初始化开始结束验证配置
	initConfig: function(config) {
		config.startConfig = Ext.apply(config.startConfig || {}, {
			xtype: 'container',
			vtype: 'startValue'
		});
		
		config.endConfig = Ext.apply(config.endConfig || {}, {
			xtype: 'container',
			vtype: 'endValue'
		});
	},
	
	getStartConfig: function() {
		return {
			xtype: 'xapdatefield',
			name: 'startDate',
			editable:false,
			fieldType: 'date',
			width: 100
		};
	},
	
	getEndConfig: function() {
		return {
			xtype: 'xapdatefield',
			name: 'endDate',
			editable:false,
			fieldType: 'date',
			width: 100
		};
	}
});