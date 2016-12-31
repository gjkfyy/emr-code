Ext.define('iih.po.com.action.PatientGridInitForNurseAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
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
        var tabpanel = block.down('xaptabpanel');
        var grid = tabpanel.getActiveTab();
        var groupType = grid.groupType;
        var url = this.url;
    	var mclass = null;
    	var condition = {
    	   workScreen: '4',
    	   userId: IMER_GLOBAL.user.code,
    	   wardCd: IMER_GLOBAL.department.code,
    	   groupType: groupType,
    	   pageSize: pageSize,
    	   pageNum: pageNum
    	};
    	var searchblock = this.getBlock('search');
    	var form = searchblock.down('xapform');
    	condition = Ext.apply(condition,form.getData());
    	if(context.curMgNurId)
            condition = Ext.apply(condition,{'curMgNurId':context.curMgNurId});
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
    	operations.length=0;
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('content');
        var panel = block.down('xaptabpanel');
        if(!panel)return;
        var grid = panel.getActiveTab();
        var m = operation.result;
		if(m){
		    if(this.turnpage)
		        grid.setData(m.dataList);
		    else
		        grid.setPageData(m);
		    /*var store = grid.getStore();
            if(grid.groupType == '6')
                store.sort('finishTime','DESC');
            else
                store.sort('currentBedCode','ASC');*/
		}
    }
});