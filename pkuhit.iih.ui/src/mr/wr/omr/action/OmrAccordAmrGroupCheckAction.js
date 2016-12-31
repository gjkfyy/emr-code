Ext.define('iih.mr.wr.omr.action.OmrAccordAmrGroupCheckAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.prepareOperations(context.operations);
			
		},
	    prepareOperations: function(operations) {
	    	/*var iemrCallHis = this.getOwner().getActionChain('iemrCallHis');
	    	iemrCallHis.execute();*/
	    	
	    	
	    	var callOrderBtn=Ext.getCmp('callOrderBtn');
	    	var encounterOverBtn=Ext.getCmp('encounterOverBtn');
	    	var callPatCaseBtn=Ext.getCmp('callPatCaseBtn');//wangyanli 20160721  住院按钮，当多次切换门诊住院门户时，该按钮会再门诊门户显示(开发环境下有问题)，故进行处理
	    	
	    	if(CONFIG_PARAM.CALL_ORDER_BUTTON&&callOrderBtn){
	    		callOrderBtn.show();
    		}
	    	if(CONFIG_PARAM.ENCOUNTER_OVER_BUTTON&&encounterOverBtn){
	    		encounterOverBtn.show();
	    	}
	    	if(callPatCaseBtn){
	    		callPatCaseBtn.hide();
	    	}
	    	
	    	
	        var url = this.url;
	        if(!IMER_GLOBAL.encounterSn){
	        	return;
	        }
	        url = url+'/'+IMER_GLOBAL.encounterSn;  
	        var mclass = null;
	        var METHODS = this.getInvocationMethods();
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: METHODS.METHOD_GET,
	            condition: null,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	    	var owner=this.getOwner();
	    	var accordAmrGroup=operation.result.data.accordAmrGroup;
	    	if(accordAmrGroup){
	    		XapMessageBox.confirm2('检测到上次就诊在三天内，是否续诊？', function(id){
    				if(id=='yes'){
    					var amrGroupCreate = owner.getActionChain('amrGroupCreate');
    					amrGroupCreate.execute();
    				}else{
    					var treeInit = owner.getActionChain('treeInit');
    					treeInit.execute();
    				}
    			});
	    	}else{
	    		var treeInit = owner.getActionChain('treeInit');
				treeInit.execute();
	    	}
	    	
	    }
	});

