
/** 
 * 病历树点击触发的事件加载病历
 * @extends Xap.ej.action.Action
 * @author ：wang_yanli11111111111
 */
Ext.define('iih.mr.qa.process_qa_work.action.MrInTreeItemClickAction', {
	extend: 'Xap.ej.action.Action',
	
	requires:['iih.mr.qa.QaStatusGlobal','iih.mr.qa.QaFunction'],
    
	execute: function(context){  
		
		var owner = this.getOwner();  
		
		var me = this;
		
		//获取点击树的记录
		var treeRecord = context.event.arguments[1].raw;
		if(!treeRecord.leaf){
			return;
		}
		
		var properties = owner.getLayer(Xap.ej.block.Layer.PROPERTIES);//qaworkview
		
		var patientRecord = properties.data.patientRecord;
		
		var viewflag = properties.data.viewflag;
		
		//病历记录的主键
		var mrSn = treeRecord.mrPk;
		
        //获取编辑器及缺陷一览的视图
		if(viewflag == '1'){
			var mrdocAndDefetcView = owner.down('defectinandmreditandhelperview');
		}else{
			var mrdocAndDefetcView = owner.down('defectinAndmreditview');
		}
				
		//获取病历工作区的block
		var mrdocBlock = mrdocAndDefetcView.getBlock('top');
		
		//获取缺陷一览的表格
		var defectsinGrid =  mrdocAndDefetcView.getBlock('bottom');
		
		//文书类型对应的质控项目一级分类
		var firstCode = "";
		
		//创建病历文书并添加到病历文书工作区
		var mrdocEditView = iih.mr.qa.QaFunction.qaCreateMrdoc(mrdocBlock,mrSn);
		
		mrdocEditView.on('editorOpened',function(medicalRecord){
			
			firstCode = medicalRecord.firstCode;
			properties.data.firstCode = firstCode;
			properties.data.medicalRecord = medicalRecord;
			//设置TITLE
			 iih.mr.qa.QaFunction.setBlockTitle(mrdocBlock,properties,treeRecord);
			 
			 //如果是终末质控需求判断提缺陷的按钮是否可操作
			 if(iih.mr.qa.QaFunction.getQaTypeBoolean(properties)){
				 
				 iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,owner,false);
				 
			 }else{
				 
				 iih.mr.qa.QaFunction.setButDisabled(defectsinGrid,owner,true);
			 }
		});
	
		
		/*//获取定位缺陷一览的CHAIN
		var positionChain = mrdocAndDefetcView.getActionChain('positionAction');
		positionChain.execute({record:treeRecord});*/
		
		//页面间要定位的文书存储
		properties.data.record = treeRecord;
		
	}

	
})