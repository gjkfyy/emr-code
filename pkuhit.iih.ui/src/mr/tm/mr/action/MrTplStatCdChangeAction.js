Ext.define('iih.mr.tm.mr.action.MrTplStatCdChangeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	   doExecute: function(context) {
	        //console.log(context.event.arguments[0].value);
	        var mrTplStatCd =context.event.arguments[0].value;
	        var operations = context.operations; 
	        var owner = this.getOwner().ownerCt;  
	        console.log(owner);
	        var  mrNm =owner.down('[name=mrTemplateTrigger]').value;	
	        if(mrNm==undefined){
	            mrNm=null;
	        }
	        console.log(mrNm);
	        this.prepareOperations(operations,mrNm,mrTplStatCd);
	    }, 
	   prepareOperations: function(operations,mrNm,data) {
	        var url = this.url;
	        url += '/' +mrNm+'/'+ data;   
	        var METHODS = this.getInvocationMethods();
	        var operation = {
	            url: url,
	            mclass: null,
	            method: METHODS.METHOD_GET,
	            condition: null,
	            data:null,
	            scope: this,
	            success: this.onSuccess,
	            fail: this.onFail
	        };
	        operations.push(operation);     
	     },	
	     onFail: function(operation) {
	         Ext.MessageBox.show({
	             title:'提示',
	             msg:'查询失败!!!'
	         });
	     },          
	     onSuccess: function(operation) {
	         var block = this.getBlock('result');
	         var m = operation;
			 if(m)
				block.setData(m.result.data);
	     }    
	    
});
