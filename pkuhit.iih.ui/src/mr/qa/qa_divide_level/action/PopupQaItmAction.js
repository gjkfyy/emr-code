/** 
 * 弹出质控项目新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.PopupQaItmAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.qa_divide_level.view.QaItmSetView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var workBlock = owner.up();
    	var groupType = workBlock.groupType;
//		var typeFlag = owner.typeFlag;
		var eventNm = context.eventNm;
		if(eventNm == undefined){
			eventNm = context.event.name;
		}
		var contentBlock = this.getBlock('right');
	    var grid = contentBlock.down('xapgrid');
	    var blockTitle;
	    var fstCd;
	    var sndCd;
	    var qaItmCd;
		if(eventNm == 'addClick'){
			fstCd = owner.fstCd;
			sndCd = owner.sndCd;
			blockTitle = '新增质控项目';
		}else if(eventNm == 'editClick'){
			blockTitle = context.blockTitle;
			qaItmCd = context.qaItmCd;
		}
		
		var config = {
				title:blockTitle,
	    		width: 590,
	    		height:260,
	    		contentConfig: {
	    			xtype: 'qaitmsetview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'initQaItmFst',
	    				context: {
	    					qaItmCd: qaItmCd,
	    					fstCd:fstCd, //新增时一级/二级分类赋值
	    					sndCd:sndCd,
	    					eventNm: eventNm,
	    					groupType:groupType
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})