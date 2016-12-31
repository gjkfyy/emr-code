Ext.define('iih.mr.tm.xml.action.FormXmlDataTopInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
        var operations = context.operations;
        var view = this.getBlock('condition').ownerCt.ownerCt;
        var keyword = view.keyword;
        var kwText = view.down('xaptextfield[name=dataResource]');
        kwText.setValue(keyword);
        var data = [];
        if(!Ext.isEmpty(keyword,false)){
        	data.metaElementNm = keyword;
        	data.spellNo = keyword;
        }else{
        	data.metaElementNm = '';
        	data.spellNo = '';
        }
        
        this.prepareOperations(operations,data);    
    }, 
    prepareOperations: function(operations,data) {
        var url = this.url;
        if(Ext.Object.getSize(data) > 0 ){
	        var queryString = Ext.Object.toQueryString(data);
	        url = url + '?'+queryString;
        }
        var mclass = null; 
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method:METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
       
    onSuccess: function(operation) {
    	var me=this;
    	var view = me.getOwner();
    	var block = view.down('formxmldatabuttomblock');
        // TODO 数据格式就这样了？
        if(operation.result.dataList){
        	block.setData(operation.result);
        }else{
        	block.setData([]);
        };
    }
});
