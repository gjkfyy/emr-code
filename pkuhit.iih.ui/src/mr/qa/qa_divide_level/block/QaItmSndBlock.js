Ext.define('iih.mr.qa.qa_divide_level.block.QaItmSndBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [],

    alias:'widget.qaitmsndblock',

    layout: 'fit',
    
    border:0,

    items: [{
        title: '二级分类',
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'sndCd',

        tools:[{
           xtype:'button',
           text:'新增',
           method: 'addLevel',
           margin:'0 0 0 10'
       	}/*,{
           xtype:'button',
           text:'编辑',
           method: 'editLevel',
           margin:'0 0 0 10',
           disabled : true
       	},{
           xtype:'button',
           text:'删除',
           method: 'delLevel',
           margin:'0 0 0 10',
           disabled : true
       	}*/],
//        height:550,   
        CM_JR_Record: [
        	{xtype:'xapactioncolumn',text:'操作',width : 100,
				items: [
					{text:'编辑',
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('qaitmsndview');
							var editLevelChain = owner.getActionChain("editLevel");
							editLevelChain.execute({
								record:record,
								eventNm:'editClick'
							});
						}	
					},{text:'删除',
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('qaitmsndview');
							XapMessageBox.confirm2 (
							'确认删除？',
							function(btn){
								if(btn == 'yes'){
									var delLevelChain = owner.getActionChain("delLevel");
									delLevelChain.execute({
										record:record
									});
								}
							});
						}	
					}
				]
			},
         	 {header: '二级分类编码',dataIndex: 'fstCd',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '一级分类编码',dataIndex: 'sndCd',field: 'textfield' ,type: 'string',hidden:true},
             {header: '名称',dataIndex: 'nm',field: 'textfield' ,type: 'string',flex:1},
             {header: '评分',dataIndex: 'score',field: 'textfield' ,type: 'string',width:400}
        ]
    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid');
        if(data){
        	grid.setData(data);
        }else{
        	grid.setData({});
        }
    }
});

