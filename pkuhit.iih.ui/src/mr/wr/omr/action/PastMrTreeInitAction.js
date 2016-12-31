Ext.define('iih.mr.wr.omr.action.PastMrTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	requires: ['Xap.ej.block.Layer'],
	
	execute: function(context) {
	    this.showLoading();
        var operations = context.operations;  
        var encounterCombobox=this.getBlock('left').down('xapcombobox');
        var enPk=encounterCombobox.getValue();
        if(enPk==undefined){
        	enPk = IMER_GLOBAL.encounterSn;
        }
        var url = this.url+"?encounterPk="+enPk+'&showAllCourse=1';  
        var mclass = null;        
        var operation = {
            url: url,
            mclass: mclass,
            method: 'get',
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);  
    }, 

    onSuccess: function(operation) {
        var block = this.getBlock('left');
//        var right=this.getOwner().getBlock('right');
//        var owner=this.getOwner();
//        var mr=right.medicalRecord;
        var m = operation;
        if(m.result.data.children){
        	block.setData(m.result.data.children);
        }else{
        	block.setData([]);
        }
    }  
});