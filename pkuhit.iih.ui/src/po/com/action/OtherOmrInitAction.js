Ext.define('iih.po.com.action.OtherOmrInitAction', {
	    extend: 'Xap.ej.action.ServiceInvocation',
	    
	    doExecute: function(context) {
			this.callParent();
		    var operations = context.operations;
		    var workPageView = this.getOwner().workpageview;
	        var url = workPageView.url;
	        var METHODS = this.getInvocationMethods();
	        if(url == 'mr/other'){
	        	var encounterSn = this.getOwner().encounterSn;
		        var enType = this.getOwner().enType;
		        var condition = {
		        		encounterSn: encounterSn,
		        		enType: enType
		            };
		        var qs = Ext.Object.toQueryString(condition);
		        url += '?' + qs;
//		        url = url+'/'+encounterSn;  
		        var mclass = null;
	        }else{
	        	
	     	    //查询cis门诊处方调用url
	     	    var cisRecipeCode = 'EIM01.02';
	     	    url = url + '/' + cisRecipeCode;  
	        }
	        
	        var operation = {
	            url: url,
	            mclass: mclass,
	            method: 'get',
	            condition: condition,
	            scope: this,
	            success: this.onSuccess
	        };
	        operations.length=0;
	        operations.push(operation);
	    },
	    onSuccess: function(operation) {
	    	var workPageView = this.getOwner().workpageview;
	        var url = workPageView.url;
		    var owner = this.getOwner();
		    var parentOwner = owner.ownerCt;
	    	var block = this.getBlock('content');
	    	var m = operation.result;
	    	if(url == 'mr/other'){
	    		 var textarea = block.down('textarea');
	 	        if(m.data == '1'){
	 	            XapMessageBox.info('该次就诊未写病历！');
	 	            parentOwner.close();
	 	        }else{
	 	        	textarea.setValue(m.data);
	 	        }
	    	 }else{
	    			var m = operation.result.dataList;
	    			var url,method,defaultParam,param,recipeUrl;
	    			var params = ['',''];
	    			//患者patient_Id
	    			var patientId = IMER_GLOBAL.patientId;
	    			//就诊次数
	    			var inVisitTimes = IMER_GLOBAL.encounterCount;
	    			
	    			/*var employeeId = '13109';
	    			var deptSn = '1040200';
	    			//患者patient_Id
	    			var patientId = '000521282200';
	    			//就诊次数
	    			var inVisitTimes = '28';*/
	    			if(m){
	    				exterInterf = m[0];
	    				url = exterInterf.url;
	    				method = exterInterf.method;
	    				defaultparam = exterInterf.defaultparam;
	    				param = exterInterf.param;
	    			}
	    			if(url != null && url != ""){
	    				recipeUrl = url;
	    			}
	    			if(method != null && method != ""){
	    				recipeUrl = recipeUrl+"/"+method;
	    			}
	    			
	    			var check=CONFIG_PARAM.ASSISTANT_DISTRICT_SEARCH_MR_PARAM_SETUP;
	    			var amrNo=IMER_GLOBAL.amrNo;
	    			if(param != null && param != ""){
	    				var params = param.split(":");
	    				for(var i=0; i<params.length;i++){
	    					var para = params[i];
	    					switch(para)
	    					{
	    					case 'patientId':
	    					   if(i==0){
	    						   if(check==1){
	    							   recipeUrl = recipeUrl+"?inpatientno="+amrNo;
	    						   }else{
	    							   recipeUrl = recipeUrl+"?patientId="+patientId;
	    						   }
	    					   }
	    					   else{
	    						   if(check==1){
	    							   recipeUrl = recipeUrl+"&inpatientno="+amrNo;
	    						   }else{
	    							   recipeUrl = recipeUrl+"&patientId="+patientId;
	    						   }
	    						  
	    					   }
	    					   break;
	    					case 'inVisitTimes':
	    					  if(i==0){
	    						  recipeUrl = recipeUrl+"?invisittimes="+inVisitTimes;
	    					   }
	    					   else{
	    						  recipeUrl = recipeUrl+"&invisittimes="+inVisitTimes;
	    					   }
	    					   break;
	    					}
	    				}
	    			}
	    			if(defaultparam != null && defaultparam != ""){
	    				recipeUrl = recipeUrl+defaultparam;
	    			}
	    			 var owner = this.getOwner();   
	    			    var block = owner.getBlock('content');
	    			    var mrcontent = block.down('textarea[name=mrcontent]'); 
	    			    block.remove(mrcontent);
	    			  /*  var url= "http://172.18.72.79:8080/dws/emrsee.html";
	    			    orderUrl = "http://172.18.72.120:8080/dws/dwsHtml.html?employeeId=13109%26deptSn=1040200%26wardSn=%26patientId=000521282200%26code=onp%26inVisitTimes=27%26flag=recipeEditor";
	    				var employeeId = '13109';
	    				var deptSn = '1040200';
	    				var patientId = '000521282200';
	    				var inVisitTimes = '27';
	    			    var condition = "employeeId="+employeeId+"%26deptSn="+deptSn+"%26wardSn="+wardSn+"%26patientId="+patientId+"%26code=inp%26inVisitTimes="+inVisitTimes+"%26flag=order";
	    		*/	    var htmlStr = {'html':'<iframe align = "top" width="950" height="475" src="'+recipeUrl+'"> </iframe>'};
	    				console.log(recipeUrl);
	    				block.add(htmlStr);
	    		
	    	 }
	    		        
	    }
	});

