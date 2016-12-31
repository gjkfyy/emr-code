Ext.define('iih.sy.userinfo.action.RoleInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
//    	this.callParent();
         var operations = context.operations;
    	 if(!operations) {
    		 return;
    	 }
    	 var url = this.url;
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('right');// 当前block是UserInfoRightBlock
        var m = operation.result;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setGridData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
            block.setGridData(m);
        }
        // var r = rb.getData();
    }
});
