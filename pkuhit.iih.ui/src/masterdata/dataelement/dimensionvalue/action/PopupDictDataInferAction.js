Ext.define('iih.masterdata.dataelement.dimensionvalue.action.PopupDictDataInferAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.masterdata.dataelement.dimensionvalue.view.DictGeneralDataInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
        
        var block = owner.ownerCt.getBlock('top');
		var grid = block.down('xapgrid');
        var record = grid.getSelectionModel().getSelection();
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择新建项目所属的数据元素！');
			return;
		}
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var config = {
    		width: 700,
    		height:280,
    		title:'通用字典',
    		contentConfig: {
    			xtype: 'dictgeneraldatainferview',
    			sourceOwner:owner,  //传入上级视图
    			initChain: {
    				name: 'init',
    				context: {
    					data : record,
    					customerData : 'new'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
