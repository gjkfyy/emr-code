Ext.define('iih.mr.qa.terminal_qa_patient.action.TerminalFinishAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		//    	this.callParent();
		this.showLoading();
		var data = context.data;
		var rb = this.getBlock('result');
//		var eventNm = context.event.name;
		var eventNm = context.eventNm;
		var grid;
		if(eventNm == 'finishDeptClick'){
			grid = rb.down('xapgrid');
		}else if(eventNm == 'finishTerminalClick'){
			grid = rb.down('xapgrid[name=alreadySignGrid]');
		}
		var enPk;
		var rs = context.record;
		if(rb){
			rb.eventNm = eventNm;
			rb.rs = rs;
			enPk=rs.data.pk; //就诊外键
		}
		
//		var rs = grid.getSelectionModel().getSelection();
		
		/***********************syh 增加了质控完毕按钮*/
		if(!enPk&&context.workScreen){
			enPk=IMER_GLOBAL.encounterSn;
			this.onFinishBtn=context.onFinishBtn;
			if(context.workScreen=="8"){//科室质控
				this.url='qa/qaCompletedDept/amr';
			}
			if(context.workScreen=="4"){//终末质控
				this.url='qa/qaCompleted/amr';
			}
		}
		
		var qaDeptTerminalParalle;
		//科室终末并行
		if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
        	qaDeptTerminalParalle =  'true';
        }else{
        	qaDeptTerminalParalle =  'false';
        }
		var operations = context.operations;
		var url = this.url;
		url += '/'+enPk + "?qaDeptTerminalParalle=" + qaDeptTerminalParalle ;
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
	},
	onSuccess : function(operation) {
		/***********************syh 增加了质控完毕按钮*/
		if(this.onFinishBtn){
			this.onFinishBtn.setDisabled(true);
			return;
		}
		
		var view = this.getOwner();
		var block = this.getBlock('result');
		if(block)
		var eventNm = block.eventNm;
		var grid;
		if(eventNm == 'finishDeptClick'){		//判断是科室质控的完成还是终末质控的完成
			grid = block.down('xapgrid');
		}else if(eventNm == 'finishTerminalClick'){
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
