Ext.define('iih.mr.di.action.InDiagnosisSonDiAction', {
	extend: 'Xap.ej.action.Action',

	requires: [],

    execute: function(context) {
    	var owner = this.getOwner();
		var block = this.getBlock('content');
		var diInGrid = block.down('xapgrid');
		var selModel = diInGrid.getSelectionModel();
		var record = selModel.getSelection()[0];
	    if(record != undefined){
	    	var data = record.data
	    }
	    var form =block.down('xapform');
	    form.setTitle('子诊断新增');
	    var formData = {
         		addDescr: undefined,
         			diCd: undefined,
         			diEmpNm: undefined,
         			diNm: undefined,
         			diSn: undefined,
         			diTime: undefined,
         			diTypeCd: undefined,
         			diTypeNm: undefined,
         			icdCd: undefined,
         			mainF: "0",
         			memo: undefined,
         			parDiSn: undefined
         	}; 
         var diCd = block.down('comboxgrid[name=diCd]');
 	    diCd.setRecordData({value:'',text:''}); 
 	    var showInfo = block.down('xapdisplayfield[name=showInfo]');
 	    showInfo.setValue('');
        form.getForm().setValues(formData);
	    parDiSn = block.down('xaptextfield[name=parDiSn]');
	    parDiSn.setValue(data.diSn);
    }
});
