Ext.define('iih.mr.wr.nmr.action.NmrDocStartApproveAction', {
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
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrStartApprove',false);
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
//            medicalRecord.fileData=plugin.SaveToString();
//            medicalRecord.xmlFileData=plugin.ExportXML();
//            medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
            if(opType=='new'){
                Ext.Msg.alert("提示","提示","只有已经提交的病历才开始审签！");
            }else if(opType=='open'){
            	this.showSubmitProgressBar('iemrEditor');
                this.openPrepareOperations(operations, medicalRecord);
            }
        }
    },
    
    openPrepareOperations: function(operations,medicalRecord) {
        var url=this.url+'/'+medicalRecord.mrPk;
        var operation = {
            url: url,
            method: 'post',
            data:medicalRecord,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
    	this.getOwner().medicalRecord=operation.result.data;
    	var self=this;
//    	setTimeout(function(){
    	var emrSignDisposeAction=self.getOwner().getActionChain("emrSignDispose");
        emrSignDisposeAction.execute();
//    	},1000);
   		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
		disabledOfficeToolBarAction.execute();
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'开始审签失败!');
    }
});
