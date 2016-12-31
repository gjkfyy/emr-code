Ext.define('iih.sy.userinfo.action.UserToLeadAction', {
			extend : 'Xap.ej.action.ServiceInvocation',

			requires : [],

			/*
			 * @Override
			 */
			execute : function(context) {
				this.callParent();
				var rb = this.getBlock('result');
				var grid = rb.down('xapgrid');
				var selected = grid.getSelectionModel().getSelection();
				var select = {selects : []};
				if (selected.length > 0) {
					for (i = 0; i < selected.length; i++) {
						select.selects[i] = selected[i].data;
					}
					var operations = context.operations;
					if (!operations) {
						return;
					}
					this.prepareOperations(operations, select);
				} else {
					var message = '请选择人员！';
					XapMessageBox.info(message);
//					Xap.ej.util.MsgUtil.MsgBoxInfo(message);
				};
			},
			prepareOperations : function(operations, select) {
				var url = this.url;
				var METHODS = this.getInvocationMethods();
				var mclass = null;
				var operation = {
					url : url,
					method : METHODS.METHOD_UPDATE,
					data : select,
					scope : this,
					success : this.onSuccess
				};
				operations.push(operation);
			},
			onSuccess : function(operation) {
				//保存成功后关闭画面
				var owner = this.getOwner();
				var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
				var data = properties.getData();
				data.parentWindow.close();
				var b = data.sourceView;
				console.log(b);
				var initChain = b.getBlock('top').getBlock('left').getActionChain('init');
				initChain.execute({});
			}
		});
