Ext.define('iih.mr.wr.nmr.block.BatchDocListBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.FlowGrid',
    		   'Xap.ej.element.grid.column.Date'],

    alias:'widget.batchdoclistblock',

    layout: {
        type:'vbox',
        align: 'stretch'
    },
    items: [{
        title: '已书写文书',
        
        xtype: 'xapgrid',
        name: 'mrDocGrid',
        ifSelect : false,
        selectBy: 'mrPk',
        flex:1, 
        pageSize : 20,
        checkboxShow:true,
		mode:'simple',
		showHeaderCheckbox : true,
		pageShow : false,
        CM_JR_Record: [
             {header: '文书状态',dataIndex: 'statusName',field: 'textfield' ,type: 'string',width:60},
             {header: '文书名称',dataIndex: 'name',alink:true,field: 'textfield' ,type: 'string',flex:1/*,renderer:handler*/},
             {header: '起草人',dataIndex: 'createUserName',field: 'textfield' ,type: 'string',width:80},
             {header: '业务时间',dataIndex: 'bizTime',xtype: 'xapdatecolumn',format:'Y-m-d H:i',width:140,hidden:true},
             {header: '审签等级',dataIndex: 'signLevelName',field: 'textfield' ,type: 'string',width:80},
             {header: '审签医师',dataIndex: 'masterDoctorName',field: 'textfield' ,type: 'string',width:80,hidden:true},
             {header: '最后更新人',dataIndex: 'lastUpdateUserName',field: 'textfield' ,type: 'string',width:80},
             {header: '最后更新时间',dataIndex: 'lastUpdateTime',xtype: 'xapdatecolumn',width:140},
             {header: '模板编码',dataIndex: 'templeCode',field: 'textfield' ,type: 'string',hidden:true},
             {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true,flex:1}
             //{header: '需整改缺陷数',dataIndex: 'defectCount',field: 'textfield',type: 'string',width:80}
        ],
        autoScroll:true,
        height:500
    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid[name=mrDocGrid]');
        var dataList=data.mrs;
        if(grid){
        	if(dataList){
		    	var totalList = {"total":data.total,"dataList":dataList};
		    	var pageSize = data.pageSize;
		    	if(!pageSize){
		    		grid.setPageData(totalList);	//初始化赋值
		    	}else{
		    		grid.setData(dataList);	//翻页时赋值
		    	}
        	}
        	
        }
    }
});

