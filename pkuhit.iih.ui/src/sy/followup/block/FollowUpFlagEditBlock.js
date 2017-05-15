Ext.define('iih.sy.followup.block.FollowUpFlagEditBlock',{
	extend : 'Xap.ej.block.FormBlock',
	requires: [
		   		'Xap.ej.element.field.ComboBox',
		   		'Xap.ej.element.field.TextArea',
		   		'Xap.ej.element.field.Checkbox',
		   		'Xap.ej.element.field.DateField',
		   		'Xap.ej.element.field.ComboBoxGrid',
				'Xap.ej.element.form.Form'
		   	],

	alias:'widget.followupflageditblock',
	
	layout: {
		type: 'table',
		columns: 4,
		tableAttrs: {
            border: 0,
            cellpadding: 0,
            cellspacing: 1
        },
        tdAttrs: {
            valign: 'left',
            buttonAlign:'center'
        }
	},
	items: [{
				header : '患者ID',
				name : 'crtUserId',
				field : 'textfield',
				type : 'string',
				hidden : true
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '患者',
				padding:'5 0 0 50',
				labelWidth:50,
				width:50,
				colspan: 1,
				valign: 'right',
				name:'patientName',
				value: 'sss'
			},{
				xtype: 'xapdisplayfield',
				fieldLabel: '当前的随访状态是',
				width:250,
				padding:'5 0 0 50',
				colspan: 3,
				valign: 'left',
				name:'',
				value: '待随访（3M）'
			},{
				xtype:'xapcombobox',
	            name:'fuFlag',
	            colspan: 4,
	            fieldLabel:'将随访状态修改为',
				padding:'5 0 0 50',
		        labelWidth:100,
		        width:220,
	            labelAlign:'left',
	            comboData : [
	    			 {"code":'1', "value":"待随访"},
	                 {"code":'2', "value":"已随访"},
	                 {"code":'3', "value":"已忽略"}
	            ],
	            displayField: 'value',
	            valueField: 'code',
	            allowBlank:true,
	            editable:false,
	            value:'1'
			},{
				xtype:'xaptextarea',
				colspan: 4,
				padding:'5 0 0 50',
		        labelWidth:50,
		        fieldLabel:'备注',
		        /*allowBlank:false,
		        blankText : '不能为空',*/
		        width:380,
		        height:120,
		        name:'info'
			},{
	            xtype: 'xapdisplayfield',
	            colspan: 1,
	            width: 170
	        },{
				xtype: 'button',
				text: '保存',
				padding:'1 5 1 5',
				colspan: 1,
				iconCls: 'icon-save',
				action: 'save',
				valign : 'center'
			},{
				xtype: 'button',
				padding:'1 5 1 5',
				text: '取消',
				colspan: 1,
				iconCls: 'icon-cancel',
				action: 'cancel',
				valign : 'center'
			},{
	            xtype: 'xapdisplayfield',
	            colspan: 1,
	            width: 130
	        },{
	            xtype: 'xapdisplayfield',
	            colspan: 4,
	            width: 130
	        }],
			setData: function(data) {
			    this.callParent(arguments);
			},
		    getData: function() {
		        this.callParent(arguments);
		    }
			
})