Ext.define('iih.mr.dr.plan.block.PlanGridBrowseBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: ['Xap.ej.element.grid.column.ActionColumn'],

	alias:'widget.plangridbrowseblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
       
        ifSelect : true,
        selectBy: 'retrievalCd',
		autoScroll:true,
		pageSize : 25,
		pageShow : true,
             
		CM_JR_Record: [      
  				{ header: '检索编码', dataIndex: 'retrievalCd',field: 'textfield',type: 'string',hidden:true },
  				{ header: '方案所属', dataIndex: 'ownTpCd',field: 'textfield',type: 'string',width:150,hidden:true},
                { header: '检索科室', dataIndex: 'deptCd',field: 'textfield',type: 'string',width:120,hidden:true },
                { header: '负责人', dataIndex: 'responsibleCd',field: 'textfield',type: 'string',width:80,hidden:true },
  				{ header: '检索方案名称', dataIndex: 'retrievalNm',field: 'textfield',type: 'string',width:150},
  				{ header: '方案所属', dataIndex: 'ownTpNm',field: 'textfield',type: 'string',width:150},
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
