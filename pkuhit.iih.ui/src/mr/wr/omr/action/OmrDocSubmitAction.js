Ext.define('iih.mr.wr.omr.action.OmrDocSubmitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
		if(context.submitF){//第三方socket调用刷新处置后提交标识
			this.submitF=context.submitF;
		}
        if(context.event){
        	 var cmd=context.event.arguments[0];
        	 this.cmd=cmd;
        }else{
        	this.cmd=context.cmd;
        }
        	
        var medicalRecord=this.getOwner().medicalRecord;
        //如果文档为提交状态，则不执行提交，直接进行打印
        if('emrSubmit'!=this.cmd&&(!medicalRecord||medicalRecord.statusCode=='MRM04.02')){
        	//执行整洁打印
            var emrNeatPrint = this.getOwner().getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute({submitF:submitF});
            }
            return;
        }
        var userName=IMER_GLOBAL.user.name;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(false);
        var opType=this.getOwner().opType;
        if(opType!=undefined){
        	this.showSubmitProgressBar();
            var macroIdOld='MR.M.013.D.26';
            //plugin.ImportMacroValue(macroIdOld, userName);//进行签名
            medicalRecord.fileData=plugin.SaveToString();
            plugin.SetReadOnly();
            var referenceElem=plugin.GetSourceReferenceElem();
	        console.log(referenceElem);
	        if(referenceElem.length>0){
	            var referenceElemJson=JSON.parse(referenceElem);
	            medicalRecord.referenceElem=referenceElemJson;//得到文档中的引用元素及值
	        }
	        medicalRecord.xmlFileData=plugin.ExportXML();
	        var pdfUrl=plugin.ExportPDF();
	        medicalRecord.mrPdfData=plugin.FileToBase64(pdfUrl.substring(8,pdfUrl.length));
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
        var url='omr';
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
        plugin.EnableOCX(true);
        this.getOwner().medicalRecord=returnData.result.data;
        
        var owner = this.getOwner();
        var chain = owner.getActionChain('disabledOfficeToolBarAction');
        if(chain) {
            chain.execute();
        }
        if(CONFIG_PARAM.OMR_SUBMIT_WINDOW_IS_MIN == 1){
            this.minEmr();
        }
        if(CONFIG_PARAM.OMR_SUBMIT_IS_SENDMQ == 1){
            //向集成平台发送mq消息
            var emrSendMq = owner.getActionChain('emrSendMq');
            if(emrSendMq) {
                emrSendMq.execute({
                    'opt':'0'
                });
            }
        }
        if('emrSubmit'==this.cmd){
        	this.callback();
        	return;
        }
        if(CONFIG_PARAM.OMR_SUBMIT_IS_PRINT == 1||this.cmd=='emrPrint'){
            var emrNeatPrint = owner.getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute({submitF:this.submitF});
            }
        }
//        Ext.Msg.alert('提示','提交成功!');
    },
    onAddSuccess: function(returnData) {
    	var refresh = this.getOwner().ownerCt.getActionChain('refresh');
    	refresh.execute({from:'addSuccess'});
        this.getOwner().opType='open';
        this.getOwner().mrSn=returnData.result.data.mrPk;
        this.getOwner().medicalRecord=returnData.result.data;
        var plugin = document.getElementById('iemrEditor');
        plugin.EnableOCX(true);
        plugin.SetCommandEnable('com.founder.iemr.editor.toolbar:emrDocProperty',true);
        plugin.SetReadOnly();
        //更改按钮状态
        var owner = this.getOwner();
        //执行工具栏控制
        var chain = owner.getActionChain('disabledOfficeToolBarAction');
        if(chain) {
            chain.execute();
        }
        if(CONFIG_PARAM.OMR_SUBMIT_WINDOW_IS_MIN == 1){
            this.minEmr();
        }
        if(CONFIG_PARAM.OMR_SUBMIT_IS_SENDMQ == 1){
            //向集成平台发送mq消息
            var emrSendMq = owner.getActionChain('emrSendMq');
            if(emrSendMq) {
                emrSendMq.execute({
                    'opt':'0'
                });
            }
        }
        if('emrSubmit'==this.cmd){
        	this.callback();
        	return;
        }
        if(CONFIG_PARAM.OMR_SUBMIT_IS_PRINT == 1||this.cmd=='emrPrint'){
            //执行整洁打印
            var emrNeatPrint = owner.getActionChain('emrNeatPrint');
            if(emrNeatPrint) {
            	emrNeatPrint.execute({submitF:this.submitF});
            }
        }
        this.callback();
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','提交失败!');
    },
    callback: function() {
    	if(this.getOwner().callback){
        	var callback=this.getOwner().callback;
        	callback();
        }
    },
    minEmr: function() {
        var top = Ext.getCmp('portalview').down('topview');
        var chain = top.getActionChain('topBaseButtons');
        chain.execute({
            action: 'minimum'
        });
    }
});
