Ext.define('Xap.ej.action.ServiceInvocation', {
	extend: 'Xap.ej.action.Action',

    statics: {
        METHOD_CREATE: 'POST',

        METHOD_DELETE: 'DELETE',

        METHOD_UPDATE: 'PUT',

        METHOD_GET: 'GET'
    },

	/*
	* @Override
	*/
    execute:function(context){
    	this.callParent();

        if(!context.operations) {
            context.operations = [];
        };
        if(!this.doExecute(context))
			return;
        var operations = context.operations;
        for(var i = 0; i < operations.length; i++) {
            var o = operations[i];
            if(!o.success) {
                // TODO 不要临时定义function
                o.success = function(o) {
                    this.onSuccess(o.result);
                }
            }
            if(!o.fail) {
                o.fail = function(o) {
                    this.onFailure();
                }
            }
            if(!o.scope) {
                o.scope = this;
            }
        };
    },

    getInvocationMethods: function() {
        return Xap.ej.action.ServiceInvocation;
    },

    // 返回false表明不再继续
    doExecute: Ext.emptyFn,

    /* 
    * 成功的回调
    * @param data 后端服务返回的结果
    */
    onSuccess: Ext.emptyFn,
	/* 
    * 失败的总回调
    */
	doFailureCallback: Ext.emptyFn,
    // 失败的回调
    onFailure: Ext.emptyFn,

	showLoading: function() {
		var owner = this.getOwner();
		//if(!this.isGridreeComponents(owner))return;
		if (owner) {
			if (!owner.loadingMask) {
				owner.loadingMask = Ext.create('Xap.ej.element.window.LoadMask', owner);
			}
			owner.loadingMask.show();
		}
	},
	
	hideLoading: function() {
		var owner = this.getOwner();
		//if(!this.isGridreeComponents(owner))return;
		if (owner && owner.loadingMask) {
			owner.loadingMask.hide();
			owner.updateLayout();
		}
	},

	isGridreeComponents: function(component) {
		if(component){
			var gridtreeComponents = component.query('xapgrid, xaptree');
			if(gridtreeComponents.length > 0)return true;
		}
		return false;
	},
	
	showSubmitProgressBar: function() {
		var owner = this.getOwner();
		if (owner) {
			if (!owner.progressBar) {
				owner.progressBar = Ext.create('Xap.ej.element.MessageBox.MessageBox', owner);
			}
			var title = FuiLocale.get('messagebox', 'submit');
			var textSaving = FuiLocale.get('messagebox', 'saving');
			owner.progressBar.wait('', title, {
				interval: 500,
				increment: 10,
				text: textSaving
			},owner);
		}
	},

	closeSubmitProgressBar: function() {
		var owner = this.getOwner();
		if (owner && owner.progressBar) {
			owner.progressBar.progressBar.reset();
			owner.progressBar.close();
			owner.updateLayout();
		}
	}
});
