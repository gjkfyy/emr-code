Ext.define('iih.mr.wr.mr.block.MrLoginWinBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.TextArea',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.NumberField',
               'Xap.ej.element.field.ComboBoxGrid'],

    alias:'widget.mrloginwinblock',

    border:false,
    
    defaults:{
        labelWidth:90,
        labelAlign:'right'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'loginNm',
        style : 'margin:15px 10px 5px 5px;',
        labelWidth:80,
        colspan: 3,
        height:26,
        width:220,
        fieldLabel:'用户名',
        allowBlank:false,
        blankText:'账号不允许为空！'
    },{
        xtype:'xaptextfield',
        inputType: 'password' ,
        style : 'margin:15px 10px 5px 5px;',
        name:'loginPwd',
        labelWidth:80,
        height:26,
        colspan: 3,
        width:220,
        fieldLabel:'密码',
        allowBlank:false,
        blankText:'密码不允许为空！'
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        style : 'margin:0px 15px 15px 5px;',
        text: '确认',
        handler:function(btn,e){
        }
    },{
        xtype: "button",
        name: 'cancel',
        method:'no',
        style : 'margin:0px 45px 15px 5px;',
        text: '取消',
        handler:function(btn,e){
        	var plugin = document.getElementById('iemrEditor');
            plugin.EnableOCX(true);
        	Ext.getCmp('mrloginwinview').ownerCt.close();
        }
    }],
    
    initComponent: function() {
        this.callParent();
    }
})