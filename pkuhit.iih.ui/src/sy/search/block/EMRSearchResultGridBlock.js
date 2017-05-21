Ext.define('iih.sy.search.block.EMRSearchResultGridBlock', {
	extend : 'Xap.ej.block.Block',

	requires : [ 'Xap.ej.element.grid.Grid',
			   		'Xap.ej.element.field.Checkbox',
			   		'Xap.ej.element.field.DateField',
			   		'Xap.ej.element.field.ComboBoxGrid',
					'Xap.ej.element.form.Form'],

	alias : 'widget.emrsearchresultgridblock',

	layout : {
		type : 'vbox',
		align : 'stretch'
	},

	items : [ {
		xtype : 'toolbar',
		autoScroll : true,
		width : '100%',
		margin : '0 0 0 0',
		height : 30,
		items : [ {
			text : '立即搜索',
			iconCls : 'icon-Search',
			handler:function(owner,tool){
                var view = this.up('searchcontentview');
                var chain = view.getActionChain('search');
                chain.execute({
                	pageNum:1,
                	pageSize:20
                });
            }
				
		}, {
			xtype : 'button',
			text : '清除条件',
			iconCls : 'icon-points',
			valign : 'left',
			action : 'clear'

		}, '->', {
			xtype : 'button',
			text : '导出结果至Excel',
			iconCls : 'icon-Excel',
			valign : 'right'

		}, {
			xtype : 'button',
			text : '保存当前搜索条件',
			iconCls : 'icon-save',
			valign : 'right'
		} ]
	}, {
		xtype : 'xapgrid',
		name : 'userList',
		colspan : 1,
		width : '100%',
		rownumShow : false,
		height : 470,
		pageShow : true,
		ifSelect : false,
		mode : 'simple',
		showHeaderCheckbox : false,
		checkboxShow : false,
		CM_JR_Record : [ {
			header : 'empId',
			dataIndex : 'patientId',
			field : 'textfield',
			type : 'string',
			hidden : true
		},{
			header : 'inpatientNo',
			dataIndex : 'inpatientNo',
			field : 'textfield',
			type : 'string',
			hidden : true
		}, {
			header : '姓名',
			dataIndex : 'patientName',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '卡号',
			dataIndex : 'xpianNo',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '就诊日期',
			dataIndex : 'admissionDate',
			field : 'textfield',
			xtype : 'xapdatecolumn',
			flex : 1
		}, {
			header : '来源',
			dataIndex : 'source',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '性别',
			dataIndex : 'sex',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '年龄',
			dataIndex : 'age',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '诊断',
			dataIndex : 'diagnose',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '治疗目标',
			dataIndex : 'therapeuticGoal',
			field : 'textfield',
			type : 'string',
			flex : 1
		}, {
			header : '手术方案',
			dataIndex : 'operationPlan',
			field : 'textfield',
			type : 'string',
			flex : 1
		} ]
	} ],
	
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	setData : function(data) {
		var grid = this.down('xapgrid[name=userList]');
		if (data) {
			var dataList = data.dataList;
			if (grid) {
				if (dataList) {

					// 记住上次选中行，若第一次加载则默认选中第一行
					if (dataList.length > 0 && grid.nodeId == null) {
						grid.nodeId = dataList[0][grid.selectBy];
					}

					var totalList = {
						"total" : data.total,
						"dataList" : dataList
					};
					var pageSize = data.pageSize;
					if (pageSize == undefined
							|| typeof (data.pageSize) == 'object') {
						grid.setPageData(totalList); // 初始化赋值
					} else {
						grid.setData(dataList); // 翻页时赋值
					}
				} else {
					var totalList = {
						"total" : data.total,
						"dataList" : dataList
					};
					grid.setPageData(totalList);
				}

			}
		}
	}
})
