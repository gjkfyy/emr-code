var widthRate = 0.87
var tbRate = 0.87

Ext
		.define(
				'iih.sy.userinfo.block.UserInfoRightBlock',
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
							'iih.sy.userinfo.block.UserRightLimitBlock' ],
					alias : 'widget.useinforightblock',

					layout : {
						type : 'table',
						border : 0,
						columns : 6,
						tableAttrs : {
							border : 0,
							cellpadding : 5,
							cellspacing : 1,
							width : '100%'
						},
						tdAttrs : {
							valign : 'left'
						}
					},

					title : "用户基本信息",
					autoScroll:true,
					items : [
							{
								xtype : 'xaptextfield',
								name : 'hiddenData',
								hidden : true
							},
							{
								xtype : 'xaptextfield',
								name : 'id',
								colspan : 2,
								labelWidth : 60,
								labelAlign : 'right',
								readOnly : true,
								fieldLabel : '用户ID'
							},
							{
								xtype : 'xaptextfield',
								labelWidth : 60,
								labelAlign : 'right',
								name : 'name',
								readOnly : true,
								fieldLabel : '姓名',
								width : 160 * tbRate,
								margin:'0 120 0 0'
							},
							{
								labelWidth : 40,
								labelAlign : 'right',
								xtype : 'xapcombobox',
								name : 'sexName',
								readOnly : true,
								fieldLabel : '性別',
								colspan : 3,
								dictionary : 'MD002',
								width : 130 * tbRate
							},{//签名图片
						        xtype: 'filefield',
								width : 275 * tbRate,
						        labelWidth : 60,
						        fieldLabel: '选择图片',
						        labelAlign : 'right',
						        buttonText: '',
						        buttonConfig: {
						            iconCls: 'icon-Upload'
						        },
						        colspan:1
							},{
						        xtype: 'imagecomponent',
						        name:'signPicture',
						        width:100,
						        height:50,
						        margin:'0 0 0 -80',
						        colspan : 5
						    },{
								colspan : 4,
								title : '角色列表',
								layout : {
									type : 'table',
									border : 1,
									columns : 4,
									tableAttrs : {
										border : 0,
										cellpadding : 3,
										cellspacing : 1
									},
									tdAttrs : {
										valign : 'left'
									}
								},
								items : [{ //出诊科室列表
											xtype : 'xapgrid',
											name : 'deptgrid',
											height : 440,
											width : 200,
											cid : 'useinforightGrid',
											url : '',
											rownumShow : false,
//											plugins : [ Ext.create('Ext.grid.plugin.CellEditing', { clicksToEdit : 1 }) ],
											listeners : {
												beforeedit : function(editor, e, eOpts) {
													if (e.field == 'organizationName') {
														if (e.record.data.flag == '0') {
															return false;
														} else {
															return true;
														}
													}
												},
												edit : function(editor, e) {
													if (e.field == 'organizationName') {
														e.record.data.flag = '0';
													}
												},
												cellclick : function(view, td, cellIndex, record, tr, rowIndex, e, eOpts) {
													if (cellIndex == '0' & (record.data.flag == '0' || record.data.flag == '' ) & record.data.roleList.length > 0) {
														this.fireEvent('comboxclick', this, record);
													} else if (cellIndex == '0' & record.data.organizationCode == "") {
														this.fireEvent( 'comboxclick', this, record);
													} else if (cellIndex == '0' & record.data.organizationCode == undefined) {
														this.fireEvent('comboxclick', this, record);
													}else if (cellIndex == '0' & (record.data.flag == '0' || record.data.flag == '' ) & record.data.roleList.length == 0) {
														this.fireEvent('comboxclick', this, record);
													}
													if (cellIndex == 1) {
														record.data.flag = '1';
														this.getPlugin().startEdit(rowIndex, 0);
														return false;
													}
												}
											},
											CM_JR_Record : [
													{
														header : '角色信息',
														name : 'roleList',
														dataIndex : 'roleList',
														hidden : true
													},
													{
														header : 'xxx',
														name : 'xx',
														dataIndex : 'flag',
														hidden : true
													},
													{
														header : 'xxx',
														name : 'xx',
														dataIndex : 'organizationCode',
														hidden : true
													},
													{
														header : '出诊科室',
														name : 'organizationName',
														dataIndex : 'organizationName',
														flag : '0',
														deptCode : '',
														flex : 1,
														editor : {
															xtype : 'comboxgrid',
															listWidth : 150,
															padding : '0 0 0 0',
															valueField : 'code',
															method : 'dept',
															columns : [
															{
																text : '科室编码',
																dataIndex : 'value',
																hidden : true
															},
															{
																text : '科室',
																flex : 1,
																dataIndex : 'text'
															} ],
															displayField : 'keyword',
															parentXtype : 'useinforightblock',
															dictionary : 'ownerCdLoad',
															callback : function(newValue, oldValue, record) {
																console.log(newValue);
																console.log(oldValue);
																console.log(record);
																var currGrid = this.up('xapgrid[name=deptgrid]');
																var currStore = currGrid.getStore();
																var datas = currStore.data.items;
																var b = false;
																for ( var i = 0; i < datas.length; i++) {
																	if ((datas[i].data.organizationCode == record.value)) {
																		b = true;
																		break;
																	}
																}

																if (b) {
																	Ext.MessageBox.show({
																		title : '提示',
																		msg : '重复录入',
																		icon : Ext.Msg.WARNING,
																		buttons : Ext.Msg.OK
																	});
																	this.clearValue();
																	var currGrid = this.up('xapgrid[name=deptgrid]');
																	var selModel = currGrid.getSelectionModel();
																	var recordRow = selModel.getSelection()[0];
																	recordRow.set('organizationCode', '');
																} else {
																	var currGrid = this.up('xapgrid[name=deptgrid]');
																	var selModel = currGrid.getSelectionModel();
																	var recordRow = selModel.getSelection()[0];
																	recordRow.set('organizationCode', record.value);
																	recordRow.set('organizationName', record.text);
																	if (record.value == 'NULL') {
																		recordRow.set('organizationCode', '');
																	} else {
																		recordRow.set('organizationCode', record.value);
																	}
																}
															}
														}
													},
													{
														xtype : 'xapactioncolumn',
														name : 'editRow',
														defectStore : null,
														width : 0
													},
													{
														xtype : 'xapactioncolumn',
														name : 'deleteRow',
														defectStore : null,
														width : 0
													}
													,{
														xtype : 'xapactioncolumn',
														name : 'empDeptCd',
														dataIndex : 'empDeptCd',
														deptCode : '',
														width : 0
													},{
														xtype : 'xapactioncolumn',
														name : 'signLvlCd',
														dataIndex : 'signLvlCd',
														deptCode : '',
														width : 0
													},{
														xtype : 'xapactioncolumn',
														name : 'curDrcDctId',
														dataIndex : 'curDrcDctId',
														deptCode : '',
														width : 0
													},{
														xtype : 'xapactioncolumn',
														name : 'curDeputyDrcDctId',
														dataIndex : 'curDeputyDrcDctId',
														deptCode : '',
														width : 0
													} ]
										},
										{ //角色列表
											xtype : 'xapgrid',
											name : 'rolegrid',
											mode : 'multi',
											checkOnly : true,
											height : 440,
											width : 200,
											colspan : 1,
											selType : 'cellmodel',
											checkboxShow : true,
											rownumShow : false,
											plugins : [ Ext.create('Xap.ej.element.grid.plugin.CellEditing') ],
											CM_JR_Record : [ {
												header : '角色Id',
												dataIndex : 'roleCode',
												hidden : true
											}, {
												header : '角色',
												dataIndex : 'roleName',
												width : 160 * widthRate,
												flex : 1
											}, {
												header : '用户角色主键',
												dataIndex : 'code',
												hidden : true
											} ]
										},
										{ //审签等级
											xtype : 'xapform',
											title:'审签等级',
											name : 'reviewform',
											height : 440,
											width : 200,
											items:[{
											       xtype: 'xapradiogroup',
											       layout:{
											    	   type: 'vbox',
											    	   align: 'left'
											       },
											       name: 'signLvlCd',
											       items: [
														{boxLabel: '一级审签', name: 'signLvlCd', inputValue: 'MRM02.02'},
														{boxLabel: '二级审签', name: 'signLvlCd', inputValue: 'MRM02.03'},
														{boxLabel: '三级审签', name: 'signLvlCd', inputValue: 'MRM02.04'}
													]
											}]
										},
										{ //默认三级医师
											xtype : 'xapform',
											title:'默认三级医师',
											name : 'drcdctform',
											height : 440,
											width : 200,
											items: [{
												xtype:'comboxgrid',
												url: 'employee',//人员查询的url
										        anchor: "90%",
												listWidth:210,    //gird的宽度
												width:140,        //combo的宽度
										        padding:'0 0 0 0',
										        name: 'curDeputyDrcDctId',
												dataIndex : 'curDeputyDrcDctId',
										        method:'employee',
										        fieldLabel:'二级医师',
										        labelWidth : 60,
												labelAlign : 'right',
												valueField : 'id',//用户编码的字段名
												displayField: 'name',//人员名称的字段名
												columns: [{              //grid的column配置
												   text: '人员编码',
												   dataIndex: 'id',
												   width:60
												},{
												   text: '医师姓名',
												   flex:1,
												   dataIndex: 'name'
												}],
												callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
												    console.log(newValue);     //本次选择的科室编码
												    console.log(oldValue);     //上次选择的科室编码
												    console.log(record);       //本次选择的科室完整记录
												}
											},{
												xtype:'comboxgrid',
												url: 'employee',//人员查询的url
										        anchor: "90%",
												listWidth:210,    //gird的宽度
												width:140,        //combo的宽度
										        padding:'0 0 0 0',
										        name: 'curDrcDctId',
												dataIndex : 'curDrcDctId',
										        method:'employee',
										        fieldLabel:'三级医师',
										        labelWidth : 60,
												labelAlign : 'right',
												valueField : 'id',//用户编码的字段名
												displayField: 'name',//人员名称的字段名
												columns: [{              //grid的column配置
												   text: '人员编码',
												   dataIndex: 'id',
												   width:60
												},{
												   text: '医师姓名',
												   flex:1,
												   dataIndex: 'name'
												}],
												callback:function(newValue,oldValue,record){  //在grid选择记录后的回调函数
												    console.log(newValue);     //本次选择的科室编码
												    console.log(oldValue);     //上次选择的科室编码
												    console.log(record);       //本次选择的科室完整记录
												}
											}]
										}]
							}],
					setData : function(data) {
						if (data) {
							// 遍历data时使用
							var obj = new Object();
							var tempData = Ext.Object.merge(obj, data);

							var hiddenData = this.down('xaptextfield[name=hiddenData]');
							var deptgrid = this.down('xapgrid[name=deptgrid]');
							var displayOrgCodes = [];
							var displayResults = []; // 数据重新封装后给前端显示的数组
							hiddenData.setRawValue(data);
							var wardDepts = data.wardDeptList;

							for ( var i in wardDepts) {

								var wardDept = wardDepts[i];

								if (null != wardDept.deptCd&& !Ext.Array.contains(displayOrgCodes, wardDept.deptCd)) {

									var dept = new Object();
									dept['organizationCode'] = wardDept.deptCd;
									dept['organizationName'] = wardDept.nm;
									dept['empDeptCd'] = wardDept.empDeptCd;
									dept['signLvlCd'] = wardDept.signLvlCd;
									dept['curDrcDctId'] = wardDept.curDrcDctId;
									dept['curDeputyDrcDctId'] = wardDept.curDeputyDrcDctId;

									displayResults.push(dept);
									displayOrgCodes.push(wardDept.deptCd);
								}
							}
							/*var userRoles = data.userRoleList;

							for ( var i in userRoles) {

								var userRole = userRoles[i];

								if (null != userRole.organizationCode&& !Ext.Array.contains(displayOrgCodes, userRole.organizationCode)) {

									var dept = new Object();
									dept['organizationCode'] = userRole.organizationCode;
									dept['organizationName'] = userRole.organizationName;
									displayResults.push(dept);
									displayOrgCodes.push(userRole.organizationCode);
								}
							}*/
							var tempUserRoles = tempData.userRoleList;
							for ( var i in displayResults) {

								var singleResult = displayResults[i];// 分组过的机构编码
								var roleList = [];

								for ( var j = 0; j < tempUserRoles.length; j++) {

									var tempUserRole = tempUserRoles[j];
									var role = new Object();

									if (tempUserRole.organizationCode == singleResult.organizationCode) {
										role['roleCode'] = tempUserRole.roleCode;
										role['roleName'] = tempUserRole.roleName;
										role['code'] = tempUserRole.code; // 待确认
//										role['startTime'] = tempUserRole.startTime;
//										role['stopTime'] = tempUserRole.stopTime;
										role['organizationCode'] = tempUserRole.organizationCode;
										roleList.push(role);
										tempUserRoles.splice(j, 1);
										j = j - 1;
									}
								}
								displayResults[i].roleList = roleList;
								
							}
							
							deptgrid.setData(displayResults); // 给用户角色赋值
							this.getForm().setValues(data); // 给form表单赋值
						}
					},
					setGridData : function(data) {
						if (data) {
							var grid = this.down('xapgrid[name=rolegrid]');
							var dataList = data.dataList;
							for ( var i in dataList) {
								dataList[i]['roleCode'] = dataList[i].code;
								dataList[i]['roleName'] = dataList[i].name;
								dataList[i]['code'] = '';
							}
							grid.setData(dataList);
						}
					}
				})