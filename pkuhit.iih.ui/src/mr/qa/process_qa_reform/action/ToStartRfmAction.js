/** 
 * 环节整改通知（开始整改）
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.ToStartRfmAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var contentBlock = this.getBlock('content');
	    var rfmGrid = contentBlock.down('xapgrid');
	    var selModel = rfmGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    if(record == undefined){
			 XapMessageBox.info("请选择整改通知书");
		}else{
			var operations = context.operations;
			var revisionCd = record.data.revisionCd;
			contentBlock.revisionCd = revisionCd;
			contentBlock.record = record;
		    var revisionStatus = record.data.status;
			if(revisionStatus == iih.mr.qa.QaStatusGlobal.revisionNoticeToReform){
				var url = this.url;
		        url+= '/' + revisionCd;
		        console.log(url);
		    	var operation = {
		            url: url,
		    		mclass: null,
		    		method: 'put',
		    		condition: null,
		    		scope: this,
		    		success: this.onSuccess
		    	};
		    	operations.length = 0;
		    	operations.push(operation);
			}else{
			//弹出缺陷整改画面
				var chain = this.getOwner().getActionChain('popProcessRfmDefect');
				if(chain) {
			    	chain.execute({
			    		revisionCd: revisionCd,
			    		revisionStatus:revisionStatus,
			    		record:record
			    	});
				}
			}
	    }
    },
    onSuccess: function(operation) {
    	var contentBlock = this.getBlock('content');
    	var revisionCd = contentBlock.revisionCd;
    	var revisionStatus = iih.mr.qa.QaStatusGlobal.revisionNoticeReforming;//整改中
    	var record = contentBlock.record;
    	//弹出缺陷整改画面
    	var chain = this.getOwner().getActionChain('popProcessRfmDefect');
    	if(chain) {
        	chain.execute({
        		revisionCd: revisionCd,
        		revisionStatus:revisionStatus,
        		record:record
        	});
    	}
    }
});