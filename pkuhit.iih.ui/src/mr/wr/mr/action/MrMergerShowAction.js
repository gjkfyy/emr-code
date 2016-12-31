Ext.define('iih.mr.wr.mr.action.MrMergerShowAction', {
    extend: 'Xap.ej.action.PopAction',

    requires: ['Xap.ej.element.grid.Grid'],
    
    execute: function(context) {
//        var rb = this.getBlock('result');
//        var grid = rb.down('xapgrid[name=mrDocGrid]'); 
//        var selected=grid.getSelectionModel().getSelection();
//        if (selected.length > 0) {
//            var pk=selected[0].data.mrPk;
//            var name=selected[0].data.name;
//            var workpageview = this.getOwner().ownerCt.items.items[1];
//            //框架已经给关闭了，不需要此处再关闭
//            /*//打开第二份病历之前先关闭第一份病历
//            if(workpageview){
//            	var mrSn = workpageview.blocks.workContent.items.items[0].mrSn;
//            	if(mrSn!=pk){
//            		workpageview.ownerCt.remove(workpageview);
//                }
//            }*/
            var canvas = Xap.getCanvas();
            var config = {
                    pageCode: 'mrdoceditview',
                    xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                    pageTitle: '所有病程记录',
                    viewConfig:{
                        //mrCd:condition
                    	mrTpCcatCd:'MRM14.03',
                        opType:'readonly'
                    },
                    assistantConfig:{
                        tgtObCd: 'MRB02',
                        tgtObPk: ''
                    }
            };       
            canvas.fireEvent("addWorkPage",config);
//        }else {
//             XapMessageBox.info("请选择一条记录！");
//        };
    }
});
