Ext.define('iih.mr.di.action.InDiagnosisEditFormAction', {
	extend: 'Xap.ej.action.Action',

	requires: [],

    execute: function(context) {
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var diInGrid = block.down('xapgrid');
		var selModel = diInGrid.getSelectionModel();
		var record = selModel.getSelection()[0];
		var data;
	    if(record != undefined){
	    	data = record.data
	    }
	    var form =block.down('xapform');
	    form.setTitle('诊断编辑');
	    var diCd = block.down('comboxgrid[name=diCd]');
	    diCd.setRecordData({value:data.diCd,text:data.diNm});
	    form.getForm().setValues(data);
	    var value = form.getForm().getValues();
	   /* var diSn = block.down('xaptextfield[name=diSn]');
	    var parDiSn = block.down('xaptextfield[name=parDiSn]');
	    var diTypeCd = block.down('xapcombobox[name=diTypeCd]');
	    var diTime = block.down('datetimefield[name=diTime]');
	    var icdCd = block.down('xaptextfield[name=icdCd]');
	    var memo = block.down('xaptextfield[name=memo]');
	    var addDescr = block.down('xaptextfield[name=addDescr]');
	    var mainF = block.down('xapradiogroup[name=mainFgroup]');
	    //block.setData(data);
	    var diCd = block.down('comboxgrid[name=diCd]');
	    diCd.setRecordData({value:data.diCd,text:data.diNm}); //设置适应病种
	    diSn.setValue(data.diSn);
	    parDiSn.setValue(data.parDiSn);
	    diTypeCd.setValue(data.diTypeCd);
	    diTime.setValue(data.diTime);
	    icdCd.setValue(data.icdCd);
	    memo.setValue(data.memo);
	    addDescr.setValue(data.addDescr);
	    var mainG = mainF.items.items;
	    for(var i=0;i<mainG.length;i++){
	    	if(data.mainF ==mainG[i].inputValue){
	    		mainG[i].setValue(true);
		    }
	    }*/
    }
});
