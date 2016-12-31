Ext.define('iih.mrb.action.MrbSearchPatientEnAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
		//alert(123);
	    this.callParent();
	    this.showLoading();
    	var operations = context.operations;
    	var pageNum; 
        var pageSize = 30;
        if(context.event && context.event.name == 'turnpage'){
            pageNum = context.event.arguments[0]; 
            pageSize = context.event.arguments[1];
        }
        this.turnpage = false;
        if(pageNum)
            this.turnpage = true;
        var block = this.getBlock('content');
        var form = block.down('xapform');
        var grid = block.down('patientEncounterListBlock');
    	var url = this.url;
    	var mclass = null;
    	var condition = {
    	   workScreen: '3',
    	   groupType: groupType,
    	   userId: IMER_GLOBAL.user.code,
    	   deptCd: IMER_GLOBAL.department.code,
    	   pageSize: pageSize,
    	   pageNum: pageNum
    	};
    	condition = Ext.apply(condition,form.getData());
    	//if(context.deptCd)
    	    //condition = Ext.apply(condition,{'deptCd':context.deptCd});
    	var qs = Ext.Object.toQueryString(condition);
    	url += '?' + qs;
    	var METHODS = this.getInvocationMethods();
    	var operation = {
    	    url: url,
    	    mclass: mclass,
    	    method: METHODS.METHOD_GET,
    	    condition: condition,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('content');
        var tabpanel = block.down('xaptabpanel');
        var grid = tabpanel.getActiveTab();
        if(!grid)return;
        var m = operation.result;
		if(m){
		    if(this.turnpage)
		        grid.setData(m.dataList);
		    else
		        grid.setPageData(m);
		}
    }
});