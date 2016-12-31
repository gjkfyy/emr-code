Ext.define('iih.mr.wr.nmr.action.NmrDocRejectAction', {
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
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
            plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_37);// 清空签名
            plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_38);
            plugin.ClearMacroValue(IMER_CONSTANT.MR_ELEMENT_CD_39);
	        plugin.SwitchRedline(0, '');//不记录编辑和不显示审签横迹
	        plugin.ShowRedline(1);//显示审签横迹
            
	         medicalRecord.fileData=plugin.SaveToString();
	         medicalRecord.xmlFileData=plugin.ExportXML();
	         medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
	         if(opType=='new'){
	              Ext.Msg.alert("提示","提示","只有已经提交的病历才可驳回！");
	         }else if(opType=='open'){
	        	 this.showSubmitProgressBar('iemrEditor');
	        	 this.openPrepareOperations(operations, medicalRecord);
	         }
        }
    },
    
    openPrepareOperations: function(operations,medicalRecord) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+medicalRecord.mrPk;
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
        plugin.SetReadOnly();
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
