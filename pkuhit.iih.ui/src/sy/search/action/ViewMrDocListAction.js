Ext.define('iih.sy.search.action.ViewMrDocListAction', {
    extend: 'Xap.ej.action.PopAction',

    requires: ['Xap.ej.element.grid.Grid'],
    
    execute: function(context) {
//    	alert(33);
        var rb = this.getOwner().getBlock('result');
        var grid = rb.down('xapgrid'); 
        var selected=grid.getSelectionModel().getSelection();
        
		var me = this;
		var owner = this.getOwner();   
		var mr = owner.getBlock('result');
	    var itmGrid = mr.down('xapgrid');
	    var selModel = itmGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    var patientData = record.data;
	    var en_pk = patientData.inpatientNo;
	    var patientName = patientData.patientName;
	    if(en_pk == null){
	    	return;
	    }
	    
	    var pageTitle = patientName + '[病历文书列表]';
	    var	pageCode = "mrDocListView";
	    var viewConfig = {
    		en_pk:en_pk,
    		patientName:patientName,
	    	sourceView:owner
	    }
        if(event) {
            var config = {
            	pageCode: pageCode,
            	pageTitle: pageTitle,
                viewConfig:  viewConfig
            };
            var canvas = Xap.getCanvas();
            canvas.fireEvent("addWorkPage",config);
        };
    }
});
