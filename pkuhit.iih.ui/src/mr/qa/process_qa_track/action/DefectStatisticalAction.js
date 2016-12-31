/** 
 * 完成本次审核前判断整改通知书下的缺陷状态
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.DefectStatisticalAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var me = this;
			
	    var owner = this.getOwner();   
	    
	    var revisionCd = owner.revisionCd;
	    
		var operations = context.operations;
		
    	//获取储存于画面间的参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    
	    var typeFlag = properties.data.typeFlag;
	    
		var workScreen;
		
		if(typeFlag==1){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackProcess;
		}else if(typeFlag==2){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackTerminal;
		}else if(typeFlag==3){
			workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackDept;
		}
		
        var url = this.url;
        url += '?' + 'revisionCd=' + revisionCd + '&workScreen='+ workScreen;
        console.log(url);
    	var operation = {
            url: url,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
		var me = this;
		
	    var owner = this.getOwner();   
	    
	    var revisionCd = owner.revisionCd;
	    
    	//获取储存于画面间的参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		var revisionRecord = properties.data.revisionRecord;
        
        var m = operation.result;
        if(m=="1"){
        	XapMessageBox.info("存在未审核的缺陷，请先审核。");
        }else if(m=="2"){
        	XapMessageBox.confirm2("存在需要再次整改的缺陷，再次发送整改通知？", function(button) {
	            if (button == "yes") {
		        	//刷新
		        	var chain = owner.getActionChain('popupNotification');
		        	if(chain) {
		            	chain.execute();
		        	}
	            }else{
	            	return;
	            }
	        });
        }else if(m=="3"){
        	//刷新
        	var chain = this.getBlock('result').ownerCt.getActionChain('finishCheck');
        	if(chain) {
            	chain.execute({
    	        	rownum:0,
            		revisionCd: revisionCd
            	});
        	}
        }
    }
});
