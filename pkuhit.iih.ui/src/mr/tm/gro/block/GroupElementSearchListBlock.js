Ext.define('iih.mr.tm.gro.block.GroupElementSearchListBlock',{
	extend : 'Xap.ej.element.grid.Grid',
	requires: [	           
		'Xap.ej.block.LayeredBlock',  
	    'Xap.ej.element.grid.column.ActionColumn'
	],
	
	alias:'widget.groupelementsearchlistblock',	
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	layout: 'fit',
	
	checkboxShow : true,
	
	//simple点击行起作用，multi点击checkbox起作用
	mode: 'simple',

	//title: '组合元素列表',

	ifSelect:true,
	
	tbar:[
	      { 
	        xtype: "xapcombobox",
	        name: 'groupElementStatCd',
	        allOptions:true,
	        editable: false,
	        fieldLabel: '',
	        dictionary:'MRM05',
	        emptyText: "状态查询"
        },
		{text: '新建',method: 'create',iconCls: 'icon-Create'},
		{text: '升级',method: 'upgrade'},
		{text: '打开',method: 'open',iconCls: 'icon-Open'},
		{text: '删除',method: 'delete',iconCls: 'icon-Delete'},
		{text: '属性',method: 'property',iconCls: 'icon-Property'},	
		{text: '提交',method: 'submit',iconCls: 'icon-Submit'},
		{text: '审核通过',method: 'verify'},
		{text: '驳回',method: 'reject'},
		{text: '停用',method: 'disable',iconCls: 'icon-disable'},
        {text: '启用',method: 'enable',iconCls: 'icon-enable'}
	],

	CM_JR_Record: [

	    		   {dataIndex: 'canUpdate',hidden:true},
	               {dataIndex: 'canDelete',hidden:true},
	    		   {dataIndex: 'canSubmit',hidden:true},
	    		   {dataIndex: 'canUpgrade',hidden:true},
	    		   {dataIndex: 'canReject',hidden:true},
	    		   {dataIndex: 'canStop',hidden:true},
	    		   {dataIndex: 'canActivated',hidden:true},
	    		   {dataIndex: 'canReview',hidden:true},
	    		   
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