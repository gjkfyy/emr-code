Ext.define('iih.po.assistant.block.EditKnowledgeBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
		'Xap.ej.element.grid.FlowGrid',  
		'Xap.ej.element.grid.column.ActionColumn'
	],

	alias:'widget.editknowledgeblock',

	layout: {
        type: 'table',
        columns: 2
    },
	
	header:false,
	
	items:[{
	    	xtype:'xaptextfield',
	        name:'fragmentTplCd',
	        hidden:true
	    },{
    	xtype:'xapform',
    	border:0,
    	colspan:1,
    	width:300,
    	layout: 'hbox',
    	items:[{
	    	xtype:'xapcombobox',
	        name:'fragmentTplTypeCd',
	        padding:'10 0 10 10',
	        labelWidth:90,
	        editable:false,
	        labelAlign : 'right',
	        width:200,
	        fieldLabel:'类别',
	        displayField:'fragmentTplTypeNm',
            valueField:'fragmentTplTypeCd'
	    },{
	        xtype: "button",
	        name: 'edit',
	        method:'edit',
	        padding:'2 5 2 5',
            margin:'10 0 10 5',
	        text: '编辑类别'
	    }]
    },{
    	fieldLabel:'所属',
    	labelWidth:30,
	    labelAlign : 'left',
	    colspan:1,
    	xtype: 'xapradiogroup',
		method:'checkFlag',
		width:150,
		vertical: true,
		items: [
			{ boxLabel: '个人', name: 'ownerTypeCd', inputValue: 'MDM12.03',checked: true},
			{ boxLabel: '科室', name: 'ownerTypeCd', inputValue: 'MDM12.02'}
		]
    },{
    	xtype:'xaptextfield',
        name:'ownerCd',
        hidden:true
	},{
        xtype: 'xaptextfield',
        padding:'0 0 0 10',
        name:'fragmentTplNm',
        labelWidth:90,
        colspan: 2,
        width:400,
        fieldLabel:'名称',
        maxLength :66,
		maxLengthText : '输入内容过长，请重新输入！'
    },{
		xtype: 'xaptextarea',
		fieldLabel:'个人知识库内容',
		labelAlign : 'right',
		labelWidth:90,
		name:'fragmentTplContent',
		padding: '5 10 5 10',
		colspan: 2,
		width:560,
		height : 207,
		maxLength : 1333,
		maxLengthText : '输入内容过长，请重新输入！'
	}],   
    buttons:[{
        xtype: "button",
        name: 'save',
        method:'save',
        text: '保存'
    },{
        xtype: "button",
        name: 'close',
        method:'close',
        text: '关闭'    
    }],
	setData: function(data) {
		
	}
})