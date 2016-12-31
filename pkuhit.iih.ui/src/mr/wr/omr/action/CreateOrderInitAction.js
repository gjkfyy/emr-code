Ext.define('iih.mr.wr.omr.action.CreateOrderInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	eventName: '',
	doExecute: function(context) {
		this.callParent();
	    var operations = context.operations;
	    if(context.event != undefined){
	    	eventName = context.event.name;
	    }else{
	    	eventName = '';
	    }
	    
	    //查询 调用 cis门诊相关 url
	    var cisRecipeCode = 'EIM01.01';
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
		var url,method,defaultParam,param,recipeUrl,flag;
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
		
		 var owner = this.getOwner();   
		 var block = owner.getBlock('content');
		 var tabs =  block.down('xaptabpanel');
		 var tab = tabs.getActiveTab();
		 var groupType = tab.groupType;
		 var haveHtml = tab.haveHtml;
		// var htmlStr = tab.initialConfig.html;
		 if(eventName == 'tabchange' && haveHtml){
				return;
		 }
		 tab.haveHtml = true;
		 
		 
		 
		 if(groupType==1){// 处方recipeEditor
			 flag = "recipeEditor";
		 }else if(groupType==2){// 门诊草药
			 flag = "2";
		 }else if(groupType==3){// 处置单 procRecipeEditor
			 flag = "procRecipeEditor";
		 }else if(groupType==4){//检验 obsLabOrds
			 flag = "obsLabOrds";
		 }else if(groupType==5){//检查 obsReqFrame
			 flag = "obsReqFrame";
		 }else if(groupType==6){//病理-标版pathy
			 flag = "pathy";
		 }else if(groupType==7){//手术 opRegMgr
			 flag = "opRegMgr";
		 }else if(groupType==8){//工作日志
			 flag = "2";
		 }else if(groupType==9){//申请住院
			 flag = "2";
		 }else if(groupType==10){//传染卡
			 flag = "2";
		 }else if(groupType==11){//检查检验模板
			 flag = "2";
		 }
		 
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
				case 'employeeId':
				   if(i==0){
					  recipeUrl = recipeUrl+"?employeeId="+employeeId;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26employeeId="+employeeId;
				   }
				   break;
				case 'deptSn':
				   if(i==0){
					  recipeUrl = recipeUrl+"?deptSn="+deptSn;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26deptSn="+deptSn;
				   }
				   break;
				case 'patientId':
				   if(i==0){
					  recipeUrl = recipeUrl+"?patientId="+patientId;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26patientId="+patientId;
				   }
				   break;
				case 'inVisitTimes':
				  if(i==0){
					  recipeUrl = recipeUrl+"?inVisitTimes="+inVisitTimes;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26inVisitTimes="+inVisitTimes;
				   }
				   break;
				case 'flag':
				  if(i==0){
					  recipeUrl = recipeUrl+"?flag="+flag;
				   }
				   else{
					  recipeUrl = recipeUrl+"%26flag="+flag;
				   }
				   break;
				}
			}
		}
		console.log('cis url is =====================: '+recipeUrl);
		console.log('cis url is =====================: '+defaultparam);
		
		if(defaultparam != null && defaultparam != ""){
			recipeUrl = recipeUrl+defaultparam;
		}
		 //   orderUrl = "http://172.18.72.120:8080/dws/dwsHtml.html?employeeId=13109%26deptSn=1040200%26wardSn=%26patientId=000521282200%26code=onp%26inVisitTimes=27%26flag=recipeEditor";
		 var html = '<iframe align = "top" width="950" height="475" src="'+recipeUrl+'"> </iframe>';
		 tab.update(html);
		 //Ext.getCmp('InputXMLStylePanel').update(html);
	}
});
