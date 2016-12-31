Ext.define('iih.mr.di.action.OutDiagnosisSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [
        'Xap.ej.data.DataModel',
        'iih.po.com.iemrTohisEvent'
    
    ],

    doExecute: function(context) {
        if(context.callback){
        	this.getOwner().callback=context.callback;
        }
	    this.prepareOperations(context);
    },

    prepareOperations: function(context) {
		var outDiagnosisBlock=this.getBlock('content');
	    outDiagnosisBlock.setBtnCommitDisabled(true);
        var me = this;
    	var owner=me.getOwner();	
	    var tree = owner.ownerCt.down('diagnosisfiltertree');
	    var nodes = tree.getStore().getRootNode().childNodes;
	    var diagnosisDatas = [];
	    
	    for(var i=0;i<nodes.length;i++){
	    	
	    	var diagnosisRecord = {};
	    	if(nodes[i].get('diNm')!=''){
	    		
	    		diagnosisRecord['diSn']=nodes[i].get('diSn');
	    	   	if(/.*[\u4e00-\u9fa5]+.*$/.test(nodes[i].get('diSn'))){
				    diagnosisRecord['diSn'] = '';
				}else{
				    diagnosisRecord['diSn']=nodes[i].get('diSn');
				}
	    	   	if(!nodes[i].get('diCd')){
	    	   		continue;
	    	   	}
		       	diagnosisRecord['diCd']=nodes[i].get('diCd');
		       	diagnosisRecord['diNm']=nodes[i].get('diNm');
		       	diagnosisRecord['suspected']=nodes[i].get('suspected');
		       	diagnosisRecord['tocheck']=nodes[i].get('tocheck');
		       	diagnosisRecord['addDescr']=nodes[i].get('addDescr');
		       	diagnosisRecord['icdCd']=nodes[i].get('icdCd');
		       	diagnosisRecord['diEmpCd']=nodes[i].get('diEmpCd');
		       	diagnosisRecord['diEmpNm']=nodes[i].get('diEmpNm');
		       	diagnosisRecord['diTime']=nodes[i].get('diTime');        	
		       	diagnosisRecord['updCount']=nodes[i].get('updCount');
		    	diagnosisRecord['setOwnerTypeCd']=nodes[i].get('setOwnerTypeCd');
		    	diagnosisRecord['setOwnerCd']=nodes[i].get('setOwnerCd');
		    	
		    	diagnosisDatas.push(diagnosisRecord);
	    	}
	    	
	    }
	    
	    var data = {enSn:IMER_GLOBAL.encounterSn,list:diagnosisDatas};
	    context.operations = [];
        var METHODS = this.getInvocationMethods();
        var url = this.url;
        var operation = {
                url: url,
                mclass: null,
                method: METHODS.METHOD_CREATE,
                condition: null,
                data:data,
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
        context.operations.push(operation);
        
       // return true;
    },
    onSuccess: function(operation){
    	 var me = this;
	     var owner=me.getOwner();	
	     this.callback();
	     var tree = owner.ownerCt.down('diagnosisfiltertree');
	     
	     var diagnosischain = owner.getActionChain("outDiagnosisInitAction");
         var diagnosisAction = diagnosischain.getActionByClass('iih.mr.di.action.OutDiagnosisInitAction');
         diagnosisAction.url = '/di/'+IMER_GLOBAL.encounterSn+'/dis?orgCode='+IMER_GLOBAL.hospitalArea.code;
         diagnosischain.execute();
         iih.po.com.iemrTohisEvent.fireEvent('diagnosisComit');
         var outmrwriteview = Ext.getCmp('outmrwriteview');
		 var diagnosis = outmrwriteview.getBlock('right').getActionChain('emrRefreshDiagnosis');
		 diagnosis.execute();
		 //Ext.MsgTip.msg('诊断列表变更通知', '病历中诊断同时被更新，请及时保存病历',true,5000);
    },
    
    onFail: function(operation) {
    	XapMessageBox.info('查询失败!');
    }
	,
    callback: function() {
    	if(this.getOwner().callback){
        	var callback=this.getOwner().callback;
        	callback();
        }
   }
});
