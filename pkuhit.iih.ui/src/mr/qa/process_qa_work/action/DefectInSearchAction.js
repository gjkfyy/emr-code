/** 
 * 查询缺陷的Action
 * @extends Xap.ej.action.ServiceInvocation
 * @author ：wu_guocheng
 */

Ext.define('iih.mr.qa.process_qa_work.action.DefectInSearchAction', {
	extend: 'Xap.ej.action.ServiceInvocation',
	requires:['iih.mr.qa.QaStatusGlobal'],
	/*
	* @Override
	*/
	execute: function(context) {      
    
    	var owner = this.getOwner();
    	
    	var properties =owner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	
    	//就诊序号
    	var encounterPk = properties.data.patientRecord.pk;//encounterPk;
    	
    	//缺陷状态
    	var statusCode = properties.data.statusCode;
    	if(statusCode == 'ALL'){	//	如果选择“全部”，赋空值
			statusCode='';		
    	}
    	
    	//获取查询参数
    	//var data = properties.getData();
    	
    	var dataJson = {
    			encounterPk:encounterPk,  //就诊PK
            	qaTypeCode:properties.data.qaTypeCode,    //质控类型编码
            	statusCode:statusCode,    				 //缺陷状态编码
            	dropFlag:properties.data.dropFlag,        //不扣分缺陷
            	workScreen:properties.data.workScreen    //工作场景
    	}
    	
    	//获取缺陷一览的 block
		var block = this.getBlock('bottomcontent');
		
		var defectinGrid = block.down('xapgrid');
    	
    	var operations = context.operations;
    	if(!operations) {
    		return;
    	}
    	this.prepareOperations(operations,dataJson);
    	
    },
    prepareOperations: function(operations,data){
    
    	var qs = Ext.Object.toQueryString(data);
 
       // var url = this.url+'?encounterPk='+data.encounterPk+'&qaTypeCode='+data.qaTypeCode+'&statusCode='+data.statusCode+'&dropFlag='+data.dropFlag+'&workScreen='+data.workScreen+'&isDept='+data.isDept;
        var url = this.url+'?'+ qs;
    	var mclass = null;
        var METHODS = this.getInvocationMethods();
    	var operation = {
            url: url,
            mclass: null,
            method: METHODS.METHOD_GET,
            condition: null,	
            data:data,
    		scope: this,
    		success: this.onSuccess
    	};
    	operations.push(operation);
    },
    onSuccess: function(operation) {
        
    	//获取缺陷一览的 block
		var block = this.getBlock('bottomcontent');
		var defectinGrid = block.down('xapgrid');
	    var m = operation.result;
	    
        var owner = this.getOwner();
    	
    	var properties =owner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
    	properties.data.currentQaPk = m.data.currentQaPk  //当前未完成的质控主键
	    
    	if(m.data.qaFaultList.dataList){
	    	defectinGrid.setData(m.data.qaFaultList.dataList);
	    }else{
	    	defectinGrid.setData([]); //dataList为空时，置空
	    }
    	
        var datas  = defectinGrid.getStore().getModifiedRecords( );
        /***********************syh 增加了质控完毕按钮*/
		if(properties.data.workScreen=="1"){//环节质控隐藏
			defectinGrid.down('xapbutton[action=finish]').setVisible(false);
		}else{
			if(m.data.btnFlag&&m.data.btnFlag!="1")//无完成按钮权限
				defectinGrid.down('xapbutton[action=finish]').setDisabled(false);
		}
		
		/*defectinGrid.down('xapbutton[action=editDefect]').setDisabled(true);
		defectinGrid.down('xapbutton[action=defectDelete]').setDisabled(true);*/
		//设置完成本次质控按钮可编辑
		defectinGrid.down('xapbutton[action=defectsfinish]').setDisabled(false);
		
/*		if(b){
			
			defectinGrid.down('xapbutton[action=defectssave]').setDisabled(false);
		}*/
		
		defectinGrid.refresh();
		
		//默认选中第一条
		/*if(properties.data.record== undefined ){
			
			var selectModel = defectinGrid.getSelectionModel();
	    	selectModel.select(0);
	    	
		}else{
			
			//获取定位缺陷一览的CHAIN
			var positionChain = owner.getActionChain('positionAction');
			positionChain.execute({record:properties.data.record});
		}*/
    }
});