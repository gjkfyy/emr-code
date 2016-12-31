Ext.define('iih.masterdata.dataelement.dimensionvalue.block.DictGeneralDataInferBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.dictgeneraldatainferblock',
	
	buttons:[{
            xtype: "button",
            name: 'save',
            method:'save',
            text: '保存',
            iconCls: 'icon-OK'
        },{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
            text: '取消' ,
            iconCls: 'icon-cancel' 
    }],

	items: [{
		xtype: 'xapform',
		name:'dictGeneral',
		width:'100%',
		border: 1,
		layout: {
			type: 'table',
			columns: 2,
			tableAttrs: {
	            border: 0,
	            cellpadding: 5,
	            cellspacing: 1,
	            width: '100%',
	            height:'100%'
	        },
	        tdAttrs: {
	            valign: 'left'
	        }
		},
		items:[{
			xtype:'xaptextfield',
			name:'dataElementCd',
			labelAlign : 'right',
			width:300,
			colspan : 2,
			fieldLabel:'通用字典编码',
			hidden:true
		},{
			xtype:'xaptextfield',
			readOnly:true,
			name:'valueCode',
			labelAlign : 'right',
			width:300,
			allowBlank: false,
            blankText: '编码不能为空！',
			enforceMaxLength:true,
			maxLength:20,
			maxLengthText:'编码最大长度不能超过20个字符！',
			fieldLabel:'编码'
		},{
			xtype:'xaptextfield',
			name:'valueDisplay',
			labelAlign : 'right',
			width:300,
			allowBlank: false,
            blankText: '名称不能为空！',
			fieldLabel:'名称'
		}/*,{
			xtype:'xaptextfield',
			name:'dCode',
			dataIndex : 'dCode',
			labelAlign : 'right',
			width: 300,
			fieldLabel:'自定义码'
		},{
			xtype:'xaptextfield',
			name:'extendCode1',
			dataIndex : 'extendCode1',
			labelAlign : 'right',
			width:300,
			fieldLabel:'扩展码1'
		},{
			xtype:'xaptextfield',
			name:'extendCode2',
			dataIndex : 'extendCode2',
			labelAlign : 'right',
			width:300,
			fieldLabel:'扩展码2'
		},{
			xtype:'xaptextfield',
			name:'extendCode3',
			dataIndex : 'extendCode3',
			labelAlign : 'right',
			width:300,
			fieldLabel:'扩展码3'
		}*/,{
			xtype : 'xaptextarea',
			fieldLabel : '备注',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			width: 500,
			name: 'memo',
			dataIndex : 'memo'
		}]
	}],
    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})