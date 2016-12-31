Ext.define('iih.po.assistant.action.FragmentTplTypeCdChangeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	   doExecute: function(context) {
		    this.callParent();	
		    var owner = this.getOwner();  
	        var operations = context.operations;
	        //console.log(owner.down('[name=fragmentTplTypeCd]'));
	        var  fragmentTplTypeCd =owner.down('[name=fragmentTplTypeCd]').value;	
	        if(fragmentTplTypeCd==undefined){
	        	fragmentTplTypeCd="";
	        }else if(fragmentTplTypeCd=='ALL'){
	        	fragmentTplTypeCd="";
	        };	
	        this.prepareOperations(operations,fragmentTplTypeCd);  
	    }, 
	    prepareOperations: function(operations,fragmentTplTypeCd) {
	    	var empCd = window.userId;
	        var deptCd = window.deptCd;
	        var condition = '?empCd='+empCd+'&deptCd='+deptCd+'&fragmentTplTypeCd='+fragmentTplTypeCd;;  
	        var url = this.url + condition;    
	        var METHODS = this.getInvocationMethods();
	        var operation = {
	            url: url,
	            mclass: null,
	            method: METHODS.METHOD_GET,
	            condition: null,
	            data:condition,
	            scope: this,
	            success: this.onSuccess,
	            //fail: this.onFail
	        };
	        operations.push(operation);	    
		 },
		    
	    onSuccess: function(operation) {
	        var block = this.getBlock('result');
	        var m = operation.result;
			if(m){
				// TODO 数据格式就这样了？
				if(m instanceof Ext.data.Model) {
					block.setData({
						mclass: operation.mclass,
						data: m.getData(true)
					});
				}
				else {
					block.setData(m);
				}
			}
	    }    
	});
