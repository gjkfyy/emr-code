Ext.define('iih.mr.dr.retrieval.block.DataRetrievalGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.dataretrievalgridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'qaPk',
		autoScroll:true,
		pageSize : 25,
		pageShow : true,
             
		CM_JR_Record: [
  				{ header: '检索编码', dataIndex: 'retrievalCd',field: 'textfield',type: 'string',hidden:true },
  				{ header: '病案号', dataIndex: 'amrNo',field: 'textfield',type: 'string',width:100},
                { header: '患者姓名', dataIndex: 'paNm',field: 'textfield',type: 'string',width:100 },
                { header: '性别', dataIndex: 'sexName',field: 'textfield',type: 'string',width:80 },
                { header: '年龄', dataIndex: 'age',field: 'textfield',type: 'string',width:80 },
                { header: '所在科室', dataIndex: 'currentDeptName',field: 'textfield',type: 'string',width:120 },
                { header: '主诊断', dataIndex: 'currentMainDiagnosisName',field: 'textfield',type: 'string',width:80 },
                { header: '入院时间', dataIndex: 'currentDeptIntoTime',xtype: 'xapdatecolumn',width:120 },
                { header: '出院时间', dataIndex: 'finishTime',xtype: 'xapdatecolumn',width:120 },
                { header: '出院病情', dataIndex: 'illStatusName',field: 'textfield',type: 'string',width:80 },
                { header: '备注', dataIndex: 'memo',field: 'textfield',type: 'string',flex:1}
        ]
    }],
    setData: function(data) {
        	var grid = this.down('xapgrid');
        	var dataList = '';
        	grid.setData(dataList);
    	}  
})
