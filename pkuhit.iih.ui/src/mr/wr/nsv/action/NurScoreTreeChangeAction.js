Ext.define('iih.mr.wr.nsv.action.NurScoreTreeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) { 
		 var rb = this.getBlock('result').down('xaptree');
		 var treeNode = rb.getSelectionModel().getSelection();
//         var merge = treeNode[0].raw.merge;
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
           		deleteBtn.setDisabled(false);
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
