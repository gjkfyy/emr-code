Ext.define('iih.sy.patient.block.PatientRightBlock',
		{extend : 'Xap.ej.block.FormBlock',
		 requires : ['Xap.ej.element.form.Form',
					 'Xap.ej.block.ToolbarBlock'],
		alias : 'widget.patientrightblock',
		layout : {      type : 'table',
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
											name:'userList',
											colspan : 1,
											width: '100%',
											rownumShow : false,
											height : 470,
											pageShow : true,
											ifSelect: false,
											mode:'simple',
											showHeaderCheckbox : false,
											checkboxShow : false,
											CM_JR_Record : [{
												header : 'empId',
												dataIndex : 'encounterPk',
												field : 'textfield',
												type : 'string',
												hidden:true
											},{
												header : 'xapUserPk',
												dataIndex : 'xapUserPk',
												field : 'textfield',
												type : 'string',
												hidden:true,
												flex : 1
											},{
												header : '文书编号',
												dataIndex : 'filePk',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '病历分类名',
												dataIndex : 'name',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写人',
												dataIndex : 'crtUserId',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写时间',
												dataIndex : 'logicSubmitTime',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新人',
												dataIndex : 'dirDoctorName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新时间',
												dataIndex : 'mastDoctorDate',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '审签人',
												dataIndex : 'serviceDepartName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '审签时间',
												dataIndex : 'submitName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}],
											setData : function(data) {
											  console.log('--data='+data.toString())
												var grid = this.down('xapgrid[name=userList]');
												if(data){
													var dataList=data.dataList;
											    	if(grid){
											    		if(dataList){
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
											},
											getData : function(data) {
												if (data) {
													var hiddenData = this.down('xaptextfield[name=hiddenData]');
													hiddenData.setRawValue(data);
													this.getForm().setValues(data);
												}
											},
											setGridData : function(data) {
												  console.log('-2-data='+data.toString())
												if (data) {
													
												}
											}
									}]
						}]
				})