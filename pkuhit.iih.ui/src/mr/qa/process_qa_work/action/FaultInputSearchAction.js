/** 
 * 查询质控项目Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.FaultInputSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*   
	* @Override
	*/
	execute: function(context) {      
		
		/*var app = Xap.getApp();
		app.baseUrl = "http://172.18.73.65:8082/";
		app.chainExecutor.baseUrl= "http://172.18.73.65:8082/";*/
    
    	var owner = this.getOwner();
    	      
    	//获取质控项目block
		var block = this.getBlock('content');
		
		var defectinGrid = block.down('xapgrid');
    	
        var data = {
        	qaItmFst:context.qaItmFst,
        	qaItmSnd:context.qaItmSnd,
        	enPk:context.encounterPk,
        	mrTypeCode:context.mrTypeCode,
        	mrSegmemtTypeCode:context.mrSegmemtTypeCode
        };
        
        /*var data = {
        		enPk:'870719',
        		mrTypeCode:'MRM16.02',
        		mrSegmemtTypeCode:'MRM01.01'
        };*/
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,data);
    	
    	
    },
    prepareOperations: function(operations,data){
    	var qs = Ext.Object.toQueryString(data);
    	  var url = this.url+'?'+ qs;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
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
	    var listData = [];
	    if(null != m.dataList){
		      for(var i=0;i<m.dataList.length;i++){
		    	var obj = new Object();
		    	var rw = Ext.Object.merge(obj, m.dataList[i]);
	            rw.deductScrTimes = 1;
	            listData.push(rw);
		    }
	    }
	  
    	if(defectinGrid){
    	    defectinGrid.setData(listData);
    	}else{
    		return;
    	}
    	if(CONFIG_PARAM.QA_RFMUSER_SELECT && iih.mr.qa.QaStatusGlobal.isNurseRole){
    		var rfmUserCmp = block.down('xapcombobox[name=rfmUser]');
			rfmUserCmp.show();	
			block.doLayout();
    	}
    	//wangyanli  add 2016-11-8 整改人下拉框数据 加载
    	var searchDeptEmpChain = this.getOwner().getActionChain('searchDeptEmp');
    	searchDeptEmpChain.execute();
    	
    	
    }
});