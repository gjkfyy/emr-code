Ext.define('iih.mr.tm.gro.block.GroupElementPropertyEditViewBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
	           'Xap.ej.element.field.ComboBox',
	           'Xap.ej.element.field.ComboBoxGrid',
	           'Xap.ej.element.field.TextField',
	           'Xap.ej.element.field.TextArea'
	],

	alias:'widget.groupelementpropertyeditviewblock',

	layout: {
        type: 'table',
        columns: 2,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '100%'
        },
        tdAttrs: {
            valign: 'right'
        }
    },
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认',
        iconCls: 'icon-OK'
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        text: '取消',
        iconCls: 'icon-cancel'
    }],
	items: [   
       		{           
                xtype: "xaptextfield",
                name: 'code',
                hidden:true
       		},{           
                xtype: "xaptextfield",
                name: 'filePk',
                hidden:true
       		},{
                xtype:'xaptextfield',
                name:'name',
                fieldLabel:'组合元素名称:'
        	},{
                xtype:'xapcombobox',
                name:'typeCode',
                fieldLabel:'组合元素分类:',   
                editable: false/*,    
                dictionary:'BCM001'*/             
        	},{
        		xtype:'xaptextfield',
                name:'typeCode',
                fieldLabel:'组合元素所属类型:'
            },{
        		xtype:'xaptextfield',
                name:'typeCode',
                fieldLabel:'组合元素所属:'
            },{
            	xtype:'xaptextarea',
            	height:40,
                labelAlign:'left',
                name :'description',
                fieldLabel:'描述:',
                width:255
            }
     ],
	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
})