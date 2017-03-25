Ext.define('iih.sy.patient.block.PatientLeftGridBlock', {
	extend : 'Xap.ej.block.Block',

	requires : [ 'Xap.ej.element.grid.Grid' ],

	alias : 'widget.patientleftgridblock',

	layout : {
		type:'vbox',
        align: 'stretch'
	},

	items : [ {
		title : '患者列表',
		xtype : 'xapgrid',
		name:'patientList',
		// pageShow : true,
		rownumShow : false,
		height : 470,
		// selType:'checkboxmodel',
		pageSize : 20,
		pageShow : true,
		ifSelect: true,
		selectBy: 'patientId',
		//checkOnly : true,
		mode:'simple',
		showHeaderCheckbox : false,
		//selType : 'cellmodel',
		checkboxShow : false,
		CM_JR_Record : [ {
			header : 'patientId',
			dataIndex : 'patientId',
			field : 'textfield',
			type : 'string',
			hidden:true
		},{
			header : '姓名',
			dataIndex : 'patientName',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '住院号',
			dataIndex : 'inpatientNo',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			//header : '入院时间',
			header : '手机号',
			//dataIndex : 'admissionDate',
			dataIndex : 'tel',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			//header : '来源',
			header : '诊断',
			//dataIndex : 'serviceDepartName',
			value : '住院',
			field : 'textfield',
			type : 'string',
			flex : 1
		} ]
	} ],
	setData : function(data) {
		var grid = this.down('xapgrid[name=patientList]');
		if(data){
			var dataList=data.dataList;
	    	if(grid){
	    		if(dataList){
	    			
	    			//记住上次选中行，若第一次加载则默认选中第一行
	    			if(dataList.length >0 &&grid.nodeId == null){
	    				grid.nodeId = dataList[0][grid.selectBy];
	    			}
	    			
			    	var totalList = {"total":data.total,"dataList":dataList};
			    	var pageSize = data.pageSize;
			    	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
			    		grid.setPageData(totalList);	//初始化赋值
			    	}else{
			    		grid.setData(dataList);	//翻页时赋值
			    	}
	        	}else{
	        		var totalList = {"total":data.total,"dataList":dataList};
	        		grid.setPageData(totalList);
	        	}
	    		
	    	}
		}
	}
})
