Ext.define('iih.mr.qa.terminal_qa_patient.action.TerminalSignAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
        var rb = this.getBlock('result');
		var grid = rb.down('xapgrid[name=waitSignGrid]');
		var rs = grid.getSelectionModel().getSelection();
        var select = [];
        var qaDeptTerminalParalle;
        if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
        	qaDeptTerminalParalle =  'true';
        }else{
        	qaDeptTerminalParalle =  'false';
        }
        if (rs.length > 0) {
            for (i = 0; i < rs.length; i++) {
            	select[i] = rs[i].data;
            }
            var data = {'datas':select,'qaDeptTerminalParalle':qaDeptTerminalParalle,"qaTypeCd":iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal};
            var operations = context.operations;
	    	if(!operations) {
	    		return;
	    	}
	    	operations.length = 0;
	    	
	    	this.prepareOperations(operations,data);
        }else{
            XapMessageBox.info("请选择患者！");
        };
	},
	
	prepareOperations: function(operations,data) {
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var mclass = null;
    	var operation = {
            url: url,
            method: 'put',
    		data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
	onSuccess : function(operation) {
		var view = this.getOwner();
		var block = this.getBlock('result');
		var grid = block.down('xapgrid[name=waitSignGrid]');
		var rs = grid.getSelectionModel().getSelection()[0];
		var pageSize = block.pageSize;
		var initChain = view.getActionChain('search');
		initChain.execute({
			rs:rs,
			pageSize:pageSize
		});
	}     
});
