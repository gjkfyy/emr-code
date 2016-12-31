Ext.define('iih.mr.tm.fr.action.FrTplProEditCheckAction', {
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
      	properties.data.mrFrTplTpCd = data.mrFrTplTpCd;
  		properties.data.nm = data.nm;
  		properties.data.memo = data.memo;
  		properties.data.filePk = data.filePk;
  		properties.data.mrFrTplCd = data.mrFrTplCd;
  		var view = this.getOwner();
  		var msgInfo = view.down('xapdisplayfield[name=msgInfo]');
  		var params={},errorText;
  		if(data.nm!=undefined && !Ext.isEmpty(data.nm,false)){
  			if(data.mrFrTplTpCd!=undefined && !Ext.isEmpty(data.mrFrTplTpCd,false)){
  				if(properties.data.customerData=='new'){
  		  			params = {name:data.nm};
  		  		}else if(properties.data.customerData=='edit'){	          
  		  			params = {code:data.mrFrTplCd,name:data.nm};
  		  		}
  		  		this.checkOperations(operations, params);
  	  		}else{
	  	  		errorText = '模板类型不能为空，请选择！';
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
    		var msg = '模板名称重复，请重新输入!!!';
    		XapMessageBox.info(msg);
    	}
    },
    onFail: function(operation) {
    	var msg = '验证失败!!!';
    	XapMessageBox.info(msg);
    }     
});
