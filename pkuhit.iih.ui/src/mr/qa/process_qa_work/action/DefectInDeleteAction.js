/** 
 * 删除单条缺陷的Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.DefectInDeleteAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override  
	*/
	doExecute: function(context) {
    
    	var owner = this.getOwner();
    	
    	var me = this;
    	      
    	//获取缺陷一览的 block
		var block = this.getBlock('bottomcontent');
    	
		var record = context;
		/*var defectGrid = block.down('xapgrid');
		
		var selModel = defectGrid.getSelectionModel();
		
		var record = selModel.getSelection()[0];*/
    	
    	var operations = context.operations;
            	if(!operations) {
            		return;
        }
        me.prepareOperations(operations,record);
    	
    },
    prepareOperations: function(operations,record){
        var url = this.url+'/'+record.data.qaFltPk;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_DELETE,
            condition: null,	
           // data:data.data.pk,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        //调用查询Action
    	var owner = this.getOwner();
    	var searchDefectsChain = owner.getActionChain('searchDefectsAction');
    	searchDefectsChain.execute();
    }
})