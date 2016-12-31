Ext.define('iih.mr.wr.mr.action.MrSelectContinuePrintAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        var plugin = document.getElementById('iemrEditor');
        if(!plugin&&!this.getOwner().medicalRecord){
        	var mrTpCcatCd=this.getOwner().ownerCt.getBlock('left').down('xaptree').getSelectionModel().getSelection()[0].raw.mrTpCcatCd;
        	this.prepareOperations(operations, mrTpCcatCd);
        }else if(!plugin.IsModified()){
            var mrTypeCustomCode=this.getOwner().medicalRecord.mrTypeCustomCode;
            this.prepareOperations(operations, mrTypeCustomCode);
        }else{
        	Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
        }
    },
    
    prepareOperations: function(operations,mrTypeCustomCode) {
        var METHODS = this.getInvocationMethods();
        var encounterSn = IMER_GLOBAL.encounterSn;
        var url=this.url+'?withFile=1&encounterPk='+encounterSn+'&mrTypeCustomCode='+mrTypeCustomCode;
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        if(plugin==null){
        	plugin = document.getElementById('iemrEditorRead');
        }
        var fileNames='';
        var fileNewPageSorts='';
        var printBegin = -1;
        var mrPk="";
        if(this.getOwner().medicalRecord){
            mrPk=this.getOwner().medicalRecord.mrPk;
        }
        var returnData=operation.result.dataList;
        for ( var i = 0; i < returnData.length; i++) {
            var fileName=plugin.Base64toODT(returnData[i].fileData);
            if(fileNames==''){
                fileNames=fileName;
            }else{
                fileNames=fileNames+'\n'+fileName
            }
            if(1==returnData[i].newPageF&&(0==returnData[i].alonePageF||null==returnData[i].alonePageF)){
                if(fileNewPageSorts==''){
                    fileNewPageSorts=i;
                }else{
                    fileNewPageSorts=fileNewPageSorts+'\n'+i
                }
            }else  if(1==returnData[i].alonePageF){
                if(fileNewPageSorts==''){
                    fileNewPageSorts=i+'\n'+(i+1);
                }else{
                    fileNewPageSorts=fileNewPageSorts+'\n'+i+'\n'+(i+1);
                }
            }
        }
        setTimeout(function() {
            plugin.PrintContinue2(fileNames,printBegin,fileNewPageSorts);
        }, 500);
//        plugin.EditDocument();
//        Ext.Msg.alert("提示",'驳回成功!');
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取续打病历失败!');
    }
});
