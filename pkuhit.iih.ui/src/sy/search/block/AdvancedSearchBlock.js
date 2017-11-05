Ext.define('iih.sy.search.block.AdvancedSearchBlock', {
	extend : 'Xap.ej.block.FormBlock',
	requires : [ 'Xap.ej.element.form.Form', 
	             'Xap.ej.block.ToolbarBlock',
	             'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.Checkbox',
		   		'Xap.ej.element.field.DateField',
		   		'Xap.ej.element.field.ComboBoxGrid'],
	alias : 'widget.advancedsearchblock',

	layout : {
		type : 'table',
		border : 0,
		columns : 12,
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
	autoScroll:true,

	items : [ {
		xtype : 'fieldset',
		title : '住院',
		colspan: 12,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '入院时间',
            labelWidth:80,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xapdatefield',
              name:'beginTime',
              flex: 3,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'fenge',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'endTime',
                flex: 3,
            	labelAlign:'left',
            	editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '住院号',
            labelWidth:80,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'beginNo',
              flex: 3,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'fenge',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xaptextfield',
            	name:'endNo',
                flex: 3,
            	labelAlign:'left',
            	editable:false
            }]
        }]
	},{
		xtype : 'fieldset',
		title : '患者',
		colspan: 12,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '姓名',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.2,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'username',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '性别',
            labelWidth:40,
            layout: 'hbox',
            columnWidth:0.25,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 20',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
        		xtype:'xapcombobox',
     	       // id:'sex',
     	        name:'sex',
                flex: 1,
                comboData : [
                     {"code":'-1', "value":"不限"},
         			 {"code":'1', "value":"男"},
                      {"code":'0', "value":"女"}
                 ],
                 displayField: 'value',
                 valueField: 'code',
                 allowBlank:true,
                 editable:false,
                 value:'-1'
     		}]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '出生日期11',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.5,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 20',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xapdatefield',
              name:'beginTime',
              flex: 1,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'fenge',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'endTime',
                flex: 1,
            	labelAlign:'left',
            	editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '联系电话',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.45,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'tel',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '身份证号',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.5,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 20',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'idCardNo',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '地址',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.95,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'10 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'address',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        }]
	},{
		xtype : 'fieldset',
		title : 'xxxx',
		colspan: 12,
		defaultType : 'textfield',
		layout : 'column',
		items : [{
            xtype: 'fieldcontainer',
            fieldLabel: '诊断',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'diagnosis',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '治疗目标',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'therapeuticGoal',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '手术方案',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'operationPlan',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        },{
            xtype: 'fieldcontainer',
            fieldLabel: '检查项目',
            labelWidth:60,
            layout: 'hbox',
            columnWidth:0.75,
            combineErrors: true,
            defaultType: 'textfield',
            padding:'5 0 5 0',
            defaults: {
                hideLabel: 'true'
            },
            items: [{
              xtype: 'xaptextfield',
              name:'address',
              flex: 1,
              labelAlign:'left',
              editable:false
            }]
        }]
	},{
		//title : '查询结果',
		border:false,
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
						text: '立即搜索',
						iconCls: 'icon-Search'
					},{
						xtype: 'button',
						text: '清除条件',
						iconCls: 'icon-points',
						valign : 'left'
			        
			        },'->',{
						xtype: 'button',
						text: '导出结果至Excel',
						iconCls: 'icon-reset',
						valign : 'right'
			        
			        },{
						xtype: 'button',
						text: '保存当前搜索条件',
						iconCls: 'icon-save',
						valign : 'right'
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
				header : '姓名',
				dataIndex : 'name',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '卡号',
				dataIndex : 'cardNo',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '就诊日期',
				dataIndex : 'visitDate',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '来源11',
				dataIndex : 'source',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '性别',
				dataIndex : 'sex',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '年龄',
				dataIndex : 'age',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '诊断',
				dataIndex : 'diagnose',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '治疗目标',
				dataIndex : 'therapeuticGoal',
				field : 'textfield',
				type : 'string',
				flex : 1
			}, {
				header : '手术方案',
				dataIndex : 'operationPlan',
				field : 'textfield',
				type : 'string',
				flex : 1
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
			setData:function(data) {
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
	}]
}]
})