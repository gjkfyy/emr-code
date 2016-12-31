Ext.define('iih.po.assistant.action.ObservationRightAction', {
	extend: 'Xap.ej.action.Action',
	
	requires: ['Xap.ej.block.Layer'],
	
	/*
	* @Override
	*/
	execute: function(context) {
		console.log('----------------ObservationRightAction-------------------');
		this.callParent();
        var west = this.getBlock('west');
    	var grid = west.down('xapgrid[name=observationLeftList]');
    	var records = grid.getSelectionModel().getSelection();
    	var obImpr,/*obVal,obFndg,obDi,adv,*/center,obImprArea/*,obValArea,obFndgArea,obDiArea,advArea*/;
    	if(records.length>0){
    		obImpr = records[0].get('obImpr');
        	/*obVal = records[0].get('obVal');
        	obFndg = records[0].get('obFndg');
        	obDi = records[0].get('obDi');
        	adv = records[0].get('adv');*/
        	center = this.getBlock('center');
        	//console.log(center);
        	obImprArea = center.down('xaptextarea[name=obImpr]');
        	obImprArea.setValue(obImpr);
        	/*obValArea = center.down('xaptextarea[name=obVal]');
        	obValArea.setValue(obVal);
        	obFndgArea = center.down('xaptextarea[name=obFndg]');
        	obFndgArea.setValue(obFndg);
        	obDiArea = center.down('xaptextarea[name=obDi]');
        	obDiArea.setValue(obDi);
        	advArea = center.down('xaptextarea[name=adv]');
        	advArea.setValue(adv);*/
    	}else{
    		center = this.getBlock('center');
        	obImprArea = center.down('xaptextarea[name=obImpr]');
        	obImprArea.setValue(null);
    	}
    }
});
