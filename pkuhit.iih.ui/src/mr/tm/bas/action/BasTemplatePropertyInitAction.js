Ext.define('iih.mr.tm.bas.action.BasTemplatePropertyInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],

	doExecute: function(context) {
	    this.callParent();
	    console.log('------------------------ BasTemplatePropertyInitAction ----------------------------------');
        var operations = context.operations;
        var owner = this.getOwner();
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
            customerData: context.customerData,   
            code:context.code, 
            filePk:context.filePk,
            sourceView:context.sourceView,  
            block:context.block
        });
        console.log(context.customerData);
        console.log(context.sourceView);
        if(context.customerData=='new'){
        	/*新建页面初始化
            var block = this.getBlock('result');
            var ownerTypeCd = owner.down('[name = ownerTypeCd]');
            //新建页面初始化,带过来选中的，全院，科室等信息
            if(ownerTypeCd!=null){
                ownerTypeCd.setValue(context.treeSelected);
            }
            return*/
        }else if((context.customerData=='edit')||(context.customerData=='upgrade')){
        	//编辑页面初始化
            if(!operations) {
                return;
            }
            this.prepareOperations(operations,context.code);
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
