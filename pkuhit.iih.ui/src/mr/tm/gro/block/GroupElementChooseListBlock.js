Ext.define('iih.mr.tm.gro.block.GroupElementChooseListBlock',{
	extend : 'Xap.ej.element.grid.Grid',
	requires: [	           
		'Xap.ej.block.LayeredBlock',  
	    'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.groupelementchooselistblock',	
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	
	layout: 'fit',
	checkboxShow : true,
	mode: 'single',//simple点击行起作用，multi点击checkbox起作用
	//title: '组合元素一览',
	ifSelect:true,
	
	tbar:[
		{text: '打开',method: 'open',iconCls: 'icon-Open'},
		{text: '插入',method: 'through'},
		{text: '取消',method: 'cancel'},
	],

	CM_JR_Record: [
				   /*{dataIndex: 'canOpen',hidden:true},
				   {dataIndex: 'canThrough',hidden:true},*/
	               
	               {header: '组合元素id',dataIndex: 'code',hidden:true},
	               {header: '组合元素文件id',dataIndex: 'filePk',hidden:true},
				   {header: '分类',dataIndex: 'typeName',width:150},
				   {header: '名称',dataIndex: 'name',width:150},
				   {header: '版本号',dataIndex: 'versionNo',width:50},
				   
				   {header: '状态id',dataIndex: 'typeCode',hidden:true},			   
				   {header: '状态',dataIndex: 'statusName',width:150},				   
                   //{header: '类型',dataIndex: 'mrTypeName',dictionary: 'MRM003',flex:1},
	               {header: '所属',dataIndex: 'ownerTypeName',width:150},
	               
	               {header: '创建人',dataIndex: 'crtByNm',width:50},
	               {header: '创建时间',dataIndex: 'crtTime',width:150},
	               {header: '发布人',dataIndex: 'pubEmpNm',width:50},
	               {header: '发布时间',dataIndex: 'pubTime',width:150},
	               {header: '描述',dataIndex: 'description',width:150} 
	]
})