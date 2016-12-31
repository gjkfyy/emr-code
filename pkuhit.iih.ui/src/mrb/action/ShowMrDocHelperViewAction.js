Ext.define('iih.mrb.action.ShowMrDocHelperViewAction', {
	extend: 'Xap.ej.action.PopAction',

	requires: ['iih.po.assistant.view.MrDocHelperView'],
	

	execute: function(context) {
		var printable=this.getOwner().printable;
		var managementPortal=this.getOwner().managementPortal;
		IMER_GLOBAL.encounterSn=context.event.arguments[1].data.pk;
		IMER_GLOBAL.patientId=context.event.arguments[1].data.patientId;
		IMER_GLOBAL.encounterCount=context.event.arguments[1].data.encounterCount;
	        var config = {
                modal: true,           
                width: 1100,
                height:600,
                title :'病历浏览',
                contentConfig: {
                    xtype: 'mrdochelperview',
                    managementPortal:managementPortal,
                    initChain: {
                        name: 'refresh',
                        context: {
                            'enPk': context.event.arguments[1].data.pk,
                            printable:printable
                        }
                    }
                }
            };
	    
    	
    	this.callParent([config]);
    }
});
