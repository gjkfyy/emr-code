/** 
 * 查询：质控评分画面---查询质控评分
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.doctor_self_score.action.QaScoreSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context.operations,context);
	 },
	 prepareOperations: function(operations,context) {
	        
	        var url = this.url;
	        var owner = this.getOwner();
	        var enPk = IMER_GLOBAL.encounterSn;
	    	var operation = {
	            url: url+'?enPk='+ enPk + '&qaTypeCode=',
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
    	
        var scoreFormBlock = this.getBlock('result');
        
        var m = operation.result;
        m.data.score = '<div style=\'color:red;font-weight:800;font-size:24px;\'>'+ m.data.score+'分</div>';
        m.data.lvl = '<div style=\'color:red;font-weight:800;font-size:24px;\'>'+ m.data.lvl +'级</div>';
        scoreFormBlock.setData(m.data);
        
    }
});
