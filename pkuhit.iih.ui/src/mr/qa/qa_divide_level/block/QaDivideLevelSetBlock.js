/** 
 * 病案等级设置（新增、编辑）BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.block.QaDivideLevelSetBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.qadividelevelsetblock',
    
    layout: {
		type: 'table',
		columns: 1,
		//width: 1024,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'
//            height:76
        },
        tdAttrs: {
            valign: 'left'
        }
	},
    
    buttons:[{
            xtype: "button",
            name: 'save',
            action:'save',
            text: '确认',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            action:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],
    
    items:[{
        xtype:'xapcombobox',
        name:'lvl',
        margin:'10 0 0 0',
//        padding:'10 0 8 15',
//        labelWidth:80,
//        width:220,
//        labelWidth : 60,
		labelAlign : 'right',
        editable:false,
        allOptions: false,
        fieldLabel:'等级',
        dictionary:'MRM10'
    },{
        xtype:'xapnumberfield',
        name:'minScr',
        labelAlign : 'right',
		fieldLabel:'最低分',
		allowBlank:false,
		margin:'10 0 10 0',
		decimalPrecision: 1, //精确1位小数
		maxValue: 100,
		minValue: 0
    },{
        xtype:'xapnumberfield',
        labelAlign : 'right',
        name:'maxScr',
		fieldLabel:'最高分',
		decimalPrecision: 1, //精确1位小数
		allowBlank:false,
		maxValue: 100,
		minValue: 0
    },{
		xtype: 'xapdisplayfield',
		fieldLabel: '',
		colspan:16,
		vertical: true,
		name:'showInfo',
		value: '',
		margin:'0 10 0 0'
    }]
})