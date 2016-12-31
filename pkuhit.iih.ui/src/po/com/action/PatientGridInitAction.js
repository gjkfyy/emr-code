Ext.define('iih.po.com.action.PatientGridInitAction', {
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
    	var enTpCd;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1)
    	    enTpCd = IMER_CONSTANT.OUTPATIENT;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2)
    	    enTpCd = IMER_CONSTANT.INPATIENT;
    	var condition = {
    	   workScreen: '1',
    	   userId: IMER_GLOBAL.user.code,
    	   deptCd: IMER_GLOBAL.department.code,
    	   enTpCd: enTpCd,
    	   groupType: groupType,
    	   respDeptId: IMER_GLOBAL.department.code,
    	   pageSize: pageSize,
    	   pageNum: pageNum
    	};
    	var searchblock = this.getBlock('search');
    	var form = searchblock.down('xapform');
    	condition = Ext.apply(condition,form.getData());
    	if(context.curMgDctId)
            condition = Ext.apply(condition,{'curMgDctId':context.curMgDctId});
    	if(context.consRespDctId)
            condition = Ext.apply(condition,{'respDctId':context.respDctId});
    	var qs = Ext.Object.toQueryString(condition);
    	if(groupType==4){//跨科就诊患者
            url = 'mramr/stepdept';
        };
        if(groupType==5){//会诊患者
            url = 'mramr/cons';
        };
    	url += '?' + qs;
    	console.log(url);
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
        var panel = block.down('xaptabpanel');
        if(!panel)return;
        var grid = panel.getActiveTab();
        var m = operation.result;
        console.log(m.dataList);
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