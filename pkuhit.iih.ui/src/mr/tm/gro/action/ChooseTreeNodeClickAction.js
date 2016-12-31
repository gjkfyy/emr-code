Ext.define('iih.mr.tm.gro.action.ChooseTreeNodeClickAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('-------------------------- ChooseTreeNodeClickAction ------------------------------');
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var page = this.getOwner().ownerCt;
    	var rs = page.down('groupelementchooseeditview');
    	var properties = rs.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	var filePk = properties.data.filePk;
		if(!Ext.isEmpty(filePk, false)){
	        this.openPrepareOperations(operations, filePk);
		}
    },
    openPrepareOperations: function(operations, filePk) {
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
        var self = this;
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
