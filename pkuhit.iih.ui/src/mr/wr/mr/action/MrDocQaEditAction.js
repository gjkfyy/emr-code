Ext.define('iih.mr.wr.mr.action.MrDocQaEditAction', {
	extend: 'iih.mr.action.editor.EmrEditorOperatorAction',
	
	requires: ['iih.mr.block.editor.MrDocEditBlock'],
	/*
	* @Override
	*/
	execute: function(context) {
	    Ext.useShims=true;
    	var operations = context.operations;
    	if(!operations) {
            return;
        }
    	var opType=this.getOwner().opType;
    	var rs = this.getBlock('content');   
    	this.addEditorEvent(rs);
    	if(opType!=undefined){
            if(opType=='reform'){//创建新病历
            	this.showProgress();
                var mrSn=this.getOwner().mrSn;
                this.openPrepareOperations(operations, mrSn);
            }else{
            	Ext.Msg.alert('提示','opType参数错误!');
            }
        }
    },
    openPrepareOperations: function(operations, mrSn) {
        var url = this.url+'/'+mrSn+'?withFile=true';
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onOpenSuccess
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
        var self=this;
        var medicalRecord=operation.result.data;
        //设置整改标志位1，这样后台保存时不验证是否有保存权限
        medicalRecord.reformFlag=true;
        var mrDocEditPage=this.getOwner();
        mrDocEditPage.medicalRecord=medicalRecord;
//        console.log(mrDocEditPage.medicalRecord);
        var params={
                'objectId':'iemrEditor',
                'sstream':medicalRecord.fileData,
                'mr_mode':1,
                'readonly':false,
                'callBackAction':'editorCallBackAction'
        };
        this.insertWriter(mrDocEditPage,params);
    }
});
