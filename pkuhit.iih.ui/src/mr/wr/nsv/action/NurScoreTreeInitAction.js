Ext.define('iih.mr.wr.nsv.action.NurScoreTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
		this.from=context.from;
        var operations = context.operations;  
        this.showLoading();
        var url = this.url;
        var mclass = null;        
        var operation = {
            url: url,
            mclass: mclass,
            method: 'get',
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);  
    }, 

    onSuccess: function(operation) {
//    	if('XAPM06.14'==IMER_GLOBAL.portal.code){
//    		var leftBlock= this.getOwner().getBlock('left');
//    		var deleteButton=leftBlock.down('button[method=delete]');
//    		var propertyButton=leftBlock.down('button[method=property]');
//    		deleteButton.setDisabled(false);
//    		propertyButton.setDisabled(false);
//    	}
        var block = this.getBlock('result');
        var right=this.getOwner().getBlock('right');
        var owner=this.getOwner();
        if(this.from&&('addSuccess'!=this.from||this.from=='delete')){
//        	var right=this.getOwner().getBlock('right');
            var objView=right.down("objectview");
    		if(objView){
    			right.remove(objView);
    			delete right.mrSn;
    			delete right.medicalRecord;
    		}
    	}
        var mr=right.medicalRecord;//当前打开的病历
        var m = operation;
        if(m.result.data.children){
        	block.setData(m.result.data.children);
        	var tree = block.down('xaptree');
        	if(mr&&mr.mrPk){
        		tree.selectById(mr.mrPk);
        		var rb = tree.getSelectionModel().getSelection();              
                if(rb){
                	var treeNode = rb[0];
                	if(treeNode&&treeNode.data.parentId!=null&&treeNode.data.parentId!=undefined){
                		tree.selectById(treeNode.data.parentId);
                		var rb2 = tree.getSelectionModel().getSelection();
                		var parNode=rb2[0];
                		parNode.expand();
                		tree.selectById(mr.mrPk);
                		var deleteBtn=owner.down('toolbar button[method=delete]');
                		if(mr.canDelete=='1'){
                			deleteBtn.setDisabled(false);
                		}else{
                			deleteBtn.setDisabled(true);
                		}
                    	var property=owner.down('toolbar button[method=property]');
                    	property.setDisabled(false);
                    }
                }
        	}else{
        		var parNode=owner.parNode;
        		if(parNode){
        			tree.selectById(parNode);//选中数据
        		}
        		var rb = tree.getSelectionModel().getSelection();//取到 选中的数据
        		if(rb.length>0){
                	var treeNode = rb[0];
                	if(treeNode.childNodes.length>0){
                    	treeNode.expand();
                    	if(!parNode){
                    		parNode=treeNode.data.id;
                    	}
//                    	if(parNode=='MRM14.14'){
//                    		var id= treeNode.data.children[0].id;
//                        	if(id){
//                        		var mr=treeNode.data.children[0];
//                        		var deleteBtn=owner.down('toolbar button[method=delete]');
//                        		if(mr.canDelete=='1'){
//                        			deleteBtn.setDisabled(false);
//                        		}else{
//                        			deleteBtn.setDisabled(true);
//                        		}
//                        		tree.selectById(id);
//                        		var treeNodeChange=this.getOwner().getActionChain('treeNodeChange');
//                        		treeNodeChange.execute();
//                        	}
//                    	}else{
////                    		reSelectTempBtn.setDisabled(true);
//                    	}
                    }else{
//            			reSelectTempBtn.setDisabled(true);
                    }
        		}else{
//        			reSelectTempBtn.setDisabled(true);
        		}                    
        	}
        }else{
        	block.setData([]);
        	var tree = block.down('xaptree');
        	tree.getSelectionModel().deselectAll();
        	var deleteBtn=owner.down('toolbar button[method=delete]');
           	var property=owner.down('toolbar button[method=property]');
           	deleteBtn.setDisabled(true);
           	property.setDisabled(true);
           	if('XAPM06.14'==IMER_GLOBAL.portal.code){
	        	var createAction=this.getOwner().getActionChain('create');
	            createAction.execute();
           	}
        }
    }  
});
