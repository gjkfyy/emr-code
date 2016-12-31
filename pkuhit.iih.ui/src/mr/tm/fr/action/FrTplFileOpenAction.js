Ext.define('iih.mr.tm.fr.action.FrTplFileOpenAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context,data) {
       this.callParent();    	   
       var grid = this.getBlock('result');
       var rb = grid.getSelectionModel().getSelection();     
       if(rb.length == 0){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else if(rb.length >  1){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else{
    	   var mrFrTplCd =rb[0].data.mrFrTplCd;           
    	   var pk = rb[0].data.filePk;
    	   var nm = rb[0].data.nm;
    	   var view = this.getOwner().ownerCt;
    	   var readonly = true;
    	   var release = false;
    	   var canUpdate = rb[0].raw.canUpdate;
    	   if(rb[0].raw.canUpdate=='1'){
    		   readonly = false;
    	   }
    	   if(rb[0].raw.canActivated=='1' || '1' == rb[0].raw.canSubmit){
    		   release = true;
    	   }
    	   var workpageview = view.items.items[1];
           if(workpageview){
	           	var mrSn = workpageview.filePk;
	           	if(mrSn!=pk){
	           		view.remove(workpageview);
	           	}
           }
    	   var canvas = Xap.getCanvas();
           var config = {
                   pageCode: 'frtpleditview',
                   xclass: 'iih.mr.tm.fr.view.FrTplEditView',
                   pageTitle: nm,
                   viewConfig:{
                	   mrFrTplCd:mrFrTplCd,
                	   filePk:pk,
                       opType:'open',
                       readonly:readonly,
                       release:release
                   }
           };       
           canvas.fireEvent("addWorkPage",config);
    	}     
    }
});
