/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.PopupQaItmSndAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.qa_divide_level.view.QaItmSndSetView'],
	
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
	    var sndNm;
		if(eventNm == 'addClick'){
			fstCd = owner.fstCd
			blockTitle = '新增二级分类';
		}else if(eventNm == 'editClick'){
			blockTitle = context.blockTitle;
			sndCd = context.sndCd;
			sndNm = context.sndNm;
		}
		
		var config = {
				title:blockTitle,
	    		width: 350,
	    		height:230,
	    		contentConfig: {
	    			xtype: 'qaitmsndsetview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'initQaItmFst',
	    				context: {
	    					sndCd: sndCd,
	    					sndNm:sndNm,
	    					fstCd:fstCd,//新增时赋默认值
	    					eventNm: eventNm,
	    					groupType:groupType
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})