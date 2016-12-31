Ext.define('iih.sy.userinfo.action.ReportSaveAction', {
	extend : 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations);
    },
    
    prepareOperations: function(operations) {
        var roleGrid = this.getBlock('result').getBlock('left').down('xapgrid');
        var select = roleGrid.getSelectionModel().getSelection()[0];
        if(select==undefined){
        	var message = '请选择角色！';
            XapMessageBox.info(message);
            return;
        }
        var reportGrid = this.getBlock('result').getBlock('right').down('xapgrid');
        var reportList = reportGrid.getSelectionModel().getSelection();
        var roleReportList = [];
    	for(var i in reportList){
    		var report = reportList[i].data;
    		for(var j in report){
    			 report[j]['reportCd'] = report.reportCd;
    		}
    		roleReportList[i] = report;
		}
	    	
    	var data = {'roleCd':select.data.code, 'roleReportList':roleReportList};
    	console.log(data);
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var mclass = null;
    	var operation = {
            url: url + '/' + select.data.code,
    		mclass: mclass,
    		method: METHODS.METHOD_UPDATE,
    		data : data,
    		scope: this,
    		success: this.onSuccess,
            fail: this.onFail
    	};
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        XapMessageBox.info("保存成功");
    },
    onFail: function(operation) {
        XapMessageBox.info("保存失败");
    }
});
