var formatDate =function (date,startorend) {
    	if(date==0||date==""||date=="null"||date==null){
    		return null;
    	}
        var y = date.getFullYear();
        var m = date.getMonth() + 1;
        m = m < 10 ? '0' + m : m;
        var d = date.getDate();
        d = d < 10 ? ('0' + d) : d;
        var hms_start = " 00:00:00" ;
        var hms_end = " 23:59:59" ;
        var hms = hms_start ;
        if(startorend == 'end'){
        	hms = hms_end ;
        }
        return y + '-' + m + '-' + d + hms;
    };
Ext.define('iih.mrb.action.PatientListSearchAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
    			return;
    		}
    		var view = this.getOwner().getBlock('condition');
            var block = this.getOwner().getBlock('content');
            //就诊类型
            var enTypeCode = '' ;
            var orgTypeCode =view.down('[name=enTypeCode]').getValue();
            console.log('orgTypeCode') ;
            console.log(orgTypeCode) ;
            if(orgTypeCode&&orgTypeCode != 'ALL'){
            	if(orgTypeCode == 'ORGM02.01'){
            		enTypeCode = 'ENM01.04';
            	} else if(orgTypeCode == 'ORGM02.05'){
            		enTypeCode = 'ENM01.01' ;
            	} else{
            		enTypeCode = 'ENM01.01' ;
            	}
            }
            console.log('就诊类型enTypeCode') ;
            console.log(enTypeCode) ;
            var currentDeptCode="";
            if(!context.newValue){
            	currentDeptCode= view.down('comboxgrid[name=curDeptNm]').getValue();
            }else{
            	currentDeptCode=context.newValue;
            }
            console.log('查询科室currentDeptCode') ;
            console.log(currentDeptCode) ;
            var currentDoctorCode = "";
            var doctorCodeFromCombobox =view.down('xapcombobox[name=doctorCodeList]').getValue();
            if(doctorCodeFromCombobox != 'ALL'){
            	currentDoctorCode = doctorCodeFromCombobox ;
            }
            console.log('查询医生currentDoctorCode') ;
            console.log(currentDoctorCode) ;
            var enCardTypeCode = "";
            var enCardTypeCodeFromCombobox =view.down('xapcombobox[name=enCardTypeCode]').getValue();
            if(doctorCodeFromCombobox != 'ALL'){
            	enCardTypeCode = enCardTypeCodeFromCombobox ;
            }
            console.log('急诊卡类别enCardTypeCode') ;
            console.log(enCardTypeCode) ;
            var currentConditionCode= view.down('xaptextfield[name=conditionCode]').getValue();
            console.log('唯一号currentConditionCode') ;
            console.log(currentConditionCode) ;
            
            var moblie= view.down('xaptextfield[name=mobile]').getValue();
            console.log('手机号码moblie') ;
            console.log(moblie) ;
            
            var conditionTypeCodeCombobox =view.down('xapcombobox[name=conditionTypeCode]').getValue();
            var idCardNo = '' ;
            var amrNo = '' ;
            var paId = '' ;
            	if(conditionTypeCodeCombobox == "icdCard"){
            		idCardNo = currentConditionCode ;
            	}else if(conditionTypeCodeCombobox == "amrNo"){
            		amrNo = currentConditionCode ;
            	}else if(conditionTypeCodeCombobox == "paId"){
            		paId = currentConditionCode ;
            	}


            
    		var startTime= view.down('xapdatefield[name=crtTimeStart]').getValue();
    		var endTime= view.down('xapdatefield[name=crtTimeEnd]').getValue();
    		
    		var patientName= view.down('xaptextfield[name=patientName]').getValue();
    		var checkArchive= view.down('radiogroup[name=checkArchive]').getValue().checkArchive;
    		
    		var mrTypes= view.down('xapcombobox[name=mrTypes]').getValue();
    		
    		if(startTime != "" && endTime!=""){
        		if(endTime < startTime){
    				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
    	    		return;
        		}
        	}
    		this.showLoading();
            console.log('context') ;
            console.log(context) ;

    		var pageNum = 1 ,pageSize =25 ;
    		if(context.event && context.event.name == "turnpage"){
	    		pageNum = context.event.arguments[0];
	    		pageSize = context.event.arguments[1];
    		}else {
    			pageNum = context.pageNum; 
    			pageSize = context.pageSize; 
    		}
    		block.pageSize = pageSize;
    		var data = {
    				'enTypeCode':enTypeCode,
    				'deptCode' : currentDeptCode,
    				'doctorCode':currentDoctorCode,
    				'startTime' : formatDate(startTime),
    				'endTime':formatDate(endTime,'end'),
    				'idCardNo':idCardNo,
    				'amrNo':amrNo,
    				'paId':paId,
    				'patientName':patientName,
    				'mobile':moblie,
    				'pageNum':pageNum,
					'pageSize':pageSize,
					'checkArchive':checkArchive,
					'mrTypes':mrTypes
    		};
            console.log('查询data') ;
            console.log(data) ;
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
        	console.log('condition');
        	console.log(condition);
        	/*if(data.enTypeCode != undefined){
        		condition.enTypeCode = data.enTypeCode;
        	}
        	if(data.deptCode != undefined){
        		condition.deptCode = data.deptCode;
        	}
        	if(data.doctorCode != undefined){
        		condition.doctorCode = data.doctorCode;
        	}
        	if(data.startTime != undefined){
        		condition.startTime = data.startTime;
        	}
        	if(data.endTime != undefined){
        		condition.endTime = data.endTime;
        	}
        	if(data.idCardNo != undefined){
        		condition.idCardNo = data.idCardNo;
        	}
        	if(data.amrNo != undefined){
        		condition.amrNo = data.amrNo;
        	}
        	if(data.paId != undefined){
        		condition.paId = data.paId;
        	}
        	if(data.patientName != undefined){
        		condition.patientName = data.patientName;
        	}
        	if(data.mobile != undefined){
        		condition.mobile = data.mobile;
        	}
        	if(data.checkArchive != undefined){
        		condition.checkArchive = data.checkArchive;
        	}
    		condition.pageNum = data.pageNum;
    		condition.pageSize = data.pageSize;
        	console.log('condition 合并之后');
        	console.log(condition);*/
            var url = this.url;
            var mclass = null;
            if(block.getModelClass) {
                mclass = block.getModelClass();
            }
        	console.log('mclass');
        	console.log(mclass);
        	var operation = {
                url: url,
        		mclass: mclass,
        		method: 'get',
        		//condition: condition,
        		params:data,
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
          
        }
    });
