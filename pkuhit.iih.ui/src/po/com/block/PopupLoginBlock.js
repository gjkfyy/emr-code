Ext.define('iih.po.com.block.PopupLoginBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: ['Xap.ej.element.field.DisplayField',
	           'Xap.ej.element.field.TextField'],

    alias:'widget.popuploginblock',
    
    layout: {
		type: 'vbox'
	},
    
    buttons:[{
            xtype: "button",
            name: 'login',
            action:'login',
            text: '登录',
            iconCls: 'icon-OK',
            marginTop: 100
        },{
            xtype: "button",
            name: 'cancel',
            action:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel',
            handler:function(btn,e){
                var win = this.up('window');
                win.close();
            }
    }],
    
    items:[{
        xtype:'xaptextfield',
        name:'username',
		fieldLabel:'用户名',
		style:{
            marginTop: '10px',
            marginBottom: '0px'
        }
    },{
        xtype:'xaptextfield',
        name:'password',
        inputType:'password',
		fieldLabel:'密码',
		style:{
            marginTop: '10px',
            marginBottom: '10px'
        }
    }/*,{
        xtype:'xapdisplayfield',
        name:'showInfo'
    }*/]
})