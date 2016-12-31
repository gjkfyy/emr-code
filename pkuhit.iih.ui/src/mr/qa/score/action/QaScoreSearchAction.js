/** 
 * 查询：质控评分画面---查询质控评分
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.score.action.QaScoreSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
	        this.prepareOperations(context.operations,context);
	 },
	 prepareOperations: function(operations,context) {
	        
	        var url = this.url;
	        var owner = this.getOwner();
	        var scoreWorkProperites = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	        
	        var enPk  = scoreWorkProperites.data.enPk; //获取患者就诊序号
	        var qaTypeCode = scoreWorkProperites.data.qaTypeCode;
	    	var operation = {
	            url: url+'?enPk=' + enPk + '&qaTypeCode=' + qaTypeCode,
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
