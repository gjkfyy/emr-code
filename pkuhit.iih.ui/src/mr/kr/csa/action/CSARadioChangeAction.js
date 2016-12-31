Ext.define('iih.mr.kr.csa.action.CSARadioChangeAction', {
	extend: 'Xap.ej.action.Action',
	//requires:['iih.di.de.model.DiagnosisEntryModel'],
	execute: function(context){
	
	    var me = this;
	    var owner=me.getOwner();
	    var block = me.getBlock('leftblock');
	    
        var radio = context.event.arguments[0];
        var radioDept = block.down('xapradio[action=ownerTypeDept]');
        var radioPer = block.down('xapradio[action=ownerTypePerson]');
        
        
        var csaSearchchain = me.getOwner().getActionChain("csasearchAction");
 	    csaSearchchain.execute();
    }
	
});
