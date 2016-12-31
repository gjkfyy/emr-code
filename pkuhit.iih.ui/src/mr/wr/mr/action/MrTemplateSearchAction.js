Ext.define('iih.mr.wr.mr.action.MrTemplateSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var newValue = context.newValue;
	    this.prepareOperations(context.operations,newValue);
    },
    prepareOperations: function(operations,newValue) {
        var block = this.getBlock('condition');
        var condition = block.getData();
        var mainDiCd = IMER_GLOBAL.mainDiCd;
        console.log(IMER_GLOBAL);
        var departCode = IMER_GLOBAL.department.code;//登陆科室编码
        var userCode = IMER_GLOBAL.user.code;//登陆用户
        var hospitalArea = IMER_GLOBAL.hospitalArea.code;//全院
        
        var url = this.url;
        if(condition) {
        	var cond = condition;
        	var ownerCode = "";
        	if(condition.dept){
        		//如果newValue不为undefined则为切换科室时触发的init操作
        		if(newValue!=undefined){
	        		ownerCode = ownerCode + "," + newValue;
	        	}else{
	        		if(condition.deptCode){
		        		ownerCode = ownerCode + "," + cond.deptCode;
		        	}else{
		        		ownerCode = ownerCode + "," + departCode;
		        	}
	        	}
        	}
        	if(condition.personal){
        		ownerCode = ownerCode + "," + userCode;
        	}
        	if(condition.all){
        		ownerCode = ownerCode  + "," + hospitalArea;
        	}
            ownerCode=ownerCode.substr(1);
        	
        	var typeCode = condition.typeCode;
	        if(typeCode==""){
	        	return ;
	        }
        	var templateNm = condition.templateNm;
        	
        	if(typeCode==""||typeCode=="ALL"){
        		cond = {'mrCategoryCode':condition.mrCategoryCode,'ownerCode':ownerCode,'name':templateNm};
        	}else{
        		cond = {'typeCode':condition.typeCode,'ownerCode':ownerCode,'name':templateNm};
        	}
            var qs = Ext.Object.toQueryString(cond);
            if(qs){
                url += '?' + qs;
            }
        };
        url=url+'&addSignLevel=1&mainDiCode='+mainDiCd+'&signDeptCode='+departCode+'&statusCode=MRM07.05&enTypeCode=ENM01.04&pageNum=1&pageSize=100000';
//        console.log(url);
        var operation = {
            url: url,
            method: 'get',
            condition: condition,
            scope: this,
            success: this.onSuccess
        };
        operations.length=0;
        operations.push(operation);
    },
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        // TODO 数据格式就这样了？
        if(operation.result.dataList){
        	block.setData(operation.result.dataList);
        }else{
        	block.setData([]);
        };
        //新建画面确定按钮置灰
        var bottom = this.getOwner().ownerCt.getBlock('bottom');
		var confim=bottom.down('button[name=confim]');
		confim.setDisabled(true);
		//判断结果集是否为一条数据，如果为一条则选中
		var grid = block.down('xapgrid');
		var length = grid.store.data.length;
		if(length>0){
			grid.getSelectionModel().select(0,false,true);
			var select = grid.getSelectionModel().getSelection()[0];
			grid.fireEvent('itemclick',grid, select, null, 0, null, null);
		}
    }
});
