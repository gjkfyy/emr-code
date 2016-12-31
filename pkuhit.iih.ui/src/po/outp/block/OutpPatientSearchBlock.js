Ext.define('iih.po.outp.block.OutpPatientSearchBlock', {
extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.block.ToolbarBlock',
               'Xap.ej.element.form.Form',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.field.DateField',
               'Xap.ej.element.field.RangeDateField',
               'Xap.ej.element.field.ComboBoxGrid',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.outppatientsearchblock',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    height: 640,
    
    border:false,
    
    items:[{
        xtype: 'xapform',
        height: 40,
        layout: {
            type: 'hbox',
            align: 'middle'
        },
        border:false,
        defaults: {
            labelWidth:70,
            labelAlign:'right'
        },
        items:[{
            xtype:'xaptextfield',
            name:'patientId',
            fieldLabel:'患者ID',
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('outppatientview');
                        var chain = view.getActionChain('search');
                        chain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'xaptextfield',
            name:'patientName',
            fieldLabel:'患者姓名',
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('outppatientview');
                        var chain = view.getActionChain('search');
                        chain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'rangedatefield',
            name:'enDate',
            fieldLabel:'就诊时间',
            editable:false,
            //value: new Date(),
            listeners:{
                change : function(dateField, newValue, oldValue, e) {
                    var view = this.up('outppatientview');
                    var chain = view.getActionChain('search');
                    chain.execute();
                }
            }
        }]
    },{
        xtype: 'xaptoolbarblock',
        items: [{
            xtype: 'button',
            iconCls: 'icon-reset',
            text: '重置',
            action: 'reset',
            handler:function(btn,e){
                var block = btn.up('outppatientsearchblock');
                var form = block.down('xapform');
                form.getForm().reset();
                var startField = form.down('xapdatefield[name=startDate]');
                var endField = form.down('xapdatefield[name=endDate]');
                startField.setMaxValue(null);
                endField.setMinValue(null);
                var view = btn.up('outppatientview');
                if(form.getForm().isValid()){
                    var chain = view.getActionChain('search');
                    chain.execute();
                }
            }
        },{
            xtype: 'button',
            iconCls: 'icon-Search',
            text: '查询',
            action: 'search',
            handler:function(btn,e){
                var view = btn.up('outppatientview');
                var block = btn.up('outppatientsearchblock');
                var form = block.down('xapform');
                if(form.getForm().isValid()){
                    var chain = view.getActionChain('search');
                    chain.execute();
                }
            }
        }]
    },{
        xtype:'xaptabpanel',
        flex: 1,
        layout: {
            type:'vbox',
            align:'stretch'
        },
        border:false,
        defaults:{
            xtype:'xapgrid',
            selectBy:'pk',
            layout: 'fit',
            border:false,
            pageShow:true,
            pageSize:30,
            flex:1,
            listeners: {
                itemdblclick: function(grid, rec, item, index) {
                    var win = grid.up('window');
                    var block = win.down('outppatientsearchblock');
                    block.changePatient(win,rec.raw);
                }
            }
        },
        items:[{
            title:'待诊患者',
            groupType:1,
            CM_JR_Record: [{
                dataIndex:'pk',
                hidden:true
            },{
                header:'患者ID',
                dataIndex:'patientId',
                width:100
            },{
                header:'门诊号',
                dataIndex:'amrNo',
                width:80
            },{
                header:'姓名',
                dataIndex:'patientName',
                width:100
            },{
                header:'性别',
                dataIndex:'sexName',
                width:60
            },{
                header:'年龄',
                dataIndex:'age',
                width:60
            },{
                header:'就诊时间',
                xtype:'xapdatecolumn',
                dataIndex:'receiveTime',
                width:120
            },{
                header:'就诊次',
                dataIndex:'encounterCount',
                width:60
            },{
                header:'患者身份',
                dataIndex:'paInsurNm',
                width:100
            },{
                header:'主诊断',
                dataIndex:'currentMainDiagnosisName',
                flex:1
            }]
        },{
            title:'已诊患者',
            groupType:2,
            CM_JR_Record: [{
                dataIndex:'pk',
                hidden:true
            },{
                header:'患者ID',
                dataIndex:'patientId',
                width:100
            },{
                header:'门诊号',
                dataIndex:'amrNo',
                width:80
            },{
                header:'姓名',
                dataIndex:'patientName',
                width:100
            },{
                header:'性别',
                dataIndex:'sexName',
                width:60
            },{
                header:'年龄',
                dataIndex:'age',
                width:60
            },{
                header:'就诊时间',
                xtype:'xapdatecolumn',
                dataIndex:'receiveTime',
                width:120
            },{
                header:'就诊次',
                dataIndex:'encounterCount',
                width:60
            },{
                header:'患者身份',
                dataIndex:'paInsurNm',
                width:100
            },{
                header:'主诊断',
                dataIndex:'currentMainDiagnosisName',
                flex:1
            }]
        },{
            title:'全科患者',
            groupType:3,
            CM_JR_Record: [{
                dataIndex:'pk',
                hidden:true
            },{
                header:'患者ID',
                dataIndex:'patientId',
                width:100
            },{
                header:'门诊号',
                dataIndex:'amrNo',
                width:80
            },{
                header:'姓名',
                dataIndex:'patientName',
                width:100
            },{
                header:'性别',
                dataIndex:'sexName',
                width:60
            },{
                header:'年龄',
                dataIndex:'age',
                width:60
            },{
                header:'就诊时间',
                xtype:'xapdatecolumn',
                dataIndex:'receiveTime',
                width:120
            },{
                header:'就诊次',
                dataIndex:'encounterCount',
                width:60
            },{
                header:'患者身份',
                dataIndex:'paInsurNm',
                width:100
            },{
                header:'主诊断',
                dataIndex:'currentMainDiagnosisName',
                flex:1
            }]
        }],
        tabBar: {
            items:[{
                xtype: 'container',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end',
                    padding: '2 0 0 0'
                },
                flex: 1,
                items: [{
                    xtype: 'tool',
                    itemId: 'refreshBtn',
                    type: 'refresh',
                    tooltip: '刷新',
                    callback:function(owner,tool){
                        var view = owner.up('outppatientview');
                        var chain = view.getActionChain('search');
                        chain.execute();
                    }
                },{
                    xtype: 'label',
                    width: 5
                }]
            }]
        }
    }],
    
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        width: 75,
        text: '确认',
        style : 'margin-right:10px',
        handler:function(btn,e){
            var win = this.up('window');
            var block = win.down('outppatientsearchblock');
            var tabpanel = block.down('xaptabpanel');
            var grid = tabpanel.getActiveTab();
            var record = grid.getSelectionModel().getSelection();
            if(record && record.length>0){
                var rec = record[0].raw;
                block.changePatient(win,rec);
            }else{
                XapMessageBox.warn('请选择患者！','',win);
            }
        }
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        width: 75,
        text: '取消',
        handler:function(btn,e){
            var win = this.up('window');
            if(IMER_GLOBAL.encounterSn){
                win.close();
            }else{
                XapMessageBox.warn('请选择患者！','',win);
            }
        }
    }],
    
    initComponent: function() {
        var me = this;
        me.callParent();
        var startField = me.down('xapdatefield[name=startDate]');
        var endField = me.down('xapdatefield[name=endDate]');
        startField.setValue(new Date());
        endField.setValue(new Date());
    },
    
    changePatient: function(win,rec){
        var pk = rec.pk;
        if(pk == IMER_GLOBAL.encounterSn){
            win.close();
        }else{
            var workArea = Ext.getCmp('workareapageview');
            var closePages = new Array();
            var openPages = new Array();
            var openPageCount = 0;
            var tabs = workArea.items.items;
            Ext.each(tabs,function(item){
                if(!item.baseMenu && !item.isItem)
                    closePages.push(item);
                else{
                    openPageCount++;
                    openPages.push(item);
                }
            });
            var callBack = function(patient){
                var canvas = Xap.getCanvas();
                canvas.fireEvent("updatePatient",{patient:patient});
            };
            workArea.callBack = {
                method: callBack,
                params: [rec]
            };
            if(closePages && closePages.length>0){
                workArea.closePages = closePages;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            }else{
                workArea.openPageCount = openPageCount;
                workArea.openPages = openPages;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender2");
                win.close();
            }
        }
    }
});