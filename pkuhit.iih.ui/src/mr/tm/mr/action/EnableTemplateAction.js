Ext.define('iih.mr.tm.mr.action.EnableTemplateAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
    	var grid = this.getBlock('result').down('mrtemplatelistblock');  
        var rb = grid.getSelectionModel().getSelection();         
        //模板id//rb instanceof Array
        if(rb.length == 0){
            var message = '请选模板进行启用~~~';
            XapMessageBox.info(message);
        }else{
            var code =rb[0].data.code;
            var length = rb.length;
            var dataList =[];
            for(var i=0;i<length;i++){
            	dataList.push(rb[i].data.code);
            }
            //参照接口文件，多条记录启用
            var data ={"ids":dataList};
            this.prepareOperations(context.operations,data);
        }
    },

    prepareOperations: function(operations,data) {       
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
            // fail: this.onFail
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
        var pageNum = gridBlock.currentPage;
        var chain = owner.getActionChain('init');
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");
            console.log(chain);            
        }
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25',
        		statusCode :mrTplStatCdValue,
				mrCategoryCode :mrTplCCatValue,
				typeCode :mrTplTypeCdValue,
				name:mrTemplateTriggerValue
            });
        }
    }
});
