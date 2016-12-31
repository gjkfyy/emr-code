/** 
 *
 * 带查询图标的单文本编辑框
 * @extends Ext.form.field.Trigger
 * @author：yaolijie
 * 
 *
 */
 
 Ext.define('Xap.ej.element.field.CustomTrigger', {
    extend: 'Ext.form.field.Trigger',
    alias: 'widget.xaptrigger',
	triggerBaseCls :'x-text-trigger',
    // override onTriggerClick
    onTriggerClick: function() {
		this.fireEvent("onTriggerClick",this,this.getValue());
    }
});
