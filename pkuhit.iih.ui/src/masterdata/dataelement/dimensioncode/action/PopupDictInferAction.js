Ext.define('iih.masterdata.dataelement.dimensioncode.action.PopupDictInferAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.masterdata.dataelement.dimensioncode.view.DictGeneralInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var config = {
    		width: 700,
    		height:335,
    		title:'通用字典',
    		contentConfig: {
    			xtype: 'dictgeneralinferview',
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
