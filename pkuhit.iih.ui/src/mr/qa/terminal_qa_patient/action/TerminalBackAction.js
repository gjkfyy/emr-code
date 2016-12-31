Ext.define('iih.mr.qa.terminal_qa_patient.action.TerminalBackAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		var data = context.data;
		var rb = this.getBlock('result');
		if(context.event == undefined){
			var eventNm = context.name;
		}else{
			var eventNm = context.event.name;
		}
		
//		var eventNm = context.eventNm;
		var grid;
		if(eventNm == 'deptclick'){
			grid = rb.down('xapgrid');
		}else if(eventNm == 'terminalclick'){
			grid = rb.down('xapgrid[name=alreadySignGrid]');
		}
		rb.eventNm = eventNm;
		var rs = grid.getSelectionModel().getSelection()[0];
//		var rs = context.record;
		rb.rs = rs;
		if(rs.data){
			var enPk = rs.data.pk; //就诊外键
			var operations = context.operations;
			var url = this.url;
			url += '/'+enPk;
			var METHODS = this.getInvocationMethods();
		    var mclass = null;
			var operation = {
				url : url,
				method: 'put',
				scope : this,
				success : this.onSuccess
				// fail: this.onFail
			};
			operations.length = 0;
			operations.push(operation);
		}else{
			XapMessageBox.info("请选择患者！");
			return;
		}
	},
	onSuccess : function(operation) {
		var view = this.getOwner();
		var block = this.getBlock('result');
		var eventNm = block.eventNm;
		var grid;
		if(eventNm == 'deptclick'){		//判断是科室质控的打回还是终末质控的打回
			grid = block.down('xapgrid');
		}else if(eventNm == 'terminalclick'){
			grid = block.down('xapgrid[name=alreadySignGrid]');
		}
		var rs = block.rs;
		var pageSize = block.pageSize;
		var initChain = view.getActionChain('search');
		initChain.execute({
			rs:rs,
			pageSize:pageSize
		});
	}     
});
