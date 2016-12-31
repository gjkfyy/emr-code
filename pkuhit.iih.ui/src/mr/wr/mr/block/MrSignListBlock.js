Ext.define('iih.mr.wr.mr.block.MrSignListBlock',{
    extend : 'Xap.ej.block.FormBlock',
    
    requires: ['Xap.ej.element.tab.Panel',
               'Xap.ej.element.grid.Grid',
               'Xap.ej.element.grid.column.Date',
               'Xap.ej.element.grid.column.Number'],

    alias:'widget.mrsignlistblock',

    layout: 'fit',
    
    border:false,
    
    items:[{
        xtype:'xaptabpanel',
        layout: 'fit',
        border:false, 
        /*defaults:{
            xtype:'xapgrid',
            layout: 'fit',
            border:false,
            pageShow:true
        },*/
        items:[{
            title:'本人待审签一览',
            ifSelect : true,
            selectBy: 'mrPk',
            name:'waitPersonSign',
            xtype:'xapgrid',
            layout: 'fit',
            border:false,
            autoScroll:true,
    		pageSize : 25,
    		pageShow : true,
            selectBy: 'mrPk'
        },/*{
            title:'科室待审签一览',
            name:'waitDeptSign',
            xtype:'xapgrid',
            layout: 'fit',
            border:false,
            ifSelect : true,
            autoScroll:true,
    		pageSize : 25,
    		pageShow : true,
            selectBy: 'mrPk'
        },*/{
        	title:'科室待审签一览',
            border:false, 
            name:'waitDeptSign',
            xtype:'xappanel',
            layout: {
                type : 'vbox',
                align : 'stretch'
            },
            items:[{
            	xtype:'xapform',
            	height:50,
            	items:{
            		xtype:'xapcombobox',
					name:'waitDeptSignPatient',
					editable:false,
        			allOptions:true,
					padding:'10 0 10 20',
					fieldLabel:'患者',
					labelWidth:40,
					queryMode: 'local',
					displayField: 'patientName',
					valueField: 'patientId'
            	}
            },{
            	xtype:'xapgrid',
//	            layout: 'fit',
            	flex:1,
	            border:false,
	            name:'waitDeptSign',
	            ifSelect : true,
                selectBy: 'mrPk',
                autoScroll:true,
        		pageSize : 25,
        		pageShow : true,
	            CM_JR_Record:[
	            	{header: '床位',dataIndex: 'bedNo',field: 'textfield',type: 'string',flex:2},
			        {header: '姓名',dataIndex: 'patientName',field: 'textfield',type: 'string',flex:2},
			        {header: '性别',dataIndex: 'sexName',field: 'textfield',type: 'string',flex:1},
			        {header: '文书名称',dataIndex: 'name',alink:true,width:600},
			        {header: '文书状态',dataIndex: 'stateName',field: 'textfield',type: 'string',flex:2},
			        {header: '审签等级',dataIndex: 'signLvlNm',field: 'textfield',type: 'string',flex:2},
			        {header: '提交人',dataIndex: 'submitCd',field: 'textfield',type: 'string',flex:2},
			        {header: '提交时间',dataIndex: 'submitDate',width:120, xtype:'xapdatecolumn'},
			        {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '文书状态编码',dataIndex: 'statusCode',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '就诊编码',dataIndex: 'encounterPk',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '患者编码',dataIndex: 'patientId',field: 'textfield' ,type: 'string',hidden:true}
		        ]
            }]
        },{
            title:'本人已审签一览',
            border:false, 
            name:'alreadySign',
            xtype:'xappanel',
            layout: {
                type : 'vbox',
                align : 'stretch'
            },
            items:[{
            	xtype:'xapform',
            	height:50,
            	items:{
            		xtype:'xapcombobox',
					name:'patient',
					editable:false,
        			allOptions:true,
					padding:'10 0 10 20',
					fieldLabel:'患者',
					labelWidth:40,
					queryMode: 'local',
					displayField: 'patientName',
					valueField: 'patientId'
            	}
            },{
            	xtype:'xapgrid',
//	            layout: 'fit',
            	flex:1,
	            border:false,
	            name:'alreadySign',
	            ifSelect : true,
                selectBy: 'mrPk',
                autoScroll:true,
        		pageSize : 25,
        		pageShow : true,
	            CM_JR_Record:[
	            	{header: '床位',dataIndex: 'bedNo',field: 'textfield',type: 'string',flex:2},
			        {header: '姓名',dataIndex: 'patientName',field: 'textfield',type: 'string',flex:2},
			        {header: '性别',dataIndex: 'sexName',field: 'textfield',type: 'string',flex:1},
			        {header: '文书名称',dataIndex: 'name',alink:true,width:600},
			        {header: '文书状态',dataIndex: 'stateName',field: 'textfield',type: 'string',flex:2},
			        {header: '审签等级',dataIndex: 'signLvlNm',field: 'textfield',type: 'string',flex:2},
			        {header: '签名时间',dataIndex: 'doctorDate',flex:3, xtype:'xapdatecolumn'},
			        {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '文书状态编码',dataIndex: 'statusCode',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '就诊编码',dataIndex: 'encounterPk',field: 'textfield' ,type: 'string',hidden:true},
			        {header: '患者编码',dataIndex: 'patientId',field: 'textfield' ,type: 'string',hidden:true}
		        ]
            }]
        }]
    }],
    initComponent: function() {
        var tabItems = this.items[0].items;
        tabItems[0].CM_JR_Record = this.createGridColumn();
        tabItems[1].CM_JR_Record = this.createGridColumn();
        this.callParent();
    },
    createGridColumn: function() {
        var columnConfig = [
	        {header: '床位',dataIndex: 'bedNo',field: 'textfield',type: 'string',flex:2},
	        {header: '姓名',dataIndex: 'patientName',field: 'textfield',type: 'string',flex:2},
	        {header: '性别',dataIndex: 'sexName',field: 'textfield',type: 'string',flex:1},
	        {header: '文书名称',dataIndex: 'name',alink:true,width:600},
	        {header: '文书状态',dataIndex: 'stateName',field: 'textfield',type: 'string',flex:2},
	        {header: '提交人',dataIndex: 'submitCd',field: 'textfield',type: 'string',flex:2},
	        {header: '提交时间',dataIndex: 'submitDate',flex:3, xtype:'xapdatecolumn'},
	        {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true},
            {header: '文书状态编码',dataIndex: 'statusCode',field: 'textfield' ,type: 'string',hidden:true},
            {header: '就诊编码',dataIndex: 'encounterPk',field: 'textfield' ,type: 'string',hidden:true},
            {header: '患者编码',dataIndex: 'patientId',field: 'textfield' ,type: 'string',hidden:true}
        ];
        return columnConfig;
    },
    setData : function(data,gridName) {
//    	console.log('aaaaaaaaaaaaaaaaa');
//    	console.log(data);
        var grid = this.down('xapgrid[name='+gridName+']');
        var dataList = data.dataList;
        if(grid){
    		if(dataList){
		    	var totalList = {"total":data.total,"dataList":dataList};
		    	var pageSize = data.pageSize;
		    	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
		    		grid.setPageData(totalList);	//初始化赋值
		    	}else{
		    		grid.setData(dataList);	//翻页时赋值
		    	}
        	}else{
        		var totalList = {"total":data.total,"dataList":dataList};
        		grid.setPageData(totalList);
        	}
    	}/*
        if(data){
        	grid.setData(data);
        }else{
        	grid.setData({});
        }*/
    }
})