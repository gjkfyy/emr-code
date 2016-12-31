/** 
 * 病历文书保存调用
 * @author ：yao_lijie
 */
Ext.define('iih.mr.qa.process_qa_reform.action.MrDocSaveAction', {
    extend: 'Xap.ej.action.Action',

    execute: function(context) {
    	var owner = this.getOwner();
	    var topBlock = this.getBlock('content');
	    var workView = topBlock.down();  //获取病历编辑器页面
    	var doSaveChain = workView.getActionChain('doSave');
    		if(doSaveChain) {
    		    var chain = owner.getActionChain('doSave');
    		    if(chain){
    		        workView._removeTab = owner._removeTab;
    		        workView._tabPanel = owner._tabPanel;
    		        doSaveChain.callBack = chain.callBack;
    		    };
        		doSaveChain.execute({});
    		}
    }
});
