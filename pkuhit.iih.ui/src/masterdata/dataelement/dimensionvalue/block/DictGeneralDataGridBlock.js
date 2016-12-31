Ext.define('iih.masterdata.dataelement.dimensionvalue.block.DictGeneralDataGridBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

	alias:'widget.dictgeneraldatagridblock',
	
	layout: 'fit',
	border: 0,

    items:  [{
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'pkDictgendata',
		autoScroll:true,
		
		tools:[
				/*{
					xtype: 'xapcheckbox',
					boxLabel : '启用',
					checked:true,
					action: 'isActivated',
					padding:'0 0 0 0',
					disabled: true
				},*/{
					xtype: 'xapbutton',
					text: '新建',
					action: 'create',
					iconCls: 'icon-Create',
					disabled: true
				},
				{
					xtype: 'xapbutton',
					text: '编辑',
					action: 'edit',
					iconCls: 'icon-edit',
					disabled: true
				}/*,
				{
					xtype: 'xapbutton',
					text: '上移',
					action: 'changeUp',
					iconCls: 'icon-up',
					disabled: true
				},
				{
					xtype: 'xapbutton',
					text: '下移',
					action: 'changeDown',
					iconCls: 'icon-down',
					disabled: true
				},
				{
					xtype: 'xapbutton',
					text: '停用',
					action: 'stopped',
					iconCls: 'icon-disable',
					disabled: true
				}*/,
				{
					xtype: 'xapbutton',
					text: '删除',
					action: 'deleted',
					iconCls: 'icon-Delete',
					disabled: true
				}
			],
		CM_JR_Record: [
				{ header: '通用字典数据主键', dataIndex: 'dataElementValueCd',field: 'textfield',type: 'string' ,hidden:true  },
  				{ header: '通用字典分类外键', dataIndex: 'dataElementCd',field: 'textfield',type: 'string',hidden:true   },
  				{ header: '编码', dataIndex: 'valueCode',field: 'textfield',type: 'string',width:100},
                { header: '名称', dataIndex: 'valueDisplay',field: 'textfield',type: 'string',width:150 },
                { header: '注释', dataIndex: 'memo',field: 'textfield',type: 'string',width:250 }
        ]
    }],
	setData: function(data) {
    	var grid = this.down('xapgrid');
    	if(grid){
    		if(data){
	        	var dataList = data.dataList;
	        	if(dataList){
	        		grid.setData(dataList);
	        	}
	    	}else{
	    		grid.setData([]);
	    	}
		}
	}
})
