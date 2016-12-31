Ext.define('iih.mr.wr.omr.action.DisabledOfficeToolBarAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    doExecute: function(context) {
        var operations = context.operations;
        var me=this;
        if(!operations) {
            return;
        }
        me.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var url=this.url+'/SYSM01.7';
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
    	var me=this;
		var parms=operation.result.dataList;
		var submitRevokeEnable=true;//是否启用提交撤回流程，默认启用
		if(parms.length>0 ){
			if(parms[0].value!='1'){
				submitRevokeEnable=false;
			}
		}
		function intToBoolean(str){
        	if('1'==str){
        		return true;
        	}else{
        		return false;
        	}
        }
        var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrSubmit = 'com.founder.iemr.editor.toolbar:emrSubmit';//提交
        var emrRevoke = 'com.founder.iemr.editor.toolbar:emrRevoke';//撤销
        var emrDocProperty='com.founder.iemr.editor.toolbar:emrDocProperty';//属性
        var emrStartApprove='com.founder.iemr.editor.toolbar:emrStartApprove';//开始审签
        var emrApprove='com.founder.iemr.editor.toolbar:emrApprove';//审签
        var emrAuditRevoke='com.founder.iemr.editor.toolbar:emrAuditRevoke';//审签撤回
        var emrReject = 'com.founder.iemr.editor.toolbar:emrReject';//驳回
        var emrDocDelete = 'com.founder.iemr.editor.toolbar:emrDocDelete';//删除
        var emrRefreshMacro = 'com.founder.iemr.editor.toolbar:emrRefreshMacro';//刷新宏元素
        var emrRefreshDiagnosis = 'com.founder.iemr.editor.toolbar:emrRefreshDiagnosis';//刷新诊断
        var emrImageLibraries = 'com.founder.iemr.editor.toolbar:emrImageLibraries';//插入图片
        var emrContinuePrint = 'com.founder.iemr.editor.toolbar:emrContinuePrint';//续打
        var emrSelectContinuePrint = 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint';//选页打印
        var emrSaveAsTemplate = 'com.founder.iemr.editor.toolbar:emrSaveAsTemplate';//病历另存为模板
        var emrRefreshOutpatientDisposal='com.founder.iemr.editor.toolbar:emrRefreshOutpatientDisposal';//刷新门诊处置
        var emrPrintSelected="com.founder.iemr.editor.toolbar:emrPrintSelected";//选中位置续打
//        var emrSelectContinuePrint = 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint';//选页续打
//        var emrContinuePrint = 'com.founder.iemr.editor.toolbar:emrContinuePrint';//病历另存为模板
//        var iddMedocalHistory = '';//月经史公式编辑
        
        var mr=me.getOwner().medicalRecord;
        //重新选择模板按钮
        var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
        setTimeout(function() {
        	Ext.MessageBox.hide();
        },150);
        setTimeout(function() {
        	var plugin = document.getElementById('iemrEditor');
            var canSign=intToBoolean(mr.canSign);
            var canCancelSigned=intToBoolean(mr.canCancelSigned);
            var canUpdate=intToBoolean(mr.canUpdate);
            var canDelete=intToBoolean(mr.canDelete);
            var canEdit=intToBoolean(mr.canEdit);
            var canPrint=intToBoolean(mr.canPrint);
            var canErpSign=intToBoolean(mr.canErpSign);
//            var canContinuePrint=intToBoolean(mr.canContinuePrint);
            var canSaveAsTemplate=intToBoolean(mr.canSaveAsTemplate);
            if (mr.mrTypeCustomCode=='MRM14.03'){
    			plugin.SetCommandVisible(emrRefreshOutpatientDisposal,false);
    		}
        	if(me.getOwner().opType=='open'){
        		var mrDelete=Ext.getCmp('mrDelete');
        		mrDelete.setDisabled(!canDelete);
        		if(reSelectTempBtn){
        			reSelectTempBtn.setDisabled(!canEdit);
        		}
        		//plugin.SetCommandEnable(emrSaveAsTemplate,canSaveAsTemplate);
        		plugin.SetCommandEnable(emrSave,canUpdate);
        		plugin.SetCommandEnable(emrSubmit,canSign);
            	plugin.SetCommandEnable(emrRevoke,canCancelSigned);
            	plugin.SetCommandEnable(emrDocDelete,canDelete);
            	plugin.SetCommandEnable(emrRefreshDiagnosis,canEdit);
            	plugin.SetCommandEnable(emrRefreshMacro,canEdit);
            	plugin.SetCommandEnable(emrImageLibraries,canEdit);
            	plugin.SetCommandEnable(emrRefreshOutpatientDisposal,canEdit);
            	plugin.SetCommandVisible(emrSelectContinuePrint,false);
            	var erpSignBtn=Ext.getCmp('erpSignBtn');
            	erpSignBtn.setDisabled(!canErpSign);
            	var serchErpSignBtn=Ext.getCmp('serchErpSignBtn');
            	if(mr.caFileData&&mr.caFileData.length>100){
            		serchErpSignBtn.setDisabled(false);
            	}else{
            		serchErpSignBtn.setDisabled(true);
            	}
            }else{
            	plugin.SetCommandEnable(emrDocProperty,false);
            	plugin.SetCommandEnable(emrRevoke,false);
            	plugin.SetCommandEnable(emrDocDelete,false);
            	if(reSelectTempBtn){
        			reSelectTempBtn.setDisabled(true);
        		}
//            	plugin.SetCommandEnable(emrContinuePrint,false);
            }
        	plugin.SetCommandVisible(emrPrintSelected,false);
        	plugin.SetCommandVisible(emrContinuePrint,false);
        	plugin.SetCommandVisible(emrSubmit,submitRevokeEnable);
        	plugin.SetCommandVisible(emrRevoke,submitRevokeEnable);
        	plugin.UpdateToolbar();
        },450);
    }
});
