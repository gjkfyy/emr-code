/** 
 * 弹出完成本次质控Action
 * @extends Xap.ej.action.PopAction
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.PopupDefectNoticeInferViewAction', {
	extend: 'Xap.ej.action.PopAction',
	       
	requires:['iih.mr.qa.process_qa_work.view.DefectNoticeInferView','Xap.ej.block.Layer'],
	
	execute: function(context){ 
		
		var defectBlock = this.getBlock("bottomcontent");
		
		var defectGrid = defectBlock.down('xapgrid');
		
		var defectData = defectGrid.getData(); 
		
		var haveFault = true;
		
		var owner=this.getOwner();	
		
		var properties = owner.ownerCt.ownerCt.getLayer(Xap.ej.block.Layer.PROPERTIES);
		
		//质控类型
		var typeFlag = properties.data.typeFlag;
		
		//就诊序号
		var encounterSn = properties.data.encounterPk;
		
		//病案号
		var medicalNum = properties.data.medicalNum;
		
		var config = {};
		//var defectnoticeinferview1 = Ext.create('iih.mr.qa.process_qa_work.view.DefectNoticeInferView');
		if(defectData.length == '0'){
			XapMessageBox.confirm2( "本次质控无缺陷，确定完成？", function(button) {
							            if (button == "yes") {
							            	haveFault = false;
											var defectnoticeinferview = Ext.create('iih.mr.qa.process_qa_work.view.DefectNoticeInferView');
											var propertiesNoticeInferView = defectnoticeinferview.getLayer(Xap.ej.block.Layer.PROPERTIES);
											propertiesNoticeInferView.setData({
													typeFlag: '1',
										        	encounterPk:encounterSn,  //就诊PK
										        	qaTypeCode:properties.data.qaTypeCode,    //质控类型编码
						        					qaTypeName:properties.data.qaTypeName,  //质控类型名称
						        					patientRecord:properties.data.patientRecord,  //患者就诊记录 
						        					haveFault:haveFault,
						        					revisionCd:'',
						        					workScreen:properties.data.workScreen
						        					
										        	
										    });
									        var chain = defectnoticeinferview.getActionChain('send');
									        
									        if(chain) {
									            chain.execute();
									        }
									        defectnoticeinferview.destroy();
							            }else{
							            	return;
							            }
							        });
		}else{
			haveFault = true;	
			config = {
	    		width: 760,
	    		height:600,
	    		title:'发送病历整改通知书',
	    		contentConfig: {
	    			xtype: 'defectnoticeinferview',
	    			socuseOwner:owner,  //传入上级视图
	    			initChain: {
	    				name: 'refresh',
	    				context: {
	    					typeFlag: '1',
	    					encounterSn: encounterSn,
	    					medicalNum: medicalNum,
	    					qaTypeCode:properties.data.qaTypeCode,    //质控类型编码
        					qaTypeName:properties.data.qaTypeName,  //质控类型名称
        					haveFault:haveFault,//是否有缺陷
        					patientRecord:properties.data.patientRecord,  //患者就诊记录
        					workScreen:properties.data.workScreen,
        					revisionCd:''
	    					
	    				}
	    			}
	    		}
	    	};
	    	this.callParent([config]);
		}
		
	
		
		
		
	}
})