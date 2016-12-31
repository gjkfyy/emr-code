Ext.define('iih.mr.wr.mr.action.QaDisabledOfficeToolBarAction',{
    extend : 'Xap.ej.action.ServiceInvocation',

	/*
	* @Override
	*/
	doExecute : function(context) {
		var operations = context.operations;
		if (!operations) {
			return;
		}
		function intToBoolean(str) {
			if ('1' == str) {
				return true;
			} else {
				return false;
			}
		}
		var me = this;
		var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
		var emrSubmit = 'com.founder.iemr.editor.toolbar:emrSubmit';//提交
		var emrRevoke = 'com.founder.iemr.editor.toolbar:emrRevoke';//撤销
		var emrStartApprove = 'com.founder.iemr.editor.toolbar:emrStartApprove';//开始审签
		var emrApprove = 'com.founder.iemr.editor.toolbar:emrApprove';//审签
		var emrAuditRevoke = 'com.founder.iemr.editor.toolbar:emrAuditRevoke';//审签撤回
		var emrReject = 'com.founder.iemr.editor.toolbar:emrReject';//驳回
		var emrDocDelete = 'com.founder.iemr.editor.toolbar:emrDocDelete';//删除
		var emrRefreshMacro = 'com.founder.iemr.editor.toolbar:emrRefreshMacro';//刷新宏元素
		var emrRefreshDiagnosis = 'com.founder.iemr.editor.toolbar:emrRefreshDiagnosis';//刷新诊断
		var emrImageLibraries = 'com.founder.iemr.editor.toolbar:emrImageLibraries';//插入图片
		var emrContinuePrint = 'com.founder.iemr.editor.toolbar:emrContinuePrint';//续打
		var emrSelectContinuePrint = 'com.founder.iemr.editor.toolbar:emrSelectContinuePrint';//选页打印
		var emrPrint='com.founder.iemr.editor.toolbar:emrPrint';//打印
		var emrSaveAsTemplate = 'com.founder.iemr.editor.toolbar:emrSaveAsTemplate';//病历另存为模板
//      var iddMedocalHistory = '';//月经史公式编辑
		setTimeout(function() {
		var plugin = document.getElementById('iemrEditor');
		if (me.getOwner().opType == 'reform') {
			plugin.SetCommandVisible(emrPrint, false);
			plugin.SetCommandVisible(emrSubmit, false);
			plugin.SetCommandVisible(emrRevoke, false);
			plugin.SetCommandVisible(emrReject, false);
			plugin.SetCommandVisible(emrDocDelete, false);
			plugin.SetCommandVisible(emrStartApprove, false);
			plugin.SetCommandVisible(emrApprove, false);
			plugin.SetCommandVisible(emrAuditRevoke, false);
			plugin.SetCommandVisible(emrSelectContinuePrint, false);
			plugin.SetCommandVisible(emrContinuePrint, false);
			plugin.SetCommandVisible(emrSaveAsTemplate, false);
		}
		plugin.UpdateToolbar();
		},200)
	}
});
