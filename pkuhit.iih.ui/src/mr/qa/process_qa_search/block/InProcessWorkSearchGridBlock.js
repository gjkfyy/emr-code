Ext.define('iih.mr.qa.process_qa_search.block.InProcessWorkSearchGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.inprocessworksearchgridblock',
	
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
  				{ header: '通知书编码', dataIndex: 'revisionCd',field: 'textfield',type: 'string',hidden:true },
  				{ header: '通知书状态编码', dataIndex: 'status',field: 'textfield',type: 'string',hidden:true },
  				//为了显示top信息
  				{  dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90 ,hidden:true},
  				{ header: '床号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',width:70 ,hidden:true},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:100 ,hidden:true},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 ,hidden:true},
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:60 ,hidden:true},
                { header: '入院时间', dataIndex: 'receiveTime',xtype: 'xapdatecolumn',width:130 ,hidden:true},
  				{ header: '质控日期', dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:130},
  				/*{ header: '质控日期', dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:130 ,
  				renderer: function(value, cellmeta, record, rowIndex, colIndex, store){
  						if (value) {
  							if (Ext.isNumber(value)) {
  								value = new Date(value);
  								return Ext.util.Format.date(value, 'Y-m-d ');
  							}
  							return value;
  						}
  					}
  					
  				},*/
  				{ header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:100},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:80},
  				{ header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '通知书', dataIndex: 'revisionMemo',field: 'textfield',type: 'string',flex:1 },
                { header: '通知书状态', dataIndex: 'statusNM',field: 'textfield',type: 'string',width:90 },
                { header: '缺陷数', dataIndex: 'defectCount',field: 'textfield',type: 'int',width:60 },
                { header: '整改医师/护士', dataIndex: 'rfmDoctorNm',field: 'textfield',type: 'string',width:100 },
                { header: '整改日期', dataIndex: 'rfmTime',xtype: 'xapdatecolumn',width:120},
                { header: '质控医师/护士', dataIndex: 'crtUserNm', field: 'textfield',type: 'string',width:100 },
                { header: '质控科室', dataIndex: 'crtDeptNm' ,field: 'textfield',type: 'string',width:90}
                
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
