Ext.define('iih.po.com.block.ResourceTreeBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.resourcetreeblock',

    layout: 'card',
    
    border: 0,

    items: [{
        xtype: 'xaptree',
        name:'basTree',
        border: 0,
        rootVisible: false
    },{
        xtype: 'xaptree',
        name:'mrTree',
        border: 0,
        rootVisible: false
    },{
        xtype: 'xaptree',
        name:'grpTree',
        border: 0,
        rootVisible: false
    }],
    
    initComponent: function() {
        this.callParent();
    }
})