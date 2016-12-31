Ext.define('iih.po.assistant.action.VitalSignSearchInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
	    var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            parentWindow: context.parentWindow,
            sourceView: context.sourceView//,
           // encounterSn : context.encounterSn,
           // typeFlag:context.typeFlag
        });
		var DoctorAndEncounterSn=IMER_GLOBAL.user.code+IMER_GLOBAL.encounterSn;
		//var cookie1 = Ext.state.Manager.getProvider();
		//var cookie1 = Ext.state.CookieProvider();
		
		var cookie1 = new Ext.state.CookieProvider();  
 		Ext.state.Manager.setProvider(cookie1);  
 		var lastSearchDateValue = 'nodate';
 		lastSearchDateValue = cookie1.get(DoctorAndEncounterSn,'nodate');
        
        var block = this.getOwner().getBlock('content');
    	var beginTime = block.down('xapdatefield[name=beginTime]');
    	var endTime = block.down('xapdatefield[name=endTime]');
    	if(lastSearchDateValue=='nodate'){
	    	var curDate = new Date();
	    	var bDate = new Date();
	    	bDate.setDate(bDate.getDate() - 7);
	    	beginTime.setValue(bDate);
	    	endTime.setValue(curDate);
    	}
    	else{
    		beginTime.setValue(lastSearchDateValue.beginTime);
	    	endTime.setValue(lastSearchDateValue.endTime);
    	}
    }

});