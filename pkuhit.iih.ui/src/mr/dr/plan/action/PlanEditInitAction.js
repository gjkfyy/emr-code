Ext.define('iih.mr.dr.plan.action.PlanEditInitAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: [],
	
	execute: function(context) {
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		properties.setData({
            customerData: context.customerData,
            data:context.data/*,
            sourceView:context.sourceView, 
            block:context.block*/
        });
		if(context.customerData=='new'){
			
		}else if(context.customerData=='edit'){
			var data = context.data.data;
	    	var block = this.getBlock('result');
			var retrievalNm = block.down('xaptextfield[name=retrievalNm]');
//			var inOrOut = block.down('');
			var ownTpCd = block.down('xapradiogroup[name=ownTpCd]');
			var deptCd = block.down('comboxgrid[name=deptCd]');
			var responsibleCd = block.down('comboxgrid[name=responsibleCd]');
			var retrievalKey = block.down('xaptextarea[name=retrievalKey]');
			var memo = block.down('xaptextarea[name=memo]');
			
			var retrievalCd = data.retrievalCd;
			
			retrievalNm.setValue(data.retrievalNm);
//			inOrOut.
			deptCd.setValue(data.deptCd);
			retrievalKey.setValue(data.retrievalKey);
			responsibleCd.setValue(data.responsibleCd);
			memo.setValue(data.memo);
		}
    }
});