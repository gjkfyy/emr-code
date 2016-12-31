Ext.define('iih.mr.dr.plan.action.PlanSearchAction', {
	
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this. showLoading();
	    this.prepareOperations(context);
	},
	prepareOperations: function(context) {
		var me = this;
	    var owner = this.getOwner();   
		var typeFlag = owner.typeFlag;
		var toolbarBlock = owner.getBlock('toolbar');
		/*if(typeFlag==1){
			 var createCheck = toolbarBlock.down('button[action=create]');
			 var conditionSettingCheck = toolbarBlock.down('button[action=conditionSetting]');
			 createCheck.setDisabled(true);
			 conditionSettingCheck.setDisabled(true);
			 createCheck.setHiddenState(true);
			 conditionSettingCheck.setHiddenState(true);
		}*/
	    //储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        properties.setData({
    		typeFlag:typeFlag
        });
		var operations = context.operations;
        var bottomBlock = this.getBlock('result');  
       var event = context.event;
        var url = this.url;
        var conditionView = owner.getBlock('condition');
        var conditionBlock = conditionView.getBlock('content');
    	var condition = conditionBlock.getData();
		if(condition) {
            var qs = Ext.Object.toQueryString(condition);
            url += '?' +qs;
		}
    	var operation = {
            url: url ,
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	var owner = this.getOwner();  
        var block = this.getBlock('result');
        var conditionGrid = block.down('xapgrid');
//        conditionGrid.removeAll();
        var m = operation.result;
        if(m==null){
        	conditionGrid.setData([]);
        }else{
        	conditionGrid.setData(m.dataList);
        }
    }
});
