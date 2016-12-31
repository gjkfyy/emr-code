Ext.define('iih.mr.tm.gro.block.GroupElementChooseTreeBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.groupelementchoosetreeblock',

    border: 0,
    
    layout:'fit',

    items: [{
        xtype: 'xaptree',
        name:'grpTree',
        border: 0,
        expanded:true,
        rootVisible: false
    }],
    
    initComponent: function() {
        this.callParent();
    }
})