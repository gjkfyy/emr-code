Ext.define('iih.mr.wr.omr.action.RefreshMrDiagnosisAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    
    /*
     * @Override
     */
    execute: function(context) {
    	var plugin = document.getElementById('iemrEditor');
    	if(plugin.IsReadOnly()){
    		return;
    	}
        var operations = context.operations;
        if(!operations) {
            return;
        }
        this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
    	var medicalRecord=this.getOwner().medicalRecord;
    	if(medicalRecord){
    		var url=this.url+'?enPk='+medicalRecord.encounterPk;
            var operation = {
                url: url,
                method: 'get',
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
            operations.push(operation);
    	}
    },
    onSuccess: function(operation) {
        var plugin = document.getElementById('iemrEditor');
        var returnData=operation.result.dataList;
        var aData01 = '    ';
        for ( var i = 0; returnData&&i < returnData.length; i++) {
            if(returnData[i].diTpCd == '04'){
                if(aData01 == '    '){
                    aData01 = returnData[i].longDiNm;
                }else{
                    aData01 = aData01 + '\n' + returnData[i].longDiNm;
                }
            }
            
        };
//        if(aData01 != null)
            plugin.RefreshSpecifyTable('门诊诊断表',2, aData01);
       /* var count=this.getOwner().count;
        console.log('-------------------'+count);
        if(count&&count==2){
        	console.log('----------plugin.EnableOCX(true);---------'+count);
        	plugin.EnableOCX(true);
        }else{
        	this.getOwner().count=count+1;
        }*/
    
    },
    onFail: function(operation) {
        Ext.Msg.alert("提示",'获取诊断失败，请重试！');
    }
});
