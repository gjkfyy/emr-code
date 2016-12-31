Ext.define('iih.sy.userinfo.action.UserDeptRefreshAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
    	this.callParent();
    	var block = this.getOwner();
//         var userId = block.userId;		//用户ID
         var userId = block.xapUserPk;		//用户ID
         console.log(this.getOwner());
         var operations = context.operations;
    	 if(!operations) {
    		 return;
    	 }
    	 var url = this.url;
        url += '?' + "userId="+userId;
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().down("xapgrid[name=deptgrid]");
        var m = operation.result;
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        } else {
            block.setData(m);
        }
    }
});
