Ext.define('iih.mr.qa.terminal_qa_patient.action.TerminalQAPatientListSearchAction', {
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
    	var specialMr = block.down('xapcombobox[name=specialMr]');
    	var blank = block.down('xapdisplayfield[name=blank]');
		if(CONFIG_PARAM.QA_SPECIAL_MR_ENABLE == true){
			specialMr.hidden = false;
			blank.hidden = true;
		}else{
			specialMr.hidden = true;
			blank.hidden = false;
		}
        var tabpanel = block.down('xaptabpanel');
        var grid = tabpanel.getActiveTab();
        var groupType = grid.groupType;
        
        //已签收患者
        if(groupType == '2'){
        	//打回按钮
			var back = grid.down('button[method=back]');
			back.on('click',function(btn){
			XapMessageBox.confirm2 (
			'确认打回？',
			function(btn){
				if(btn == 'yes'){
					if(context.event == undefined){
						context.name = 'terminalclick'; //点击完成本次质控后，点击完成
					}else{
						context.event.name='terminalclick';
					}
					var backChain = owner.getActionChain("back");
					backChain.execute(context);
					}
				});
			});
		
			//进入终末质控按钮
			var inTerminal = grid.down('button[method=inTerminal]');
			inTerminal.on('click',function(btn){
				var inTerminalChain = owner.getActionChain("inTerminal");
				inTerminalChain.execute(context);
			});
        	
        	/*//完成终末质控按钮
			var finishTerminal = grid.down('button[name=finishTerminal]');
			finishTerminal.on('click',function(btn){
				context.event.name='finishTerminalClick';
				var finishTerminalChain = owner.getActionChain("finishTerminal");
				finishTerminalChain.execute(context);
			});*/
        }
	
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
		block.groupType = groupType;
		var data = {
			pageNum : pageNum,
			pageSize : pageSize,
			groupType : groupType,
			curDeptNm : context.curDeptNm
		}
		
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView,
            pageSize:pageSize,
            pageNum:pageNum,
            groupType:groupType
        });
    	var rs = context.rs;
    	this.rs = rs;
    	
    	var msgInfo = block.down('xapdisplayfield[name=msgInfo]');
    	if(groupType == '2'){
    		var beginTime = block.down('xapdatefield[name=beginTime]').rawValue;
        	var endTime = block.down('xapdatefield[name=endTime]').rawValue;
        	var beginTimes = grid.down('xapform').getData().beginTime;
        	var endTimes = grid.down('xapform').getData().endTime;
        	data.beginTime = beginTime;
        	data.endTime = endTime;
        	if(beginTime !=''&& endTime != ''&& (beginTimes-endTimes > 0)){
    			var errorText = '开始时间不能大于结束时间！';
    			msgInfo.setValue('<font color=red>' + errorText + '</font>');
//    			return '';
        	}else{
        		if(beginTime != null && beginTime !=''){
        			data.beginTime = beginTime + " 00:00:00";
        		}
        		if(endTime != null && endTime !=''){
        			data.endTime = endTime + " 23:59:59";
        		}
        		msgInfo.setValue('');
        	}
    	}
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    },
    
    prepareOperations: function(operations,data) {
    	var block = this.getBlock('result');
        var tabpanel = block.down('xaptabpanel');
        var grid = tabpanel.getActiveTab();
//        var curDeptNm = grid.down('comboxgrid[method=curDeptNm]')
//        var value = curDeptNm.value;
        var curDeptNm;
        if(data.curDeptNm != undefined){
    		curDeptNm = data.curDeptNm;
    	}else{
    		curDeptNm = grid.down('xapform').getData().curDeptNm;
    	}
    	var amrNo = grid.down('xapform').getData().amrNo;
    	var patientName = grid.down('xapform').getData().patientName;
    	var qaAutoScrMin = grid.down('xapform').getData().qaAutoScrMin;
    	var qaAutoScrMax = grid.down('xapform').getData().qaAutoScrMax;
    	
    	var owner = this.getOwner();
    	var typeFlag = owner.typeFlag;
    	var amrStatus;
    	var terminalQaStaCd = "";//终末质控状态
    	//待签收患者一览
    	if(typeFlag == '2' && data.groupType == '1'){
    		//科室、终末质控并行
    		if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
    			amrStatus = iih.mr.qa.QaStatusGlobal.writeCompleted;//病案状态为书写已完成
    		}else{
    			if(CONFIG_PARAM.QA_DEPT_ENABLE){
        			amrStatus = iih.mr.qa.QaStatusGlobal.qaDeptScored;//病案状态为已科室评分
        		}else{
        			amrStatus = iih.mr.qa.QaStatusGlobal.writeCompleted;//待签收，病案状态为书写已完成
        		}
    		}
    		
    		//amrStatus = iih.mr.qa.QaStatusGlobal.qaDeptScored;//待审签 暂时不做科室质控，病案状态为已科室评分 wangyanli注释掉，改为以上实现方式：根据有无科室质控功能区分病案状态
    	
    	}else if(typeFlag == '2' && data.groupType == '2'){//已签收患者一览
    		//科室、终末质控并行 则赋值终末质控状态
    		if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
    			amrStatus = iih.mr.qa.QaStatusGlobal.writeCompleted;//病案状态为书写已完成
    			terminalQaStaCd = iih.mr.qa.QaStatusGlobal.qaStarted;//已签收
    			
    		}else{
    			
    			amrStatus = iih.mr.qa.QaStatusGlobal.qaStarted;//已签收
    		}
    	}
    	var qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal; //质控类型为终末质控
