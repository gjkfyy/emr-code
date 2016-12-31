Ext.define('iih.mr.wr.mr.action.RefreshMrDiagnosisAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
    	var medicalRecord=this.getOwner().medicalRecord;
    	
        var url=this.url+'?enPk='+medicalRecord.encounterPk;
        var operation = {
            url: url,
            method: 'get',
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
//        console.log(operation);
/*        if(null!=operation.result.dataList&&operation.result.dataList.length>0){
        	this.importReferenceElem(plugin,operation.result.dataList);
        }*/
        var returnData=operation.result.dataList;
        var aData01 = null;
        var aData02 = null;
        for ( var i = 0; returnData&&i < returnData.length; i++) {
//            var macroConstants = window.iemr.extensions.constants[0];
            if(returnData[i].diTpCd == '01'){
                if(aData01 == null){
                    aData01 = returnData[i].diNm;
                }else{
                    aData01 = aData01 + '\n' + returnData[i].diNm;
                }
            }
            if(returnData[i].diTpCd == '02'){
                if(aData02 == null){
                    aData02 = returnData[i].diNm;
                }else{
                    aData02 = aData02 + '\n' + returnData[i].diNm;
                }
            }
            
        };
        if(aData01 != null)
            plugin.RefreshDiagnosis('01', aData01);
        if(aData02 != null)
            plugin.RefreshDiagnosis('02', aData02);
        
        var count=this.getOwner().count;
        console.log(count);
        if(count&&count==3){
        	console.log('----------plugin.EnableOCX(true);---------'+count);
        	plugin.EnableOCX(true);
        }else{
        	this.getOwner().count=count+1;
        }
    
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取诊断失败，请重试！');
    }
});
