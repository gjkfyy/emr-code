Ext.define('iih.mr.wr.nsv.block.NurScoreGridListBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [
        'Xap.ej.element.grid.Grid',  
        'Xap.ej.element.grid.column.ActionColumn'
    ],

    alias:'widget.nmrgridlistblock',

   // layout: 'fit',

    items: [{
        title: '护理模板一览',
        
        //maxHeight: 800,
        
        xtype: 'xapgrid',
        
        CM_JR_Record: [
           {header: '模板id',dataIndex: 'code',hidden:true},
           {header: '文件主键',dataIndex: 'filePk',hidden:true},
           {header: '医疗记录类型编码',dataIndex: 'mrTypeCode',hidden:true},
//           {header: '模板标准编码',dataIndex: 'mrTplKc',hidden:true},
           {header: '医疗记录类型名称',dataIndex: 'mrTypeName',hidden:true},
           {header: '护理模板名称',dataIndex: 'name',field: 'textfield',type: 'string',flex:1},
           {header: '适用病种',dataIndex: 'diNames',field: 'textfield',type: 'string',width:150},
           {header: '所属',dataIndex: 'ownerName',field: 'textfield',type: 'string',width:150},
           {header: '审签级别编码',dataIndex: 'signLevelCode',hidden:true},
          // {header: '审签级别',dataIndex: 'signLevelName',field: 'textfield',type: 'string',width: 150}
        ],
        autoScroll:true,
        height:315
    }],

    setData: function(data) {
        var grid = this.down('xapgrid');
        if(grid){
        	grid.setData(data);
        }
    }
});