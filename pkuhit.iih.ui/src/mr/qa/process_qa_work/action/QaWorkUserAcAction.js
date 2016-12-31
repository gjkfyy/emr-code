/** 
 * 质控工作画面加载初始化Action
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.QaWorkUserAcAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
    	var userId = IMER_GLOBAL.user.code;
    	var orgCd = IMER_GLOBAL.department.code;
    	var dataJson = {
    			userId:userId,  //用户ID
    			orgCd:orgCd  //出诊科室编码
    	}      
    	var operations = context.operations;
     	if(!operations) {
     		return;
     	}
     	operations.length=0;
     	this.prepareOperations(operations,dataJson);
    	
    },
    prepareOperations: function(operations,data){
    	
    	var qs = Ext.Object.toQueryString(data);
    	 
        var url = this.url+'?'+ qs;
        
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        
    	var m = operation.result.dataList;
    	var qaUserRoles = [];
    	var isNurseRole = false;
    	if(m != null && m != undefined){
    		for(var i=0;i<m.length;i++){
        		var obj = m[i];
        		if(obj.roleCode=='XAPM14.08'||obj.roleCode=='XAPM14.13'||obj.roleCode=='XAPM14.22'||obj.roleCode=='XAPM14.23'){
        			qaUserRoles.push(obj.roleCode);
        		}
        	}
    	}
    	for(var i=0;i<qaUserRoles.length;i++){
    		if(qaUserRoles[i]=='XAPM14.22' || qaUserRoles[i]=='XAPM14.23' ){
    			isNurseRole = true;
    			break;
    		}
    	}
    	iih.mr.qa.QaStatusGlobal.qaUserRoles = qaUserRoles;
    	iih.mr.qa.QaStatusGlobal.isNurseRole = isNurseRole;
    	
    }
})