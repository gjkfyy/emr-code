var formatDate =function (date) {
    	if(date==0||date==""||date=="null"||date==null){
    		return null;
    	}
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        return y + '-' + m + '-' + d;
    };
Ext.define('iih.mr.archive.patient_mediclRecord_archive.action.PatientListSearchAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
    			return;
    		}
    		var view = this.getOwner().getBlock('condition');
            var block = this.getOwner().getBlock('content');
            var currentDeptCode="";
            if(!context.newValue){
            	currentDeptCode= view.down('comboxgrid[name=curDeptNm]').getValue();
            }else{
            	currentDeptCode=context.newValue;
            }
    		var receiveTime= view.down('xapdatefield[name=crtTimeStart]').getValue();
    		var finishTime= view.down('xapdatefield[name=crtTimeEnd]').getValue();
    		var amrNo= view.down('xaptextfield[name=amrNo]').getValue();
    		var patientName= view.down('xaptextfield[name=patientName]').getValue();
    		var qaF= view.down('radiogroup[name=checkQa]').getValue().qaF;
    		var arcF= view.down('radiogroup[name=checkArc]').getValue().arcF;
    		
    		if(receiveTime != "" && finishTime!=""){
        		if(finishTime < receiveTime){
    				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
    	    		return;
        		}
        	}
    		this.showLoading();
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
    				currentDeptCode : currentDeptCode,
    				receiveTime : formatDate(receiveTime),
    				finishTime:formatDate(finishTime),
    				amrNo:amrNo,
    				patientName:patientName,
    				pageNum:pageNum,
					pageSize:pageSize,
					qaF:qaF,
					arcF:arcF
    		};
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
            var view = this.getOwner().getBlock('condition');
            var block = this.getOwner().getBlock('content');
        	var condition = view.getData();
        	if(data.currentDeptCode != undefined){
        		condition.currentDeptCode = data.currentDeptCode;
        	}
        	if(data.receiveTime != undefined){
        		condition.receiveTime = data.receiveTime;
        	}
        	if(data.finishTime != undefined){
        		condition.finishTime = data.finishTime;
        	}
        	if(data.amrNo != undefined){
        		condition.amrNo = data.amrNo;
        	}
        	if(data.patientName != undefined){
        		condition.patientName = data.patientName;
        	}
        	if(data.qaF != undefined){
        		condition.qaF = data.qaF;
        	}
        	if(data.arcF != undefined){
        		condition.arcF = data.arcF;
        	}
            var url = this.url;
            var pageNum = data.pageNum; 
    		var pageSize = data.pageSize; 
            if(condition) {
                var qs = Ext.Object.toQueryString(condition);
                	if(data.pageSize == undefined || typeof(data.pageSize)=='object'){
                		if(qs) {
                			url += '?' + qs; //+"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
                		}else{
                			url += '?';// +"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess;
                		}
                	}else{
                		if(qs) {
                    		url += '?' + qs+"&pageNum="+ pageNum +"&pageSize="+ pageSize;//+"&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess 
                		}else{
                			url +='?' + "pageNum="+ pageNum +"&pageSize="+ pageSize;// + "&workScreen=" + iih.mr.qa.QaStatusGlobal.workScreenWorkProcess
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
            var block = this.getOwner().getBlock('content');
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
    	     
            }
            var grid =block.down('xapgrid');
            
            
            var reds=grid.getSelectionModel().getSelection();
    		var btn=this.getOwner().getBlock('content').down('button[name=selectArchive]');
    		if(reds&&reds.length>0){
    			btn.setDisabled(false);
    		}else{
    			btn.setDisabled(true);
    		}

        }
    });
