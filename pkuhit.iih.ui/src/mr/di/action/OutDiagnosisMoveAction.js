 Ext.define('iih.mr.di.action.OutDiagnosisMoveAction', {
	extend: 'Xap.ej.action.Action',
	requires:['iih.mr.di.model.OutDiagnosisModel'],
	/*
	* @Override
	*/
	execute: function(context) {
	 
         var me = this;
	     var owner=me.getOwner();	
	     var tree = owner.ownerCt.down('diagnosisfiltertree');
	     var rootNode = tree.getRootNode();
	     var selModel=tree.getSelectionModel();
	     var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	     if(properties.data.action=='moveup'){
	    	 
	    	 me.moveUpOrDownFun(selModel,1);
	    	
	    	 
	     }else if(properties.data.action=='movedown'){
	    	 
	    	 me.moveUpOrDownFun(selModel,2);
	    	
	    	 
	     }else if(properties.data.action=='insertBtn'){
	    	 
	    	 me.insertDiagnosisFun(rootNode,tree);
	    	 
	     }else if(properties.data.action=='newRowOnButtom'){
	    	 
	    	 me.newRowOnButtom(rootNode,tree);
	    	 
	     }else if(properties.data.action=='commitBtn'){
	    	 
	    
	     }else if(properties.data.action=='deleteBtn'){
	    	 
	    	 me.delDiagnosisFun(selModel,me);
	     }
	     
	     
    },
    
    //上下移动
    moveUpOrDownFun:function(selModel,flag){
    	
	     var selRecord = selModel.getSelection()[0];
	   	 if(selRecord){
	   		     var parentNode=selRecord.parentNode;
	        	 var previousSibling =selRecord.previousSibling;
	        	 var index;
	        	 if(flag == 1){
	        		  
	        		 if(!previousSibling ){
			             //第一个子节点不能上移
			        	 return;
			          }else{
			        	  var indexRecord=parentNode.indexOf(previousSibling);
					      index = indexRecord;
							  var outDiagnosisBlock=this.getBlock('content');
							  outDiagnosisBlock.setBtnCommitDisabled(false);
			          }
	        	 }else{
	        		 
	        		   var indexRecord=parentNode.indexOf(selRecord);
	        	       if( parentNode.childNodes.length===index+1){
	        	    	   //最后一条不能移动
	        	    	   return;
	        	       }else{
	        	    	   index = indexRecord+1;
		        	    	   var outDiagnosisBlock=this.getBlock('content');
							   outDiagnosisBlock.setBtnCommitDisabled(false);
	        	       }
	        	 }
	        	  selRecord.remove();
				  parentNode.insertChild(index,selRecord);
				  selModel.select(selRecord);    
	   	    }
    },
    //在当前行上面插入一行
    insertDiagnosisFun:function(rootNode,tree){
    	
    	 var index = rootNode.childNodes.length;
    	 var selModel=tree.getSelectionModel();
 	     var selRecord=selModel.getSelection()[0];
 	     var selectIndex = rootNode.indexOf(selRecord);
 	     if(index != selectIndex){
 	    //  if(rootNode.lastChild===selRecord){
 	    	if(selRecord.data.diNm!=''){
 	    		
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
 	      	   rootNode.insertChild(selectIndex,node);
	 	      	   var outDiagnosisBlock=this.getBlock('content');
	 	      	   outDiagnosisBlock.setBtnCommitDisabled(false);
 	    	}
 	    }
         
       //  tree.setData(node);
    },
    //最下面新增一行
    newRowOnButtom:function(rootNode,tree){
    	
    	 var index = rootNode.childNodes.length;
    	 var selModel=tree.getSelectionModel();
 	     var selRecord=selModel.getSelection()[0];
 	    if(rootNode.lastChild===selRecord){
 	    	if(selRecord.data.diNm!=''){
 	    		
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
				   var outDiagnosisBlock=this.getBlock('content');
				   outDiagnosisBlock.setBtnCommitDisabled(false);
 	    	}
 	    }
         
       //  tree.setData(node);
    },
    
    //删除
    delDiagnosisFun:function(selModel,me){
    	
    	 var selRecord = selModel.getSelection()[0];
    	 var outDiagnosisAction = me.getOwner().getActionChain('outDiagnosisDelAction');
    	 if(selRecord){
    		 XapMessageBox.confirm2(
 					'确认删除该记录？',
 					function(btn){
 						if(btn == 'yes'){
 							
 							if(selRecord.get('diSn')==''){
 				    			 selRecord.parentNode.removeChild(selRecord);
 				    		 }else{
 				    			outDiagnosisAction.execute();
	 							var outDiagnosisBlock=this.getBlock('content');
	 							outDiagnosisBlock.setBtnCommitDisabled(false);
	 						//	Ext.MsgTip.msg('诊断列表变更通知', '病历中诊断同时被更新，请及时保存病历',true,5000);
 				    		 }

 						}
 				});
    	 }else{
    		 XapMessageBox.info('请选择一条记录!');
    	 }
    }
});
