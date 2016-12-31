Ext.define('iih.mr.qa.dept_qa_patient.action.DeptQAPatientListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
			return;
		}
		this.showLoading();
		var block = this.getBlock('result');
		var pageNum,pageSize;
		if(context.event == undefined){
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}else{
			pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
		}
		block.pageSize = pageSize;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize,
			curDeptNm : context.curDeptNm
		}
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView,
            pageSize:pageSize,
            pageNum:pageNum
        });
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
        var block = this.getBlock('condition');
    	var condition = block.getData();
    	if(data.curDeptNm != undefined){
    		condition.curDeptNm = data.curDeptNm;
    	}
        var url = this.url;
        var pageNum = data.pageNum; 
		var pageSize = data.pageSize; 
		var amrStatus = '';
		var deptQaStaCd = '';
		//科室、终末质控并行 则赋值终末质控状态
		if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
			amrStatus = iih.mr.qa.QaStatusGlobal.writeCompleted; //病案状态为书写已完成
			deptQaStaCd = "";//
			
		}else{
			
			amrStatus = iih.mr.qa.QaStatusGlobal.writeCompleted; //病案状态为书写已完成
		}
		
		
		var qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept; //质控类型为科室质控
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
//            alert(qs);
            	if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
            		if(qs) {
            			url += '?' + qs +"&amrStatus=" + amrStatus +"&qaTypeCode=" +qaTypeCode + "&deptQaStaCd=" +deptQaStaCd;
            		}else{
            			url += '?' +"amrStatus=" + amrStatus+"&qaTypeCode=" +qaTypeCode + "&deptQaStaCd=" +deptQaStaCd;
            		}
            	}else{
            		if(qs) {
                		url += '?' + qs +"&amrStatus=" + amrStatus +"&qaTypeCode=" +qaTypeCode + "&deptQaStaCd=" +deptQaStaCd +"&pageNum="+ pageNum +"&pageSize="+ pageSize;
            		}else{
            			url +='?' + "amrStatus=" + amrStatus +"&qaTypeCode=" +qaTypeCode + "&deptQaStaCd=" +deptQaStaCd + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
            		}
            	}
            console.log(url);
        }
        var mclass = null;
        if(block.getModelClass) {
            mclass = block.getModelClass();
        }
    	var operation = {
            url: url,
    		mclass: mclass,
    		method: 'get',
    		condition: condition,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var pageSize = block.pageSize;
        var m = operation.result;
        m.pageSize = pageSize;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
        	block.setData(m);
        	console.log(m);
        }
        
         //判断按钮状态
        var grid = block.down('xapgrid');
        if(grid){
		    var rs = grid.getSelectionModel().getSelection();
		    var inBtn = grid.down('button[name=inDept]');
//			var finishBtn = grid.down('button[name=finishDept]');
			var back = grid.down('button[name=back]');
			if(rs.length > 0){
				inBtn.setDisabled(false);
//				finishBtn.setDisabled(false);
				back.setDisabled(false);
			}else{
				inBtn.setDisabled(true);
//				finishBtn.setDisabled(true);
				back.setDisabled(true);
			} 
        }
    }
});
