Ext.define('iih.mr.qa.qa_divide_level.block.QaItmWorkBlock',{
	extend : 'Xap.ej.block.FormBlock',

	alias:'widget.qaitmworkblock',

	requires: ['iih.mr.qa.qa_divide_level.view.QaDivideLevelView',
				'iih.mr.qa.qa_divide_level.view.QaItmFstView',
				'iih.mr.qa.qa_divide_level.view.QaItmSndView',
				'iih.mr.qa.qa_divide_level.view.QaItmView'],
	layout: 'fit',
	border: 0,
	items: [{
        xtype:'xaptabpanel',
        layout: 'fit',
        border:false, 
        items:[{
            title:'病案等级设置',
            groupType:1,
            name:'qadividelevel',
            xtype:'xappanel',
            layout: 'fit',
            items:[{
            	xtype:'qadividelevelview'
            }]
        },{
            title:'一级分类',
            name:'qaitmfst',
            xtype:'xappanel',
            layout: 'fit',
            groupType:2,
            items:[{
            	xtype:'qaitmfstview'
            }]
        },{
            title:'二级分类',
            name:'qaitmsnd',
            xtype:'xappanel',
            layout: 'fit',
            groupType:3,
            items:[{
            	xtype:'qaitmsndview'
            }]
        },{
            title:'质控项目设置',
            name:'qaitm',
            xtype:'xappanel',
            layout: 'fit',
            groupType:4,
            items:[{
            	xtype:'qaitmview'
            }]
        }]
    }],
    
    setData : function(data) {/*
    	var grid;
    	if(data.groupType == '1'){
    		 grid = this.down('xapgrid[name=waitSignGrid]');
    	}else if(data.groupType == '2'){
    		 grid = this.down('xapgrid[name=alreadySignGrid]');
    	}
    	var dataList = data.dataList;
    	if(dataList){
        	var totalList = {"total":data.total,"dataList":dataList};
        	var pageSize = data.pageSize;
        	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
        		grid.setPageData(totalList);
	    	}else{
	    		grid.setData(dataList);
	    	}
        }else{
        	var totalList = {"total":data.total,"dataList":dataList};
        	grid.setPageData(totalList);
        }
    */}
})