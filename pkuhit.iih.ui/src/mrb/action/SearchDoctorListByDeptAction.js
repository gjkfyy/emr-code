Ext.define('iih.mrb.action.SearchDoctorListByDeptAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    /*
     * @Override
     */
     execute: function(context) {
         var newValue = context.newValue;
         console.log('newValue') ;
         console.log(newValue) ;
         var condition= {} ;
         if(newValue != 'ALL' && newValue != ''){
         	condition={"deptCode":newValue};
         }else{
        	 return ;
         }
         console.log('condition') ;
         console.log(condition) ;
         var url = this.url;
         var operation = {
                 url: url,
                 method: 'get',
                 params: condition,
                 scope: this,
                 success: this.onSuccess
                 // fail: this.onFail
             };
         operations =context.operations ;
         operations.push(operation);
     },
/*     prepareOperations: function(operations) {


     },*/
     onSuccess: function(operation) {
    	 console.log('SearchDoctorListByDeptAction onSuccess');
         var block = this.getOwner().getBlock('condition');
         var doctorCodeList=block.down('[name=doctorCodeList]');
         doctorCodeList.clearValue( );
         doctorCodeList.select(null);
         if(operation.result){
        	 if(operation.result.dataList){
	         	console.log('operation.result.dataList');
	         	console.log(operation.result.dataList);
	         	doctorCodeList.setData(operation.result.dataList);
	         	doctorCodeList.setValue('ALL');
           /*  var properties = this.getOwner().ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
             var selectdata = properties.data.doctorCodeSelect;
             if(selectdata){
            	 doctorCodeList.select(selectdata);
                 properties.data.mrTpCd = null;
             }else{
            	 doctorCodeList.select('ALL');
             };*/
             //var result = this.getOwner();
             //var initChain = result.getActionChain('init');
             //initChain.execute();
             //if(mrCustClaCd!='ALL')mrTypeCd.expand();
	         }else{
	        	// doctorCodeList.setData({});
	         }
         }
     }
 });