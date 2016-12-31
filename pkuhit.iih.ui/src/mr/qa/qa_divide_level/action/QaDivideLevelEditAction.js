/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaDivideLevelEditAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	
	execute: function(context){
		var owner = this.getOwner();
		var workBlock = owner.up();
    	var groupType = workBlock.groupType;
		var eventNm = context.eventNm;
	    var record = context.record;
	    var blockTitle;
	    if(groupType == '2'){
	    	blockTitle = '一级分类编辑';
			if(record == undefined){
        		XapMessageBox.info("请选择要编辑的一级分类");
			}else{
				var fstCd = record.data.fstCd;
				var fstNm = record.data.nm;
				//弹出一级分类画面
				var chain = owner.getActionChain('popupQaItmFst');
				if(chain) {
			    	chain.execute({
			    		eventNm:eventNm,
			    		fstCd: fstCd,
			    		fstNm:fstNm, //方便编辑一级分类时校验
			    		blockTitle:blockTitle
			    	});
				}
			}
	    }else if(groupType == '1'){
	    	blockTitle = '病案等级设置编辑';
			if(record == undefined){
        		XapMessageBox.info("请选择要编辑的病案等级");
			}else{
				var qaDivideLevelCd = record.data.qaDivideLevelCd;
				//弹出病案等级画面
				var chain = owner.getActionChain('popupQaDivideLevel');
				if(chain) {
			    	chain.execute({
			    		eventNm:eventNm,
			    		qaDivideLevelCd: qaDivideLevelCd,
			    		blockTitle:blockTitle
			    	});
				}
			}
	    }
	}
})