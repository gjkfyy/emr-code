Ext.define('iih.mr.wr.mr.action.MrDocApprovePostAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var plugin = document.getElementById('iemrEditor');
        var opType=this.getOwner().opType;
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
            medicalRecord.fileData=plugin.SaveToString();
            medicalRecord.xmlFileData=plugin.ExportXML();
            medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
            plugin.SetReadOnly();
            var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
            if(opType=='new'){
                Ext.Msg.alert("提示","只有已经提交的病历才可审签！");
            }else if(opType=='open'){
            	if(context.pic != null || context.pic != undefined){
    	        	var certID = IMER_GLOBAL.certID;
    	        	var certValue = iih.po.com.BJCAUtil.GetSignCert(certID);//证书值
    				var caData= iih.po.com.BJCAUtil.SignedData(certID,plugin.ExportXML());//签名值
    				medicalRecord.certId =certID;
    				medicalRecord.certValue =certValue;
    				medicalRecord.caData = caData;
    	        }
            	this.showSubmitProgressBar('iemrEditor');
                this.openPrepareOperations(operations, medicalRecord);
            }
        }
    },
    
    openPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+data.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        //plugin.SetReadOnly();
        this.getOwner().medicalRecord=operation.result.data;
        //设置编辑器按钮状态
		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
		disabledOfficeToolBarAction.execute();
		plugin.EnableOCX(true);
//        Ext.Msg.alert('提示','审签成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','审签失败!');
    }
});
