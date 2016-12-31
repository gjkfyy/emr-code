Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
		this. showLoading();
		
		var pageNum, pageSize;
		if(context.event == undefined){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		var block = this.getBlock('top');
		block.pageSize = pageSize;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize
		}
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView,
            pageSize:pageSize,
            pageNum:pageNum
        });
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
		
    	this.prepareOperations(operations, data);

	 },
	 prepareOperations: function(operations, data) {
	    var owner = this.getOwner();   
        var contentBlock = owner.getBlock('top');
	    /*var isVerifiedBox = contentBlock.down('xapgrid xapcheckbox');
        var verifiedChecked = isVerifiedBox.checked;
        var verified = 1;//默认勾选的启用checkbox
        if(!verifiedChecked){
        	verified = 0;
        }*/
	    var conditionStr = contentBlock.down('xapgrid xaptextfield[name=conditionStr]').value;
        var url = this.url;
        url += "?" + "verified=1"  ;
        if(conditionStr != undefined){
        	url += "&conditionStr=" + conditionStr;
        }
        if(data.pageSize != undefined && typeof(data.pageSize)!='object'){
			url += "&pageNum="+data. pageNum +"&pageSize="+data.pageSize;
		}
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('top');
        var m = operation.result; 
        var pageSize = block.pageSize;
        m.pageSize = pageSize;
        if(m.total>0) {
        	block.setData(m);
        }else {
        	block.setData([]);
        }
        var bottomBlock = this.owner.getBlock('bottom').getBlock('result');
        bottomBlock.setData(null);
    }
});
