/** 
 * 点击整改，完成本次整改按钮前判断文书是否编辑
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.ConfirmAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var me = this;
		var owner = this.getOwner();
		var topBlock = this.getBlock('top');
		var resultBlock = this.getBlock('bottom');
	    var defectGrid = resultBlock.down('xapgrid');
	    var selModel = defectGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    if(record != undefined){
	    	var mrPk = record.data.mrPk;
	   		var sbmtTime = record.data.sbmtTime;
	    }
	    var mrPkFirst = topBlock.mrPk;
	    var sbmtTimeFirst = topBlock.sbmtTime;
	    //判断同一份缺陷不做操作
	    if(mrPk == mrPkFirst && sbmtTime == sbmtTimeFirst){
	    	return;
	    }else{
			var workView = topBlock.down();  //获取病历编辑器页面
			var workareapageview = owner.ownerCt;
	        var page = this.getBlock('top');
			//整改
	    	var rfmChain = this.getBlock('bottom').ownerCt.getActionChain('rfmDefect');
	    	//完成本次整改按钮
	    	var finishRfmChain = this.getBlock('bottom').ownerCt.getActionChain('defectStatusJudge');
	    	//双击
	    	var qaMrSignOpenChain = this.getBlock('bottom').ownerCt.getActionChain('qaMrSignOpen');
	        if(workView == undefined){
	        	if(context.event.name == "rfmClick"){
	        		if(rfmChain) {
		        		rfmChain.execute({});
		    		}
	        	}else if(context.event.name == "finishRfmClick"){
	        		if(finishRfmChain) {
		        		finishRfmChain.execute({});
		    		}
	        	}else if(context.event.name == "itemdblclick"){
	        		if(qaMrSignOpenChain) {
		        		qaMrSignOpenChain.execute({});
		    		}
	        	}else if(context.event.name == "linkClick"){
	        		if(qaMrSignOpenChain) {
		        		qaMrSignOpenChain.execute({});
		    		}
	        	}
	        }else{
	        	if(page.hasEdit && Ext.isFunction(page.hasEdit)){
	                    if(page.hasEdit()){
	                        workareapageview.showConfirm(function() {
	                            workareapageview.callControllerMethod(workView, function(workView) {
							    	if(context.event.name == "rfmClick"){
						        		if(rfmChain) {
							        		rfmChain.execute({});
							    		}
						        	}else if(context.event.name == "finishRfmClick"){
						        		if(finishRfmChain) {
							        		finishRfmChain.execute({});
							    		}
						        	}else if(context.event.name == "itemdblclick"){
						        		if(qaMrSignOpenChain) {
							        		qaMrSignOpenChain.execute({});
							    		}
						        	}else if(context.event.name == "linkClick"){
						        		if(qaMrSignOpenChain) {
							        		qaMrSignOpenChain.execute({});
							    		}
						        	}
	                            });
	                        }, function() {
	                        	if(context.event.name == "rfmClick"){
					        		if(rfmChain) {
						        		rfmChain.execute({});
						    		}
					        	}else if(context.event.name == "finishRfmClick"){
					        		if(finishRfmChain) {
						        		finishRfmChain.execute({});
						    		}
					        	}else if(context.event.name == "itemdblclick"){
					        		if(qaMrSignOpenChain) {
						        		qaMrSignOpenChain.execute({});
						    		}
					        	}else if(context.event.name == "linkClick"){
					        		if(qaMrSignOpenChain) {
						        		qaMrSignOpenChain.execute({});
						    		}
					        	}
	                        });
	                        return false;
	                    }else{
			                if(context.event.name == "rfmClick"){
				        		if(rfmChain) {
					        		rfmChain.execute({});
					    		}
				        	}else if(context.event.name == "finishRfmClick"){
				        		if(finishRfmChain) {
					        		finishRfmChain.execute({});
					    		}
		        			}else if(context.event.name == "itemdblclick"){
				        		if(qaMrSignOpenChain) {
					        		qaMrSignOpenChain.execute({});
					    		}
				        	}else if(context.event.name == "linkClick"){
				        		if(qaMrSignOpenChain) {
					        		qaMrSignOpenChain.execute({});
					    		}
				        	}
	                	}
	            }
	        }
		 }
	 }
});
