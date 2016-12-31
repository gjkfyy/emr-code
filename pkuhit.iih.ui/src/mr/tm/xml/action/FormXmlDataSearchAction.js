Ext.define('iih.mr.tm.xml.action.FormXmlDataSearchAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.xml.view.FormXmlDataView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var view = this.getOwner();
	    var dataResource = view.down('xaptextfield[name=dataResource]').value;
	    if(dataResource==undefined){
	    	dataResource = '';
	    }
	    var config = {
                modal: true,            
                height: 350,
                width:  550,
                title :'数据元',
                contentConfig: {
                    xtype: 'formxmldataview',  
                    initChain: {
                        name: 'init',
                        context: {
                        	sourceView:view,
                        	keyword:dataResource
                        }
                    }
                }
        };
	    this.callParent([config]);      
    }
});
