Ext.define('iih.sy.search.action.ClearSearchConditionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: ['Xap.ej.block.Layer'],
	doExecute: function(context) {
		 
	    this.callParent();
	    var pageNum ,pageSize; 
	    var owner = this.getOwner();
		var block = owner.getBlock('condition');
		
	    var data = block.getItemData(block);
	    for(var key in data){
	    	
	    	data[key] = null;
	    }
	    block.setData(data);
	    
	}   
});