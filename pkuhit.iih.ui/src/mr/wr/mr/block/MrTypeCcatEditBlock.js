Ext.define('iih.mr.wr.mr.block.MrTypeCcatEditBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.TextArea',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.NumberField'],

    alias:'widget.mrtypeccateditblock',

    layout: {
        type: 'table',
        columns: 1,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    
    border:false,
    
    defaults:{
        labelWidth:60,
        labelAlign:'right'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'code',
        hidden: true
    },{
        xtype:'xaptextfield',
        name:'name',
        width: 250,
        fieldLabel:'名称',
        allowBlank:false,
        blankText:'名称不允许为空！'
    },{
        xtype:'xapcombobox',
        name:'continuePrintF',
        width: 120,
        fieldLabel:'是否续打',
        comboData : [
             {"code":0, "value":"否"},
             {"code":1, "value":"是"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:false,
        editable:false,
        value:0
    },{
        xtype:'xapcombobox',
        name:'dctNsF',
        width: 120,
        fieldLabel:'医护标记',
        comboData : [
             {"code":1, "value":"医"},
             {"code":0, "value":"护"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:false,
        editable:false,
        value:1
    },{
        xtype:'xapnumberfield',
        name:'sortNo',
        width: 120,
        fieldLabel:'顺序',
        allowDecimals:false,
        minValue:1,
        allowBlank:false,
        blankText:'顺序不允许为空！'
    },{
        xtype:'xaptextarea',
        name:'description',
        rows:3,
        width: 300,
        fieldLabel:'描述'
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认',
        handler:function(btn,e){
            var form = this.up('xapformblock');
            if(form.isValid()){
                var view = this.up('mrtypeccateditview');
                var chain = view.getActionChain('save');
                chain.execute();
            }
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