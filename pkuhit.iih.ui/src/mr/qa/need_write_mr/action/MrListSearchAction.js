/** 
 * 查询：质控评分画面---扣分项目列表
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.need_write_mr.action.MrListSearchAction', {
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
            url: url+'?enPk='+enPk,
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
	    var block = this.getBlock('content');
        var m = operation.result;
        block.setData(m);
       
    }
});
