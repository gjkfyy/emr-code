
/** 
 *
 * 一个用于简化列定义的子类，适用于日期类型的渲染。 默认转换为本地化的时间，也可配置format属性。
 * @extends Ext.grid.column.Date
 * 
 * @author ：chenyajie<chen_yajie@founder.com>
 **/

Ext.define('Xap.ej.element.grid.column.Date', {
	extend : 'Ext.grid.column.Date',
	alias : ['widget.xapdatecolumn'],
	//默认格式化格式
	format:'Y-m-d H:i',
	renderer: function(value, cellmeta, record, rowIndex, colIndex, store){
		if (value) {
			if (Ext.isNumber(value)) {
				value = new Date(value);
				return Ext.util.Format.date(value, 'Y-m-d H:i');
			}
			return value;
		}
	}
});
