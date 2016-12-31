Ext.define('iih.sy.params.block.ParamsSetListBlock',{
	extend : 'Xap.ej.element.grid.Grid',
	requires: [	           
		'Xap.ej.block.LayeredBlock',
	    'Xap.ej.element.grid.FlowGrid',  
	    'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.paramssetlistblock',	
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	name:'mrtemplatelistblock',
	layout: 'fit',
	checkboxShow : false,
	mode: 'simple',
	//autoScroll:true,
	pageSize : 20,
	pageShow : true,
	ifSelect:true,
	selectBy: 'code' ,//主键dataIndex名称（默认是id）
		
	tbar:[
		{text: '新建',method: 'create',iconCls: 'icon-Create'},
		{text: '编辑',method: 'edit',iconCls: 'icon-Open'},
		{text: '删除',method: 'delete',iconCls: 'icon-Delete'},
		{text: '刷新内存',method: 'refresh',iconCls: 'icon-redefect'}
	],

	CM_JR_Record: [
				   {header: '名称',dataIndex: 'nm',width:300},
				   {header: '编码',dataIndex: 'codeName',width:100},
				   {header: '标识',dataIndex: 'key',width:90},
				   {header: '值',dataIndex: 'value',width:90},
				   {header: '描述',dataIndex: 'memo',width:500},
				   {header: '编码',dataIndex: 'code',width:100,hidden:true},
				   {header: '参数编码',dataIndex: 'paramCd',hidden:true}/*,			   
				   {header: '序号',dataIndex: 'sortNo',hidden:true},
				   {header: '拼音码',dataIndex: 'spellNo',width:100},//MRM16
                   {header: '五笔码',dataIndex: 'wubiNo',hidden:true},
	               {header: '更新次数',dataIndex: 'updCnt',width:100},
				   {header: '创建人',dataIndex: 'crtUserId',width:100},
	               {header: '创建时间',dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:150},
	               {header: '创建部门',dataIndex: 'crtDeptCd',width:100},
	               {header: '最后更新时间',dataIndex: 'lastUpdTime',xtype: 'xapdatecolumn',width:150},
	               {header: '最后更新部门',dataIndex: 'lastUpdDeptCd',width:150},
	               {header: '最后更新人',dataIndex:'lastUpdUserId',hidden:true}*/
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
			 		//console.log(totalList);
		    		this.setPageData(totalList);	//初始化赋值
		    	}else{
		    		//console.log("翻页");
		    		this.setData(data.dataList);	//翻页时赋值
		    	}
	 	}else{
	 		var totalList = {"total":data.total,"dataList":data.dataList};
	 		this.setPageData(totalList);
	 	}
	},
	initComponent: function() {
		this.callParent();
		this.initBlock();
		
	}
})