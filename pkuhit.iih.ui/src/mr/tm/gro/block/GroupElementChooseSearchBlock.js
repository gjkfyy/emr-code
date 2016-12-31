Ext.define('iih.mr.tm.gro.block.GroupElementChooseSearchBlock', {
    extend : 'Xap.ej.block.FormBlock',

    requires: ['Xap.ej.element.field.CustomTrigger'],

    alias:'widget.groupelementchoosesearchblock',

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
            var view = this.up('groupelementchoosetreeview');
            var chain = view.getActionChain('init');
            chain.execute();
            var choose = this.up('groupelementchooseview');
            var right = choose.getActionChain('search');
            right.execute();
        },
        emptyText: ''
    }],
    
    initComponent: function() {
        this.callParent();
    }
})