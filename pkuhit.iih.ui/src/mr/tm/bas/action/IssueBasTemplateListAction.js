Ext.define('iih.mr.tm.bas.action.IssueBasTemplateListAction', {
    extend: 'Xap.ej.action.ServiceInvocation',  
    
    doExecute: function(context) {
        var grid = this.getBlock('result');      
        var rb = grid.getSelectionModel().getSelection();         
        //模板id
        //rb instanceof Array
        if(rb.length == 0){
            Ext.MessageBox.show({
                title:'提示',
                msg:'请选模板进行发布~~~'
            });
        }else{
            var verBaseTplKc =rb[0].data.verBaseTplKc;
            console.log(rb);
            var data ={key:verBaseTplKc,type:'issue'}
            this.prepareOperations(context.operations,data);
        }
    },

    prepareOperations: function(operations,data) {       
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
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
