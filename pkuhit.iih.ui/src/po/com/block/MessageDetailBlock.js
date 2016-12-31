Ext.define('iih.po.com.block.MessageDetailBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.DisplayField',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.ComboBoxGrid',
               'Xap.ej.element.field.TextArea'],

    alias:'widget.messagedetailblock',

    layout: {
        type: 'table',
        columns: 2,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            align: 'center'
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    
    border:false,
    
    defaults:{
        labelWidth:60,
        width: 190,
        xtype:'xapdisplayfield'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'mesId',
        hidden: true
    },{
        xtype:'xapdisplayfield',
        name:'sendUserName',
        fieldLabel:'发送人'
    },{
        xtype:'xapdisplayfield',
        name:'sendDate',
        fieldLabel:'发送时间'
    },{
        xtype:'xaptextarea',
        name:'content',
        fieldLabel:'消息内容',
        width:600,
        height : 150,
        colspan:2
    },{
        xtype:'xaptextfield',
        name:'portalCd',
        hidden: true
    },{
        xtype:'xaptextfield',
        name:'menuCd',
        hidden: true
    },{
        xtype:'xaptextfield',
        name:'revisionCd',
        hidden: true
    },{
        dataIndex:'encounterSn',
        hidden:true
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '去处理',
        hidden:true,
        handler:function(btn,e){
            var form = btn.up('messagedetailblock');
            var data = form.getData();
            var view = form.up('messagedetailview');
            var chain = view.getActionChain('jump');
            chain.execute({
                data:data
            });
        }
    },{
        xtype: "button",
        name: 'close',
        method:'close',
        text: '关闭',
        handler:function(btn,e){
            var win = this.up('window');
            win.close();
        }
    }],
    
    initComponent: function() {
        this.callParent();
    }
})