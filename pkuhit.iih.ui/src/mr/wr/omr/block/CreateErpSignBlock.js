Ext
		.define(
				'iih.mr.wr.omr.block.CreateErpSignBlock',
				{
					extend : 'Xap.ej.block.PanelBlock',

					alias : 'widget.createerpsignblock',
					id : 'createerpsignblock',
					border : false,
					buttons : [],
					items : [
							{
								xtype : "button",
								name : 'doctorSignBtn',
								text : '医生签名',
								width : 70,
								itemId : 'doctorSignBtn',
								id:'doctorSignBtn',
								margin : '5 5 5 8'
							},
							{
								xtype : "button",
								name : 'patientSignBtn',
								text : '患者签名',
								width : 70,
								itemId : 'patientSignBtn',
								id:'patientSignBtn',
								margin : '5 5 5 8'
							},
							{
								xtype : "button",
								name : 'fingerprintGatherBtn',
								text : '指纹采集',
								margin : '5 5 5 8',
								id:'fingerprintGatherBtn',
								width : 70,
								itemId : 'fingerprintGatherBtn'
							},
							{
								xtype : "button",
								name : 'timePokeSignBtn',
								text : '时间戳签名',
								margin : '5 5 5 8',
								width : 70,
								disabled:true,
								id:'timePokeSignBtn',
								itemId : 'timePokeSignBtn'
							},
							{
								xtype : "button",
								name : 'erpSignSaveBtn',
								margin : '5 5 5 8',
								width : 70,
								id:'erpSignSaveBtn',
								itemId : 'erpSignSaveBtn',
								text : '保存'
							},
							{
								items : [ {
									xtype : 'displayfield',
									name : 'templeName',
									fieldLabel : '',
									labelAlign : 'right',
									anchor : '100% 88%',
									width : 230,
									renderer : function(value) {
										return "<object id=\"FoxitPDFSDK\"  WIDTH=\"900px\" HEIGHT=\"490px\" clsid=\"{F53B7748-643C-4A78-8DBC-01A4855D1A10}\" TYPE=\"application/x-itst-activex\"></object>" +
				    						"<object id=\"idMXOTOCX\" clsid=\"{4E16E1BD-B562-48E3-813E-DC5CA566D94C}\" type=\"application/x-itst-activex\" height=0 width=0></object>"+
				    						"<object id=\"sigCtl1\" WIDTH=\"0\" HEIGHT=\"0\" clsid=\"{963B1D81-38B8-492E-ACBE-74801D009E9E}\" TYPE=\"application/x-itst-activex\">	</object>"+
											"<object id=\"sigcapt\" clsid=\"{E34F39B0-37EF-40B0-94CF-3FE20CF6AD5D}\"	TYPE=\"application/x-itst-activex\"></object>";
									}
								} ]
							} ]
				});