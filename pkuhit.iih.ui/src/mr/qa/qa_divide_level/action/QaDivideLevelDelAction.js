/** 
 * 删除单条等级的Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelDelAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {
    	var owner = this.getOwner();
    	var workBlock = owner.up();
    	var groupType = workBlock.groupType;
    	var me = this;
		var contentBlock = this.getBlock('content');
		/*var grid = contentBlock.down('xapgrid');
		var selModel = grid.getSelectionModel();
		var record = selModel.getSelection()[0];*/
    	var record = context.record;
		contentBlock.record = record;
    	if(record == undefined){
    		 if(groupType == '1'){
				XapMessageBox.info("请选择要删除的病案等级");
    		}else if(groupType == '2'){
        		XapMessageBox.info("请选择要删除的一级分类");
    		}else if(groupType == '3'){
    			XapMessageBox.info("请选择要删除的二级等级");
    		}else if(groupType == '4'){
    			XapMessageBox.info("请选择要删除的质控项目");
    		}
		}else{
			var operations = context.operations;
            	if(!operations) {
            		return;
        	}
        		me.prepareOperations(operations,record);
		}
    },
    prepareOperations: function(operations,record){
    	var owner = this.getOwner();
    	var workBlock = owner.up();
    	var groupType = workBlock.groupType;
//    	var typeFlag = owner.typeFlag;
    	var url = this.url
    	if(groupType == '1'){
			url += '/'+record.data.qaDivideLevelCd;   //删除病案等级
		}else if(groupType == '2'){
    		url += '/'+record.data.fstCd;		//删除一级分类
		}else if(groupType == '3'){
			url += '/'+record.data.sndCd;   //删除二级分类
		}else if(groupType == '4'){
			url += '/'+record.data.qaItmCd;   //删除质控项目
		}
//        var url = this.url+'/'+record.data.qaDivideLevelCd;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_DELETE,
            condition: null,	
           // data:data.data.pk,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },
    onSuccess: function(operation) {
    	//调用查询Action
    	var owner = this.getOwner();
    	var workBlock = owner.up();
    	var groupType = workBlock.groupType;
//    	var typeFlag = owner.typeFlag;
    	var contentBlock = this.getBlock('content');
    	if(groupType == '3'){
    		var fstCd = contentBlock.record.data.fstCd;
    		var initChain = owner.getActionChain('treeSelect');
    		initChain.execute({
    			fstCd:fstCd
    		});
    	}else if(groupType == '4'){
    		var fstCd = contentBlock.record.data.fstCd;
    		var sndCd = contentBlock.record.data.sndCd;
    		var initChain = owner.getActionChain('treeSelect');
    		initChain.execute({
    			fstCd:fstCd,
    			sndCd:sndCd
    		});
    	}else{
    		var initChain = owner.getActionChain('init');
    		initChain.execute();
    	}
    }
})