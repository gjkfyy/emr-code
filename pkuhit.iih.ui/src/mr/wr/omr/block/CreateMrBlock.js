Ext.define('iih.mr.wr.omr.block.CreateMrBlock',{
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'iih.mr.wr.omr.view.CreateOmrDocView',
               'iih.mr.wr.omr.view.PastMrSelectView',
               'iih.mr.kr.csa.view.CSAKRView'],

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
            title:'按组套选择',
            xtype:'csakrview',
            name:'csakrview',
            height:427,
            visable:false,
//            layout: 'fit',
            border:false,
            autoScroll:true
        },{
            title:'按类别选择',
            name:'createomrdocview',
            xtype:'createomrdocview',
//            layout: 'border',
            border:false,
            autoScroll:true
        },{
            title:'既往病历选择',
            name:'pastmrselectview',
            xtype:'pastmrselectview',
//            layout: 'fit',
            border:false,
            autoScroll:true
        }]
    },{
        xtype:'omrdocpropertyview',
//        layout: 'border',
        border:true
    }]
})