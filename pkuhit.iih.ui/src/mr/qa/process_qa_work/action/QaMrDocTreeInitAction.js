Ext.define('iih.mr.qa.process_qa_work.action.QaMrDocTreeInitAction', {
	extend: 'Xap.ej.action.ServiceInvocation',

	doExecute: function(context) {  
        var operations = context.operations;    
        var encounterSn = context.encounterSn;
        this.workScreen = context.workScreen;
        this.prepareOperations(operations,encounterSn);    
    }, 
    prepareOperations: function(operations,encounterSn) {
    	//就診序號變量
    	var encounterCode = IMER_GLOBAL.encounterSn;
        console.log(encounterCode);
        var url = this.url+'?encounterPk='+encounterSn;//+'?keyword='+'test'+'&'
        var mclass = null;        
        var METHODS = this.getInvocationMethods();
        var operation = {
            url: url,
            mclass: mclass,
            method: METHODS.METHOD_GET,
            condition: null,
            scope: this,
            success: this.onSuccess
        };
        operations.push(operation);
    },
        
    onSuccess: function(operation) {
        var block = this.getBlock('result');
        var m = operation.result.data.children; 
        
        //护理相关病历类型组
        var nurseMrTpCCat = iih.mr.qa.QaStatusGlobal.nurseMrTpCCat;
        var qaUserRoles = iih.mr.qa.QaStatusGlobal.qaUserRoles;

        if(m !=null && m !=undefined ){//环节工作=1、科室工作=8
        	if( (this.workScreen !='1' && this.workScreen !='8')){
        		block.setData(m);
        	}else{
        		var orData = m;//源数组
            	var desData = []; //目标数组
            	var isNurseRole = iih.mr.qa.QaStatusGlobal.isNurseRole;	//如果为护士角色，则过滤文书问护理相关文书
            
        		for(var j=0; j<orData.length; j++){
        			var hasNurseMrTpCCat = false;
        			for(var k=0;k<nurseMrTpCCat.length;k++){
        			
        				if(orData[j]!= undefined && orData[j].ccatCode == nurseMrTpCCat[k]){
        					hasNurseMrTpCCat = true;
        					break;
                		}
                	}
        			if(isNurseRole && hasNurseMrTpCCat){
        				desData.push(orData[j]);
            			delete orData[j];
        			}else if(!isNurseRole && !hasNurseMrTpCCat){
        				desData.push(orData[j]);
            			delete orData[j];
        			}
        		}
            	
            	block.setData(desData);
        	}
        	
        }
    }    

});
