Ext.define('iih.sy.params.action.EditParamsSetAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.sy.params.view.ParamsSetEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	   //新建模板
		console.log('---------------- CreateParamsSetAction --------------------');
		this.callParent();
		var operations = context.operations;
		var view =this.getOwner();	
	    var block = this.getBlock('result');
		var grid = view.down('paramssetlistblock');
		var records = grid.getSelectionModel().getSelection();
		var data = {};
		if(records.length>0){
			data.paramCd = records[0].data.paramCd;
			var config = {         
	            modal: true,            
	            height: 290,
	            width: 350,
	            title :'编辑参数',
	            contentConfig: {
	            	//新建模板页面
	                xtype: 'paramsseteditview', 
	                initChain: {
	                    name: 'init',
	                    context: {
	                        customerData: 'edit',
	                        sourceView: view,
	                        block:block,
	                        data:data
	                    }
	                }
	            }
	        };
	        this.callParent([config]); 
		}else{
			var message = '请选择修改的参数!!!';
        	XapMessageBox.info(message);
		}
    }
});
