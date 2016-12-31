/** 
 *
 *  时间范围编辑框
 * @extends Ext.button.Button
 * @author：chenyajie<chen_yajie@founder.com>
 * 
 *
 */
Ext.define('Xap.ej.element.field.RangeTimeField', {
	extend: 'Ext.form.field.Time',
	alias: 'widget.rangetimefield',
	
	minValue: '6:00 AM',
	maxValue: '8:00 PM',
	increment: 30,
	anchor: '100%'
});