Ext.define('iih.mr.tm.fr.action.FrTplProInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
	    console.log('------------------------ FrTplProInitAction ----------------------------------');
        var operations = context.operations;
        var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            customerData: context.customerData,   
            mrFrTplCd:context.mrFrTplCd, 
            filePk:context.filePk,
            sourceView:context.sourceView,  
            block:context.block
        });
        console.log(context.customerData);
        console.log(context.sourceView);
        if(context.customerData=='new'){
        }else if(context.customerData=='edit'){
        	//编辑页面初始化
            if(!operations) {
                return;
            }
            this.prepareOperations(operations,context.mrFrTplCd);
        }
	},  
	 prepareOperations: function(operations,data) {
        var url = this.url +'/'+data;    
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:null,
            scope: this,
            success:this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);	    
	 },
	    
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation.result.data;
        // TODO 数据格式就这样了？
        if(m instanceof Ext.data.Model) {
            block.setData({
                mclass: operation.mclass,
                data: m.getData(true)
            });
        }
        else {
            //分布赋值
            block.setData(m);
        }
    }    
});
