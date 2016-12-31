var widthRate = 1
Ext.define('iih.mr.qa.order_qa_patient.block.OrderQAPatientListGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.orderqapatientlistgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'pk',
		title: '就诊患者一览',
		tools:[{
				   xtype: 'label',		              
			       width:10
			   },{
			       xtype:'button',
			       name:'inOrder',
			       iconCls: 'icon-inTerminal',
			       text:'进入医嘱质控',
			       method:'inOrder',
           		   disabled : true
			   }],
		autoScroll:true,
//		height:520,
		pageSize : 25,
		pageShow : true,
  		CM_JR_Record: [   
  				
				{ header : '按钮状态',dataIndex : 'btnFlag', field: 'textfield',type: 'string',hidden:true },
  				{  dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',flex:1,hidden:true},
  				{  dataIndex: 'curMainDiNm',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室编码', dataIndex: 'currentDeptCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生编码', dataIndex: 'currentManageDoctorId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生名称', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',flex:1,hidden:true },
  				/*{  header: '标记', dataIndex: 'qaFlag',name: 'qaFlag',width:50,
  				renderer:function(value,metaData,record){
			        if(value == 1){
			        	return "<label>★</label>";
			        }else{
			        	return null;
			        	}
					}
  				},//质控标记
*/  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:80},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 },
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:60 },
                { header: '住院科室', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:110 },
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',flex:1},
                { header: '出院时间', dataIndex: 'finishTime',xtype: 'xapdatecolumn',flex:1 },
                { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '手术标识', dataIndex: 'surgeryFlag',name: 'surgeryFlag',
					renderer:function(value,metaData,record){
			        if(value == 1){
			        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
			        }else{
			        	return null;
			        	}
					}
				},
				
                { header: '缺陷数', dataIndex: 'faultTotal',field: 'textfield',type: 'int',width:60 }
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
})
