Ext.define('iih.mr.wr.nmr.action.NmrDocApprovePostAction', {
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
            if(opType=='new'){
                Ext.Msg.alert("提示","只有已经提交的病历才可审签！");
            }else if(opType=='open'){
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
        plugin.SetReadOnly();
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
