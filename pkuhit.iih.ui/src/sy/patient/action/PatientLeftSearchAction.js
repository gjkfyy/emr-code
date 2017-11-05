Ext.define('iih.sy.patient.action.PatientLeftSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires : [ 'iih.sy.patient.block.PatientLeftGridBlock' ],
	/*
	* @Override
	*/
	execute: function(context) {
		this. showLoading();
    	var owner = this.getOwner();
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	/*var block = owner.getBlock('result');
    	block.setData({
            mclass: 'patientleftgridblock'
        });*/
    	
    	this.prepareOperations(operations,context);
    },
    
    prepareOperations: function(operations,context) {
        var block = this.getBlock('condition');
        var searchCondition = Ext.getCmp('searchCondition').getValue();
        //获取分页数
        var pageNum,pageSize ;
		if(context.event && context.event.name == "turnpage"){
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
       // console(orgCd.comboRecord);
    	var condition = block.getData();
    	console.log(condition.pageNum);
    	condition.pageNum=pageNum;
    	condition.pageSize=pageSize;
    	this.getOwner().pageSize=pageSize;
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(qs) {
                url += '?' + qs +'&condition=' + searchCondition;
            }
        }
        var mclass = null;
        if(block.getModelClass) {
            mclass = block.getModelClass();
        }
        console.log("##########"+url);
    	var operation = {
            url: url,
    		mclass: mclass,
    		method: 'get',
    		condition: condition,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var data;
   	 	var pageSize=this.getOwner().pageSize;
        var block = this.getOwner().getBlock('result');
        
        // TODO 数据格式就这样了？
        if(operation.result){
	        resultData=operation.result;
	        resultData.pageSize=pageSize;
	        console.log(resultData);
    	 	block.setData(resultData);
        }else{
       	 	block.setData(null);
        }
    }
});
