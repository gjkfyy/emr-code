Ext.define('iih.mr.tm.mr.block.MrTemplateListBlock',{
	extend : 'Xap.ej.element.grid.Grid',
	requires: [	           
		'Xap.ej.block.LayeredBlock',
	    'Xap.ej.element.grid.FlowGrid',  
	    'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.mrtemplatelistblock',	
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	name:'mrtemplatelistblock',
	layout: 'fit',
	checkboxShow : false,
	//simple点击行起作用，multi点击checkbox起作用
	mode: 'simple',
	//title: '模板列表',
	autoScroll:true,
	pageSize : 25,
	pageShow : true,
	ifSelect:true,
	selectBy: 'code' ,//主键dataIndex名称（默认是id）
		
	tbar:[
/*	      {        
	        xtype: "xapcombobox",
	        name: 'mrTplStatCd',
	        allOptions:true,
	        editable: false,
	        fieldLabel: '',
	        dictionary:'MRM07',
	        emptyText: "状态查询",
	        value:'ALL',
	        editable:false
	      },
		{text: '升级',method: 'upgrade'},
		{text: '审核通过',method: 'verify'},
		{text: '驳回',method: 'reject'},
		{text: '取消审核',method: 'cancleVerify'},	
		{text: '发布',method: 'issue',iconCls: 'icon-Issue'},			
		{text: '提交',method: 'submit',iconCls: 'icon-Submit'},*/
		{text: '新建',method: 'create',iconCls: 'icon-Create'},
		{text: '打开',method: 'open',iconCls: 'icon-Open'},
		{text: '删除',method: 'delete',iconCls: 'icon-Delete',disabled:true},
		{text: '属性',method: 'property',iconCls: 'icon-Property',disabled:true},	
		{text: '停用',method: 'disable',iconCls: 'icon-disable',disabled:true},
        {text: '启用',method: 'enable',iconCls: 'icon-enable',disabled:true},
        {text: '↑',method: 'upSort',iconCls: '',disabled:true},
        {text: '↓',method: 'downSort',iconCls: '',disabled:true},
        {text: '默认设置',method: 'default',iconCls: 'icon-enable',disabled:true}
	],

	CM_JR_Record: [
				   {header: '名称',dataIndex: 'name',width:150},
				  /* {header: '版本号',dataIndex: 'versionNo',flex:1},*/
				   {header: '适用病种',dataIndex: 'diNameArray',hidden:true},	
				   {header: '适用病种',dataIndex: 'diNames',width:100},
				   {header: '状态id',dataIndex: 'statusCode',hidden:true},
				   {header: '状态',dataIndex: 'statusName',width:60},//dictionary: 'MRM07',
				   {header: '是否默认',dataIndex: 'defaultName',width:60},
				   {header: '医疗记录类型编码',dataIndex: 'mrTypeCode',hidden:true},
				   {header: '类型',dataIndex: 'mrTypeName',width:100},//MRM16
                   {header: '所属编码',dataIndex: 'ownerTypeCode',hidden:true},
	               {header: '所属',dataIndex: 'ownerName',width:100},
				   {header: '审签等级',dataIndex: 'signLevelCode',hidden:true},	
				   {header: '审签等级',dataIndex: 'signLevelName',width:100},
	               {header: '创建人',dataIndex: 'createUserName',width:100},
	               {header: '创建时间',dataIndex: 'crtTime',xtype: 'xapdatecolumn',width:150},
	               {header: '最后更新人',dataIndex: 'lastUpdateUserName',width:100},
	               {header: '最后更新时间',dataIndex: 'lastUpdateTime',xtype: 'xapdatecolumn',width:150},
	               {header: '描述',dataIndex: 'description',width:150},
	               {header: '模板id',dataIndex:'code',hidden:true},
	               {header: '模板文件id',dataIndex: 'filePk',hidden:true},
	               {header: '基础模板id',dataIndex: 'baseTemplateCode',hidden:true},
	               {header: '基础模板名字',dataIndex: 'baseTemplateName',hidden:true},
	               {header: 'xmlfilecd',dataIndex: 'xmlFilePk',hidden:true},
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