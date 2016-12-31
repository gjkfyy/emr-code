/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.PopupQaDivideLevelAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.qa_divide_level.view.QaDivideLevelSetView'],
	
	execute: function(context){
		var owner = this.getOwner();
		var eventNm = context.eventNm;
		if(eventNm == undefined){
			eventNm = context.event.name;
		}
		var contentBlock = this.getBlock('content');
	    var grid = contentBlock.down('xapgrid');
	    var blockTitle;
	    var qaDivideLevelCd;
		if(eventNm == 'addClick'){
			blockTitle = '新增病案等级设置';
		}else{
			blockTitle = context.blockTitle;
			qaDivideLevelCd = context.qaDivideLevelCd;
		}
		
	   
		
		var config = {
				title:blockTitle,
	    		width: 350,
	    		height:230,
	    		contentConfig: {
	    			xtype: 'qadividelevelsetview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'init',
	    				context: {
	    					qaDivideLevelCd: qaDivideLevelCd,
	    					eventNm: eventNm
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})