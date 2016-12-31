Ext.define('iih.mr.wr.mr.block.MrShareElementBlock',{
	extend : 'Xap.ej.block.Block',

	requires: [	           
			'Xap.ej.element.grid.Grid'
	],
	
	alias:'widget.mrshareelementblock',
	
	mixins : ['Xap.ej.block.LayeredBlock'],
	
	layout: 'fit',
    
    border: 0,
    
    flex: 1,
    
	items:[{
	    xtype:'xapgrid',
        layout: 'fit',
        border:false,
        pageShow:true,
        pageSize:25,
        ifSelect:true,
        selectBy: 'mrShareElementCd',
        CM_JR_Record: [
               {header: '名称',dataIndex: 'nm',width:300},
               /*{header: '分类编码',dataIndex: 'category',width:300},*/
               {
                   header: '宏元素标识',
                   dataIndex: 'macroFlag',
                   width:80,
                   renderer:function(value,metaData,record){
                       if(value == 1){
                           return FuiLocale.get('messagebox', 'yes');
                       }else{
                           return FuiLocale.get('messagebox', 'no');
                       }
                   }
               },
               {header: '描述',dataIndex: 'des',flex:1},
               {dataIndex: 'mrShareElementCd',hidden:true}
        ],
        tbar:[
               {
                   text: '新建',
                   method: 'create',
                   iconCls: 'icon-Create',
                   listeners:{
                       click: function(btn,e){
                           var view = this.up('mrshareelementview');
                           var chain = view.getActionChain('open');
                           chain.execute();
                       }
                   }/*
                   handler:function(btn,e){
                       var view = this.up('mrshareelementview');
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
                           var view = this.up('mrshareelementview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               var chain = view.getActionChain('open');
                               chain.execute({
                                   data:rec
                               });
                           }else{
                               XapMessageBox.warn('请选择共享元素！','',view);
                           }
                       }
                   }
                   /*handler:function(btn,e){
                       var view = this.up('mrshareelementview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           var chain = view.getActionChain('open');
                           chain.execute({
                               data:rec
                           });
                       }else{
                           XapMessageBox.warn('请选择共享元素！','',view);
                       }
                   }*/
               },
               {
                   text: '删除',
                   method: 'delete',
                   iconCls: 'icon-Delete',
                   listeners:{
                       click:function(btn,e){
                           var view = this.up('mrshareelementview');
                           var grid = view.down('xapgrid');
                           var record = grid.getSelectionModel().getSelection();
                           if(record && record.length>0){
                               var rec = record[0].raw;
                               XapMessageBox.confirm2('是否确认删除选中的共享元素？',
                                   function(btn, text){
                                       if (btn == 'yes') {
                                           var chain = view.getActionChain('delete');
                                           chain.execute({
                                               data:rec
                                           });
                                       } 
                                   }
                               );
                           }else{
                               XapMessageBox.warn('请选择共享元素！','',view);
                           }
                       }   
                   }
                   /*handler:function(btn,e){
                       var view = this.up('mrshareelementview');
                       var grid = view.down('xapgrid');
                       var record = grid.getSelectionModel().getSelection();
                       if(record && record.length>0){
                           var rec = record[0].raw;
                           XapMessageBox.confirm2('是否确认删除选中的共享元素？',
                               function(btn, text){
                                   if (btn == 'yes') {
                                       var chain = view.getActionChain('delete');
                                       chain.execute({
                                           data:rec
                                       });
                                   } 
                               }
                           );
                       }else{
                           XapMessageBox.warn('请选择共享元素！','',view);
                       }
                   }*/    
               }
        ]
	}],
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	setListData: function(data,turnpage) {
	    var grid = this.down('xapgrid');
        if(grid)
            if(turnpage)
                grid.setData(data.dataList);
            else
                grid.setPageData(data);
	}

})