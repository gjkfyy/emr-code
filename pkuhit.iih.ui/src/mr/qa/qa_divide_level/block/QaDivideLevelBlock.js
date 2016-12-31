Ext.define('iih.mr.qa.qa_divide_level.block.QaDivideLevelBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [],

    alias:'widget.qadividelevelblock',

    layout: 'fit',
    border:0,

    items: [{
        title: '病案等级',
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'qaDivideLevelCd',

        /*tools:[{
           xtype:'button',
           text:'新增',
           method: 'addLevel',
           margin:'0 0 0 10',
           hidden:true
       	},{
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
           hidden:true
       	}],*/
//        height:550,
        CM_JR_Record: [
        	{xtype:'xapactioncolumn',text:'操作',width : 60,
				items: [
					{text:'编辑',
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('qadividelevelview');
							var editLevelChain = owner.getActionChain("editLevel");
							editLevelChain.execute({
								record:record,
								eventNm:'editClick'
							});
						}	
					}
				]
			},
        	 {header: '等级编码',dataIndex: 'qaDivideLevelCd',field: 'textfield' ,type: 'string',hidden:true},
             {header: '等级',dataIndex: 'lvl',field: 'textfield' ,type: 'string',flex:1},
             {header: '最低分',dataIndex: 'minScr',field: 'textfield' ,type: 'string',width:400},
             {header: '最高分',dataIndex: 'maxScr',field: 'textfield' ,type: 'string',flex:1}
        ]
    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid');
        if(grid){
        	if(data){
        		grid.setData(data);
	        }else{
	        	grid.setData({});
	        }
        }
    }
});

