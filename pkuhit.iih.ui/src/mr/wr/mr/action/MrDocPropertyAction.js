Ext.define('iih.mr.wr.mr.action.MrDocPropertyAction', {
    extend: 'Xap.ej.action.PopAction',

    requires: ['iih.mr.wr.mr.view.MrDocPropertyEditView'],
    
    execute: function(context) {
        var rb = this.getOwner().getBlock('right');
//        var context={mrSn:null};
        if(undefined!=rb){//从病历文书列表进来
        	context.mrDocListView=this.getOwner();
            var grid = rb.down('xapgrid[name=mrDocGrid]'); 
            var selected=grid.getSelectionModel().getSelection();
            if (selected.length > 0) {
                context.mrSn=selected[0].data.mrPk;
            }else {
                XapMessageBox.info("请选择一条记录！");
            };
        }else{//从编辑器菜单进来
            var mrDocEditView=this.getOwner();
//          console.log('rrrrrrrr');
//          console.log(mrDocEditView);
            context.mrSn=mrDocEditView.mrSn;
            context.mrDocEditView=mrDocEditView,
            context.from='editor';
            }
            if(null!=context.mrSn){
                var config = {
                    modal: true,           
                    width: 600,
                    height:430,
                    title :'病历属性',
                    contentConfig: {
                        xtype:'mrdocpropertyeditview',
                        initChain: {
                            name: 'init',
                            context: context
                        }
                    }
                };
                this.callParent([config]);
            }
    	}
});
