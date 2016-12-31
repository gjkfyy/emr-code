Ext.define('iih.po.com.block.SetDoctorPopBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.field.DisplayField',
               'Xap.ej.element.field.ComboBox',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.field.ComboBoxGrid'],

    alias:'widget.setdoctorpopblock',

    layout: {
        type: 'table',
        columns: 3,
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
    
    parent:null,
    
    defaults:{
        labelWidth:60,
        width: 190,
        xtype:'xapdisplayfield'
    },
    
    items:[{
        xtype:'xaptextfield',
        name:'pk',
        hidden: true
    },{
        xtype:'xapdisplayfield',
        name:'inpatientNo',
        fieldLabel:'住院号'
    },{
        xtype:'xapdisplayfield',
        name:'patientName',
        fieldLabel:'患者姓名',
        colspan: 2
    },{
        xtype:'xapdisplayfield',
        name:'currentManageDoctorName',
        fieldLabel:'经治医师'
    },{
        xtype:'comboxgrid',
        name:'curMojDctId',
        fieldLabel:'主治医师',
        url: 'employee',
        listWidth:210,
        valueField : 'id',
        displayField: 'name',
        searchParam: {'deptCd': IMER_GLOBAL.department.code},
        columns: [{
           text: '人员id',
           dataIndex: 'id',
           width:70
        },{
           text: '医师姓名',
           flex:1,
           dataIndex: 'name'
        }],

    },{
        xtype:'comboxgrid',
        name:'curDrcDctId',
        fieldLabel:'主任医师',
        url: 'employee',
        listWidth:210,
        valueField : 'id',
        displayField: 'name',
        searchParam: {'deptCd': IMER_GLOBAL.department.code},
        columns: [{
           text: '人员id',
           dataIndex: 'id',
           width:70
        },{
           text: '医师姓名',
           flex:1,
           dataIndex: 'name'
        }],
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认'
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
        var curMojDct = this.down('comboxgrid[name=curMojDctId]');
        curMojDct.searchParam = {'deptCd': IMER_GLOBAL.department.code};
        var curDrcDct = this.down('comboxgrid[name=curDrcDctId]');
        curDrcDct.searchParam = {'deptCd': IMER_GLOBAL.department.code};
    }
})