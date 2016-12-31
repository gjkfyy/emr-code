Ext.define('iih.masterdata.dataelement.dimensionvalue.action.PopupDictDataEditAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.masterdata.dataelement.dimensionvalue.view.DictGeneralDataInferView'
	],
	execute: function(context) {
		var owner =  this.getOwner();
        var ownerCt = owner.ownerCt;   

        var blockTop = ownerCt.getBlock('top');
		var grid = blockTop.down('xapgrid');
        var recordTop = grid.getSelectionModel().getSelection();
        if(recordTop ==undefined || Ext.isEmpty(recordTop,false)){
			XapMessageBox.info('请选择一条记录进行操作！');
			return;
		}
        
        var block = ownerCt.getBlock('bottom');
		var grid = block.down('xapgrid');
        var record = grid.getSelectionModel().getSelection();
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择要修改的通用字典项目！');
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
    					data:record,
    					customerData: 'edit'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
