Ext.define('iih.sy.params.block.ParamsSetSearchBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.Checkbox'],

    alias:'widget.paramsSetSearchBlock',
    
    layout : {
		type : 'table',
		columns : 8,
		// width: 1024,
		tableAttrs : {
			border : 0,
			cellpadding : 0,
			cellspacing : 1,
			width : '100%',
			height : 25
		},
		tdAttrs : {
			valign : 'left'
		}
	},
    overflowY: 'auto',
    
    border: false,
    
    items: [
			{
        xtype: 'xaptextfield',
        padding:'10 0 0 10',
        name:'conditionNm',
        labelWidth:80,
        width:200,
        fieldLabel:'关键词'
    },{
		xtype: 'xapcheckbox',
		boxLabel : '只显示开关参数',
		checked:false,
		name:'onlyFlag',
		action: 'onlyFlag',
		padding:'0 0 0 0'
			
	}       ]
})