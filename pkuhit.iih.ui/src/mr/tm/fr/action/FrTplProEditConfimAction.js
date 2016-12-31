Ext.define('iih.mr.tm.fr.action.FrTplProEditConfimAction', {
extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();
	   var operations = context.operations;		 
	   var view = this.getOwner();
	   var properties = view.getLayer(Xap.ej.block.Layer.PROPERTIES);
	   var data = {};
       data.mrFrTplTpCd = properties.data.mrFrTplTpCd;//医疗记录基础模板编码
       data.nm = properties.data.nm;
       data.memo = properties.data.memo;//文件主键
       data.mrFrTplCd = properties.data.mrFrTplCd;
       this.getOwner().ownerCt.close();
       if(properties.data.customerData=='new'){
    	   //新建操作方式更改2014-12-14
    	   var layout = properties.data.block.getLayout();
    	   var mrFrTplTpCd = data.mrFrTplTpCd;
           var nm = data.nm;
           var memo = data.memo;
           var owner = properties.data.sourceView;
           var block = properties.data.block;
           
           var canvas = Xap.getCanvas();
           var config = {
                   xclass: 'iih.mr.tm.fr.view.FrTplEditView',
                   pageTitle: nm,
                   pageCode:'frtpleditview',
                   viewConfig:{
                       opType:'new',
                       mrFrTplTpCd:mrFrTplTpCd,
                       memo:memo
                   }
           };
           canvas.fireEvent("addWorkPage",config);
       }else if(properties.data.customerData=='edit'){
    	   this.prepareOperations(operations,data);
       }
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
    	var mrFrTplCd = data.mrFrTplCd;
        var url = this.url+"/"+mrFrTplCd;        
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
