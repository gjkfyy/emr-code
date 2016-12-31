Ext.define('iih.mr.kr.csa.action.mrDbClickAction', {
	extend: 'Xap.ej.action.Action',
	
	execute: function(context) {
		var omrdocpropertyblock=Ext.getCmp('omrdocpropertyblock');
		var mrNm=omrdocpropertyblock.down('xaptextfield[name=mrNm]');
		var logicSmtDate=omrdocpropertyblock.down('datetimefield[name=logicSmtDate]');
		var csaDiAndMrTemplateBlock=this.getBlock('rightblock')
	    var mrGrid = csaDiAndMrTemplateBlock.down('xapgrid[action=mrgrid]');
	    var mrSelModel=mrGrid.getSelectionModel();
	    var mrSelection = mrSelModel.getSelection();
	    var mrTemplateName=mrSelection[0].data.mrTemplateName;
	    mrNm.setValue(mrTemplateName);
	    logicSmtDate.setValue(new Date());
	    var confirmChain = omrdocpropertyblock.ownerCt.ownerCt.ownerCt.getActionChain('confim');
	    confirmChain.execute();
    }
});