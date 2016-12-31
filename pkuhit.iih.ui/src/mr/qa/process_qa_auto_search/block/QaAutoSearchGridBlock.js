Ext.define('iih.mr.qa.process_qa_auto_search.block.QaAutoSearchGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.qaautosearchgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'qaPk',
		tools:[{
           xtype:'button',
           text:'查看',
           method: 'look',
           disabled : true
       	}],
		autoScroll:true,
		pageSize : 25,
		pageShow : true,
             
  CM_JR_Record: [      
  				{  dataIndex: 'qaPk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				//为了显示top信息
  				{  dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90 ,hidden:true},
  				{ header: '床号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',width:70 ,hidden:true},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:100 ,hidden:true},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 ,hidden:true},
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:60 ,hidden:true},
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',width:130 ,hidden:true},
//  				{ header: '质控日期', dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:130},
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:150},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:120},
  				{ header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '缺陷数', dataIndex: 'faultTotal',field: 'textfield',type: 'int',width:80 },
                { header: '主管医师', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:120 },
                { header: '就诊科室', dataIndex: 'currentDeptName' ,field: 'textfield',type: 'string',width:120}
                
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
