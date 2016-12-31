Ext.define('iih.mr.tm.mr.action.MrTemplateActivateAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var block = this.getBlock('result');         
    	var rs =block.down('mrtemplateeditview');
    	var properties = rs.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	//打开类型
    	var opType=properties.data.opType;
    	this.addEditorEvent(rs);

    	if(opType!=undefined){
            if(opType=='new'){
            	//打开基础模板
            	console.log(properties.data.data);
                var basetemplatefilePk = properties.data.data.basetemplatefilePk;                
                this.addPrepareOperations(operations,basetemplatefilePk);
            }else if(opType=='open'){
                var templatefilePk=properties.data.filePk;
                console.log(properties.data);
                this.openPrepareOperations(operations,templatefilePk);
            }
        }
    },
        
    openPrepareOperations: function(operations, filePk) {
        var url = 'mr/basefile/'+filePk;
		//'mr/tpl/template/{id}
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
        var block = this.getBlock('result');         
        var rs =block.down('mrtemplateeditview');
        var params={
                'objectId':'iemrEditor',
                'sstream':operation.result.data.odtFile,
                'mr_mode':2,
                'readonly':operation.result.readonly
        };
        this.insertWriter(rs,params);
    },
    addPrepareOperations: function(operations,baseTemplateCode) {
        var url = this.url+'/'+baseTemplateCode;
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
        var self=this;
        var block = this.getBlock('result');         
        var rs =block.down('mrtemplateeditview');
        var params={
                'objectId':'iemrEditor',
                'sstream':operation.result.data.odtFile,
                'mr_mode':2,
                'readonly':'false'
        };
        this.insertWriter(rs,params);
    }
});
