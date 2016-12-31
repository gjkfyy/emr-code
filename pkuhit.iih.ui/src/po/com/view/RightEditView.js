Ext.define('iih.po.com.view.RightEditView', {
	extend: 'Xap.ej.element.tab.Panel',

	requires: ['iih.po.com.view.KnowledgeView',
	           'iih.po.com.view.SpecialCharacterView',
	           'iih.mr.tm.fr.view.FrTplView'],

	alias:'widget.righteditview',

	layout: 'fit',
	
	tabBar: {
	    height:30,
	    layout: {
            type: 'hbox',
            align: 'middle',
            pack: 'end'
        },
	},

    items: [],

    initComponent: function() {
    	this.callParent();
    	this.removeAll();
    	if(this.workscene=='mr'){
    	    this.add({
    	        title:'个人知识库',
    	        xtype:'knowledgeview'
    	    }).show();
    	}else{
    	    this.add({
    	        title:'片段模板',
    	        xtype:'frtplview'
    	    }).show();
    	};
    	this.add({
    	    title:'特殊字符',
            xtype:'specialcharacterview'
    	});
    	var workscene = this.workscene;
    	this.getTabBar().add({
            xtype: 'container',
            layout: {
                type: 'hbox',
                align: 'middle',
                pack: 'end'
            },
            flex: 1,
            items: [{
                xtype: 'button',
                text: '写回病历',
                handler : function() {
                    var tabpanel = this.up('righteditview');
                    var view = tabpanel.down('knowledgeview');
                    view.fireEvent("writeMrDoc");
                },
                hidden:workscene=='mr'?false:true
            },{
                xtype: 'label',
                width: 5
            },{
                xtype: 'button',
                text: '插入',
                handler : function() {
                    var tabpanel = this.up('righteditview');
                    var view = tabpanel.down('frtplview');
                    view.fireEvent("writeMrDoc");
                },
                hidden:workscene=='mr'?true:false
            }]
        });
    }
});