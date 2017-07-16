Ext.define('iih.sy.search.block.SearchHistoryBlock', {
	extend : 'Xap.ej.block.Block',

	requires : [ 'Xap.ej.element.grid.Grid' ],

	alias : 'widget.searchhistoryblock',

	layout : {
		type:'vbox',
        align: 'stretch'
	},

	items : [ {
		title : '我的搜索',
		xtype : 'xapgrid',
		name:'searchList',
		// pageShow : true,
		border:false,
		rownumShow : true,
		height : 612,
		// selType:'checkboxmodel',
		pageSize : 20,
		pageShow : true,
		ifSelect: true,
		selectBy: 'id',
		//checkOnly : true,
		mode:'simple',
		showHeaderCheckbox : false,
		//selType : 'cellmodel',
		checkboxShow : false,
		CM_JR_Record : [ {
			header : 'id',
			dataIndex : 'id',
			field : 'textfield',
			type : 'string',
			hidden:true
		},{
			header : '名称',
			dataIndex : 'conditionName',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : 'condition',
			dataIndex : 'condition',
			field : 'textfield',
			type : 'string',
			hidden:true
		}
//		,{
//			header:"操作",
//          width:130,
//          align:"center",
//          renderer:function(value,cellmeta){
//            var returnStr = "<INPUT type='button' value='删除'>";
//            return returnStr;
//          }
//	    }
		,{
		    xtype: 'actioncolumn',
		    text: '操作',
		    align : 'center', 
		    width: 50,
		    tdCls: 'action',
		    items: [{
		    	iconCls : 'icon-Delete',
		    	valign : 'center',
		        tooltip: '删除',
		        handler: function(grid, rowIndex, colIndex, node, e, record, rowEl) {
					var owner = this.up('searchleftview');
					XapMessageBox.confirm2 (
					'确认删除？',
					function(btn){
						if(btn == 'yes'){
							var deleteChain = owner.getActionChain("delete");
							deleteChain.execute({
								record:record
							});
						}
					});
		        }
		    }]
		}]
	} ],
	setData : function(data) {
		var grid = this.down('xapgrid[name=searchList]');
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