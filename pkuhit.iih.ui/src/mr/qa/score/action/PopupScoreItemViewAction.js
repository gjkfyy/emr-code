/** 
 * 弹出扣分项画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.score.action.PopupScoreItemViewAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.score.view.ScoreItemInputView'],
	
	execute: function(context){  
		
		var owner=this.getOwner();	
		
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		//就诊序号
		var enPk = properties.data.enPk;
		
		var firstCode = "";
		
		var config = {
				title:"病案评分标准项目",
	    		width: 650,
	    		height:500,
	    		contentConfig: {
	    			xtype: 'scoreiteminputview',
	    			socuseOwner:owner,  //传入上级视图
	    			initChain: {
	    				name: 'initQaItmFst',
	    				context: {
	    					encounterPk: enPk,
	    					mrTypeCode: "",
	    					mrTypeName: "",
	    					firstCode:""
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})