Ext.define('iih.po.com.action.JumpFunctionAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    var view = this.getOwner();
        var operations = context.operations;
	    var data = context.data;
	    this.portalCd = data.portalCd;
	    this.menuCd = data.menuCd;
	    this.revisionCd = data.revisionCd;
	    this.encounterSn = data.encounterSn;
	    var url = 'validateUser';
        var mclass = null;
        var condition = {
           userId: IMER_GLOBAL.user.code,
           orgCd: IMER_GLOBAL.department.code,
           portalCd: this.portalCd,
           menuCd: this.menuCd,
           encounterSn:this.encounterSn
        };
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
        var data = operation.result.data;
        var result = data.validate;
        if(result == 'true'){
            //关闭弹出窗体
            var windows = Ext.ComponentQuery.query('window');
            Ext.each(windows,function(w){
                if(w.modal)w.close();
            });
            
            var portalCd = this.portalCd;
            var menuCd = this.menuCd;
            var revisionCd = this.revisionCd;
            var encounterSn = this.encounterSn;
            var portal = Ext.getCmp('portalview');
            var workArea = portal.down('xaptabpanel[id=workareapageview]');
            var patient = {'pk':encounterSn};
            
            var callBack = function(){
                IMER_GLOBAL.portal.code = portalCd;
                IMER_GLOBAL.revisionCd = revisionCd;
                IMER_GLOBAL.encounterSn = encounterSn;
                var chain = this.getActionChain('init');
                var getPatientChain = this.getActionChain('getPatient');
                
                getPatientChain.execute({
                	patient: patient,
                	callback: function(data) {
                		chain.execute({
                            hospitalAreaCode:IMER_GLOBAL.hospitalArea.code,
                            hospitalAreaName:IMER_GLOBAL.hospitalArea.name,
                            departmentCode:IMER_GLOBAL.department.code,
                            departmentName:IMER_GLOBAL.department.name,
                            portalCode:IMER_GLOBAL.portal.code,
                            portalName:IMER_GLOBAL.portal.name,
                            menuCd:menuCd,
                            encounterSn:encounterSn,
                            patient: data
                        });
                	}
                });
            };
            workArea.callBack = {
                method: callBack,
                scope: portal,
                params: []
            };
            workArea.closePages = null;
            var canvas = Xap.getCanvas();
            canvas.fireEvent("portalRender");
            //直接定位到患者！！！     encounterSn
            canvas.fireEvent("updatePatient", {patient:patient});
        }else{
            XapMessageBox.warn('用户没有处理权限！');
        }
    }
});
