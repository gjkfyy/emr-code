Ext.define('iih.mr.wr.mr.action.DisabledOfficeToolBarAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    doExecute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var opType=this.getOwner().opType;
        var editorName="iemrEditor";
    	if("readonly"==opType){
    		editorName="iemrEditorRead";
    	}
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
        var me=this;
        var printable=this.getOwner().ownerCt.printable;
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
        var plugin = document.getElementById(editorName);
        var mr=me.getOwner().medicalRecord;
        setTimeout(function() {
        	Ext.MessageBox.hide();
        },150);
        setTimeout(function() {
            var canSign=intToBoolean(mr.canSign);
            var canCancelSigned=intToBoolean(mr.canCancelSigned);
            var canReject=intToBoolean(mr.canReject);
            var canUpdate=intToBoolean(mr.canUpdate);
            var canDelete=intToBoolean(mr.canDelete);
            var canEdit=intToBoolean(mr.canEdit);
            var canPrint=intToBoolean(mr.canPrint);
            var canContinuePrint=intToBoolean(mr.canContinuePrint);
            var canApprove=intToBoolean(mr.canApprove);
            var canStartApprove=intToBoolean(mr.canStartApprove);
            var canCancelApprove=intToBoolean(mr.canCancelApprove);
            var canSaveAsTemplate=intToBoolean(mr.canSaveAsTemplate);
            plugin.SetCommandVisible(emrRefreshOutpatientDisposal,false);
        	if(opType=='open'||opType=='readonly'){
        		if(CONFIG_PARAM.MR_TPL_OWNER_TYPE){
        			plugin.SetCommandEnable(emrSaveAsTemplate,mr.canSaveAsTemplate);
        		}else{
        			plugin.SetCommandEnable(emrSaveAsTemplate,false);
        		}
        		//根据用户审签等级判断隐藏哪些按钮
        		if(mr.userSignLevelCode==null||'MRM02.01'==mr.userSignLevelCode||'MRM02.02'==mr.userSignLevelCode||IMER_GLOBAL.user.code==mr.createUserId){
        			plugin.SetCommandVisible(emrApprove,false);
        			plugin.SetCommandVisible(emrStartApprove,false);
        			plugin.SetCommandVisible(emrAuditRevoke,false);
        			plugin.SetCommandVisible(emrReject,false);
        		}else if(('MRM02.03'==mr.userSignLevelCode||'MRM02.04'==mr.userSignLevelCode)&&IMER_GLOBAL.user.code!=mr.createUserId){
        			plugin.SetCommandVisible(emrSubmit,false);
        			plugin.SetCommandVisible(emrRevoke,false);
        		}
        		plugin.SetCommandEnable(emrSave,canUpdate);
            	plugin.SetCommandEnable(emrSubmit,canSign);
            	plugin.SetCommandEnable(emrRevoke,canCancelSigned);
            	plugin.SetCommandEnable(emrReject,canReject);
            	plugin.SetCommandEnable(emrDocDelete,canDelete);
            	plugin.SetCommandEnable(emrRefreshDiagnosis,canEdit);
            	plugin.SetCommandEnable(emrRefreshMacro,canEdit);
            	plugin.SetCommandEnable(emrImageLibraries,canEdit);
            	plugin.SetCommandEnable(emrStartApprove,canStartApprove);
            	plugin.SetCommandEnable(emrApprove,canApprove);
            	plugin.SetCommandEnable(emrAuditRevoke,canCancelApprove);
            	plugin.SetCommandVisible(emrContinuePrint,canContinuePrint);
            	plugin.SetCommandVisible(emrSelectContinuePrint,canContinuePrint);
            	if(opType=='readonly'){
            		plugin.SetCommandVisible(emrPrintSelected,false);
            		plugin.SetCommandVisible(emrSave,canUpdate);
                	plugin.SetCommandVisible(emrSubmit,canSign);
                	plugin.SetCommandVisible(emrRevoke,canCancelSigned);
                	plugin.SetCommandVisible(emrReject,canReject);
                	plugin.SetCommandVisible(emrDocDelete,canDelete);
                	plugin.SetCommandVisible(emrRefreshDiagnosis,canEdit);
                	plugin.SetCommandVisible(emrRefreshMacro,canEdit);
                	plugin.SetCommandVisible(emrImageLibraries,canEdit);
                	plugin.SetCommandVisible(emrStartApprove,canStartApprove);
                	plugin.SetCommandVisible(emrApprove,canApprove);
                	plugin.SetCommandVisible(emrAuditRevoke,canCancelApprove);
            	}
            }else{
            	plugin.SetCommandEnable(emrDocProperty,false);
            	plugin.SetCommandEnable(emrRevoke,false);
            	plugin.SetCommandVisible(emrReject,false);
            	plugin.SetCommandEnable(emrDocDelete,false);
            	plugin.SetCommandVisible(emrStartApprove,false);
            	plugin.SetCommandVisible(emrApprove,false);
            	plugin.SetCommandVisible(emrAuditRevoke,false);
//            	plugin.SetCommandEnable(emrContinuePrint,false);
            }
        	/*
        	//当医疗记录自定义分类既不是入院记录也不是病程记录时禁用续打和选页打印功能
        	if(mr.mrTypeCustomCode&&mr.mrTypeCustomCode.indexOf('MRM14.02')<0&&mr.mrTypeCustomCode.indexOf('MRM14.03')<0){
        		plugin.SetCommandVisible(emrSelectContinuePrint,false);
            	plugin.SetCommandVisible(emrContinuePrint,false);
        	}*/
        	plugin.UpdateToolbar();
        	var count=me.getOwner().count;
            console.log(count);
            if(count&&count==3){
            	console.log('----------plugin.EnableOCX(true);---------'+count);
            	plugin.EnableOCX(true);
            }else{
            	me.getOwner().count=count+1;
            }
        },750);
//        Ext.MessageBox.hide();
    }
});
