/** 
 * 删除单条扣分项目的Action
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.score.action.QaScoreDeleteAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override  
	*/
	doExecute: function(context) {
    
    	var me = this;
    	      
    	//获取缺陷一览的 block
		var block = this.getBlock('bottom');
    	
		var grid = block.down("xapgrid");
    	
		var selModel = grid.getSelectionModel();
		
		//var record = context.selModel.getSelection()[0];
		var record  = context.event.arguments[0];
		if(!record){
			return;
		}
		
    	var operations = context.operations;
        if(!operations) {
            return;
        }
        me.prepareOperations(operations,record);
    },
    prepareOperations: function(operations,record){
        var url = this.url+'/'+record.data.qaDivideCd;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_DELETE,
            condition: null,	
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	
 		var initChain = this.owner.getActionChain('init');
 		initChain.execute();
 		
    }
})