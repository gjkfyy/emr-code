Ext.define('iih.mr.tm.gro.block.GroupElementChooseBlock', {
	extend: 'Xap.ej.block.Block',

	requires: [
	           'iih.mr.tm.gro.block.GroupElementChooseListBlock',
	           'iih.mr.tm.gro.view.GroupElementChooseEditView'
	           ],

	alias:'widget.groupelementchooseblock',
	
	id:'groupelementchooseblock',
	
	border: 0,
	
	layout:'card',
	
	items: [{
        id: 'groupelementchooselistblock',
        name:'groupelementchooselistblock',
        xtype: 'groupelementchooselistblock'
    },{
        id: 'groupelementchooseeditview',
        name:'groupelementchooseeditview',
        xtype: 'groupelementchooseeditview'
    }],
    
    initComponent: function() {
    	this.callParent();
    },
})