Ext.define('iih.po.assistant.block.TodoListBlock',{
    extend : 'Xap.ej.block.Block',

    requires : [
        'Xap.ej.element.grid.Grid',
        'Xap.ej.element.grid.column.ActionColumn',
        'Xap.ej.element.grid.column.Date',
        'Xap.ej.element.grid.column.Number'
    ],
    
    alias : 'widget.todolistblock',
    
    layout: 'fit',
    
    items:  [{
        xtype:'xapgrid',
        overflowX:'auto',
        plugins: [
          Ext.create('Ext.grid.plugin.CellEditing', {
              clicksToEdit: 1
          })
        ],
        CM_JR_Record: [
          {xtype:'xapactioncolumn',
                text:'操作',
                layout: {
                    type: 'hbox',
                    align: 'middle'
                },
                width:60,
                defectStore: null,
                items: [
                    {
                        text:'完成',
                        getClass : function(v,m,record) {
                            if(record.data.taskStaCd==IMER_CONSTANT.TASK_STATUS_CD_3){
                                return 'x-hidden';
                            }                           
                        },
                        handler: function(view,rowIndex,colIndex,e,item ,record) {
                            var taskView = view.up('todolistview');
                            var chain = taskView.getActionChain('complete');
                            chain.execute({
                                data:record.data
                            });
                        }   
                    }
                ]
            },
            {dataIndex:'taskPk',hidden:true},
            {dataIndex:'qaFltPk',hidden:true},
            {header:'任务/问题描述',dataIndex:'des',width:150},
            {dataIndex:'segTpCd',hidden:true},
            {header:'段落名称',dataIndex:'segTpNm',width:90},
            {dataIndex:'taskStaCd',hidden:true},
            {header:'任务状态',dataIndex:'taskStaNm',width:80},
            {dataIndex:'fltFromCd',hidden:true},
            {header:'业务活动',dataIndex:'fltFromNm',width:80},
            {dataIndex:'sbmtDeptCd',hidden:true},
            {header:'提出科室',dataIndex:'sbmtDeptNm',width:100},
            {dataIndex:'sbmtUserId',hidden:true},
            {header:'提出人',dataIndex:'sbmtUserNm',width:80},
            {header:'提出时间',dataIndex:'sbmtTime',xtype:'xapdatecolumn',width:100},
            {header:'截止时间',dataIndex:'deadline',xtype:'xapdatecolumn',width:100},
            {header:'整改要求',dataIndex:'rfmReq',width:150},
            {header:'整改说明',dataIndex:'rfmDes',width:180,
                editor: new Ext.form.TextField({
                    allowBlank: false,
                    listeners: {
                        focus:function(me){
                            me.up('xapgrid').fireEvent('textfieldfocus');
                        },
                        blur: function(me){
                            me.up('xapgrid').fireEvent('textfieldblur', me.value);
                        }
                    }
                })  
            }
        ]
    }],

    setData: function(data) {
        var grid = this.down('xapgrid');
        if(data)
            grid.setData(data);
        else
            grid.setData({});
    }
});
