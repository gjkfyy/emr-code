Ext.define('iih.mr.qa.process_qa_work.action.QaItmSearchAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var block = this.getBlock('content');
	    var data = block.data;
        var qaItmFstValue=block.down('[name=qaItmFst]').getValue();
        var qaItmSndValue=block.down('[name=qaItmSnd]').getValue();
        if(qaItmSndValue == 'ALL'){
            	qaItmSndValue = "";
            }
        var view = this.getOwner();
        var initChain = view.getActionChain('init');
        initChain.execute({
        	qaItmFst: qaItmFstValue,
        	qaItmSnd : qaItmSndValue,
        	encounterPk:data.encounterPk,
    		mrTypeCode:data.mrTypeCode,
    		mrSegmemtTypeCode:data.mrSegmemtTypeCode
        });
    }
});
