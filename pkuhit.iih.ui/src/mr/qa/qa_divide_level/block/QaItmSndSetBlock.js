/** 
 * 病案等级设置（新增、编辑）BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */
var me;
Ext.define('iih.mr.qa.qa_divide_level.block.QaItmSndSetBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.qaitmsndsetblock',
    
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
        name:'fstCd',
        margin:'10 0 0 0',
        labelAlign : 'right',
        editable:false,
        allOptions: false,
        fieldLabel:'一级分类',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'fstCd'
    },{
        xtype:'xaptextfield',
        name:'nm',
		fieldLabel:'名称',
		allowBlank:false,
		margin:'10 0 10 0'
    },{
        xtype:'xapnumberfield',
        name:'score',
		fieldLabel:'评分',
		decimalPrecision: 1, //精确1位小数
		labelAlign : 'right',
		maxValue: 100,
		minValue: 1
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