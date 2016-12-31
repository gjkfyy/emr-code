Ext.define('iih.mr.qa.process_qa_search.action.InProcessWorkSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		
		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
			return;
		}
		var view = this.getBlock('condition');
        var block = view.getBlock('content');
    	var condition = block.getData();
    	var crtTimeStart = condition.crtTimeStart;
    	var crtTimeEnd = condition.crtTimeEnd;
    	var rfmTimeStart = condition.rfmTimeStart;
    	var rfmTimeEnd = condition.rfmTimeEnd;
    	if(crtTimeEnd != ""){
    		if(crtTimeEnd < crtTimeStart){
				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
	    		return;
    		}
    	}
    	if(rfmTimeEnd != ""){
    		if(rfmTimeEnd < rfmTimeStart){
				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
	    		return;
    		}
    	}
    	
		this.showLoading();
		var block = this.getBlock('result');
		var curDeptNm = context.curDeptNm;
		var crtUserNm = context.crtUserNm;
		var currentManageDoctorName = context.currentManageDoctorName;
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
            curDeptNm:curDeptNm,
            crtUserNm:crtUserNm,
            currentManageDoctorName:currentManageDoctorName
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
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
        var view = this.getBlock('condition');
        var block = view.getBlock('content');
    	var condition = block.getData();
    	if(data.curDeptNm != undefined){
    		condition.curDeptNm = data.curDeptNm;
    	}
    	if(data.crtUserNm != undefined){
    		condition.crtUserNm = data.crtUserNm;
    	}
    	if(data.currentManageDoctorName != undefined){
    		condition.currentManageDoctorName = data.currentManageDoctorName;
    	}
        var url = this.url;
        var pageNum = data.pageNum; 
		var pageSize = data.pageSize; 
		var isNurseRole = iih.mr.qa.QaStatusGlobal.isNurseRole;	//如果为护士角色，则过滤文书为护理相关文书
		
        if(condition) {
            var qs = Ext.Object.toQueryString(condition);
//            alert(qs);
            
            	if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
            		if(qs) {
            			url += '?' + qs +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess + "&isNurseRole=" + isNurseRole;
            		}else{
            			url += '?' +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess + "&isNurseRole=" + isNurseRole;
            		}
            	}else{
            		if(qs) {
                		url += '?' + qs +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess + "&isNurseRole=" + isNurseRole +"&pageNum="+ pageNum +"&pageSize="+ pageSize;
            		}else{
            			url +='?' + "&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess + "&isNurseRole=" + isNurseRole + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
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
				var look = grid.down('button[method=look]');
				if(rs.length > 0){
					look.setDisabled(false);
				}else{
					look.setDisabled(true);
				} 
	        }
        }
    }
});
