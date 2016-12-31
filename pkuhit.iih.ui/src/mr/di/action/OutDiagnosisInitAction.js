Ext.define('iih.mr.di.action.OutDiagnosisInitAction',{
	extend : 'Xap.ej.action.ServiceInvocation',
	requires:['iih.mr.di.action.Util','iih.mr.di.model.OutDiagnosisModel'],
	
	doExecute: function(context) {
/*	     var owner = this.getOwner();
	     var diagnosisSavechain = owner.getActionChain("outDiagnosisSaveAction");
	     diagnosisSavechain.execute();*/

		   //this. showLoading();
           this.prepareOperations(context.operations,context);
        },
	 prepareOperations: function(operations,context) {
	       
        	/*var condition = {
        	         userId: IMER_GLOBAL.user.code,
        	         orgCd: IMER_GLOBAL.department.code
        	          
        	        };
        	        
        	var qs = Ext.Object.toQueryString(condition);
        	var url = this.url;
        	url += '?' + qs;*/
        	
	        var url = this.url;
	        var METHODS = this.getInvocationMethods();
	    	var operation = {
	            url: url,
	    		mclass: null,
	    		method: METHODS.METHOD_GET,
	    		condition: null,
	    		scope: this,
	    		success: this.onSuccess,
	    	    fail: this.onFailure
	    	};
	    	operations.push(operation);
	    },
	
	onSuccess : function(operation) {
	         var me = this;
		     var owner=me.getOwner();	
		     var tree = owner.ownerCt.down('diagnosisfiltertree');
		 	 var selModel=tree.getSelectionModel();
		 	 var rootNode=tree.getRootNode();
		     
		     var res = operation.result;
		    
		     
		     var datas = iih.mr.di.action.Util.cascadeTransfer(res, function(node){
					node['expanded'] = true;
					if (node['children']) {
						node['leaf'] = false;
					} else {
						node['leaf'] = true;
					}
					
					if(node['icdCd'] == 'NULL'){
					    node['icdCd'] = '';
					}
				});
		     
		      tree.setData(datas);
		      if(owner.data!=null){
		    	  owner.csaInsertDiagnosis(owner.data);
		    	  owner.data = null;
		      }
		     
		      
		      var index = rootNode.childNodes.length;
		      var node = {
		      		      'diNm':'',
			       	      'diEmpNm':IMER_GLOBAL.user.name,
			       	      'diEmpCd':IMER_GLOBAL.user.code,
			       	      'diTime':'',
			       	      'diCd':'',
						  'diSn':'',
						  'icdCd':'',
						  'setOwnerTypeCd':'',
		          	      'setOwnerCd':'',
			        	   leaf:true	 
		         };
		  	   rootNode.insertChild(index,node);
		  	   selModel.select(node);  
	    	
	    },
	 onFailure: function(operation) {
	    	XapMessageBox.info('查询失败!');
	    },  
});
