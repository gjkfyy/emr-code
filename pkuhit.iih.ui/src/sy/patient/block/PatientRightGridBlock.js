Ext.define('iih.sy.patient.block.PatientRightGridBlock',
		{extend : 'Xap.ej.block.Block',
		requires : [ 'Xap.ej.element.grid.Grid','Xap.ej.element.grid.column.Date' ],
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
														text: '新建病例',
														iconCls: 'icon-Create',
														method: 'createDoc'        
													},{
														xtype: 'button',
														text: '删除',
														iconCls: 'icon-Delete',
														method: 'delDoc' ,
														valign : 'left',
														handler: function(btn, e){
															var mrTree = btn.up('patientrightview').getBlock('result').down("xapgrid")
															var treeNode = mrTree.getSelectionModel().getSelection();
															if(treeNode.length == 0){
																XapMessageBox.info('请先选择要删除的病例！');
													            return
													        }else{
													        	var view = btn.up('patientrightview'); 
													        	XapMessageBox.confirm2('是否确认删除所选病例？',
													                function(btn, text){
													                    if (btn == 'yes') {
													                        var chain = view.getActionChain('delDoc');
													                        chain.execute();
													                    }
													                }
														        );
													        }
												        }
											        
											        }]
										},{
											xtype : 'xapgrid',
											name:'docList',
											colspan : 1,
											width: '100%',
											pageSize : 20,
											pageNum : 1,
											rownumShow : true,
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
												header : '病例类型',
												dataIndex : 'typeName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '病例名称',
												dataIndex : 'name',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写人',
												dataIndex : 'createUserName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写时间',
												dataIndex : 'createTime',
												field : 'textfield',
												xtype : 'xapdatecolumn',
												flex : 1
											}, {
												header : '最后更新人',
												dataIndex : 'lastUpdateUserName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新时间',
												dataIndex : 'lastUpdTime',
												field : 'textfield',
												xtype : 'xapdatecolumn',
												flex : 1
											}/*, {
												header : '审签人',
												dataIndex : 'signLevelName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '审签时间',
												dataIndex : 'dirDoctorDate',
												field : 'textfield',
												type : 'string',
												flex : 1
											}*/]
											
									}]
									
						}],
						setData: function(data) {
							var grid = this.down('xapgrid[name=docList]');
							if(data){
								var dataList=data.dataList;
						    	if(grid){
						    		if(dataList){
						    			//记住上次选中行，若第一次加载则默认选中第一行
						    			if(dataList.length >0 &&grid.nodeId == null){
						    				grid.nodeId = dataList[0][grid.selectBy];
						    			}
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
						    		grid.setData(dataList);	//翻页时赋值
						    	}
							}
						}
				})