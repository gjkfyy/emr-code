Ext.define('iih.mr.wr.mr.block.MrShareElementEditBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.TextArea',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.NumberField'],

    alias:'widget.mrshareelementeditblock',

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
        labelWidth:75,
        labelAlign:'right'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'mrShareElementCd',
        hidden: true
    },{
        xtype:'xaptextfield',
        name:'nm',
        width: 250,
        fieldLabel:'名称',
        allowBlank:false,
        blankText:'名称不允许为空！'
    }/*,{
        xtype:'xapcombobox',
        name:'category',
        width: 250,
        fieldLabel:'分类编码',
        comboData : [
             {"code":'MR.M.030.D.1', "value":"患者基本信息"},
             {"code":'MR.M.030.D.2', "value":"是"},
             {"code":'MR.M.030.D.3', "value":"是"}
        ],
        displayField: 'value',
        valueField: 'code',
        editable:false
    },{
        xtype:'xapcombobox',
        name:'macroFlag',
        width: 120,
        fieldLabel:'宏元素标识',
        comboData : [
             {"code":'0', "value":"否"},
             {"code":'1', "value":"是"}
        ],
        displayField: 'value',
        valueField: 'code',
        allowBlank:false,
        editable:false,
        value:'0'
    }*/,{
        xtype:'xaptextfield',
        name:'macroFlag',
        hidden: true,
        value:'0'
    },{
        xtype:'xaptextfield',
        name:'spellNo',
        width: 150,
        fieldLabel:'拼音码',
        allowBlank:false,
        blankText:'拼音码不允许为空！'
    },{
        xtype:'xaptextarea',
        name:'des',
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
                var view = this.up('mrshareelementeditview');
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