/** 
 * 缺陷列表block
 * @author ：yao_lijie
 */
 var me = this;
Ext.define('iih.mr.qa.process_qa_reform.block.DefectRfmListBlock',{
	extend : 'Xap.ej.block.Block',

	alias:'widget.defectrfmlistblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgrid',
		height : 170,
		tools:[/*{
			xtype: 'xapbutton',
			text: '整改',
			margin:'0 10 0 0',
			action: 'rfm'
		},*/{
			xtype: 'xapbutton',
			text : '完成本次整改',
			margin:'0 10 0 0',
			action: 'finishRfm'
		},{
            itemId: 'up',
            hidden: false,
            xtype: 'tool',
            type: 'up'
        },{
            itemId: 'down',
            hidden: true,
            xtype: 'tool',
            type: 'down'
        }
	],
		autoScroll:true,
		title:'缺陷列表',
		CM_JR_Record: [
			{xtype:'xapactioncolumn',text:'操作',width : 100,hidden:false,name:'reformback',
				items: [
					{text:'整改',
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							var fltStaCd = record.data.fltStaCd;
							if(fltStaCd == iih.mr.qa.QaStatusGlobal.faultToReform){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('processrfmdefectview');
							if(owner == undefined){
								owner = this.up('orderRfmdefectview');
							}
							var rfmDefectChain = owner.getActionChain("rfmDefect");
							rfmDefectChain.execute({
								record:record
							});
						}	
					},{
						text:'撤回',
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							var finishRfm = this.up('xapgrid').down('xapbutton');
							if(finishRfm.disabled == true){
								return true;
							}else{
								var fltStaCd = record.data.fltStaCd;
								if(fltStaCd == iih.mr.qa.QaStatusGlobal.faultReformed){
									return false;
								}else{
									return true;
								}
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('processrfmdefectview');
							if(owner == undefined){
								owner = this.up('orderRfmdefectview');
							}
							var backDefectChain = owner.getActionChain("backDefect");
							backDefectChain.execute({
								record:record
							});
						}	
					}
				]
			},
			{xtype:'xapactioncolumn',text:'操作',width : 100,hidden:true,name:'reform',
				items: [
					{text:'整改',
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							var fltStaCd = record.data.fltStaCd;
							if(fltStaCd == iih.mr.qa.QaStatusGlobal.faultToReform){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							var owner = this.up('processrfmdefectview');
							if(owner == undefined){
								owner = this.up('orderRfmdefectview');
							}
							var rfmDefectChain = owner.getActionChain("rfmDefect");
							rfmDefectChain.execute({
								record:record
							});
						}	
					}
				]
			},
		   {header: '状态', dataIndex: 'fltStaNm', field: 'textfield', type: 'string', width: 80},
           {header: '文书名称', dataIndex: 'mrName', alink:true,field: 'textfield', type: 'string',flex:1},
           {header: '缺陷描述', dataIndex: 'req', field: 'textfield', type: 'string', width: 220},
           {header: '扣分标准', dataIndex: 'deductDes', field: 'textfield',type: 'string', width: 80},
           {header: '缺陷次数',dataIndex: 'deductScrTimes', field: 'textfield', type: 'string' ,width: 80},
           {header: '提出日期', dataIndex: 'sbmtTime', xtype: 'xapdatecolumn',  width: 135},
           {header: '提出人', dataIndex: 'crtUserNm', field: 'textfield', type: 'string', width: 80},
           {header: '整改说明', dataIndex: 'rfmDes', field: 'textfield', type: 'string',flex:1},
           {header : '缺陷主键', name: 'qaFltPk', dataIndex : 'qaFltPk', hidden:true },
           {header: '文书主键', dataIndex: 'mrPk', field: 'textfield', type: 'string', hidden:true },
		   {header: '状态编码', dataIndex: 'fltStaCd', field: 'textfield', type: 'string', width: 80,hidden:true}
		]
	}],

	setData: function(data) {
		var grid = this.down('xapgrid');
		if(grid){
			if(data){
				grid.setData(data);
			}else{
				grid.setData([]);
			}
		}
	}
})