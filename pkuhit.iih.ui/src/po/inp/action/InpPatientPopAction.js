Ext.define('iih.po.inp.action.InpPatientPopAction', {
	extend: 'Xap.ej.action.PopHideAction',

	requires: ['iih.po.inp.view.InpPatientSearchView'],
	
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
    	var config = {
    	    modal: true,           
    		width: 1100,
    		height:560,
    		title :'患者查询',
    		contentConfig: {
    			xtype: 'inppatientsearchview'
    		}
    	};
    	this.callParent([config]);
    }
});
