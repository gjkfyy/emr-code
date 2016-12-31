/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.PopupQaItmFstAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.qa_divide_level.view.QaItmFstSetView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var eventNm = context.eventNm;
		if(eventNm == undefined){
			eventNm = context.event.name;
		}
		var contentBlock = this.getBlock('content');
	    var grid = contentBlock.down('xapgrid');
	    var blockTitle;
	    var fstCd;
	    var fstNm;
		if(eventNm == 'addClick'){
			blockTitle = '新增一级分类';
		}else if(eventNm == 'editClick'){
			blockTitle = context.blockTitle;
			fstCd = context.fstCd;
			fstNm = context.fstNm;
		}
		
		var config = {
				title:blockTitle,
	    		width: 350,
	    		height:230,
	    		contentConfig: {
	    			xtype: 'qaitmfstsetview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'init',
	    				context: {
	    					fstCd: fstCd,
	    					fstNm:fstNm,
	    					eventNm: eventNm
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})