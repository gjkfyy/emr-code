Ext.define('iih.sy.search.block.EMRSearchConditionBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [ 'Xap.ej.element.grid.Grid' ],

	alias : 'widget.emrsearchconditionblock',
	id:'emrsearchconditionblock',

	layout : {
		type:'vbox',
        align: 'stretch'
	},

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
              name:'admissionDateStart',
              flex: 3,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'admissionDateEnd',
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
              name:'inpatientNoStart',
              flex: 3,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xaptextfield',
            	name:'inpatientNoEnd',
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
              name:'patientName',
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
            fieldLabel: '出生日期',
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
              name:'birthdayStart',
              flex: 1,
              labelAlign:'left',
              editable:false
            }, {
        	  	xtype: 'xapdisplayfield',
        		fieldLabel: '',
        		vertical: true,
        		name:'',
        		padding:'0 5 0 5',
        		value: '~'
          },{
              	xtype: 'xapdatefield',
            	name:'birthdayEnd',
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
		title : '高级检索项',
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
              name:'treatmentGoal',
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
              name:'ExamItem',
              flex: 1,
              labelAlign:'left',
              editable:false
            },{
				xtype: 'button',
				text: '',
				iconCls: 'icon-Create',
				margin:'0 5 0 10',
				colspan: 1,
				iconCls: 'icon-Create',
				valign : 'center',
				action: ''
			},{
				xtype: 'button',
				text: '',
				iconCls: 'icon-Create',
				margin:'0 5 0 5',
				colspan: 1,
				iconCls: 'icon-Delete',
				valign : 'center',
				action: ''
			}]
        }]
	}]
})
