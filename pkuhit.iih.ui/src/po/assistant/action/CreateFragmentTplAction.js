Ext.define('iih.po.assistant.action.CreateFragmentTplAction', {
	extend: 'Xap.ej.action.ServiceInvocation',	
	
	doExecute: function(context) {
	/*	var block = this.getBlock('center');
		//console.log(block);
		block.getForm().reset();
		var owner = this.getOwner();		
		
	
		var create = owner.down('[name=create]');
		var edit = owner.down('[name=edit]');
		var ddelete = owner.down('[name=delete]');		
		var save = owner.down('[name=save]');
		
		var ownerCd = owner.down('[name=ownerCd]');
		var fragmentTplTypeCd = owner.down('[name=fragmentTplTypeCd]');
		//var editBtn = owner.down('[method=editBtn]');
		var fragmentTplNm = owner.down('[name=fragmentTplNm]');
		
		var fromStatus = owner.down('[name=fromStatus]');
		var fragmentTplContent = owner.down('[name=fragmentTplContent]');
		create.setDisabled(true);
		edit.setDisabled(true);
		ddelete.setDisabled(true);
		save.setDisabled(false);
		
		ownerCd.setReadOnly(false);
		console.log(fragmentTplTypeCd);
		fragmentTplTypeCd.setDisabled(true);
		//编辑按钮可用
		//editBtn.setDisabled(false);
		fragmentTplNm.setReadOnly(false);
		fromStatus.setValue('fromCreate');
		fragmentTplContent.setReadOnly(false);*/
	},
    prepareOperations : function(operations) {
    	
    },
	onSuccess : function(operation) {
		
	}
});
