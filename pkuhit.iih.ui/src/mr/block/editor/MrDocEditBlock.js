Ext.define('iih.mr.block.editor.MrDocEditBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.objectview.ObjectView'],

    alias:'widget.mrdoceditblock',

    //layout: 'fit',
    items: [{
        xtype: "button",
        name: 'editorEvent',
        hidden : true,
        method : 'editorEvent'
    }]
})