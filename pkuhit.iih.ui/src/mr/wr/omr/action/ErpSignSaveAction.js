Ext.define('iih.mr.wr.omr.action.ErpSignSaveAction', {
	extend: 'iih.mr.wr.omr.action.BtnStaErpSignAction',
	
	/*
	 * @Override
	 */
	execute: function(context) {
		var operations = context.operations;
//		var target = document.getElementById("target");
//		target.DeleteFile("D:\qq.txt");
//		console.info("删除完成");
//		return;
        if(!operations) {
            return;
        }
		var self=this;
		//XapMessageBox.confirm2('签名保存后将无法对病历进行修改和再次签名，请确认是否继续保存签名？', function(btn){
		//	if (btn == 'yes') {
				var signresult = self.foxit_sdk_ts_signature(); 
				if(!signresult){
					Ext.MessageBox.alert('提示', '已签章或签章失败，病历保存失败！');
				   return ; 
				}
				var FoxitPDFSDK = document.getElementById("FoxitPDFSDK");
				// 保存文件
				FoxitPDFSDK.Save();
				// 获得文件路径
				var filePath = FoxitPDFSDK.FilePath;
				//var filePath = "C:\\" + 'timestamp.pdf';
				// 转换为base64
				var base64 = FoxitPDFSDK.ReadFileToBase64(filePath);
				//取到mrpk和fileDate放入data传入后台
				var outmrdoceditview=Ext.getCmp('outmrdoceditview');
				var mr=outmrdoceditview.medicalRecord;
				mr.caFileData=base64;
				self.addPrepareOperations(operations, mr);
				/*FuiPageFactory.submit({
			          serviceName: 'fi.clinical.mr.online.mr_doc_edit.MRDocEditService',
			          serviceMethodName: 'savePDF',
			          data: [data],
			          success: function(mrbMrDocFile) {
							var electronicSign=Ext.getCmp('electronicSign');
							electronicSign.setDisabled(true);
							var gridDoc = me.getMrDocGrid();
							var deleteBtn=gridDoc.down('button[action=delete]');
							deleteBtn.setDisabled(true);
							var emrDocDelete = window.iemr.extensions.constants[0].EMR_DOC_DELETE;
							var emrSave = window.iemr.extensions.constants[0].EMR_SAVE;
							var emrRefreshMacro = window.iemr.extensions.constants[0].EMR_REFRESH_MACRO;//刷新宏元素
							var emrRefreshDiagnosis = window.iemr.extensions.constants[0].EMR_REFRESH_DIAGNOSIS;//刷新诊断
							iemrEditor.SetCommandVisible(emrDocDelete, false);
							iemrEditor.SetCommandVisible(emrSave, false);
							iemrEditor.SetCommandVisible(emrRefreshMacro, false);
							iemrEditor.SetCommandVisible(emrRefreshDiagnosis, false);
							iemrEditor.SetReadOnly();
							iemrEditor.UpdateToolbar();
							docEditPage.data.updateCount = mrbMrDocFile.updateCount;
			          },
			          failure: function(data) {
//			              Ext.MessageBox.alert('提示', '保存失败！');
			          }
			    });*/
           // }else if (btn == 'no') {
            //    return false;
           // }
		// 	});
	},
    addPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:data,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onAddSuccess: function(returnData) {
    	var erpSignSaveBtn=Ext.getCmp('erpSignSaveBtn');
		erpSignSaveBtn.setDisabled(true);
		var timePokeSignBtn=Ext.getCmp('timePokeSignBtn');
		timePokeSignBtn.setDisabled(true);
		var fingerprintGatherBtn=Ext.getCmp('fingerprintGatherBtn');
		fingerprintGatherBtn.setDisabled(true);
		var patientSignBtn=Ext.getCmp('patientSignBtn');
		patientSignBtn.setDisabled(true);
		var doctorSignBtn=Ext.getCmp('doctorSignBtn');
		doctorSignBtn.setDisabled(true);
		var erpSignBtn=Ext.getCmp('erpSignBtn');
		erpSignBtn.setDisabled(true);
		var serchErpSignBtn=Ext.getCmp('serchErpSignBtn');
		serchErpSignBtn.setDisabled(false);
		var mrDelete=Ext.getCmp('mrDelete');
		mrDelete.setDisabled(true);
		var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
    	reSelectTempBtn.setDisabled(true);
		var plugin = document.getElementById('iemrEditor');
		var emrSave = 'com.founder.iemr.editor.toolbar:emrSave';//保存
        var emrSubmit = 'com.founder.iemr.editor.toolbar:emrSubmit';//提交
        var emrRevoke = 'com.founder.iemr.editor.toolbar:emrRevoke';//撤销
        var emrDocDelete = 'com.founder.iemr.editor.toolbar:emrDocDelete';//删除
        var emrRefreshMacro = 'com.founder.iemr.editor.toolbar:emrRefreshMacro';//刷新宏元素
        var emrRefreshDiagnosis = 'com.founder.iemr.editor.toolbar:emrRefreshDiagnosis';//刷新诊断
        var emrRefreshOutpatientDisposal='com.founder.iemr.editor.toolbar:emrRefreshOutpatientDisposal';//刷新门诊处置
        plugin.SetCommandEnable(emrSave, false);
        plugin.SetCommandEnable(emrSubmit, false);
        plugin.SetCommandEnable(emrRevoke, false);
        plugin.SetCommandEnable(emrDocDelete, false);
        plugin.SetCommandEnable(emrRefreshMacro, false);
        plugin.SetCommandEnable(emrRefreshDiagnosis, false);
        plugin.SetCommandEnable(emrRefreshOutpatientDisposal, false);
        plugin.SetReadOnly();
        plugin.UpdateToolbar();

    	Ext.MessageBox.alert('提示', '已签章成功！');
    }
});
