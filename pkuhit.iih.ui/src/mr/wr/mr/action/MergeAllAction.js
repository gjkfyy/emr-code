Ext.define('iih.mr.wr.mr.action.MergeAllAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var me=this;
		var mrs=this.getOwner().mrs;
		if(mrs.length>0){
			var plugin = document.getElementById('iemrEditorRead');
//			plugin.EditDocument();
			setTimeout(function() {
			for(var i=0;i<mrs.length;i++){
//				
//					plugin.EditDocument();
					if(i>0){
						var mr=mrs[i];
		        		plugin.InsertFromString(mr.fileData,1);
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
            var emrPrint = 'com.founder.iemr.editor.toolbar:emrPrint';//打印
			setTimeout(function() {
				plugin.SetCommandVisible(emrSave,false);
    			plugin.SetCommandVisible(emrContinuePrint,false);
                plugin.SetCommandVisible(emrSubmit,false);
                plugin.SetCommandVisible(emrRevoke,false);
                plugin.SetCommandVisible(emrDocDelete,false);
                plugin.SetCommandVisible('com.founder.iemr.editor.toolbar:emrNeatPrint',false);
                plugin.SetCommandVisible(emrRefreshMacro,false);
                plugin.SetCommandVisible(emrRefreshDiagnosis,false);
                plugin.SetCommandVisible(emrImageLibraries,false);
                plugin.SetCommandVisible(emrRefreshOutpatientDisposal,false);
                
                plugin.SetCommandVisible(emrDocProperty,false);
                plugin.SetCommandVisible(emrStartApprove,false);
                plugin.SetCommandVisible(emrApprove,false);
                plugin.SetCommandVisible(emrAuditRevoke,false);
                //plugin.SetCommandVisible(emrSelectContinuePrint,false);
                plugin.SetCommandVisible(emrSaveAsTemplate,false);
                plugin.SetCommandVisible(emrReject,false);
            	plugin.SetCommandVisible(emrPrintSelected,false);
                if(me.getOwner().ownerCt.managementPortal){
                    plugin.SetCommandVisible(emrPrint,true);
                    //plugin.SetCommandVisible(emrContinuePrint,true);
                    plugin.SetCommandVisible(emrSelectContinuePrint,true);
                }else{
                	plugin.OfficeCommand('com.founder.iemr.editor.toolbar:emrBrowsMode'); 
                }
				plugin.SaveToString();
				plugin.SetReadOnly();
				setTimeout(function() {
//						plugin.ShowOCX(true);
//						plugin.GotoMark('DOC_START');
					plugin.UpdateToolbar();
    				me.closeProgress();
            		plugin.ShowOCX(true);
						//me.closeProgress();//关闭进度条
					},250);
			},250);
			},200);
		}
    }
});
