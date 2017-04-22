Ext.define('iih.sy.followup.block.FollowUpListBlock', {
	extend : 'Xap.ej.element.grid.Grid',

	requires: [	           
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
	//title: '基础模板列表',
	autoScroll:true,
	pageSize : 25,
	pageShow : true,
	ifSelect:true,
	selectBy: 'code' ,//主键dataIndex名称（默认是id）
	name: 'followUpListBlock',

	tbar:[{
		    	xtype:'xapcombobox',
	            name:'type',
	            fieldLabel:'',
				padding:'5 20 0 5',
	            colspan: 3,
		        labelWidth:60,
		        width:120,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'-1', "value":"患者姓名"},
	                 {"code":'0', "value":"住院号"},
	                 {"code":'0', "value":"手机号"},
	                 {"code":'0', "value":"诊断"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'患者姓名'
			},{
				xtype : 'xaptextfield',
				id : 'value',
				name : 'value',
				colspan : 1,
				labelWidth : 0,
				width : 150,
				align  : 'left',  
				readOnly : false,
				fieldStyle:'color:#c6c6c6',
				value : '',
				fieldLabel : '',
				listeners:{
					
				}
			},{
				xtype : 'xaptextfield',
				id : 'diagnosis',
				name : 'diagnosis',
				colspan : 1,
				labelWidth : 50,
				width : 200,
				align  : 'left',  
				readOnly : false,
				fieldStyle:'color:#c6c6c6',
				value : '',
				fieldLabel : '诊断'
			},{
		    	xtype:'xapcombobox',
	            name:'marriage',
	            fieldLabel:'',
				padding:'5 20 0 5',
	            colspan: 3,
		        labelWidth:60,
		        //name:'marriage',
		        width:150,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'1', "value":"全部随访状态"},
	                 {"code":'0', "value":"待随访"},
	                 {"code":'0', "value":"已随访"},
	                 {"code":'0', "value":"已忽略"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'全部随访状态'
			},{
		    	xtype:'xapcombobox',
	            name:'marriage',
	            fieldLabel:'',
				padding:'5 20 0 5',
	            colspan: 3,
		        labelWidth:60,
		        //name:'marriage',
		        width:120,
	            labelAlign:'right',
	            comboData : [
	    			 {"code":'1', "value":"最近14天"},
	                 {"code":'0', "value":"前7天"},
	                 {"code":'0', "value":"后7天"},
	                 {"code":'0', "value":"全部时间"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'最近14天'
			},{
				xtype:'xapdatefield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'',
		        allowBlank:false,
		        blankText : '',
		        width:120,
		        name:'startTime',
		        listeners: {
					change: function( v, newValue, oldValue, eOpts ) {
						var startDate = this.up('panel').down('xapdatefield[name=admissionDate]');
						startDate.setMaxValue( this.getValue( ) );
					}
				}
			},{
				xtype:'xapdatefield',
				colspan: 2,
				padding:'5 0 0 5',
		        labelWidth:60,
		        fieldLabel:'',
		        allowBlank:false,
		        blankText : '不能为空',
		        width:120,
		        name:'endTime',
		        listeners: {
					change: function( v, newValue, oldValue, eOpts ) {
						var startDate = this.up('panel').down('xapdatefield[name=admissionDate]');
						startDate.setMaxValue( this.getValue( ) );
					}
				}
			},{
				xtype: 'button',
				text: '检索',
				iconCls: 'icon-Search',
				action: 'search'
			},{
				xtype: 'button',
				text: '导出excel',
				iconCls: 'icon-Excel',
				action: 'search'
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
			dataIndex : 'sexValue',
			field : 'textfield',
			type : 'string',
			flex : 1
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
			header : '上次入院时间',
			dataIndex : 'inpatientNo',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '预计随访时间',
			dataIndex : 'tel',
			field : 'textfield',
			type : 'string',
			flex : 1
		},{
			header : '随访状态',
			dataIndex : '',
			field : 'textfield',
			type : 'string',
			flex : 1
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