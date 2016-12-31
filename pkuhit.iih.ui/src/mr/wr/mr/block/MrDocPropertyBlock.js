Ext.define('iih.mr.wr.mr.block.MrDocPropertyBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.DateField',
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.datetimefield.DateTimeField'
	],
	alias:'widget.mrdocformblock',
	/*
     * layout:{ type: 'table', columns: 2, //width: 1024, tableAttrs: { border:
     * 0, cellpadding: 4, // cellspacing: 1, width: '100%' }, tdAttrs: { valign:
     * 'left' }},
     */
	layout:{
		type: 'table',
		columns: 2,
		tableAttrs: {
			border: 0,
			//cellpadding: 2,
			width: '100%'
		},
		tdAttrs: {
			valign: 'left'
		}
	},
	buttons:[{
            xtype: "button",
            name: 'close',
            method:'close',
            text: '关闭',
            iconCls: 'icon-close'
        },{
            xtype: "button",
            name: 'confim',
            method:'confim',
            text: '确认',
            disabled:true,
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'confimUpPro',
            method:'confimUpPro',
            text: '确认',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],
	
	items: [/*,{
		xtype:'xaptextfield',
		name:'jobTitleCd',
		padding:'10 0 0 15',
		fieldLabel:'职称',
		labelWidth:60,
		queryMode: 'local',
		readOnly:true,
		disabled:true
	},*/{
		xtype:'xaptextfield',
		name:'mrNm',
		fieldLabel:'病历标题',
		labelWidth:60,
		width:516,
		colspan:2,
		padding:'10 0 0 15'
	},{
		xtype:'datetimefield',
		name:'logicSmtDate',
		fieldLabel:'业务时间',
		labelWidth:60,
		padding:'10 0 0 22'
	},{
		xtype:'xapcombobox',
		name:'higherLvlEmpId',
		padding:'10 0 0 15',
		fieldLabel:'上级查房医师',
		labelWidth:80,
		editable:true,
		width:280,
		disabled:true,
		queryMode: 'local',
		displayField: 'name',
		valueField: 'id'
	}/*,{
		xtype:'xapcombobox',
		name:'relevance',
		fieldLabel:'关联医嘱',
		labelWidth:60,
		queryMode: 'local',
		disabled:true,
		padding:'10 0 0 15',
		displayField: 'name',
		valueField: 'abbr'
	}*/],
	setData: function(data) {
        this.callParent(arguments);
    },
    getData: function() {
        this.callParent(arguments);
    }
})