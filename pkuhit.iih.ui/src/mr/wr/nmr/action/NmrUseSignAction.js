Ext.define('iih.mr.wr.nmr.action.NmrUseSignAction', {
	extend : 'Xap.ej.action.ServiceInvocation',

	/*
	 * @Override
	 */
	execute : function(context) {
		var self=this;
		var operations = context.operations;
		if (!operations) {
			return;
		}
		self.getOwner().docCkNotNull=true;
		var docCkNotNull = self.getOwner().getActionChain('docCkNotNull');
		docCkNotNull.execute();
		
		setTimeout(function() {
			if(!self.getOwner().docCkNotNull)return;//非空验证未通过
			self.macroIdOld='MR.M.013.D.37';
			if(CONFIG_PARAM.YES_NO_NURSIGN){
				self.prepareOperations(operations);
			}else{
				var plugin = document.getElementById('iemrEditor');
				var userName=IMER_GLOBAL.user.name;
				plugin.ImportMacroValue(self.macroIdOld, userName);//进行签名
				var emrSubmit1 = self.getOwner().getActionChain('emrSubmit1');
				emrSubmit1.execute();
			}
		},700);
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
		if (user.signPicture !=null&&user.signPicture.length>0) {
			// 启用图片签名
			if (user.signPicture == null) {
				XapMessageBox.warn('当前签名用户没有签名图片,请联系管理员！', function(btn, text) {
					return false;
				});
			}else{
				//console.info(user.signPicture);
				plugin.ImportMacroValue(this.macroIdOld, '{IMG}'+user.signPicture);// 进行图片签名
			}
		} else {
			plugin.ImportMacroValue(this.macroIdOld, IMER_GLOBAL.user.name);// 进行签名
		}
		var emrSubmit1 = this.getOwner().getActionChain('emrSubmit1');
		emrSubmit1.execute();
	}
});
