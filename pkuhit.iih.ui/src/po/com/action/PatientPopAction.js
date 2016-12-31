Ext.define('iih.po.com.action.PatientPopAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.com.view.PatientPopView',
	           'iih.po.outp.view.OutpPatientView',
	           'iih.po.com.view.PatientPopForNurseView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
	    if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_1 || IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_8){
	        var config = {
                modal: true,           
                width: 950,
                height:640,
                title :'患者列表',
                contentConfig: {
                    xtype: 'outppatientview',
                    initChain: {
                        name: 'search'
                    }
                }
            };
	    }else if(IMER_GLOBAL.portal.code == IMER_CONSTANT.PORTAL_CD_10){
	        var config = {
                modal: true,           
                width: 950,
                height:640,
                title :'患者列表',
                contentConfig: {
                    xtype: 'patientpopfornurseview',
                    initChain: {
                        name: 'init'
                    }
                }
            };
	    }else{
	        var config = {
                modal: true,           
                width: 950,
                height:640,
                title :'患者列表',
                contentConfig: {
                    xtype: 'patientpopview',
                    initChain: {
                        name: 'init'
                    }
                }
            };
	    }
    	
    	this.callParent([config]);
    }
});
