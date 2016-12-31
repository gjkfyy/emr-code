Ext.define('iih.po.inp.block.InpPatientListBlock', {
    extend : 'Xap.ej.block.Block',

    requires: [
        'iih.po.inp.block.InpPatientData',
        'iih.po.model.PatientModel'
    ],

    alias:'widget.inppatientlistblock',

    layout: 'fit',
    
    border: 0,
    
    initComponent: function() {
        var store = Ext.create('Ext.data.Store', {
            model: 'iih.po.model.PatientModel'
        });
        var patientList = this.createPatientView({ store: store });
        this.items = [patientList];
        this.callParent();
    },
    
    createPatientView: function(info) {
        info = info || {};
        var view = 'iih.po.inp.block.InpPatientData';
        var store = Ext.data.StoreManager.lookup(info.store);
        var patientView = Ext.create(view, {
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
        var v = this.down('dataview');
        var store = v.getStore();
        if(data)
            store.loadData(data);
        else
            store.loadData({});
    }
})