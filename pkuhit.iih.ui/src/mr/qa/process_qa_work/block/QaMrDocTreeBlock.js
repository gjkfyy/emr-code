Ext.define('iih.mr.qa.process_qa_work.block.QaMrDocTreeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	          'Xap.ej.element.tree.Tree'
	],
	alias:'widget.qamrdoctreeblock',
	
	 layout: 'fit',
	 
	 border:0,
	
	items:[{
	        xtype:'xaptree',
	        autoScroll:true,
//	        height:545,
	        name:'MrDocTree',
	        ifSelect:true,
	        rootVisible: false,
	        border:0
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