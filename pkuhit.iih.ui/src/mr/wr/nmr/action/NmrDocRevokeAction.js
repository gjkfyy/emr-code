Ext.define('iih.mr.wr.nmr.action.NmrDocRevokeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.showSubmitProgressBar();
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        var opType=this.getOwner().opType;
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrRevoke',false);
        if(opType!=undefined){
            var medicalRecord=this.getOwner().medicalRecord;
            plugin.EditDocument();//设置为可编辑模式（因只读状态对编辑器进行的修改SaveToString无法得到）
            plugin.SetModified(true);
            //            plugin.SwitchRedline(0, IMER_GLOBAL.user.code);//停止记录修订痕迹
            plugin.ClearMacroValue('MR.M.013.D.37');// 清空一级签名
//            plugin.SetModified(true);
            plugin.EnableOCX(true);
            medicalRecord.fileData=plugin.SaveToString();
            medicalRecord.xmlFileData=plugin.ExportXML();
            medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
//            plugin.SetReadOnly();
            if(opType=='new'){
                Ext.Msg.alert("提示","只有已经提交的病历才可撤回！");
            }else if(opType=='open'){
                this.openPrepareOperations(operations, medicalRecord);
            }
/*            var data={
                    'odtFile':plugin.SaveToString()
                    };
            data.actionType='revoke';
            if(opType=='new'){
                
            }else if(opType=='open'){
                data.mrSn=this.getOwner().mrSn;
                this.openPrepareOperations(operations, data);
            }*/
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
//        plugin.EditDocument();
   		var disabledOfficeToolBarAction=this.getOwner().getActionChain("disabledOfficeToolBarAction");
		disabledOfficeToolBarAction.execute();
		var refresh = this.getOwner().ownerCt.getActionChain('refresh');
    	refresh.execute();
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'撤回失败!');
    }
});
