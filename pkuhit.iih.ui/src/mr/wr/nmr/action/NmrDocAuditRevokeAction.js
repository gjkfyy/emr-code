Ext.define('iih.mr.wr.nmr.action.NmrDocAuditRevokeAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var m=this;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrAuditRevoke',false);
        var opType=this.getOwner().opType;
        if(opType!=undefined){
        	var medicalRecord=this.getOwner().medicalRecord;
        	medicalRecord.xmlFileData=plugin.ExportXML();
        	medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
            plugin.EditDocument();//设置为可编辑模式（因只读状态对编辑器进行的修改SaveToString无法得到）
            plugin.SetModified(true);
            //          plugin.SwitchRedline(0, '');//停止记录修订痕迹
            var signEleId='';
            if('MRM02.03'==medicalRecord.userSignLevelCode){
            	signEleId='MR.M.013.D.38';// 清空二级签名
            }else if('MRM02.04'==medicalRecord.userSignLevelCode){
            	signEleId='MR.M.013.D.39';// 清空三级签名
            }
            if(''!=signEleId){
            	 plugin.ClearMacroValue(signEleId);// 清空签名
            }
            var d=new Date();
            for(var i=0;i<20;i++){
            	console.log(medicalRecord);
            }
            var e=new Date();
            console.log(e-d);
            plugin.EnableOCX(true);
        	medicalRecord.fileData=plugin.SaveToString();
            if(opType=='new'){
                Ext.Msg.Ext.Msg.alert("提示","提示","只有已经审签的病历才可以审签撤回！");
            }else if(opType=='open'){
            	m.showSubmitProgressBar('iemrEditor');
                m.openPrepareOperations(operations, medicalRecord);
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
    
    openPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+data.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_DELETE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
//        plugin.EditDocument();
        this.getOwner().medicalRecord=operation.result.data;
        var editorCallBackAction = this.getOwner().getActionChain("editorCallBackAction");
		editorCallBackAction.execute();
		var emrSignDisposeAction=this.getOwner().getActionChain("emrSignDispose");
        emrSignDisposeAction.execute();
//        Ext.Msg.alert("提示",'审签撤回成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'审签撤回失败!');
    }
});
