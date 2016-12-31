Ext.define('iih.mr.wr.mr.action.MrDocSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
        if(context.callback){
        	this.getOwner().callback=context.callback;
        }
	    var plugin = document.getElementById('iemrEditor');
	    plugin.EnableOCX(false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',false);
	    plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',false);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',false);
//	    plugin.UpdateToolbar();
	    var opType=this.getOwner().opType;
	    if(opType!=undefined){
	        var medicalRecord=this.getOwner().medicalRecord;
	        medicalRecord.fileData=plugin.SaveToString();
//	        medicalRecord.docContent=plugin.ExportText();
//	        medicalRecord.actionType='save';
	        var referenceElem=plugin.GetSourceReferenceElem();
//	        console.log(referenceElem);
	        if(referenceElem.length>0){
	            var referenceElemJson=JSON.parse(referenceElem);
	            medicalRecord.referenceElem=referenceElemJson;//得到文档中的引用元素及值
	        }
		    medicalRecord.xmlFileData=plugin.ExportXML();//将文档的xml传到后台
		    medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
		    plugin.SetReadOnly();
		    var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
	        plugin.EditDocument();
	        this.showSubmitProgressBar('iemrEditor');
//	        console.log('------********-------'+opType);
            if(opType=='new'){
                this.addPrepareOperations(operations,medicalRecord);
            }else if(opType=='open'){
            	if(Ext.isEmpty(medicalRecord.mrPk,false)){
//            		console.log('-------------'+opType);
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
        this.getOwner().medicalRecord=returnData.result.data;
        this.callback();
//        plugin.UpdateToolbar();
//        Ext.Msg.alert('提示','保存成功!');
    },
    onAddSuccess: function(returnData) {
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
        this.getOwner().opType='open';
        this.getOwner().medicalRecord=returnData.result.data;
        this.getOwner().mrSn=returnData.result.data.mrPk;
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSave', true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocDelete',true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
        this.callback();
//        plugin.UpdateToolbar();
//        Ext.Msg.alert('提示','保存成功!');
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
