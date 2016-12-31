Ext.define('iih.po.com.block.KnowledgeTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.tree.Tree'
	           ],
	
	alias:'widget.knowledgetreeblock',
	layout: 'fit',
	items:[{
            xtype:'xapformblock',
            layout: {
    		    type: 'vbox',
    		    align: 'stretch'
    		},
            items:[{
 	           xtype:'xaptree',
	           name:'knowledgesTree',
	           flex: 1,
	           ifSelect:true,
	           rootVisible: false,
	           /*treeFields:[{
	   				name : 'content',
	   				type : 'string'
	           }]*/
	       }]
    }],

	setData: function(data) {
	    var tree = this.down('xaptree');
	    var myobj=eval(data);  
	    tree.setData(myobj);
	},
    getData: function() {
        return null;
    }	
    
})