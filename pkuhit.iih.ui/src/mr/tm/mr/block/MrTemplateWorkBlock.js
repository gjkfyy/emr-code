Ext.define('iih.mr.tm.mr.block.MrTemplateWorkBlock', {
	extend: 'Xap.ej.block.Block',

	requires: [
	           'iih.mr.tm.mr.block.MrTemplateListBlock',
	           'iih.mr.tm.mr.view.MrTemplateEditView'
	           ],

	alias:'widget.mrtemplateworkblock',
	
	id:'mrtemplateworkblock',
	
	border: 0,
	
	layout:'card',
	
	items: [{
        id: 'mrtemplatelistblock',
        name:'mrtemplatelistblock',
        xtype: 'mrtemplatelistblock'
    },{
        id: 'mrtemplateeditview',
        name:'mrtemplateeditview',
        xtype: 'mrtemplateeditview'
    }],
    
    initComponent: function() {
    	this.callParent();
    },
})