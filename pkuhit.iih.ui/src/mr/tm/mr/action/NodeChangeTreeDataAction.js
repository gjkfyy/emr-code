Ext.define('iih.mr.tm.mr.action.NodeChangeTreeDataAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	
    doExecute: function(context) {
        var operations = context.operations;    
        //alert(encodeURI(encodeURI('BCM001.01'))); 
        var SmrTypeCd =context.event.arguments[1].raw.mrTypeCd;
        var SownerCd =context.event.arguments[1].raw.ownerCd;
        var SownerType =context.event.arguments[1].raw.ownerType;
        var mrTplStatCd =null;      
        var data ={mrTypeCd:SmrTypeCd,ownerCd:SownerCd,ownerType:SownerType};
        this.prepareOperations(operations,SmrTypeCd,SownerCd,SownerType,mrTplStatCd);
    }, 
    prepareOperations: function(operations,mrTypeCd,ownerCd,ownerType,mrTplStatCd) {        
        var condition ='?mrTemplate='+'click'+ '&mrTypeCd='+mrTypeCd+'&ownerCd='+ownerCd+'&ownerTypeCd='+ownerType+'&mrTplStatCd='+mrTplStatCd;   
        var url = this.url + condition;    
        //console.log(url);
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,
            data:condition,
            scope: this,
            success: this.onSuccess,
            //fail: this.onFail
        };
        operations.push(operation);     
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
