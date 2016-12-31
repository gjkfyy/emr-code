Ext.define('iih.mr.qa.dept_qa_auto_search.block.QaMrDocListBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.FlowGrid',
    		   'Xap.ej.element.grid.column.Date'],

    alias:'widget.qamrdoclistblock',

    height:500,  
    
    layout: {
        type:'vbox',
        align: 'stretch'
    },

    items: [{    
        xtype: 'xapgrid',
        name: 'mrDocGrid',
        autoScroll:true,
        ifSelect : true,
        selectBy: 'mrPk',
        height:470,  
        CM_JR_Record: [
             {header: '文书状态',dataIndex: 'statusName',field: 'textfield' ,type: 'string',width:100},
             {header: '文书名称',dataIndex: 'name',field: 'textfield' ,type: 'string',flex:1/*,renderer:handler*/},
             {header: '起草人',dataIndex: 'createUserName',field: 'textfield' ,type: 'string',width:80},
             {header: '创建时间',dataIndex: 'bizTime',xtype: 'xapdatecolumn',format:'Y-m-d H:i',width:140},
             {header: '提交时间',dataIndex: 'logicSubmitTime',xtype: 'xapdatecolumn',format:'Y-m-d H:i',width:140},//逻辑提交时间
             {header: '模板编码',dataIndex: 'templeCode',field: 'textfield' ,type: 'string',hidden:true},
             {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true,flex:1}
        ]
    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid[name=mrDocGrid]');
        if(data){
        	grid.setData(data);
        }else{
        	grid.setData({});
        }
    }
});

