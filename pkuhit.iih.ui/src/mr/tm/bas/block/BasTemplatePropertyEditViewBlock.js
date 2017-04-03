Ext.define('iih.mr.tm.bas.block.BasTemplatePropertyEditViewBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
        'Xap.ej.element.field.ComboBox',
        'Xap.ej.element.field.ComboBoxGrid',
        'Xap.ej.element.field.TextField',
        'Xap.ej.element.field.TextArea'
	],

	alias:'widget.bastemplatepropertyeditviewblock',

	layout: {
        type: 'table',
        columns: 1,
        tableAttrs: {
            border: 0,
            cellpadding: 5,
            cellspacing: 1,
            width: '100%'
        },
        tdAttrs: {
            valign: 'left'
        }
    },
    buttons:[{
        xtype: "button",
        name: 'confim',
        method:'confim',
        text: '确认'
    },{
        xtype: "button",
        name: 'cancel',
        method:'cancel',
        text: '取消'    
    }],
	items: [   
                {
                	xtype:'xaptextfield',
                    name:'name',
                    fieldLabel:'名称:',
                    labelAlign:'right'
                },{
		            xtype:'xapcombobox',
		            name :'paperTypeCode',
		            fieldLabel:'纸张类型:',
	                allOptions:false,  
	                editable: false,    
		            dictionary:'MDM07',
                    labelAlign:'right' 
                },{
                	xtype:'xaptextarea',
	            	height:40,
	                name :'description',
	                fieldLabel:'描述:',
                    labelAlign:'right'
                },{
                	xtype: 'xapdisplayfield',
        			fieldLabel: '',
        			vertical: true,
        			name:'msgInfo',
        			value: '',
        			margin:'-10 0 0 0'
                },{           
	                xtype: "xaptextfield",
	                name: 'code',
	                hidden:true
                },{           
	                xtype: "xaptextfield",
	                name: 'filePk',
	                hidden:true
                }
         ],

	setData: function(data) {
	    this.callParent(arguments);
	},
    getData: function() {
        this.callParent(arguments);
    }
    
})