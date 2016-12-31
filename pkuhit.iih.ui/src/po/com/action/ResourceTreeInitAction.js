Ext.define('iih.po.com.action.ResourceTreeInitAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
	
	/*
	* @Override
	*/
	doExecute: function(context) {
	    this.callParent();
	    this.objcd = context.objcd;
    	var operations = context.operations;
    	var url = this.url;
        var condition = {};
    	var METHODS = this.getInvocationMethods();
    	var method = METHODS.METHOD_GET;
    	if(context.objcd == IMER_CONSTANT.BASE_TPL){//基础模板
    	    url = 'mr/tpl/tree/baseTemplate';
    	}
    	else if(context.objcd == IMER_CONSTANT.MR_TPL){//病历模板
            url = 'mr/tpl/tree/notlazy';
        }
    	else if(context.objcd == IMER_CONSTANT.GROUP_ELEMENT){//组合元素
            url = 'mr/tpl/tree/groupElement';
            condition = Ext.apply(condition,{typeCode:'MRM11.01'});
        }
    	var mclass = null;
    	var form = this.getOwner().getBlock('top');
    	condition = Ext.apply(condition,form.getData());
    	var qs = Ext.Object.toQueryString(condition);
    	url += '?' + qs;
    	var operation = {
    	    url: url,
    	    mclass: mclass,
    	    method: method,
    	    condition: null,
            scope: this,
            success: this.onSuccess
    	};
    	operations.push(operation);
    },
    
    onSuccess: function(operation) {
        var block = this.getBlock('tree');
        var tree;
        var m = operation.result;
		if(m){
		    if(this.objcd == IMER_CONSTANT.BASE_TPL){//基础模板
	            tree = block.down('xaptree[name=basTree]');
	            tree.setData(m.data);
	        }
	        else if(this.objcd == IMER_CONSTANT.MR_TPL){//病历模板
	            tree = block.down('xaptree[name=mrTree]');
                tree.setData(m.root);
	        }
	        else if(this.objcd == IMER_CONSTANT.GROUP_ELEMENT){//组合元素
	            tree = block.down('xaptree[name=grpTree]');
	            tree.setData(m.root);
	        }
		}
    }
});