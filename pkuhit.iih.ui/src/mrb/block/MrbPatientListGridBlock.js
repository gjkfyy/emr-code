Ext.define('iih.mrb.block.MrbPatientListGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.mrbpatientlistgridblock',
	
	layout: 'fit',
	
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        //ifSelect : true,
        selectBy: 'pk',
		title: '就诊患者一览',
		tools:[
	],
		name:'patientGrid',
		autoScroll:true,
		pageSize : 25,
		checkboxShow:false,
		mode:'simple',//simple,
		showHeaderCheckbox : false,
		pageShow : true,
  		CM_JR_Record: [   
  		        { header: '患者编号', dataIndex: 'pk',field: 'textfield',type: 'string',width:90,hidden:true},
  				{ header: '就诊号/住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90},
  				{ header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:90},
  				{ header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:60 },
  				{ header: '患者id', dataIndex: 'patientId',field: 'textfield',type: 'string',width:90},
               
               
                { header: '就诊次数', dataIndex: 'encounterCount',field: 'textfield',type: 'string',width:110},
                { header: '就诊科室 ', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:110 },
                { header: '就诊医生', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:110 },
                { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',width:110 },
                { header: '手机号码', dataIndex: '',field: 'textfield',type: 'string',width:100},
                { header: '身份证号', dataIndex: '',field: 'textfield',type: 'string',flex:1}
             
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
