Ext.define('iih.mr.tm.mr.action.GridChangeAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	
    doExecute: function(context) {
    	alert("GridChangeAction");
    }, 
    
    onSuccess: function(operation) {
        var block = this.getBlock('grid');
        var m = operation.result;
		if(m){
			// TODO 数据格式就这样了？
			if(m instanceof Ext.data.Model) {
				block.setData({
					mclass: operation.mclass,
					data: m.getData(true)
				});
			}
			else {
				block.setData(m);
			}
		}
    }    
    
});
