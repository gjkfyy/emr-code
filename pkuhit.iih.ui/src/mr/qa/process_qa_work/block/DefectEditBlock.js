/** 
 * 病案等级设置（新增、编辑）BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */
var me;
Ext.define('iih.mr.qa.process_qa_work.block.DefectEditBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.defecteditblock',
    
    layout: {
		type: 'table',
		columns: 1,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%'
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
    	xtype:'xaptextfield',
    	fieldLabel:'缺陷主键',
		name: 'qaFltPk',
		hidden:true
	},{
        xtype:'xapdisplayfield',
        name:'mrName',
		fieldLabel:'病历文书',
		labelAlign : 'right',
		width: 400,
		margin:'10 0 0 0'
    },{
        xtype:'xapdisplayfield',
        name:'req',
        labelAlign : 'right',
		fieldLabel:'缺陷描述',
		width: 400,
		margin:'10 0 0 0'
    },
    {
		xtype : 'xaptextarea',
		fieldLabel : '整改说明',
		//labelWidth:80,
		labelAlign : 'right',
		padding:'10 0 8 0',
		height:70,
		width: 400,
		name: 'rfmDes',
		dataIndex : 'rfmDes'
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