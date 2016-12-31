Ext.define('iih.mr.tm.gro.action.ConfimGroupElementPropertyEditAction', {
extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	    this.callParent();    
	       var rs = this.getBlock('result').ownerCt;   
	       //向后台发送form表单   
	       var form= this.getBlock('result').getForm();
	       //拿到的form的value有问题       
	       var data =form.getValues();
	       if((data!=undefined)||(data!=null)){
	           data = this.getBlock('result').getForm().getValues();
	       }else{
	           data = null;
	       }
	       var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
	       if(properties.data.customerData=='new'){
	    	   //新建操作方式更改2014-12-14
	    	   var layout = properties.data.block.getLayout();
	    	   var paperTypeCode =data.paperTypeCode;
               var name =data.name;
               var description =data.description;
               var owner = properties.data.sourceView;
               var block = properties.data.block;
               var gridBlock =block.down('groupelementeditview');               
            
               var chain = owner.getActionChain('beforeActivate');
               var properties = gridBlock.getLayer(Xap.ej.block.Layer.PROPERTIES);
	           properties.setData({
	            	opType: 'new',  
	            	name:name,
	            	//新建的属性
	            	
	            });
	           chain.execute();    /**/
	    	   layout.setActiveItem(1);	    	   
	       }  /* if(properties.data.customerData=='upgrade'){
	    	   //升级操作方式更改2014-12-14
	    	   var layout = properties.data.block.getLayout();
	    	   var paperTypeCode =data.paperTypeCode;
               var name =data.name;
               var description =data.description;
               var code =data.code;
               var filePk=data.filePk;
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
	       }else if(properties.data.customerData=='edit'){	          
	           var operations = context.operations;		          
	           this.prepareOperations(operations,data);
	       }*/
	       this.getOwner().ownerCt.close();
	},    
    addOperations: function(operations,data,view) {
        var condition = data;
        var url = this.url;
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
        var view  =  properties.data.sourceView;
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
            // fail: this.onFail
        };
        operations.push(operation);
    }        
});
