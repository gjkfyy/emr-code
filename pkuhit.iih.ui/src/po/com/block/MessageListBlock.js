Ext.define('iih.po.com.block.MessageListBlock', {
    extend : 'Xap.ej.block.Block',

    requires: ['Xap.ej.element.tree.Tree',
               'Xap.ej.element.grid.column.ActionColumn',
               'Xap.ej.element.grid.column.Date'],

    alias:'widget.messagelistblock',

    layout: 'fit',
    
    border: 0,
    
    flex: 1,

    items: [{
        xtype:'xapgrid',
        layout: 'fit',
        border:false,
        checkboxShow : true,
        showHeaderCheckbox:true,
        pageShow:true,
        mode: 'multi',
        pageSize:20,
        flex:1,
        CM_JR_Record: [{
            header:'标识',
            dataIndex:'readFlag',
            align: 'center',
            renderer : function(value) {
                return (value == 0)?"<img src='css/images/message/letter.png' />":"<img src='css/images/message/letter_open.png' />";
            },
            width:70
        },{
            header:'重要性',
            renderer : function(value) {
                return (value == 1)?'重要':'一般';
            },
            dataIndex:'mesLevel',
            width:70
        },{
            header:'发送人',
            dataIndex:'sendUserName',
            renderer : function(value) {
                return (value == null)?'系统':value;
            },
            width:70
        },{
            header:'内容',
            dataIndex:'content',
            alink:true,
            flex:1
        },{
            header:'发送时间',
            dataIndex:'sendDate',
            xtype:'xapdatecolumn',
            width:120
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
                //altText:'去处理',
                text:'去处理',
                //icon:'css/images/icons/arrow_right.png',
                handler: function(grid, rowIndex, colIndex) {
                    var store = grid.getStore();
                    var rec = store.getAt(rowIndex); 
                    var view = grid.up('messageview');
                    grid.getSelectionModel().select(rowIndex);
                    var chain2 = view.getActionChain('read');
                    chain2.execute();
                    var chain1 = view.getActionChain('jump');
                    chain1.execute({
                        data:rec.raw
                    });
                },
                getClass : function(v,m,record) {
                    if(!record.raw.status){
                        return 'x-hidden';
                    }                           
                }
            }]
        },{
            dataIndex:'mesId',
            hidden:true
        },{
            dataIndex:'portalCd',
            hidden:true
        },{
            dataIndex:'menuCd',
            hidden:true
        },{
            dataIndex:'status',
            hidden:true
        },{
            dataIndex:'revisionCd',
            hidden:true
        },{
            dataIndex:'encounterSn',
            hidden:true
        }],
        listeners: {
            itemdblclick: function(grid, rec, item, index) {
                var view = grid.up('messageview');
                var chain = view.getActionChain('open');
                chain.execute({
                    msg: rec.data
                });
            },
            linkClick: function(rec) {
                var view = this.up('messageview');
                var chain = view.getActionChain('open');
                chain.execute({
                    msg: rec
                });
            }
        },
        tbar:[{
            xtype: "button",
            name: 'read',
            text: '已读',
            iconCls: 'icon-send',
            handler:function(btn,e){
                var win = this.up('window');
                var view = this.up('messageview');
                var grid = this.up('xapgrid');
                var record = grid.getSelectionModel().getSelection();
                if(record && record.length>0){
                    var chain = view.getActionChain('read');
                    chain.execute();
                }else{
                    XapMessageBox.warn('请选择消息！','',win);
                }
            }
        },{
            xtype: "button",
            name: 'delete',
            text: '删除',
            iconCls: 'icon-Delete',
            handler:function(btn,e){
                var win = this.up('window');
                var view = this.up('messageview');
                var grid = this.up('xapgrid');
                var record = grid.getSelectionModel().getSelection();
                if(record && record.length>0){
                    XapMessageBox.confirm2('是否确认删除选中的消息？',
                        function(btn, text){
                            if (btn == 'yes') {
                                var chain = view.getActionChain('delete');
                                chain.execute();
                            } 
                        },win
                    );
                }else{
                    XapMessageBox.warn('请选择消息！','',win);
                }
            }
        }]
    }]
});