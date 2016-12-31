Ext.define('iih.mr.dr.condition_set.block.ConditionSettingInferRightBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.conditionsettinginferrightblock',
	
	 /*buttons:[{
	        xtype: "button",
	        name: 'save',
	        method:'save',
	        text: '保存',
	        iconCls: 'icon-OK'
	    },{
	        xtype: "button",
	        name: 'cancel',
	        method:'cancel',
	        text: '取消',
	        iconCls: 'icon-cancel'
	    }],*/
	    
	items: [{
		xtype: 'xapform',
		name:'defectComplete',
		width:'100%',
		border: 0,
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
			xtype:'xapcombobox',
            labelWidth:90,
            labelAlign:'right',
            colspan : 2,
            width:200,
			margin:'0 180 0 10',
            name:'conditionType',
            readOnly:true,    
            comboData : [
                    {"value":"1", "name":""},
                    {"value":"2", "name":"简单条件"},
                    {"value":"3", "name":"组合条件"}
            ],
	        displayField: 'name',
			fieldLabel:'条件类型'
		},{
			xtype : 'xaptextarea',
			fieldLabel : '约束对象',
			labelWidth:100,
			colspan : 2,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:80,
			width: 300,
			name: 'constraintObject',
			dataIndex : 'constraintObject'
		},{
			xtype:'xapcombobox',
            labelWidth:100,
            labelAlign:'right',
            colspan : 2,
            width:200,
            name:'logicSymbolCode',
            editable: false,    
            comboData : [
                    {"value":"=", "name":"="},
                    {"value":">", "name":">"},
                    {"value":">=", "name":">="},
                    {"value":"<", "name":"<"},
                    {"value":"<=", "name":"<="},
                    {"value":"!=", "name":"!="},
                    {"value":"like", "name":"like"},
                    {"value":"in", "name":"in"}
            ],
	        displayField: 'name',
			fieldLabel:'逻辑关系'
		},{
			xtype : 'xaptextarea',
			fieldLabel : '约束值域',
			colspan : 2,
			labelWidth:100,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:80,
			width: 300,
			name: 'constraintDomain',
			dataIndex : 'constraintDomain'
		},{
			xtype:'xaptextfield',
			name:'elemPath',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'树节点路径',
			hidden:true
		},{
			xtype:'xaptextfield',
			name:'mrPk',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'文档主键',
			hidden:true
		},{
			xtype:'xaptextfield',
			name:'docType',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'文档类型编码',
			hidden:true
		}]
	}],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})