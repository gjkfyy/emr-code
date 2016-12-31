Ext.define('iih.mr.dr.plan.action.PopupEditPlanAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.dr.plan.view.PlanInferView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var record = context.record;
		var config = {
				title:'检索方案编辑',
				width: 700,
	    		height:520,
	    		contentConfig: {
	    			xtype: 'planinferview',
	    			sourceOwner:owner,  //传入上级视图
	    			initChain: {
	    				name: 'init',
	    				context: {
	    					customerData: 'edit',
	    					data:record
	    				}
	    			}
	    		}
	    	};
		this.callParent([config]);
	}
})