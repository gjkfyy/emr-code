Ext.define('iih.mr.qa.terminal_qa_patient.action.JudgeStateAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var rb = this.getBlock('result');
		var eventNm = context.event.name;
		var grid;
		var qaTypeCode;
		if(eventNm == 'select'){
			grid = rb.down('xapgrid');
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept; //质控类型为科室质控
		}else if(eventNm == 'itemclick'){
			grid = rb.down('xapgrid[name=alreadySignGrid]');
			qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal; //质控类型为终末质控
		}
		rb.eventNm = eventNm;
		 var rs=grid.getSelectionModel().getSelection();
         var pk = rs[0].data.pk;    //就诊外键
         var statusCode = rs[0].data.statusCode;    //病案状态
		 var operations = context.operations;
		 var url = this.url;
//		 url += '/'+pk;
		 url += '?' + "pk=" + pk + "&qaTypeCode="+ qaTypeCode;
		 var METHODS = this.getInvocationMethods();
         var mclass = null;
		 var operation = {
			url: url,
    		mclass: null,
    		method: 'get',
    		scope: this,
    		success: this.onSuccess
		};
		operations.length = 0;
		operations.push(operation);
	},
	onSuccess : function(operation) {
		var block = this.getBlock('result');
		var eventNm = block.eventNm;
		var grid;
		var finishBtn;
		var inBtn;
		if(eventNm == 'select'){		//判断是科室质控的单击还是终末质控的单击
			grid = block.down('xapgrid');
			inBtn = grid.down('button[name=inDept]');
			finishBtn = grid.down('button[name=finishDept]');
		}else if(eventNm == 'itemclick'){
			grid = block.down('xapgrid[name=alreadySignGrid]');
			inBtn = grid.down('button[name=inTerminal]');
			finishBtn = grid.down('button[name=finishTerminal]');
		}
		var back = grid.down('button[name=back]');
        var m = operation.result;
        if(m=="1"){
        	back.setDisabled(false);
        	finishBtn.setDisabled(true);
        	inBtn.setDisabled(false);
        }else{
        	back.setDisabled(false);
        	finishBtn.setDisabled(false);
        	inBtn.setDisabled(false);
        } 
	}     
});
