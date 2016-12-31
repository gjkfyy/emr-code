Ext.define('iih.mr.kr.csm.action.CSMConfirmAction', {
	extend: 'Xap.ej.action.Action',
	//requires:['iih.di.de.model.DiagnosisEntryModel'],
	execute: function(context){
	
	    var me = this;
        var owner=me.getOwner();
        var topblock =  me.getBlock('topblock');
        var diGrid = topblock.down('xapgrid[action=digrid]');
        var mrGrid = topblock.down('xapgrid[action=mrgrid]');
        
        var diSelModel=diGrid.getSelectionModel(); 
        var mrSelModel=mrGrid.getSelectionModel();
        
        var diSelection = diSelModel.getSelection();
        var mrSelection = mrSelModel.getSelection();
        
        var diagnosisModels = [];
        
        var ywtime = owner.down('datetimefield[action=ywDate]');
        
        var ywValue = ywtime.rawValue;
        
        
        if(ywValue.trim()==''){
        	XapMessageBox.info('请填写业务时间!');
         	return;
        }
        
        if(diSelection.length==0){
        	XapMessageBox.info('请选择诊断记录!');
        	return;
        }else{
        	//diagnosisModels
        	for(var i=0;i<diSelection.length;i++){
        		//返回的诊断结果应该包含ownerType,ownerCd.
        		var node = {
	          		      'diNm':diSelection[i].data.diName,
	    	       	      'diEmpNm':IMER_GLOBAL.user.name,
	    	       	      'diEmpCd':IMER_GLOBAL.user.code,
	    	       	      'diTime':'',
	    	       	      'diCd':diSelection[i].data.diCode,
	    				  'diSn':'',
	    				  'icdCd':diSelection[i].data.icdCode,
	    				  'setOwnerTypeCd':diSelection[i].data.ownerType,
	              	      'setOwnerCd':diSelection[i].data.ownerCode,
	    	        	   leaf:true	 
	             };
        		
        		diagnosisModels.push(node);
        	}
        	
        	var outDiagnosisView = Ext.getCmp('outdiagnosisview');
        	outDiagnosisView.csaInsertDiagnosis(diagnosisModels);
        }
        
        if(mrSelection.length==0){
        	XapMessageBox.info('请选择病例模板记录!');
        	return;
        }
    }
	
});
