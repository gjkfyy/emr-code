Ext.define('iih.mr.tm.fr.action.FrTplActivatedAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
    	console.log('--------------------- FrTplActivatedAction -----------------------------------');
        var grid = this.getBlock('result');
        var rb = grid.getSelectionModel().getSelection();         
        if(rb.length == 0){
            var message = '请选模板进行启用~~~';
            XapMessageBox.info(message);
        }else{
            var mrFrTplCd =rb[0].data.mrFrTplCd;
            var length = rb.length;
            var dataList =[];
            for(var i=0;i<length;i++){
            	dataList.push(rb[i].data.mrFrTplCd);
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
