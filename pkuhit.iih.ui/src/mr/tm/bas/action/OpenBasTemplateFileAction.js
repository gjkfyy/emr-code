Ext.define('iih.mr.tm.bas.action.OpenBasTemplateFileAction', {
	extend: 'Xap.ej.action.Action',
	
	/*
	* @Override
	*/
	execute: function(context,data) {
       this.callParent();    	   
       var grid = this.getBlock('result');
//       var layout = block.getLayout();
//       var grid = block.down('bastemplatelistblock');  
       var rb = grid.getSelectionModel().getSelection();     
       if(rb.length == 0){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else if(rb.length >  1){
    	   var message = '请选模板进行打开~~~';
           XapMessageBox.info(message);
       }else{
    	   /*var gridBlock =block.down('bastemplateeditview')
    	   var code =rb[0].data.code;           
    	   var filePk = rb[0].data.filePk;
    	   var properties = gridBlock.getLayer(Xap.ej.block.Layer.PROPERTIES);
           properties.setData({
	           	opType: 'open',  
	           	filePk:filePk,
	            code:code
           });
           //先remove掉编译器打开的odt
           //gridBlock  insert
           var owner = this.getOwner();
           var chain = owner.getActionChain('beforeActivate');
           chain.execute();
           layout.setActiveItem(1);*/
    	   var codePk =rb[0].data.code;           
    	   var pk = rb[0].data.filePk;
    	   var name = rb[0].data.name;
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
                   pageCode: 'mrbastpleditview',
                   xclass: 'iih.mr.tm.bas.view.BasTemplateEditView',
                   pageTitle: name,
                   viewConfig:{
                	   code:codePk,
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
