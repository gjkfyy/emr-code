Ext.define('iih.mr.dr.plan.action.PopupPlanInferAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
		'iih.mr.dr.plan.view.PlanInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var config = {
    		width: 700,
    		height:520,
    		title:'检索方案设置',
    		contentConfig: {
    			xtype: 'planinferview',
    			sourceOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'init',
    				context: {
    					customerData: 'new'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
