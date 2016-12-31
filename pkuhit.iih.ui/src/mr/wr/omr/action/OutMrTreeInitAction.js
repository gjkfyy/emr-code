Ext.define('iih.mr.wr.omr.action.OutMrTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
		this.from=context.from;
        var omrTempSortTree=Ext.getCmp('omrTempSortTree');
    	if(omrTempSortTree.getStore().tree.root.childNodes.length==0||context.tempInit=='tempInit'){
    		var tempInit = this.getOwner().getActionChain('tempInit');
	        if(tempInit) {
	        	tempInit.execute();
	        }
    	}
        var operations = context.operations; 
        var owner=this.getOwner();
        owner.ownerCt.ownerCt.addListener('hide', function(enPk){
        	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
        	reSelectTempBtn.hide();
        	var erpSignBtn=Ext.getCmp('erpSignBtn');
        	erpSignBtn.hide();
        	var serchErpSignBtn=Ext.getCmp('serchErpSignBtn');
        	serchErpSignBtn.hide();
	    });
        owner.ownerCt.ownerCt.addListener('show', function(enPk){
        	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
        	reSelectTempBtn.show();
        	var erpSignBtn=Ext.getCmp('erpSignBtn');
        	erpSignBtn.show();
        	var serchErpSignBtn=Ext.getCmp('serchErpSignBtn');
        	serchErpSignBtn.show();
	    });   
        var enPk = context.enPk;
        if(enPk==undefined){
        	if(IMER_GLOBAL.encounterSn){
        		enPk = IMER_GLOBAL.encounterSn;
        		this.showLoading();
        	}else{
        		return
        	}
        }else{
        	this.showLoading();
        }
        var toolbarsInitAction=this.getOwner().getActionChain('toolbarsInit');
        toolbarsInitAction.execute();
        var erpSignBtnStatusAction=this.getOwner().getActionChain('erpSignBtnStatus');
        erpSignBtnStatusAction.execute();
        var url = this.url+"?encounterPk="+enPk+'&showAllCourse=1';  
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
        var block = this.getBlock('result');
        var right=this.getOwner().getBlock('right');
        var owner=this.getOwner();
//        if('addSuccess'!=this.from){//当不是新建保存成功刷新时需要关闭编辑器，执行此段代码
            var objView=right.down("objectview");
    		if(objView){
    			right.remove(objView);
    			delete right.mrSn;
    			delete right.medicalRecord;
    		}
//    	}
//        var mr=right.medicalRecord;
        var m = operation;
        if(m.result.data.children){
        	block.setData(m.result.data.children);
        	var tree = block.down('xaptree');
//        	if(mr&&mr.mrPk){
//        		tree.selectById(mr.mrPk);
//        		var rb = tree.getSelectionModel().getSelection();
//                var treeNode = rb[0];
//                if(rb){
//                	if(treeNode&&treeNode.parentNode){
//                    	treeNode.parentNode.expand();
//                    	var property=owner.down('toolbar button[method=property]');
//                    	property.setDisabled(false);
//                    }
//                }
//        	}else{
    		tree.selectById('MRM14.09');

        	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
    		var rb = tree.getSelectionModel().getSelection();
    		if(rb&&rb.length>0){
    		var treeNode = rb[0];
            	if(treeNode&&treeNode.childNodes.length>0){
                	treeNode.expand();
                	var id= treeNode.data.children[0].id;
                	if(id){
                		var mr=treeNode.data.children[0];
                		var deleteBtn=owner.down('toolbar button[method=delete]');
                		if(mr.canDelete=='1'){
                			deleteBtn.setDisabled(false);
                		}else{
                			deleteBtn.setDisabled(true);
                		}
                		tree.selectById(id);
                		var treeNodeChange=this.getOwner().getActionChain('treeNodeChange');
                		treeNodeChange.execute();
                	}
                	
                }else{
                   	if(reSelectTempBtn){
            			reSelectTempBtn.setDisabled(true);
            		}
                }
            }else{
               	if(reSelectTempBtn){
        			reSelectTempBtn.setDisabled(true);
        		}
            }
//        	}
        }else{
        	block.setData([]);
        	var tree = block.down('xaptree');
        	tree.getSelectionModel().deselectAll();
        	var deleteBtn=owner.down('toolbar button[method=delete]');
           	var property=owner.down('toolbar button[method=property]');
           	deleteBtn.setDisabled(true);
           	property.setDisabled(true);
           	var reSelectTempBtn=Ext.getCmp('reSelectTempBtn');
           	if(reSelectTempBtn){
    			reSelectTempBtn.setDisabled(true);
    		}
        	var medicalRecord=m.result.data.medicalRecord;
        	if(medicalRecord){//medicalRecord有值代表有默认模板，有默认模板则进行创建病历
        		right.opType = 'new';
        		right.medicalRecord=medicalRecord;
        		var initChain =  right.getActionChain('init');
		        initChain.execute();
        	}else{//否则弹出新建病历对话框
            	if(IMER_GLOBAL.encounterSn){
            	    if(CONFIG_PARAM.OMR_IS_POP_SELECT_TEMPLATE == 1){
            	        var createAction=this.getOwner().getActionChain('create');
            	        createAction.execute();
            	    }
            	}
        	}
        }
    }  
});