Ext.define('iih.po.com.action.CreateMenuAction', {
    extend: 'Xap.ej.action.Action',
    
    requires: [],
    
    /*
    * @Override
    */
    execute: function(context) {
        var event = context.event;
        var view = this.getOwner();
        if(event) {
            var args = event.arguments;
            var e = args[4];
            e.preventDefault();  
            e.stopEvent();  
            var record = args[1];
            var data = record.raw.data;
            if(!data)
                data = record.raw;
            //console.log(data);
            //病历文书父节点
            if(data.code == 'XAPM07.05' || data.nodeType == IMER_CONSTANT.MENU_MR_CATEGORY)
            {
                var nodemenu = new Ext.menu.Menu({  
                    floating : true,  
                    items : [{  
                        text : "新建",
                        handler : function() {  
                            var custCategoryCode = data.custCategoryCode;
                            var chain = view.getActionChain('createMr');
                            chain.execute({
                                custCategoryCode:custCategoryCode
                            });
                        } 
                    }]
                });
                nodemenu.showAt(e.getXY());
            }
            //病历文书
            else if(data.nodeType == IMER_CONSTANT.MENU_MR_DOC)
            {
                var nodemenu = new Ext.menu.Menu({  
                    floating : true,  
                    items : [{  
                        text : "打开",
                        handler : function() {  
                            var mrPk = data.code;
                            var chain = view.getActionChain('openMr');
                            chain.execute({
                                mrPk:mrPk
                            });
                        }
                    },{  
                        text : "属性",
                        handler : function() {  
                            var mrPk = data.code;
                            var chain = view.getActionChain('mrProperty');
                            chain.execute({
                                mrPk:mrPk
                            });
                        } 
                    }]
                });
                nodemenu.showAt(e.getXY());
            }
        };
    }
});