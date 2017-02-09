Ext.define(
				'iih.sy.patient.block.PatientRightBlock',
				{
					extend : 'Xap.ej.block.FormBlock',
					requires : [
							'Xap.ej.element.form.Form',
							'Xap.ej.block.ToolbarBlock'],
					alias : 'widget.patientrightblock',

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
								title : "患者基本信息",
								id : 'baseInfo',
								autoScroll:true,
								layout: {
									type : 'table',
									border : 0,
									columns : 6,
									tableAttrs : {
										border : 0,
										cellpadding : 0,
										cellspacing : 0,
										width : '100%'
									},
									tdAttrs : {
										valign : 'left'
									}
		    				    },
								items : [{
									xtype :'toolbar',
									width : '100%',
						            margin : '0 0 0 0',  
									height :30,
									colspan : 6,
									items: [{
												xtype: 'button',
												text: '编辑',
												iconCls: 'icon-edit',
												valign : 'left',
												action : 'modifyPatient'
									        }]
									},{
										xtype : 'xaptextfield',
										name : 'hiddenData',
										hidden : true
									},{
										xtype : 'xapdisplayfield',
										labelWidth : 60,
										labelAlign : 'right',
										name : 'patientName',
										readOnly : true,
										colspan:1,
										fieldLabel : '姓名'
									},{
										xtype : 'xapdisplayfield',
										name : 'sexValue',
										labelWidth : 100,
										colspan:1,
										labelAlign : 'right',
										readOnly : true,
										fieldLabel : '性别'
									},{
										xtype : 'xapdisplayfield',
										name : 'age',
										labelWidth : 60,
										colspan:1,
										labelAlign : 'right',
										valign : 'right',
										readOnly : true,
										fieldLabel : '年龄'
									},{
										xtype: 'xapdisplayfield',
										fieldLabel: '',
										colspan:1,
										width : 50,
										valign: 'left',
										name:'',
										value: '岁'
									},{
										xtype : 'xapdisplayfield',
										name : 'tel',
										labelWidth : 60,
										colspan:1,
										labelAlign : 'right',
										readOnly : true,
										fieldLabel : '电话'
									},{
								        xtype: 'xapdisplayfield',
								        labelWidth : 100,
								        name : 'adress',
								        fieldLabel: '住址',
								        colspan:1,
								        labelAlign : 'right'
									},
									{
										xtype : 'xapdisplayfield',
										name : 'inpatientNo',
										labelWidth : 60,
										colspan:1,
										labelAlign : 'right',
										readOnly : true,
										fieldLabel : '住院号'
									},{
										labelWidth : 100,
										labelAlign : 'right',
										xtype : 'xapdisplayfield',
										name : 'admissionDate',
										readOnly : true,
										colspan:1,
										fieldLabel : '入院时间',
									},{
										labelWidth : 60,
										labelAlign : 'right',
										xtype : 'xapdisplayfield',
										name : 'sex',
										readOnly : true,
										colspan : 2,
										fieldLabel : '诊断',
									},{
										xtype: 'xapdisplayfield',
										fieldLabel: '',
										colspan:1,
										labelWidth : 60,
										name:'',
										value: ''
									},{
										xtype: 'xapdisplayfield',
										fieldLabel: '',
										colspan:1,
										labelWidth : 100,
										name:'',
										value: ''
									}]
								},{
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
														text: '新建',
														iconCls: 'icon-Create',
														menu: Ext.create('Ext.menu.Menu', {
															cls: 'top-base',
															frame: false,
									        				margin: 0,
									        				padding: 0,
													        items: [{
								        	            		text: '上肢',
								        	            		tooltip:'上肢',
								        	            		handler:function(btn,e){
								        	            			
								        	            		}
								        					},{
	
								        	            		text: '下肢',
								        	            		tooltip:'下肢',
								        	            		handler:function(btn,e){
								        	            			
								        	            		}
								        					
								        					},{
								        	            		text: '脊柱',
								        	            		tooltip:'脊柱',
								        	            		handler:function(btn,e){
								        	            			
								        	            		}
								        					},{
								        	            		text: '足底畸形',
								        	            		tooltip:'足底畸形',
								        	            		handler:function(btn,e){
								        	            			
								        	            		}
								        					},{
								        	            		text: '躯干侧弯',
								        	            		tooltip:'躯干侧弯',
								        	            		handler:function(btn,e){
								        	            			
								        	            		}
								        					}]
														})         
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
												dataIndex : 'employeeId',
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
												dataIndex : 'id',
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
												dataIndex : 'statusName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '书写时间',
												dataIndex : 'serviceDepartName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新人',
												dataIndex : 'serviceDepartName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}, {
												header : '最后更新时间',
												dataIndex : 'serviceDepartName',
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
												dataIndex : 'serviceDepartName',
												field : 'textfield',
												type : 'string',
												flex : 1
											}]
									}]
								}],
								setData : function(data) {
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
					
					setData : function(data) {
						if (data) {
							var hiddenData = this.down('xaptextfield[name=hiddenData]');
							hiddenData.setRawValue(data);
							this.getForm().setValues(data);
						}
					},
					setGridData : function(data) {
						if (data) {
							
						}
					}
				})