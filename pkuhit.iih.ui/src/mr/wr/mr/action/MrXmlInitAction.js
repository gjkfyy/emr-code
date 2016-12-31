Ext.define('iih.mr.wr.mr.action.MrXmlInitAction', {
    extend: 'Xap.ej.action.Action',

    /*
     * @Override
     */
    execute: function(context) {
        var owner = this.getOwner();
        var xml=context.xml;
        var mrxml=Ext.getCmp('mrxml');
        mrxml.setReadOnly(true);
        mrxml.setValue(xml);
    }
});
