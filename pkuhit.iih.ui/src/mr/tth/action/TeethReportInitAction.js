Ext.define('iih.mr.tth.action.TeethReportInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    doExecute: function(context) {
    	this.callParent();
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var url = this.url + '/' + '13';
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.length = 0;
        operations.push(operation);
    },
    
    onSuccess: function(operation){
        if(operation.result){
            var view = this.getOwner();
            var block = this.getBlock('content');
            var reportUrl = operation.result.data.url.trim();
            reportUrl += "&toolbardisplay=top&params=enPk="+view.enPk;
            var htmlStr = {'html':'<iframe align = "center" width="100%" height="100%" src="'+reportUrl+'"> </iframe>'};
            block.add(htmlStr);
        }
    }
});