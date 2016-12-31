Ext.define('iih.mr.tm.gro.action.ChooseTreeNodeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    doExecute: function(context) {
    	console.log('---------------------- ChooseTreeNodeChangeAction ---------------------------');
        this.operations = context.operations;
        var block = this.getBlock('bottom');
        var page = this.getOwner().ownerCt.ownerCt;
        var right = page.down('groupelementchooseblock');
        var layout = right.getLayout();
        if(context.event.arguments[1].raw.leaf){
        	var gridBlock = page.down('groupelementchooseeditview');
        	var code = context.event.arguments[1].raw.data.code;
        	this.getFilePk(this.operations, code);
        }else{
        	//点击非叶子结点，对树进行查询
        	//按条件查询，修改列表显示
            var data = context.event.arguments[1].raw.data;
            this.prepareOperations(this.operations,data);
        	layout.setActiveItem(0);
        }
    },
    getFilePk:function(operations,code){
    	var url = this.url + '/' + code;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success: this.onFileSuccess,
        };
        operations.push(operation);	
    },
    onFileSuccess: function(operation) {
    	var m = operation.result;
    	var page = this.getOwner().ownerCt.ownerCt;
    	var view = page.down('groupelementchooseview');
    	var block = page.down('groupelementchooseblock');
    	var layout = block.getLayout();
    	if(!Ext.isEmpty(m, false)){
    		var filePk = m.data.filePk;
    		var code = m.data.code;
    		//filePk = '0A3FA5841D2BA776E050007F01006EAB';
    		var gridBlock = block.down('groupelementchooseeditview')
      	   	var properties = gridBlock.getLayer(Xap.ej.block.Layer.PROPERTIES);
             properties.setData({
  	           	opType: 'open',  
  	           	filePk:filePk,
  	            code:code
             });
             var chain = view.getActionChain('beforeClickActivate');
             chain.execute();
             layout.setActiveItem(1);
    	}
    },
    prepareOperations: function(operations,data) { 
    	var typeCode = data.ownerTypeCode;
    	var customCategoryCode = data.customCategoryCode;
    	var ownerTypeCode = data.ownerTypeCode;
    	var ownerCode = data.ownerCode;
        var url = this.url +'?typeCode=MRM11.01'+'&ownerTypeCode='+ownerTypeCode+'&customCategoryCode='+customCategoryCode+'&ownerCode='+ownerCode;    
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
	 onSuccess: function(operation) {
        var page = this.getOwner().ownerCt.ownerCt;
        var gridBlock = page.down('groupelementchooselistblock');
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
