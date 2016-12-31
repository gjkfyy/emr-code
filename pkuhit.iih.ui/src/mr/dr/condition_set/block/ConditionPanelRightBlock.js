Ext.define('iih.mr.dr.condition_set.block.ConditionPanelRightBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [],
	
	alias:'widget.conditionpanelrightblock',

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
            colspan : 1,
            width:200,
			margin:'0 0 0 10',
            name:'relationType',
            comboData : [
                    {"value":"and", "name":"并且"},
                    {"value":"or", "name":"或者"}
            ],
	        displayField: 'name',
			fieldLabel:'关联类型'
		},{
			xtype:'xapcombobox',
            labelWidth:90,
            labelAlign:'right',
            colspan : 1,
            width:200,
			margin:'0 200 0 0',
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
			xtype:'xaptextfield',
			name:'conditionName',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'条件名称'
		},{
            xtype: "button",
            name: 'cancel',
            method:'cancel',
			margin:'0 0 0 45',
            text: '条件设置',
			colspan : 2,
			action: 'conditionInfer',
            width:'100'
   		},{
			xtype : 'xaptextarea',
			fieldLabel : '约束对象',
			labelWidth:100,
			colspan : 2,
			labelAlign : 'right',
			padding:'8 0 8 0',
			height:100,
			width: 450,
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
			height:100,
			width: 450,
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
		},{
			xtype:'xaptextfield',
			name:'grade',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'条件级次',
			value:'1',
			hidden:true
		},{
			xtype:'xaptextfield',
			name:'upcond',
			labelAlign : 'right',
			colspan : 2,
			width: 450,
			fieldLabel:'上级条件',
			value:'',
			hidden:true
		}]
	}],

    setData : function(data) {
    	if(data){
			this.getForm().setValues(data.formData); //给form表单赋值
    	}
    }
})