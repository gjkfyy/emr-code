Ext.define('iih.mr.wr.mr.block.MrTypeListBlock',{
	extend : 'Xap.ej.block.Block',

	requires: [	           
			'Xap.ej.element.grid.Grid'
	],
	
	alias:'widget.mrtypelistblock',
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	layout: 'fit',
    
    border: 0,
    
    flex: 1,
    
	items:[{
	    xtype:'xapgrid',
        layout: 'fit',
        //pageShow:true,
        //pageSize:25,
        ifSelect:true,
        selectBy: 'code',
        CM_JR_Record: [
               {header: '名称',dataIndex: 'name',width:200},
               {
                   header: '就诊类型',
                   dataIndex: 'encounterTypeName',
                   width:120
               },
               {header: '审签级别',dataIndex: 'signLevelName',width:150},
               {
                   header: '是否单文书',
                   dataIndex: 'onlyF',
                   width:80,
                   renderer:function(value,metaData,record){
                       if(value == 1){
                           return FuiLocale.get('messagebox', 'yes');
                       }else{
                           return FuiLocale.get('messagebox', 'no');
                       }
                   }
               },
               {
                   header: '是否换页打印',
                   dataIndex: 'newPageF',
                   width:90,
                   renderer:function(value,metaData,record){
                       if(value == 1){
                           return FuiLocale.get('messagebox', 'yes');
                       }else{
                           return FuiLocale.get('messagebox', 'no');
                       }
                   }
               },
               {
                   header: '非创建本人修改',
                   dataIndex: 'permitF',
                   width:90,
                   renderer:function(value,metaData,record){
                       if(value == 1){
                           return FuiLocale.get('messagebox', 'yes');
                       }else{
                           return FuiLocale.get('messagebox', 'no');
                       }
                   }
               },
               {header: '顺序',dataIndex: 'sortNo',width:60},
               {header: '描述',dataIndex: 'description',flex:1},
               {header: '质控标记',dataIndex: 'memo',width:70},
               {dataIndex: 'code',hidden:true},
               {dataIndex: 'signLevelCode',hidden:true}
        ],
        tbar:[
               {
                   text: '新建',
                   method: 'create',
                   iconCls: 'icon-Create',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrtypeview');
                           var chain = view.getActionChain('open');
                           chain.execute();
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeview');
                       var chain = view.getActionChain('open');
                       chain.execute();
                   }*/
               },
               {
                   text: '编辑',
                   method: 'edit',
                   iconCls: 'icon-edit',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrtypeview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               var chain = view.getActionChain('open');
                               chain.execute({
                                   mrtp:rec
                               });
                           }else{
                               XapMessageBox.warn('请选择病历文书类型！','',view);
                           }
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           var chain = view.getActionChain('open');
                           chain.execute({
                               mrtp:rec
                           });
                       }else{
                           XapMessageBox.warn('请选择病历文书类型！','',view);
                       }
                   }*/
               },
               {
                   text: '删除',
                   method: 'delete',
                   iconCls: 'icon-Delete',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrtypeview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               XapMessageBox.confirm2('是否确认删除选中的病历文书类型？',
                                   function(btn, text){
                                       if (btn == 'yes') {
                                           var chain = view.getActionChain('delete');
                                           chain.execute({
                                               mrtp:rec
                                           });
                                       } 
                                   }
                               );
                           }else{
                               XapMessageBox.warn('请选择病历文书类型！','',view);
                           }
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           XapMessageBox.confirm2('是否确认删除选中的病历文书类型？',
                               function(btn, text){
                                   if (btn == 'yes') {
                                       var chain = view.getActionChain('delete');
                                       chain.execute({
                                           mrtp:rec
                                       });
                                   } 
                               }
                           );
                       }else{
                           XapMessageBox.warn('请选择病历文书类型！','',view);
                       }
                   }*/
               }
        ]
	}],
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	setGridData: function(data) {
	}

})