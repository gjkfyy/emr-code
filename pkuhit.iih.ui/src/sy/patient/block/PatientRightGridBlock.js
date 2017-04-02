Ext.define('iih.sy.patient.block.PatientRightGridBlock',
		{extend : 'Xap.ej.block.Block',
		requires : [ 'Xap.ej.element.grid.Grid' ],
		alias : 'widget.patientrightgridblock',
		layout : {      
						type : 'table',
						border : 0,
						columns: 1,
						tableAttrs : {
							border : 0,
							cellpadding : 1,
							cellspacing : 1,
							width : '100%'
						},
						tdAttrs : {
							valign : 'left'
						}
					},
					
					items: [{
										title : '已书写文书',
										layout: {
											type:'vbox',
									        align: 'stretch',
									        tableAttrs : {
												border : 0,
												cellpadding : 1,
												cellspacing : 1,
												width : '100%'
											}
										},
										items : [{
											xtype :'toolbar',
											autoScroll :true,
											width: '100%',
								            margin  : '0 0 0 0',  
											height:30,
											items: [{                   
														text: '新建病历',
														iconCls: 'icon-Create',
														method: 'createDoc'        
													},{
														xtype: 'button',
														text: '打开',
														iconCls: 'icon-Open',
														valign : 'left'
											        
											        },{
														xtype: 'button',
														text: '诊断',
														disabled: true,
														iconCls: 'icon-Diagnosis',
														valign : 'left'
											        
											        },{
														xtype: 'button',
														text: '随访',
														disabled: true,
														iconCls: 'icon-enable',
														valign : 'left'
											        }]
										},{
											xtype : 'xapgrid',
											name:'docList',
											colspan : 1,
											width: '100%',
											pageSize : 20,
											pageNum : 1,
											rownumShow : false,
											height : 476,
											pageShow : true,
											ifSelect: false,
											mode:'simple',
											selectBy: 'enPK',
											showHeaderCheckbox : false,
											checkboxShow : false,
											CM_JR_Record : [{
												header : 'mrPk',
												dataIndex : 'mrPk',
												field : 'textfield',
												type : 'string',
												hidden:true
											},{
												header : 'xapUserPk',
												dataIndex : 'mrPk',
												field : 'textfield',
												type : 'string',
												hidden:true,
												flex : 1
											},{
												header : '文书编号',
												dataIndex : 'mrPk',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '病历分类名',
												dataIndex : 'mrTypeCustomCode',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写人',
												dataIndex : 'submitName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写时间',
												dataIndex : 'submitDate',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新人',
												dataIndex : 'mrPk',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新时间',
												dataIndex : 'mrPk',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '审签人',
												dataIndex : 'dirDoctorName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '审签时间',
												dataIndex : 'dirDoctorDate',
												field : 'textfield',
												type : 'string',
												flex : 1
											}]
											
									}]
									
						}],
						setData: function(data) {
							var grid = this.down('xapgrid[name=docList]');
							if(data){
								var dataList=data.dataList;
						    	if(grid){
						    		if(dataList){
						    			/*//记住上次选中行，若第一次加载则默认选中第一行
						    			if(dataList.length >0 &&grid.nodeId == null){
						    				grid.nodeId = dataList[0][grid.selectBy];
						    			}*/
								    	var totalList = {"total":data.total,"dataList":dataList};
								    	var pageSize = data.pageSize;
								    	if(pageSize == undefined || typeof(data.pageSize) == 'object'){
								    		grid.setPageData(totalList);	//初始化赋值
								    	}else{
								    		grid.setData(dataList);	//翻页时赋值
								    	}
						        	}else{
						        		var totalList = {"total":data.total,"dataList":dataList};
						        		grid.setPageData(totalList);
						        	}
						    		
						    	}
							}
						}
				})