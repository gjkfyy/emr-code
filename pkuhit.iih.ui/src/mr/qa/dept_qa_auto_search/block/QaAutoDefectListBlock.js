Ext.define('iih.mr.qa.dept_qa_auto_search.block.QaAutoDefectListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.qaautodefectlistblock',

	layout: 'fit',
	
	items: [{
		xtype: 'xapgridblock',
//		title: '自动质控缺陷项',
		autoScroll:true,
		/*plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],*/
		pageSize : 25,
		pageShow : true,
		CM_JR_Record: [
                   { header: '就诊序号', dataIndex: 'encounterSn', hidden: true},
                   { header: '住院号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:80},
                   { header: '患者姓名', dataIndex: 'patientName',field: 'textfield',type: 'string',width:80},
                   { header: '主管医师', dataIndex: 'currentManageDoctorName',field: 'textfield',type: 'string',width:80 },
                   //{ header: '就诊科室', dataIndex: 'currentDeptName' ,field: 'textfield',type: 'string',width:90},
                   { header: '扣分项目', dataIndex: 'req',width:200},
                   { header: '文书类型', dataIndex: 'nm', width:160},
                   { header: '完成时间', dataIndex: 'completeTime',xtype: 'xapdatecolumn',width:130},
                   { header: '扣分描述', dataIndex: 'memo', flex:1}
		]
	}],

	setData: function(data) {/*
		var grid = this.down('xapgridblock');
		if(data.dataList){
			grid.setData(data.dataList);
		}else{
			grid.setData([]);
		}
	*/

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