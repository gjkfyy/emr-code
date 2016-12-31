Ext.define('iih.sy.params.action.CheckParamsSetEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	   	this.callParent();
	   	console.log('--------------------- CheckParamsSetEditAction -----------------------------');
	   	var operations = context.operations;
       	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
       	var view = this.getOwner();
       	var owner = properties.data.sourceView;
       	var form = this.getBlock('result').getForm();
       	//拿到的form的value有问题       
       	var data = this.getBlock('result').getForm().getValues();
       	var message;
       	//判断非空验证
       	if(!Ext.isEmpty(data,false)){
       		if(!Ext.isEmpty(data.nm,false)){
       			if(!Ext.isEmpty(data.code,false)){
       				if(!Ext.isEmpty(data.key,false)){
           				if(!Ext.isEmpty(data.value,false)){
           					properties.data.paramCd = data.paramCd;
           					properties.data.nm = data.nm;
           					properties.data.code = data.code;
           					properties.data.key = data.key;
           					properties.data.value = data.value;
           					properties.data.memo = data.memo;
           					properties.data.updCnt = data.updCnt;
           					this.checkParamName(operations, data);
    		       		}else{
    		       			message = '值不能为空!!!';
            				XapMessageBox.info(message);
    		       		}
    	       		}else{
    	       			message = '标识不能为空!!!';
            			XapMessageBox.info(message);
    	       		}
       			}else{
       				message = '编码不能为空!!!';
        			XapMessageBox.info(message);
       			}
       		}else{
       			message = '名称不能为空!!!';
        		XapMessageBox.info(message);
       		}
       	}
	},
    //验证
    checkParamName: function(operations,data) {
    	var params = {};
    	params.nm = data.nm;
    	params.paramCd = data.paramCd;
    	params.code = data.code;
    	params.key = data.key;
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            params: params,
            scope: this,
            success: this.checkSuccess,
            fail: this.checkFail
        };
        operations.push(operation);
    },
    checkSuccess: function(operation) {
        //调用模板列表刷新页面
        var view = this.getOwner();
    	var chain = view.getActionChain('confim');
    	var data = operation.result.data;
    	var msg = '';
    	if(data.nmExist =='0'){
    		if(data.ckExist ==null || data.ckExist =='' || data.ckExist =='0'){
    			chain.execute();
    		}else{
    			msg = '参数名称重复，请重新输入!!!';
        		XapMessageBox.info(msg);
    		}
    	}else{
    		msg = '参数名称重复，请重新输入!!!';
    		XapMessageBox.info(msg);
    	}
    },
    editFail: function(operation) {
        var message = '修改失败!!!';
        XapMessageBox.info(message);
    }
});
