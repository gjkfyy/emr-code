/** 
 * 查询：质控评分画面---完成质控评分
 * @author ：wang_yanli
 */
Ext.define('iih.mr.qa.score.action.QaScoreCompleteAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	
	doExecute: function(context) {
        this.prepareOperations(context);
	},
	prepareOperations: function(context) {
		
		//var scoreItemBlock = this.getBlock('bottom');
		
		var owner = this.getOwner();
	    var scoreWorkProperites = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
	    var workScreen = scoreWorkProperites.data.workScreen;
	    var enPk  = scoreWorkProperites.data.enPk; //获取患者就诊序号
        //科室终末并行
	    var qaDeptTerminalParalle;
	    
	    if(CONFIG_PARAM.QA_DEPT_TERMINAL_PARALLE){
        	qaDeptTerminalParalle =  'true';
        }else{
        	qaDeptTerminalParalle =  'false';
        }
   	 
		var operations = context.operations;
	        
        var url = this.url;
        if(workScreen == '11'){
        	url = 'qacustom/deptCompleteScore';
        }
        
        var METHODS = this.getInvocationMethods();
        
    	var operation = {
            url: url+'/'+enPk + "?qaDeptTerminalParalle=" + qaDeptTerminalParalle,
    		mclass: null,
    		method: METHODS.METHOD_CREATE,
            condition: null,
    		scope: this,
    		success: this.onSuccess
    	};
    	
    	operations.length = 0;
    	operations.push(operation);
    },

    onSuccess: function(operation) {
    	
    	var scoreItemBlock = this.getBlock('bottom');
    	
    	var addButton = scoreItemBlock.down('xapgrid xapbutton[action=qaScoreItemAdd]');
    	
    	addButton.setDisabled(true);
    	
    	/*var deleteButton = scoreItemBlock.down('xapgrid xapbutton[action=qaScoreItemDelete]');
    	
    	deleteButton.setDisabled(true);*/
    	
    	var completeButton = scoreItemBlock.down('xapgrid xapbutton[action=qaScoreComplete]');
    	
    	completeButton.setDisabled(true);
    	
    	var ownerProperty = this.getOwner().ownerProperty;
    	
    	ownerProperty.completed = true;
    	var initChain = this.owner.getActionChain('init');
 		initChain.execute();
 		XapMessageBox.info("完成质控评分！");
    }
});
