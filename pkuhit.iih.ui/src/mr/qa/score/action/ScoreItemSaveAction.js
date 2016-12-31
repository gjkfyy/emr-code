/** 
 * 质控项目保存Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.score.action.ScoreItemSaveAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
	
	/*   
	* @Override
	*/
	execute: function(context) {   
		
		this.showSubmitProgressBar();
		
    	var owner = this.getOwner();
    	      
    	//获取质控项目block
		var block = this.getBlock('content');
		
		var rfmDes = block.getData().rfmDes;
		var qaItemGrid = block.down('xapgrid');
		
		var socuseOwner = owner.socuseOwner;
		var properties = socuseOwner.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
    	//参数处理
    	var selModel = qaItemGrid.getSelectionModel();
        var selRecord = selModel.getSelection()[0];
        if(null == selRecord){
        	this.closeSubmitProgressBar();
        	XapMessageBox.info('请选择一条记录');
        	return;
        }
        selRecord.data.drpDes = rfmDes;
    	var listdata = this.getData(selRecord.data,properties,socuseOwner);
    	
    	var operations = context.operations;
    	if(!operations) {
    		this.closeSubmitProgressBar();
    		return;
    	}
    	this.prepareOperations(operations,listdata);
    	
    	
    },
    prepareOperations: function(operations,data){
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
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        
    	//获取质控项目block
		var block = this.getBlock('content');
		var defectinGrid = block.down('xapgrid');
	    var m = operation.result;
	    
	    //质控工作画面中的缺陷一览进行查询
	    var owner = this.getOwner();
	    
	    //关闭此画面
    	var closeChain = owner.getActionChain('closeFaultAction');
    	closeChain.execute();
	    
    	//刷新终末评分页面
    	var socuseOwner = owner.socuseOwner;
    	var chain = socuseOwner.getActionChain('init');
    	chain.execute();
    	
    	
    },
    getData:function(data,properties,socuseOwner){
    	//保存的参数集合
    	var datasArr = [];
    	var workScreen = properties.data.workScreen;
    	var obj = new Object();
		obj.qaItmPk = data.qaItmCd;
		obj.deductScrTimes = data.deductScrTimes;//缺陷次数
		obj.drpDes =  data.drpDes;
		if(workScreen == '7'){
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal; 
		}else if(workScreen == '11'){
			qaTyCd = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept; 
		}
		
		obj.qaTyCd = qaTyCd; 
		obj.enPk = properties.data.enPk; 
		
    	datasArr.push(obj);
    	
    	 var data={qaDivideArray:datasArr};
    	 
    	 return data;
    }
});