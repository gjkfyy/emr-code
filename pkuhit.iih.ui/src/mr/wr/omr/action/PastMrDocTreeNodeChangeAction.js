Ext.define('iih.mr.wr.omr.action.PastMrDocTreeNodeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) { 
		 var rb = this.getBlock('result').down('xaptree');
		 rb.disable();
		 var treeNode = rb.getSelectionModel().getSelection();
         var mrPk = treeNode[0].raw.mrPk;
         var mrTpCcatCode=treeNode[0].raw.mrTpCcatCd;
         var owner = this.getOwner();
         setTimeout(function() {
        	 if(rb.isDisabled()){
            	 rb.enable();
        	 }
         },350);
         var mrDocNmText=owner.ownerCt.ownerCt.down('[name=mrNm]');
         var logicSmtTimeDateFiled=owner.ownerCt.ownerCt.down('[name=logicSmtDate]');
         if(mrPk){
        	var mr=treeNode[0].raw;
            var mrDocNm=mr.nm;
            mrDocNmText.setValue(mrDocNm);
            logicSmtTimeDateFiled.setValue(new Date());
          	var right = owner.getBlock('right');
          	if(right){
          		var mrSn = right.mrSn;
          		if(mrPk!=mrSn){
          			delete right.mrTpCcatCd;
          			var objView=right.down("objectview");
          			right.mrSn = mrPk;
          			right.opType = 'readonly';
          			if(objView){
  						right.remove(objView);
          			}
          			setTimeout(function() {
	 			        	var initChain =  right.getActionChain('init');
	 			        	initChain.execute();
	 			    },150);
          		}
          	}
          }else{
        	  mrDocNmText.setValue(null);
        	  logicSmtTimeDateFiled.setValue(null);
         	var right = owner.getBlock('right');
         	if(right){
//         		var mrTpCcatCd = right.mrTpCcatCd;
//         		if(mrTpCcatCode!=mrTpCcatCd){
         			delete right.mrSn;
         			delete right.medicalRecord;
         			var objView=right.down("objectview");
          			if(objView){
          				right.remove(objView);
          			}
//			        right.mrTpCcatCd = mrTpCcatCode;
//			        right.opType = 'readonly';
//			        var initChain =  right.getActionChain('init');
//			        initChain.execute();
//         		}
         	}
         }
    }
});
