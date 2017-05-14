Ext.define('iih.sy.followup.block.FollowUpListBlock', {
	extend : 'Xap.ej.element.grid.Grid',

	requires: [	'Xap.ej.element.grid.Grid',
	           	'Xap.ej.element.grid.column.Date',           
				'Xap.ej.block.LayeredBlock',
				'Xap.ej.element.grid.FlowGrid',  
				'Xap.ej.element.grid.column.ActionColumn'
		],

	alias : 'widget.followUpListBlock',
	mixins : ['Xap.ej.block.LayeredBlock'],
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	layout: 'fit',
	//checkboxShow : true,
	//simple点击行起作用，multi点击checkbox起作用
	mode: 'simple',
	//title: '',
	autoScroll:true,
	pageSize : 25,
	pageShow : true,
	ifSelect:true,
	selectBy: 'code' ,//主键dataIndex名称（默认是id）
	name: 'followUpListBlock',

	tbar:[{
		    	xtype:'xapcombobox',
	            name:'fuType',
	            fieldLabel:'',
				padding:'5 0 0 5',
		        labelWidth:10,
		        width:120,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'patientName', "value":"患者姓名"},
	                 {"code":'inpatientNo', "value":"住院号"},
	                 {"code":'tel', "value":"手机号"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'patientName'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
//				vertical: true,
				width:4,
				valign: 'left',
				name:'',
				value: ':'
			},{
				xtype : 'xaptextfield',
				name : 'fuValue',
				labelWidth : 0,
				width : 150,
				align  : 'left',  
				readOnly : false,
				fieldStyle:'',
				value : '',
				fieldLabel : '',
				listeners:{
					
				}
			},{
				xtype : 'xaptextfield',
				id : 'diagnosis',
				name : 'diagnosis',
				labelWidth : 50,
				width : 200,
				align  : 'left',  
				readOnly : false,
				fieldStyle:'',
				value : '',
				fieldLabel : '诊断'
			},{
		    	xtype:'xapcombobox',
	            name:'fuFlag',
	            fieldLabel:'',
				padding:'5 20 0 5',
		        labelWidth:0,
		        width:120,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'all', "value":"全部随访状态"},
	                 {"code":'1', "value":"待随访"},
	                 {"code":'2', "value":"已随访"},
	                 {"code":'3', "value":"已忽略"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'all'
			},{
		    	xtype:'xapcombobox',
	            name:'fuDate',
	            fieldLabel:'',
				padding:'5 0 0 5',
		        labelWidth:0,
		        //name:'marriage',
		        width:120,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'14', "value":"最近14天"},
	                 {"code":'-7', "value":"前7天"},
	                 {"code":'7', "value":"后7天"},
	                 {"code":'all', "value":"全部时间"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'14',
	            listeners: {
					change: function( v, newValue, oldValue, eOpts ) {
						var view = this.up('followUpListView');
		                var chain = view.getActionChain('getDate');
						if(v.value=='-7'){
							chain.execute({
								flag:'-7'
							});
						}else if(v.value=='7'){
							chain.execute({
								flag:'7'
							});
						}else if(v.value=='14'){
							chain.execute({
								flag:'14'
							});
						}else if(v.value=='all'){
							chain.execute({
								flag:'all'
							});
						}
					}
				}
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
//				vertical: true,
				width:4,
				valign: 'left',
				name:'',
				value: ':'
			},{
				xtype:'xapdatefield',
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'',
		        allowBlank:true,
		        blankText : '',
		        fieldStyle:'font-size:12px;background:#e0dfdf;',
		        width:90,
		        editable:false,
		        readOnly:true,
		        name:'startDate',
		        anchor:'100% 88%',
		        value:''
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '',
				width:4,
				valign: 'left',
				name:'',
				value: '—'
			},{
				xtype:'xapdatefield',
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'',
		        blankText : '不能为空',
		        width:90,
		        name:'endDate',
		        fieldStyle:'background:#e0dfdf',
		        value:'',
		        editable:false,
		        readOnly:true
			},{
				xtype: 'button',
				text: '检索',
				iconCls: 'icon-Search',
				handler:function(owner,tool){
	                var view = this.up('followUpListView');
	                var chain = view.getActionChain('init');
	                var gridBlock = view.down('followUpListBlock');
	                chain.execute({
	                	pageNum:gridBlock.currentPage,
	                	pageSize:gridBlock.pageSize
	                });
                }
			},{
				xtype: 'button',
				text: '导出excel',
				iconCls: 'icon-Excel',
				action: ''
			}],
	
		CM_JR_Record : [ {
			header : 'patientId',
			dataIndex : 'patientId',
			field : 'textfield',
			type : 'string',
			hidden:true
		},{
			header : '姓名',
			dataIndex : 'patientName',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '性别',
			dataIndex : 'sex',
			field : 'textfield',
			type : 'string',
			flex : 1,
			renderer : function(value) {
                return (value == 1)?"男":"女";
            }
		},{
			header : '年龄',
			dataIndex : 'age',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '手机号',
			dataIndex : 'tel',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '诊断',
			dataIndex : 'diagnosis',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '住院号',
			dataIndex : 'inpatientNo',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '上次入院日期',
			dataIndex : 'admissionDate',
			field : 'textfield',
			xtype : 'xapdatecolumn',
			flex : 1,
			renderer : function(value) {
				var v = Ext.Date.parse(value, 'time');
				return Ext.Date.format(v, 'Y-m-d');
            }
		},{
			header : '预计随访日期',
			dataIndex : 'admissionDate',
			field : 'textfield',
			xtype : 'xapdatecolumn',
			flex : 1,
			renderer : function(value) {
				//3个月
				var v0 = Ext.Date.parse(value, 'time');
				v0.setMonth(v0.getMonth()+3);
				var v3m = Ext.Date.format(v0, 'Y-m-d');
				
				//6个月
				var v1 = Ext.Date.parse(value, 'time');
				v1.setMonth(v1.getMonth()+6);
				var v6m = Ext.Date.format(v1, 'Y-m-d');
				
				//1年
				var v2 = Ext.Date.parse(value, 'time');
				v2.setFullYear(v2.getFullYear()+1);
				var v1y = Ext.Date.format(v2, 'Y-m-d');
				
				//3年
				var v3 = Ext.Date.parse(value, 'time');
				v3.setFullYear(v3.getFullYear()+3);
				var v3y = Ext.Date.format(v3, 'Y-m-d');
				
				
				//当前时间前后7天范围
				var cDate = new Date();
				var currentDate = Ext.Date.format(cDate, 'Y-m-d');
				cDate.setDate(cDate.getDate()-7);
				var preDate = Ext.Date.format(cDate, 'Y-m-d');
				
				var cDate = new Date();
				cDate.setDate(cDate.getDate()+7);
				var afterDate = Ext.Date.format(cDate, 'Y-m-d');
				
				if(preDate<v3m && v3m<afterDate){
					return v3m;
				}else if(preDate<v6m && v6m<afterDate){
					return v6m;
				}else if(preDate<v1y && v1y<afterDate){
					return v1y;
				}else if(preDate<v3y && v3y<afterDate){
					return v3y;
				}else{
					return "";
				}
            }
		},{
			header : '随访状态',
			dataIndex : 'admissionDate',
			field : 'textfield',
			type : 'string',
			flex : 1,
			renderer : function(value) {
				//3个月
				var v0 = Ext.Date.parse(value, 'time');
				v0.setMonth(v0.getMonth()+3);
				var v3m = Ext.Date.format(v0, 'Y-m-d');
				
				//6个月
				var v1 = Ext.Date.parse(value, 'time');
				v1.setMonth(v1.getMonth()+6);
				var v6m = Ext.Date.format(v1, 'Y-m-d');
				
				//1年
				var v2 = Ext.Date.parse(value, 'time');
				v2.setFullYear(v2.getFullYear()+1);
				var v1y = Ext.Date.format(v2, 'Y-m-d');
				
				//3年
				var v3 = Ext.Date.parse(value, 'time');
				v3.setFullYear(v3.getFullYear()+3);
				var v3y = Ext.Date.format(v3, 'Y-m-d');
				
				//当前时间前后7天范围
				var cDate = new Date();
				var currentDate = Ext.Date.format(cDate, 'Y-m-d');
				cDate.setDate(cDate.getDate()-7);
				var preDate = Ext.Date.format(cDate, 'Y-m-d');
				
				var cDate = new Date();
				cDate.setDate(cDate.getDate()+7);
				var afterDate = Ext.Date.format(cDate, 'Y-m-d');
				if(preDate<v3m && v3m<afterDate){
					return "待随访（3M）";
				}else if(preDate<v6m && v6m<afterDate){
					return "待随访（6M）";
				}else if(preDate<v1y && v1y<afterDate){
					return "待随访（1Y）";
				}else if(preDate<v3y && v3y<afterDate){
					return "待随访（3Y）";
				}else{
					return "";
				}
            }
		}],
		
		setGridData: function(data) {
		 	var dataList = data;
		 	if( null == data.dataList ){
		 		var totalList = {"total":0,"dataList":null};
		 		this.setPageData(totalList);
		 	}
		 	if(dataList){
			    	var totalList = {"total":data.total,"dataList":data.dataList};
			    	var pageNum = data.pageNum;
			    	if(pageNum == '1'){
				 		//console.log(totalList);
			    		this.setPageData(totalList);	//初始化赋值
			    	}else{
			    		//console.log("翻页");
			    		this.setData(data.dataList);	//翻页时赋值
			    	}
		 	}else{
		 		var totalList = {"total":data.total,"dataList":data.dataList};
		 		this.setPageData(totalList);
		 	}
		}
})