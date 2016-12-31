var widthRate = 1
Ext.define('iih.mr.qa.process_qa_patient.block.InProcessQAPatientListGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.inprocessqapatientlistgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'pk',
		title: '就诊患者一览',
		tools:[{
           xtype:'button',
           text:'进入环节质控',
           iconCls: 'icon-inProcess',
           method: 'inProcess',
           disabled : true
       	}],
		autoScroll:true,
//		height:465,
		pageSize : 25,
		pageShow : true,
//       width:1200*widthRate,
       /*plugins: [
                 Ext.create('Ext.grid.plugin.CellEditing', {
                     clicksToEdit: 0
                 })
             ],*/
             
  CM_JR_Record: [      
  				{  header: '标记', dataIndex: 'qaFlag',name: 'qaFlag',width:50,
  				renderer:function(value,metaData,record){
			        if(value == 1){
			        	return "<label>★</label>";
			        }else{
			        	return null;
			        	}
					}
  				},//质控标记
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90},
  				{ header: '床号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',width:70},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:100},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 },
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:60 },
//                { dataIndex: 'deptCd',field: 'textfield',type: 'string', flex:1 ,hidden:true},
                { header: '就诊科室', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:70 },
 				{  header: '病区', dataIndex: 'currentWardName',field: 'textfield',type: 'string',width:70},
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',width:130},
                /*{ header: '入院时间', dataIndex: 'receiveTime', flex:1,
					field: {
						xtype: 'datetimefield'
					},
					renderer: function(v){
						if(v){
							v = new Date(v);
							return Ext.util.Format.date(v, 'Y-m-d H:i:s');
						}
						return v;
					}
				 },*/
//                { header: '入院次数', dataIndex: 'encounterCount',field: 'textfield',type: 'Short',flex:1},
                { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '主管医师', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:60 },
                { header: '责任护士', dataIndex: 'currentManageNurseName',field: 'textfield',type: 'string',width:60 },
//                { header: '出院时间', dataIndex: 'fnshTime',field: 'textfield',type: 'string',flex:1 },
               /* { header: '出院时间', dataIndex: 'finishTime',  
					field: {
						xtype: 'datetimefield'
					},
					renderer: function(v){
						if(v){
							v = new Date(v);
							return Ext.util.Format.date(v, 'Y-m-d H:i:s');
						}
						return v;
					}
				 },*/
                { header: '病危/病重', dataIndex: 'illStatusCode',width:70,hidden:true,
                	renderer:function(value,metaData,record){
			        if(value ==  "ENM05.01" || value == "ENM05.02"){//病危 DANGER_ILL = "ENM05.01" 病重 SERIOUSLY_ILL = "ENM05.02"
			        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
			        }else{
			        	return null;
			        	}
					}
				},
                { header: '手术标识', dataIndex: 'surgeryFlag',name: 'surgeryFlag',width:70,hidden:true,
					renderer:function(value,metaData,record){
			        if(value == 1){
			        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
			        }else{
			        	return null;
			        	}
					}
				},
                { header: '缺陷数', dataIndex: 'faultTotal', alink:true, field: 'textfield',type: 'int',width:60 },
                { header: '质控次数', dataIndex: 'qaCount', field: 'textfield',type: 'string',width:60 },
                { header: '质控医师', dataIndex: 'curUserName', field: 'textfield',type: 'string',width:60 },
                {  dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'curMainDiNm',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室编码', dataIndex: 'currentDeptCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前病区编码', dataIndex: 'currentWardCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前责任护士编码', dataIndex: 'currentManageNurseId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生编码', dataIndex: 'currentManageDoctorId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生名称', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',flex:1 ,hidden:true}
        ]
    }],
    setData: function(data) {
        	var grid = this.down('xapgrid');
        	var dataList = data.dataList;
        	if(grid){
        		if(dataList){
			    	var totalList = {"total":data.total,"dataList":dataList};
			    	var pageSize = data.pageSize;
			    	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
			    		grid.setPageData(totalList);	//初始化赋值
			    	}else{
			    		grid.setData(dataList);	//翻页时赋值
			    	}
	        	}else{
	        		var totalList = {"total":data.total,"dataList":data.dataList};
	        		grid.setPageData(totalList);
	        	}
        	}
    	}  
        /*setData: function(data) {
        	var grid = this.down('xapgrid');
        	if(data.dataList){
	        	var cusAmr;
	        	var encounterModel;
	        	var dataList = data.dataList;
	        	var dataListGroup = [];
//	        	var model = Ext.create('iih.po.model.PatientModel',data.data);
	        	for(i=0;i<dataList.length;i++){
	        		cusAmr = dataList[i].cusAmr;
	        		encounterModel = dataList[i].encounterModel;
	        		dataListGroup[i]={
						enPk:encounterModel.enPk,
						qaFlag:cusAmr.qaFlag,
						curBedCd:encounterModel.curBedCd,
						amrNo:cusAmr.amrNo,
						paNm:encounterModel.paNm,
						sexNm:encounterModel.sexNm,
						age:encounterModel.age,
						curDeptNm:encounterModel.curDeptNm,
						rcvTime:encounterModel.rcvTime,
						enCnt:encounterModel.enCnt,
						curMainDiNm:encounterModel.curMainDiNm,
						fnshTime:encounterModel.fnshTime,
						illStaCd:encounterModel.illStaCd,
						suF:encounterModel.suF,
						faultTotal:cusAmr.faultTotal,
						faultTodoReform:cusAmr.faultTodoReform,
						faultTodoReview:cusAmr.faultTodoReview,
						executeEndTime:cusAmr.executeEndTime,
						executeDeptName:cusAmr.executeDeptName,
						excuteUserName:cusAmr.excuteUserName
						};
	        	}
//	    	grid.setData(dataList);
        	var totalList = {"total":data.total,"dataList":dataList};
        	var pageSize = data.pageSize;
        	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
        		grid.setPageData(totalList);	//初始化赋值
        	}else{
        		grid.setData(dataList);	//翻页时赋值
        	}
        	}else{
        		var totalList = {"total":data.total,"dataList":data.dataList};
        		grid.setPageData(totalList);
        	}
    	}  */             
})
