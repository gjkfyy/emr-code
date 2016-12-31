Ext.define('iih.po.com.action.SyncPaToMrAmrAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
    contextParam:{},
	doExecute: function(context) {
	    this.callParent();
	    var patient = context.patient;
	    contextParam = context;
    	var operations = context.operations;
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
    	if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10)
    		enTpCd = IMER_CONSTANT.INPATIENT;
    	var data = {
    	   workScreen: '1',
    	   userId: IMER_GLOBAL.user.code,
    	   deptCd: IMER_GLOBAL.department.code,
    	   enTypeCode: enTpCd,
    	   groupType: groupType,
    	   respDeptId: IMER_GLOBAL.department.code,
    	   patientId:patient.patientId,
    	   times:patient.encounterCount,
    	   enPk:patient.pk
    	};
        //跨科和会诊没有实现，待分析 wangyanli
    	var qs = Ext.Object.toQueryString(data);
    	url += '?' + qs;
    	console.log(url);
    	var METHODS = this.getInvocationMethods();
    	var operation = {
    	    url: url,
    	    mclass: mclass,
    	    method: METHODS.METHOD_GET,
    	    condition: data,
            scope: this,
            success: this.onSuccess
    	};
    	operations.length=0;
    	operations.push(operation);
    },
    callbackTemp : function(win){
	
	},
    onSuccess: function(operation) {
    	var win = contextParam.callback.params;
    	var chainParam = contextParam.callback.chainParam;
    	var rec = contextParam.patient;
    	var block = this.getBlock('content');
    	if(chainParam == 'updatePatient'){
    		block.refreshPage(win, rec);
    	}else if(chainParam == 'setDoctor'){
    		var patientpopview = Ext.getCmp('patientpopview');
    		var chain = patientpopview.getActionChain('setDoctor');
            chain.execute({
                patient: rec
            });
    	}
    	
    }
    
});