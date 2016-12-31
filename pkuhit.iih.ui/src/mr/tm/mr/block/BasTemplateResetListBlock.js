Ext.define('iih.mr.tm.mr.block.BasTemplateResetListBlock',{
	extend : 'Xap.ej.element.grid.Grid',

	requires: [	           
			'Xap.ej.block.LayeredBlock',
			'Xap.ej.element.grid.FlowGrid',  
			'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.bastemplateresetlistblock',
	
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
	name: 'basTemplateResetListBlock',
	
	tbar:[],
	CM_JR_Record: [
           {header: '名称',dataIndex: 'name',width:200},//基础模板
           {header: '纸张类型',dataIndex: 'paperTypeName',width:60},
           //{header: '状态',dataIndex: 'statusName',width:60},
           //{header: '创建人',dataIndex: 'createUserName',width:100},
           //{header: '创建时间',dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:150},
           {header: '最后更新人',dataIndex: 'lastUpdateUserName',width:100},
           {header: '最后更新时间',dataIndex: 'lastUpdateTime',xtype: 'xapdatecolumn',width:150},
           {header: '描述',dataIndex: 'description',flex:1},
          // {header: '应用标志',dataIndex: 'applyFlag',width:60},
           {header: '状态编码',dataIndex: 'statusCode'/*,dictionary: 'MRM06'*/,hidden:true},
           {header: '基础模板id',dataIndex: 'code',hidden:true},
		   {header: '文件主键',dataIndex: 'filePk',hidden:true},
		 //  {header: '版本号',dataIndex: 'versionNo',flex:1},
           {header: '纸张类型',dataIndex: 'paperTypeCode',hidden:true}
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
	}

})