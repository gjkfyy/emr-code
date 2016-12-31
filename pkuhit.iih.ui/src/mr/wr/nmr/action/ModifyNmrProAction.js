Ext.define('iih.mr.wr.nmr.action.ModifyNmrProAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	 * @Override
	 */
	execute: function(context) {
	    var operations = context.operations;
        if(!operations) {
            return;
        }
	    var page=this.getOwner();
	    var form= this.getBlock('content').getForm();
	    var data =form.getValues();
	    var mr=page.mr;
	    mr.bizTime=data.logicSmtDate;
	    mr.name=data.mrNm;
	    mr.superiorDoctorId=data.higherLvlEmpId;
	    mr.mastDoctorCd=data.masterDoctorName;
	    mr.dirDoctorCd=data.dirDoctorName;
        this.openPrepareOperations(operations, mr);
    },
    
    openPrepareOperations: function(operations,data) {
        var METHODS = this.getInvocationMethods();
        var url=this.url+'/'+data.mrPk;
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            data:data,
            scope: this,
            success: this.onOpenSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onOpenSuccess: function(operation) {
//    	var mrDocEditView=this.getOwner().mrDocEditView;
//    	if(mrDocEditView){
//    		mrDocEditView.medicalRecord=operation.result.data;
////    		console.log(mrDocEditView);
//    		mrDocEditView.up('workareapageview').getActiveTab().tab.setText(operation.result.data.name);
//    	}
//    	var mrDocListView = this.getOwner().mrDocListView;
//    	if(mrDocListView){
//    		var chain = mrDocListView.getActionChain('init');
//            if(chain) {
//                chain.execute();
//            }
//    	}
        
        this.getOwner().ownerCt.close();
    },
    onFail: function(operation) {
        Ext.Msg.alert('提示','保存失败!');
    }
});
