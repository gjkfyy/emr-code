Ext.define('iih.mr.di.action.OutDiagnosisDelAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:['iih.mr.di.action.Util'],
	
	doExecute: function(context) {
		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
        	
        	 var me = this;
             var owner=me.getOwner();	
             var tree = owner.ownerCt.down('diagnosisfiltertree');
             var selModel=tree.getSelectionModel();
             var selRecord = selModel.getSelection()[0];
             var diSn = selRecord.get('diSn');
            // var data = selRecord.data;
             var data = {enSn:IMER_GLOBAL.encounterSn,diCd:selRecord.data.diCd};
	        var url = this.url+'/'+diSn;
	        var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	            data:data,
	    		mclass: null,
	    		method: METHODS.METHOD_DELETE,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	    	 var me = this;
		     var owner=me.getOwner();	
		     var tree = owner.ownerCt.down('treepanel');
		     
		     var diagnosischain = owner.getActionChain("outDiagnosisInitAction");
	         var diagnosisAction = diagnosischain.getActionByClass('iih.mr.di.action.OutDiagnosisInitAction');
	         diagnosisAction.url = '/di/'+IMER_GLOBAL.encounterSn+'/dis?orgCode='+IMER_GLOBAL.hospitalArea.code;
	         diagnosischain.execute();
	         
	         iih.po.com.iemrTohisEvent.fireEvent('diagnosisComit');
	         
	         var outmrwriteview = Ext.getCmp('outmrwriteview');
			 var diagnosis = outmrwriteview.getBlock('right').getActionChain('emrRefreshDiagnosis');
			 diagnosis.execute();
	    },
    onFailure: function(operation) {
	    	XapMessageBox.info('删除失败!');
	    },  
});
