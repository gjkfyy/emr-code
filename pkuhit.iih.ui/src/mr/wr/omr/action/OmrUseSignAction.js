Ext.define('iih.mr.wr.omr.action.OmrUseSignAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		var operations = context.operations;
		if (!operations) {
			return;
		}
		this.prepareOperations(operations);
	},

	prepareOperations : function(operations) {
		var condition = this.getOwner().medicalRecord;
		condition.opType = this.getOwner().opType;
		var url = this.url + '/' + IMER_GLOBAL.user.code;
		var operation = {
			url : url,
			method : 'get',
			condition : condition,
			scope : this,
			success : this.onSuccess,
			fail : this.onFail
		};
		operations.push(operation);
	},
	onSuccess : function(operation) {
		var plugin = document.getElementById('iemrEditor');
		var user = operation.result.data;
		if (user.usePicSign == '1') {
			// 启用图片签名
			if (user.signPicture == null) {
				XapMessageBox.warn('当前签名用户没有签名图片,请联系管理员！', function(btn, text) {
					return false;
				});
			}else{
				plugin.ImportMacroValue('MR.M.013.D.26', '{IMG}'+user.signPicture);// 进行图片签名
			}
		} else {
			plugin.ImportMacroValue('MR.M.013.D.26', IMER_GLOBAL.user.name);// 进行签名
		}
	}
});
