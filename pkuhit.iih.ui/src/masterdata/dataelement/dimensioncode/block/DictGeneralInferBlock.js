Ext.define('iih.masterdata.dataelement.dimensioncode.block.DictGeneralInferBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.dictgeneralinferblock',
	
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
			allowBlank: false,
            blankText: '编码不能为空！',
			enforceMaxLength:true,
			maxLength:20,
			maxLengthText:'编码最大长度不能超过20个字符！',
			fieldLabel:'编码'
			,readOnly:true
		},{
			xtype:'xaptextfield',
			name:'dataElementNm',
			labelAlign : 'right',
			width:300,
			allowBlank: false,
            blankText: '名称不能为空！',
			fieldLabel:'名称'
		}/*,{
			xtype: 'xapradiogroup',
			border: 1,
			fieldLabel : '关联标记',
			labelAlign : 'left',
			width:300, 
			dataIndex : 'extendFlag',
			method:'extendFlag',
			margin:'0 0 0 50',
			items: [
				{boxLabel: '关联', name: 'extendFlag',width:85, inputValue: '1'},
				{boxLabel: '不关联', name: 'extendFlag', width:85,inputValue: '0',checked: true}
			]
			},{
			xtype : 'xaptextfield',
			fieldLabel : '关联对象',
			labelWidth:100,
			colspan : 1,
			labelAlign : 'right',
			padding:'8 0 8 0',
			width: 300,
			name: 'extendDict',
			dataIndex : 'extendDict'
		},{
			xtype: 'xapradiogroup',
			border: 1,
			fieldLabel : '系统标记',
			labelAlign : 'left',
			width:300, 
			colspan : 2,
			dataIndex : 'systemFlag',
			method:'systemFlag',
			margin:'0 0 0 50',
			items: [
				{boxLabel: '系统', name: 'systemFlag',width:85, inputValue: '1'},
				{boxLabel: '非系统', name: 'systemFlag', width:85,inputValue: '0',checked: true}
			]
			},{
			xtype:'xaptextfield',
			labelAlign : 'right',
			colspan : 2,
			padding:'8 0 8 0',
			width: 400,
			fieldLabel:'自定义码',
			name: 'dCode',
			dataIndex : 'dCode'
				,visible:false
		}*/,{
			xtype : 'xaptextarea',
			fieldLabel : '描述',
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