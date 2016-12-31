Ext.define('iih.sy.pwd.block.PwdUpdateBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

    alias:'widget.pwdupdateblock',
    
    layout: {
		type: 'table',
		columns: 2,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1,
            width: '100%',
            align: 'center'
        },
        tdAttrs: {
            valign: 'middle'
        }
	},
    
    /*buttons:[{
            xtype: "button",
            name: 'save',
            action:'save',
            text: '保存',
            iconCls: 'icon-OK',
            margin:'0 20 0 330'
        },{
            xtype: "button",
            name: 'cancel',
            action:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' ,
            margin:'0 540 0 0'
    }],*/
    
    items:[{
        xtype:'xaptextfield',
        name:'oldPwd',
        inputType:'password',
		fieldLabel:'原&nbsp;&nbsp;密&nbsp;&nbsp;码22',
		colspan:2,
		margin:'30 0 0 140'
    },{
        xtype:'xaptextfield',
        name:'iemrPassword',
        inputType:'password',
		fieldLabel:'新&nbsp;&nbsp;密&nbsp;&nbsp;码111',
		colspan:2,
		margin:'10 0 0 140',
		maxLength:10,
		minLength:4
    },{
        xtype:'xaptextfield',
        name:'confirmPwd',
        inputType:'password',
		fieldLabel:'确&nbsp;&nbsp;认&nbsp;&nbsp;密&nbsp;&nbsp;码',
		colspan:2,
		margin:'10 0 0 140'
    },{
		xtype: 'xapdisplayfield',
		fieldLabel: '',
		colspan:2,
		vertical: true,
		name:'showInfo',
		value: '',
		margin:'0 0 0 200'
	},{
        xtype: "button",
        name: 'save',
        action:'save',
        text: '保存',
        iconCls: 'icon-OK',
        margin:'10 10 20 230'
    },{
        xtype: "button",
        name: 'cancel',
        action:'cancel',
        text: '取消' ,
        iconCls: 'icon-cancel' ,
        margin:'10 230 20 0'
}]
})