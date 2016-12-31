/** 
 * 缺陷列表block
 * @author ：cheng_feng
 */
Ext.define('iih.mr.qa.process_qa_track.block.DefectListBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [
   		'Xap.ej.element.grid.Grid',
		'Xap.ej.element.grid.column.Date'
   	],
   	
	alias:'widget.defectlistblock',

	layout: 'fit',

	items: [{
		xtype: 'xapgrid',
		tools:[{
			xtype: 'xapbutton',
			text : '审核通过',
			action: 'checkPass',
            hidden: true,
			disabled: true
		},{
			xtype: 'xapbutton',
			text : '扣分',
			action: 'deduction',
            hidden: true,
			disabled: true
		},
		{
			xtype: 'xapbutton',
			text: '再整改',
			action: 'rectification',
            hidden: true,
			disabled: true
		},{
			xtype: 'xapbutton',
			text : '完成本次审核',
			action: 'finishCheck',
			disabled: true
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
			 { xtype:'xapactioncolumn',
				text:'操作',
				width: 170,
				defectStore: null,
				items: [
					{
						text:'审核通过',
						/*getClass : function(v,m,record) {
							if(record.data.bugState=='MRM010.01' || record.data.bugState=='MRM010.03'  || record.data.bugState=='MRM010.05'){
								return 'x-hidden';
							}							
						},*/
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.revisionStatus==iih.mr.qa.QaStatusGlobal.revisionNoticeReformed){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.up('processqadefectview');
							var checkPassChain = owner.getActionChain("checkPass");
							checkPassChain.execute({
								record:record
							});
							var wakeDefectButtonChain = owner.getActionChain("wakeDefectButton");
							wakeDefectButtonChain.execute({
								record:record
							});
						}
					},{
						text:'扣分',
						/*getClass : function(v,m,record) {
							if(record.data.bugState=='MRM010.01' || record.data.bugState=='MRM010.03'  || record.data.bugState=='MRM010.05'){
								return 'x-hidden';
							}							
						},*/
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.revisionStatus==iih.mr.qa.QaStatusGlobal.revisionNoticeReformed){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.up('processqadefectview');
							var deductionChain = owner.getActionChain("deduction");
							deductionChain.execute({
								record:record
							});
							var wakeDefectButtonChain = owner.getActionChain("wakeDefectButton");
							wakeDefectButtonChain.execute({
								record:record
							});
						}
					},{
						text:'再整改',
						/*getClass : function(v,m,record) {
							if(record.data.bugState=='MRM010.01' || record.data.bugState=='MRM010.02' || record.data.bugState=='MRM010.04'   || record.data.bugState=='MRM010.05'){
								return 'x-hidden';
							}							
						},*/
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							if(record.data.revisionStatus==iih.mr.qa.QaStatusGlobal.revisionNoticeReformed){
								return false;
							}else{
								return true;
							}
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
//							console.log('click '+'---'+rowIndex+'---'+colIndex+'---'+record.data.bugCd);
//							console.log('click '+'---'+this.ownerCt.ownerCt.xtype);
//							this.ownerCt.ownerCt.fireEvent('columnClick',record);
							var owner = this.up('processqadefectview');
							var rectificationChain = owner.getActionChain("rectification");
							rectificationChain.execute({
								record:record
							});
							var wakeDefectButtonChain = owner.getActionChain("wakeDefectButton");
							wakeDefectButtonChain.execute({
								record:record
							});
						}	
					}
				]
			},
		   {header: '状态', dataIndex: 'fltStaNm', field: 'textfield', type: 'string', width: 80},
           {header: '文书名称', dataIndex: 'mrName',alink:true, field: 'textfield', type: 'string', width: 150},
           {header: '缺陷描述', dataIndex: 'req', field: 'textfield', type: 'string', width: 165},
           {header: '扣分标准', dataIndex: 'deductDes', field: 'textfield',type: 'string', width: 80},
           {header: '缺陷次数',dataIndex: 'deductScrTimes', field: 'textfield', type: 'string' ,width: 80},
           /*{ header: '提出日期', dataIndex: 'sbmtTime', 
				field: {
					xtype: 'datetimefield'
				},
				renderer: function(v){
					if(v){
						v = new Date(v);
						return Ext.util.Format.date(v, 'Y-m-d H:i');
					}
					return v;
				}
			 },*/
           {header: '提出日期', dataIndex: 'sbmtTime', xtype: 'xapdatecolumn',  width: 120},
           {header: '提出人', dataIndex: 'crtUserNm', field: 'textfield', type: 'string', width: 80},
           {header: '整改说明', dataIndex: 'rfmDes', field: 'textfield', type: 'string', width: 80, flex:1},
		   {header : '缺陷主键', name: 'qaFltPk', dataIndex : 'qaFltPk', hidden:true },
		   {header : '通知书状态', name: 'revisionStatus', dataIndex : 'revisionStatus', hidden:true },
		   {header : '质控项', name: 'qaItmCd', dataIndex : 'qaItmCd', hidden:true },
           {header: '文书主键', dataIndex: 'mrPk', field: 'textfield', type: 'string', hidden:true },
		   {header: '缺陷状态编码', dataIndex: 'fltStaCd', field: 'textfield', type: 'string', hidden:true}
		]
	}],

	setData: function(data) {
		var grid = this.down('xapgrid');
		if(data){
			grid.setData(data);
		}else{
			grid.setData([]);
		}
	}
})