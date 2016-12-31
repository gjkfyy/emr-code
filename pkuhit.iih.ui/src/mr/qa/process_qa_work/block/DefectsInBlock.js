/** 
 * 缺陷一览BLOCK
 * @extends Xap.ej.block.Block
 * @author ：wang_yanli
 */

Ext.define('iih.mr.qa.process_qa_work.block.DefectsInBlock',{
	extend : 'Xap.ej.block.Block',
	
	requires: [],

    alias:'widget.defectsinblock',
	layout: 'fit',
    items:[{
    	
    	xtype : 'xapgrid',
		name : 'defectingrid',
		rownumShow:false,
		//height : 170,
		title:'缺陷一览',
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		tools:[{
				xtype: 'xapbutton',
				text: '提缺陷',
				action: 'defectsin'
				//disabled:true
			},{
				xtype: 'tbspacer',
				padding:'0 10 0 0'
			}/*,{
				xtype: 'xapbutton',
				text: '编辑',
				action: 'editDefect',
				disabled:true
			},{
				xtype: 'tbspacer',
				padding:'0 10 0 0'
			},{
				xtype: 'xapbutton',
				text: '删除',
				action: 'defectDelete',
				disabled:true
			},{
				xtype: 'tbspacer',
				padding:'0 10 0 0'
			}*/,{
				xtype: 'xapbutton',
				text: '完成本次质控',
				action: 'defectsfinish',
				margin:'0 10 0 0'
		    },
		    /***********************syh 增加了质控完毕按钮*/
		    {
				xtype: 'xapbutton',
				text: '质控完毕',
				action: 'finish',
				disabled : true,  
				margin:'0 10 0 0',
				handler: function() {
					var view = this.up('defectinandmreditandhelperview');
					if(view&&view.ownerCt&&view.ownerCt.ownerCt&&view.ownerCt.ownerCt.workScreen){
						var workScreen=view.ownerCt.ownerCt.workScreen;
						var finishChain = view.getActionChain("finish");
						finishChain.execute({
							record:null,
							workScreen:workScreen,
							onFinishBtn:this,
							eventNm:'onFinishClick'
						});
					}
					
				}		
		    }/*,{
               itemId: 'up',
               hidden: false,
               xtype: 'tool',
               type: 'up'
           }, {
               itemId: 'down',
               hidden: true,
               xtype: 'tool',
               type: 'down'
        }*/],  		
		CM_JR_Record:[{
			header : '缺陷主键',
			name: 'qaFltPk',
			dataIndex : 'qaFltPk',
			hidden:true
		},{
			header : '质控项目主键',
			name: 'qaItemPk',
			dataIndex : 'qaItemPk',
			hidden:true
		},{
			header : '病案主键',
			name: 'mrPk',
			dataIndex : 'mrPk',
			hidden:true
		},{
			header : '缺陷状态编码',
			name: 'statusCode',
			dataIndex : 'statusCode',
			hidden:true
		},{
			header : '扣分说明',
			name: 'dropDescription',
			dataIndex : 'dropDescription',
			hidden:true
		},{
			header : '需整改标志',
			name: 'canReform',
			dataIndex : 'canReform',
			hidden:true
		},{
			header : '缺陷确认结果',
			name: 'faultConfirmResult',
			dataIndex : 'faultConfirmResult',
			hidden:true
		},{
			header : '序号',
			name: 'defectsNo',
			xtype:'xaprownumberer',
		    width:30
		},{ xtype:'xapactioncolumn',
			text:'操作',
			width:90,
			defectStore: null,
			items: [
				{
					text : '编辑',
					id:'editDefect',
					handler : function(view, rowIndex, cellIndex, e,item, record) {
						var defectinAndmreditview = this.up('defectinAndmreditview');
						if(defectinAndmreditview == undefined){
							defectinAndmreditview = this.up('defectinandmreditandhelperview');
							if(defectinAndmreditview == undefined){
								defectinAndmreditview = this.up('defectinandorderview');
							}
						}
						var editDefectChain = defectinAndmreditview.getActionChain("editDefectAction");
						editDefectChain.execute(record);
						
					}
				},{ 
					text : '删除',
					handler : function(view, rowIndex, cellIndex, e,item, record) {	
						var defectinAndmreditview = this.up('defectinAndmreditview');
						if(defectinAndmreditview == undefined){
							defectinAndmreditview = this.up('defectinandmreditandhelperview');
							if(defectinAndmreditview == undefined){
								defectinAndmreditview = this.up('defectinandorderview');
							}
						}
						XapMessageBox.confirm2(
							'确认删除？',
			   				function(btn){
							if(btn=="yes"){
								var defectDeleteChain = defectinAndmreditview.getActionChain("deleteDefectsAction");
								defectDeleteChain.execute(record);
							}
						});}
				}
			]
		}
		,{
			header : '缺陷状态',
			name: 'fltStaNm',
			dataIndex : 'fltStaNm',
			width:70
		},{
			header : '病历文书',
			name: 'mrName',
			dataIndex : 'mrName',
			width:120,
			renderer:function(value){
				if(value){
					return "<a class='link' href='#'>"+value+"</a>";
				}
		    }
		},{
			header : '缺陷描述',
			name: 'req',
			dataIndex : 'req',
			flex:1
		},{
			header : '扣分标准',
			name: 'deductDes',
			dataIndex : 'deductDes',
			width: 60
		},{
			header : '缺陷次数',
			name: 'deductScrTimes',
			dataIndex : 'deductScrTimes',
			width:60
		},{
			header : '提出日期',
			xtype: 'xapdatecolumn',
			name: 'sbmtTime',
			dataIndex : 'sbmtTime',
			width:115/*,
			format:'Y-m-d'*/
		},{
			header : '提出人',
			name: 'crtUserNm',
			dataIndex : 'crtUserNm',
			width:60
		},{
			header : '整改说明',
			name: 'rfmDes',
			dataIndex : 'rfmDes'
			/*renderer:function(value,metaData,record){
				return record.data.reformRequirement +"/"+record.data.dropDescription;
			},
            getEditor:function(record,defaultField ) {
            	 
            	 if(record.data.canEdit == 0){
            		 return null;
            	 }else if(record.data.faultConfirmResult==iih.mr.qa.QaStatusGlobal.FaultConfirmStatus){
            		 return null;
            	 }else{
            		 return Ext.create('Xap.ej.element.field.TextField');
            	 }
	           	
            }*/
		},{
			header : '整改人',
			name: 'rfmUserNm',
			dataIndex : 'rfmUserNm',
			width:60
		}/*,{
			header : '提出科室',
			name: 'submittedDeptName',
			dataIndex : 'submittedDeptName',
		}*/]
    }]

})