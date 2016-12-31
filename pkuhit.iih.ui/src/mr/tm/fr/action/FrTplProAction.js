Ext.define('iih.mr.tm.fr.action.FrTplProAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires: ['iih.mr.tm.fr.view.FrTplProEditView'],
	/*
	* @Override
	*/
	execute: function(context) {
	    var gridPage = this.getOwner();
    	var grid = this.getBlock('result');
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
        	var mrFrTplCd =rb[0].data.mrFrTplCd;
            //var name =rb[0].data.name;
            var config = {         
                    modal: true,            
                    height: 200,
                    width:300,
                    title :'属性编辑',
                    contentConfig: {
                        xtype: 'frtplproeditview',  
                        initChain: {
                            name: 'init',
                            context: {
                                customerData: 'edit',
                                mrFrTplCd :mrFrTplCd,
                                sourceView: this.getOwner()
                            }
                        }
                    }
            };
          this.callParent([config]); 
        }	       
    }
});
