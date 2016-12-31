Ext.define('iih.mr.tm.gro.action.GroupElementStatCdChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
	    var groupElementStatCd =context.event.arguments[0].value;
        var operations = context.operations;      
        this.prepareOperations(operations,groupElementStatCd);  
	},  
	 prepareOperations: function(operations,groupElementStatCd) { 
		//当所选为全部 
		if(groupElementStatCd=='ALL'){
			 var url = this.url+'?typeCode='+'MRM11.01'
		}else{
			 var url = this.url+'?typeCode='+'MRM11.01'+'&'+'statusCode='+groupElementStatCd;
		}
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
        var gridBlock =block.down('groupelementsearchlistblock')
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
        	gridBlock.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {        
        	if(m.dataList==null){
        		var empty ={};
        		gridBlock.setData(empty);
        	}else{
            	gridBlock.setData(m.dataList);
        	}
        }
    
    }    
});
