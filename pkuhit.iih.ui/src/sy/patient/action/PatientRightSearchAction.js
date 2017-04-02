Ext.define('iih.sy.patient.action.PatientRightSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires : [ 'iih.sy.patient.block.PatientRightGridBlock'],
	/*
	* @Override
	*/
	execute: function(context) {
    	var owner = this.getOwner();
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	//判断患者是否被选中
    	var block = owner.ownerCt.getBlock('left').getBlock('result');
  	    var grid = block.down('xapgrid');
  		var rb = grid.getSelectionModel().getSelection();
  		//var patientId = "000010012800_83";
  		if(rb.length == 0){
            return;
        }else{
        	this.showLoading();
          	patientId = rb[0].data.patientId;
          	this.prepareOperations(operations,context,patientId);
        }	
    },
    
    prepareOperations: function(operations,context,patientId) {
        var block = this.getOwner().getBlock('condition');
        //获取分页数
        var pageNum,pageSize ;
		if(context.event && context.event.name == "turnpage"){
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
    	var condition = block.getData();
    	condition.pageSize=pageSize;
    	this.getOwner().pageSize=pageSize;
        var url = this.url;
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            if(qs) {
                url += '/'  + patientId + "?"+qs;
            }
            console.log(url);
        }
        var mclass = null;
        if(block.getModelClass) {
            mclass = block.getModelClass();
        }
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
        var block = this.getBlock('result');
        console.log(operation.result);
        console.log(block);
        // TODO 数据格式就这样了？
        if(operation.result){
	        resultData=operation.result;
	        resultData.pageSize=operation.result.pageSize;
    	 	block.setData(resultData);
        }else{
       	 	block.setData(null);
        }
    }
});
