/** 
 * 病案新增、编辑保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelSaveAction', {
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
		var lvl = block.down('xapcombobox[name=lvl]');
		var qaDivideLevelCd = lvl.value;
		var lvl = lvl.rawValue; //value
		var form= block.getForm();
        var data = form.getValues();
        data.eventNm = eventNm;
        data.qaDivideLevelCd = qaDivideLevelCd;
        data.lvl = lvl;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        if(eventNm == 'addClick'){
	     	this.addOperations(operations,data);
        }else{
        	data.qaDivideLevelCd = properties.data.qaDivideLevelCd;
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
    	//修改病案等级
    	var qaDivideLevelCd =data.qaDivideLevelCd;
        var url = this.url+"/"+qaDivideLevelCd;
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
    	var closeQaItmFstChain = owner.getActionChain('closeQaDivideLevel');
    	closeQaItmFstChain.execute();
    	
    	//刷新一级分类的记录
        var view  =  owner.sourceView;
    	
    	var chain = view.getActionChain('init');
    	chain.execute();
    }
});