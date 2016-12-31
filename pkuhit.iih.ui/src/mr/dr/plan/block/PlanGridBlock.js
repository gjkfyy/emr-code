Ext.define('iih.mr.dr.plan.block.PlanGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: ['Xap.ej.element.grid.column.ActionColumn'],

	alias:'widget.plangridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        tools:[{
				xtype: 'xapbutton',
				text : '编辑',
				action: 'editRetrieval',
	            hidden: true,
				disabled: true
			},{
				xtype: 'xapbutton',
				text : '删除',
				action: 'deleteRetrieval',
	            hidden: true,
				disabled: true
			}
		],
        ifSelect : true,
        selectBy: 'retrievalCd',
		autoScroll:true,
		pageSize : 25,
		pageShow : true,
             
		CM_JR_Record: [      
	  			{ xtype:'xapactioncolumn',
					text:'操作',
					width: 100,
					retrievalStore: null,
					items: [
						{
							text:'编辑',
							handler: function(view,rowIndex,colIndex,e,item ,record) {
								var owner = this.up('planlistview');
								var editChain = owner.getActionChain("edit");
								editChain.execute({
									record:record
								});
							}
						},{
							text:'删除',
							handler: function(view,rowIndex,colIndex,e,item ,record) {
								var owner = this.up('planlistview');
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
						}
					]
				},
  				{ header: '检索编码', dataIndex: 'retrievalCd',field: 'textfield',type: 'string',hidden:true },
  				{ header: '方案所属', dataIndex: 'ownTpCd',field: 'textfield',type: 'string',width:150,hidden:true},
                { header: '检索科室', dataIndex: 'deptCd',field: 'textfield',type: 'string',width:120,hidden:true },
                { header: '负责人', dataIndex: 'responsibleCd',field: 'textfield',type: 'string',width:80,hidden:true },
  				{ header: '检索方案名称', dataIndex: 'retrievalNm',field: 'textfield',type: 'string',width:200},
  				{ header: '方案所属', dataIndex: 'ownTpNm',field: 'textfield',type: 'string',width:80},
                { header: '检索科室', dataIndex: 'deptNm',field: 'textfield',type: 'string',width:120 },
                { header: '负责人', dataIndex: 'responsibleNm',field: 'textfield',type: 'string',width:80 },
                { header: '检索方案关键字', dataIndex: 'retrievalKey',field: 'textfield',type: 'string',width:300 },
                { header: '备注', dataIndex: 'memo',field: 'textfield',type: 'string',flex:1}
        ]
    }],
    setData: function(data) {
        	var grid = this.down('xapgrid');
        	if(grid){
	        	var dataList = data.dataList;
	        	if(dataList){
	        		grid.setData(dataList);
	        	}
        	}
    	}  
})
