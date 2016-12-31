Ext.define('iih.mr.tm.gro.action.GroupChooseThroughAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		//点击grid上选中的行，对操作权限进行修改
		console.log('--------------------------- GroupChooseThroughAction ---------------------------------------');
		var operations = context.operations;
		var grid =  this.getBlock('result').down('groupelementchooselistblock'); 
		var records = grid.getSelectionModel().getSelection();
		if(records.length>0){
			var filePk = records[0].data.filePk;
			this.openPrepareOperations(operations, filePk);
		}
    },
    openPrepareOperations: function(operations, filePk) {  
    	//filePk = '0A3FA5841D2BA776E050007F01006EAB';
        var url = this.url +'/'+filePk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onOpenSuccess
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
        var self = this;
        var m = operation.result.data;
        var mrDocOdtFile = m.odtFile;
        var owner = this.getOwner().ownerCt;  
        var plugin = document.getElementById('iemrEditor');
		plugin.InsertFromString(mrDocOdtFile,0);
		owner.close();
    }  
});
