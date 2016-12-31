Ext.define('iih.mr.wr.nmr.action.BatchDisabledOfficeToolBarAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    doExecute: function(context) {
    	var opType=this.getOwner().opType;
        function intToBoolean(str){
        	if('1'==str){
        		if("readonly"==opType){
        			return false;
        		}
        		return true;
        	}else{
        		return false;
        	}
        }
    	var plugin = document.getElementById('iemrOpenEditor');
        var me=this;
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
        var emrRefreshReference='com.founder.iemr.editor.toolbar:emrRefreshReference';//刷新引用元素
        var emrPrintSelected="com.founder.iemr.editor.toolbar:emrPrintSelected";//选中位置续打
        var emrPrint = 'com.founder.iemr.editor.toolbar:emrPrint';//打印
//        var emrSelectContinuePrint = 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint';//选页续打
//        var emrContinuePrint = 'com.founder.iemr.editor.toolbar:emrContinuePrint';//病历另存为模板
//        var iddMedocalHistory = '';//月经史公式编辑
        
        var mr=me.getOwner().medicalRecord;
        setTimeout(function() {
        	Ext.MessageBox.hide();
        },150);
        setTimeout(function() {
            	plugin.SetCommandVisible(emrPrint,true);
	    		plugin.SetCommandVisible(emrPrintSelected,false);
	    		plugin.SetCommandEnable(emrSave,false);
	        	plugin.SetCommandEnable(emrSubmit,false);
	        	plugin.SetCommandEnable(emrRevoke,false);
	        	plugin.SetCommandEnable(emrReject,false);
	        	plugin.SetCommandEnable(emrDocDelete,false);
	        	plugin.SetCommandVisible(emrRefreshDiagnosis,false);
	        	plugin.SetCommandEnable(emrRefreshMacro,false);
	        	plugin.SetCommandEnable(emrImageLibraries,false);
	        	plugin.SetCommandEnable(emrStartApprove,false);
	        	plugin.SetCommandEnable(emrApprove,false);
	        	plugin.SetCommandEnable(emrAuditRevoke,false);
	        	plugin.SetCommandVisible(emrContinuePrint,false);
	        	plugin.SetCommandVisible(emrSelectContinuePrint,false);
	        	plugin.UpdateToolbar();
        },450);
    }
});
