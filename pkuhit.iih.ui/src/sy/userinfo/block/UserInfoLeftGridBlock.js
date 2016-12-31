Ext.define('iih.sy.userinfo.block.UserInfoLeftGridBlock', {
	extend : 'Xap.ej.block.Block',

	requires : [ 'Xap.ej.element.grid.Grid' ],

	alias : 'widget.userinfoleftgridblock',

	layout : {
//		type : 'table',
//		border : '0',
//		columns : 1,
//		tableAttrs : {
//			border : 0,
//			cellpadding : 5,
//			cellspacing : 1,
//			width : '100%'
//		},
//		tdAttrs : {
//			valign : 'left'
//		}
		type:'vbox',
        align: 'stretch'
	},

	items : [ {
		title : '用户列表',
		xtype : 'xapgrid',
		name:'userList',
		// pageShow : true,
		rownumShow : false,
		height : 420,
		// selType:'checkboxmodel',
		pageSize : 20,
		pageShow : true,
		ifSelect: false,
		//checkOnly : true,
		mode:'simple',
		showHeaderCheckbox : false,
		//selType : 'cellmodel',
		checkboxShow : false,
		CM_JR_Record : [ {
			header : 'empId',
			dataIndex : 'employeeId',
			field : 'textfield',
			type : 'string',
			hidden:true
		},{
			header : 'xapUserPk',
			dataIndex : 'xapUserPk',
			field : 'textfield',
			type : 'string',
			hidden:true
		},{
			header : '用户ID',
			dataIndex : 'id',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '用户名',
			dataIndex : 'name',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '用户状态',
			dataIndex : 'statusName',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '所属科室',
			dataIndex : 'serviceDepartName',
			field : 'textfield',
			type : 'string',
			flex : 1
		} ]
	} ],
	setData : function(data) {
		var grid = this.down('xapgrid[name=userList]');
		if(data){
			var dataList=data.dataList;
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
	        		var totalList = {"total":data.total,"dataList":dataList};
	        		grid.setPageData(totalList);
	        	}
	    	}
		}
	}
})
