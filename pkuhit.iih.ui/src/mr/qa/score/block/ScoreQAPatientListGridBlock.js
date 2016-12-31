var widthRate = 1
Ext.define('iih.mr.qa.score.block.ScoreQAPatientListGridBlock',{
	extend : 'Xap.ej.block.FormBlock',
	
	requires: [],

	alias:'widget.scoreqapatientlistgridblock',
	
	layout: 'fit',
    border: 0,
//    height:520,
    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'pk',
		tools:[{
           xtype:'button',
           margin:'0 10 0 0',
           name:'score',
           text:'评分',
           method:'score',
           disabled : true
       }],
		autoScroll:true,
       	pageSize : 25,
		pageShow : true,
  CM_JR_Record: [   
  				{ header: '就诊外键', dataIndex: 'pk',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'patientId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header: '床位号', dataIndex: 'currentBedCode',field: 'textfield',type: 'string',flex:1,hidden:true},
  				{  dataIndex: 'curMainDiNm',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  dataIndex: 'currentDeptIntoTime',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室编码', dataIndex: 'currentDeptCode',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '当前科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生编码', dataIndex: 'currentManageDoctorId',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{  header: '主管医生名称', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',flex:1 ,hidden:true},
  				{ header:'病案状态编码', dataIndex: 'statusCode',field: 'textfield',type: 'string',flex:1,hidden:true},
                { header: '科室名称', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:110  },
                { header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:90},
                { header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:90},
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:70 },
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:70},
                { header: '诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',flex:1 },
                { header: '入院时间', dataIndex: 'receiveTime', flex:1,
					field: {
						xtype: 'datetimefield'
					},
					renderer: function(v){
						if(v){
							v = new Date(v);
							return Ext.util.Format.date(v, 'Y-m-d H:i');
						}
						return v;
					}
				 },
                { header: '出院时间', dataIndex: 'finishTime', flex:1 ,
					field: {
						xtype: 'datetimefield'
					},
					renderer: function(v){
						if(v){
							v = new Date(v);
							return Ext.util.Format.date(v, 'Y-m-d H:i');
						}
						return v;
					}
				 },
				
                
                { header: '经治医生', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:90  },
                { header: '科室质控得分', dataIndex: 'deptQaScr',field: 'textfield',flex:1 ,id:'deptQaScr'},
                { header: '科室病案等级', dataIndex: 'deptLvl',field: 'textfield',flex:1, id:'deptLvl',hidden:true
                	/* renderer: function(value) {
                		 var deptQaScrObj = Exp.getCmp('deptQaScr');
                		 alert(deptQaScrObj);
                		 var deptQaScr = deptQaScrObj.value;
                		 if(deptQaScr){
                			 if(parseInt(deptQaScr) > 90){
      							return '甲级';
      						}else if(parseInt(deptQaScr) > 75 && parseInt(deptQaScr) <= 90){
      							return '乙级';
      						}else if(0<=parseInt(deptQaScr) <= 75){
      							return '丙级';
      						}
                		 }else{
                			 return '-';
                		 }
                     }*/

                	
                },
                { header: '质控得分', dataIndex: 'score',field: 'textfield',flex:1 ,id:'qaScr' },
                { header: '病案等级', dataIndex: 'lvl',field: 'textfield',flex:1,id:'lvl'}
                
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
	        		grid.setPageData(totalList);
		    	}else{
		    		grid.setData(dataList);
		    	}
	        }else{
	        	var totalList = {"total":data.total,"dataList":dataList};
	        	grid.setPageData(totalList);
	        }
    	}
    }
})