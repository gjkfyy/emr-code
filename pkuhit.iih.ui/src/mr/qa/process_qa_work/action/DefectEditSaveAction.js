/** 
 * 缺陷编辑保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_work.action.DefectEditSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:[],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var showInfo = block.down('xapdisplayfield[name=showInfo]');
		var form= block.getForm();
        var data = form.getValues();

    	var operations = context.operations;
        if(!operations) {
     		return;
	    }
	    this.prepareOperations(operations,data);
    
        /*if(data.rfmDes == ""){
        	showInfo.setValue('<font color=red>整改说明为空</font>');
			return null;
        }else{}*/
    },

    prepareOperations: function(operations,data){
    	var qaFltPk = data.qaFltPk;
        var url = this.url+"/"+qaFltPk; 
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
    	var closeChain = owner.getActionChain('close');
    	closeChain.execute();
    	
    	//刷新缺陷一览的记录
        var view  =  owner.sourceView;
    	var chain = view.getActionChain('searchDefectsAction');
    	chain.execute();
    }
});