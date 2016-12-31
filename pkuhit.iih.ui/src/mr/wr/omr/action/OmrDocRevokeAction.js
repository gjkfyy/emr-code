Ext.define('iih.mr.wr.omr.action.OmrDocRevokeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.showSubmitProgressBar('iemrEditor');
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        var opType=this.getOwner().opType;
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrRevoke',false);
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
            plugin.EditDocument();//设置为可编辑模式（因只读状态对编辑器进行的修改SaveToString无法得到）
    //      plugin.ClearMacroValue('MR.M.013.D.26');// 清空一级签名
//            plugin.SetModified(true);
            medicalRecord.fileData=plugin.SaveToString();
            medicalRecord.xmlFileData=plugin.ExportXML();
            if(opType=='new'){
                Ext.Msg.alert("提示","只有已经提交的病历才可撤回！");
            }else if(opType=='open'){
                this.openPrepareOperations(operations, medicalRecord);
            }
        }
    },
    
    openPrepareOperations: function(operations,medicalRecord) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+medicalRecord.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_DELETE,
            data:medicalRecord,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
    	this.getOwner().medicalRecord=operation.result.data;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
//        plugin.EditDocument();
   		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
		disabledOfficeToolBarAction.execute();
		if(CONFIG_PARAM.OMR_SUBMIT_IS_SENDMQ == 1){
            //向集成平台发送mq消息
            var emrSendMq = this.getOwner().getActionChain('emrSendMq');
            if(emrSendMq) {
                emrSendMq.execute({
                    'opt':'-1'
                });
            }
        }
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'撤回失败!');
    }
});
