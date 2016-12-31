Ext.define('iih.mrb.action.PatientInitAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
		//患者查询初始化信息
		var block = this.getOwner().getBlock('condition');
//        var form = block.down('xapform');
//        form.getForm().reset();
		var block = this.getBlock('content');
		var crtTimeStart = block.down('xapdatefield[name=crtTimeStart]');
	    var crtTimeEnd = block.down('xapdatefield[name=crtTimeEnd]');
	    var curDeptNm = block.down('comboxgrid[name=curDeptNm]');
	    
	    var patientName = block.down('xaptextfield[name=patientName]');
	    var radi= block.down('radiogroup[name=checkArchive]').items.items[0];	   
	    patientName.setValue();
	    var curDate = new Date();
		var curDateTime = curDate.getTime();
		var preDateTime = curDateTime - 24*60*60*1000*7;  
		crtTimeStart.setValue(preDateTime);
		crtTimeEnd.setValue(curDateTime);
/*		curDeptNm.select(IMER_GLOBAL.department.code,true,true) ;
		curDeptNm.comboxHiddenValue = IMER_GLOBAL.department.code;*/
		radi.setValue(true);
		
		var searchMrTypeChain = this.getOwner().getActionChain('searchMrType');
		searchMrTypeChain.execute({});
	}

});
