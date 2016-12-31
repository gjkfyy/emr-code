/** 
 * 病案等级设置（新增、编辑）BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */
var me;
Ext.define('iih.mr.qa.qa_divide_level.block.QaItmSetBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.qaitmsetblock',
    
    layout: {
		type: 'table',
		columns: 2,
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
        xtype:'xaptextfield',
        name:'qaItmCd',
        fieldLabel:'质控项目编码',
        hidden:true
    },{
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
        xtype:'xapcombobox',
        name:'sndCd',
        margin:'10 0 0 0',
        labelAlign : 'right',
        editable:false,
        allOptions: false,
        fieldLabel:'二级分类',
        queryMode: 'local',
        displayField: 'nm',
        valueField: 'sndCd',
        id:'sndCdTip'
    },{
        xtype:'xaptextfield',
        colspan:2,
        width:540,
        name:'req',
		fieldLabel:'项目名称',
		allowBlank:false,
		margin:'10 0 0 0'
    },{
        xtype:'xapcombobox',
        labelAlign : 'right',
        name:'qaDrpScrTpCd',
		fieldLabel:'扣分类型',
		dictionary:'QAM02',
		editable:false,
		allowBlank:false,
		margin:'10 0 0 0'
    },{
        xtype:'xapnumberfield',
        margin:'10 0 0 0',
        name:'onceDrpScr',
		fieldLabel:'单次扣分值',
		labelAlign : 'right',
		allowBlank:false,
		decimalPrecision: 1, //精确1位小数
		maxValue: 100,
		minValue: 0
    },{
        xtype:'xaptextfield',
        name:'deductDes',
		fieldLabel:'扣分描述',
		allowBlank:false,
		margin:'10 0 0 0'
    },{
        xtype:'xapnumberfield',
        margin:'10 0 0 0',
        name:'maxDrpScr',
		fieldLabel:'累计扣分最大值',
		labelAlign : 'right',
		maxValue: 100,
		minValue: 0
    },{
		xtype: 'xapradiogroup',
		fieldLabel:'自动质控标志',
		colspan:2,
		margin:'10 0 0 40',
		items: [
			{boxLabel: '是', name: 'autoQaF',width:85, inputValue: '1'},
			{boxLabel: '否', name: 'autoQaF', width:85,inputValue: '0',checked: true}
		]
	},{
		xtype: 'xapdisplayfield',
		fieldLabel: '',
		colspan:16,
		vertical: true,
		name:'showInfo',
		value: '',
		margin:'0 10 0 0'
	}],
initComponent: function() {
    this.callParent(arguments);
	//当指定控件有显示不全时，自动出现tip提示
	this.addListener('afterrender',this.tip);
},
tip : function(){
	Ext.create('Ext.tip.ToolTip', {
        target: 'sndCdTip',
        anchor: 'buttom',
        anchorOffset: 30,
        trackMouse: true,
    	listeners: {
			beforeshow: function updateTipBody(tip) {
				var textTip = Ext.getCmp('sndCdTip');
				var value = textTip.rawValue;
				tip.update(value);				
			}
		}
      
    });
}
})