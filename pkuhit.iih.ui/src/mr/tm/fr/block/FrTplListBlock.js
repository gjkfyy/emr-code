Ext.define('iih.mr.tm.fr.block.FrTplListBlock',{
	extend : 'Xap.ej.element.grid.Grid',

	requires: [	           
			'Xap.ej.block.LayeredBlock',
			'Xap.ej.element.grid.FlowGrid',  
			'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.frtpllistblock',
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	layout: 'fit',
	//checkboxShow : true,
	//simple点击行起作用，multi点击checkbox起作用
	mode: 'simple',
	//title: '基础模板列表',
	autoScroll:true,
	pageSize : 25,
	pageShow : true,
	ifSelect:true,
	selectBy: 'code' ,//主键dataIndex名称（默认是id）
	name: 'frTplListBlock',
	
	tbar:[
		{text: '新建',method: 'create',iconCls: 'icon-Create'},
		{text: '打开',method: 'open',iconCls: 'icon-Open'},
		{text: '删除',method: 'delete',iconCls: 'icon-Delete'},
		{text: '属性',method: 'property',iconCls: 'icon-Property'},	
		{text: '停用',method: 'stopped',iconCls: 'icon-disable'},
        {text: '启用',method: 'activated',iconCls: 'icon-enable'}
	],


	CM_JR_Record: [
	               {header: '名称',dataIndex: 'nm',width:200},//基础模板
	               {header: '类型',dataIndex: 'mrFrTplTpNm',width:60},
	               {header: '状态',dataIndex: 'statusName',width:60},
	               {header: '创建人',dataIndex: 'crtUserName',width:100},
	               {header: '创建时间',dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:150},
	               {header: '最后更新人',dataIndex: 'lastUpdUserName',width:100},
	               {header: '最后更新时间',dataIndex: 'lastUpdTime',xtype: 'xapdatecolumn',width:150},
	               {header: '描述',dataIndex: 'memo',flex:1},
	               {header: '状态编码',dataIndex: 'status',hidden:true},
	               {header: 'id',dataIndex: 'mrFrTplCd',hidden:true},
				   {header: '文件主键',dataIndex: 'filePk',hidden:true}
	],
	setGridData: function(data) {
	 	var dataList = data;
	 	if( null == data.dataList ){
	 		var totalList = {"total":0,"dataList":null};
	 		this.setPageData(totalList);
	 	}
	 	if(dataList){
		    	var totalList = {"total":data.total,"dataList":data.dataList};
		    	var pageNum = data.pageNum;
		    	if(pageNum == '1'){
		    		this.setPageData(totalList);	//初始化赋值
		    	}else{
		    		this.setData(data.dataList);	//翻页时赋值
		    	}
	 	}else{
	 		var totalList = {"total":data.total,"dataList":data.dataList};
	 		this.setPageData(totalList);
	 	}
	}

})