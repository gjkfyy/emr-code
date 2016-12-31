Ext.define('iih.mr.tm.fr.action.FrTplTreeNodeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    doExecute: function(context) {
    	
        var operations = context.operations; 
        var view = this.getOwner();
        var treeBlock = view.down('frtpltreeblock');
        console.log('------------------- FrTplTreeNodeAction ------------------------');
        var data = {},fragmentTplCd='',treeNode;
        var keyword = view.ownerCt.down('[name=keyword]').value;
        if(context.fragmentTplCd!=undefined && !Ext.isEmpty(context.fragmentTplCd,false)){
        	fragmentTplCd = context.fragmentTplCd;
        }else{
        	treeNode = context.event.arguments[1];
        	if(!Ext.isEmpty(treeNode.data.leaf,false)){
            	if(treeNode.data.leaf){
            		fragmentTplCd = treeNode.data.id;
            	}
            }
        }
        data.fragmentTplCd = fragmentTplCd;
        if(!Ext.isEmpty(data.fragmentTplCd,false)){
        	this.showLoading();
        	this.prepareOperations(operations,data);
        }
    }, 
    prepareOperations: function(operations,data) { 
    	var fragmentTplCd = data.fragmentTplCd;
        var url = this.url+"/"+fragmentTplCd;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            params: data,
            data:null,
            scope: this,
            success: this.onSuccess,
        };
        operations.push(operation);	    
	 },
	    
	 onSuccess: function(operation) {
     	var block = this.getBlock('result');
        var areaText =block.down('[name=contentText]');
       	        
        var m = operation.result.data;
        // TODO 数据格式就这样了？
        areaText.setValue(m.contentText);
	 }     
});
