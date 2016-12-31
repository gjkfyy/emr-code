Ext.define('iih.sy.params.action.ConfimParamsSetEditAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	   	this.callParent();
	   	console.log('--------------------- ConfimParamsSetEditAction -----------------------------');
	   	var operations = context.operations;
       	var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
       	var data = {};
       	data.paramCd = properties.data.paramCd;
       	data.nm = properties.data.nm;
       	data.code = properties.data.code;
       	data.key = properties.data.key;
       	data.value = properties.data.value;
       	data.memo = properties.data.memo;
       	data.updCnt = properties.data.updCnt;
       	if(properties.data.customerData=='new'){
       		this.addOperations(operations,data);
       	}else if(properties.data.customerData=='edit'){
       		this.editOperations(operations,data);
       	}
       	var owner = this.getOwner().ownerCt;  
       	owner.close();
	},
    addOperations: function(operations,data) {
        var condition = data;
        var url = 'param/set/create';
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
        var gridBlock = view.down('paramssetlistblock');
        var pageNum = gridBlock.currentPage;
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");   
        }
        console.log(chain);
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25'
            });
        }
    },
    onFail: function(operation) {
        var message = '新增失败!!!';
        XapMessageBox.info(message);
    },    
    //修改
    editOperations: function(operations,data) {
    	var paramCd = data.paramCd;
        var url = this.url+'/'+paramCd;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.editSuccess,
            fail: this.editFail
        };
        operations.push(operation);
    },
    editSuccess: function() {
        //调用模板列表刷新页面
        var properties = this.getOwner().getLayer(Xap.ej.block.Layer.PROPERTIES);
        var view = properties.data.sourceView;
    	var chain = view.getActionChain('init');
        var gridBlock = view.down('paramssetlistblock');
        var pageNum = gridBlock.currentPage;
        if(!chain) {
            //如果没找到chain执行结果
            console.log("faile");   
        }
        console.log(chain);
        if(chain) {
            chain.execute({
            	pageNum:pageNum,
            	pageSize:'25'
            });
        }
    },
    editFail: function(operation) {
        var message = '修改失败!!!';
        XapMessageBox.info(message);
    }
});
