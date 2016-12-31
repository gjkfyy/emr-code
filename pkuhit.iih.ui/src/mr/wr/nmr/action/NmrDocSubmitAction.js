Ext.define('iih.mr.wr.nmr.action.NmrDocSubmitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var userName=IMER_GLOBAL.user.name;
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
           
            //plugin.ImportMacroValue(macroIdOld, userName);//进行签名
//            var nmrUseSign = this.getOwner().getActionChain('nmrUseSign');
//            nmrUseSign.execute({'macroIdOld':macroIdOld});
            medicalRecord.fileData=plugin.SaveToString();
            var referenceElem=plugin.GetSourceReferenceElem();
//	        console.log(referenceElem);
	        if(referenceElem.length>0){
	            var referenceElemJson=JSON.parse(referenceElem);
	            medicalRecord.referenceElem=referenceElemJson;//得到文档中的引用元素及值
	        }
	        medicalRecord.xmlFileData=plugin.ExportXML();
	        var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
//	        medicalRecord.txtFileData=plugin.ExportText();//获取病历文本
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
        var url='nmr';
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
        plugin.SetReadOnly();

        var owner = this.getOwner();
        var refresh = this.getOwner().ownerCt.getActionChain('refresh');
    	refresh.execute({from:'addSuccess'});
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
        plugin.SetReadOnly();
        //更改按钮状态
        var owner = this.getOwner();
        var chain = owner.getActionChain('disabledOfficeToolBarAction');
        if(chain) {
            chain.execute();
        }
        var refresh = this.getOwner().ownerCt.getActionChain('refresh');
        if(refresh) {
        	refresh.execute();
        }
        plugin.EnableOCX(true);
//        plugin.UpdateToolbar();
//        Ext.Msg.alert('提示','提交成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','提交失败!');
    }
});
