Ext.define('iih.mr.qa.qa_work_assistant.block.DiagnosisHelperBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.column.ActionColumn'],

    alias:'widget.diagnosishelperblock',

    layout: 'fit',
    border: false,

    items: [{
        title: '',
		xtype: 'xapgrid',
		name: 'diagnosisHelperBlock',
//		checkboxShow : true,
//		showHeaderCheckbox:true,
		mode: 'SIMPLE',
		sortableColumns : false,
//        autoScroll:true,
        //height:250,
        CM_JR_Record : [
        	{header : '诊断类型',dataIndex : 'diTpNm',width:120},
        	{header : '诊断名称',dataIndex : 'diNm',width:220},
        	{header : '诊断编码',dataIndex : 'diCd',width:120},
        	{header : '诊断描述',dataIndex : 'addInfo',flex:1},
        	{header : '诊断日期',dataIndex : 'diTime',xtype: 'xapdatecolumn',width:150},
        	{header : '治疗结果编码',dataIndex : 'trtRstCd',width:150},
        	{header : '诊断类型编码',dataIndex : 'diTpCd',hidden:true,}
    	]
    }],
    
    setData: function(data) {
		var grid = this.down('xapgrid');
		if(grid)
		    grid.setData(data);
	},
    getData: function() {
        return null;
    }
});