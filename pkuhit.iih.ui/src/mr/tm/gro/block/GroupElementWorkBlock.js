Ext.define('iih.mr.tm.gro.block.GroupElementWorkBlock', {
	extend: 'Xap.ej.block.Block',

	requires: [
	           'iih.mr.tm.gro.block.GroupElementSearchListBlock',
	           'iih.mr.tm.gro.view.GroupElementEditView'
	           ],

	alias:'widget.groupelementworkblock',
	
	id:'groupelementworkblock',
	
	border: 0,
	
	layout:'card',
	
	items: [{
        id: 'groupelementsearchlistblock',
        name:'groupelementsearchlistblock',
        xtype: 'groupelementsearchlistblock'
    },{
        id: 'groupelementeditview',
        name:'groupelementeditview',
        xtype: 'groupelementeditview'
    }],
    
    initComponent: function() {
    	this.callParent();
    },
})