/** 
 * 保存缺陷的Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.DefectInSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override  
	*/
	execute: function(context) {    
		
		this.showSubmitProgressBar();
		if(context.complete != undefined ){
			
			this.complete = context.complete;
		}
		
    
    	var owner = this.getOwner();
    	      
    	//获取缺陷一览的 block
		var block = this.getBlock('bottomcontent');
		
		var defectinGrid = block.down('xapgrid');
    	
		//定义更新的数据集合
		var updateData= [];
		
		//通过Store获取数据集方便判断
		var datas  = defectinGrid.getStore().getModifiedRecords( );

    	//遍历判断被修改的记录添加到集合变量中
    	for(var i=0;i<datas.length;i++){
    		
    		if(datas[i].dirty){
    			
    			var obj = new Object();
    			obj.pk = datas[i].data.pk;
    			obj.reformRequirement = datas[i].data.reformRequirement;
    			obj.reformedDescription = datas[i].data.reformedDescription;
    			obj.dropDescription = datas[i].data.dropDescription;
    			obj.faultConfirmResult = datas[i].data.faultConfirmResult;
    			updateData.push(obj);
    		}
    		
    	}
    	
    	var updatas = {qaFaultList:updateData};
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,updatas);
    	
    	
    },
    prepareOperations: function(operations,data){
        var url = this.url;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_UPDATE,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess,
    		failure: this.onFail
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
       
    	var owner = this.getOwner();
    	
    	if(this.complete != undefined && this.complete == 1){
    	    
    		this.complete = undefined;
    		
    		var popupDefectNoticeInferViewChain = owner.getActionChain("popupDefectNoticeInferViewAction");
    		popupDefectNoticeInferViewChain.execute();
    		
    	}
    	//提示保存成功
    	XapMessageBox.info('保存成功');
    	
    	//调用查询Action
    	var searchChain = owner.getActionChain('searchDefectsAction');
    	searchChain.execute();
        
    },
    onFail:function(operation){
    	XapMessageBox.info('保存失败');
    }
});