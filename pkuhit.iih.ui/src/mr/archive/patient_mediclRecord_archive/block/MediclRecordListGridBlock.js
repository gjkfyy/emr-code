Ext.define('iih.mr.archive.patient_mediclRecord_archive.block.MediclRecordListGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.mediclrecordlistgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        selectBy: 'mrPk',
		title: '选择病历',
		name:'mediclGrid',
		autoScroll:true,
		pageSize : 25,
		pageShow : true,
		ifSelect: false,
		//checkOnly : true,
		mode:'simple',
		showHeaderCheckbox : true,
		rownumShow : true,
		selType : 'cellmodel',
		checkboxShow : true,
  		CM_JR_Record: [   
  				{ header: '病历编号', dataIndex: 'mrPk',field: 'textfield',type: 'string',width:250},
  				{ header: '病历文书名称', dataIndex: 'name',field: 'textfield',type: 'string',width:160 },
//                { header: '病历文书类型', dataIndex: 'templeCode',field: 'textfield',type: 'string',width:110 },
                { header: '文书类型', dataIndex: 'typeName',field: 'textfield',width:130},
                { header: '系统标示编码', dataIndex: 'typeCode',field: 'textfield',flex:1,width:110,hidden:true},
                { header: '系统标示编码', dataIndex: 'filePk',field: 'textfield',flex:1,width:110,hidden:true},
                { header: '患者编号', dataIndex: 'encounterPk',field: 'textfield',flex:1,width:110,hidden:true},
                
                { header: '创建人', dataIndex: 'createUserName',field: 'textfield',width:60 },
                { header: '是否上传', dataIndex: 'arcF',field: 'textfield',width:60 
                	,renderer: function(value){
  							return value==1?"已上传":"未上传";
  						}
  					 },
                { header: '创建时间', dataIndex: 'crtTime',width:120 
                	,renderer: function(value){
  						if (value) {
  							if (Ext.isNumber(value)) {
  								value = new Date(value);
  								return Ext.util.Format.date(value, 'Y-m-d h:i');
  							}
  							return value;
  						}
  					} },
                { header: '最后修改时间', dataIndex: 'lastUpdTime',width:120
                	,renderer: function(value){
  						if (value) {
  							if (Ext.isNumber(value)) {
  								value = new Date(value);
  								return Ext.util.Format.date(value, 'Y-m-d h:i');
  							}
  							return value;
  						}
  					} },
                
        ],
        viewConfig : {
        	getRowClass : function(record,rowIndex,rowParams,store){
	        	if("1"==record.get('arcF')){ 
	        	return 'row_f'; 
	        	} else{
	        	return '';
	        		
	        	}
        	}
    },
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
