Ext.define('iih.mr.tm.mr.action.PropertyTemplateListAction', {
	extend: 'Xap.ej.action.PopAction',
	

	requires: ['iih.mr.tm.mr.view.MrTemplatePropertyEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var gridPage = this.getOwner();
	    var grid = this.getBlock('result').down('mrtemplatelistblock'); 
	    console.log(grid);
	    var rb = grid.getSelectionModel().getSelection(); 	            
        if(rb.length == 0){
            var message = '请选模板进行属性编辑~~~';
            XapMessageBox.info(message);
        }else if(rb.length == 1){
            //模板id
            var code =rb[0].data.code;
          //  console.log(rb[0].data);
            var config = {         
                    modal: true,            
                    height: 280,
                    width:  530,
                    title :'模板属性',
                    contentConfig: {
                        xtype: 'mrTemplatePropertyEditView',  
                        initChain: {
                            name: 'init',
                            context: {
                                customerData: 'edit',
                                verMrTplKc :code,
                                sourceView: gridPage
                            }
                        }
                    }
            };
          this.callParent([config]); 
        }else if(rb.length >1){
        	var message = '不能选择多个模板~~~';
            XapMessageBox.info(message);
        }	       
    }
});
