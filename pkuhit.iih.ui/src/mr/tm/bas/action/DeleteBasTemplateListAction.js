Ext.define('iih.mr.tm.bas.action.DeleteBasTemplateListAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override  点击发布按钮，更新模板状态url：basTemplate,发送方式 put
	*/
    doExecute: function(context) {
    	var grid = this.getBlock('result');//.down('bastemplatelistblock');
        var rb = grid.getSelectionModel().getSelection();      
        if(rb.length == 0){
            var message = '请选模板进行删除~~~';
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
        var chain = owner.getActionChain('init');
        var message = operation.result.data.message;
        var gridBlock = owner.down('bastemplatelistblock');
        var pageNum = gridBlock.currentPage;
//        XapMessageBox.info(message);
        if(!chain) {
            //如果没找到chain执行结果
            console.log(chain);            
        }
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25'
            });
        }
    }
});
