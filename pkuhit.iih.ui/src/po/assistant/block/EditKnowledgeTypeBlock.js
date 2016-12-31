Ext.define('iih.po.assistant.block.EditKnowledgeTypeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],

	alias:'widget.editknowledgetypeblock',

	header:false,
	items:[{
        xtype: 'xapgrid',
        border:false,
        tbar:[
        	{xtype:'button'/*,iconCls: 'icon-Create'*/,text:'新建',method: 'create'},
            {xtype:'button'/*,iconCls: 'icon-Property'*/,text:'编辑',method: 'edit'},
            {xtype:'button'/*,iconCls: 'icon-Delete'*/,text:'删除',method: 'delete'},
            {xtype:'button'/*,iconCls: 'icon-Delete'*/,text:'刷新',method: 'fresh'}
        ],
        autoScroll:true,
        CM_JR_Record: [
             {header: '类别编码',dataIndex: 'fragmentTplTypeCd',field: 'textfield' ,type: 'string',hidden:true,flex:1},
             {header: '类别名称',dataIndex: 'fragmentTplTypeNm',field: 'textfield' ,type: 'string',flex:1},
        	 {dataIndex: 'useCount',field: 'textfield' ,type: 'string',hidden:true,flex:1}
        ],
        height:239,
        plugins:[
        	Ext.create('Ext.grid.plugin.CellEditing',{
        		//clicksToEdit:1
        	})
        ]
    }],   
    buttons:[{
        xtype: "button",
        name: 'save',
        method:'save',
        text: '保存'    
    },{
        xtype: "button",
        name: 'close',
        method:'close',
        text: '关闭'    
    }],
	setData: function(data) {
		var grid = this.down('xapgrid');
        if(data){
        	grid.setData(data);
        }else{
        	grid.setData({});
        }
	}
})

