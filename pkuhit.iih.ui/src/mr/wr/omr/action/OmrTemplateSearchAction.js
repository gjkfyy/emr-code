Ext.define('iih.mr.wr.omr.action.OmrTemplateSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		//科室下拉列表中的最新数据，改变下拉值时触发
		var opType=this.getOwner().ownerCt.ownerCt.ownerCt.ownerCt.opType;
		if(opType&&(opType=='reSelectTemp'||opType=='reSelectMr')){
			var createomrview=this.getOwner().ownerCt.ownerCt.ownerCt.ownerCt;
			var mrDocNmText=createomrview.down('[name=mrNm]');
	        mrDocNmText.setVisible(false);
	        var logicSmtTimeDateFiled=createomrview.down('[name=logicSmtDate]');
	        logicSmtTimeDateFiled.setVisible(false);
	        var higherLvlEmpId=createomrview.down('[name=higherLvlEmpId]');
	        higherLvlEmpId.setVisible(false);
		}
		var newValue = context.newValue;
	    this.prepareOperations(context.operations,newValue);
    },
    prepareOperations: function(operations,newValue) {
        var block = this.getBlock('condition');
        var data = block.getData();
        var url = this.url;
        if(data) {
            var departCode = null;
        	if(data.dept){
        		//如果newValue不为undefined则为切换科室时触发的init操作
        		if(newValue!=undefined){
        		    departCode = newValue;
	        	}else{
	        		if(data.deptCode){
	        		    departCode = data.deptCode;
		        	}else{
		        	    departCode = IMER_GLOBAL.department.code;//登陆科室编码
		        	}
	        	}
        	}
        	var userCode = null;
        	if(data.personal){
        	    userCode = IMER_GLOBAL.user.code;//登陆用户
        	}
        	var hospitalArea = null;
        	if(data.all){
        	    hospitalArea = IMER_GLOBAL.hospitalArea.code;//全院
        	}
        	
        	var typeCode = data.typeCode;
        	if(typeCode==""||typeCode=="ALL"){
        	    typeCode = null;
        	}
        	var templateNm = data.templateNm;
        	condition = {
    	        'mrCategoryCode':data.mrCategoryCode,
    	        'typeCode':typeCode,
    	        'name':templateNm,
    	        'hospitalArea':hospitalArea,
    	        'departCode':departCode,
    	        'userCode':userCode
        	}
            var qs = Ext.Object.toQueryString(condition);
            if(qs){
                url += '?' + qs;
            }
        }
        var operation = {
            url: url,
            method: 'get',
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        if(operation.result.dataList){
        	block.setData(operation.result.dataList);
        }else{
        	block.setData([]);
        }
		var grid = block.down('xapgrid');
		if(grid&&grid.store.data.length>0){
			grid.getSelectionModel().select(0,false,true);
			var select = grid.getSelectionModel().getSelection()[0];
			grid.fireEvent('itemclick',grid, select, null, 0, null, null);
		}
    }
});
