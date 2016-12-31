/** 
 * 质控项目保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSaveAction', {
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
        block.sndCd = data.sndCd;
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
        if(eventNm == 'addClick'){
        	var fstCdValue = block.down('xapcombobox[name=fstCd]').value;
        	var sndCdValue = block.down('xapcombobox[name=sndCd]').value;
        	if(fstCdValue == null || sndCdValue == null){
        		XapMessageBox.info("请添加分类信息");
        	}else{
        		this.addOperations(operations,data);
        	}
        }else{
        	data.qaItmCd = properties.data.qaItmCd;
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
    	var qaItmCd =data.qaItmCd;
        var url = this.url+"/"+qaItmCd; 
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
    	var closeQaItmFstChain = owner.getActionChain('closeQaItm');
    	closeQaItmFstChain.execute();
    	var block = this.getBlock('content');
        var fstCd = block.fstCd ;
        var sndCd = block.sndCd ;
    	//刷新一级分类的记录
        var view  =  owner.sourceView;
     
    	var chain = view.getActionChain('treeSelect');
    	chain.execute({
    		fstCd:fstCd,
    		sndCd:sndCd
    	});
    }
});