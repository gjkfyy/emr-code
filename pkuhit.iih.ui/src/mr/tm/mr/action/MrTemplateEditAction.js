Ext.define('iih.mr.tm.mr.action.MrTemplateEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var view = this.getOwner().ownerCt;
    	var opType = view.opType;
    	var rs = this.getBlock('content');   
    	this.addEditorEvent(rs);
    	if(opType!=undefined){
    		this.showProgress();
            if(opType=='new'){
                var filePk = view.data.basetemplatefilePk;
                this.addPrepareOperations(operations,filePk);
            }else if(opType=='saveAs'){
                var filePk = view.data.filePk;
                console.log(view.data);
                this.addPrepareOperations(operations, filePk);
            }else if(opType=='open'){
                var filePk = view.filePk;
                this.openPrepareOperations(operations, filePk);
            }
        }
    },
    openPrepareOperations: function(operations, filePk) {
//    	filePk = '0A3FA5841F3FA776E050007F01006EAB';
    	var url = this.url+'/'+filePk;
    	 console.log(url);
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
        var mrTemplateEditPage = this.getOwner();
        mrTemplateEditPage.mrTemplate = operation.result;
        var params={
                'objectId':'iemrEditor',
                'sstream':operation.result.data.odtFile,
                'mr_mode':2,
                'readonly':mrTemplateEditPage.readonly,
                'callBackAction':'editorCallBackAction'//编辑器加载完成后要执行的回调Action
        };
        this.insertWriter(mrTemplateEditPage,params);
        this.closeProgress();
    },
    addPrepareOperations: function(operations,filePk) {
    	//filePk = '0A3FA5841F3FA776E050007F01006EAB';
        var url = this.url+'/'+filePk;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onAddSuccess
        };
        operations.push(operation);
    },
    onAddSuccess: function(operation) {
    	var view = this.getOwner().ownerCt;
    	var opType = view.opType;
    	var odtFile = view.data.odtFile;
    	var xmlFile = view.data.xmlFile;
    	var sstream;
        var self=this;
        if(opType=='new'){
        	sstream = operation.result.data.odtFile;
        }else if(opType=='saveAs'){
        	sstream = odtFile;
        }
        var mrTemplateEditPage = this.getOwner();
        var params={
                'objectId':'iemrEditor',
                'sstream':sstream,
                'mr_mode':2,
                'readonly':'false',
                'callBackAction':'editorCallBackAction'//编辑器加载完成后要执行的回调Action
        };
        this.insertWriter(mrTemplateEditPage,params);
        this.closeProgress();
		if(opType=='saveAs'){
			var emrSaveChain = mrTemplateEditPage.getActionChain('emrSave');
	        emrSaveChain.execute({
	        	odtFile:odtFile,
	        	xmlFile:xmlFile
	        });
		}
    }
});
