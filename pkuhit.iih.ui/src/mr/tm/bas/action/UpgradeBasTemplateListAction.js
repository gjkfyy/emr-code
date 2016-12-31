Ext.define('iih.mr.tm.bas.action.UpgradeBasTemplateListAction', {
	extend: 'Xap.ej.action.PopAction',
	
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
                msg:'请选基础模板进行升级~~~'
            });
        }else if(rb.length > 1){
            Ext.MessageBox.show({
                title:'提示',
                msg:'只能选择一条基础模板进行升级！！！'
            });
        }else{
            //模板id
        	var code =rb[0].data.code;
        	var filePk =rb[0].data.filePk;
        	var name =rb[0].data.name;
        	var paperType =rb[0].data.paperType;
        	var view =this.getOwner();	
        	var block = this.getBlock('result');
            var config = {         
                    modal: true,            
                    height: 200,
                    width:300,
                    title :'属性编辑',
                    contentConfig: {
                        xtype: 'bastemplatepropertyeditview',  
                        initChain: {
                            name: 'init',
                            context: {
                                customerData: 'upgrade',
                                filePk:filePk,
                                code :code,
                                name:name,
                                paperType:paperType,
                                sourceView: view,
                                block:block
                            }
                        }
                    }
            };
          this.callParent([config]); 
        }	       
    }
});
