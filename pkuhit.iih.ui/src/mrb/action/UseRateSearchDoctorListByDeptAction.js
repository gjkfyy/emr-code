Ext.define('iih.mrb.action.UseRateSearchDoctorListByDeptAction', {
    extend: 'Xap.ej.action.ServiceInvocation',
    /*
     * @Override
     */
     execute: function(context) {
         var newValue = context.newValue;
         console.log('context') ;
         console.log(context) ;
         var block = this.getOwner().getBlock('condition');
         console.log('block') ;
         console.log(block) ;
         var deptCodeList=block.down('[name=deptCodeList]');
         var currDeptCode = deptCodeList.lastValue;
         console.log('deptCodeList');
         console.log(deptCodeList);
         console.log('currDeptCode');
         console.log(currDeptCode);
         var condition= {} ;
         if(currDeptCode != 'ALL' && currDeptCode != ''){
         	condition={"deptCode":currDeptCode};
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