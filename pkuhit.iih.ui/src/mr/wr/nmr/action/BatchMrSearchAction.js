Ext.define('iih.mr.wr.nmr.action.BatchMrSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
    /*
	    * @Override
	    */
    execute: function(context) {
    	var view =this.getOwner();
    	var batchCategoryCode=view.getBlock('condition').down('[name=batchCategoryCode]').getValue();
    	if(batchCategoryCode=="ALL"){
    		batchCategoryCode='';
    			}
        var enPk = IMER_GLOBAL.encounterSn;
        var pageNum,pageSize ;
		if(context.event && context.event.name == "turnpage"){
    		pageNum = context.event.arguments[0];
    		pageSize = context.event.arguments[1];
		}else {
			pageNum = context.pageNum; 
			pageSize = context.pageSize; 
		}
		pageSize=10000;//需要分页时，删除该行，显示分页工具栏
		view.pageSize=pageSize;
        this.prepareOperations(context.operations,enPk,batchCategoryCode,pageNum,pageSize);
    },
    prepareOperations: function(operations,enPk,tpCcatCd,pageNum,pageSize) {
         var url = this.url+'?enPk='+enPk+'&tpCcatCd='+tpCcatCd+'&pageNum='+pageNum+'&pageSize='+pageSize+'&DctNsF=0';
         var operation = {
             url: url,
             method: 'get',
             scope: this,
             success: this.onSuccess
         };
         operations.push(operation);
     },
     onSuccess: function(operation) {
    	 var data;
    	 var pageSize=this.getOwner().pageSize;
         var block = this.getOwner().getBlock('content');
         // TODO 数据格式就这样了？
         if(operation.result.data){
        	 data=operation.result.data;
        	 data.pageSize=pageSize;
     	 	 block.setData(data);
         }else{
        	 block.setData(null);
         }
//         var grid= block.down('[name=mrDocGrid]');
//         var mydata=grid.getStore().data.items;
//         for (var i = 0; i < mydata.length; i++) {
//				//if(mydata[i].data.arcF!=1){
//					grid.getSelectionModel().select(i,true,true);
//				//}
//			}
        
     }
});
