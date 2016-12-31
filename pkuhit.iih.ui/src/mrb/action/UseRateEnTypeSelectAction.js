Ext.define('iih.mrb.action.UseRateEnTypeSelectAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context) {
        console.log('context') ;
        console.log(context) ;
	    /*  var block = this.getOwner().getBlock('condition');
	        console.log('block') ;
	        console.log(block) ;
	        console.log(block.down('[name=useRateTypeCode]')) ;
	        var useRateTypeCode=block.down('[name=useRateTypeCode]').getValue();
	        console.log('useRateTypeCode') ;
	        console.log(useRateTypeCode) ;
	        var  useRateTypeCodeOriginalValue = block.down('[name=useRateTypeCode]').originalValue;
	        
	        console.log('useRateTypeCodeOriginalValue') ;
	        console.log(useRateTypeCodeOriginalValue) ;
	        if(useRateTypeCode == 'hosiptalType'){
	        	 //禁用就诊类型、部门、医生下拉框
	        	 console.log('禁用就诊类型、部门、医生下拉框') ;
	        	// block.down('[name=enTypeCode]').readOnly  = true ;
	        	 block.down('[name=deptCodeList]').readOnly  = true ;
	        	 block.down('[name=doctorCodeList]').readOnly  = true ;
	        	 block.down('[name=enTypeCode]').emptyText = '无需选择' ;
	        	 block.down('[name=deptCodeList]').emptyText= '无需选择';
	        	 block.down('[name=doctorCodeList]').emptyText= '无需选择';
	        	 return ;
	        }else{
	        	if(useRateTypeCodeOriginalValue == 'hosiptalType' ){
			       	 //block.down('[name=enTypeCode]').readOnly  = false ;
			    	 block.down('[name=deptCodeList]').readOnly  = false ;
			    	 block.down('[name=doctorCodeList]').readOnly  = false ;
		        	 block.down('[name=enTypeCode]').value = 'ALL' ;
		        	 block.down('[name=deptCodeList]').value = 'ALL' ;
		        	 block.down('[name=doctorCodeList]').value = 'ALL' ;
	        	}else{
	        		return ;
	        	}
	        }*/
	}

});
