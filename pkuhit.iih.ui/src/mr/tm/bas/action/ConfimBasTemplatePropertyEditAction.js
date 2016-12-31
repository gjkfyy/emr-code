Ext.define('iih.mr.tm.bas.action.ConfimBasTemplatePropertyEditAction', {
extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();
	   var operations = context.operations;		 
	   var view = this.getOwner();
	   var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	   var data = {};
       data.paperTypeCode = properties.data.paperTypeCode;//医疗记录基础模板编码
       data.name = properties.data.name;
       data.description = properties.data.description;//文件主键
       data.code = properties.data.code;
       this.getOwner().ownerCt.close();
       if(properties.data.customerData=='new'){
    	   //新建操作方式更改2014-12-14
    	   var layout = properties.data.block.getLayout();
    	   var paperTypeCode = data.paperTypeCode;
           var name = data.name;
           var description = data.description;
           var owner = properties.data.sourceView;
           var block = properties.data.block;
           
           var canvas = Xap.getCanvas();
           var config = {
                   xclass: 'iih.mr.tm.bas.view.BasTemplateEditView',
                   pageTitle: name,
                   pageCode:'mrbastpleditview',
                   viewConfig:{
                       opType:'new',
                       paperTypeCode:paperTypeCode,
                       description:description
                   }
           };
           canvas.fireEvent("addWorkPage",config);
       }else if(properties.data.customerData=='edit'){
    	   this.prepareOperations(operations,data);
       }/*else if(properties.data.customerData=='upgrade'){
    	   //升级操作方式更改2014-12-14
    	   var layout = properties.data.block.getLayout();
    	   var paperTypeCode = data.paperTypeCode;
           var name = data.name;
           var description = data.description;
           var code = data.code;
           var filePk= data.filePk;
           var owner = properties.data.sourceView;
           var block = properties.data.block;
           var gridBlock =block.down('bastemplateeditview');               
           var chain = owner.getActionChain('beforeActivate');               
           var properties = gridBlock.getLayer(Xap.ej.block.Layer.PROPERTIES);	 
            properties.setData({
            	opType: 'upgrade',  
            	code:code,
            	filePk:filePk,
            	name:name,
            	description:description,
            	paperTypeCode:paperTypeCode
            });	  
           chain.execute(); 
    	   layout.setActiveItem(1);	    	   
       }*/
	},    
    addOperations: function(operations,data,view) {
        var condition = data;
        var url = this.url;
        /*var qs = Ext.Object.toQueryString(condition);   
        console.log(qs);*/
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,
            data:condition,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function() {
        //调用模板列表刷新页面
        var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
        var view = properties.data.sourceView;
        var chain = view.getActionChain('init');
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");   
        }
        if(chain) {
            chain.execute();
        }
    },
    onFail: function(operation) {
        Ext.MessageBox.show({
            title:'提示',
            msg:'新增失败!!!'
        });
    },    
    prepareOperations: function(operations,data) {
    	//修改属性，改属性的值
    	var code =data.code;
        var url = this.url+"/"+code;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    }        
});
