Ext.define('iih.mr.wr.mr.block.MrDocListBlock',{
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.grid.FlowGrid',
    		   'Xap.ej.element.grid.column.Date'],

    alias:'widget.mrdoclistblock',

    layout: {
        type:'vbox',
        align: 'stretch'
    },

    items: [{
        title: '已书写文书',
        
        xtype: 'xapgrid',
        name: 'mrDocGrid',
        ifSelect : true,
        selectBy: 'mrPk',
        flex:1,

        tbar:[{xtype:'button',iconCls: 'icon-Create',text:'新建',method: 'create',disabled:true},
              {xtype:'button',iconCls: 'icon-Open',text:'打开',method: 'open'},
              {xtype:'button',iconCls: 'icon-Delete',text:'删除',disabled:true,method: 'delete'},
              {xtype:'button',iconCls: 'icon-archive',text:'属性',method: 'property'},
              {xtype:'button',iconCls: 'icon-MergerShow',text:'病程合并',method: 'merger'},
//              {xtype:'button',iconCls: 'icon-Property',text:'模板信息',method: 'templateProperty'},
              {xtype:'button',text:'完成书写',method: 'finish',hidden:true}
        ],
             
        CM_JR_Record: [
             {header: '文书状态',dataIndex: 'statusName',field: 'textfield' ,type: 'string',width:100},
             {header: '文书名称',dataIndex: 'name',alink:true,field: 'textfield' ,type: 'string',flex:1/*,renderer:handler*/},
             {header: '起草人',dataIndex: 'createUserName',field: 'textfield' ,type: 'string',width:80},
             {header: '业务时间',dataIndex: 'bizTime',xtype: 'xapdatecolumn',format:'Y-m-d H:i',width:140},
             {header: '审签等级',dataIndex: 'signLevelName',field: 'textfield' ,type: 'string',width:80},
             {header: '审签医师',dataIndex: 'masterDoctorName',field: 'textfield' ,type: 'string',width:80},
             {header: '最后更新人',dataIndex: 'lastUpdateUserName',field: 'textfield' ,type: 'string',width:80},
             {header: '最后更新时间',dataIndex: 'lastUpdateTime',xtype: 'xapdatecolumn',width:140},
             {header: '模板编码',dataIndex: 'templeCode',field: 'textfield' ,type: 'string',hidden:true},
             {header: '文书ID',dataIndex: 'mrPk',field: 'textfield' ,type: 'string',hidden:true,flex:1}
             //{header: '需整改缺陷数',dataIndex: 'defectCount',field: 'textfield',type: 'string',width:80}
        ]
    },{
        title: '待书写文书',
        
        xtype: 'xapgrid',
        name: 'taskGrid',
        ifSelect : true,
        selectBy: 'taskId',
        
        height:220,
        
        CM_JR_Record: [{
            header:'文书类型',
            dataIndex:'mrTpNm',
            width:150
        },{
            header:'任务描述',
            dataIndex:'memo',
            flex:1
        },{
            header:'创建时间',
            dataIndex:'beginTime',
            xtype:'xapdatecolumn',
            width:130
        },{
            header:'截止时间',
            dataIndex:'endTime',
            xtype:'xapdatecolumn',
            width:130
        },{
            header:'剩余时间',
            dataIndex:'surplusTime',
            width:100,
            renderer:function(val,cellmeta){
                if(val && val<0)
                    return '<span style="color:red;">' + val + '</span>';
                else
                    return val;
            }
        },{
            xtype:'xapactioncolumn',
            text:'操作',
            layout: {
                type: 'hbox',
                align: 'middle'
            },
            width:60,
            defectStore: null,
            items:[{
                text:'处理',
                handler: function(grid, rowIndex, colIndex) {
                    var view = grid.up('mrdoclistview');
                    var store = grid.getStore();
                    var rec = store.getAt(rowIndex); 
                    var docSn = rec.data.docSn;
                    if(docSn){
                        var docGrid = view.down('xapgrid[name=mrDocGrid]');
                        var docStore = docGrid.getStore();
                        var docRec = docStore.findRecord('mrPk',docSn);
                        docGrid.getSelectionModel().select(docRec);
                        var chain = view.getActionChain('open');
                        chain.execute();
                    }else{
                        var chain = view.getActionChain('create');
                        chain.execute({
                            mrTpCd:rec.raw.mrTpCd,
                            mrTpCcatCd:rec.raw.mrTpCcatCd
                        });
                    }
                },
                getClass : function(v,m,record) {
                    if(record.raw.status=='XAPM20.02'){
                        return 'x-hidden';
                    }                           
                }
            }]
        },{
            dataIndex:'taskId',
            hidden:true
        },{
            dataIndex:'encounterSn',
            hidden:true
        },{
            dataIndex:'taskTypeCd',
            hidden:true
        },{
            dataIndex:'docSn',
            hidden:true
        }],
        listeners: {
            itemdblclick: function(grid, rec, item, index) {
            }
        }
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

