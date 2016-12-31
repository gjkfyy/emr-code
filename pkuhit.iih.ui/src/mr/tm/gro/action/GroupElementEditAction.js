Ext.define('iih.mr.tm.gro.action.GroupElementEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var opType=this.getOwner().opType;
    	var rs = this.getBlock('content');   
    	this.addEditorEvent(rs);
    	if(opType!=undefined){
            if(opType=='new'){
                this.addPrepareOperations();
            }else if(opType=='upgrade'){
                this.addPrepareOperations();
            }else if(opType=='open'){
                this.openPrepareOperations(operations, this.getOwner().verBaseTplKc);
            }
        }
    },
    openPrepareOperations: function(operations, strmFileSn) {    	
        var url = this.url+'/'+strmFileSn;
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
        var mrTemplateEditPage=this.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':operation.result.odtFile,
                'mr_mode':2,
                'readonly':operation.result.readonly
        };
        this.insertWriter(mrTemplateEditPage,params);
    },
    addPrepareOperations: function() {
        var self=this;
        var mrTemplateEditPage=this.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':'',
                'mr_mode':2,
                'readonly':'false'
        };
        this.insertWriter(mrTemplateEditPage,params);
    }
});
