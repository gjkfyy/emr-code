
/** 
 * 
 * @extend: 'Ext.form.field.Date',
 * 日期区间编辑框
 * @author ：chenyajie
 */  
Ext.define('Xap.ej.element.datetimefield.RangDate', {
	extend: 'Ext.panel.Panel',
	alias: 'widget.rangdate',
	//frame:true,  
	border:false,
	layout: {
		type: 'table',
		columns:4,
		tableAttrs: {　　
			cellpadding: 2,
			cellspacing: 1
		},
		tdAttrs: {　　
			valign: 'left'
		}
	},
    items: [
		{
			xtype: "xaplabel",
			html: '从'
		},{
			xtype: 'xapdatefield',
			name: 'startDate',
			format: 'Y-m-d',
			emptyText: '请选择日期 ...', 
			listeners: {
				change: function( v, newValue, oldValue, eOpts ) {
					var endData = this.up('panel').down('xapdatefield[name=endData]');
					endData.setMinValue( this.getValue( ) );
				}
			}
		},{
			xtype: "xaplabel",
			html: '至'
		}, {
			xtype: 'xapdatefield',
			name: 'endData',
			emptyText: '请选择日期 ...', 
			format: 'Y-m-d',
			listeners: {
				change: function( v, newValue, oldValue, eOpts ) {
					var startDate = this.up('panel').down('xapdatefield[name=startDate]');
					startDate.setMaxValue( this.getValue( ) );
				}
			}
		}
	]
});