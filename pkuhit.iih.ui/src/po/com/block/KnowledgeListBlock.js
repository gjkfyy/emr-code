Ext.define('iih.po.com.block.KnowledgeListBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['iih.po.com.block.KnowledgeData','iih.po.model.KnowledgeModel'],

    alias:'widget.knowledgelistblock',

    layout: 'fit',
    
    border: 0,
    
    initComponent: function() {
        var store = Ext.create('Ext.data.Store', {
            model: 'iih.po.model.KnowledgeModel'
        });
        var knowledgeList = this.createKnowledgeView({ store: store });
        this.items = [knowledgeList];
        this.callParent();
    },
    
    createKnowledgeView: function(info) {
        info = info || {};
        var view = 'iih.po.com.block.KnowledgeData';
        var store = Ext.data.StoreManager.lookup(info.store);
        var knowledgeView = Ext.create(view, {
            cls: 'patientnavigationview-list',
            autoScroll: true,
            flex: 1,
            padding: 0,
            store: store,
            trackOver: true,
            overItemCls: 'x-item-over'
        });
        return knowledgeView;
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