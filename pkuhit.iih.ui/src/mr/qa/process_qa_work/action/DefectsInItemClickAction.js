
/** 
 * 缺陷一览页面删除按钮
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.process_qa_work.action.DefectsInItemClickAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:['iih.mr.qa.QaStatusGlobal'],
    
	execute: function(context){  
		
		var owner = this.getOwner();
		
		var defectsInBlock = this.getBlock('bottomcontent');
		
		var mrBlock = this.getBlock('topcontent');
		
		//获取缺陷一览的GRID
		var defectsInGrid = defectsInBlock.down('xapgrid');
		/*//设置删除按钮可用
		defectsInGrid.down('xapbutton[action=defectDelete]').setDisabled(false);
		
		//设置编辑按钮可用
		defectsInGrid.down('xapbutton[action=editDefect]').setDisabled(false);*/

	/*	var selModel = defectsInGrid.getSelectionModel();
	    var record = selModel.getSelection()[0];*/
		var record = context.event.arguments[1];
	    var mrPk = record.data.mrPk;
	    var properties = owner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);//qaworkview
        if(mrPk!=undefined && mrPk !="" ){
        	if(properties.data.medicalRecord && properties.data.medicalRecord.mrPk == mrPk){
        		return;
        	}
        	var config = {
	                xclass: 'iih.mr.wr.mr.view.MrDocEditView',
	                viewConfig:{
	                    mrSn:mrPk,
	                    opType:'readonly'
	                	}
	        }; 
        	
        	
            var workView =  Ext.create(config.xclass,config.viewConfig);
            mrBlock.removeAll();
            mrBlock.add(workView);
            
            //
        	
        	properties.data.medicalRecord = {'mrPk':mrPk};
        }
    
			
	}
	
})