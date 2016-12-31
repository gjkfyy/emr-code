/** 
 * 查询：质控评分画面---扣分项目列表
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.doctor_self_score.action.ScoreItemListSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
		this.prepareOperations(context);
	 },
	 prepareOperations: function(context) {
		var operations = context.operations;
        var url = this.url;
        
        // 获取选中患者的就诊序号
        var enPk;
    	enPk = IMER_GLOBAL.encounterSn;
    	var operation = {
            url: url+'?enPk='+enPk+'&qaTypeCode=QAM13.04',
    		mclass: null,
    		method: 'get',
    		condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.length = 0;
    	operations.push(operation);
    },

   onSuccess: function(operation) {
	    var owner = this.getOwner(); 
	    var block = this.getBlock('bottom');
        var m = operation.result;
        block.setData(m);
       
        var chain = owner.getActionChain('qaScoreSearch');
        
        if(chain) {
            chain.execute();
        }
    }
});
