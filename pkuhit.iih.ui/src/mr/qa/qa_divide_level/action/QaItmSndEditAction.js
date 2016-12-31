/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaItmSndEditAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	
	execute: function(context){
		var owner = this.getOwner();
		var workBlock = owner.up();
    	var groupType = workBlock.groupType;
		var eventNm = context.eventNm;
		var record = context.record;
		/*var contentBlock = this.getBlock('right');
	    var grid = contentBlock.down('xapgrid');
		var selModel = grid.getSelectionModel();
	    var record = selModel.getSelection()[0];*/
	    var blockTitle;
	    if(groupType == '3'){
	    	blockTitle = '二级分类编辑';
			if(record == undefined){
        		XapMessageBox.info("请选择要编辑的二级分类");
			}else{
				var sndCd = record.data.sndCd;
				var sndNm = record.data.nm;
				//弹出二级分类画面
				var chain = owner.getActionChain('popupQaItmSnd');
				if(chain) {
			    	chain.execute({
			    		eventNm:eventNm,
			    		sndCd : sndCd,
			    		sndNm:sndNm, //方便编辑二级分类时校验名字
			    		blockTitle:blockTitle
			    	});
				}
			}
	    }else if(groupType == '4'){
	    	blockTitle = '质控项目编辑';
			if(record == undefined){
        		XapMessageBox.info("请选择要编辑的质控项目");
			}else{
				var qaItmCd = record.data.qaItmCd;
				//弹出质控项目编辑画面
				var chain = owner.getActionChain('popupQaItm');
				if(chain) {
			    	chain.execute({
			    		eventNm:eventNm,
			    		qaItmCd: qaItmCd,
			    		blockTitle:blockTitle
			    	});
				}
			}
	    }
	}
})