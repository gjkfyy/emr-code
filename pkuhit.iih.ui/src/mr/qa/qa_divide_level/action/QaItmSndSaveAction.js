/** 
 * 二级分类保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSndSaveAction', {
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
        block.fstCd = data.fstCd;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        if(eventNm == 'addClick'){
	     	this.addOperations(operations,data);
        }else{
        	data.sndCd = properties.data.sndCd;
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
    	//修改二级分类
    	var sndCd =data.sndCd;
        var url = this.url+"/"+sndCd; 
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
    	var closeQaItmFstChain = owner.getActionChain('closeQaItmSnd');
    	closeQaItmFstChain.execute();
    	var block = this.getBlock('content');
        var fstCd = block.fstCd ;
    	//刷新一级分类的记录
        var view  =  owner.sourceView;
     
    	var chain = view.getActionChain('treeSelect');
    	chain.execute({
    		fstCd:fstCd
    	});
    }
});