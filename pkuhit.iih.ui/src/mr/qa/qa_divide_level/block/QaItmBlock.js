Ext.define('iih.mr.qa.qa_divide_level.block.QaItmBlock',{
    extend : 'Xap.ej.block.Block',

    requires: [],

    alias:'widget.qaitmblock',

    layout: 'fit',
    
    border:0,

    items: [{
        title: '',
        xtype: 'xapgrid',
        ifSelect : true,
        selectBy: 'qaItmCd',

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
							var owner = this.up('qaitmview');
							var editLevelChain = owner.getActionChain("editLevel");
							editLevelChain.execute({
								record:record,
								eventNm:'editClick'
							});
						}	
					},{text:'删除',
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('qaitmview');
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
         	 {header: '一级分类编码',dataIndex: 'fstCd',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '二级分类编码',dataIndex: 'sndCd',field: 'textfield' ,type: 'string',hidden:true},
        	 {header: '质控项目编码',dataIndex: 'qaItmCd',field: 'textfield' ,type: 'string',hidden:true},
             {header: '项目名称',dataIndex: 'req',field: 'textfield' ,type: 'string',flex:1},
             {header: '质控扣分类型编码',dataIndex: 'qaDrpScrTpCd',field: 'textfield' ,type: 'string',width:100,hidden:true},
             {header: '质控扣分类型',dataIndex: 'qaDrpScrTpNm',field: 'textfield' ,type: 'string',width:100},
             {header: '单次扣分值',dataIndex: 'onceDrpScr',field: 'numberfield' ,type: 'string',width:80},
             {header: '累计扣分最大值',dataIndex: 'maxDrpScr',field: 'numberfield' ,type: 'string',width:100},
             {header: '扣分描述',dataIndex: 'deductDes',field: 'textfield' ,type: 'string',width:80},
             {header: '自动质控标识',dataIndex: 'autoQaF',name:'autoQaF',field: 'textfield' ,type: 'string',width:90,
             	renderer:function(value,metaData,record){
			        if(value ==  "1"){
			        	return "<div style='text-align:center'><label style='align:center'>√</label></div>";
			        }else{
			        	return null;
			        }
				}
			},
			{header: '启用标识',dataIndex: 'useFlag',field: 'textfield' ,type: 'string',width:80},
			/** 质控项目类别,主数据QAM06：时限性、频率性、完整性 */
			{header: '质控项目类别',dataIndex: 'qaItmTpCd',field: 'textfield' ,type: 'string',hidden:true}
        ]
    }],
    
    setData : function(data) {
        var grid = this.down('xapgrid');
        if(data){
        	for(var i=0;i<data.length;i++){
	        	if(data[i].autoQaF == '1'){
	        		var useFlag = data[i].useFlag;
	        		if(useFlag == '1'){
	        			data[i].useFlag = '启用';
	        		}else if(useFlag == null || useFlag == '0'){
	        			data[i].useFlag = '停用';
	        		}
	        	}
        	}
        	grid.setData(data);
        }else{
        	grid.setData({});
        }
    }
});

