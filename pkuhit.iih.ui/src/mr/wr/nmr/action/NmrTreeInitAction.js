Ext.define('iih.mr.wr.nmr.action.NmrTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
		this.from=context.from;
        var operations = context.operations;  
        var enPk = context.enPk;
        if(enPk==undefined){
        	if(IMER_GLOBAL.encounterSn&&IMER_GLOBAL.encounterSn!=null){
        		enPk = IMER_GLOBAL.encounterSn;
        	}
        }
        this.showLoading();
        var url = this.url+"?encounterPk="+enPk;
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
		var leftBlock= this.getOwner().getBlock('left');
    	if('XAPM06.10'==IMER_GLOBAL.portal.code){
    		var insertButton=leftBlock.down('button[name=insert]');
    		var deleteButton=leftBlock.down('button[name=delete]');
    		insertButton.show();
    		insertButton.setDisabled(false);
    		deleteButton.show();
    	}
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
        //mengxinhua add begin
        if(mr && mr.encounterPk){
            if(mr.encounterPk != IMER_GLOBAL.encounterSn){
                var objView=right.down("objectview");
                if(objView){
                    right.remove(objView);
                    delete right.mrSn;
                    delete right.medicalRecord;
                }
            }
        }
       //mengxinhua add end
//        var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
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
//                    	tree.getSelectionModel().select(treeNode.childNodes[0]);
//                    	var treeNodeChange= this.getOwner().getActionChain('treeNodeChange');
//                    	treeNodeChange.execute();
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
        	if(IMER_GLOBAL.encounterSn&&'XAPM06.10'==IMER_GLOBAL.portal.code){
        		var createAction=this.getOwner().getActionChain('create');
            	createAction.execute();
        	}
        }
        var data=m.result.data;
        var writeCompleted=Ext.getCmp('writeCompleted');
        if(data&&data.amr&&data.amr.statusCode!=iih.mr.qa.QaStatusGlobal.writeStarted){
        	var insertButton=leftBlock.down('button[name=insert]');
    		var deleteButton=leftBlock.down('button[name=delete]');
    		var refresh=leftBlock.down('tool[name=refresh]');
    		insertButton.setDisabled(true);
    		deleteButton.setDisabled(true);
    		//refresh.setDisabled(true);
    		writeCompleted.setDisabled(true);
    		var init= right.getActionChain('init');
    		init.execute();
        }else{
        	writeCompleted.setDisabled(false);
        }
    }  
});
