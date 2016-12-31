Ext.define('iih.mr.wr.nmr.action.NmrDocSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
        if(context.context&&context.context.callback){
        	this.getOwner().callback=context.context.callback;
        }else{
        	this.getOwner().callback=undefined;
        }
	    var plugin = document.getElementById('iemrEditor');
	    plugin.EnableOCX(false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',false);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',false);
        setTimeout(function() {
        	plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
    	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',true);
    	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',true);
            plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
        },500);
	    var opType=this.getOwner().opType;
	    if(!opType){
	    	opType=this.getOwner().getBlock('right').opType;
	    	this.onClick='doSave';
	    }
	    if(opType!=undefined){
	        var medicalRecord=this.getOwner().medicalRecord;
	        if(this.onClick&&this.onClick=='doSave'){
	        	medicalRecord=this.getOwner().getBlock('right').medicalRecord;
	        }
	        medicalRecord.fileData=plugin.SaveToString();
//	        medicalRecord.docContent=plugin.ExportText();
//	        medicalRecord.actionType='save';
//	        var referenceElem=plugin.GetSourceReferenceElem();
//	        console.log(referenceElem);
//	        if(referenceElem.length>0){
//	            var referenceElemJson=JSON.parse(referenceElem);
//	            medicalRecord.referenceElem=referenceElemJson;//得到文档中的引用元素及值
//	        }
	        medicalRecord.xmlFileData=plugin.ExportXML();
	        this.showSubmitProgressBar();
            if(opType.indexOf('new')>-1){
                this.addPrepareOperations(operations,medicalRecord);
            }else if(opType=='open'){
            	if(Ext.isEmpty(medicalRecord.mrPk,false)){
            		this.addPrepareOperations(operations,medicalRecord);
            	}else{
            		this.openPrepareOperations(operations, medicalRecord);
            	}
            }else if(opType=='reform'){
                this.openPrepareOperations(operations, medicalRecord);
            }else{
            	Ext.Msg.alert('提示','opType：【'+opType+'】不符合要求，只能为【new】、【open】、【reform】！');
            }
        }else{
        	Ext.Msg.alert('提示','opType不能为空！');
        }
    },
    
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    openPrepareOperations: function(operations,medicalRecord) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+medicalRecord.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            data:medicalRecord,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(returnData) {
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',true);
        if(this.onClick&&this.onClick=='doSave'){
        	this.getOwner().getBlock('right').medicalRecord=returnData.result.data;
        }else{
        	this.getOwner().medicalRecord=returnData.result.data;
        }
        this.callback();
//        Ext.Msg.alert('提示','保存成功!');
    },
    onAddSuccess: function(returnData) {
    	var refresh = null;
    	var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
    	if(this.onClick&&this.onClick=='doSave'){
    		refresh = this.getOwner().getActionChain('refresh');
    		this.getOwner().getBlock('right').opType='open';
            this.getOwner().getBlock('right').medicalRecord=returnData.result.data;
            this.getOwner().getBlock('right').mrSn=returnData.result.data.mrPk;
            return;//mengxinhua add
    	}else{
    		refresh = this.getOwner().ownerCt.getActionChain('refresh');
    		this.getOwner().opType='open';
            this.getOwner().medicalRecord=returnData.result.data;
            this.getOwner().mrSn=returnData.result.data.mrPk;
    	}
        refresh.execute({from:'addSuccess'});
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
        this.callback();
    },
    onFail: function(operation) {
    	 plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
    	 plugin.UpdateToolbar();
        Ext.Msg.alert('提示','保存失败!');
    },
    callback: function() {
    	if(this.getOwner().callback){
           var callback=this.getOwner().callback;
           callback();
          }
   }
});
