Ext.define('iih.mr.wr.mr.action.MrDocListDeleteAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    doExecute: function(context) {
		var datas = {'mrPk':context.mrPk,'encounterPk':context.encounterSn,'updateCount':context.updateCount};
	    this.prepareOperations(context.operations,datas);
	},
    prepareOperations: function(operations,datas) {
        var url = this.url;
        url += '/' + datas.mrPk;       
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_DELETE,
            condition: null,
            data:datas,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var owner = this.getOwner();
        var chain = owner.getActionChain('init');
        if(chain) {
            chain.execute();
        };
        var chainTask = owner.getActionChain('searchTask');
        if(chainTask) {
            chainTask.execute();
        };
    }
});
