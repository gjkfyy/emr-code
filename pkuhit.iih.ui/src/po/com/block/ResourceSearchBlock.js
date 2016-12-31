Ext.define('iih.po.com.block.ResourceSearchBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.CustomTrigger'],

    alias:'widget.resourcesearchblock',

    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
    border: 0,
    
    padding: '3 3 3 3',

    items: [{
        xtype: 'xaptrigger',
        name: 'keyword',
        onTriggerClick: function() {
            var view = this.up('resourcenavigationview');
            var chain = view.getActionChain('init');
            chain.execute({
                objcd:view.objcd
            });
        },
        emptyText: ''
    }],
    
    initComponent: function() {
        this.callParent();
    }
})