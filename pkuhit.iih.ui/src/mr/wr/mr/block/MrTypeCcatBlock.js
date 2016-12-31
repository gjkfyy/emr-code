Ext.define('iih.mr.wr.mr.block.MrTypeCcatBlock',{
	extend : 'Xap.ej.block.Block',

	requires: [	           
			'Xap.ej.element.grid.Grid'
	],
	
	alias:'widget.mrtypeccatblock',
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	layout: 'fit',
    
    border: 0,
    
    flex: 1,
    
	items:[{
	    xtype:'xapgrid',
        layout: 'fit',
        border:false,
        //pageShow:true,
        //pageSize:25,
        ifSelect:true,
        selectBy: 'code',
        CM_JR_Record: [
               {header: '名称',dataIndex: 'name',width:300},
               {
                   header: '是否续打',
                   dataIndex: 'continuePrintF',
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
                   header: '医护标记',
                   dataIndex: 'dctNsF',
                   width:80,
                   renderer:function(value,metaData,record){
                       if(value == 1){
                           return '医';
                       }else{
                           return '护';
                       }
                   }
               },
               {header: '顺序',dataIndex: 'sortNo',width:80},
               {header: '描述',dataIndex: 'description',flex:1},
               {dataIndex: 'code',hidden:true}
        ],
        tbar:[
               {
                   text: '新建',
                   method: 'create',
                   iconCls: 'icon-Create',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrtypeccatview');
                           var chain = view.getActionChain('open');
                           chain.execute();
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeccatview');
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
                           var view = this.up('mrtypeccatview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               var chain = view.getActionChain('open');
                               chain.execute({
                                   mrtpccat:rec
                               });
                           }else{
                               XapMessageBox.warn('请选择病历文书类型组！','',view);
                           }
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeccatview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           var chain = view.getActionChain('open');
                           chain.execute({
                               mrtpccat:rec
                           });
                       }else{
                           XapMessageBox.warn('请选择病历文书类型组！','',view);
                       }
                   }*/
               },
               {
                   text: '删除',
                   method: 'delete',
                   iconCls: 'icon-Delete',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrtypeccatview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               XapMessageBox.confirm2('是否确认删除选中的病历文书类型组？',
                                   function(btn, text){
                                       if (btn == 'yes') {
                                           var chain = view.getActionChain('delete');
                                           chain.execute({
                                               mrtpccat:rec
                                           });
                                       } 
                                   }
                               );
                           }else{
                               XapMessageBox.warn('请选择病历文书类型组！','',view);
                           }
                       }    
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrtypeccatview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           XapMessageBox.confirm2('是否确认删除选中的病历文书类型组？',
                               function(btn, text){
                                   if (btn == 'yes') {
                                       var chain = view.getActionChain('delete');
                                       chain.execute({
                                           mrtpccat:rec
                                       });
                                   } 
                               }
                           );
                       }else{
                           XapMessageBox.warn('请选择病历文书类型组！','',view);
                       }
                   }*/    
               }
        ]
	}],
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	setListData: function(data) {
	    var grid = this.down('xapgrid');
        if(grid)
            grid.setData(data);
	}

})