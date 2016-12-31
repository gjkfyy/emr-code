Ext.define('iih.mr.tm.mr.action.DeleteMrTemplateListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override delete
	* 当删除前的列表个数大于等于待删除个数，根据列表grid.store.gridBlock.store.lastOptions 进行查询。树不做操作。
	* 当删除后个数0，按照左上角的条件进行刷新树和列表。
	*/
    doExecute: function(context) {
    	var self = this;
    	var grid = self.getBlock('result').down('mrtemplatelistblock');
        var rb = grid.getSelectionModel().getSelection();      
        if(rb.length == 0){
        	 var message = '请选模板进行删除~~~';
             XapMessageBox.info(message);
        }else{
        	/*var msg = '确认删除？';
        	XapMessageBox.confirm2(msg, function(btn){
        		if(btn=='yes'){
        		}
        	});*/
        	var code =rb[0].data.code;
            var length = rb.length;
            var dataList =[];
            for(var i=0;i<length;i++){
            	dataList.push(rb[i].data.code);
            }
            //参照接口文件，多条记录启用 
            var data ={"ids":dataList};
            self.prepareOperations(context.operations,data);
        }
    },

    prepareOperations: function(operations,data) {       
        var url = this.url;     
        var mclass = null;       
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_DELETE,
            data:data,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    
    onSuccess: function(operation) {
    	
        var owner = this.getOwner();
        console.log(owner);
        var treeBlock = owner.down('mrtemplateTreeBlock');
        var mrTplCCat = treeBlock.down('xapcombobox[name=mrTplCCat]');
		var mrTplTypeCd = treeBlock.down('xapcombobox[name=mrTplTypeCd]');
		var mrTplStatCd = treeBlock.down('xapcombobox[name=mrTplStatCd]');
		var mrTemplateTrigger = treeBlock.down('xaptrigger[name=mrTemplateTrigger]');
		var mrTplCCatValue = mrTplCCat.value;
		var mrTplTypeCdValue = mrTplTypeCd.value;
		var mrTplStatCdValue = mrTplStatCd.value;
		var mrTemplateTriggerValue = mrTemplateTrigger.value;
        var gridBlock = owner.down('mrtemplatelistblock');
        var message = operation.result.data.message;
        //XapMessageBox.info(message);
        /*Ext.MessageBox.show({
            title:'提示',
            msg:message
        });*/
        var chainTree = owner.getActionChain('initTree');
        if(!chainTree) {
            //如果没找到chain执行结果
            console.log("faile");
            console.log(chainTree);            
        }
        if(chainTree) {
        	chainTree.execute({
        		statusCode :mrTplStatCdValue,
				mrCategoryCode :mrTplCCatValue,
				typeCode :mrTplTypeCdValue,
				name:mrTemplateTriggerValue
        	});
        }
    }
});
