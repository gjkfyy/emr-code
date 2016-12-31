Ext.define('iih.po.assistant.view.VitalSignHelperView', {
	extend : 'Xap.ej.template.BaseTemplate',

	requires: [
		'iih.po.assistant.block.VitalSignHelperBlock',
		'iih.po.assistant.action.VitalSignInitAction',
		'iih.po.assistant.action.VitalSignSearchWindowPopupAction',
		'iih.po.assistant.action.VitalSignSearchAction'
	],
	
	alias:'widget.vitalsignhelperview',
	layout:'fit',
	
	xapConfig: {
		blocks: {
			'list': {
				xclass: 'iih.po.assistant.block.VitalSignHelperBlock'
			}
        },
		actions: {
			'refresh': {
				xclass: 'iih.po.assistant.action.VitalSignInitAction',
				url: 'nu/vitalsigns',
				blocks: {
					result: 'list'
				}
			},
			'searchwindowpopup': {
				xclass: 'iih.po.assistant.action.VitalSignSearchWindowPopupAction',
				blocks: {
					result: 'list'
				}
			},
			'search': {
				xclass: 'iih.po.assistant.action.VitalSignSearchAction',
				blocks: {
					result: 'list'
				}
			}
			
		},

		chains: {
			'refresh': ['refresh'],
			'search':['search'],
			'searchwindowpopup':['searchwindowpopup']
		},

		connections: {
			'list': [/*{
				event: 'afterrender',
				chain: 'refresh'
			},{
				selector: 'button[method=Search]',
                event: 'click',
				chain: 'searchwindowpopup'
			}*/]
			
		}
	},
	initComponent : function() {
		var me = this;
        this.callParent();
        this.addEvents("writeMrDoc");//为视图添加事件
	    this.addListener('writeMrDoc', function() {//添加监听事件
	        //写回病历
	        var block = this.getBlock('list');
	       	var grid = block.down('xapgrid');
	        var selModel = grid.getSelectionModel();
	       	var records = selModel.getSelection();
	   		if(records.length>0){
	   			var str="",acDate = [],bodyT = [],pulse = [],breathe = [],sysP = [],diaP = [];
	   			for(var i=0; i<records.length;i++){
	   				acDate[i] = records[i].get("acquisitionDate");
	   				bodyT[i] = records[i].get("temper");
	   				pulse[i]  = records[i].get("pulse");
	   				breathe[i] = records[i].get("breathe");
	   				sysP[i] = records[i].get("systolicPress");
	   				diaP[i] = records[i].get("diastolicPress");
	   			}
	   			for(var i=0; i<acDate.length;i++){
	   				for(var  j = 0 ;j < acDate.length - i - 1; j++){
	   					var temp1,temp2,temp3,temp4,temp5,temp6;
	   					if(acDate[j] > acDate[j+1]){
	   						temp1 = acDate[j];
	   						acDate[j] = acDate[j+1];
	   						acDate[j+1] = temp1;
	   						
	   						temp2 = bodyT[j];
	   						bodyT[j] = bodyT[j+1];
	   						bodyT[j+1] = temp2;
	   						
	   						temp3 = pulse[j];
	   						pulse[j] = pulse[j+1];
	   						pulse[j+1] = temp3;
	   						
	   						temp4 = breathe[j];
	   						breathe[j] = breathe[j+1];
	   						breathe[j+1] = temp4;
	   						
	   						temp5 = sysP[j];
	   						sysP[j] = sysP[j+1];
	   						sysP[j+1] = temp5;
	   						
	   						temp6 = diaP[j];
	   						diaP[j] = diaP[j+1];
	   						diaP[j+1] = temp6;
	   					}
	   				}
	   			}
	   			var bodyTemperature,pulseRul,breatheRul,systolicPressure,diagstolicPressure;
	   			for(var i=0; i<records.length;i++){
	   				var strBuf="";
	   				bodyTemperature = bodyT[i];
	   				pulseRul  = pulse[i];
	   				breatheRul = breathe[i];
	   				systolicPressure = sysP[i];
	   				diagstolicPressure = diaP[i];
	   				if(bodyTemperature != null && bodyTemperature.length > 0){
	                   strBuf = strBuf+"  T"+bodyTemperature+"℃";
	   				}
	   				if(pulseRul != null && pulseRul.length > 0){
	                   if(!Ext.isEmpty(strBuf,false)){
	                	   strBuf = strBuf+"， P"+pulseRul+"次/分";
	            	   }else{
	            		   strBuf = strBuf+"  P"+pulseRul+"次/分";
	            	   }
	   				}
	   				if(breatheRul != null && breatheRul.length > 0){
	            	   if(!Ext.isEmpty(strBuf,false)){
	            		   strBuf = strBuf+"，R"+breatheRul+"次/分";
	            	   }else{
	            		   strBuf = strBuf+"  R"+breatheRul+"次/分";
	            	   }
	   				}
	   				if(systolicPressure != null && systolicPressure.length > 0){
	            	   if(!Ext.isEmpty(strBuf,false)){
	            		   strBuf = strBuf+"，  BP"+systolicPressure+"/"+diagstolicPressure+"mmHg";
	            	   }else{
	            		   strBuf = strBuf+"  BP"+systolicPressure+"/"+diagstolicPressure+"mmHg";
	            	   }
	                   
	   				}
	   				if(i>0){
	                   str=str+"； ";
	   				}
	   				str = str+strBuf;
	   			}
	   		}else{
	             var message = '请先选记录再进行写回！';
	             XapMessageBox.info(message);
	             return;
	   		}  
	        // alert(str);
	   		var plugin = document.getElementById('iemrEditor');
	       	if(plugin!=null){
	       		plugin.InsertText(str);
	       	}else{
	       		var message = '未获取编辑器控件！';
	            XapMessageBox.info(message);
	       	}
		});
	    this.addEvents("changeEncounter");//为视图添加刷新事件
        this.addListener('changeEncounter', function(enPk){//添加监听事件
            //查询action
       	 	var chain = me.getActionChain('refresh');
       	 	chain.execute({
       	 		'enPk':enPk
       	 	});
        });
	}
});