Ext.define('iih.mr.tm.bas.action.CheckBasTemplatePropertyEditAction', {
extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
		this.callParent();
		var operations = context.operations;
       	var rs = this.getBlock('result').ownerCt;      
       	//console.log(rs); 
       	//向后台发送form表单   
       	var form = this.getBlock('result').getForm();
       	//拿到的form的value有问题       
//       console.log(this.getBlock('result').getForm().getValues());
       	var data =this.getBlock('result').getForm().getValues();
       	if((data!=undefined)||(data!=null)){
          	data = this.getBlock('result').getForm().getValues();
       	}else{
           	data = null;
       	}
       	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
       	//数据存储在properties对象
      	properties.data.paperTypeCode = data.paperTypeCode;
  		properties.data.name = data.name;
  		properties.data.description = data.description;
  		properties.data.filePk = data.filePk;
  		properties.data.code = data.code;
  		var view = this.getOwner();
  		var msgInfo = view.down('xapdisplayfield[name=msgInfo]');
  		var params={},errorText;
  		if(data.name!=undefined && !Ext.isEmpty(data.name,false)){
  			if(data.paperTypeCode!=undefined && !Ext.isEmpty(data.paperTypeCode,false)){
  				if(properties.data.customerData=='new'){
  		  			params = {name:data.name};
  		  		}else if(properties.data.customerData=='edit'){	          
  		  			params = {code:data.code,name:data.name};
  		  		}/*else if(properties.data.customerData=='upgrade'){
  		    	   	//升级操作方式更改2014-12-14
  		    	   	var layout = properties.data.block.getLayout();
  		    	   	var paperTypeCode = data.paperTypeCode;
  		           	var name = data.name;
  		           	var description =data.description;
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
  		  		this.checkOperations(operations, params);
  	  		}else{
	  	  		errorText = '纸张类型不能为空，请选择！';
	       		msgInfo.setValue('<font color=red>' + errorText + '</font>');
	       		return;
  	  		}
  		}else{
  			errorText = '名称不能为空，请输入！';
       		msgInfo.setValue('<font color=red>' + errorText + '</font>');
       		return;
  		}
	},    
    checkOperations: function(operations,params) {
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            params:params,
            scope: this,
            success: this.onSuccess,
            fail: this.onFail
        };
        operations.push(operation);
    },
    onSuccess: function(returnData) {
    	var view = this.getOwner();
    	var chain = view.getActionChain('confim');
    	var isexist = returnData.result.data;
    	if(!isexist){
    		chain.execute();
    	}else{
    		var msg = '基础模板名称重复，请重新输入!!!';
    		XapMessageBox.info(msg);
    	}
    },
    onFail: function(operation) {
    	var msg = '验证失败!!!';
    	XapMessageBox.info(msg);
    }     
});
