Ext.define('iih.po.inp.block.PatientSearchBlock', {
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.block.ToolbarBlock',
               'Xap.ej.element.form.Form',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.field.RangeDateField',
               'Xap.ej.element.field.ComboBoxGrid',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.patientsearchblock',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    height: 520,
    
    border:false,
    
    items:[{
        xtype: 'xapform',
        height: 60,
        layout: {
            type: 'hbox',
            align: 'middle'
        },
        border:false,
        defaults: {
            labelWidth:50,
            labelAlign:'right'
        },
        items:[{
            xtype: 'comboxgrid',
            name: 'deptCd',
            fieldLabel: '科室',
            url: 'organization/keyword',//科室查询的url
            listWidth:230,    //gird的宽度
            width:200,        //combo的宽度
            valueField : 'code',//科室编码的字段名
            displayField: 'name',//科室名称的字段名
            columns: [{              //grid的column配置
               text: '科室编码',
               dataIndex: 'code',
               width:80
            },{
               text: '科室',
               flex:1,
               dataIndex: 'name'
            }],
            callback:function(newValue,oldValue,record){
                var view = this.up('inppatientsearchview');
                var initChain = view.getActionChain('init');
                initChain.execute({
                    deptCd:newValue
                });
            }
        },{
            xtype:'rangedatefield',
            fieldLabel:'时间'
        },{
            xtype:'xaptextfield',
            name:'patientId',
            fieldLabel:'患者ID',
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('inppatientsearchview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'xaptextfield',
            name:'amrNo',
            fieldLabel:'住院号',
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('inppatientsearchview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'xaptextfield',
            name:'patientName',
            fieldLabel:'姓名',
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('inppatientsearchview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
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
                var block = btn.up('patientsearchblock');
                var form = block.down('xapform');
                form.getForm().reset();
                var startField = form.down('xapdatefield[name=startDate]');
                var endField = form.down('xapdatefield[name=endDate]');
                startField.setMaxValue(null);
                endField.setMinValue(null);
                var view = btn.up('inppatientsearchview');
                var block = btn.up('patientsearchblock');
                var form = block.down('xapform');
                if(form.getForm().isValid()){
                    var chain = view.getActionChain('init');
                    chain.execute();
                }
            }
        },{
            xtype: 'button',
            iconCls: 'icon-Search',
            text: '查询',
            action: 'search',
            handler:function(btn,e){
                var view = btn.up('inppatientsearchview');
                var block = btn.up('patientsearchblock');
                var form = block.down('xapform');
                if(form.getForm().isValid()){
                    var chain = view.getActionChain('init');
                    chain.execute();
                }
            }
        }]
    },{
        xtype: 'xapgrid',
        flex: 1,
        autoScroll:true,
        pageSize : 30,
        pageShow : true,
        CM_JR_Record: [{
            dataIndex:'pk',
            hidden:true
        },{
            dataIndex:'patientId',
            hidden:true
        },{
            header:'床号',
            dataIndex:'currentBedCode',
            width:60
        },{
            header:'住院号',
            dataIndex:'amrNo',
            width:100
        },{
            header:'患者ID',
            dataIndex:'patientId',
            width:100
        },{
            header:'姓名',
            dataIndex:'patientName',
            width:80
        },{
            header:'性别',
            dataIndex:'sexName',
            width:50
        },{
            header:'年龄',
            dataIndex:'age',
            width:50
        },{
            header:'入院时间',
            xtype:'xapdatecolumn',
            dataIndex:'currentDeptIntoTime',
            flex:1
        },{
            header:'出院时间',
            xtype:'xapdatecolumn',
            dataIndex:'finishTime',
            flex:1
        },{
            header:'经治医师',
            dataIndex:'currentManageDoctorName',
            width:80
        },{
            header:'主诊断',
            dataIndex:'currentMainDiagnosisName',
            flex:1
        }],
        listeners: {
            itemdblclick: function(grid, rec, item, index) {
                var win = grid.up('window');
                var block = win.down('patientsearchblock');
                block.changePatient(win,rec.raw);
            }
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
            var block = win.down('patientsearchblock');
            var grid = block.down('xapgrid');
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
    },
    
    changePatient: function(win,rec){
        var pk = rec.pk;
        if(pk == IMER_GLOBAL.encounterSn){
            win.close();
        }else{
            var workArea = Ext.getCmp('workareapageview');
            var closePages = new Array();
            var tabs = workArea.items.items;
            Ext.each(tabs,function(item){
                if(!item.baseMenu)
                    closePages.push(item);
            });
            if(closePages && closePages.length>0){
                var callBack = function(patient){
                    var canvas = Xap.getCanvas();
                    canvas.fireEvent("updatePatient",{patient:patient});
                    this.close();
                };
                workArea.callBack = {
                    method: callBack,
                    scope: win,
                    params: [rec]
                };
                workArea.closePages = closePages;
                var canvas = Xap.getCanvas();
                canvas.fireEvent("portalRender");
            }else{
                var canvas = Xap.getCanvas();
                canvas.fireEvent("updatePatient",{patient:rec});
                win.close();
            }
        }
    }
})