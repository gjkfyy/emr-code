Ext.define('iih.mr.tm.mr.action.BaseTplInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
	    this.callParent();
        var operations = context.operations;
        var view = this.getOwner();
        this.prepareOperations(operations);        
	},  
	 prepareOperations: function(operations) {
		//查询已经启用的基础模板
        var condition = '?statusCode='+'MRM06.02';    
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
        var block = this.getBlock('result').down('[name=baseTemplateCode]');      
        var m = operation.result;
        //console.log(m.dataList);
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}else {
				//遍历结果,重新赋值，对于不对应的dataIndex
				var data =m.dataList
				if(data){
					Ext.Array.forEach(data,function(node,index,array){ 
						node.baseTemplateCode = node.name;
					});
					block.setData(m.dataList);
					//console.log(m.dataList);
				}
			}
			//树数据加载完毕后，设置该编辑页面的数据
			var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
			var baseTemplateCodeValue;
			var view = properties.data.sourceView ;
			if(properties.data.customerData=='edit'){
	    	   	var grid = view.down('mrtemplatelistblock');
	    	   	var selectedItemArr,item;
	    	   	if(grid){
	    	   		selectedItemArr = grid.getSelectionModel().getSelection();
		    	   	item = selectedItemArr[0].raw;
		    	   	baseTemplateCodeValue = item.baseTemplateCode ;
	    	   	}else{
	    	   		baseTemplateCodeValue = properties.data.baseTemplateCode;
	    	   	}
	    	   	block.select(baseTemplateCodeValue,false,true);
			}else if(properties.data.customerData=='saveAs'){
				baseTemplateCodeValue = properties.data.baseTemplateCode;
	    	   	block.select(baseTemplateCodeValue,false,true);
			}
		}
    }    
});

