Ext.define('iih.po.com.block.SearchPatientForNurseBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.block.ToolbarBlock',
               'Xap.ej.element.form.Form',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.field.RangeDateField',
               'Xap.ej.element.field.ComboBoxGrid',
               'Xap.ej.element.field.TextField',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.searchpatientfornurseblock',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    height: 90,
    
    border:false,

    items:[{
        xtype: 'xapform',
        flex: 1,
        layout: {
            type: 'hbox',
            align: 'middle'
        },
        border:false,
        defaults: {
            labelWidth:60,
            labelAlign:'right'
        },
        items:[{
            xtype:'xaptextfield',
            name:'currentBedCode',
            fieldLabel:'床位号',
            width:160,
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('patientpopfornurseview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'xaptextfield',
            name:'amrNo',
            fieldLabel:'住院号',
            width:160,
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('patientpopfornurseview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'xaptextfield',
            name:'patientName',
            fieldLabel:'姓名',
            width:160,
            listeners:{
                specialkey : function(field, e) {  
                    if (e.getKey() == Ext.EventObject.ENTER) {  
                        var view = this.up('patientpopfornurseview');
                        var initChain = view.getActionChain('init');
                        initChain.execute({}); 
                    }  
                }
            }
        },{
            xtype:'comboxgrid',
            name:'curMgNurId',
            hidden: true,
            disabled: true,
            fieldLabel:'主管护士',
            url: 'employee',
            width:160,
            listWidth:210,
            valueField : 'id',
            displayField: 'name',
            searchParam: {'deptCd': IMER_GLOBAL.department.code},
            columns: [{
               text: '人员id',
               dataIndex: 'id',
               width:70
            },{
               text: '护士姓名',
               flex:1,
               dataIndex: 'name'
            }],
            callback:function(newValue,oldValue,record){
                var view = this.up('patientpopfornurseview');
                var initChain = view.getActionChain('init');
                initChain.execute({
                    curMgNurId:newValue
                });
            }
        },{
            xtype:'rangedatefield',
            name:'finishTime',
            disabled: true,
            fieldLabel:'出院时间'
        }]
    },{
        xtype: 'xaptoolbarblock',
        height: 30,
        items: [{
            xtype: 'button',
            iconCls: 'icon-reset',
            text: '重置',
            action: 'reset',
            handler:function(btn,e){
                var block = btn.up('searchpatientfornurseblock');
                var form = block.down('xapform');
                form.getForm().reset();
                var startDate = block.down('xapdatefield[name=startDate]');
                var endDate = block.down('xapdatefield[name=endDate]');
                startDate.setMaxValue(null);
                endDate.setMinValue(null);
                var view = btn.up('patientpopfornurseview');
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
                var view = btn.up('patientpopfornurseview');
                var block = btn.up('searchpatientfornurseblock');
                var form = block.down('xapform');
                if(form.getForm().isValid()){
                    var chain = view.getActionChain('init');
                    chain.execute();
                }
            }
        }]
    }],
    
    initComponent: function() {
        this.callParent();
        var curMgNurId = this.down('comboxgrid[name=curMgNurId]');
        curMgNurId.searchParam = {'deptCd': IMER_GLOBAL.department.code};
    }
})