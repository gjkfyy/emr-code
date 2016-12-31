Ext.define('iih.mr.qa.score.action.ScoreQAPatientListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) {
		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
			return;
		}
    	var owner = this.getOwner();
    	this.showLoading();
    	var block = this.getBlock('result');
    	var pageNum ;
    	var pageSize ;
    	if(context.pageSize == undefined){
    		pageSize = context.pageSize;
    		pageNum = context.pageNum;
    	}else{
    		pageNum = context.event.arguments[0]; 
			pageSize = context.event.arguments[1]; 
    	}
		block.pageSize = pageSize;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize,
			curDeptNm :context.curDeptNm
		}
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView,
            pageSize:pageSize,
            pageNum:pageNum
        });
    	var rs = context.rs;
    	this.rs = rs;
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
    	var owner = this.getOwner();
    	var block = this.getBlock('condition');
    	var condition = block.getData();
    	var typeFlag = owner.typeFlag;
    	var ifScore = condition.score;
    	var amrStatus = "";
    	var terminalQaStaCd = "";//终末质控状态
    	var deptQaStaCd = "";//科室质控状态
    	var qaDeptTerminalParalle;
    	 if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
         	qaDeptTerminalParalle =  'true';
         }else{
         	qaDeptTerminalParalle =  'false';
         }
    	//科室、终末质控并行 则赋值终末质控状态
		if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
			if(typeFlag == '1'){//终末质控
	    		if(ifScore =='1'){
	    			terminalQaStaCd = iih.mr.qa.QaStatusGlobal.qaCompleted;//待评分  完成终末质控
	    		}else if(ifScore =='2'){
	    			terminalQaStaCd = iih.mr.qa.QaStatusGlobal.qaScored;//已评分  
	    		}
	    	}else if(typeFlag == '2'){//科室质控
	    		if(ifScore =='1'){
	    			deptQaStaCd = iih.mr.qa.QaStatusGlobal.qaDept;//评分  已科室质控
	    		}else if(ifScore =='2'){
	    			deptQaStaCd = iih.mr.qa.QaStatusGlobal.qaDeptScored;//已评分  已科室质控
	    		}
	    		
	    	}
		}else{
			if(typeFlag == '1'){//终末质控
	    		if(ifScore =='1'){
	    			amrStatus = iih.mr.qa.QaStatusGlobal.qaCompleted;//待评分  完成终末质控
	    		}else if(ifScore =='2'){
	    			amrStatus = iih.mr.qa.QaStatusGlobal.qaScored;//已评分  
	    		}
	    	}else if(typeFlag == '2'){//科室质控
	    		if(ifScore =='1'){
	    			amrStatus = iih.mr.qa.QaStatusGlobal.qaDept;//评分  已科室质控
	    		}else if(ifScore =='2'){
	    			amrStatus = iih.mr.qa.QaStatusGlobal.qaDeptScored;//已评分  已科室质控
	    		}
	    		
	    	}
		}
    	
    	if(data.curDeptNm != undefined){
    		condition.curDeptNm = data.curDeptNm;
    	}
        var url = this.url;
        var pageNum = data.pageNum; 
		var pageSize = data.pageSize;
        if(condition) {
	        var qs = Ext.Object.toQueryString(condition);
	//            alert(qs);
	        if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
        		if(qs) {
        			url += '?' + qs+"&amrStatus=" + amrStatus + "&terminalQaStaCd=" + terminalQaStaCd + "&deptQaStaCd=" + deptQaStaCd + "&qaDeptTerminalParalle=" + qaDeptTerminalParalle;
        		}else{
        			url += '?' + "amrStatus=" + amrStatus + "&terminalQaStaCd=" + terminalQaStaCd + "&deptQaStaCd=" + deptQaStaCd + "&qaDeptTerminalParalle=" + qaDeptTerminalParalle;
        		}
	    	}else{
	    		if(qs) {
	        		url += '?' + qs+"&amrStatus=" + amrStatus  + "&terminalQaStaCd=" + terminalQaStaCd + "&deptQaStaCd=" + deptQaStaCd + "&qaDeptTerminalParalle=" + qaDeptTerminalParalle + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
	    		}else{
	    			url +='?' +"amrStatus=" + amrStatus  + "&terminalQaStaCd=" + terminalQaStaCd + "&deptQaStaCd=" + deptQaStaCd + "&qaDeptTerminalParalle=" + qaDeptTerminalParalle + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
	    		}
	    	}
            /*if(qs) {
                	url += '?' + qs+"&workScreen="+iih.mr.qa.QaStatusGlobal.workScreenWorkTerminal;
            }*/
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
    	var me=this;
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
        
        //科室、终末动态显示、隐藏列
        var owner = this.getOwner();
    	var block = this.getBlock('result');
    	var condition = block.getData();
    	var typeFlag = owner.typeFlag;
    	var patientGrid = block.down('xapgrid');
    	if(typeFlag == '1'){//终末质控
    		Ext.getCmp("deptQaScr").hide();
    		Ext.getCmp("deptLvl").hide();
    		
        }else if(typeFlag == '2'){
        	Ext.getCmp("qaScr").hide();
    		Ext.getCmp("lvl").hide();
        	
        }
        
        //判断按钮状态
        var grid = block.down('xapgrid');
        if(grid){
        	var rs = grid.getSelectionModel().getSelection();
		    //评分按钮
			var score = grid.down('button[name=score]');
			if(rs.length > 0){
				score.setDisabled(false);
			}else{
				score.setDisabled(true);
			} 
        }
        /*if(me.rs != undefined){
        	var enPk=me.rs.data.pk;
        	var grid = block.down('xapgrid');
	        var gridData=grid.getData();
	        var rowIndex= 0;
	        for(var i=0;i<gridData.length;i++){
	        	var gridEnPkb=gridData[i].pk;
	        	if(enPk == gridEnPkb){
	        		rowIndex=i;
	        		break;
	        	}
	        }
        	var grid = block.down('xapgrid');
        	grid.getSelectionModel().select(rowIndex);
        	var openTerminal = grid.down('button[name=openTerminal]');
	        var inTerminal = grid.down('button[name=inTerminal]')
	        openTerminal.setDisabled(true);
	        inTerminal.setDisabled(false);
        }*/
    }
});
