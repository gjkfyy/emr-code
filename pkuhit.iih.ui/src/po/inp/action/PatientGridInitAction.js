Ext.define('iih.po.inp.action.PatientGridInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    this.showLoading();
	    var owner = this.getOwner();
	    var block = this.getBlock('content');
	    var deptCd = block.down('comboxgrid[name=deptCd]');
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
        var ifShowOutpatient = CONFIG_PARAM.IF_SHOW_OUTPATIENT;
    	var url = this.url;
    	var mclass = null;
    	var enTpCd;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1)
    	    enTpCd = IMER_CONSTANT.OUTPATIENT;
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_2)
    	    enTpCd = IMER_CONSTANT.INPATIENT;
    	var condition = {
    	   workScreen: '1',
    	   userId: null,
    	   deptCd: null,
    	   enTpCd: enTpCd,
    	   portalCd:IMER_GLOBAL.portal.code,
    	   ifShowOutpatient:ifShowOutpatient,
    	   pageSize: pageSize,
    	   pageNum: pageNum
    	};
    	condition = Ext.apply(condition,form.getData());
    	if(context.deptCd){
    		condition = Ext.apply(condition,{'deptCd':context.deptCd});
    	}else{
    		deptCd.setValue(CONFIG_PARAM.IF_SELECT_DEPT);
    		condition = Ext.apply(condition,{'deptCd':CONFIG_PARAM.IF_SELECT_DEPT});
    	}
    	    
    	
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
        var grid = block.down('xapgrid');
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