Ext.define('iih.mr.tm.xml.block.FormXmlDataButtomBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.field.TextField'
	           ],
	
	alias:'widget.formxmldatabuttomblock',
	layout: 'fit',
	items:[{
    	xtype:'xapgrid',
    	flex:1,
        border:false,
        name:'dataResourceGrid',
        ifSelect : true,
        selectBy: 'dataElementCd',
        autoScroll:true,
		pageSize : 25,
		pageShow : false,
        CM_JR_Record:[
        	{header: '数据元标示符',dataIndex: 'dataElementCd',field: 'textfield',type: 'string',flex:0.4},
	        {header: '数据元名称',dataIndex: 'dataElementNm',field: 'textfield',type: 'string',flex:0.6}
        ]
    }],

	setData: function(data) {
        var grid = this.down('xapgrid[name=dataResourceGrid]');
        var dataList = data.dataList;
        /*if(grid){
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
    	}*/
        if(dataList){
        	grid.setData(dataList);
        }else{
        	grid.setData({});
        }
    },
    getData: function() {
        return null;
    },
    initComponent: function() {
        this.callParent();
    }
    
})