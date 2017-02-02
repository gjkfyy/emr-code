var widthRate = 0.87
var tbRate = 0.87

Ext.define(
				'iih.sy.patient.block.PatientRightBlock',
				{
					extend : 'Xap.ej.block.FormBlock',
					requires : [ 'Xap.ej.element.field.ComboBox',
							'Xap.ej.element.field.ComboBoxGrid',
							'Xap.ej.element.field.Radio',
							'Xap.ej.element.radiogroup.RadioGroup',
							'Xap.ej.element.field.DateField',
							'Xap.ej.element.datetimefield.DateTimeField',
							'Xap.ej.element.grid.column.ActionColumn',
							'Xap.ej.element.form.Form',
							'Xap.ej.block.ToolbarBlock',
							'iih.sy.patient.block.PatientRightLimitBlock' ],
					alias : 'widget.patientrightblock',

					layout : {
						type : 'table',
						border : 0,
						columns : 5,
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
						items : [
								{
									xtype : 'xaptextfield',
									name : 'hiddenData',
									hidden : true
								},
								{
									xtype : 'xapdisplayfield',
									labelWidth : 60,
									labelAlign : 'right',
									id : 'patientName',
									name : 'patientName',
									readOnly : true,
									fieldLabel : '姓名',
									width : 160 * tbRate,
									margin:'0 120 0 0'
								},
								{
									xtype : 'xapdisplayfield',
									id : 'inpatientNo',
									name : 'inpatientNo',
									colspan : 2,
									labelWidth : 60,
									labelAlign : 'right',
									readOnly : true,
									fieldLabel : '住院号'
								},
								{
									labelWidth : 40,
									labelAlign : 'right',
									xtype : 'xapdisplayfield',
									id : 'sex',
									name : 'sex',
									readOnly : true,
									fieldLabel : '性别',
									colspan : 3,
									dictionary : 'MD002',
									width : 130 * tbRate
								},{//签名图片
							        xtype: 'xapdisplayfield',
									width : 275 * tbRate,
							        labelWidth : 60,
							        id : 'adress',
							        fieldLabel: '住址',
							        labelAlign : 'right',
							        buttonText: '',
							        buttonConfig: {
							            iconCls: 'icon-Upload'
							        },
							        colspan:1
								},{
									colspan : 4,
									title : '已书写文书',
									layout: {
										type: 'hbox',
										pack: 'end'
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
													iconCls: 'icon-Diagnosis',
													valign : 'left'
										        
										        },{
													xtype: 'button',
													text: '随访',
													iconCls: 'icon-enable',
													valign : 'left'
										        }]
									}]
								},{
									
									items : [ {
										//title : '患者列表',
										xtype : 'xapgrid',
										name:'userList',
										// pageShow : true,
										rownumShow : false,
										height : 470,
										// selType:'checkboxmodel',
										pageSize : 20,
										pageShow : true,
										ifSelect: false,
										//checkOnly : true,
										mode:'simple',
										showHeaderCheckbox : false,
										//selType : 'cellmodel',
										checkboxShow : false,
										CM_JR_Record : [ {
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
											hidden:true
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
									} ],
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
									}
								}]
					}],
					
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