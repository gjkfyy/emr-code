/** 
 * 质控工作画面加载初始化Action
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.action.QaWorkInitAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:['Xap.ej.block.Layer','iih.mr.qa.QaStatusGlobal','iih.mr.qa.QaFunction'],
	      
	execute: function(context){
		
		var me = this;
		
	    var owner = this.getOwner();   
	    
	    var windowView = owner.ownerCt;
	    
	    var encounterPk = owner.patientRecord.pk;
	    
	    var workScreen = owner.workScreen;
	    
	    var qaTypeName = '';
	    
	    var viewflag = context.viewflag;
	    
	    //监听弹出窗口的关闭事件,刷新不同工作场景的画面缺陷
	    windowView.on('close',function(){
	    	var closeChain = owner.getActionChain('closeAction');
	    	closeChain.execute();
	    });
	    
	    //储存画面间参数
	    var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);//qaworkview
	    
	    //1=环节质控工作 2=环节质控追踪  4、5 = 终末 8、9=科室
	    if(workScreen == '1' || workScreen == '2'){
	    	qaTypeName = "环节质控";
	    }else if(workScreen == '4' || workScreen == '5'){
	    	qaTypeName = "终末质控";
	    }else if(workScreen == '8' || workScreen == '9'){
	    	qaTypeName = "科室质控";
	    }else if(workScreen == '13'){
	    	qaTypeName = "医嘱质控";
	    }
        properties.setData({
        	encounterPk:encounterPk,  //就诊PK
        	qaTypeCode:context.qaTypeCode,    //质控类型编码
        	qaTypeName:qaTypeName,    //质控类型名称        	
        	patientRecord: owner.patientRecord,  //患者就诊记录        
        	workScreen:workScreen,
        	viewflag:viewflag
        });
	    
	    //获取工作区
		var block = this.getBlock('content');
		
		//获取病历树视图
		
		var mrDocTreeView = owner.down('qamrdoctreeview');
		if(mrDocTreeView != undefined){
			
			//初始化病历树
			var initTreeChain = mrDocTreeView.getActionChain('initTree');
			//initTreeChain.execute({'encounterSn':1203730});
			initTreeChain.execute({'encounterSn':encounterPk,'workScreen':workScreen});
		}
		
		//获取缺陷一览视图
		if(viewflag == '1'){
			var defectinAndmreditview = owner.down('defectinandmreditandhelperview');
		}else{
			var defectinAndmreditview = owner.down('defectinAndmreditview');
		}
		var defectinAndorderview = owner.down('defectinandorderview');
		//初始化缺陷一览列表
		var searchDefectsChain = '';
		if(defectinAndmreditview != undefined){
			
			searchDefectsChain =  defectinAndmreditview.getActionChain('searchDefectsAction');
			searchDefectsChain.execute();
			
		}else if(defectinAndorderview != undefined){
			searchDefectsChain =  defectinAndorderview.getActionChain('searchDefectsAction');
			searchDefectsChain.execute();
		}
		
		//根据记录创建文书
		if(context.record!=undefined && defectinAndmreditview != undefined){
			
			var mrdocBlock = defectinAndmreditview.down('qamreditblock');
			var mrSn = context.record.targetObjectPk;
			//iih.mr.qa.QaFunction.qaCreateMrdoc(mrdocBlock,mrSn);
			
			var defectsinGrid = defectinAndmreditview.down('xapgrid');
			
			//创建病历文书并添加到病历文书工作区
			var mrdocEditView = iih.mr.qa.QaFunction.qaCreateMrdoc(mrdocBlock,mrSn);
			
			mrdocEditView.on('editorOpened',function(medicalRecord){
				
				 //设置TITLE
				 iih.mr.qa.QaFunction.setBlockTitle(mrdocBlock,properties,context.record);
				 
				 //如果是终末质控需求判断提缺陷的按钮是否可操作
				 if(iih.mr.qa.QaFunction.getQaTypeBoolean(properties)){
					 
					 iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,owner,false);
					 
				 }else{
					 
					 iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,defectinAndmreditview,true);
				 }
			});
			
			/*//暂时先用任务处理
			this.task = new Ext.util.DelayedTask(function(){ me.setTitleAndButDisabled(defectsinGrid,defectinAndmreditview);}); 
			
			 if(iih.mr.qa.QaFunction.getQaTypeBoolean(properties)){
				 
				 //暂时先用定时来处理
				 me.task.delay(iih.mr.qa.QaFunction.taskTimes);
				 
			 }else{
				 
				 iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,defectinAndmreditview,true);
			 }
			 
			 //设置TITLE
			 iih.mr.qa.QaFunction.setBlockTitle(mrdocBlock,properties,context.record);*/
		}
		
	},
	
	setTitleAndButDisabled:function(defectsinGrid,owner){

		iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,owner,false);
	}
	
})