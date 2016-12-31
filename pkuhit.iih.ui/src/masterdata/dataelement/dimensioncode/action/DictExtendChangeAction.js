Ext.define('iih.masterdata.dataelement.dimensioncode.action.DictExtendChangeAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
    	var owner = this.getOwner();
    	var block = owner.getBlock('content');
    	var extendFlagV = block.down('xapradiogroup[method=extendFlag]').getValue().extendFlag;
    	var extendDict =  block.down('xaptextfield[name=extendDict]');
    	if(extendFlagV == "0"){//不关联
    		extendDict.disable();
//    		extendDict.hide();
    	}else if(extendFlagV == "1"){//关联
    		extendDict.enable();
//    		extendDict.show();
    	}
    }
});