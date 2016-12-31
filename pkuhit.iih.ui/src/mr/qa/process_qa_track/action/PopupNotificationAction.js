 /*
 *  弹出完成本次质控Action
 * @extends Xap.ej.action.PopAction
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.action.PopupNotificationAction', {
	extend: 'Xap.ej.action.PopAction',
	
	execute: function(context) {

        var owner = this.getOwner();   
        
    	//获取储存于画面间的参数
        var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);
        
		var typeFlag = properties.data.typeFlag;
			
		var qaTypeCode = "";
		var qaTypeName = "";
		var workScreen = "2";
		if(typeFlag==1){
		   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeProcess;
		   qaTypeName = "环节质控";
		   workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackProcess;
		} else if(typeFlag==2){
		   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeTerminal;
		   qaTypeName = "终末质控";
		   workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackTerminal;
		} else if(typeFlag==3){
		   qaTypeCode = iih.mr.qa.QaStatusGlobal.qaTypeCodeDept;
		   qaTypeName = "科室质控";
		   workScreen = iih.mr.qa.QaStatusGlobal.workScreenTrackDept;
		}
        
        var revisionCd = owner.revisionCd;
    	
    	var revisionRecord = properties.data.revisionRecord;
        
		var config = {
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
    					encounterPk:revisionRecord.data.enPk,  //就诊PK
			        	qaTypeCode:qaTypeCode,    //质控类型编码
    					qaTypeName:qaTypeName,  //质控类型名称
    					patientRecord:revisionRecord,  //患者就诊记录 
    					revisionCd:revisionRecord.data.revisionCd,
    					workScreen:workScreen
    				}
    			}
    		}
    	};
    	this.callParent([config]);
	}
});
