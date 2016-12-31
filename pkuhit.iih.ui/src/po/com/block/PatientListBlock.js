Ext.define('iih.po.com.block.PatientListBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.tree.Tree'],

    alias:'widget.patientlistblock',

    layout: 'fit',
    
    border: 0,
    
    flex: 1,

    items: [{
        xtype: 'xaptree',
        border:0
    }],
    
    setData : function(data) {
        var tree = this.down('xaptree');
        tree.setData(data);
    }
})