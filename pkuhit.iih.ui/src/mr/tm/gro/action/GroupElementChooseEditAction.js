Ext.define('iih.mr.tm.gro.action.GroupElementChooseEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('-------------------------- GroupElementChooseEditAction ------------------------------');
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var page = this.getOwner().ownerCt;
    	var grid =  page.down('groupelementchooselistblock'); 
		var records = grid.getSelectionModel().getSelection();
		if(records.length>0){
			var filePk = records[0].data.filePk;
	    	var opType=this.getOwner().opType;
	        this.openPrepareOperations(operations, filePk);
		}
    },
    openPrepareOperations: function(operations, filePk) {    
    	//filePk = '0A3FA5841D2BA776E050007F01006EAB';
        var url = this.url+'/'+filePk;
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
        var self=this;
        var page = this.getOwner().ownerCt;
        var rs = page.down('mreditorblock');
        page.odtFile = operation.result.data.odtFile;
        var params={
                'objectId':'iemrEditorChoose',
                'sstream':operation.result.data.odtFile,
                'mr_mode':3,
                'readonly':true
        };
        var plugin = document.getElementById('iemrEditorChoose');
    	if(plugin!=null){
    		var objectView =rs.down('objectview');
            rs.remove(objectView);
         }
        this.insertWriter(rs,params);
        var block = page.down('groupelementchooseblock');
        var layout = block.getLayout();
	    layout.setActiveItem(1);
    }
});
