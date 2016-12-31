/** 
 * 质控设置页面初始化
 * @extends Xap.ej.action.Action
 * @author ：yao_lijie
 */

Ext.define('iih.mr.qa.qa_divide_level.action.QaItmWorkInitAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:[],
	      
	execute: function(context){

	    var block = this.getBlock('content');
	    var tabpanel = block.down('xaptabpanel');
        var xappanel = tabpanel.getActiveTab();
        var groupType = xappanel.groupType;
	    if(groupType == '1'){
	    	var view = xappanel.down('qadividelevelview');
	    	var chain = view.getActionChain("init");
			chain.execute(context);
	    }else if(groupType == '2'){
	    	var view = xappanel.down('qaitmfstview');
	    	var chain = view.getActionChain("init");
			chain.execute(context);
	    }else if(groupType == '3'){
	    	var view = xappanel.down('qaitmsndview');
	    	var chain = view.getActionChain("initTree");
			chain.execute(context);
	    }else if(groupType == '4'){
	    	var view = xappanel.down('qaitmview');
	    	var chain = view.getActionChain("initTree");
			chain.execute(context);
	    }
	    
	}
	
})