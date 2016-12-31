/** 
 *
 * 日期编辑框
 * @extends Ext.form.field.Date
 * @author：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.field.DateField', {
	extend: 'Ext.form.field.Date',
	alias: 'widget.xapdatefield',
	//默认格式化格式
	format:'Y-m-d',
	//返回该表单项在表单中的值 毫秒
	getSubmitValue: function() {
		var value = this.getValue();
		return value ? value.getTime() : '';
	},
	//设置日期项的值。
	setValue: function(value) {
		//如果传递的是millisecond timestamp格式的日期，转换为Date对象
		if (value) {
			if (Ext.isString(value)) {
				var number = Ext.Number.from(value);
				if (number) {
					value = number;
				}
			}
			if (Ext.isNumber(value)) {
				value = Ext.Date.parse(value, 'time', true);
			}
		}
		this.callParent([value]);
	}
});