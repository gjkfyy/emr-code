Ext.define('iih.mr.wr.mr.block.XmlShowBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.TextArea',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.NumberField',
               'Xap.ej.element.field.ComboBoxGrid'],

    alias:'widget.xmlshowblock',

//    layout: 'fit',
    
    border:false,
    
    items:[{
        xtype:'xaptextarea',
        name:'mrxml',
        id:'mrxml',
//        disabled:true,
        rows:38,
        width: 800,
//        fieldLabel:''
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认',
        handler:function(btn,e){
        	var win = this.up('window');
            win.close();
        }
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        text: '取消',
        handler:function(btn,e){
            var win = this.up('window');
            win.close();
        }
    }],
    
    initComponent: function() {
        this.callParent();
    }
})