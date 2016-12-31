Ext.define('iih.po.assistant.action.SaveFragmentTplAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	doExecute: function(context) {
	   this.callParent();    
	   var rs = this.getBlock('result').ownerCt; 
	   if(!this.getBlock('result').getForm().isValid()){
		   return;
	   }
	   //向后台发送form表单   
	   var data =this.getBlock('result').getForm().getValues();
	   var ownerTypeCd = data.ownerTypeCd;
	   if(ownerTypeCd=="MDM12.03"){//个人
	   		data.ownerCd = IMER_GLOBAL.user.code;
	   }else if(ownerTypeCd=="MDM12.02"){//科室
	   		data.ownerCd = IMER_GLOBAL.department.code;
	   }
	   //判断当前操作是保存还是修改
	   var owner=this.getOwner();
	   var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	   //create or edit
	   var method = properties.data.method;
	   if(data!=undefined||data!=null){
	   	   if(method=='create'){
	   	   	    this.createPrepareOperations(context.operations,data);
	   	   }else if(method=='edit'){
	   	   	    this.editPrepareOperations(context.operations,data);
	   	   }
	   }
	},    
    createPrepareOperations: function(operations,data) {
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_CREATE,
            condition: null,
            data:data,
            scope: this,
            success: this.createOnSuccess
        };
        operations.push(operation);
    },
    createOnSuccess: function() {
    	var owner=this.getOwner();
    	//关闭当前页
    	var editView = owner.ownerCt;
        editView.close();
        //调用主页面个人知识库列表刷新
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		//树节点选择病历分类编号
		var parentView = properties.data.parentView;
        var chain = parentView.getActionChain('init');
        if(chain) {
            chain.execute();
        }
        var center = parentView.getBlock('center');
		/*var grid = west.down('xapgrid[name=knoeledgeteGrid]');
		var result =grid.getSelectionModel().getSelection()[0].data;*/
    	var data =this.getBlock('result').getForm().getValues();
    	var knowledgeContent=data.fragmentTplContent;
		center.down('xaptextarea').setValue(knowledgeContent);
    },    
    editPrepareOperations: function(operations,data) {
        var url = this.url;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_UPDATE,
            condition: null,
            data:data,
            scope: this,
            success: this.editOnSuccess
        };
        operations.push(operation);
    },
    editOnSuccess: function() {
    	var owner=this.getOwner();
    	var data =this.getBlock('result').getForm().getValues();
    	var knowledgeContent=data.fragmentTplContent;
    	//关闭当前页
    	var editView = owner.ownerCt;
        editView.close();
        //调用主页面个人知识库列表刷新
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		//树节点选择病历分类编号
		var parentView = properties.data.parentView;
        var chain = parentView.getActionChain('init');
        if(chain) {
            chain.execute();
        }
        var center = parentView.getBlock('center');
		center.down('xaptextarea').setValue(knowledgeContent);
    } 
});