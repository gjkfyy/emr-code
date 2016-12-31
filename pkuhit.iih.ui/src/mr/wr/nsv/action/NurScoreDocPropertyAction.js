Ext.define('iih.mr.wr.nsv.action.NurScoreDocPropertyAction', {
    extend: 'Xap.ej.action.PopAction',

    requires: ['iih.mr.wr.nsv.view.NurScoreDocPropertyEditView'],
    
    execute: function(context) {
        var left = this.getOwner().getBlock('left');
//        var context={mrSn:null};
        if(undefined!=left){//从病历文书树进来
//        	context.mrDocListView=this.getOwner();
            var mrTree = left.down('xaptree'); 
            var selected=mrTree.getSelectionModel().getSelection();
            var mr=selected[0].raw;
            context.mrSn=mr.mrPk;
//            XapMessageBox.info("请选择一条记录！");
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
                    width: 580,
                    height:300,
                    title :'属性',
                    contentConfig: {
                        xtype:'nurscoredocpropertyeditview',
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
