Ext.define('iih.mr.tth.block.TeethContentBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.TextField',
               'Xap.ej.element.field.DisplayField'],

    alias:'widget.teethcontentblock',
    
    layout: {
        type: 'vbox',
        align:'stretch'
    },
    
    header:false,
    
    border:false,

    defaults: { 
        xtype:'xaptextfield'
    },
    
    items: [{
        hidden: true,
        name: 'teethPk'
    },{
        hidden: true,
        name: 'enPk'
    },{
        hidden: true,
        name: 'examDoctorCd'
    },{
        fieldLabel:'其它',
        name: 'othDesc'
    },{
        fieldLabel:'诊断',
        name: 'diDesc'
    },{
        fieldLabel:'治疗设计',
        name: 'treatDesign'
    },{
        layout: {
            type: 'hbox'
        },
        xtype:'container',
        defaults: { 
            xtype:'xapdisplayfield',
            labelWidth : 100,
            labelAlign:'right'
        },
        items:[{
            xtype: 'container',
            layout: "column",
            flex: 1,
            items:[{
                xtype:'xapdisplayfield',
                fieldLabel:'BOP%',
                labelWidth : 100,
                labelAlign:'right',
                name: 'bop'
            },{
                xtype: "displayfield", 
                value: "%"
            }]
        },{
            fieldLabel:'医生',
            name: 'examDoctorNm',
            width: 200
        },{
            fieldLabel:'日期',
            name: 'examDate',
            renderer: function(value){
                if (value) {
                    var time = Ext.Date.parse(value, 'time');
                    return Ext.util.Format.date(time, 'Y-m-d H:i');
                }
                return '';
            },
            width: 300
        }]
    }],
    
    buttons: [{
        text: '保存',
        iconCls: 'icon-OK',
        action: 'save'
    }],

    trackResetOnLoad:true,
    
    initComponent: function() {
        this.callParent();
    }
})