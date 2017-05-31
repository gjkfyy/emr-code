Ext.define('iih.sy.followup.block.FollowUpListBlock', {
	extend : 'Xap.ej.block.Block',

	requires: [	'Xap.ej.element.grid.Grid',
	           	'Xap.ej.element.grid.column.Date',  
	           	'Xap.ej.element.tree.Tree',
				'Xap.ej.element.grid.column.ActionColumn'
		],

	alias : 'widget.followUpListBlock',
	mixins : ['Xap.ej.block.LayeredBlock'],
	layout: 'fit',
	items:[{
		xtype:'xapgrid',
        layout: 'fit',
        border:false,
        checkboxShow : false,
        showHeaderCheckbox:false,
        pageShow:true,
        mode: 'multi',
        pageSize:23,
        pageNum:1,
        flex:1,
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
//					vertical: true,
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
//					vertical: true,
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
		                var grid = view.down('xapgrid[name=followUpListBlock]');
		                chain.execute({
		                	pageNum:1,
		                	pageSize:grid.pageSize
		                });
	                }
				},{
					xtype: 'button',
					text: '导出excel',
					iconCls: 'icon-Excel',
					action: '',
					handler:function(owner,tool){
						var view = this.up('followUpListView');
		                var chain = view.getActionChain('export');
		                var grid = view.down('xapgrid[name=followUpListBlock]');
		                chain.execute({
		                	pageNum:1,
		                	pageSize:grid.pageSize
		                });
		                
						//window.location.href = Ext.CONTEXT + '/followUp/export';
		                /*var view = this.up('followUpListView');
		                var chain = view.getActionChain('init');
		                var grid = view.down('xapgrid[name=followUpListBlock]');
		                chain.execute({
		                	pageNum:1,
		                	pageSize:grid.pageSize
		                });*/
	                }
				}],
		
			CM_JR_Record : [{
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
				flex : 0.5,
				renderer : function(value) {
	                return (value == 1)?"男":"女";
	            }
			},{
				header : '年龄',
				dataIndex : 'age',
				field : 'textfield',
				type : 'string',
				flex : 0.5
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
				flex : 1.5	
			},{
				header : '住院号',
				name : 'aa',
				dataIndex : 'inpatientNo',
				field : 'textfield',
				type : 'string',
				alink : false,
				flex : 1
			},{
				header : '上次入院日期',
				dataIndex : 'admissionDate',
				field : 'textfield',
				xtype : 'xapdatecolumn',
				flex : 1,
				activate : function(value) {
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
				dataIndex : 'fuStatus',
				alink:true,
				flex : 1/*,
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
	            }*/
			},/*{ xtype:'xapactioncolumn',
				text:'操作',
				width: 120,
				alink:true,
				align:'center',
				defectStore: null,
				items: [
					{
						text:'已随访',
						getClass : function(v,m,record) {
							
						},
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							
						}
					},{
						text:'已忽略',
						getClass : function(v,m,record) {
							
						},
						isDisabled : function(view,rowIndex,colIndex,item ,record) {
							
						},
						handler: function(view,rowIndex,colIndex,e,item ,record) {
							
						}
					}
				]
			},*/{
				header : 'patientId',
				dataIndex : 'patientId',
				field : 'textfield',
				type : 'string',
				hidden:true
			}]/*,
			listeners: {
	            itemdblclick: function(grid, rec, item, index) {
	            	alert(887);
	            },
	            cellclick: function(rec) {
	            	alert(888);
	            }
	        }*/
	}],
	
	initComponent: function() {
		this.callParent();
		this.initBlock();
	},
	setData : function(data) {
		var grid = this.down('xapgrid[name=followUpListBlock]');
		if(data){
			var dataList=data.dataList;
	    	if(grid){
	    		if(dataList){
			    	var totalList = {"total":data.total,"dataList":dataList};
			    	var pageSize = data.pageSize;
			    	if(typeof(data.pageSize) == 'number'){
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
	getData: function() {
        this.callParent(arguments);
    }
})