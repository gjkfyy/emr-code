Ext.define('iih.mr.dr.retrieval.action.PopupPlanAction', {
	extend: 'Xap.ej.action.PopAction',
	
	execute: function(context) {

        var owner = this.getOwner();   
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		var config = {
    		width: 1000,
    		height:520,
    		title:'检索方案选择',
    		contentConfig: {
    			xtype: 'planlistbrowseview',
    			typeFlag:'1',
    			socuseOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'init',
    				context: {
    					
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
