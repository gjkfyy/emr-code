Ext.define('iih.mr.wr.mr.action.MrContinuePrintAction', {
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
        if(this.getOwner().ownerCt.managementPortal){
        	plugin = document.getElementById('iemrEditorRead');
        }
        if(!plugin.IsModified()){
        	var mrTypeCustomCode="";
        	if(this.getOwner().medicalRecord){
        		mrTypeCustomCode=this.getOwner().medicalRecord.mrTypeCustomCode;
        	}
            if(!mrTypeCustomCode){
            	mrTypeCustomCode=this.getOwner().ownerCt.mrTpCcatCode;
            }
            this.prepareOperations(operations, mrTypeCustomCode);
        }else{
        	Ext.MessageBox.alert('提示', '当前修改未保存，请保存后重试！');
        }
    },
    
    prepareOperations: function(operations,mrTypeCustomCode) {
        var METHODS = this.getInvocationMethods();
        var encounterSn = IMER_GLOBAL.encounterSn;
        var deptCd=null;
        if(this.getOwner().medicalRecord)
        	deptCd=this.getOwner().medicalRecord.deptCd;
        var url=this.url+'?withFile=1&encounterPk='+encounterSn+'&mrTypeCustomCode='+mrTypeCustomCode+'&deptCd='+deptCd;
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
        if(this.getOwner().ownerCt.managementPortal){
        	plugin = document.getElementById('iemrEditorRead');
        }
        var fileNames='';
        var fileNewPageSorts='';
        var printBegin = 0;
        var mrPk=null;
        if(this.getOwner().medicalRecord)
        	mrPk=this.getOwner().medicalRecord.mrPk;
        var returnData=operation.result.dataList;
        var bl=false;
        for ( var i = 0; i < returnData.length; i++) {
            if (mrPk == returnData[i].mrPk) {
                printBegin = i;
                bl=true;
            }
            
            var fileName=plugin.Base64toODT(returnData[i].fileData);
            if('MRM16.25'==returnData[i].typeCode){//如果类型是转入记录，则页眉需要以此开始
            	if(bl&&i>printBegin){
            		break;
            	}
            	fileName=fileName+'NewHeader-';
            }
            if(fileNames==''){
                fileNames=fileName;
            }else{
                fileNames=fileNames+'\n'+fileName;
            }
            if(1==returnData[i].newPageF&&(0==returnData[i].alonePageF||null==returnData[i].alonePageF)){
                if(fileNewPageSorts==''){
                    fileNewPageSorts=i;
                }else{
                    fileNewPageSorts=fileNewPageSorts+'\n'+i;
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
