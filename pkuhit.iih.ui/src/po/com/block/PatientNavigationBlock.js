Ext.define('iih.po.com.block.PatientNavigationBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.patientnavigationblock',

    layout: 'fit',

    items: [{
        id: 'patienttree',
        xtype: 'xaptree'
    }],
    
    setData : function(data) {
        var tree = this.down('xaptree');
        tree.setData(data);
    }
        
})