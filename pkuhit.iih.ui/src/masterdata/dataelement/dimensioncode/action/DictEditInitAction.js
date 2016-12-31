Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictEditInitAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	execute: function(context) {
		var owner = this.getOwner();
		
        var block = owner.getBlock('content');
  /*  	var extendFlagV = block.down('xapradiogroup[method=extendFlag]').getValue().extendFlag;
    	var extendDict =  block.down('xaptextfield[name=extendDict]');
    	if(extendFlagV == "0"){//不关联
    		extendDict.disable();
    	}else if(extendFlagV == "1"){//关联
    		extendDict.enable();
    	}
		*/
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		properties.setData({
            customerData: context.customerData,
            data:context.data
        });
		if(context.customerData=='new'){
			var getNewCodeChain = owner.getActionChain('getNewCode') ;
			getNewCodeChain.execute();
			
		}else if(context.customerData=='edit'){
	    	var block = this.getBlock('result');
			var record = context.data;
	    	var form = block.getForm('xapform');
	    	form.setValues(record[0].data);  
		}
    }
});