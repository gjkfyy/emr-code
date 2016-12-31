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
Ext.define('iih.mrb.action.UseRateViewReportAction', {
    	extend: 'Xap.ej.action.ServiceInvocation',
    	execute: function(context) {
    		if(context.event != undefined && context.event.name=='combochange' && context.event.from.rawValue != ""){
    			return;
    		}
    		var view = this.getOwner().getBlock('condition');
            var block = this.getOwner().getBlock('content');
            //查询对象
            var currentUseRateTypeCode="";
            var useRateTypeCodeFromCombobox =view.down('xapcombobox[name=useRateTypeCode]').getValue();
            if(useRateTypeCodeFromCombobox != 'ALL'){
            	currentUseRateTypeCode = useRateTypeCodeFromCombobox ;
            }
            console.log('查询对象currentUseRateTypeCode') ;
            console.log(currentUseRateTypeCode) ;
	  		var us = view.down('xapcombobox[name=useRateTypeCode]').store;
            console.log('us') ;
            console.log(us) ;
	  		var usc = us.count ;
            console.log('usc') ;
            console.log(usc) ;
            var  viewUserId = '' ; 
            if(usc  <  3 ){
            	 viewUserId  =  IMER_GLOBAL.user.code; 
            }
            console.log('viewUserId') ;
            console.log(viewUserId) ;
            //就诊类型
            var enTypeCode = '' ;
            var orgTypeCode =view.down('[name=enTypeCode]').lastValue;
            
            console.log('组织类型orgTypeCode') ;
            console.log(orgTypeCode) ;
            console.log(view.down('[name=enTypeCode]'));
            if(orgTypeCode != 'ALL'){
            	if(orgTypeCode == 'ORGM02.01'){
            		enTypeCode = 'ENM01.04';
            	} else if(orgTypeCode == 'ORGM02.05'){
            		enTypeCode = 'ENM01.01' ;
            	} else if(orgTypeCode == 'ORGM02.06'){
            		enTypeCode = 'ENM01.02' ;
            	}else if(orgTypeCode == 'ORGM02.07'){
            		enTypeCode = 'ENM01.00' ;
            	}else if(orgTypeCode == 'ORGM02.08'){
            		enTypeCode = '' ;
            	}
            }
            
            console.log('就诊类型enTypeCode') ;
            console.log(enTypeCode) ;
            var currentDeptCode="";
            var deptCodeFromCombobox =view.down('xapcombobox[name=deptCodeList]').getValue();
            if(deptCodeFromCombobox != 'ALL'){
            	currentDoctorCode = doctorCodeFromCombobox ;
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
    		var startTime= view.down('xapdatefield[name=crtTimeStart]').getValue();
    		var endTime= view.down('xapdatefield[name=crtTimeEnd]').getValue();
    		if(startTime != "" && endTime!=""){
        		if(endTime < startTime){
    				 XapMessageBox.info("开始日期大于结束日期，请重新选择！");
    	    		return;
        		}
        	}
    		this.showLoading();
            console.log('context') ;
            console.log(context) ;
            //报表的id
            var rptId = "" ;
            //查询参数
            var reportParam = '';
	  		var useRateTypeCodeXapcombobox = block.down('xapcombobox[name=useRateTypeCode]');

            if(currentUseRateTypeCode == 'doctorType'){
            	rptId = "userate_employee" ;
            	reportParam += "deptCode="+currentDeptCode+";empId="+currentDoctorCode+";startDatetime="+ formatDate(startTime) +";endDatetime="+formatDate(endTime,'end')+";viewUserId="+viewUserId+";enTypeCode="+enTypeCode+";" ;
            }else if(currentUseRateTypeCode == 'deptType'){
            	rptId = "userate_dept" ;
            	 reportParam += "startDatetime="+ formatDate(startTime) +";endDatetime="+formatDate(endTime,'end')+";deptCode="+currentDeptCode+";viewUserId="+viewUserId+";enTypeCode="+enTypeCode+";" ;
            }else if(currentUseRateTypeCode == 'hosiptalType'){
            	if(orgTypeCode != 'ALL'){
            		rptId = "userate_hospital_muti_en" ;
            	}else{
            		rptId = "userate_hospital" ;
            	}
            	 reportParam += "startDatetime="+ formatDate(startTime) +";endDatetime="+formatDate(endTime,'end')+";enTypeCode="+enTypeCode+";" ;
            }
            
            +";viewUserId="+viewUserId+";enTypeCode="+enTypeCode+";" ;
            
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
    				'useRateTypeCode':currentUseRateTypeCode,
    				'orgTypeCode':orgTypeCode,
    				'enTypeCode':enTypeCode,
    				'deptCode' : currentDeptCode,
    				'doctorCode':currentDoctorCode,
    				'startTime' : formatDate(startTime),
    				'endTime':formatDate(endTime,'end'),
    				'rptId':rptId,
    				'reportParam':reportParam,
    				'pageNum':pageNum,
					'pageSize':pageSize
    		};
            console.log('查询data') ;
            console.log(data) ;
            console.log('context') ;
            console.log(context) ;
            this.getOwner().reportParam =  reportParam ;
            this.prepareOperations(context.operations,data);
            
        },
        
        prepareOperations: function(operations,data) {
            var url = this.url + '/' + data.rptId;
            console.log('url') ;
            console.log(url) ;
            var mclass = null;
            var METHODS = this.getInvocationMethods();
            var operation = {
                url: url,
                mclass: null,
                method: 'get',
                scope: this,
                success: this.onSuccess,
                fail: this.onFail
            };
            operations.length = 0;
            operations.push(operation);
        },
        
        onSuccess: function(operation){
            if(operation.result){
                var reportParam =  this.getOwner().reportParam  ;
                console.log('reportParam');
                console.log(reportParam);
                var view = this.getOwner();
                var block = this.getBlock('content');
                block.removeAll();
                var reportUrl = operation.result.data.url.trim();
                reportUrl += "&toolbardisplay=top&toolbardisplay=top&params=";
                reportUrl += reportParam ;
                console.log('reportUrl');
                console.log(reportUrl);
                var htmlStr = {'html':'<iframe align = "center" width="800" height="450"  src="'+reportUrl+'"> </iframe>'};
                block.add(htmlStr);
            }
        }
    });