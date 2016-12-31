/** 
 * 打开病历文书
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.QaMrSignOpenAction', {
    extend: 'Xap.ej.action.ServiceInvocation',

    doExecute: function(context) {
    	
    	var me = this;
    	
		var resultBlock = this.getBlock('result');
	        
	    var enGrid = resultBlock.down('xapgrid');
	     
	    var selModel = enGrid.getSelectionModel();
	        
	    var record = selModel.getSelection()[0];
	     
	    var mrPk = record.data.mrPk;
	    
        var page = this.getOwner();
        
        var operations = context.operations;
        
        if(undefined!=mrPk && mrPk != ""){
        	var config = {
                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
                viewConfig:{
                    mrSn:mrPk,
                    opType:'readonly'
                },
                assistantConfig:{
                	 tgtObCd: 'MRB02',
                     tgtObPk: mrPk
                }
            };   
        	var workContent = page.getBlock('top');
            workContent.removeAll();
            var workView =  Ext.create(config.xclass,config.viewConfig);
            workContent.add(workView);
        }
    }
});
