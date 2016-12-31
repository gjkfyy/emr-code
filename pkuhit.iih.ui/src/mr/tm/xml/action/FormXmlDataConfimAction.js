Ext.define('iih.mr.tm.xml.action.FormXmlDataConfimAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getOwner();
        var tree = view.down('xaptree');
        var roonodes = tree.getRootNode().childNodes;
        var data = {};
        var dataList = [];
        if(roonodes.length>0){
            for(var i=0;i<roonodes.length;i++){
            	dataList.push(roonodes[i].raw);
            }
        }
        data = {'mrFormXml':dataList};
        this.prepareOperations(operations,data);    
    }, 
    
    prepareOperations: function(operations,data) {  
    	var url = this.url;
    	var queryString ='';
    	var mclass = null; 
        var METHODS = this.getInvocationMethods();
        var operation = {
                url: url,
                mclass: mclass,
                method:'PUT',
                data:data,
                scope: this,
                success: this.onSuccess
            };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
    	var me = this;
    	var view = me.getOwner();
    	var result = operation.result.data.resultStr;
    	result = unescape(result.replace(/\\/g, "%"));
    	var plugin = document.getElementById('iemrEditor'); 
    	if(!Ext.isEmpty(result,false)){
    		console.log(result);
    		plugin.ImportEleTableHead(result);
    	}
        // TODO 数据格式就这样了？
    	var win = view.up('window');
        win.close();
        plugin.EnableOCX(true);//设置编辑器可用
    }
});
