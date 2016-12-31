/** 
 * 引入cis处方录入
 * @author ：wangyanli
 */

Ext.define('iih.mr.wr.omr.block.CreateOrderBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: ['Xap.ej.element.field.ComboBox'],

    alias:'widget.reportblock', 
    
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    
   // height: 640,
    
    border:false,
    
    items:[{
        xtype:'xaptabpanel',
        flex: 1,
        layout: {
            type:'vbox',
            align:'stretch'
        },
        border:false,       
        items:[{
            title:'处方处理',
            groupType:1,
            haveHtml:false,
            html:''
        },{
            title:'门诊草药',
            groupType:2,
            haveHtml:false,
            html:''
        },{
            title:'处置单新',
            groupType:3,
            haveHtml:false,
            html:''
        },{
            title:'检验申请',
            groupType:4,
            haveHtml:false,
            html:''
        },{
            title:'检查申请',
            groupType:5,
            haveHtml:false,
            html:''
        },{
            title:'病理申请',
            groupType:6,
            haveHtml:false,
            html:''
        },{
            title:'手术申请',
            groupType:7,
            haveHtml:false,
            html:'ccc'
        },{
            title:'工作日志',
            groupType:8,
            haveHtml:false,
            html:''
        },{
            title:'申请住院',
            groupType:9,
            haveHtml:false,
            html:''
        },{
            title:'传染卡',
            groupType:10,
            haveHtml:false,
            html:''
        },{
            title:'检查检验模板',
            groupType:11,
            haveHtml:false,
            html:''
        }],
        tabBar: {
            items:[{
                xtype: 'container',
                layout: {
                    type: 'hbox',
                    align: 'middle',
                    pack: 'end',
                    padding: '2 0 0 0'
                },
                flex: 1,
                items: [{
                    xtype: 'tool',
                    itemId: 'refreshBtn',
                    type: 'refresh',
                    tooltip: '刷新',
                    callback:function(owner,tool){
                        var view = owner.up('createorderview');
                        var chain = view.getActionChain('init');
                        chain.execute();
                    }
                },{
                    xtype: 'label',
                    width: 5
                }]
            }]
        }
    }]
       
})