Ext.define('iih.mr.tm.bas.action.BastemplateActivateAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	

	execute: function(context) {
	    var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var block = this.getBlock('result');         
    	var rs =block.down('bastemplateeditview');
    	var properties = rs.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	//打开类型
    	var opType=properties.data.opType;
    	//var code = properties.data.code;
    	this.addEditorEvent(rs);
    	if(opType!=undefined){
            if(opType=='new'){
                this.addPrepareOperations();
            }else if((opType=='upgrade')||(opType=='open')){
            	//filePk为odt文件的主键
            	var filePk = properties.data.filePk;  
                this.openPrepareOperations(operations,filePk);
            }else {
                console.log("error"+"没有打开类型")
            }
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
        var self=this;
        var block = this.getBlock('result');         
        var rs =block.down('bastemplateeditview');
        var params={
                'objectId':'iemrEditor',
                'sstream':operation.result.data.odtFile,
                'mr_mode':2,
                'readonly':"readly"
        };
        var plugin = document.getElementById('iemrEditor');/*
    	var plugin = Ext.get('iemrEditor');*/
    	if(plugin!=null){
    		var objectView =rs.down('objectview');
            rs.remove(objectView);
            //保留直接换掉String
    		//plugin.OpenFromString(operation.result.data.odtFile,1);
         }
    	 this.insertWriter(rs,params);
    	 /*
         //保留直接换掉String
         	else{
         	//更改，闪-objectView的openFromString()编辑器的方法
             this.insertWriter(rs,params);
         }*/
    	 //更改，闪-objectView的openFromString()编辑器的方法
    },
    addPrepareOperations: function() {
        var self=this;
        var block = this.getBlock('result');         
        var rs =block.down('bastemplateeditview');
        var params={
                'objectId':'iemrEditor',
                'sstream':'',
                'mr_mode':2,
                'readonly':'false'
        };
        var plugin = document.getElementById('iemrEditor');
        if(plugin!=null){
        	
    		var objectView =rs.down('objectview');
            rs.remove(objectView);
            //保留直接换掉String
    		//plugin.OpenFromString(operation.result.data.odtFile,1);
         }
        this.insertWriter(rs,params);
    }
});
