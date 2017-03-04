Ext.define('iih.sy.patient.block.PatientLeftBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
	            
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.Checkbox',
		   		'Xap.ej.element.field.DateField',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form'
		   	],

	alias:'widget.patientleftblock',
	
	layout: {
		type: 'table',
		columns: 2,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1
        },
        tdAttrs: {
            valign: 'left'
        }
	},
	items: [{
			xtype: 'button',
			text: '新建患者',
			margin:'5 0 5 0',
			iconCls: 'icon-Create',
			valign : 'left',
			action : 'newPatient'
	},{
			xtype: 'button',
			text: '编辑患者',
			iconCls: 'icon-edit',
			valign : 'left',
			action : 'editPatient'
	}]
})