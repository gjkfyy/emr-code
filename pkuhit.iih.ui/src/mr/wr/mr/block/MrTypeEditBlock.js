Ext.define('iih.mr.wr.mr.block.MrTypeEditBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.TextArea',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.NumberField',
               'Xap.ej.element.field.ComboBoxGrid'],

    alias:'widget.mrtypeeditblock',

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
        labelWidth:90,
        labelAlign:'right'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'code',
        hidden: true
    },{
        xtype:'xaptextfield',
        name:'name',
        width: 280,
        fieldLabel:'名称',
        allowBlank:false,
        blankText:'名称不允许为空！'
    },{
        xtype:'xapcombobox',
        name:'mrTpCcatCd',
        //multiSelect:true,
        fieldLabel:'分组',
        valueField : 'code',
        displayField: 'name',
        allowBlank:false,
        editable:false,
        width: 350,
        blankText:'分组不允许为空！'
    },{
        xtype:'xapcombobox',
        name:'encounterTypeCode',
        width: 350,
        labelWidth:90,
        labelAlign:'right',
        fieldLabel:'就诊类型',
        multiSelect:true,
        dictionary:'ENM01',
        allowBlank:false,
        editable:false,
        //displayField: 'name',                   
        //valueField: 'code',
        blankText:'就诊类型不允许为空！'
    },{
        xtype:'xapcombobox',
        name:'signLevelCode',
        width: 280,
        fieldLabel:'审签级别',
        comboData : [
             {"signLevelCode":"MRM02.01", "name":"无需审签"},
             {"signLevelCode":"MRM02.02", "name":"一级审签"},
             {"signLevelCode":"MRM02.03", "name":"二级审签"},
             {"signLevelCode":"MRM02.04", "name":"三级审签"}
        ],
        allowBlank:false,
        editable:false,
        displayField: 'name',                   
        valueField: 'signLevelCode',
        value:'MRM02.01'
    },{
        xtype:'xapcombobox',
        name:'onlyF',
        width: 150,
        fieldLabel:'是否单文书',
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
        name:'newPageF',
        width: 150,
        fieldLabel:'是否换页打印',
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
        name:'permitF',
        width: 150,
        fieldLabel:'非创建本人修改',
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
        xtype:'xapnumberfield',
        name:'sortNo',
        width: 150,
        fieldLabel:'顺序',
        allowDecimals:false,
        minValue:1,
        allowBlank:false,
        blankText:'顺序不允许为空！'
    },{
        xtype:'xaptextarea',
        name:'description',
        rows:3,
        width: 350,
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
                var view = this.up('mrtypeeditview');
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
    },
    
    setListData: function(data) {
        var mrTpCcatCd = this.down('xapcombobox[name=mrTpCcatCd]');
        if(mrTpCcatCd){
            mrTpCcatCd.setData(data);
            var code = this.down('xaptextfield[name=code]').getValue();
            if(code){
                var view = this.up('mrtypeeditview');
                var chain = view.getActionChain('mrTpCcatItmSearch');
                chain.execute({
                    typeCode:code
                });
                var enChain = view.getActionChain('encounterTypeSearch');
                enChain.execute({
                    typeCode:code
                });
            }
        }
    },
    
    setMrTpCcatValue: function(data) {
        var mrTpCcatCd = this.down('xapcombobox[name=mrTpCcatCd]');
        if(mrTpCcatCd){
            var array = new Array();
            Ext.each(data,function(rec){
                if(rec)
                    array.push(rec.mrTypeCustomCode);
            });
            mrTpCcatCd.setValue(array);
        }
    },
    
    setEnTypeValue: function(data) {
        var encounterTypeCode = this.down('xapcombobox[name=encounterTypeCode]');
        if(encounterTypeCode){
            var array = new Array();
            Ext.each(data,function(rec){
                if(rec)
                    array.push(rec.encounterTypeCode);
            });
            encounterTypeCode.setValue(array);
        }
    }
})