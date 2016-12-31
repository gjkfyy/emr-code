/** 
 * 病案等级设置（新增、编辑）BLOCK
 * @extends Xap.ej.block.Block
 * @author ：yao_lijie
 */
var me;
Ext.define('iih.mr.qa.qa_divide_level.block.QaItmFstSetBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.qaitmfstsetblock',
    
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
        xtype:'xaptextfield',
        name:'fstCd',
		fieldLabel:'编码',
		hidden:true
    },{
        xtype:'xaptextfield',
        name:'nm',
		fieldLabel:'名称',
       /* validator : function() {  //"vaidator"为该校验属性，设置校验函数  
            var view = this.up('qaitmfstsetview');
            var vaidatorNmChain = view.getActionChain('vaidatorNm');
    		vaidatorNmChain.execute();
        },
 		invalidText : '此项目名已存在！' ,*/
		allowBlank:false,
		margin:'10 0 0 0'
    },{
        xtype:'xapnumberfield',
        name:'score',
		fieldLabel:'评分',
		decimalPrecision: 1, //精确1位小数
		allowBlank:false,
		margin:'10 0 10 0',
		labelAlign : 'right',
		maxValue: 100,
		minValue: 1
    },{
        xtype:'xaptextfield',
        name:'memo',
		fieldLabel:'描述'
    },{
		xtype: 'xapdisplayfield',
		fieldLabel: '',
		colspan:16,
		vertical: true,
		name:'showInfo',
		value: '',
		margin:'0 10 0 0'
	}]
  
    /*checkCompellation :function(){
    	return false;
    }*/
})