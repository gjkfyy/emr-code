Ext.define('iih.mr.wr.omr.action.MenuCreateAction', {
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
            //树节点
            var mr = args[1].raw;
            var deleteBtn=view.down('toolbar button[method=delete]');
            var property=view.down('toolbar button[method=property]');
            var create=view.down('toolbar button[method=create]');
//            console.log(mr);
            var deleteDisabled=true;
            var propertyDisabled=true;
            var canCreate=create.disabled;
            if(1==mr.canDelete){
            	deleteDisabled=false;
            	deleteBtn.setDisabled(false);
            }else{
            	deleteBtn.setDisabled(true);
            }
            if(mr.mrPk){
            	propertyDisabled=false;
            	property.setDisabled(false);
            }else{
            	property.setDisabled(true);
            }
            var nodemenu = new Ext.menu.Menu({  
                floating : true,  
                items : [{  
                    text : "新建",
                    icon: 'css/images/icons/Create.png',
                    disabled: canCreate,
                    handler : function() {  
                    	var create =  view.getActionChain('create');
                    	create.execute();
                    } 
                },{  
                    text : "删除",
                    icon: 'css/images/icons/delete.png',
                    disabled: deleteDisabled,
                    handler : function() {  
                    	var deleteConfirm =  view.getActionChain('deleteConfirm');
                    	deleteConfirm.execute();
                    } 
                },{  
                    text : "属性",
                    icon: 'css/images/icons/property.png',
                    disabled: propertyDisabled,
                    handler : function() {  
                    	var emrDocProperty =  view.getActionChain('emrDocProperty');
                    	emrDocProperty.execute();
                    } 
                }]
            });
            nodemenu.showAt(e.getXY());
        }
    }
});