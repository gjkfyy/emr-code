Ext.define('iih.mr.wr.mr.action.AlreadySignOpenAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	execute: function(context) {
        var mrPk = '';
		var name = '';
		var encounterPk = '';
		var patientId = '';
		var arguments = context.event.arguments;
		if(context.event.name=="itemdblclick"){
			mrPk = arguments[1].raw.mrPk;
	        name = arguments[1].raw.name;
	        encounterPk = arguments[1].raw.encounterPk;
	        patientId = arguments[1].raw.patientId;
		}else{
			mrPk = arguments[0].mrPk;
	        name = arguments[0].name;
	        encounterPk = arguments[0].encounterPk;
	        patientId = arguments[0].patientId;
		}
		IMER_GLOBAL.encounterSn = encounterPk;
        IMER_GLOBAL.patientId = patientId;
    	if(undefined!=mrPk){
    		/*var workpageview = this.getOwner().ownerCt.items.items[1];
	        if(workpageview){
	        	var mrSn = workpageview.blocks.workContent.items.items[0].mrSn;
	        	if(mrSn!=mrPk){
	        		workpageview.ownerCt.remove(workpageview);//blocks.workContent.items.items[0].ownerCt.remove(workpageview.blocks.workContent.items.items[0]);
	        	}
	        }*/
        	var canvas = Xap.getCanvas();
	        var config = {
                pageCode: 'mrdoceditview',
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                pageTitle: name,
                viewConfig:{
                    mrSn:mrPk,
                    opType:'open'
                },
                assistantConfig:{
                    tgtObCd: 'MRB02',
                    tgtObPk: mrPk
                }
	        };       
	        canvas.fireEvent("addWorkPage",config);
        }
    }
});
