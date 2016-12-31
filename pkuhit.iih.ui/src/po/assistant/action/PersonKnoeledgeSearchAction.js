Ext.define('iih.po.assistant.action.PersonKnoeledgeSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	execute: function(context) {
	    this.showLoading();
		this.prepareOperations(context.operations);
	},
	prepareOperations: function(operations) {
		var block = this.getOwner().getBlock('west');//得到MrKnowledgeBlock
		var personal=block.down('[name=personal]');//个人
	    var dept=block.down('[name=dept]');//科室
	    var name=block.down('xaptrigger[name=fragmentTplNm]');//名称
		var checkPersonal =personal.getValue();
		var checkDept =dept.getValue();
		var inName =name.getValue();
		var data = {'userId':IMER_GLOBAL.user.code,'deptCd':IMER_GLOBAL.department.code};
		if(checkPersonal){//传入后台，用于判断复选框的选择情况。
			data.personal="personal";
		}
		if(checkDept){
			data.dept="dept";
		}
		if(inName!=""){//按名称查询
			data.inName=inName;
		}
		//var url = this.url+'?userId='+IMER_GLOBAL.user.code+'&deptCd='+IMER_GLOBAL.department.code+'&searchData='+data;
		var url = this.url;
		var METHODS = this.getInvocationMethods();
		var operation = {
			url: url,
			method: METHODS.METHOD_UPDATE,
			data:data,
			scope: this,
			success: this.onSuccess
		};
		operations.push(operation);
	},
	onSuccess: function(operation) {
		//插入值
		var block = this.getBlock('result');
		if(operation.result.dataList){
			block.setData(operation.result.dataList);
		}else{
			block.setData({});
		}
	}    
});
