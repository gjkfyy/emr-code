Ext.define('iih.mr.wr.nsv.block.NurScorePropertyBlock', {
	extend : 'Xap.ej.block.FormBlock',

	requires : [ 'Xap.ej.element.field.TextField', 'Xap.ej.element.field.DateField', 'Xap.ej.element.field.ComboBox', 'Xap.ej.element.datetimefield.DateTimeField' ],
	alias : 'widget.nursingrecordspropertyblock',
	id : 'nurscorepropertyblock',
	border : 0,
	layout : {
		type : 'table',
		columns : 3,
		tableAttrs : {
			border : 0,
			width : '100%'
		},
		tdAttrs : {
			valign : 'left'
		}
	},
	buttons : [ 
	{
		xtype : "button",
		name : 'confimUpPro',
		method : 'confimUpPro',
		text : '确认',
		iconCls : 'icon-OK'
	}, {
		xtype : "button",
		name : 'cancel',
		method : 'cancel',
		text : '取消',
		iconCls : 'icon-cancel'
	} ],
	items : [ {
		xtype : 'xaptextfield',
		name : 'mrNm',
		fieldLabel : '标题',
		labelWidth : 60,
		width : 250,
		padding : '5 0 0 15'
	}, {
		xtype : 'datetimefield',
		name : 'logicSmtDate',
		fieldLabel : '业务时间',
		labelWidth : 60,
		width : 210,
		padding : '5 200 0 22'
	}
	],
	setData : function(data) {
		this.callParent(arguments);
	},
	getData : function() {
		this.callParent(arguments);
	}
});