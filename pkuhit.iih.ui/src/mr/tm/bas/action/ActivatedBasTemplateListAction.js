Ext.define('iih.mr.tm.bas.action.ActivatedBasTemplateListAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
    	console.log('--------------------- ActivatedBasTemplateListAction -----------------------------------');
        var grid = this.getBlock('result');//.down('bastemplatelistblock');
        var rb = grid.getSelectionModel().getSelection();         
        //模板id//rb instanceof Array
        if(rb.length == 0){
            var message = '请选模板进行启用~~~';
            XapMessageBox.info(message);
        }else{
            var code =rb[0].data.code;
            console.log(rb);
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
        var chain = owner.getActionChain('init');
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");
            console.log(chain);            
            //chain = owner.getActionChain('init');
        }
        if(chain) {
            chain.execute();
        }
    }
});
