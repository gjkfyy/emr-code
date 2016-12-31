Ext.define('iih.mr.wr.mr.action.MrDocRejectAction', {
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
        plugin.EnableOCX(false);
        var opType=this.getOwner().opType;
        var nursePortal=false;
        if(this.getOwner().ownerCt.nursePortal){
        	nursePortal=this.getOwner().ownerCt.nursePortal;
        }
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
            var signEleId='';
            if('MRM02.03'==medicalRecord.userSignLevelCode){
            	signEleId='MR.M.013.D.26';// 清空一级签名
            }else if('MRM02.04'==medicalRecord.userSignLevelCode){
            	signEleId='MR.M.013.D.25';// 清空二级签名
            }
            if(''!=signEleId){
            	 plugin.ClearMacroValue(signEleId);// 清空签名
            }
            plugin.SwitchRedline(0, '');
            plugin.ShowRedline(0);
            if(nursePortal){
            	plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_37);// 清空护士签名
           	 	plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_38);
           	 	plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_39);
           	    plugin.ShowRedline(1);
            }
            medicalRecord.fileData=plugin.SaveToString();
            medicalRecord.xmlFileData=plugin.ExportXML();
            medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
            
            plugin.SetReadOnly();
            var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
            if(opType=='new'){
                Ext.Msg.alert("提示","提示","只有已经提交的病历才可驳回！");
            }else if(opType=='open'){
            	this.showSubmitProgressBar('iemrEditor');
                this.openPrepareOperations(operations, medicalRecord,nursePortal);
            }
        }
    },
    
    openPrepareOperations: function(operations,medicalRecord,nursePortal) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+medicalRecord.mrPk;
        if(nursePortal){
        	url="rejected/nmr/"+medicalRecord.mrPk;
        }
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:medicalRecord,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        //plugin.SetReadOnly();
        plugin.EnableOCX(true);
        this.getOwner().medicalRecord=operation.result.data;
        //设置编辑器按钮状态
		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
		disabledOfficeToolBarAction.execute();
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'驳回失败!');
    }
});
