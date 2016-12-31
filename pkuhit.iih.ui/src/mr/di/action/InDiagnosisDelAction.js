Ext.define('iih.mr.di.action.InDiagnosisDelAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	requires: [],

    doExecute: function(context) {
    	var block = this.getBlock('content');
		var diInGrid = block.down('xapgrid');
		var selModel = diInGrid.getSelectionModel();
		var record = selModel.getSelection()[0];
	    if(record != undefined){
	    	var data = record.data;
	    }
        var operations = context.operations;
        if(!operations) {
     		return;
	    }
	     	this.prepareOperations(operations,data);
    },

    prepareOperations: function(operations,data) {
//    	var enSn = IMER_GLOBAL.encounterSn; //就诊序号
    	var diSn = data.diSn;
        var url = this.url+ '/' + diSn;;
        var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
                url: url ,
        		mclass: null,
        		method: METHODS.METHOD_DELETE,
        		condition: null,
        		scope: this,
        		success: this.onSuccess
        	};
    	operations.length = 0;
    	operations.push(operation);
},
   
    onSuccess: function(operation){
    	var view = this.getOwner();
    	var chain = view.getActionChain('init');
    	chain.execute({
    		flag:'1'
    	});
    	var canvas = Xap.getCanvas();
    	var patient = {
    		'pk':IMER_GLOBAL.encounterSn
    	};
    	canvas.fireEvent("updatePatient",{
    		'patient':patient
    	});
    }
});
