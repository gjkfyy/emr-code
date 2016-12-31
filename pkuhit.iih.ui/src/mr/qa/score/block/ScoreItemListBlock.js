Ext.define('iih.mr.qa.score.block.ScoreItemListBlock',{
	extend : 'Xap.ej.block.Block',


	alias:'widget.scoreitemListblock',

	layout: 'fit',

	modCount: 0,//gird修改次数
	
	canEdit: 1,//判断当前缺陷是否可编辑，从病案一览赋值
	
	canSave: false,
	items: [{
		xtype: 'xapgridblock',
		title: '扣分项目',
		autoScroll:true,
		plugins : [Ext.create('Xap.ej.element.grid.plugin.CellEditing', {
			clicksToEdit : 1
		})],
		tools:[{
				xtype: 'xapbutton',
				text: '增加',
				action: 'qaScoreItemAdd'
			}/*,{
				xtype: 'xapbutton',
				text: '删除',
				action: 'qaScoreItemDelete',
				disabled: true
			}*/,{
				xtype: 'tbspacer',
				width: 5
			},{
				xtype: 'xapbutton',
				text: '完成评分',
				action: 'qaScoreComplete'
			}
		],
		CM_JR_Record: [
					{
						header : '扣分项目表主键',
						name: 'qaDivideCd',
						dataIndex : 'qaDivideCd',
						hidden:true
					},
					{
						header : '质控项目主键',
						name: 'qaItmPk',
						dataIndex : 'qaItmPk',
						hidden:true
					},
		 
                   { header: '就诊序号', dataIndex: 'enSn', hidden: true},
                   { header: '医护标识', dataIndex: 'dctNsF', hidden: true},
                   {
           			text : '操作',
           			name: 'qaScoreItemDelete',
           			xtype:'xapactioncolumn',
           			width:50,
           			items : [{
           				text : '删除',
           				isDisabled : function(view,rowIndex,colIndex,item ,record) {
           					var scoreworkview = this.up('scoreworkview');
							if(scoreworkview.ownerProperty.completed){
							
								return true;
								
							}else{
								if(record.data.dctNsF=='0' && iih.mr.qa.QaStatusGlobal.isNurseRole){//如果为护士登录且提缺陷者也为护士，则删除按钮可用
									return false;
								}else if(record.data.dctNsF=='1' && !iih.mr.qa.QaStatusGlobal.isNurseRole){
									return false;
								}else{
									return true;
								}
								//return false;
							}
						},
	           			/*getClass : function(v,m,record) { 
	           				  var scoreworkview = this.up('scoreworkview');
	                          if(scoreworkview.ownerProperty.completed){
	                              return 'x-hidden';
	                          }                           
	                    },*/
           				handler : function(view, rowIndex, cellIndex, e,item, record) {
           					var me = this;
           					XapMessageBox.confirm2('确认删除？', function(button) {
           			            if (button == "yes") {
           			            	
           			            	me.fireEvent('clickEvent',record,rowIndex,cellIndex);
           			            }
           			        });
           					
           				}
           			}]
           			
           		   },
                   { header: '质控类别', dataIndex: 'itemFirstNM', width:160},
                   { header: '评分项目', dataIndex: 'req', width:400,flex:1},
                   { header: '评分标准', dataIndex: 'deductDes', width:150},
                   { header: '质控医师', dataIndex: 'sbmtUserNm', width:150}
		]
	}],

	setData: function(data) {
		
		var grid = this.down('xapgridblock');
		if(data.dataList){
			grid.setData(data.dataList);
		}else{
			grid.setData([]);
		}
		/*if(data){
			var resultList = [];
			for(var i in data){
				var qaDefectModel = Ext.create('iih.mr.model.QADefectModel',data[i]);
				resultList.push(qaDefectModel);
			}
			grid.setData(resultList);
			//grid.setData(data);
		}else{
			grid.setData([]);
		}*/
	},
	buttonEnable: function(config){
		var defectSave = this.down('xapgrid xapbutton[action=defectSave]');
		var completeQaScore = this.down('xapgrid xapbutton[action=completeQaScore]');
		if(config.defectSave){
			defectSave.setDisabled(false);
		}else{
			defectSave.setDisabled(true);
		}
		if(config.completeQaScore){
			completeQaScore.setDisabled(false);
		}else{
			completeQaScore.setDisabled(true);
		}
		
	}
})