Ext.define('iih.masterdata.dataelement.dimensionvalue.action.DictDataEditInitAction', {
	//extend: 'Xap.ej.action.Action',
	extend: 'Xap.ej.action.ServiceInvocation',
	requires: [],
	
	execute: function(context) {
		var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		properties.setData({
            customerData: context.customerData,
            data:context.data
        });
		var block = this.getBlock('bottom');
		if(context.customerData=='new'){
		//元素cd
			var  dataElementCd = properties.data.data[0].data.dataElementCd ;
			var fkDictgeneral = block.down("xaptextfield[name=dataElementCd]");
			//设置 隐藏的fk-cd
			fkDictgeneral.setValue(dataElementCd);
			//从数据库获取元素cd的value——list最大的code值
			var operations = context.operations;
			 this.getValueCodeFromDB(operations,dataElementCd);

		}else if(context.customerData=='edit'){
			var record = context.data;
			var recordData = record[0].data;
	    	var form = block.getForm('xapform');
	    	form.setValues(recordData);  
		}
    },
    /*从数据库获取最新的value编码*/
	getValueCodeFromDB: function(operations,dataElementCd){
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
        var queryJson = {'dataElementCd':dataElementCd};
    	var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,	
            data:null,
    		scope: this,
    		params:queryJson,
    		success: this.getSuccess,
    		failure: this.getFail
    	};
    	operations.push(operation);
    },
    
    getSuccess: function(operation) {
    	var m = operation.result.data; 
    	var block = this.getBlock('bottom');
    	//设置code值，不可读
		var PkvalueCode = block.down("xaptextfield[name=valueCode]");
		PkvalueCode.setValue(m);
    },
    
    getFail:function(operation){
    	XapMessageBox.info('获取编码值失败');
    }
});