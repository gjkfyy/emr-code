Ext.define('iih.mr.wr.mr.action.MrDocSortTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	    execute: function(context) {
	    	//先加载按钮（病案首页）
	    	var callPatCaseBtn=Ext.getCmp('callPatCaseBtn');
	    	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');//wangyanli 20160721重新选择模板，门诊按钮，当多次切换门诊住院门户时，该按钮会再住院门户显示，故进行处理
	    	var callOrderBtn=Ext.getCmp('callOrderBtn');//门诊按钮，同上处理
	    	var encounterOverBtn=Ext.getCmp('encounterOverBtn');//门诊按钮，同上处理
	    	
	    	if(CONFIG_PARAM.CALL_PAT_CASE_BUTTON&&callPatCaseBtn){
	    		callPatCaseBtn.show();
    		}
	    	if(reSelectTempBtn){
	    		reSelectTempBtn.hide();
	    	}
	    	if(callOrderBtn){
	    		callOrderBtn.hide();
	    	}
	    	if(encounterOverBtn){
	    		encounterOverBtn.hide();
	    	}
	    	
	    	this. showLoading();
	    	var owner = this.getOwner();
	    	var mrTempSortTree=Ext.getCmp('mrTempSortTree');
	    	if(mrTempSortTree.getStore().tree.root.childNodes.length==0){
	    		var chain = owner.getActionChain('tempInit');
		        if(chain) {
		            chain.execute();
		        }
	    	}
	        var chain = owner.getActionChain('btnUsable');
	        if(chain) {
	            chain.execute();
	        }
	    	var encounterSn = IMER_GLOBAL.encounterSn;
	        this.prepareOperations(context.operations,encounterSn);
	    },
	    prepareOperations: function(operations,encounterSn) {
	         
	         var url = this.url+'?encounterPk='+encounterSn;
	         var operation = {
	             url: url,
	             method: 'get',
	             scope: this,
	             success: this.onSuccess
	         };
	         operations.push(operation);
	     },
	     onSuccess: function(operation) {
	         var block = this.getBlock('result'); 
	         // TODO 数据格式就这样了？
	         if(operation.result.data){
	         	 block.setData(operation.result.data.children);
		         var tree = block.down('xaptree'); 
		         //var node = tree.getRootNode().childNodes[0];
		         
		         //tree.getSelectionModel().select(0,false,false);
		         //var selected=tree.getSelectionModel().getSelection();
		         //tree.getStore().getAt(0);
	         }else{
	        	 block.setData(null);
	         }
	     }
});
