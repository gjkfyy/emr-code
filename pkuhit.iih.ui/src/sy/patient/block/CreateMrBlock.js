Ext.define('iih.sy.patient.block.CreateMrBlock',{
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'iih.sy.patient.view.CreateOmrDocView'],

    alias:'widget.createmrblock',
    id:'createmrblock',
    border:false,
	buttons:[{
            xtype: "button",
            name: 'confim',
            method:'confim',
            text: '确认',
            disable:true,
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],
    items:[{
        xtype:'xaptabpanel',
        layout: 'fit',
        border:false,
        items:[{
            title:'按类别选择',
            name:'createomrdocview',
            xtype:'createomrdocview',
//            layout: 'border',
            border:false,
            autoScroll:true
        }]
    },{
        xtype:'omrdocpropertyview',
        border:true
    }]
})