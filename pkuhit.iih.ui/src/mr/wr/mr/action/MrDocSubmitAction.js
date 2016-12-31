Ext.define('iih.mr.wr.mr.action.MrDocSubmitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var userName=context.user.name;
        var pic = context.pic;
        var emrSubmit = 'com.founder.iemr.editor.toolbar:emrSubmit';//提交
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrSubmit',false);
//        var certId=plugin.CA_GetCertId();
        var opType=this.getOwner().opType;
        if(opType!=undefined){
        	this.showSubmitProgressBar('iemrEditor');
           	plugin.SetCommandEnable(emrSubmit,false);
//           	plugin.UpdateToolbar();
            var medicalRecord=this.getOwner().medicalRecord;
            if(context.user.practiceDoctor=='1'){
            	medicalRecord.practiceDoctor='1';
            	medicalRecord.submitCd=context.user.loginId;
            	medicalRecord.upDocCheckSubmit=1;
            }
            var macroIdOld='MR.M.013.D.26';
            if(CONFIG_PARAM.MR_JOB_TITLE_SHOW){
            	var tabList = plugin.GetTables();
            	var flag;
    	    	if(tabList){                	    		
    	    		for(var i=0;i<tabList.length;i++){
        	    		var tabName = tabList[i];
        	    		if(tabName == '签名'){
        	    			flag='1';
        	    			break;
        	    		}
    	    		}
    	    	}
            	if(context.user.jobTitleName != null && context.user.jobTitleName !='' && flag == '1'){
            		var tableContent = plugin.ExportTable("签名");
                    if(tableContent.indexOf('：') =='-1'){
                    	 plugin.JumpToTable("签名");
                         plugin.InsertText(context.user.jobTitleName +"：");
                         if(context.user.jobTitleCode != 'MRM20.01'){
                         	plugin.OfficeCommand(".uno:JumpToNextCell");
                         	plugin.OfficeCommand(".uno:DeleteRows");
                         }
                    }
            	}
            }        
           
            if(pic == null || pic == undefined)
            	plugin.ImportMacroValue(macroIdOld, userName);//进行文字签名
            else
            	plugin.ImportMacroValue(macroIdOld, '{IMG}'+pic);//进行图片签名
            medicalRecord.fileData=plugin.SaveToString();
            var referenceElem=plugin.GetSourceReferenceElem();
            plugin.SetReadOnly();
            var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
//	        console.log(referenceElem);
	        if(referenceElem.length>0){
	            var referenceElemJson=JSON.parse(referenceElem);
	            medicalRecord.referenceElem=referenceElemJson;//得到文档中的引用元素及值
	        }
	        medicalRecord.xmlFileData=plugin.ExportXML();
	        medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
	        medicalRecord.enPk = IMER_GLOBAL.encounterSn;
	        if(pic != null || pic != undefined){
	        	var certID = IMER_GLOBAL.certID;
	        	var certValue = iih.po.com.BJCAUtil.GetSignCert(certID);//证书值
				var caData= iih.po.com.BJCAUtil.SignedData(certID,plugin.ExportXML());//签名值
				medicalRecord.certId =certID;
				medicalRecord.certValue =certValue;
				medicalRecord.caData = caData;
	        }
            if(opType=='new'){
                this.addPrepareOperations(operations,medicalRecord);
            }else if(opType=='open'){
                this.openPrepareOperations(operations, medicalRecord);
            }
        }
    },
    
    addPrepareOperations: function(operations,medicalRecord) {
    	medicalRecord.statusCode='MRM04.02';
        var METHODS = this.getInvocationMethods();
        var url='mr';
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:medicalRecord,
            scope: this,
            success: this.onAddSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    
    openPrepareOperations: function(operations,medicalRecord) {
        var METHODS = this.getInvocationMethods();
//        console.log(medicalRecord);
        var url=this.url+'/'+medicalRecord.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            data:medicalRecord,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(returnData) {
        var plugin = document.getElementById('iemrEditor');
        this.getOwner().medicalRecord=returnData.result.data;
        //plugin.SetReadOnly();

        var owner = this.getOwner();
        var chain = owner.getActionChain('disabledOfficeToolBarAction');
        if(chain) {
            chain.execute();
        }
        plugin.EnableOCX(true);
//        Ext.Msg.alert('提示','提交成功!');
    },
    onAddSuccess: function(returnData) {
        this.getOwner().opType='open';
        this.getOwner().mrSn=returnData.result.data.mrPk;
        this.getOwner().medicalRecord=returnData.result.data;
        var plugin = document.getElementById('iemrEditor');
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
        //审签后设置编辑器为只读
        //plugin.SetReadOnly();
        //更改按钮状态
        var owner = this.getOwner();
        var chain = owner.getActionChain('disabledOfficeToolBarAction');
        if(chain) {
            chain.execute();
        }
        plugin.EnableOCX(true);
//        plugin.UpdateToolbar();
//        Ext.Msg.alert('提示','提交成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','提交失败!');
    }
});
