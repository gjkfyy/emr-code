Ext.define('iih.sy.params.action.DeleteParamsSetAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override delete
	* 当删除前的列表个数大于等于待删除个数，根据列表grid.store.gridBlock.store.lastOptions 进行查询。树不做操作。
	* 当删除后个数0，按照左上角的条件进行刷新树和列表。
	*/
    doExecute: function(context) {
    	var self = this;
    	var grid = self.getOwner().down('paramssetlistblock');
        var rb = grid.getSelectionModel().getSelection();      
        if(rb.length == 0){
        	 var message = '请选择数据进行删除！！！';
             XapMessageBox.info(message);
        }else{
            var data ={};
            data.paramCd = rb[0].data.paramCd;
            self.prepareOperations(context.operations,data);
        }
    },

    prepareOperations: function(operations,data) {       
        var url = this.url+'/'+data.paramCd;     
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
        //调用模板列表刷新页面
        var view = this.getOwner();
    	var chain = view.getActionChain('init');
        var grid = view.down('paramssetlistblock');
        var pageNum = grid.currentPage;
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");   
        }
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25'
            });
        }
    }
});
