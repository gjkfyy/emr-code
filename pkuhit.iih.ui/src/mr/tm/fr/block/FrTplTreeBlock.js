Ext.define('iih.mr.tm.fr.block.FrTplTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.tree.Tree'
	           ],
	
	alias:'widget.frtpltreeblock',
	layout: 'fit',
	items:[{
            xtype:'xapformblock',
            layout: {
    		    type: 'vbox',
    		    align: 'stretch'
    		},
            items:[{
 	           xtype:'xaptree',
	           name:'frTplTree',
	           flex: 1,
	           ifSelect:true,
	           rootVisible: false
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