
/** 
 *
 * 一个用于简化列定义的子类，用来在单元格里渲染一个或多个图标。 每个图标均可自定义点击处理事件。
 * @extends Ext.grid.column.Action
 * 
 * @author ：chenyajie<chen_yajie@founder.com>
 **/

Ext.define('Xap.ej.element.grid.column.ActionColumn', {
	extend : 'Ext.grid.column.Action',
	alias : ['widget.xapactioncolumn'],
	defaultRenderer: function(v, meta, record, rowIdx, colIdx, store, view){
        var me = this,
            prefix = Ext.baseCSSPrefix,
            scope = me.origScope || me,
            items = me.items,
            len = items.length,
            i = 0,
            item, ret, disabled, tooltip;
 
        // Allow a configured renderer to create initial value (And set the other values in the "metadata" argument!)
        // Assign a new variable here, since if we modify "v" it will also modify the arguments collection, meaning
        // we will pass an incorrect value to getClass/getTip
        ret = Ext.isFunction(me.origRenderer) ? me.origRenderer.apply(scope, arguments) || '' : '';

        meta.tdCls += ' ' + Ext.baseCSSPrefix + 'action-col-cell';
        for (; i < len; i++) {
            item = items[i];

            disabled = item.disabled || (item.isDisabled ? item.isDisabled.call(item.scope || scope, view, rowIdx, colIdx, item, record) : false);
            tooltip = disabled ? null : (item.tooltip || (item.getTip ? item.getTip.apply(item.scope || scope, arguments) : null));

            // Only process the item action setup once.
            if (!item.hasActionConfiguration) {

                // Apply our documented default to all items
                item.stopSelection = me.stopSelection;
                item.disable = Ext.Function.bind(me.disableAction, me, [i], 0);
                item.enable = Ext.Function.bind(me.enableAction, me, [i], 0);
                item.hasActionConfiguration = true;
            }

			
			
			var buttonV ;
			if(item.icon){
				buttonV = '<img alt="' + (item.altText || me.altText) + '" src="' + (item.icon || Ext.BLANK_IMAGE_URL) + '" class="' + Ext.baseCSSPrefix + 'action-col-icon ' + Ext.baseCSSPrefix + 'action-col-' + String(i) + ' ' + (item.disabled ? Ext.baseCSSPrefix + 'item-disabled' : ' ') + (item.iconCls || '') + ' ' + (Ext.isFunction(item.getClass) ? item.getClass.apply(item.scope || me.scope || me, arguments) : (me.iconCls || '')) + '"' + ((item.tooltip) ? ' data-qtip="' + item.tooltip + '"' : '') + ' />';
			}else{
				buttonV = item.text || me.text;
			}	
				
			ret += '<button' + ' class="' + Ext.baseCSSPrefix + 'action-col-' + String(i) + ' ' + (disabled ? Ext.baseCSSPrefix + 'item-disabled' : ' ') 
			+ (item.cls || '') + ' ' + (Ext.isFunction(item.getClass) ? item.getClass.apply(item.scope || scope || me, arguments) : (me.iconCls || '')) 
			+ '"' + ((tooltip) ? ' data-qtip="' + tooltip + '"' : '') 
			+ '>' + buttonV + '</button>';

			
		
		}
        return ret;    
    }
});
