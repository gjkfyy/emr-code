Ext.define('iih.mr.tm.bas.action.PropertyBasTemplateListAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.bas.view.BasTemplatePropertyEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var gridPage = this.getOwner();
    	var grid = this.getBlock('result');//.down('bastemplatelistblock'); 
	    var rb = grid.getSelectionModel().getSelection();         
        if(rb.length == 0){
            Ext.MessageBox.show({
                title:'提示',
                msg:'请选模板进行属性编辑~~~'
            });
        }else if(rb.length >  1){
    	   Ext.MessageBox.show({
               title:'提示',
               msg:'请选一条模板编辑属性~~~'
           });
       }else{
            //模板id
        	var code =rb[0].data.code;
            //var name =rb[0].data.name;
            var config = {         
                    modal: true,            
                    height: 200,
                    width:300,
                    title :'属性编辑',
                    contentConfig: {
                        xtype: 'bastemplatepropertyeditview',  
                        initChain: {
                            name: 'init',//bastemplatepropertyeditview
                            context: {
                                customerData: 'edit',
                                code :code,
                                sourceView: this.getOwner()
                            }
                        }
                    }
            };
          this.callParent([config]); 
        }	       
    }
});
