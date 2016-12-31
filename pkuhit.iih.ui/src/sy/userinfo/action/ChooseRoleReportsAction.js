Ext.define('iih.sy.userinfo.action.ChooseRoleReportsAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	requires : [],
	
	execute: function(context) {
        var operations = context.operations;
        var block = this.getOwner().getBlock('left');
        var reportGrid = block.down('xapgrid'); //获取角色列表
        var selModel = reportGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
        var roleCode = record.data.code;;//获取选中的角色ID
    	if(!operations) {
    		return;
    	}
    	var url = this.url;
    	url+= '?roleCode=' + roleCode;
    	var operation = {
            url: url,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getOwner().getBlock('right');
        var m = operation.result;
        var reportGrid = block.down('xapgrid'); //获取报表列表
		var reportData = reportGrid.getData();  
		reportGrid.getSelectionModel().deselectAll(true); //清空已选中的
		var reportList = m.dataList;
		if(null != reportList && reportList.length > 0){
			for (i = 0; i < reportList.length; i++) {
				for(j=0;j<reportData.length;j++){
					if(reportList[i].reportCd == reportData[j].reportCd){
						reportGrid.getSelectionModel().select(j,true,true);//报表挨个选中
						reportData[j].code = reportList[i].code;
					}
				}
			}
		}
    }
});
