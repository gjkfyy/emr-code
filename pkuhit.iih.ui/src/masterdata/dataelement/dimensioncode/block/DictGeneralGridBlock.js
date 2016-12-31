Ext.define('iih.masterdata.dataelement.dimensioncode.block.DictGeneralGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.dictgeneralgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'pkDictgeneral',
		autoScroll:true,
		pageSize : 10,
		pageShow : true,
		
		tools:[
			/*{
				xtype: 'xapcheckbox',
				boxLabel : '启用',
				action: 'isActivated',
				checked:true,
				padding:'0 0 0 0'
			},*/{
				xtype:'xaptextfield',
				labelAlign : 'right',
				padding:'0 0 0 0',
				width: 300,
				labelWidth : 60,
				fieldLabel:'查询条件',
				name: 'conditionStr',
				dataIndex : 'conditionStr'
			},
			{
				xtype: 'xapbutton',
				text: '查询',
				action: 'search',
				iconCls: 'icon-Search',
				disabled: false
			},
			{
				xtype: 'xapbutton',
				text: '新建',
				action: 'create',
				iconCls: 'icon-Create',
				disabled: false
			},
			{
				xtype: 'xapbutton',
				text: '编辑',
				action: 'edit',
				iconCls: 'icon-edit',
				disabled: false
			},
			{
				xtype: 'xapbutton',
				text: '删除',
				action: 'deleted',
				iconCls: 'icon-Delete',
				disabled: false
			}/*,
			{
				xtype: 'xapbutton',
				text: '停用',
				action: 'stopped',
				iconCls: 'icon-disable',
				disabled: false
			},
			{
				xtype: 'xapbutton',
				text: '启用',
				action: 'activated',
				iconCls: 'icon-enable',
				disabled: false
			}*/
		],
		CM_JR_Record: [
		   			{ header: '通用字典数据主键', dataIndex: 'dataElementNm',field: 'textfield',type: 'string',hidden:true },
	  				{ header: '编码', dataIndex: 'dataElementCd',field: 'textfield',type: 'string',width:100},
	                { header: '名称', dataIndex: 'dataElementNm',field: 'textfield',type: 'string',width:150 },
	                { header: '描述', dataIndex: 'memo',field: 'textfield',type: 'string',width:300 }
	  				
        ]
    }],
    setData: function(data) {
    	var grid = this.down('xapgrid');
    	if(grid){
    		if(data){
	    		var dataList = data.dataList;
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
	    	}else{
	    		grid.setData([]);	
	    	}
    	}
	}  
})
