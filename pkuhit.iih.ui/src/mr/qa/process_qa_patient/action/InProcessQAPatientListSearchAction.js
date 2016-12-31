Ext.define('iih.mr.qa.process_qa_patient.action.InProcessQAPatientListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		this.showLoading();
		var operations = context.operations;
		
		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
			return;
		}
		var owner = this.getOwner();
		var block = this.getBlock('result');
		var curDeptNm = context.curDeptNm;
		var pageNum,pageSize;
		if(context.event == undefined ||context.event.arguments.length == 3){
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
			curDeptNm:curDeptNm
		}
    	var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView,
            pageSize:pageSize,
            pageNum:pageNum,
            curDeptNm:curDeptNm
        });
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
        var block = this.getBlock('condition');
        var topBlock = block.getBlock('content');
    	var condition = topBlock.getData();
    	if(data.curDeptNm != undefined){
    		condition.curDeptNm = data.curDeptNm;
    	}
    	var beginTime = block.down('xapdatefield[name=beginTime]').rawValue;
    	var endTime = block.down('xapdatefield[name=endTime]').rawValue;
    	if(beginTime != null && beginTime !=''){
    		condition.beginTime = beginTime + " 00:00:00";
    	}
    	if(endTime != null && endTime !=''){
        	condition.endTime = endTime + " 23:59:59";
    	}
        var url = this.url;
        var pageNum = data.pageNum; 
		var pageSize = data.pageSize; 
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
//            alert(qs);
            
            	if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
            		if(qs) {
            			url += '?' + qs +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
            		}else{
            			url += '?' +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
            		}
            	}else{
            		if(qs) {
                		url += '?' + qs +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess +"&pageNum="+ pageNum +"&pageSize="+ pageSize;
            		}else{
            			url +='?' + "&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
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
    	var owner = this.getOwner();
    	/*//添加获取用户的权限 wangyanli -------移到点击portal时进行
	    var chain = owner.getActionChain("qaWorkUserAcAction");
	    chain.execute();*/
        var block = this.getBlock('result');
        if(block){
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
			    //进入环节质控按钮
				var inProcess = grid.down('button[method=inProcess]');
				if(rs.length > 0){
					inProcess.setDisabled(false);
				}else{
					inProcess.setDisabled(true);
				} 
	        }
        }
    }
});
