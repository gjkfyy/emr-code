Ext.define('iih.masterdata.dataelement.dimensioncode.action.PopupDictEditAction', {
	extend: 'Xap.ej.action.PopAction',
	requires : [
	            'iih.masterdata.dataelement.dimensioncode.view.DictGeneralInferView'
	],
	execute: function(context) {

        var owner = this.getOwner();   
        var block = this.getBlock('top');
		var grid = block.down('xapgrid');
        var record = grid.getSelectionModel().getSelection();
        
        if(record ==undefined || Ext.isEmpty(record,false)){
			XapMessageBox.info('请选择一条记录进行操作！');
			return;
		}
        
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
    					data:record,
    					customerData: 'edit'
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
