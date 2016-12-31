Ext.define('iih.mr.qa.pat_case.action.PatCaseInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
		this.callParent();
	    var operations = context.operations;
	    //查询cis病案首页调用url
	    var cisRecipeCode = 'EIM01.03';
	    var url = this.url + '/' + cisRecipeCode;   
	    var METHODS = this.getInvocationMethods();
	    var operation = {
	        url: url,
	        mclass: null,
	        method: METHODS.METHOD_GET,
	        condition: null,
	        data:null,
	        scope: this,
	        success: this.onSuccess
	    };
	    operations.length=0;
	    operations.push(operation);	 
	},

	onSuccess : function(operation) {
		var m = operation.result.dataList;
		var url,method,defaultParam,param,recipeUrl;
		var enPk = IMER_GLOBAL.encounterSn;
		var params = ['',''];
		if(enPk != undefined && enPk != ""){
			params = enPk.split('_');
		}
		
		var employeeId = IMER_GLOBAL.user.code;
		var deptSn = IMER_GLOBAL.department.code;
		//患者patient_Id
		var patientId = IMER_GLOBAL.patientId;
		//就诊次数
		var inVisitTimes = IMER_GLOBAL.encounterCount;
		
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
		if(param != null && param != ""){
			var params = param.split(":");
			for(var i=0; i<params.length;i++){
				var para = params[i];
				switch(para)
				{
				case 'patientId':
				   if(i==0){
					  recipeUrl = recipeUrl+"?patientId="+patientId;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26patientId="+patientId;
				   }
				   break;
				case 'inVisitTime':
				  if(i==0){
					  recipeUrl = recipeUrl+"?inVisitTime="+inVisitTimes;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26inVisitTime="+inVisitTimes;
				   }
				   break;
				}
			}
		}
		if(defaultparam != null && defaultparam != ""){
			recipeUrl = recipeUrl+defaultparam;
		}
		console.log('cis url is =====================: '+recipeUrl);
		 var owner = this.getOwner();   
		    var block = owner.getBlock('content');
		  //recipeUrl = "http://172.18.72.79:8080/patcase/patcasenew.html?patientId=000170433200%26inVisitTime=1";
		  //  recipeUrl = "http://172.18.72.79:8080/patcase/patcasenew.html?patientId=000170433200%26inVisitTime=1";
		    var htmlStr = {'html':'<iframe align = "top" width="1180" height="570" src="'+recipeUrl+'"> </iframe>'};
			
			block.add(htmlStr);
	}
});
