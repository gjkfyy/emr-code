Ext.define('iih.po.outp.block.OutpPatientListBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['iih.po.outp.block.OutpPatientData',
               'Ext.view.View',
               'Xap.ej.element.tab.Panel',
               'iih.po.model.PatientModel'],

    alias:'widget.outppatientlistblock',

    layout: 'fit',
    
    border: 0,
    
    initComponent: function() {
        var wStore = Ext.create('Ext.data.Store', {
            model: 'iih.po.model.PatientModel'
        });
        var waitlist = this.createPatientView({
            itemId: 'waitlist',
            store: wStore
        });
        var cStore = Ext.create('Ext.data.Store', {
            model: 'iih.po.model.PatientModel'
        });
        var completedlist = this.createPatientView({
            itemId: 'completedlist',
            store: cStore
        });
        var pStore = Ext.create('Ext.data.Store', {
            model: 'iih.po.model.PatientModel'
        });
        var pauselist = this.createPatientView({
            itemId: 'pauselist',
            store: pStore
        });
        this.items = [{
            xtype:'xaptabpanel',
            border: false,
            defaults:{
                border: false,
                autoScroll: true
            },
            items: [{
                title: '待诊',
                statusCd: 'ENM02.02',
                items: [waitlist]
            },{
                title: '诊毕',
                statusCd: 'ENM02.05',
                items: [completedlist]
            },{
                title: '挂起',
                statusCd: 'ENM02.04',
                items: [pauselist]
            }]
        }];
        this.callParent();
    },
    
    createPatientView: function(info) {
        info = info || {};
        var view = 'iih.po.outp.block.OutpPatientData';
        var store = Ext.data.StoreManager.lookup(info.store);
        var patientView = Ext.create(view, {
            itemId: info.itemId,
            cls: 'patientnavigationview-list',
            autoScroll: true,
            flex: 1,
            padding: 0,
            store: store,
            trackOver: true,
            overItemCls: 'x-item-over'
        });
        return patientView;
    },
    
    setData : function(data) {
        console.log(data);
        if(data){
            var waitlist = this.down('dataview[itemId=waitlist]');
            var wStore = waitlist.getStore();
            var completedlist = this.down('dataview[itemId=completedlist]');
            var cStore = completedlist.getStore();
            var pauselist = this.down('dataview[itemId=pauselist]');
            var pStore = pauselist.getStore();
            Ext.each(data,function(rec){
                if(rec.encounterStatusCode == 'ENM02.02')
                    wStore.add(rec);
                if(rec.encounterStatusCode == 'ENM02.05')
                    cStore.add(rec);
                if(rec.encounterStatusCode == 'ENM02.04')
                    pStore.add(rec);
            });
        }
    }
})