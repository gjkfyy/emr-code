Ext.define('iih.po.assistant.action.MrDocTreeNodeChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	execute: function(context) { 
		var operations = context.operations;
    	if(!operations) {
            return;
        }
		 var rb = this.getBlock('result').down('xaptree');
//         	var tree=bolck.down('xaptree');
		 var treeNode = rb.getSelectionModel().getSelection();
         var mrPk = treeNode[0].raw.mrPk;
         var mrTpCcatCode=treeNode[0].raw.mrTpCcatCd;
         var owner = this.getOwner();
         owner.mrTpCcatCode=mrTpCcatCode;
         setTimeout(function() {
        	 if(rb.isDisabled()){
        		 console.log('enable');
            	 rb.enable();
        	 }
         },350);
         if(mrPk){
        	 owner.mrSn=mrPk;
        	 rb.disable();
          	var right = owner.getBlock('right');
          	if(right){
          		var mrSn = right.mrSn;
          		if(mrPk!=mrSn){
          			delete right.mrTpCcatCd;
          			right.mrSn = mrPk;
 			        right.opType = 'readonly';
// 			        var objView=right.down("objectview");
 			        var items=right.items.items;
 			        var l=items.length;
// 			        console.log(items.length);
// 			       	console.log('前');
// 			       	console.log(right.items.items.length);
 			       for(var i=0;i<l;i++){
// 			    	  console.log('第'+i+'次循环');
// 			    	 console.log(items);
 			    	   var ob=items[0];
// 			    	  console.log(ob.xtype);
 			    	   if(ob.xclass!='iih.mr.block.editor.MrDocEditBlock'){
 			    		  right.remove(ob);
// 			    		  console.log('right.remove(ob);');
 			    	   }
 			       }
// 			      console.log('后');
// 			     console.log(right.items.items.length);
//         			if(objView){
//         				right.remove(objView);
//         				console.log('right.remove(objView);');
// 			        }else{
// 			        	console.log('not ------right.remove(objView);');
// 			        }
 	 			    var initChain =  right.getActionChain('init');
 	 			    initChain.execute();	
          			/*if(right.items.items[0]){
          				right.remove(right.items.items[0]);
          			}*/
          		}
          	}
          }else if(mrTpCcatCode){
        	  rb.disable();
         	var right = owner.getBlock('right');
         	if(right){
         		var mrTpCcatCd = right.mrTpCcatCd;
         		if(mrTpCcatCode!=mrTpCcatCd){
         			delete right.mrSn;
         			var objView=right.down("objectview");
         			if(objView){
         				right.remove(objView);
 			        }
			        right.mrTpCcatCd = mrTpCcatCode;
			        right.opType = 'readonly';
			        var assistantEncounterList= Ext.getCmp('assistantEncounterList');
			        if(assistantEncounterList){
			        	right.encounterSn=assistantEncounterList.getValue();
			        }
			        var initChain =  right.getActionChain('init');
			        initChain.execute();
         		}
         	}
         }
    }/*,
    readPrepareOperations: function(operations, mrSn) {
    	var url = '/mrfile/'+mrSn;
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            method: METHODS.METHOD_GET,
            scope: this,
            success: this.onReadSuccess
        };
        operations.push(operation);
    },
    onReadSuccess: function(operation) {
        var self=this;
        var mrDocEditPage=self.getOwner();
        mrDocEditPage.medicalRecord=operation.result.data;
//        console.log(mrDocEditPage.medicalRecord);
        var plugin = document.getElementById('iemrEditorRead');
	        if(plugin&&plugin.valid){
	        	plugin.OpenFromString(operation.result.data.fileData,3);
//	        	this.readPrepareOperations(operations, mrSn)
	        }else{
		        var initChain =  right.getActionChain('init');
		        initChain.execute();	
	        }
//        var params={
//                'objectId':'iemrEditorRead',
//                'sstream':operation.result.data.fileData,
//                'mr_mode':3,
//                'readonly':true,
//                'callBackAction':'closeProgress'
//        };
    }*/
});
