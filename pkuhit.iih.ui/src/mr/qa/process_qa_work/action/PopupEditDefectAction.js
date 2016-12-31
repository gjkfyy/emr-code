/** 
 * 弹出病案等级新增、编辑画面Action
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.process_qa_work.action.PopupEditDefectAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.process_qa_work.view.DefectEditView'],
	
	execute: function(context){
		var owner = this.getOwner();
		/*var contentBlock = this.getBlock('bottomcontent');
	    var grid = contentBlock.down('xapgrid');
	    var data = grid.getSelectionModel().getSelection()[0].data;*/
		var data = context.data;
		var config = {
				title:'缺陷编辑',
	    		width: 450,
	    		height:250,
	    		contentConfig: {
	    			xtype: 'defecteditview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'init',
	    				context: {
	    					data:data
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})