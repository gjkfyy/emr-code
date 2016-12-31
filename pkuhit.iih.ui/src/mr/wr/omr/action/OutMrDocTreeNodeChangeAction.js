Ext.define('iih.mr.wr.omr.action.OutMrDocTreeNodeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) { 
		 var rb = this.getBlock('result').down('xaptree');
		 var treeNode = rb.getSelectionModel().getSelection();
         var merge = treeNode[0].raw.merge;
         var mrPk = treeNode[0].raw.mrPk;
         var mrTpCcatCode=treeNode[0].raw.mrTpCcatCd;
         var owner = this.getOwner();
         setTimeout(function() {
        	 if(rb.isDisabled()){
            	 rb.enable();
        	 }
         },350);
         if(mrPk){
        	rb.disable();
        	var mr=treeNode[0].raw;
        	var deleteBtn=owner.down('toolbar button[method=delete]');
           	var property=owner.down('toolbar button[method=property]');
           	property.setDisabled(false);
           	if(1==mr.canDelete){
           		deleteBtn.setDisabled(false);
           	}else{
           		deleteBtn.setDisabled(true);
           	}
          	var right = owner.getBlock('right');
          	if(right){
          		var mrSn = right.mrSn;
          		if(mrPk!=mrSn){
          			delete right.mrTpCcatCd;
          			var objView=right.down("objectview");
          			if(objView){
          				var callback=function(){
      						right.remove(objView);
      						right.mrSn = mrPk;
      	 			        right.opType = 'open';
      	 			        setTimeout(function() {
      	 			        	var initChain =  right.getActionChain('init');
      	 			        	initChain.execute();
      	 			        },150);
      	 			        
      					};
          				if(right.hasEdit()){
          					XapMessageBox.confirm('是否保存对当前病历的修改？',
          				            function(btn, text){
          				                if (btn == 'yes') {
          				                	var saveActionChain=right.getActionChain('emrSave');
          				                	saveActionChain.execute({callback:callback});
          				                } else if (btn == 'no') {
          				                	callback();
          				                } else if (btn == 'cancel') {
          				                	
          				                }
          				            },right
          				        );
          				}else{
          					callback();
          				}
          				
          			}else{
          				right.mrSn = mrPk;
  	 			        right.opType = 'open';
  	 			        var initChain =  right.getActionChain('init');
  	 			        initChain.execute();
          			}
          		}
          	}
          }else if(mrTpCcatCode){
        	  rb.disable();
        	  var right = owner.getBlock('right');
        	  var create=owner.down('toolbar button[method=create]');
        	  var deleteBtn=owner.down('toolbar button[method=delete]');
        	  var property=owner.down('toolbar button[method=property]');
        	  property.setDisabled(true);
        	  deleteBtn.setDisabled(true);
        	  create.setDisabled(true);
        	  if(right){
        		  var mrTpCcatCd = right.mrTpCcatCd;
        		  if(mrTpCcatCode!=mrTpCcatCd){
        			  delete right.mrSn;
        			  /*if(right.items.items[0]){
          					right.remove(right.items.items[0]);
          				}*/
        			  var objView=right.down("objectview");
        			  if(objView){
        				  right.remove(objView);
        			  }
        			  right.mrTpCcatCd = mrTpCcatCode;
        			  right.opType = 'open';
        			  var initChain =  right.getActionChain('init');
        			  initChain.execute();
        		  }
        	  }
         }else if(merge){
         	rb.disable();
           	var right = owner.getBlock('right');
           	var create=owner.down('toolbar button[method=create]');
           	var deleteBtn=owner.down('toolbar button[method=delete]');
           	var property=owner.down('toolbar button[method=property]');
           	property.setDisabled(true);
           	deleteBtn.setDisabled(true);
           	create.setDisabled(false);
           	if(right){
           		delete right.mrSn;
           		delete right.medicalRecord;
           		var opType = right.opType;
           		if(opType!='merge'){
           			var objView=right.down("objectview");
        			if(objView){
        				right.remove(objView);
        			}
  			        right.opType = 'merge';
  			        var initChain =  right.getActionChain('init');
  			        initChain.execute();
           		}
           	}
        	 
         }else{
//        	var create=owner.down('toolbar button[method=create]');
          	var deleteBtn=owner.down('toolbar button[method=delete]');
          	var property=owner.down('toolbar button[method=property]');
          	property.setDisabled(true);
          	deleteBtn.setDisabled(true);
//          	create.setDisabled(true);
         }
    }
});