//        var block = this.getBlock('condition');
//    	var condition = block.getData();
        var url = this.url;
        var pageNum = data.pageNum; 
		var pageSize = data.pageSize;
//        if(condition) {
//	        var qs = Ext.Object.toQueryString(condition);
	        if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
        		if(curDeptNm) {
        			url += '?curDeptNm=' + curDeptNm + "&amrNo=" + amrNo+ "&patientName=" + patientName + "&beginTime=" + data.beginTime + "&endTime=" + data.endTime +"&amrStatus=" + amrStatus+"&qaTypeCode=" +qaTypeCode +"&qaAutoScrMin=" +qaAutoScrMin+"&qaAutoScrMax=" +qaAutoScrMax + "&terminalQaStaCd=" +terminalQaStaCd;
        		}else{
        			url += '?' + "amrStatus=" + amrStatus+"&qaTypeCode=" +qaTypeCode + "&amrNo=" + amrNo+ "&patientName=" + patientName + "&beginTime=" + data.beginTime + "&endTime=" + data.endTime+"&qaAutoScrMin=" +qaAutoScrMin+"&qaAutoScrMax=" +qaAutoScrMax + "&terminalQaStaCd=" +terminalQaStaCd;
        		}
	    	}else{
	    		if(curDeptNm) {
	        		url += '?curDeptNm=' + curDeptNm + "&amrNo=" + amrNo+ "&patientName=" + patientName + "&beginTime=" + data.beginTime + "&endTime=" + data.endTime+"&amrStatus=" + amrStatus +"&qaTypeCode=" +qaTypeCode +"&qaAutoScrMin=" +qaAutoScrMin+"&qaAutoScrMax=" +qaAutoScrMax  + "&terminalQaStaCd=" +terminalQaStaCd + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
	    		}else{
	    			url +='?' +"amrStatus=" + amrStatus +"&qaTypeCode=" + qaTypeCode + "&amrNo=" + amrNo+ "&patientName=" + patientName + "&beginTime=" + data.beginTime + "&endTime=" + data.endTime +"&qaAutoScrMin=" +qaAutoScrMin+"&qaAutoScrMax=" +qaAutoScrMax  + "&terminalQaStaCd=" +terminalQaStaCd + "&pageNum="+ pageNum +"&pageSize="+ pageSize;
	    		}
	    	}
            /*if(qs) {
                	url += '?' + qs+"&workScreen="+iih.mr.qa.QaStatusGlobal.workScreenWorkTerminal;
            }*/
            console.log(url);
//        }
        var mclass = null;
        /*if(block.getModelClass) {
            mclass = block.getModelClass();
        }*/
    	var operation = {
            url: url,
    		mclass: mclass,
    		method: 'get',
//    		condition: condition,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var me=this;
    	var view = this.getOwner();
        var block = this.getBlock('result');
        var pageSize = block.pageSize;
        var groupType = block.groupType;
        var m = operation.result;
        m.pageSize = pageSize;
        m.groupType = groupType;
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
        var grid;
        var rs;
        if(groupType == '1'){
        	grid = block.down('xapgrid[name=waitSignGrid]');
        	if(grid){
        		rs = grid.getSelectionModel().getSelection();
		    	//终末审签按钮
				var sign = grid.down('button[method=sign]');
		    	if(rs.length > 0){
					sign.setDisabled(false);
				}else{
					sign.setDisabled(true);
				} 
        	}
        }else if(groupType == '2'){
        	grid = block.down('xapgrid[name=alreadySignGrid]');
        	if(grid){
        		rs = grid.getSelectionModel().getSelection();
		    	var back = grid.down('button[name=back]');
		    	var inBtn = grid.down('button[name=inTerminal]');
//				var finishBtn = grid.down('button[name=finishTerminal]');
		    	if(rs.length > 0){
					back.setDisabled(false);
					inBtn.setDisabled(false);
//					finishBtn.setDisabled(false);
					/*var judgeStateChain = view.getActionChain('judgeState');
					var event = {name:'itemclick'};
					judgeStateChain.execute({
						event:event
					});*/
				}else{
					back.setDisabled(true);
					inBtn.setDisabled(true);
//					finishBtn.setDisabled(true);
				} 
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
