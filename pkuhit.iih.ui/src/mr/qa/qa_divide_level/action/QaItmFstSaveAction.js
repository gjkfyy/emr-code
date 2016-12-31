/** 
 * 一级分类保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaItmFstSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		var eventNm = properties.data.eventNm;
		var block = this.getBlock('content');
		var form= block.getForm();
        var data = form.getValues();
        data.eventNm = eventNm;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        if(eventNm == 'addClick'){
	     	this.addOperations(operations,data);
        }else{
        	data.fstCd = properties.data.fstCd;
        	this.prepareOperations(operations,data);
        }
     	
    },
    addOperations: function(operations,data){
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_CREATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    prepareOperations: function(operations,data){
    	//修改一级分类
    	var fstCd =data.fstCd;
        var url = this.url+"/"+fstCd; 
        var mclass = null;
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
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
	    var owner = this.getOwner();
	    //关闭此画面
    	var closeQaItmFstChain = owner.getActionChain('closeQaItmFst');
    	closeQaItmFstChain.execute();
    	
    	//刷新一级分类的记录
        var view  =  owner.sourceView;
    	
    	var chain = view.getActionChain('init');
    	chain.execute();
    }
});