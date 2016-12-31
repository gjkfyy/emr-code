Ext.define('iih.mr.tm.mr.action.OpenTemplateAction', {
	extend: 'Xap.ej.action.PopAction',
	
	/*
	* @Override
	*/
	execute: function(context,data) {
       this.callParent();  
       var emrPrintSelected=this.getOwner().emrPrintSelected;
       var block = this.getBlock('result');
       var layout = block.getLayout();
       var grid = block.down('mrtemplatelistblock');  
       var rb = grid.getSelectionModel().getSelection();
       var sourceView = this.getOwner();
       var enTypeCode = sourceView.enTypeCode;
       var dctNsF = sourceView.dctNsF;
//       console.log('------------------ OpenTemplateAction ---------------------------');
//       console.log(rb);
       if(rb.length == 0){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else if(rb.length >  1){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else{
    	   var code = rb[0].data.code;           
    	   var pk = rb[0].data.filePk;
    	   var xmlFilePk = rb[0].data.xmlFilePk;
    	   var name = rb[0].data.name;
    	   var baseTemplateCode = rb[0].data.baseTemplateCode;
    	   var readonly = true;
    	   var release = false;
    	   var canUpdate = rb[0].raw.canUpdate;
    	   var canActivated = rb[0].raw.canActivated;
    	   var canSubmit = rb[0].raw.canSubmit;
    	   //设置编辑器状态
    	   if(canUpdate =='1'){
    		   readonly = false;
    	   }
    	   if(canActivated =='1' || '1' == canSubmit){
    		   release = true;
    	   }
    	   var mrTypeCode = rb[0].data.mrTypeCode;
    	   var view = this.getOwner().ownerCt;
    	   var workpageview = view.items.items[1];
           if(workpageview){
	           	var mrSn = workpageview.filePk;
	           	if(mrSn!=pk){
	           		view.remove(workpageview);
	           	}
           }
    	   var canvas = Xap.getCanvas();
           var config = {
                   pageCode: 'mrtpleditview',
                   xclass: 'iih.mr.tm.mr.view.MrTemplateEditView',
                   pageTitle: name,
                   viewConfig:{
                       //mrCd:condition
                	   filePk:pk,
                	   xmlFilePk:xmlFilePk,
                       opType:'open',
                       code:code,
                       enTypeCode:enTypeCode,
                       dctNsF:dctNsF,
                       mrTypeCode:mrTypeCode,
                       readonly:readonly,
                       baseTemplateCode:baseTemplateCode,
                       emrPrintSelected:emrPrintSelected,
                       release:release
                   }
           };       
           canvas.fireEvent("addWorkPage",config);
    	}     
    }
});
