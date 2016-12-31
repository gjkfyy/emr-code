/** 
 * 弹出该患者病历文书列表
 * @extends Xap.ej.action.PopAction
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.dept_qa_auto_search.action.PopupMrDocListAction', {
	extend: 'Xap.ej.action.PopAction',
	
	requires:['iih.mr.qa.dept_qa_auto_search.view.QaMrDocListView'],
	
	execute: function(context){
		var owner = this.getOwner();

		var result = this.getBlock('result');
	    var grid = result.down('xapgrid');
	    var selModel = grid.getSelectionModel();
	    var record = selModel.getSelection()[0];
	    var encounterSn = record.data.encounterSn;

		var config = {
	    		width: 1000,
	    		height:500,
	    		contentConfig: {
	    			xtype: 'qamrdoclistview',
	    			sourceView:owner,  //传入上级视图
	    			initChain: {
	    				name: 'init',
	    				context: {
	    					encounterSn: encounterSn
	    				}
	    			}
	    		}
	    	};
		
		this.callParent([config]);
		
	}
})