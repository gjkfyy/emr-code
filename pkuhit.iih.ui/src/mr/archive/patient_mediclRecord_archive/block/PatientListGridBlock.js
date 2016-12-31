Ext.define('iih.mr.archive.patient_mediclRecord_archive.block.PatientListGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.patientlistgridblock',
	
	layout: 'fit',
	
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        //ifSelect : true,
        selectBy: 'pk',
		title: '就诊患者一览',
		tools:[{
			xtype: 'xapbutton',
			text : '病历上传',
			name:'selectArchive',
			handler: function() {
				var view=Ext.getCmp('patientandmediclrecordview');
				var patientListArchive = view.getActionChain("patientListArchive");
				patientListArchive.execute();
			}	
		}
//		{
//			xtype: 'xapcheckbox',
//			boxLabel: '已上传',
//			padding:'0 920 0 0',
//			disabled: true
//		}
	],
		name:'patientGrid',
		autoScroll:true,
		pageSize : 25,
		checkboxShow:true,
		mode:'simple',//simple,
		showHeaderCheckbox : true,
		pageShow : true,
  		CM_JR_Record: [   
  		        { header: '患者编号', dataIndex: 'pk',field: 'textfield',type: 'string',width:90,hidden:true},
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:90},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 },
               
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',flex:1,width:110},
                { header: '出院时间', dataIndex: 'finishTime',xtype: 'xapdatecolumn',flex:1,width:110 },
                { header: '经治医师', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:110 },
                { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '病案状态编号', dataIndex: 'statusCode',field: 'textfield',type: 'string',width:80,hidden:true},
                { header: '病案状态', dataIndex: 'statusName',field: 'textfield',type: 'string',width:80},
                { header: '是否上传', dataIndex: 'arcF',field: 'textfield',type: 'string',width:60,renderer: function(value){
  						if (value) {
  							if (Ext.isNumber(value)) {
  								if(value==1){
  									return "已上传";
  								}
  							}
  							return "未上传";
  						}
  					} },
                {xtype:'xapactioncolumn',text:'操作',width : 90,
    				items: [{text:'病历上传',
    							handler: function(view,rowIndex,colIndex,e,item ,record) {
    								var owner = this.up('patientview');
    								var finishDeptChain = owner.getActionChain("amrConfirmArchive");
    								finishDeptChain.execute({
    									record:record
    								});
    							}	
    						}
    					]
    				}
        ]
    }]
,
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
});
