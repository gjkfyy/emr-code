Ext.define('iih.po.assistant.block.PersonKnowledgePropertyBlock',{
	extend : 'Xap.ej.block.FormBlock',

	requires: [
        'Xap.ej.element.field.TextArea',
        'Xap.ej.element.label.Label'
	],

	alias:'widget.personknowledgepropertyblock',

	layout:'vbox',
	border:0,
	
	items: [{
        xtype: 'xaplabel',
        text: '个人知识库内容:',
        width : 130,
        padding: '8 10 8 10'
    },{
		xtype: 'xaptextarea',
		readOnly:true,
		name:'fragmentTplContent',
		padding: '0 10 8 10',
		width:890,
		height : 207
	}],
	buttons:[{
        xtype: "button",
        name: 'create',
        method:'create',
        text: '新建'
    },{
        xtype: "button",
        name: 'delete',
        method:'delete',
        text: '删除'
    },{
        xtype: "button",
        name: 'edit',
        method:'edit',
        text: '编辑'    
    }],  
	setData: function(data) {
	    this.callParent(arguments);
	}
})