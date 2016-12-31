Ext.define('iih.mr.tm.gro.action.GroupElementChooseListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
		console.log('---------------------------- GroupElementChooseListAction -------------------------------------');
	    this.callParent();
        var operations = context.operations;      
        this.prepareOperations(operations);  
	},  
	 prepareOperations: function(operations) { 
		var condition = {};
        condition = Ext.apply(condition,{typeCode:'MRM11.01'});
        var page = this.getOwner().ownerCt;
    	var view = page.down('groupelementchoosetreeview');
    	var form = view.getBlock('top');
    	condition = Ext.apply(condition,form.getData());
    	var qs = Ext.Object.toQueryString(condition);
        var url = this.url+'?' + qs;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,//{typeCode:'MRM11.01'},
            data:null,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);	    
	 },
	 
	 onFail: function(operation) {  
		 alert("fail");
	 },  
     onSuccess: function(operation) {
    	//alert("success");
        var block = this.getBlock('result');
        var gridBlock =block.down('groupelementchooselistblock');
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	gridBlock.setData(m.dataList);
        }
    
    }    
});
