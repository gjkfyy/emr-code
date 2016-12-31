Ext.define('iih.mr.di.action.InDiagnosisCancelAction', {
	extend: 'Xap.ej.action.Action',

	requires: [],

    execute: function(context) {
    	var block = this.getBlock('content');
    	var form =block.down('xapform');
    	form.setTitle('诊断新增');
//    	block.getForm().reset(); //清空form
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
         var dirty = form.isDirty();
 	    this.getOwner().dirty = dirty;
    }
});
