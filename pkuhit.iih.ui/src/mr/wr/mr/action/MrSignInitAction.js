Ext.define('iih.mr.wr.mr.action.MrSignInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    execute: function(context) {
    	this.showLoading();
    	var block = this.getBlock('content');
		var pageNum,pageSize;
		var owner = this.getOwner();
		var me=this;
		if(context.event == undefined){
			pageNum = 1; 
			pageSize = 25; 
			block.pageSize = pageSize;
			var data = {
			};
			me.waitPrepareOperations(context.operations,data);
			
			var alreadySignChain = owner.getActionChain('alreadySignInit');
	        var waitDeptSignChain = owner.getActionChain('waitDeptSignInit');
	        var signedPatientsChain = owner.getActionChain('signedPatients');
	        var waitDeptSignPatients = owner.getActionChain('waitDeptSignPatients');
	        if(alreadySignChain) {
	            setTimeout(function() {
	            	alreadySignChain.execute(data);
	            },250);
	        }
	        if(waitDeptSignChain) {
	        	setTimeout(function() {
	        		waitDeptSignChain.execute(data);
	            },450);
	        }
	        if(signedPatientsChain) {
	        	setTimeout(function() {
	        		 signedPatientsChain.execute();
	        	},650);
	        }
	        if(waitDeptSignPatients) {
	        	setTimeout(function() {
	        		waitDeptSignPatients.execute();
	        	},850);
	        }
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
			block.pageSize = pageSize;
			var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        properties.setData({
	            parentWindow: context.parentWindow,
	            sourceView: context.sourceView,
	            pageSize:pageSize,
	            pageNum:pageNum
	        });
			var data = {
					pageNum : pageNum,
					pageSize : pageSize
			};
			var fromName=context.event.from.name;
			if(fromName=="waitDeptSign"||fromName=="waitDeptSignPatient"){
				var waitDeptSignChain = owner.getActionChain('waitDeptSignInit');
		        if(waitDeptSignChain) {
		            waitDeptSignChain.execute(data);
		        }
			}else if(fromName=="waitPersonSign"){
				this.waitPrepareOperations(context.operations,data);
			}else if(fromName=="alreadySign"){
				var alreadySignChain = owner.getActionChain('alreadySignInit');
		        if(alreadySignChain) {
		        	alreadySignChain.execute(data);
		        }
			}
		}
		
		
//        this.waitPrepareOperations(context.operations,data);
    },
    waitPrepareOperations: function(operations,data) {
         var url = this.url+'?userId='+IMER_GLOBAL.user.code+'&deptCd='+IMER_GLOBAL.department.code+'&pageNum='+data.pageNum+'&pageSize='+data.pageSize;
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.waitOnSuccess
         };
         operations.push(operation);
     },
     waitOnSuccess: function(operation) {
    	 var me=this;
    	 setTimeout(function() {
    		 var block = me.getBlock('content');
             var pageSize = block.pageSize;
             var m = operation.result;
             m.pageSize = pageSize;
             block.setData(m,'waitPersonSign');
    	 },200);
     }
});
